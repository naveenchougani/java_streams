import java.util.stream.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        String str = "java class";
        char ch = 'a';

        String removed=str.replace(String.valueOf(ch),"");
        System.out.println(removed);
        
        // here chars() provides IntStream representation of char unicode
        // now to convert it into String which is an object can be used in collect method
        // first convert unicode int into char, then char to String using it valueOf method
        // mapToObj is used to convert primitives to Object
        String removedUsingStream = str.chars()
                                       .filter(charInt->charInt!=ch)
                                       .mapToObj(chi->String.valueOf((char)chi))
                                       .collect(Collectors.joining());
        System.out.println(removedUsingStream);

        // But this is slower when comparedTo mapToObj version i.e, above version
        String anotherWay= Stream.of(str.split(""))
                                  .filter(s->!(s.equals(String.valueOf(ch))))
                                  .collect(Collectors.joining());
        System.out.println(anotherWay);

        char charToReplacech='x';
        String replaceusingStream=str.chars()
                                     .mapToObj(charInt->charInt==ch?String.valueOf(charToReplacech)
                                                                 :String.valueOf((char)charInt))
                                     .collect(Collectors.joining());
        
        System.out.println(replaceusingStream);

        // using delimmeter in Collectors.joining(", ")-> this method always expects String Object
         String replaceusingStreamAndDelimitter=str.chars()
                                     .mapToObj(charInt->charInt==ch?String.valueOf(charToReplacech)
                                                                 :String.valueOf((char)charInt))
                                     .collect(Collectors.joining(", "));
        
        System.out.println(replaceusingStreamAndDelimitter);
      
    }
}
