package lambdas;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseCasesMain {
    public static void main(String[] args) {
        // 1. Find the longest string in a list of strings
        List<String> strList = new ArrayList<>();
        strList.add("you");
        strList.add("are");
        strList.add("brilliant");
        strList.add("and");
        strList.add("talented");
        Optional<String> longest = strList.stream().max(Comparator.comparingInt(String::length));
        System.out.println(longest.get());

        // 2. Calculate the average age of a list of Person objects
        Person anitha = new Person("Anitha", 39);
        Person madhan = new Person("Madhan", 47);
        List<Person> personList = new ArrayList<>();
        personList.add(anitha);
        personList.add(madhan);

        double result = personList.stream().mapToInt(Person::age).average().orElse(0);
        System.out.println(result);

        // 3. Check if a list of integers contains a prime number
        /*Base Cases: It efficiently handles numbers less than or equal to 1 (not prime) and the special case of 2 (the only even prime).
        Eliminate Even Numbers: Immediately returns false for any even number greater than 2, significantly reducing checks.
        Square Root Optimization: The core optimization is checking divisors only up to the square root of n (i * i <= n).
        If a number n has a divisor greater than its square root, it must also have a corresponding divisor smaller than its square root.
        Therefore, checking up to the square root is sufficient.
                Increment by 2: The loop increments i by 2 (i += 2) because we only need to check odd divisors after handling the case of 2.*/
        List<Integer> numbers = Arrays.asList(4,6,8,10,11);
        Predicate<Integer> isPrime = UseCasesMain::isPrime;
        boolean hasPrime = numbers.stream().noneMatch(UseCasesMain::isPrime);
        System.out.println("Has Prime ?" + hasPrime);

        // 4. Merge two sorted lists into a single sorted list using java streams
        List<Integer> numbers1 = Arrays.asList(1,3,5,7);
        List<Integer> numbers2 = Arrays.asList(8,6,4,2);
        List<Integer> mergedSorted = Stream.concat(numbers1.stream(), numbers2.stream()).sorted().toList();
        System.out.println(mergedSorted);

        // 5. Find the intersection of two lists using Java streams
        List<Integer> numbers3 = Arrays.asList(1,3,5,2);
        List<Integer> numbers4 = Arrays.asList(8,5,4,2);
        List<Integer> intersection = numbers3.stream().filter(numbers4::contains).toList();
        System.out.println(intersection);

        // 6. Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> numbers5 = Arrays.asList(1,3,5,3,2);
        System.out.println(numbers5.stream().distinct().toList());

        // 7. Given a list of transactions, find the sum of transaction amounts for each day using Java streams:
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );
        Map<String, Integer> map = transactions.stream().collect(Collectors.groupingBy(Transaction::date, Collectors.summingInt(Transaction::amount)));
        System.out.println(map);

        // 8. Find the kth smallest element in an array using Java streams:
        int[] array = {4,2,5,8,1};
        int k = 3;
        int kSmall = Arrays.stream(array).sorted().skip(k-1).findFirst().orElse(-1);
        System.out.println("Kth smallest element -> " + kSmall);

        // 9. Q. Given a list of strings, find the frequency of each word using Java streams:
        List<String> strings = List.of("abc", "xyz", "abc", "qwe");
        Map<String, Long> strFreq = strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(strFreq);

        // 10. Implement a method to partition a list into two groups based on a predicate using Java streams:
        List<Integer> nums = List.of(3,24,56,7,1,5,9);
        Predicate<Integer> even = x -> x % 2 == 0;
        Predicate<Integer> odd = x -> x % 2 != 0;
        List<Integer> evenNums = nums.stream().filter(even).toList();
        Map<Boolean, List<Integer>> maaap= nums.stream().collect(Collectors.partitioningBy(even));
        List<Integer> oddNums = nums.stream().filter(odd).toList();
        System.out.println(evenNums);
        System.out.println(oddNums);
        System.out.println(maaap.get(true));
        System.out.println(maaap.get(false));

    }

    public static boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }
        if(n ==2)
            return true;
        if(n %2 ==0)
            return false;
        for(int i = 3; i * i <=n; i +=2){
            if(n%3==0) return false;
        }
        return true;
    }
}
