/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JGR
 */
package com.jordigelabert.gamehub.model;

import java.time.LocalDate;

public class Usuari {

    private final int id;
    private String nom;
    private String llinatge1;
    private String llinatge2;
    private String dni;
    private String telefon;
    private final LocalDate dataRegistre;

    public Usuari(int id, String nom, String llinatge1,
                  String llinatge2, String dni, String telefon) {

        this.id = id;
        this.nom = nom;
        this.llinatge1 = llinatge1;
        this.llinatge2 = llinatge2;
        this.dni = dni;
        this.telefon = telefon;
        this.dataRegistre = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getLlinatge1() {
        return llinatge1;
    }

    public String getLlinatge2() {
        return llinatge2;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefon() {
        return telefon;
    }

    public LocalDate getDataRegistre() {
        return dataRegistre;
    }

    public String getNomComplet() {
        return nom + " " + llinatge1 + " " + llinatge2;
    }

    @Override
    public String toString() {
        return getNomComplet();
    }
}
