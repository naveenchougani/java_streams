import java.util.stream.Collectors;
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        List<Person> persons=List.of(new Person("John","Doe",25),
                                    new Person("Jane","Smith",30),
                                    new Person("Alice","Johnson",28)
                                        );
        //using findFirst()
        Optional<Person> op=persons.stream().sorted((p1,p2)->p2.getAge()-p1.getAge()).findFirst();
        op.ifPresent(n->System.out.println(n.getFname()));

        //using map direclty on optional
        String fname=op.map(Person::getFname).orElse("No Person");
        System.out.println(fname);

        //combining findfirst and map in a singleStream
        String oldp=persons.stream().sorted((p1,p2)->p2.getAge()-p1.getAge())
                            .findFirst().map(Person::getFname).orElse("No Employee");
        System.out.println(oldp);
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
