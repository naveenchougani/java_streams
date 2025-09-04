import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
            // one way it using IntStream.rangeClosed or IntStream.range()
           int squaresOfInt = IntStream.rangeClosed(1,5).map(n->n*n).sum();

        
        List<Integer> list = List.of(1,2,3,4,5);

        // another way to work with List<Integer> to Stream<Integer> to IntStream
        int sumofSquares = list.stream().mapToInt(n->n*n).sum();

        //another way
        int sumSquares = list.stream().map(n->n*n).collect(Collectors.summingInt(Integer::intValue));

           System.out.println(squaresOfInt+"\n"+sumofSquares+"\n"+sumSquares);
    }

}
