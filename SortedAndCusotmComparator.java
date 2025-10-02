// Comparator.reverseOrder() reversed the natural order of the Objects,
// that natural order of objects obtained by implementing Comparable Interface
// Hence the above method mostly works on the objects are of comparable types (String and Wrapper Objects)

//Integer Wrapper types

// Ascending order (default)
List<Integer> ascInt = intList.stream()
    .sorted()   // this empty sorted() method would invoke the compareTo() method of Integer would sort the elements naturally
    .collect(Collectors.toList());

// Descending order
List<Integer> descInt = intList.stream()
    .sorted(Comparator.reverseOrder())   // this reverses the natural ordering or the wrapper typess
    .collect(Collectors.toList());


//Double Wrapper types
// Ascending order (default)
List<Double> ascDouble = doubleList.stream()
    .sorted()
    .collect(Collectors.toList());

// Descending order
List<Double> descDouble = doubleList.stream()
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.toList());


// String type

// Ascending order (default)
List<String> ascString = stringList.stream()
    .sorted()
    .collect(Collectors.toList());

// Descending order
List<String> descString = stringList.stream()
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.toList());


// What if your custom objects have primitive types, then use the below thisng..

// For efficient performance
// Sorting by an int field (e.g., age)
list.stream()
    .sorted(Comparator.comparingInt(CustomObject::getIntField)) // Accepts a function returning a primitive type (e.g., int, double
                                                                //Provides a specialized comparator that works on primitive values directly,
                                                                // avoiding boxing/unboxing overhead.
                                                               //This is more efficient when dealing with primitives.
    .collect(Collectors.toList());

list.stream()
    .sorted(Comparator.comparingInt(CustomObject::getIntField).reversed()) // descending
    .collect(Collectors.toList());

// Sorting by a double field (e.g., score)
list.stream()
    .sorted(Comparator.comparingDouble(CustomObject::getDoubleField)) // ascending
    .collect(Collectors.toList());

list.stream()
    .sorted(Comparator.comparingDouble(CustomObject::getDoubleField).reversed()) // descending
    .collect(Collectors.toList());


// For general performance :

list.stream()
    .sorted(Comparator.comparing(CustomObject::getIntField)) // assuming getIntField() returns Integer (boxed))
    .collect(Collectors.toList());
list.stream()
    .sorted(Comparator.comparing(CustomObject::getIntField).reversed()) // assuming getIntField() returns Integer (boxed)
    .collect(Collectors.toList());
// If the field is a primitive (e.g., int), autoboxing happens: primitives are wrapped into their wrapper objects (int → Integer).
// this over head might cause the slowness than the above performance.
// but this apporach is more helpful the reusability.




