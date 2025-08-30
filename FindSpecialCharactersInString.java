import java.util.stream.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        String str = "Hello, World! 123 #Java$Stream";
        System.out.println("input-> "+str);

        // below method using Character.isLetterOrDigit() which takes Int unicode of a char also
        String specialCharactersUsingCharacterMethod = 
            str.chars()
               .filter(ch->!Character.isLetterOrDigit(ch))
               .mapToObj(ch->String.valueOf((char)ch))  // convert unicode of char to char to String in mapToObj
               .collect(Collectors.joining());
        System.out.println("Special Characters -> "+specialCharactersUsingCharacterMethod);

        // finding special character without Character class method
        String specialCharacters = str.chars()
                                      .filter(ch->    !(ch>='a'&& ch<='z')
                                                   && !(ch>='A' && ch<='Z')
                                                   && !(ch>='1' && ch<='9')
                                             )
                                      .mapToObj(ch->String.valueOf((char)ch))
                                      .collect(Collectors.joining());
        System.out.println("Special Character -> "+specialCharacters);
    }
}
