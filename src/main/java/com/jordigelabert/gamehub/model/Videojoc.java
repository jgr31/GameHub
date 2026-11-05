/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JGR
 */
package com.jordigelabert.gamehub.model;

import java.util.EnumMap;
import java.util.Map;

public class Videojoc {

    private final int id;
    private String nom;
    private String genere;
    private final Map<Plataforma, Integer> estoc;

    public Videojoc(int id, String nom, String genere) {
        this.id = id;
        this.nom = nom;
        this.genere = genere;
        this.estoc = new EnumMap<>(Plataforma.class);

        for (Plataforma plataforma : Plataforma.values()) {
            estoc.put(plataforma, 0);
        }
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getGenere() {
        return genere;
    }

    public int getEstoc(Plataforma plataforma) {
        return estoc.get(plataforma);
    }

    public void establirEstoc(Plataforma plataforma, int unitats) {
        if (unitats < 0) {
            throw new IllegalArgumentException(
                "Les unitats no poden ser negatives."
            );
        }

        estoc.put(plataforma, unitats);
    }

    public boolean teDisponibilitat(Plataforma plataforma) {
        return getEstoc(plataforma) > 0;
    }

    public boolean reduirEstoc(Plataforma plataforma) {
        if (!teDisponibilitat(plataforma)) {
            return false;
        }

        estoc.put(plataforma, getEstoc(plataforma) - 1);
        return true;
    }

    public void augmentarEstoc(Plataforma plataforma) {
        estoc.put(plataforma, getEstoc(plataforma) + 1);
    }

    @Override
    public String toString() {
        return nom;
    }
}
