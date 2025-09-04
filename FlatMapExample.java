import java.util.stream.Collectors;
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
            List<String> sentences = Arrays.asList(
                "Java 8 introduced streams",
                "Streams are powerful",
                "Use Streams to process data"
            );

        Set<String> uniqueListOfString = sentences.stream().map(sen->sen.split(" "))//creates array of Strings
                                        .flatMap(arr->Arrays.stream(arr)) // flatmap converst all arrays into single stream
                                        .collect(Collectors.toSet());
        System.out.println(uniqueListOfString);
        
    }
}
