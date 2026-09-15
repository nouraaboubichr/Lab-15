/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author hp
 */
public class MainCompteurTODO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Map<Path, Long> todoParFichier = Files.walk(Paths.get("."))
                    .filter(p -> p.toString().endsWith(".java"))
                    .collect(Collectors.toMap(
                            p -> p,
                            p -> {
                                try {
                                    return Files.lines(p)
                                            .filter(line -> line.contains("TODO"))
                                            .count();
                                } catch (IOException e) {
                                    return 0L;
                                }
                            }
                    ));

            System.out.println("Nombre de TODO par fichier Java:");
            todoParFichier.entrySet().stream()
                    .filter(e -> e.getValue() > 0)
                    .sorted(Map.Entry.<Path, Long>comparingByValue().reversed())
                    .forEach(e -> System.out.println(e.getKey().getFileName() + ": " + e.getValue()));

            long totalTODO = todoParFichier.values().stream().mapToLong(Long::longValue).sum();
            System.out.println("Total des TODO: " + totalTODO);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
