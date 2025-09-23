// Assuming having a employee map

// this one sorts the hashmap based on the key and in descending order using custom comparator
Map<String,Integer> sortedByKey = empMap.stream().sorted (
                                                          (entry1, entry2) -> entry2.getKey().compareTo(entry1.getKey())   // key is string and reversing entry makes them sorted
                                                        )
                                                  .collect (
                                                        Collectors.toMap (
                                                          Map.Entry::getKey,
                                                          Map.Entry::getValue,
                                                          (o,n)->n,
                                                          LinkedHashMap::new
                                                          )
                                                  )
  // using default methods, this works only if key or value are of comparable types only i.e, for all Wrapper objects below one works
  Map<String,Integer> sortedByKey = empMap.stream().sorted (
  
                                                          Map.Entry.comparingByKey()   // sorts by key in ascending order
                                                          Map.Entry.comparingByKey(Comparator.reverseOrder()) // sorts by key in descending order
  
                                                         Map.Entry.comparingByValue()   // sorts by value in ascending order
                                                         Map.Entry.comparingByValue(Comparator.reverseOrder()) // sorts by valye in descending order
                                                      
                                                        )
                                                  .collect (
                                                        Collectors.toMap (
                                                          Map.Entry::getKey,
                                                          Map.Entry::getValue,
                                                          (o,n)->n,
                                                          LinkedHashMap::new
                                                          )
                                                  )
  
                                                      
