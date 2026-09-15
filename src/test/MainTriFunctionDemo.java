/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.TriFunction;

/**
 *
 * @author hp
 */
public class MainTriFunctionDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       TriFunction<Double, Double, Double, Double> volume = (longueur, largeur, hauteur) ->
                longueur * largeur * hauteur;

        TriFunction<Double, Double, Double, String> volumeEnLitres =
                volume.andThen(v -> v * 1000).andThen(v -> v + " litres");

        double l = 2.0, w = 3.0, h = 4.0;
        System.out.println("Volume du parallelepipede (" + l + "x" + w + "x" + h + "): "
                + volume.apply(l, w, h) + " m3");
        System.out.println("Volume en litres: " + volumeEnLitres.apply(l, w, h));
    }
    
}
