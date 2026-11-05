/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 *
 * @author JGR
 */
package com.jordigelabert.gamehub;

import com.jordigelabert.gamehub.view.FinestraPrincipal;
import javax.swing.SwingUtilities;

public class GameHub {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new FinestraPrincipal().setVisible(true);
        });
    }
}
