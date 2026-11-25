import java.util.stream.Collectors;
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        List<Person> persons = List.of(
            new Person("John", "Doe", 25),
            new Person("bob", "Aoes", 30),
            new Person("Alice", "Johnson", 28),
            new Person("Bob", "smith", 30),
            new Person("Jane", "zoe", 29) // Note: lowercase first name for testing
        );
// now when you sort based on age in higher age...
// "bob"(30 age) , "BOB"(30 age) are having same age...
// as Sorted uses stable sort which preserves the original order in case of same matching criteria..
// "bob" first, "BOB" second.. hence findFirst would pickup "bob"
// very good point to remember.        

        // sorted(Comparator.comparingInt/Doubl/Long().order().thenComparing())
        // here comparingInt.. will works with primitive Types.
        // thenComparing helps with Just sting value and inherenlty uses compareTo
        // String are always sorted in ascending order lexicographically
        String oldPersonLastName = persons.stream()
                                    .sorted(
                                        Comparator.comparingInt(Person::getAge).reversed()
                                       .thenComparing(p->p.getFname().toLowerCase())
                                       .thenComparing(p->p.getlname().toLowerCase(),Comparator.reverseOrder()) // prefer this
                                    ).findFirst().map(Person::getlname).orElse("No Employee");
        System.out.println(oldPersonLastName);

        // ** reversed() would work on an instance of comparator such as Comparator.comparingInt(or)comparingInt
        // thenComparing is not creating an instance, instead it works on prior instance , 
        //the below is how you can work upon like providde reverseOrder for thenComparing, on any instance .
         String oldPersonLastNameDesc = persons.stream()
                                    .sorted(
                                        Comparator.comparingInt(Person::getAge).reversed()
                                       .thenComparing(Comparator.comparing(p->p.getFname().toLowerCase(),Comparator.reverseOrder()))
                                       .thenComparing(Comparator.comparing(Person::getlname,Comparator.reverseOrder()))
                                    ).findFirst().map(Person::getlname).orElse("No Employee");
        System.out.println(oldPersonLastNameDesc);


        //another point to remember
      //  Comparator.comparingInt(Person::getAge).reversed()
      //    .thenComparing(Person::getFname)
      //    .reversed(); // Flips BOTH age AND fname!
    //Because .reversed() applies to the whole combined comparator returned by .thenComparing(...):
        
    }
}
class Person{
    String fname;
    String lname;
    int age;
    public Person(String fname, String lname,int age)
    {
            this.fname=fname;
            this.lname=lname;
            this.age=age;
    }
    public int getAge(){return age;}
    public String getlname(){return lname;}
    public String getFname(){return fname;}
    
}
