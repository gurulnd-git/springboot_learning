package com.example.test;

import org.apache.commons.io.*;
import java.io.File;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class Test {

    static String sStr;

    public void Test() {
        System.out.println("In C");
        sStr = "welcome";
    }

    public static void main(String[] args) {

     //   Test n = new Test();
     //   System.out.println(sStr);

        Integer max=Arrays.asList(7, 1, 2, 3, 6, 0, 3, 4,9).stream().max(Comparator.comparing(Integer::intValue)).get();

     //   Stream.iterate(0,n -> n+1).limit(10).forEach(System.out::println);
      //  isPalindrome();
      //  reverseArray();  //403 /401 access
      //  sortById();
       // findEvenAndSum();
        //anagramCheck();
       // findDuplicateCharInString();
       // findOccurrences();
        //isEven();
        //factorial( 10);
       // fibannoci();
       // primeNum(Arrays.asList(112,4,6,7,2,56,3,23,77,43,21));
        //randomNumGen();
        System.out.println(longestPalindromicSubstringRecursion("zzabcbai"));
      //  longestPanlindromeNumber
      //  removeDuplicatesEmpList();
        //findDupicatesinalist()
        //FindVowels()
        //compareTwoArrays()
        //subsetCheck()

    }

    public static void subSetCheck() {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};

        boolean isSubset = Arrays.stream(arr2)
                .allMatch(num -> Arrays.stream(arr1)
                        .anyMatch(n -> n == num));
        if (isSubset) {

            System.out.println("arr2 is a subset of arr1");
        } else {
            System.out.println("arr2 is not a subset of arr1");
        }

        // or

        if (isSubset(arr1, arr2)) {
            System.out.println("arr2 is a subset of arr1");
        } else {
            System.out.println("arr2 is not a subset of arr1");
        }
    }

    private static boolean isSubset(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            if (!set.contains(num)) {
                return false;
            }
        }
        return true;
    }



    public static void findSubsetofArray() {
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = findSubsets(arr);
        System.out.println(subsets);
    }

    public static List<List<Integer>> findSubsets(int[] nums) {
        return IntStream.range(0, 1 << nums.length)
                .mapToObj(i -> IntStream.range(0, nums.length)
                        .filter(j -> (i & (1 << j)) != 0)
                        .mapToObj(j -> nums[j])
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        //or

//        List<List<Integer>> subsets = new ArrayList<>();
//        backtrack(subsets, new ArrayList<>(), nums, 0);
//        return subsets;
    }

    private static void backtrack(List<List<Integer>> subsets, List<Integer> tempList, int[] nums, int start) {
        subsets.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(subsets, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static void compareTwoArrays() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};

        boolean areEqual = Arrays.equals(array1, array2);
        System.out.println("Arrays are equal: " + areEqual);

        int result = Arrays.compare(array1, array2);
        System.out.println("Comparison result: " + result);

        Integer[][] array3 = {{1, 2, 3}, {4, 5, 6}};
        Integer[][] array4 = {{1, 2, 3}, {4, 5, 6}};

         areEqual = Arrays.deepEquals(array3, array4);
        System.out.println("Arrays are equal: " + areEqual);

    }
    public static void FindVowels() {
        String str = "Hello World";
        List<Character> vowels = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1)
                .collect(Collectors.toList());
        System.out.println(vowels); // Output: [e, o, o]

        //counting

        long count = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1)
                .count();
        System.out.println("Number of vowels: " + count);
    }

    public static void findDuplicatesInaList() {

        // Arrays.stream(array)


        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 4, 5);
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = list.stream()
                .filter(n -> !set.add(n))
                .collect(Collectors.toList());
        System.out.println(duplicates);

        //frequency
        List<Integer> duplicates1 = list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .distinct()
                .collect(Collectors.toList());

        //groupingby
        List<Integer> duplicates2 = list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static String longestPalindromicSubstringRecursion(String str) {
//        if (isPalindrome(str)) {
//            return(str);
//        }
//        int n = str.length();
//        int max = 1, start = 0;
//
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = i; j < str.length(); j++) {
//                boolean flag = true;
//
//                for (int k = 0; k < (j - i + 1) / 2; k++)
//                    if (str.charAt(i + k) != str.charAt(j - k))
//                        flag = false;
//                if (flag && (j - i + 1) > max) {
//                    start = i;
//                    max = j - i + 1;
//                }
//            }
//        }
//
//        System.out.println(str.substring(start,start+max));

        if (str.equals(new StringBuilder(str).reverse().toString())) {
            return str;
        }
        String left = longestPalindromicSubstringRecursion(str.substring(1));
        String right = longestPalindromicSubstringRecursion(str.substring(0, str.length() - 1));

        if (left.length() > right.length()) {
            return left;
        } else {
            return right;
        }

    }

    private static void removeDuplicatesEmpList() {
        List<Employee> employeeList = Stream.of(
                new Employee("Vivek","545","Rf"),
                new Employee("Sardar","453","Ed"),
                new Employee("Vivek","545","Rf"),
                new Employee("Aamir","655","Ed"),
                new Employee("Sardar","453","Ed")
        ).collect(Collectors.toList());
       // employeeList.forEach(System.out::println);

        Set<String> nameSet = new HashSet<>();
        List<Employee> employeesDistinctByName = employeeList.stream()
                .filter(e -> nameSet.add(e.getName()))
                .collect(Collectors.toList());

        //need to override equals
        List<Employee> employeesDistinctByName1 = employeeList.stream().distinct()
                .collect(Collectors.toList());
        Set<Employee> employeesDistinctByName01 = employeeList.stream()
                .collect(Collectors.toSet());

        List<Employee> employeesDistinctByName2 = employeeList.stream()
                .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(Employee::getEmpId))),
                        ArrayList::new));

        List<Employee> employeesDistinctByName3 = employeeList.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(c -> Arrays.asList(c.getName(), c.getName()),
                                Function.identity(), (a,b) -> a, LinkedHashMap::new),
                        m -> new ArrayList<>(m.values())));

        employeesDistinctByName01.forEach(System.out::println);

    }

    private static void randomNumGen() {
       new Random().ints(00105,99999).limit(1).boxed().forEach(System.out::println);

        String pageReferenceString = Stream
                .generate(() -> String.valueOf(new Random().nextInt(9)))
                .limit(5)
                .collect(Collectors.joining());

       ThreadLocalRandom.current().ints(00105,99999)
                .limit(1).boxed().forEach(System.out::println);

        String st = new java.math.BigInteger(7,new Random()).toString().substring(0,5);

        System.out.println(st);
    }

    private static void fibannoci() {
        int lastvalue =0;int count =  0;
//        for(int i=0;i<10;i++) {
//            int temp = lastvalue;
//            System.out.println(count);
//            lastvalue = count + lastvalue;
//            count = temp;
//        }

        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0]+n[1]}).limit(10)
                .map(n->n[0]).forEach(System.out::println);
    }

    private static void primeNum(List <Integer> list) {
        List<Integer> intList = list.stream()
                .filter(i -> BigInteger.valueOf(i).isProbablePrime(1))
                .collect(Collectors.toList());

        intList.forEach(System.out::println);
    }

    private static void factorial(int n) {

        Long res = LongStream.rangeClosed(1, n).map(operand -> {
            System.out.println(operand);
            return operand;
        }).reduce(1, (long a, long b) -> a * b);

        System.out.println(res);
    }

    private static void isEven() {
        IntStream.range(0, 100).filter(value -> value%2 ==0).forEach(System.out::println);

    }

    private static void findOccurrences() {

        String word = "bannanas";
        char search = 'n';
    //To get List of indexes:
        List<Integer> indexes = IntStream.range(0, word.length())
                .filter(i -> word.charAt(i) == search).boxed()
                .collect(Collectors.toList());
    //To get array of indexes:
        int[] indexes1 = IntStream.range(0, word.length())
                .filter(i -> word.charAt(i) == search).toArray();

        indexes.forEach(System.out::println);
        System.out.println("___");
        Arrays.stream(indexes1).forEach(System.out::println);
    }

    public static void findEvenAndSum() {
       int[] intArray = {7, 1, 2, 3, 6, 0, 3, 4,9};
       int res = IntStream.range(0, intArray.length)
                .filter(i -> i%2==0).reduce(0,Integer::sum);
        System.out.println(res);

    }

    public static String reverseString(String string) {

        char[] charArray = "Aniruddh1".toCharArray();
        IntStream.range(0, charArray.length)
                .mapToObj(i -> charArray[(charArray.length - 1) - i])
                .forEach(System.out::println);


        return Stream.of(string)
                .map(word->new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
    }

    public static Map<String, Long> findDuplicateCharInString () {
       Map<String, Long> dataMap = ("malayalam").chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

       dataMap.entrySet().forEach(System.out::println);

       Optional<Map.Entry<String, Long>> maxString = dataMap.entrySet().stream()
               .max(Comparator.comparing(Map.Entry::getValue));
      //  Map.Entry.comparingByValue()
       System.out.println(maxString.get().getKey());

        dataMap.entrySet().forEach(stringLongEntry -> {
            if(stringLongEntry.getValue() > 1 ) {
                System.out.println(stringLongEntry.getKey()+" - Duplicate");
            } else {
                System.out.println(stringLongEntry.getKey()+" - Not a Duplicate");
            }
        });


       return dataMap;
    }

    public static boolean anagramCheck () {

        String[] anagram = {"listen", "silent"};
        int v = anagram[0].toLowerCase().chars().reduce((i, j) -> i + j).getAsInt()
                - anagram[1].toLowerCase().chars().reduce((i, j) -> i + j).getAsInt();
        System.out.println(v);
        return v==0;
    }

    public static void sortByCharCount () {
        String str = "aaamkkamooox";
        //xkkmmoooaaaa


    }

    public static void sortById () {

            List<Employee> employeeList = Stream.of(
                    new Employee("Sardar","453","Ed"),
                    new Employee("Vivek","545","Rf"),
                    new Employee("Aamir","655","Ed")
            ).collect(Collectors.toList());

            employeeList.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                    .forEach(System.out::println);
            //replaced with
            employeeList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

            employeeList.stream().map(Employee::getName).sorted((o1, o2) -> o1.compareTo(o2))
                    .forEach(System.out::println);

    }

    public static void predicateExample () {
        // contains substring

        String checkS = "rotator";
        Predicate<String> predicate = str -> checkS.contains(str);
        System.out.println(predicate.test("tat"));
    }

    public static boolean isPalindrome (String s) {
        String checkS = "rotator";
        if(s != null) {
            checkS = s;
        }

        String finalCheckS = checkS;
        Predicate predicate = str -> {
            finalCheckS.replaceAll("\\s", "").toLowerCase();
            return finalCheckS.equals(new StringBuilder().reverse().toString());
        };
       return predicate.test("rotator");
    }

    public static void reverseArrayWithoutConvertingToCollection() {
       List<Integer> arr = Arrays.asList(9,8,7,6,5,4,3,2,1);
        List<List<Integer>> op = Arrays.asList(Arrays.asList(0,3),Arrays.asList(4,5),Arrays.asList(3,6));

      String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};


      for(List arer:op) {
          int startindex = (int) arer.get(0);
          int endindex = (int) arer.get(1);
          List<Integer> firstList = new ArrayList<>();
          List<Integer> revList = new ArrayList<>();
          List<Integer> lastList = new ArrayList<>();
//          for(int i=endindex;i<=startindex;i--) {
//              firstList.add(arr.get(i));
//          }
          for(int i=0;i<startindex;i++) {
              firstList.add(arr.get(i));
          }
          for(int i=startindex;i<endindex;i++) {
              revList.add(arr.get(i));
          }
          Collections.reverse(revList);
          firstList.addAll(revList);
          for(int i=endindex;i<arr.size();i++) {
              lastList.add(arr.get(i));
          }
          firstList.addAll(lastList);

         // firstList.forEach(System.out::print);
          System.out.println(' ');
      }

        // array to a stream
        Stream<String[]> stream1 = Arrays.stream(array);
        // same result
        Stream<String[]> stream2 = Stream.of(array);

        List<String> collect = Stream.of(array)     // Stream<String[]>
                .flatMap(Stream::of)                // Stream<String>
                .filter(x -> !"a".equals(x))        // filter out the a
                .collect(Collectors.toList());      // return a List
//----- starts
        op.stream().flatMap(Stream::of).forEach(integer -> {
            System.out.println(' ');
          //  System.out.println(integer.get(0)+" "+integer.get(1));
            List<Integer> finalList = new ArrayList<>();
            System.out.print(integer.get(0));
            System.out.println(integer.get(1));
            List<Integer> tempList = new ArrayList<>();

         //   System.out.print(arr.get(integer.get(0)));
         //   System.out.println(arr.get(integer.get(1)));

            for(int i=0;i<integer.get(0);i++){
                finalList.add(arr.get(i));
            }
            for(int i=integer.get(0);i<integer.get(1);i++){
                tempList.add(arr.get(i));
            }
            Collections.reverse(tempList);
            finalList.addAll(tempList);
            for(int i=integer.get(1);i<arr.size();i++){
                finalList.add(arr.get(i));
            }
            finalList.forEach(System.out::print);
        });




    }





    public static void eElse (String string) {
        Employee employee = new Employee();
        System.out.println(employee.toString());

        List<Employee> employeeList = Stream.of(
                new Employee("Sardar","453","Ed"),
                new Employee("Vivek","545","Rf"),
                new Employee("Aamir","655","Ed")
        ).collect(Collectors.toList());

        employeeList.forEach(System.out::println);

        Map<String,Employee> collect1 = employeeList.stream().collect(Collectors.toMap(Employee::getEmpId, e -> e));
        System.out.println("1");
        collect1.forEach((o, o2) -> System.out.println(o2.getName()));
        collect1 = employeeList.stream().collect(Collectors.toMap(Employee::getEmpId, Function.identity(),(o1, o2)-> o2));
        System.out.println("2");
        collect1.forEach((o, o2) -> System.out.println(o2.getName()));
        collect1 = employeeList.stream().collect(Collectors.toMap(Employee::getEmpId, Function.identity(),(o1,o2)-> o1, LinkedHashMap::new));
        System.out.println("3");
        collect1.forEach((o, o2) -> System.out.println(o2.getName()));

        Predicate<Employee> transactionFilter = p ->  p.getName().equals("Vivek");
//        employeeList.stream().forEach(System.out::println);
//                employeeList.stream().forEach(e->  {
//                    if(transactionFilter.test(e)) e.setLocation("BLr");
//                });

        employeeList.stream().filter(p ->  p.getName().equals("Vivek")).forEach(employee1 -> employee1.setLocation("BRL"));

        employeeList.stream().filter(p ->  p.getName().equals("Vivek")).map(employee1 -> {
            employee1.setLocation("BRL");
            return employee1;
        }).collect(Collectors.toList());

        employeeList.stream().forEach(System.out::println);
        File res = new File("\\\\GP-LP\\New folder");
        res.isDirectory();
        System.out.println(res.isDirectory());

        Collection<File> files = FileUtils.listFiles(res,new String[]{"xlsx"},false);
        System.out.println(files.size());
        files.forEach(file -> {
            System.out.println(file.getName());
        });

        String ss = "@r =0, @rt= 4, @ty = 24234 234";
        List<String> ert = Stream.of(ss.split(",")).collect(Collectors.toList());
        // String[] nt = Arrays.stream(ss.split(",")).map(s -> s.replace("@","")).toArray(String[]::new);
        ert.stream().map(o -> o.substring(o.indexOf("=")+1)).toArray(String[]::new);
        // Arrays.stream(ss.split(",")).map(ss.substring(0,ss.indexOf("="));
        System.out.println("---");
        //  Arrays.stream(nt).forEach(System.out:a:println);
        System.out.println("----------");
        //  System.out.println(nt[0]);
        Stream.of(ss.split(",")).map(s -> s.replace("@","")).forEach(System.out::println);
        //   Predicate transactionFilter = p -> Status.INITIATED.toString().equals(p.getStatus())||Status.VALIDATED.toString().equals(p.getStatus()))&&p.getTimeStamp()<startKey);
//        transactionList.stream().forEach(e->  {
//            if(transactionFilter.test(e))  e.setStatus(Status.EXPIRED.toString());
//        });


//        transactionList.stream()
//                .forEach(e->  {
//            if(transactionFilter.test(e))  e.setStatus(Status.EXPIRED.toString());
//        });

        List transactionList = new ArrayList();

//        Predicate transactionFilter = p -> Status.INITIATED.toString().equals(p.getStatus())||Status.VALIDATED.toString().equals(p.getStatus()))&&p.getTimeStamp()<startKey);
//
//        transactionList.stream()
//                .filter(transactionFilter).forEach(a->{
//                        a.setStatus(Status.EXPIRED.toString());
//                });
//
//        transactionList.stream()
//                .filter(x -> isAdultMale.test(x.getAge(), x.getGender()))
//                .toList();
//
//        if(isNullOrEmty.test(transactionList){
//            transactionList.stream().forEach(a->{
//                if((a.setStatus(Status.EXPIRED.toString()):
//            });

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6,2);
        int result = numbers
                .stream()
                .reduce(1, (subtotal, element) -> Integer.sum(subtotal,element));
        System.out.println("result : "+ result);
        result = numbers
                .stream()
                .reduce(1, (subtotal, element) -> subtotal+element);

        System.out.println("result 1 : "+ result);
        result = numbers.stream().reduce(0, Integer::sum);
        System.out.println("result 2 : "+ result);
        System.out.println(reverseString("Anirudh"));
    }


}
