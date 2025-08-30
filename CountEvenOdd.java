import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

class CountEvenOdd {
    public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    // here mapToInt() method expects a function or method reference or lambda expression 
    // which would convert Object to Primitive type for efficient calculation  
    System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());
                     
    //Collectors.partioningBy() also same like Collectors.groupingBy
    //But partitioningBy always gives you map with true or false key values, 
    //partitioningBy uses predicate interface which outputs true of false values..  
    //DownStream collector method moslty we will use 
    //Collectors.summingInt(Integer::intValue) -> returns Integer (unbox required)
    //Collectors.averagingInt(Integer::intValue) -> return Double (unbox required)
    //Collectors.counting()  -> returns Long value and no need to unbox   
        
    // Collectors.summingInt(Integer::intValue) -> return Integer value and unbox required as computation required
    // Collectors.summingInt(primitive int) -> expects primitive int
    Map<Boolean,Integer> sumEvenOddParitioningBy = numbers.stream()
                                             .collect( 
                                                 Collectors.partitioningBy(
                                                                        n->n%2==0,
                                                                       Collectors.summingInt(Integer::intValue)
                                                                        )
                                                     );

     // Collectors.averagingInt(Integer::intValue) -> return Double value and unbox required as computation required  
    // Collectors.averagingInt(primitive int) -> expects primitive int
    Map<Boolean,Double> averageEvenOddParitioningBy = numbers.stream()
                                             .collect( 
                                                 Collectors.partitioningBy(
                                                                        n->n%2==0,
                                                                       Collectors.averagingInt(Integer::intValue)
                                                                        )
                                                     );

    //Collectors.counting() -> returns Long value and unbox not required
     Map<Boolean,Long> countEvenOddPartioningBy = numbers.stream()
                                              .collect(
                                                  Collectors.partitioningBy(
                                                                       n->n%2==0,
                                                                       Collectors.counting()
                                                                        ) 
                                                      );

     // Collectors.summingInt(Integer::intValue) -> return Integer value and unbox required as computation required
    // Collectors.summingInt(primitive int) -> expects primitive int
    Map<Boolean,Integer> sumEvenOddGroupingBy = numbers.stream()
                                             .collect( 
                                                 Collectors.groupingBy(
                                                                        n->n%2==0,
                                                                       Collectors.summingInt(Integer::intValue)
                                                                        )
                                                     );

     // Collectors.averagingInt(Integer::intValue) -> return Double value and unbox required as computation required  
    // Collectors.averagingInt(primitive int) -> expects primitive int
    Map<Boolean,Double> averageEvenOddGroupingBy = numbers.stream()
                                             .collect( 
                                                 Collectors.groupingBy(
                                                                        n->n%2==0,
                                                                       Collectors.averagingInt(Integer::intValue)
                                                                        )
                                                     );

      // As for int we have averagingDouble and summingDouble for collection of Double wrapper objects  
      List<Double> numbers = Arrays.asList(1.0, 2.5, 3.8,4.0);

    // Collectors.averagingDouble(Double::doubleValue) -> return Double value and unbox required as computation required  
    // Collectors.averagingDouble(primitive double) -> expects primitive double
        Map<Boolean,Double> averageDoubleEvenOddGroupingBy = numbers.stream()
                                             .collect( 
                                                 Collectors.groupingBy(
                                                                        n->n%2==0,
                                                                       Collectors.averagingDouble(Double::doubleValue)
                                                                        )
                                                     );        
        System.out.println(averageDoubleEvenOddGroupingBy);

        
    // Collectors.summingDouble(Double::doubleValue) -> return Double value and unbox required as computation required  
    // Collectors.summingDouble(primitive double) -> expects primitive double
        Map<Boolean,Double> sumDoubleEvenOddGroupingBy = numbers.stream()
                                             .collect( 
                                                 Collectors.groupingBy(
                                                                        n->n%2==0,
                                                                       Collectors.summingDouble(Double::doubleValue)
                                                                        )
                                                     );
        
        System.out.println(sumDoubleEvenOddGroupingBy);

    //Collectors.counting() -> returns Long value irrespe
     Map<Boolean,Long> countEvenOddGroupingBy = numbers.stream()
                                              .collect(
                                                  Collectors.groupingBy(
                                                                       n->n%2==0,
                                                                       Collectors.counting()
                                                                        ) 
                                                      );
        
    System.out.println(sumEvenOddParitioningBy+"\n"+
                      averageEvenOddParitioningBy+"\n"+
                      countEvenOddPartioningBy+"\n"+
                      sumEvenOddGroupingBy+"\n"+
                      averageEvenOddGroupingBy+"\n"+
                      countEvenOddGroupingBy);                       
                                    
    }
}
