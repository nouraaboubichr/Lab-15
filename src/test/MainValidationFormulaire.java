/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Validateur;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author hp
 */
public class MainValidationFormulaire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Validateur<String> validateurEmail = new Validateur<String>()
                .ajouterRegle(s -> s != null && !s.isEmpty(), "L'email ne peut pas etre vide")
                .ajouterRegle(s -> s.contains("@"), "L'email doit contenir @")
                .ajouterRegle(s -> Pattern.matches(".+@.+\\..+", s), "Format d'email invalide");

       List<String> emails = Arrays.asList("user@example.com", "", "invalide", "user@domaine");

        for (String email : emails) {
            List<String> erreurs = validateurEmail.valider(email);
            if (erreurs.isEmpty()) {
                System.out.println("Email valide: " + email);
            } else {
                System.out.println("Email invalide: " + email);
                erreurs.forEach(err -> System.out.println("  - " + err));
            }
        }
    }
    
}
