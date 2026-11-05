/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 *
 * @author JGR
 */
package com.jordigelabert.gamehub;

import com.jordigelabert.gamehub.model.*;
import com.jordigelabert.gamehub.service.GestioLloguers;

public class GameHub {

    public static void main(String[] args) {

        GestioLloguers gestio = new GestioLloguers();

        System.out.println("=== GAMEHUB ===");

        System.out.println("Usuaris: " + gestio.getUsuaris().size());
        System.out.println("Videojocs: " + gestio.getVideojocs().size());
        System.out.println("Lloguers: " + gestio.getLloguers().size());

        System.out.println("\n=== ESTOC DISPONIBLE ===");

        for (Videojoc joc : gestio.getVideojocs()) {
            System.out.println("\n" + joc.getNom());

            for (Plataforma plataforma : Plataforma.values()) {
                System.out.println(
                    plataforma + ": " + joc.getEstoc(plataforma)
                );
            }
        }
    }
}
