import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 9,2, 3, 4, 5, 2, 6, 3, 7, 8, 4);
        
        Set<Integer> set=new HashSet<>();
        List<Integer> dupElements= numbers.stream().filter(num->!set.add(num)).collect(Collectors.toList());
      
        List<Integer> dupElements1= numbers.stream().collect(
                                    Collectors.groupingBy(n->n,Collectors.counting())
                                                            ).entrySet().stream().filter(e->e.getValue()>1)
                                                             .map(e->e.getKey()).toList();
        
        // To convert map to again map using streams, Collectors.toMap is the most suitable one
        Map<Integer,Long> sortedMap= numbers.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()))
                                            .entrySet().stream().sorted((e2,e1)->e1.getKey()-e2.getKey())
                                            .collect(Collectors.toMap(e->e.getKey(),e->e.getValue(),(e,o)->e,LinkedHashMap::new));
        
        
        System.out.println(dupElements1+" "+dupElements+"\n"+sortedMap);
    }
}
