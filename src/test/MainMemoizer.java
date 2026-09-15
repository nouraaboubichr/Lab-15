/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 *
 * @author hp
 */
public class MainMemoizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Function<Integer, Long>[] fibHolder = new Function[1];
        fibHolder[0] = n -> {
            if (n <= 1) return (long) n;
            System.out.println("Calcul de fibonacci(" + n + ")");
            return fibHolder[0].apply(n - 1) + fibHolder[0].apply(n - 2);
        };
        Function<Integer, Long> fibonacci = fibHolder[0];

        // Version memoized
        Function<Integer, Long>[] memoHolder = new Function[1];
        memoHolder[0] = memoize(n -> {
            if (n <= 1) return (long) n;
            System.out.println("Calcul de fibonacci(" + n + ")");
            return memoHolder[0].apply(n - 1) + memoHolder[0].apply(n - 2);
        });
        Function<Integer, Long> fibonacciMemoized = memoHolder[0];

        System.out.println("Version non-memoized:");
        long start = System.currentTimeMillis();
        System.out.println("fibonacci(10) = " + fibonacci.apply(10));
        System.out.println("Temps: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println();
        System.out.println("Version memoized:");
        start = System.currentTimeMillis();
        System.out.println("fibonacci(10) = " + fibonacciMemoized.apply(10));
        System.out.println("Temps: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println();
        System.out.println("Deuxieme appel memoized:");
        start = System.currentTimeMillis();
        System.out.println("fibonacci(10) = " + fibonacciMemoized.apply(10));
        System.out.println("Temps: " + (System.currentTimeMillis() - start) + "ms");
    }

    public static <T, R> Function<T, R> memoize(Function<T, R> function) {
        Map<T, R> cache = new ConcurrentHashMap<>();
        return input -> cache.computeIfAbsent(input, function);
    }
    
}
