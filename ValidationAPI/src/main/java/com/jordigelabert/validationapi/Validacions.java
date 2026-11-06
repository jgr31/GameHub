/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jordigelabert.validationapi;

/**
 *
 * @author JGR
 */
public final class Validacions {

    private Validacions() {
        // Classe utilitària: no necessita instàncies.
    }

    public static boolean campObligatori(String valor) {
        return valor != null && !valor.trim().isEmpty();
    }

    public static boolean nomComencaMajuscula(String nom) {
        if (!campObligatori(nom)) {
            return false;
        }

        int primerCaracter = nom.trim().codePointAt(0);
        return Character.isUpperCase(primerCaracter);
    }

    public static boolean telefonValid(String telefon) {
        return telefon != null
                && telefon.trim().matches("[0-9]{9}");
    }

    public static boolean dniValid(String dni) {
        return dni != null
                && dni.trim().toUpperCase()
                        .matches("[0-9]{8}[A-Z]");
    }
}
