import java.util.stream.*;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        String input = "iindia";
        Optional<String> non=Stream.of(input.split(""))
                            .collect(Collectors.groupingBy(s->s,LinkedHashMap::new,Collectors.counting()))
                            .entrySet().stream().filter(e->e.getValue()==1).map(Map.Entry::getKey).findFirst();
        
        non.ifPresent(System.out::println);

        // another version
        String non=Stream.of(input.split(""))
                            .collect(Collectors.groupingBy(s->s,LinkedHashMap::new,Collectors.counting()))
                            .entrySet().stream().filter(e->e.getValue()==1).findFirst().map(Map.Entry::getKey).orElse("not found");
        
        System.out.println(non);
    }
}
