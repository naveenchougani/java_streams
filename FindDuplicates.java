import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 3, 7, 8, 4);

        System.out.println("original array -> "+numbers);

        // ******* Remove Duplicate values with and without order********* //
        
        // distinct() method keeps first occurence of the element with original order, slower than toSet() method
        List<Integer> noDuplicatesWithOrder = numbers.stream()
                                                .distinct()
                                                .collect(Collectors.toList());
        System.out.println(noDuplicatesWithOrder);

        // Collectors.toSet() method does not guarantee order but faster than distnct() method
        Set<Integer> noDuplicateWithoutOrder = numbers.stream()
                                                  .collect(Collectors.toSet());
        System.out.println(noDuplicateWithoutOrder);

        // **** Get Duplicate number with order and without order ***** //
        //Get Duplicates with order ->  Using LinkedHashMap in grouping by to preserve order
        List<Integer> duplicateWithOrderUsingLinkedHashMap = numbers.stream()
                                                  .collect(Collectors.groupingBy(n->n,
                                                                                 LinkedHashMap::new,
                                                                                 Collectors.counting()))
                                                  .entrySet().stream()
                                                  .filter(e->e.getValue()>1)
                                                  .map(e->e.getKey())    // convert entry set to Integer value
                                                  .collect(Collectors.toList());
        System.out.println(duplicateWithOrderUsingLinkedHashMap);

        //Get Duplicates with out order ->  Using HashMap in grouping 
        List<Integer> duplicateWithoutOrderUsingMap = numbers.stream()
                                                  .collect(Collectors.groupingBy(n->n,
                                                                                 Collectors.counting()))
                                                  .entrySet().stream()
                                                  .filter(e->e.getValue()>1)
                                                  .map(e->e.getKey())    // convert entry set to Integer value
                                                  .collect(Collectors.toList());
        System.out.println(duplicateWithoutOrderUsingMap);

        //Get Duplicates with order using HashSet -> using HashSet to throw duplicates..
        Set<Integer> set1=new HashSet<>();
        List<Integer> duplicateWithOrderUsingHashSet= numbers.stream() // orderedflow
                                                             .filter(n->!set1.add(n)) // orderd flow of duplicates       
                                                             .distinct() // preserved encountered order           
                                                             .collect(Collectors.toList());
         System.out.println(duplicateWithOrderUsingHashSet);

        //Get Duplicates with order using LinkedHashSet 
        Set<Integer> set1=new HashSet<>();
        Set<Integer> duplicateWithOrderUsingLinkedHashSet= numbers.stream() // orderedflow
                                                             .filter(n->!set1.add(n)) // orderd flow of duplicates                  
                                                             .collect(Collectors.toCollection(LinkedHashSet::new)); 
                                                            // Collectors.toCollection(new collection instance required)
         System.out.println(duplicateWithOrderUsingLinkedHashSet);        
    }
}
