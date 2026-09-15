/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.stream.IntStream;

/**
 *
 * @author hp
 */
public class MainFactorielleStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         System.out.println("Factorielles (version imperative):");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + "! = " + factorielleImperative(i));
        }

        System.out.println();
        System.out.println("Factorielles (version fonctionnelle):");
        for (int i = 0; i <= 10; i++) {
            final int n = i;
            System.out.println(n + "! = " + factorielleStream(n));
        }
    }

    private static long factorielleImperative(int n) {
        if (n <= 1) return 1;
        long resultat = 1;
        for (int i = 2; i <= n; i++) {
            resultat *= i;
        }
        return resultat;
    }

    private static long factorielleStream(int n) {
        if (n <= 1) return 1;
        return IntStream.rangeClosed(2, n)
                .mapToLong(Long::valueOf)
                .reduce(1, (a, b) -> a * b);
    }
    
}
