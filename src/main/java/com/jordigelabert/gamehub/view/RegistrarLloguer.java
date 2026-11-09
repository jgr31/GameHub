/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.jordigelabert.gamehub.view;

import com.jordigelabert.gamehub.model.Usuari;
import com.jordigelabert.gamehub.model.Videojoc;
import com.jordigelabert.gamehub.model.Plataforma;
import com.jordigelabert.gamehub.service.GestioLloguers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

import java.util.Locale;
import java.util.ResourceBundle;
/**
 *
 * @author JGR
 */
public class RegistrarLloguer extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegistrarLloguer.class.getName());
    
    private final GestioLloguers gestio;

private static final DateTimeFormatter FORMAT_DATA =
        DateTimeFormatter.ofPattern("dd/MM/yyyy");

private static final ResourceBundle textos = ResourceBundle.getBundle(
        "com.jordigelabert.gamehub.Bundle",
        Locale.forLanguageTag("ca-ES")
);

    /**
     * Creates new form RegistrarLloguer
     */
public RegistrarLloguer(java.awt.Frame parent, boolean modal,
                       GestioLloguers gestio) {

    super(parent, modal);
    this.gestio = gestio;

    initComponents();
    configurarTextos();
    setLocationRelativeTo(parent);

    carregarDades();
}

// Constructor per executar el formulari individualment
public RegistrarLloguer(java.awt.Frame parent, boolean modal) {
    this(parent, modal, new GestioLloguers());
}

private void configurarTextos() {
    setTitle(textos.getString("lloguer.registrar.titol"));

    panelDades.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            textos.getString("lloguer.registrar.dades")
        )
    );

    labelNumRegistre.setText(textos.getString("lloguer.registrar.numero") + ":");
    labelUsuari.setText(textos.getString("lloguer.registrar.usuari") + ":");
    labelJoc.setText(textos.getString("lloguer.registrar.joc") + ":");
    labelDataInici.setText(textos.getString("lloguer.registrar.dataInici") + ":");
    labelDataTornada.setText(textos.getString("lloguer.registrar.dataTornada") + ":");

    panelPlataformes.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            textos.getString("lloguer.registrar.plataforma")
        )
    );

    panelInfoJoc.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            textos.getString("lloguer.registrar.infoJoc")
        )
    );

    labelGenere.setText(textos.getString("lloguer.registrar.genere") + ":");
    labelDisponibilitat.setText(textos.getString("lloguer.registrar.unitats") + ":");

    botoConfirmar.setText(textos.getString("boto.confirmar"));
    botoCancelar.setText(textos.getString("boto.cancelar"));
}

private void carregarDades() {

    // Carregar usuaris
    comboUsuari.removeAllItems();

    for (Usuari usuari : gestio.getUsuaris()) {
        comboUsuari.addItem(usuari);
    }

    // Carregar videojocs
    comboJoc.removeAllItems();

    for (Videojoc joc : gestio.getVideojocs()) {
        comboJoc.addItem(joc);
    }

    // Dates automàtiques
    LocalDate avui = LocalDate.now();

    campDataInici.setText(avui.format(FORMAT_DATA));
    campDataTornada.setText(avui.plusDays(3).format(FORMAT_DATA));
    
    actualitzarPlataformes();
    
    campNumRegistre.setText(
        String.format("%02d", gestio.getSeguentIdLloguer())
);
}

private void actualitzarPlataformes() {

    Videojoc joc = (Videojoc) comboJoc.getSelectedItem();

    // Netejar la selecció anterior
    grupPlataformes.clearSelection();

    if (joc == null) {
        radioPS5.setEnabled(false);
        radioXbox.setEnabled(false);
        radioPC.setEnabled(false);
        radioSwitch2.setEnabled(false);

        valorGenere.setText("-");
        valorPS5.setText("PS5: 0");
        valorXbox.setText("Xbox: 0");
        valorPC.setText("PC: 0");
        valorSwitch2.setText("Switch 2: 0");

        botoConfirmar.setEnabled(false);
        return;
    }
    
    

    // Mostrar informació del videojoc
    valorGenere.setText(joc.getGenere());

    int ps5 = joc.getEstoc(Plataforma.PS5);
    int xbox = joc.getEstoc(Plataforma.XBOX);
    int pc = joc.getEstoc(Plataforma.PC);
    int switch2 = joc.getEstoc(Plataforma.SWITCH_2);

    valorPS5.setText("PS5: " + ps5);
    valorXbox.setText("Xbox: " + xbox);
    valorPC.setText("PC: " + pc);
    valorSwitch2.setText("Switch 2: " + switch2);

    // Activar només les plataformes disponibles
    radioPS5.setEnabled(ps5 > 0);
    radioXbox.setEnabled(xbox > 0);
    radioPC.setEnabled(pc > 0);
    radioSwitch2.setEnabled(switch2 > 0);

    // Encara no hi ha cap plataforma seleccionada
    botoConfirmar.setEnabled(false);
}

private void actualitzarConfirmar() {

    boolean plataformaSeleccionada =
            radioPS5.isSelected()
            || radioXbox.isSelected()
            || radioPC.isSelected()
            || radioSwitch2.isSelected();

    botoConfirmar.setEnabled(
            comboUsuari.getSelectedItem() != null
            && comboJoc.getSelectedItem() != null
            && plataformaSeleccionada
    );
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupPlataformes = new javax.swing.ButtonGroup();
        panelDades = new javax.swing.JPanel();
        labelNumRegistre = new javax.swing.JLabel();
        campNumRegistre = new javax.swing.JTextField();
        labelUsuari = new javax.swing.JLabel();
        comboUsuari = new javax.swing.JComboBox<>();
        labelJoc = new javax.swing.JLabel();
        comboJoc = new javax.swing.JComboBox<>();
        labelDataInici = new javax.swing.JLabel();
        campDataInici = new javax.swing.JTextField();
        labelDataTornada = new javax.swing.JLabel();
        campDataTornada = new javax.swing.JTextField();
        panelPlataformes = new javax.swing.JPanel();
        radioPS5 = new javax.swing.JRadioButton();
        radioXbox = new javax.swing.JRadioButton();
        radioPC = new javax.swing.JRadioButton();
        radioSwitch2 = new javax.swing.JRadioButton();
        panelInfoJoc = new javax.swing.JPanel();
        labelGenere = new javax.swing.JLabel();
        valorGenere = new javax.swing.JLabel();
        labelDisponibilitat = new javax.swing.JLabel();
        valorPS5 = new javax.swing.JLabel();
        valorXbox = new javax.swing.JLabel();
        valorPC = new javax.swing.JLabel();
        valorSwitch2 = new javax.swing.JLabel();
        botoCancelar = new javax.swing.JButton();
        botoConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar lloguer");
        setModal(true);
        setResizable(false);

        panelDades.setBorder(javax.swing.BorderFactory.createTitledBorder("Dades del lloguer"));

        labelNumRegistre.setText("Núm. registre:");

        campNumRegistre.setEditable(false);

        labelUsuari.setText("Usuari:");

        comboUsuari.addActionListener(this::comboUsuariActionPerformed);

        labelJoc.setText("Joc elegit:");

        comboJoc.addActionListener(this::comboJocActionPerformed);

        labelDataInici.setText("Data d'inici:");

        campDataInici.setEditable(false);

        labelDataTornada.setText("Data de tornada:\t");

        campDataTornada.setEditable(false);

        javax.swing.GroupLayout panelDadesLayout = new javax.swing.GroupLayout(panelDades);
        panelDades.setLayout(panelDadesLayout);
        panelDadesLayout.setHorizontalGroup(
            panelDadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelDadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadesLayout.createSequentialGroup()
                        .addGroup(panelDadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDataTornada)
                            .addComponent(labelDataInici)
                            .addComponent(labelJoc))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDadesLayout.createSequentialGroup()
                        .addGroup(panelDadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campDataTornada, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campDataInici, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboJoc, 0, 178, Short.MAX_VALUE)
                            .addComponent(labelUsuari, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboUsuari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDadesLayout.createSequentialGroup()
                        .addComponent(labelNumRegistre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(campNumRegistre, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        panelDadesLayout.setVerticalGroup(
            panelDadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelDadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumRegistre)
                    .addComponent(campNumRegistre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelUsuari)
                .addGap(18, 18, 18)
                .addComponent(comboUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelJoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboJoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelDataInici)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campDataInici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelDataTornada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campDataTornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        panelPlataformes.setBorder(javax.swing.BorderFactory.createTitledBorder("Plataforma"));

        grupPlataformes.add(radioPS5);
        radioPS5.setText("PS5");
        radioPS5.setEnabled(false);
        radioPS5.addActionListener(this::radioPS5ActionPerformed);

        grupPlataformes.add(radioXbox);
        radioXbox.setText("Xbox");
        radioXbox.setEnabled(false);
        radioXbox.addActionListener(this::radioXboxActionPerformed);

        grupPlataformes.add(radioPC);
        radioPC.setText("PC");
        radioPC.setEnabled(false);
        radioPC.addActionListener(this::radioPCActionPerformed);

        grupPlataformes.add(radioSwitch2);
        radioSwitch2.setText("Switch 2");
        radioSwitch2.setEnabled(false);
        radioSwitch2.addActionListener(this::radioSwitch2ActionPerformed);

        javax.swing.GroupLayout panelPlataformesLayout = new javax.swing.GroupLayout(panelPlataformes);
        panelPlataformes.setLayout(panelPlataformesLayout);
        panelPlataformesLayout.setHorizontalGroup(
            panelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlataformesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioPS5)
                    .addComponent(radioXbox)
                    .addComponent(radioPC)
                    .addComponent(radioSwitch2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPlataformesLayout.setVerticalGroup(
            panelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlataformesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioPS5)
                .addGap(18, 18, 18)
                .addComponent(radioXbox)
                .addGap(18, 18, 18)
                .addComponent(radioPC)
                .addGap(18, 18, 18)
                .addComponent(radioSwitch2)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelInfoJoc.setBorder(javax.swing.BorderFactory.createTitledBorder("Informació del joc"));

        labelGenere.setText("Gènere:");

        valorGenere.setText("-");

        labelDisponibilitat.setText("Unitats disponibles:");

        valorPS5.setText("PS5: 0");

        valorXbox.setText("Xbox: 0");

        valorPC.setText("PC: 0");

        valorSwitch2.setText("Switch 2: 0");

        javax.swing.GroupLayout panelInfoJocLayout = new javax.swing.GroupLayout(panelInfoJoc);
        panelInfoJoc.setLayout(panelInfoJocLayout);
        panelInfoJocLayout.setHorizontalGroup(
            panelInfoJocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoJocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoJocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoJocLayout.createSequentialGroup()
                        .addComponent(labelGenere)
                        .addGap(35, 35, 35)
                        .addComponent(valorGenere, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelDisponibilitat)
                    .addGroup(panelInfoJocLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(panelInfoJocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorXbox)
                            .addComponent(valorPS5)
                            .addComponent(valorPC)
                            .addComponent(valorSwitch2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInfoJocLayout.setVerticalGroup(
            panelInfoJocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoJocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoJocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGenere)
                    .addComponent(valorGenere))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDisponibilitat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorPS5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valorXbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valorPC)
                .addGap(12, 12, 12)
                .addComponent(valorSwitch2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botoCancelar.setText("Cancel·lar");
        botoCancelar.addActionListener(this::botoCancelarActionPerformed);

        botoConfirmar.setText("Confirmar");
        botoConfirmar.addActionListener(this::botoConfirmarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelDades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelInfoJoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPlataformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelPlataformes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelInfoJoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botoConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(botoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboJocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboJocActionPerformed
        // TODO add your handling code here:
        actualitzarPlataformes();
    }//GEN-LAST:event_comboJocActionPerformed

    private void radioPS5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPS5ActionPerformed
        // TODO add your handling code here:
        actualitzarConfirmar();
    }//GEN-LAST:event_radioPS5ActionPerformed

    private void radioXboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioXboxActionPerformed
        // TODO add your handling code here:
        actualitzarConfirmar();
    }//GEN-LAST:event_radioXboxActionPerformed

    private void radioPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPCActionPerformed
        // TODO add your handling code here:
        actualitzarConfirmar();
    }//GEN-LAST:event_radioPCActionPerformed

    private void radioSwitch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSwitch2ActionPerformed
        // TODO add your handling code here:
        actualitzarConfirmar();
    }//GEN-LAST:event_radioSwitch2ActionPerformed

    private void comboUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUsuariActionPerformed
        // TODO add your handling code here:
        actualitzarConfirmar();
    }//GEN-LAST:event_comboUsuariActionPerformed

    private void botoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoConfirmarActionPerformed
        // TODO add your handling code here:
        Usuari usuari = (Usuari) comboUsuari.getSelectedItem();
Videojoc joc = (Videojoc) comboJoc.getSelectedItem();

if (usuari == null || joc == null) {
    JOptionPane.showMessageDialog(this,
            textos.getString("error.lloguer.usuariJoc"));
    return;
}

// Obtenir la plataforma seleccionada
Plataforma plataforma = null;

if (radioPS5.isSelected()) {
    plataforma = Plataforma.PS5;
} else if (radioXbox.isSelected()) {
    plataforma = Plataforma.XBOX;
} else if (radioPC.isSelected()) {
    plataforma = Plataforma.PC;
} else if (radioSwitch2.isSelected()) {
    plataforma = Plataforma.SWITCH_2;
}

if (plataforma == null) {
    JOptionPane.showMessageDialog(this,
            textos.getString("error.lloguer.plataforma"));
    return;
}

// Registrar el lloguer
try {
    gestio.registrarLloguer(usuari, joc, plataforma);

    JOptionPane.showMessageDialog(this,
            textos.getString("missatge.lloguerRegistrat"));

    dispose();

} catch (IllegalArgumentException ex) {
    JOptionPane.showMessageDialog(
            this,
            ex.getMessage(),
            textos.getString("missatge.error"),
            JOptionPane.ERROR_MESSAGE
    );
}
    }//GEN-LAST:event_botoConfirmarActionPerformed

    private void botoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botoCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegistrarLloguer dialog = new RegistrarLloguer(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoCancelar;
    private javax.swing.JButton botoConfirmar;
    private javax.swing.JTextField campDataInici;
    private javax.swing.JTextField campDataTornada;
    private javax.swing.JTextField campNumRegistre;
    private javax.swing.JComboBox<Videojoc> comboJoc;
    private javax.swing.JComboBox<Usuari> comboUsuari;
    private javax.swing.ButtonGroup grupPlataformes;
    private javax.swing.JLabel labelDataInici;
    private javax.swing.JLabel labelDataTornada;
    private javax.swing.JLabel labelDisponibilitat;
    private javax.swing.JLabel labelGenere;
    private javax.swing.JLabel labelJoc;
    private javax.swing.JLabel labelNumRegistre;
    private javax.swing.JLabel labelUsuari;
    private javax.swing.JPanel panelDades;
    private javax.swing.JPanel panelInfoJoc;
    private javax.swing.JPanel panelPlataformes;
    private javax.swing.JRadioButton radioPC;
    private javax.swing.JRadioButton radioPS5;
    private javax.swing.JRadioButton radioSwitch2;
    private javax.swing.JRadioButton radioXbox;
    private javax.swing.JLabel valorGenere;
    private javax.swing.JLabel valorPC;
    private javax.swing.JLabel valorPS5;
    private javax.swing.JLabel valorSwitch2;
    private javax.swing.JLabel valorXbox;
    // End of variables declaration//GEN-END:variables
}
