import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
     List<Integer> numbers = Arrays.asList(123, 456, 101, 789, 120, 132, 204);
     System.out.println("input -> "+numbers);

    // just convert Integer to String in filter with String.valueOf() or Integer.toString() method
     List<Integer> numbersStartsWith1 = numbers.stream()
                                               .filter(num->String.valueOf(num).startsWith("1"))
                                             //.filter(num->Integer.toString(num).startsWith("1"))
                                               .collect(Collectors.toList());
     System.out.println("Starts with 1 -> "+numbersStartsWith1) ;  
    
    }
}
