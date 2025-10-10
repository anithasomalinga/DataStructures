package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.IntStream;

public class Practice1 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("anitha", "madhan", "sathvik", "vikunth");
        List<String> toUpper = stringList.stream().map(String::toUpperCase).toList();
        System.out.println(toUpper);

        Runnable r = () -> System.out.println("Running");
        new Thread(r).start();

        // Functional Interfaces - are abstract classes with exactly one method

        // Function<T,R> - apply(T t)
        Function<String, Integer> func = String::length;
        System.out.println(func.apply("anitha"));

        BiFunction<Integer, Integer, String> biFunc = (a, b) -> a + "_" + b;
        System.out.println(biFunc.apply(1,2));

        // Consumer<T> - accept(T t)
        Consumer<String> consumer = System.out::println;
        consumer.accept("testing");

        // Predicate<T> - test(T t)
        Predicate<Integer> predicate = n -> n % 2 == 0;
        System.out.println(predicate.test(3));

        // Supplier<T> - get
        // Supplier<Double> random = () -> Math.random();
        Supplier<String> supplier = () -> String.valueOf(Math.random());
        System.out.println(supplier.get());

        List<Integer> nums = IntStream.range(5, 8).boxed().toList();
        long sum = nums.stream().mapToInt(n -> n * 2).sum();
        System.out.println(nums.stream().mapToInt(n -> n * 2).boxed().toList());
        System.out.println(sum);
    }
}
