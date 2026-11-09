/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JGR
 */
package com.jordigelabert.gamehub.service;

import com.jordigelabert.gamehub.model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestioLloguers {

    private final List<Usuari> usuaris = new ArrayList<>();
    private final List<Videojoc> videojocs = new ArrayList<>();
    private final List<Lloguer> lloguers = new ArrayList<>();

    private int seguentIdUsuari = 1;
    private int seguentIdVideojoc = 1;
    private int seguentIdLloguer = 1;

    public GestioLloguers() {
        carregarDadesInicials();
    }

    // CONSULTES

    public List<Usuari> getUsuaris() {
        return Collections.unmodifiableList(usuaris);
    }

    public List<Videojoc> getVideojocs() {
        return Collections.unmodifiableList(videojocs);
    }

    public List<Lloguer> getLloguers() {
        return Collections.unmodifiableList(lloguers);
    }
    
    public int getSeguentIdLloguer() {
    return seguentIdLloguer;
}

    // GESTIÓ D'USUARIS

    public Usuari crearUsuari(String nom, String llinatge1,
                             String llinatge2, String dni, String telefon) {

        Usuari usuari = new Usuari(
                seguentIdUsuari++, nom, llinatge1,
                llinatge2, dni, telefon
        );

        usuaris.add(usuari);
        return usuari;
    }

    public boolean eliminarUsuari(Usuari usuari) {
        if (!usuaris.contains(usuari)) {
            return false;
        }

        for (Lloguer lloguer : lloguers) {
            if (lloguer.getUsuari() == usuari && lloguer.estaActiu()) {
                return false;
            }
        }

        return usuaris.remove(usuari);
    }

    // GESTIÓ DE VIDEOJOCS

    public Videojoc crearVideojoc(String nom, String genere) {
        Videojoc videojoc = new Videojoc(
                seguentIdVideojoc++, nom, genere
        );

        videojocs.add(videojoc);
        return videojoc;
    }

    public boolean eliminarVideojoc(Videojoc videojoc) {
        if (!videojocs.contains(videojoc)) {
            return false;
        }

        for (Lloguer lloguer : lloguers) {
            if (lloguer.getVideojoc() == videojoc && lloguer.estaActiu()) {
                return false;
            }
        }

        return videojocs.remove(videojoc);
    }

    // GESTIÓ DE LLOGUERS

    public Lloguer registrarLloguer(Usuari usuari, Videojoc videojoc,
                                   Plataforma plataforma) {

        if (!usuaris.contains(usuari) || !videojocs.contains(videojoc)) {
            throw new IllegalArgumentException(
                    "L'usuari o el videojoc no existeix."
            );
        }

        if (plataforma == null || !videojoc.reduirEstoc(plataforma)) {
            throw new IllegalArgumentException(
                    "No hi ha unitats disponibles per a aquesta plataforma."
            );
        }

        Lloguer lloguer = new Lloguer(
                seguentIdLloguer++, usuari, videojoc, plataforma
        );

        lloguers.add(lloguer);
        return lloguer;
    }

    public boolean retornarLloguer(Lloguer lloguer) {
        if (!lloguers.contains(lloguer) || !lloguer.estaActiu()) {
            return false;
        }

        if (lloguer.marcarComRetornat()) {
            lloguer.getVideojoc().augmentarEstoc(lloguer.getPlataforma());
            return true;
        }

        return false;
    }

    // DADES INICIALS OBLIGATÒRIES

    private void carregarDadesInicials() {

        Usuari usuari1 = crearUsuari(
                "Laura", "Garcia", "Martínez",
                "12345678Z", "600123456"
        );

        Usuari usuari2 = crearUsuari(
                "Marc", "López", "Sánchez",
                "87654321B", "600654321"
        );

        Videojoc joc1 = crearVideojoc("FIFA 25", "Esports");
        joc1.establirEstoc(Plataforma.PS5, 3);
        joc1.establirEstoc(Plataforma.SWITCH_2, 2);

        Videojoc joc2 = crearVideojoc("Cyberpunk 2077", "Acció");
        joc2.establirEstoc(Plataforma.XBOX, 2);
        joc2.establirEstoc(Plataforma.PC, 3);

        registrarLloguer(usuari1, joc1, Plataforma.PS5);
        registrarLloguer(usuari2, joc2, Plataforma.PC);
    }
}
