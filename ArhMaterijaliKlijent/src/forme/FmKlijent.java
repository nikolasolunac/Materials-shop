/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SOLUNAC
 */
public class FmKlijent extends javax.swing.JFrame {

    /**
     * Creates new form FmKlijent
     */
    public FmKlijent() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiUnosNovogKupca = new javax.swing.JMenuItem();
        jmiPretragaKupaca = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiUnosNovogArtikla = new javax.swing.JMenuItem();
        jmiPretragaArtikala = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        javax.swing.JMenuItem jmiUnosNovogRacuna = new javax.swing.JMenuItem();
        jmiPretragaRacuna = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jMenu1.setText("Kupci");

        jmiUnosNovogKupca.setText("Unos novog kupca");
        jmiUnosNovogKupca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosNovogKupcaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiUnosNovogKupca);

        jmiPretragaKupaca.setText("Pretraga kupaca");
        jmiPretragaKupaca.setToolTipText("");
        jmiPretragaKupaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaKupacaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiPretragaKupaca);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Artikli");

        jmiUnosNovogArtikla.setText("Unos novog artikla");
        jmiUnosNovogArtikla.setToolTipText("");
        jmiUnosNovogArtikla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosNovogArtiklaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiUnosNovogArtikla);

        jmiPretragaArtikala.setText("Pretraga artikala");
        jmiPretragaArtikala.setToolTipText("");
        jmiPretragaArtikala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaArtikalaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiPretragaArtikala);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Računi");

        jmiUnosNovogRacuna.setText("Unos novog računa");
        jmiUnosNovogRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosNovogRacunaActionPerformed(evt);
            }
        });
        jMenu3.add(jmiUnosNovogRacuna);

        jmiPretragaRacuna.setText("Pretraga računa");
        jmiPretragaRacuna.setToolTipText("");
        jmiPretragaRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaRacunaActionPerformed(evt);
            }
        });
        jMenu3.add(jmiPretragaRacuna);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiUnosNovogKupcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosNovogKupcaActionPerformed
        // TODO add your handling code here:
        kontroler.KontrolerKlijent.getInstance().setAktivan_sk(util.Util.SK_UNOS);
        try {
            new FmUnosKupca(this, true).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FmKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmiUnosNovogKupcaActionPerformed

    private void jmiPretragaKupacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaKupacaActionPerformed
        // TODO add your handling code here:
        new FmPretragaKupaca(this, true).setVisible(true);
    }//GEN-LAST:event_jmiPretragaKupacaActionPerformed

    private void jmiUnosNovogArtiklaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosNovogArtiklaActionPerformed
        // TODO add your handling code here:
        kontroler.KontrolerKlijent.getInstance().setAktivan_sk(util.Util.SK_UNOS);
        new FmUnosArtikla(this, true).setVisible(true);       
    }//GEN-LAST:event_jmiUnosNovogArtiklaActionPerformed

    private void jmiPretragaArtikalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaArtikalaActionPerformed
        // TODO add your handling code here:
        new FmPretragaArtikala(this, true).setVisible(true);
    }//GEN-LAST:event_jmiPretragaArtikalaActionPerformed

    private void jmiUnosNovogRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosNovogRacunaActionPerformed
        // TODO add your handling code here:
        kontroler.KontrolerKlijent.getInstance().setAktivan_sk(util.Util.SK_UNOS);
        new FmUnosRacuna(this, true).setVisible(true);
    }//GEN-LAST:event_jmiUnosNovogRacunaActionPerformed

    private void jmiPretragaRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaRacunaActionPerformed
        // TODO add your handling code here:
        new FmPretragaRacuna(this, true).setVisible(true);
    }//GEN-LAST:event_jmiPretragaRacunaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        kontroler.KontrolerKlijent.getInstance().odjaviSeSaServera();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmiPretragaArtikala;
    private javax.swing.JMenuItem jmiPretragaKupaca;
    private javax.swing.JMenuItem jmiPretragaRacuna;
    private javax.swing.JMenuItem jmiUnosNovogArtikla;
    private javax.swing.JMenuItem jmiUnosNovogKupca;
    // End of variables declaration//GEN-END:variables
}