/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.PersonneNP;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author hp
 */
public class MainComparateurCompose {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<PersonneNP> personnes = Arrays.asList(
                new PersonneNP("Jean", "Dupont", 30),
                new PersonneNP("Marie", "Martin", 25),
                new PersonneNP("Pierre", "Dupont", 40),
                new PersonneNP("Sophie", "Martin", 35),
                new PersonneNP("Paul", "Dupont", 20)
        );

        Comparator<PersonneNP> comparateur = Comparator
                .comparing(PersonneNP::getNom)
                .thenComparing(PersonneNP::getPrenom)
                .thenComparingInt(PersonneNP::getAge);

        System.out.println("Liste triee:");
        personnes.stream()
                .sorted(comparateur)
                .forEach(System.out::println);

        Comparator<PersonneNP> comparateurVariante = Comparator
                .comparing(PersonneNP::getNom)
                .thenComparing(PersonneNP::getAge, Comparator.reverseOrder());

        System.out.println();
        System.out.println("Liste triee (variante):");
        personnes.stream()
                .sorted(comparateurVariante)
                .forEach(System.out::println);
    }
    
}
