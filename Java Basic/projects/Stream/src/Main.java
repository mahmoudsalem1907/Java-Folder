import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);

        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

        List<Student> students = Arrays.asList(
                new Student("Ali", "IT", 85),
                new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45),
                new Student("Laila", "IS", 78)
        );

        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );


        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("Java", "Stream"),
                Arrays.asList("API", "Lambda"),
                Arrays.asList("FlatMap", "Map")
        );


//        pls apply next
//        🔹 Basic Stream Operations
//        Filter even numbers from a list of integers.  **
//        Find names starting with a specific letter from a list of strings.  ** a
//        Convert all strings to uppercase using stream.  **
//        Sort a list of integers in descending order using streams.  **
//        Remove duplicate elements from a list using distinct().  **

        List<Integer> integers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(numbers);
        System.out.println(numbers);
        System.out.println("/////////////////////////////////////////////");
        System.out.println(integers);

        List<String> words = names.stream()
                .filter(name -> name != null && !name.isEmpty())
                .filter(name -> name.contains("A"))
//                .filter(name -> name.toLowerCase().startsWith("a"))
                .map(name -> name.toUpperCase())
                .distinct()
                .sorted()
                .toList();
        System.out.println(words);




//      🔹 Intermediate Stream Tasks
//       1.Count the number of strings longer than 5 characters. **
//       2.Find the first element in a stream that matches a given condition.
//       3.Check if any number is divisible by 5 in a list.  **
//       4.Collect elements into a Set instead of a List.  **
//       5.Skip the first 3 elements and return the rest. **


        System.out.println("/////////////////////////////////////////////");
        System.out.println(names);

//1
        List<String> intermediateString = names.stream()
                .filter(name -> name != null && !name.isEmpty() &&  name.length() > 5)
                .collect(Collectors.toList());
        System.out.println(intermediateString);

//5
        List<String> intermediateString1 = names.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(intermediateString1);

//2
        List<String> intermediateString3 = names.stream()
                .filter(name -> name != null && !name.isEmpty() && name.contains("Sara") )
                .collect(Collectors.toList());
        System.out.println(intermediateString3);
// 3 ,4
        Set<Integer> intermediateNumber = numbers.stream()
                .filter( number -> number % 5 == 0 && number > 0)
//                .distinct().sorted()
                .collect(Collectors.toSet());

        System.out.println(intermediateNumber);









//        🔹 Numeric Streams & Reductions
//        1.Calculate the sum of a list of integers using reduce.  **
//        2.Find the maximum and minimum value in a list. **
//        3.Calculate the average of a list of doubles.
//        4.Multiply all integers in a list together using reduce. **
//        5.Count how many numbers are positive in a list. **

//1
        int sum = numbers.stream().mapToInt(number -> number).sum();
        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println(sum2);

//2
        int mmax = numbers.stream().max(Integer::compareTo).get();
        System.out.println("max: " + mmax);
//2
        int mmin = numbers.stream().min(Integer::compareTo).get();
        System.out.println("min: " + mmin);

//4
        int multiple = numbers.stream().filter(name -> name != 0).reduce(1, (a,b) -> a*b);
        System.out.println("multiple: " + multiple);
//4
        int avr = numbers.stream().reduce(names.size(), (a,b) -> a*b);
        System.out.println("avr: " + avr);

//5

        Long count = numbers.stream().filter(name -> name > 0).count();
        System.out.println("count: " + count);


    }
}