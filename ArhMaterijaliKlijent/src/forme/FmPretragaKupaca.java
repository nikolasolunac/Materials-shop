/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import apstraktno.AbstractJDialog;
import domen.Kupac;
import domen.OpstiDomenskiObjekat;
import gui.komponente.ModelTabeleKupci;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author SOLUNAC
 */
public class FmPretragaKupaca extends AbstractJDialog {

    /**
     * Creates new form FmPretragaArtikala
     */
    public FmPretragaKupaca(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        kontroler.KontrolerKlijent.getInstance().setFmPretrazivanjeKupaca(this);
        popuniTabeluSaSvimKupcima();
        srediFormuInicijalno();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxtKriterijum = new javax.swing.JTextField();
        jbtnPretrazi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblKupci = new javax.swing.JTable();
        jbtnDetalji = new javax.swing.JButton();
        jbtnObrisi = new javax.swing.JButton();
        jbtnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Unesite kriterijum pretrage:");

        jbtnPretrazi.setText("Pretraži");
        jbtnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPretraziActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("(id kupca/ime kupca/prezime kupca/telefon kupca)");

        jtblKupci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblKupci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblKupciMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblKupci);

        jbtnDetalji.setText("Detalji");
        jbtnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDetaljiActionPerformed(evt);
            }
        });

        jbtnObrisi.setText("Obriši");
        jbtnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiActionPerformed(evt);
            }
        });

        jbtnIzmeni.setText("Izmeni");
        jbtnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnIzmeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnObrisi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnDetalji))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtKriterijum, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jbtnPretrazi)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtKriterijum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnPretrazi))
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDetalji)
                    .addComponent(jbtnObrisi)
                    .addComponent(jbtnIzmeni))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPretraziActionPerformed
        // TODO add your handling code here:
        try {
            String kriterijum = jtxtKriterijum.getText().trim();
            kontroler.KontrolerKlijent.getInstance().setKriterijumPretrage(kriterijum);
            if (kriterijum.isEmpty()) {
                popuniTabeluSaSvimKupcima();
                srediFormuInicijalno();
            } else {
                List<OpstiDomenskiObjekat> lista = kontroler.KontrolerKlijent.getInstance().pretraziKupce(kriterijum);
                if (!lista.isEmpty()) {
                    postaviModelTabele(lista);
                    prikaziPorukuObavestenja("Sistem je našao kupce po zadatoj vrednosti!");
                    srediFormuInicijalno();
                } else {
                    postaviModelTabele(new ArrayList<OpstiDomenskiObjekat>());
                    prikaziPorukuGreske("Sistem ne može da nađe kupce po zadatoj vrednosti!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbtnPretraziActionPerformed

    private void jbtnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDetaljiActionPerformed
        // TODO add your handling code here:
        preuzmiPodatkeSelektovanogKupca(util.Util.SK_PRIKAZ);
    }//GEN-LAST:event_jbtnDetaljiActionPerformed

    private void jbtnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiActionPerformed
        // TODO add your handling code here:
        int red = jtblKupci.getSelectedRow();
        if (red != -1) {
            try {
                Kupac kupac = ((ModelTabeleKupci) jtblKupci.getModel()).vratiKupca(red);
                kontroler.KontrolerKlijent.getInstance().obrisiKupca(kupac.getKupacID() + "");
                prikaziPorukuObavestenja("Sistem je obrisao kupca!");
                osvezi();
            } catch (Exception e) {
                e.printStackTrace();
                prikaziPorukuGreske("Sistem ne može da obriše kupca!");

            }

        } else {

            prikaziPorukuGreske("Niste selektovali nijednog kupca!");
        }
    }//GEN-LAST:event_jbtnObrisiActionPerformed

    private void jbtnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzmeniActionPerformed
        // TODO add your handling code here:
        preuzmiPodatkeSelektovanogKupca(util.Util.SK_IZMENA);
    }//GEN-LAST:event_jbtnIzmeniActionPerformed

    private void jtblKupciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblKupciMouseClicked
        // TODO add your handling code here:
        jbtnDetalji.setVisible(true);
        jbtnIzmeni.setVisible(true);
    }//GEN-LAST:event_jtblKupciMouseClicked

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDetalji;
    private javax.swing.JButton jbtnIzmeni;
    private javax.swing.JButton jbtnObrisi;
    private javax.swing.JButton jbtnPretrazi;
    private javax.swing.JTable jtblKupci;
    private javax.swing.JTextField jtxtKriterijum;
    // End of variables declaration//GEN-END:variables
   
    private void popuniTabeluSaSvimKupcima() {
        try {
            List<OpstiDomenskiObjekat> lista = kontroler.KontrolerKlijent.getInstance().vratiListuKupaca();
            postaviModelTabele(lista);
        } catch (Exception e) {
            prikaziPorukuGreske("Problem pri učitavanju svih kupaca!");
        }
    }

    private void postaviModelTabele(List<OpstiDomenskiObjekat> lista) {
        jtblKupci.setModel(new ModelTabeleKupci(lista));
    }

    private void prikaziPorukuGreske(String poruka) {
        JOptionPane.showMessageDialog(this, poruka, "Greška!", JOptionPane.ERROR_MESSAGE);
    }

    private void prikaziPorukuObavestenja(String poruka) {
        JOptionPane.showMessageDialog(this, poruka, "Obaveštenje!", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void osvezi() {
        try {
            String kriterijum = kontroler.KontrolerKlijent.getInstance().getKriterijumPretrage();
            if (kriterijum.isEmpty()) {
                popuniTabeluSaSvimKupcima();
            } else {
                List<OpstiDomenskiObjekat> lista = kontroler.KontrolerKlijent.getInstance().pretraziKupce(kriterijum);
                if (!lista.isEmpty()) {
                    postaviModelTabele(lista);
                } else {
                    postaviModelTabele(new ArrayList<OpstiDomenskiObjekat>());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preuzmiPodatkeSelektovanogKupca(int sk) {
        int red = jtblKupci.getSelectedRow();
        if (red != -1) {
            try {
                Kupac izabraniKupac = ((ModelTabeleKupci) jtblKupci.getModel()).vratiKupca(red);
                List<OpstiDomenskiObjekat> lista = kontroler.KontrolerKlijent.getInstance().pretraziKupce(izabraniKupac.getKupacID() + "");
                if (!lista.isEmpty()) {
                    prikaziPorukuObavestenja("Sistem je učitao kupca!");
                    Kupac kupacSaPodacima = (Kupac) lista.get(0);
                    kontroler.KontrolerKlijent.getInstance().setSelektovanKupac(kupacSaPodacima);
                    kontroler.KontrolerKlijent.getInstance().setAktivan_sk(sk);
                    new FmUnosKupca(null, true).setVisible(true);
                } else {
                    prikaziPorukuGreske("Sistem ne može da učita kupca!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            prikaziPorukuGreske("Niste selektovali nijednog kupca!");
        }
    }

    private void srediFormuInicijalno() {
        jbtnDetalji.setVisible(false);
        jbtnIzmeni.setVisible(false);
    }
}
