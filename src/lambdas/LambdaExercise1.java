package lambdas;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExercise1 {
    public static void main(String[] args) {
        // 1. Find the longest string in a list of strings
        List<String> strings = List.of("ani", "vikunth", "saddhu");
        Optional<String> max = strings.stream().max(Comparator.comparingInt(String::length));
        System.out.println(max.get());

        // 2. Calculate the average age of a list of Person objects
        List<Person> persons = List.of(new Person("ani", 4), new Person("vik", 15));
        double avgAge = persons.stream().mapToInt(Person::age).average().orElse(0);
        System.out.println(avgAge);

        // 3. Check if a list of integers contains a prime number
        List<Integer> primeContestants = List.of(4,6,8,9,15,25,36,37,68);
        Predicate<Integer> predicate = n -> {
            if(n <=1)return false;
            if( n % 2 == 0) return false;
            for(int i = 3; i * i <= n; i += 2) {
                if(n%i==0)return false;
            }
            return true;
        };
        System.out.println("Has Prime?" + primeContestants.stream().anyMatch(predicate));

        // 4. Merge two sorted number lists into a single sorted list using java streams
        List<Integer> nums1 = List.of(1,5,3,9,7);
        List<Integer> nums2 = List.of(8,2,6,0,4);
        List<Integer> mergedSortedList = Stream.concat(nums1.stream(), nums2.stream()).sorted().toList();
        System.out.println(mergedSortedList);

        // 5. Find the intersection of two lists using Java streams
        List<Integer> numbers3 = Arrays.asList(1,3,5,2);
        List<Integer> numbers4 = Arrays.asList(8,5,4,2);
        List<Integer> intersection = numbers3.stream().filter(numbers4::contains).toList();
        System.out.println(intersection);

        // 6. Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> numbL = Arrays.asList(1,3,5,5,2);
        System.out.println(numbL.stream().distinct().toList());

        // 7. Given a list of transactions, find the sum of transaction amounts for each day using Java streams:
        List<Transaction> transactions = List.of(new Transaction("2025-10-06", 1001),
                new Transaction("2025-10-06", 101), new Transaction("2025-10-27", 502),
                new Transaction("2025-10-06", 981));
        Map<String, Double> dateAvgSum = transactions.stream().collect(Collectors.groupingBy(Transaction::date,
                Collectors.averagingDouble(Transaction::amount)));
        System.out.println(dateAvgSum);
    }
}
