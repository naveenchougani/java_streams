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

        // updated verions and easier to understand
        List<String> sentense = sentences.stream()
            .flatMap(gpw->Arrays.stream(gpw.split(" ")))
            .distinct()
            .toList();
                    
        System.out.println(uniqueListOfString);


        /* Real example of flatMap
        record Employee(String name, String role, int salary) {}
        record Department(String deptName, List<Employee> employees) {}
        record DeptEmployeeDTO(String deptName, String employeeName, int salary) {}

        Map<String, List<DeptEmployeeDTO>> byRole = departments.stream()
                                                               .flatMap(dept -> dept.employees().stream()
                                                                    .filter(emp -> emp.salary() > 100_000)
                                                                    .map(emp -> Map.entry(
                                                                                        emp.role(),
                                                                                        new DeptEmployeeDTO(dept.deptName(), emp.name(), emp.salary())
                                                                                        ))
                                                                    )
                                                            .collect(Collectors.groupingBy(
                                                Map.Entry::getKey,
                                                Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                                                ));
        */
    }
}
