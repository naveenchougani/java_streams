import java.util.stream.Collectors;
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        List<Integer> numbers=Arrays.asList(5,10,25,20,29);
       
        Double averageWithInteger = numbers.stream().filter(n->n>10).collect(Collectors.averagingInt(n->n));
      
        double averageWithInt = numbers.stream().filter(n->n>10).mapToInt(num->num).average().orElse(0);
        
        System.out.println(averageWithInteger+"\n"+averageWithInt);
    }
}
