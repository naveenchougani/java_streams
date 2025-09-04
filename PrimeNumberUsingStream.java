import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {

          //IntStrean.rangeClosed(strat,end) will produce that many numbers
      
           List<Integer> primeUpto30 = IntStream.rangeClosed(1,30).filter(Main::isPrime).boxed().toList();

         primeUpto30.forEach(System.out::println);
    }

    public static boolean isPrime(int number)
    {
        if(number<=1){return false;}

      //none match produces true or false based on the provided condition
        return IntStream.rangeClosed(2,(int)Math.sqrt(number)).noneMatch(divisor->number%divisor==0);        
    }
}
