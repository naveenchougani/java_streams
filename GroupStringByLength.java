import java.util.stream.*;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "melon", "pear", "plum");
       
        Map<Integer,List<String>> strLen=strings.stream()
                                                 .collect(Collectors.groupingBy(n->n.length()));
                                                 
        Map<Integer,List<String>> strLenDes=strings.stream()
                                                 .collect(Collectors.groupingBy(n->n.length()))
                                                 .entrySet().stream().sorted((e1,e2)->e2.getKey()-e1.getKey())
                                                 .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
                                                                          (o,n)->o,LinkedHashMap::new));
        System.out.println(strLen+"\n"+strLenDes);
    }
}
