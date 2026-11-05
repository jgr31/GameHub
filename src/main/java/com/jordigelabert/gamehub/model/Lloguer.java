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

public class Lloguer {

    private static final int DIES_LLOGUER = 3;

    private final int id;
    private final Usuari usuari;
    private final Videojoc videojoc;
    private final Plataforma plataforma;
    private final LocalDate dataInici;
    private final LocalDate dataRetornPrevista;

    private boolean retornat;

    public Lloguer(int id, Usuari usuari, Videojoc videojoc,
                   Plataforma plataforma) {

        this.id = id;
        this.usuari = usuari;
        this.videojoc = videojoc;
        this.plataforma = plataforma;
        this.dataInici = LocalDate.now();
        this.dataRetornPrevista = dataInici.plusDays(DIES_LLOGUER);
        this.retornat = false;
    }

    public int getId() {
        return id;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public Videojoc getVideojoc() {
        return videojoc;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public LocalDate getDataInici() {
        return dataInici;
    }

    public LocalDate getDataRetornPrevista() {
        return dataRetornPrevista;
    }

    public boolean isRetornat() {
        return retornat;
    }

    public boolean estaActiu() {
        return !retornat;
    }

    public boolean estaVencut() {
        return !retornat && LocalDate.now().isAfter(dataRetornPrevista);
    }

    public boolean marcarComRetornat() {
        if (retornat) {
            return false;
        }

        retornat = true;
        return true;
    }
}
