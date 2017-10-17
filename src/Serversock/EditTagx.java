/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serversock;

import java.io.File;
import Serversock.Mp3Object;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Josue Bonilla
 */
public class EditTagx extends javax.swing.JFrame {

    File archivo = null;
    String path = "";

    /**
     * Creates new form FileTagx
     */
    public EditTagx() {
        initComponents();
        noMostrar(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lrellenar = new javax.swing.JLabel();
        lartista = new javax.swing.JLabel();
        lcancion = new javax.swing.JLabel();
        lanime = new javax.swing.JLabel();
        Tartista = new javax.swing.JTextField();
        Ttitulo = new javax.swing.JTextField();
        Tanime = new javax.swing.JTextField();
        Jguardar = new javax.swing.JButton();
        Jborrar = new javax.swing.JButton();
        Texa = new javax.swing.JTextField();
        Bexa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seleccione un archivo de audio");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lrellenar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lrellenar.setText("Editar");
        lrellenar.setAutoscrolls(true);
        getContentPane().add(lrellenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, 27));

        lartista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lartista.setText("Artista: ");
        lartista.setAutoscrolls(true);
        getContentPane().add(lartista, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 144, 63, 27));

        lcancion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lcancion.setText("Cancion: ");
        lcancion.setAutoscrolls(true);
        getContentPane().add(lcancion, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 189, 71, 27));

        lanime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lanime.setText("Anime: ");
        lanime.setAutoscrolls(true);
        getContentPane().add(lanime, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 237, -1, 27));

        Tartista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(Tartista, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 144, 300, 27));

        Ttitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Ttitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TtituloActionPerformed(evt);
            }
        });
        getContentPane().add(Ttitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 189, 300, 27));

        Tanime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Tanime.setToolTipText("Opcional");
        getContentPane().add(Tanime, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 237, 300, 27));

        Jguardar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jguardar.setText("Guardar");
        Jguardar.setAutoscrolls(true);
        Jguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JguardarActionPerformed(evt);
            }
        });
        getContentPane().add(Jguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 282, -1, 27));

        Jborrar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Jborrar.setText("Borrar");
        Jborrar.setAutoscrolls(true);
        Jborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JborrarActionPerformed(evt);
            }
        });
        getContentPane().add(Jborrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 282, 83, 27));
        getContentPane().add(Texa, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 24, 285, 27));

        Bexa.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Bexa.setText("Examinar");
        Bexa.setAutoscrolls(true);
        Bexa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BexaActionPerformed(evt);
            }
        });
        getContentPane().add(Bexa, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 24, -1, 27));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JguardarActionPerformed
        // TODO add your handling code here:
        Mp3Object tags = new Mp3Object();
        tags.setArtist(Tartista.getText().trim());
        tags.setTitle(Ttitulo.getText().trim());
        tags.setAnime(Tanime.getText().trim());
        tags.setMp3Files(archivo);
        FileTagx ft = new FileTagx();
        ft.setFileTags(tags);
    }//GEN-LAST:event_JguardarActionPerformed

    private void JborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JborrarActionPerformed
        // TODO add your handling code here:
        Tartista.setText("");
        Ttitulo.setText("");
        Tanime.setText("");
        Texa.setText("");
        noMostrar(false);
    }//GEN-LAST:event_JborrarActionPerformed

    private void TtituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TtituloActionPerformed

    private void BexaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BexaActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = null;
        chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("MP3 Audio", "mp3"));
        chooser.setAcceptAllFileFilterUsed(false);
        if (!path.equalsIgnoreCase("")) {
            System.out.println("parentpath " + new File(path).getParentFile());
            chooser.setCurrentDirectory(archivo.getParentFile());
        }
     chooser.showOpenDialog(this);
        try {
            archivo = chooser.getSelectedFile();
            path = archivo.getAbsolutePath();
            Texa.setText(path);
        } catch (NullPointerException e) {
            System.out.println("No se selecciono un archivo. El archivo es " + e.getMessage());
        }
        if (!path.equalsIgnoreCase("")) {
            FileTagx ft = new FileTagx(path);
            Tartista.setText(ft.getFileTags().getArtist());
            Ttitulo.setText(ft.getFileTags().getTitle());
            Tanime.setText("???");
            noMostrar(true);
        }

    }//GEN-LAST:event_BexaActionPerformed

    public void noMostrar(boolean valor) {
        Tartista.setEnabled(valor);
        Ttitulo.setEnabled(valor);
        Tanime.setEnabled(valor);
        Jguardar.setEnabled(valor);
        Jborrar.setEnabled(valor);
        lrellenar.setEnabled(valor);
        lartista.setEnabled(valor);
        lcancion.setEnabled(valor);
        lanime.setEnabled(valor);
        //ancho*alto
        if (valor) {
            this.setSize(455, 365);
        } else {
            this.setSize(455, 120);
        }
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditTagx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditTagx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditTagx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditTagx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditTagx().setVisible(true);
            }
        });
    }
    /* Create and display the form */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bexa;
    private javax.swing.JButton Jborrar;
    private javax.swing.JButton Jguardar;
    private javax.swing.JTextField Tanime;
    private javax.swing.JTextField Tartista;
    private javax.swing.JTextField Texa;
    private javax.swing.JTextField Ttitulo;
    private javax.swing.JLabel lanime;
    private javax.swing.JLabel lartista;
    private javax.swing.JLabel lcancion;
    private javax.swing.JLabel lrellenar;
    // End of variables declaration//GEN-END:variables
}
