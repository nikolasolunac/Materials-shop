/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Kupac;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Racun;
import gui.komponente.ModelTabeleRacuni;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author SOLUNAC
 */
public class FmUnosKupca extends javax.swing.JDialog {

    public boolean daLiJeKreiran = false;
    
    /**
     * Creates new form FmUnosKupca
     */
    public FmUnosKupca(java.awt.Frame parent, boolean modal) throws Exception{
        super(parent, modal);
        initComponents();
        kontroler.KontrolerKlijent.getInstance().setFmUnosKupca(this);
        srediFormuPremaSK();
        popuniComboBox();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtKupacID = new javax.swing.JTextField();
        jtxtIme = new javax.swing.JTextField();
        jtxtPrezime = new javax.swing.JTextField();
        jtxtTelefon = new javax.swing.JTextField();
        jtxtEmail = new javax.swing.JTextField();
        jbtnKreirajKupca = new javax.swing.JButton();
        jcmbMesto = new javax.swing.JComboBox();
        jbtnSacuvajKupca = new javax.swing.JButton();
        jbtnOdustani = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jpnlRacuniKupca = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRacuni = new javax.swing.JTable();
        jbtnDetalji = new javax.swing.JButton();
        jbtnObrisiRacun = new javax.swing.JButton();
        jbtnUnosRacuna = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lični podaci kupca"));

        jLabel1.setText("Kupac ID:");

        jLabel2.setText("Ime:");

        jLabel3.setText("Prezime:");

        jLabel4.setText("Telefon:");

        jLabel5.setText("Email:");

        jLabel6.setText("Mesto:");

        jtxtKupacID.setEditable(false);

        jbtnKreirajKupca.setText("Kreiraj kupca");
        jbtnKreirajKupca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnKreirajKupcaActionPerformed(evt);
            }
        });

        jcmbMesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtnSacuvajKupca.setText("Sačuvaj kupca");
        jbtnSacuvajKupca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajKupcaActionPerformed(evt);
            }
        });

        jbtnOdustani.setText("Odustani");
        jbtnOdustani.setToolTipText("");
        jbtnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOdustaniActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("u formatu: xxx/xxxxxxx");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnSacuvajKupca, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jbtnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtKupacID)
                            .addComponent(jtxtIme)
                            .addComponent(jtxtPrezime)
                            .addComponent(jtxtTelefon)
                            .addComponent(jtxtEmail)
                            .addComponent(jcmbMesto, 0, 229, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnKreirajKupca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtKupacID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnKreirajKupca))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcmbMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSacuvajKupca)
                    .addComponent(jbtnOdustani))
                .addContainerGap())
        );

        jpnlRacuniKupca.setBorder(javax.swing.BorderFactory.createTitledBorder("Računi kupca"));

        jtblRacuni.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblRacuni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblRacuniMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblRacuni);

        jbtnDetalji.setText("Detalji");
        jbtnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDetaljiActionPerformed(evt);
            }
        });

        jbtnObrisiRacun.setText("Obriši račun");
        jbtnObrisiRacun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiRacunActionPerformed(evt);
            }
        });

        jbtnUnosRacuna.setText("Unos računa");
        jbtnUnosRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUnosRacunaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlRacuniKupcaLayout = new javax.swing.GroupLayout(jpnlRacuniKupca);
        jpnlRacuniKupca.setLayout(jpnlRacuniKupcaLayout);
        jpnlRacuniKupcaLayout.setHorizontalGroup(
            jpnlRacuniKupcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jpnlRacuniKupcaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtnUnosRacuna)
                .addGap(18, 18, 18)
                .addComponent(jbtnObrisiRacun)
                .addGap(18, 18, 18)
                .addComponent(jbtnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnlRacuniKupcaLayout.setVerticalGroup(
            jpnlRacuniKupcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlRacuniKupcaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jpnlRacuniKupcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDetalji)
                    .addComponent(jbtnObrisiRacun)
                    .addComponent(jbtnUnosRacuna))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnlRacuniKupca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnlRacuniKupca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnKreirajKupcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnKreirajKupcaActionPerformed
        // TODO add your handling code here:
        try {
            Kupac kupac = kontroler.KontrolerKlijent.getInstance().kreirajKupca();
            prikaziNovogKupca(kupac);
            srediFormuKupacJeKreiran();
            prikaziPorukuObavestenja("Sistem je kreirao kupca");
            daLiJeKreiran = true;
        } catch (Exception e) {
            e.printStackTrace();
            prikaziPorukuGreske("Sistem ne može da kreira kupca");
        }
    }//GEN-LAST:event_jbtnKreirajKupcaActionPerformed

    private void jbtnSacuvajKupcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajKupcaActionPerformed
        // TODO add your handling code here:
        try {
            int kupacID = Integer.parseInt(jtxtKupacID.getText().trim());
            String ime = jtxtIme.getText().trim();
            String prezime = jtxtPrezime.getText().trim();
            String telefon = jtxtTelefon.getText().trim();
            String email = jtxtEmail.getText().trim();
            Mesto mesto = (Mesto) jcmbMesto.getSelectedItem();

            if (ime == null || ime.isEmpty()) {
                prikaziPorukuGreske("Niste uneli ime kupca!");
                return;
            }
            
            if (prezime == null || prezime.isEmpty()) {
                prikaziPorukuGreske("Niste uneli prezime kupca!");
                return;
            }

            if (telefon == null || telefon.isEmpty()) {
                prikaziPorukuGreske("Niste uneli telefon kupca!");
                return;
            }
            if (!email.isEmpty()) {
                if (email.startsWith("@") || email.endsWith("@")) {
                    prikaziPorukuGreske("Niste ispravno uneli email!");
                    return;
                }
            }

            Kupac kupac = new Kupac(kupacID, ime, prezime, telefon, email, mesto);
            if (kontroler.KontrolerKlijent.getInstance().getAktivan_sk() == util.Util.SK_UNOS) {
                kontroler.KontrolerKlijent.getInstance().zapamtiKupca(kupac);
                prikaziPorukuObavestenja("Sistem je zapamtio kupca!");
                srediFormuKupacNijeKreiran();
                obrisiPodatkeIzPolja();
            }

            if (kontroler.KontrolerKlijent.getInstance().getAktivan_sk() == util.Util.SK_IZMENA) {
                kontroler.KontrolerKlijent.getInstance().azurirajKupca(kupac);
                prikaziPorukuObavestenja("Sistem je zapamtio kupca!");
                dispose();
                kontroler.KontrolerKlijent.getInstance().osveziTabeluKupaca();

            }
        } catch (Exception ex) {
            if (ex.getMessage() != null && ex.getMessage().equals(util.Util.VEC_POSTOJI_PORUKA)) {
                prikaziPorukuGreske("Već je unet ovakav kupac!");
                return;
            }
            prikaziPorukuGreske("Sistem ne može da zapamti kupca!");

        }
    }//GEN-LAST:event_jbtnSacuvajKupcaActionPerformed

    private void jbtnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOdustaniActionPerformed
        // TODO add your handling code here:
        try {
            kontroler.KontrolerKlijent.getInstance().obrisiKupca(jtxtKupacID.getText());
            srediFormuKupacNijeKreiran();
            daLiJeKreiran = false;
            obrisiPodatkeIzPolja();
        } catch (Exception e) {
            prikaziPorukuGreske("Greška prilikom brisanja kreiranog kupca!");
        }
    }//GEN-LAST:event_jbtnOdustaniActionPerformed

    private void jbtnUnosRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUnosRacunaActionPerformed
        // TODO add your handling code here:
        kontroler.KontrolerKlijent.getInstance().setAktivan_sk(util.Util.SK_UNOS);
        new FmUnosRacuna(null, true).setVisible(true);
        try {
            osvezi();
        } catch (Exception ex) {
            Logger.getLogger(FmUnosKupca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnUnosRacunaActionPerformed

    private void jbtnObrisiRacunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiRacunActionPerformed
        // TODO add your handling code here:
        int red = jtblRacuni.getSelectedRow();
        if (red != -1) {
            try {
                Racun racun = ((ModelTabeleRacuni) jtblRacuni.getModel()).vratiRacun(red);
                kontroler.KontrolerKlijent.getInstance().obrisiRacun(racun.getRacunID() + "");
                prikaziPorukuObavestenja("Sistem je obrisao račun!");
                osvezi();
            } catch (Exception e) {
                prikaziPorukuGreske("Ssitem ne može da obriše račun!");
            }
        } else {
            prikaziPorukuGreske("Niste izabrali nijedan račun!");
        }
    }//GEN-LAST:event_jbtnObrisiRacunActionPerformed

    private void jbtnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDetaljiActionPerformed
        // TODO add your handling code here:
        preuzmiPodatkeSelektovanogRacuna(util.Util.SK_PRIKAZ);
    }//GEN-LAST:event_jbtnDetaljiActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (daLiJeKreiran) {
            try {
                kontroler.KontrolerKlijent.getInstance().obrisiKupca(jtxtKupacID.getText());
            } catch (Exception e) {
                prikaziPorukuGreske("Greška prilikom brisanja kreiranog kupca!");
            }

        }
    }//GEN-LAST:event_formWindowClosing

    private void jtblRacuniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblRacuniMouseClicked
        // TODO add your handling code here:
        jbtnDetalji.setVisible(true);
    }//GEN-LAST:event_jtblRacuniMouseClicked

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDetalji;
    private javax.swing.JButton jbtnKreirajKupca;
    private javax.swing.JButton jbtnObrisiRacun;
    private javax.swing.JButton jbtnOdustani;
    private javax.swing.JButton jbtnSacuvajKupca;
    private javax.swing.JButton jbtnUnosRacuna;
    private javax.swing.JComboBox jcmbMesto;
    private javax.swing.JPanel jpnlRacuniKupca;
    private javax.swing.JTable jtblRacuni;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtIme;
    private javax.swing.JTextField jtxtKupacID;
    private javax.swing.JTextField jtxtPrezime;
    private javax.swing.JTextField jtxtTelefon;
    // End of variables declaration//GEN-END:variables

    private void srediFormuPremaSK() throws Exception {
        int aktivan = kontroler.KontrolerKlijent.getInstance().getAktivan_sk();
        if (aktivan == util.Util.SK_UNOS) {
            srediFormuKupacNijeKreiran();
            this.setTitle("Unos podataka kupca");
        }

        if (aktivan == util.Util.SK_PRIKAZ) {
            jtxtKupacID.setEditable(false);
            jtxtIme.setEditable(false);
            jtxtPrezime.setEditable(false);
            jtxtTelefon.setEditable(false);
            jtxtEmail.setEditable(false);
            jcmbMesto.setEditable(false);
            jbtnKreirajKupca.setEnabled(false);
            jbtnOdustani.setEnabled(false);
            jbtnSacuvajKupca.setEnabled(false);
            jpnlRacuniKupca.setVisible(true);
            popuniTabeluRacuniKupca();

            prikaziPodatkeKupca(kontroler.KontrolerKlijent.getInstance().getSelektovanKupac());
            this.setTitle("Prikaz podataka kupca");

        }

        if (aktivan == util.Util.SK_IZMENA) {
            srediFormuKupacJeKreiran();
            jbtnKreirajKupca.setVisible(false);
            jbtnOdustani.setVisible(false);
            prikaziPodatkeKupca(kontroler.KontrolerKlijent.getInstance().getSelektovanKupac());
            this.setTitle("Izmena podataka kupca");

        }
    }

    private void srediFormuKupacNijeKreiran() {
        daLiJeKreiran = false;
        jtxtIme.setEnabled(false);
        jtxtPrezime.setEnabled(false);
        jtxtTelefon.setEnabled(false);
        jtxtEmail.setEnabled(false);
        jcmbMesto.setEnabled(false);
        jbtnOdustani.setEnabled(false);
        jbtnSacuvajKupca.setEnabled(false);
        jbtnKreirajKupca.setEnabled(true);

    }

    private void srediFormuKupacJeKreiran() {

        jtxtIme.setEnabled(true);
        jtxtPrezime.setEnabled(true);
        jtxtTelefon.setEnabled(true);
        jtxtEmail.setEnabled(true);
        jcmbMesto.setEnabled(true);
        jbtnOdustani.setEnabled(true);
        jbtnSacuvajKupca.setEnabled(true);
        jbtnKreirajKupca.setEnabled(false);

    }

    private void popuniComboBox() {
        try {
            List<OpstiDomenskiObjekat> lista = kontroler.KontrolerKlijent.getInstance().vratiListuMesta();
            popuniComboMesta(lista);

        } catch (Exception e) {
            prikaziPorukuGreske("Greška prilikom popunjavanja combo boxa");

        }
    }

    private void popuniComboMesta(List<OpstiDomenskiObjekat> lista) {
        jcmbMesto.removeAllItems();
        jcmbMesto.setModel(new DefaultComboBoxModel(lista.toArray()));
    }

    private void prikaziPorukuGreske(String poruka) {
        JOptionPane.showMessageDialog(this, poruka, "Greška!", JOptionPane.ERROR_MESSAGE);
    }

    private void prikaziNovogKupca(Kupac kupac) {
        jtxtKupacID.setText(kupac.getKupacID() + "");
    }

    private void prikaziPorukuObavestenja(String poruka) {
        JOptionPane.showMessageDialog(this, poruka, "Obaveštenje!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void obrisiPodatkeIzPolja() {
        jtxtIme.setText("");
        jtxtPrezime.setText("");
        jtxtTelefon.setText("");
        jtxtEmail.setText("");
        jcmbMesto.setSelectedIndex(0);
    }

    private void prikaziPodatkeKupca(Kupac selektovanKupac) {
        jtxtKupacID.setText(selektovanKupac.getKupacID() + "");
        jtxtIme.setText(selektovanKupac.getIme());
        jtxtPrezime.setText(selektovanKupac.getPrezime());
        jtxtTelefon.setText(selektovanKupac.getTelefon());
        jtxtEmail.setText(selektovanKupac.getEmail());
        jcmbMesto.setSelectedItem(selektovanKupac.getMesto());

    }

    private void popuniTabeluRacuniKupca() throws Exception {
        List<OpstiDomenskiObjekat> lista = kontroler.KontrolerKlijent.getInstance().pretraziRacuneKupca(kontroler.KontrolerKlijent.getInstance().getSelektovanKupac().getKupacID() + "");
        if (!lista.isEmpty()) {
            postaviModelTabele(lista);
        } else {
            postaviModelTabele(new ArrayList<OpstiDomenskiObjekat>());

        }
    }

    private void postaviModelTabele(List<OpstiDomenskiObjekat> lista) {
        jtblRacuni.setModel(new ModelTabeleRacuni(lista));
    }

    private void preuzmiPodatkeSelektovanogRacuna(int sk) {
        int red = jtblRacuni.getSelectedRow();
        if (red != -1) {
            try {
                Racun izabraniRacun = ((ModelTabeleRacuni) jtblRacuni.getModel()).vratiRacun(red);
                List<OpstiDomenskiObjekat> lista = kontroler.KontrolerKlijent.getInstance().pretraziRacune(izabraniRacun.getRacunID() + "");
                if (!lista.isEmpty()) {
                    Racun racunSaPodacima = (Racun) lista.get(0);
                    prikaziPorukuObavestenja("Sistem je pronašao račun!");
                    kontroler.KontrolerKlijent.getInstance().setAktivan_sk(sk);
                    kontroler.KontrolerKlijent.getInstance().setSelektovanRacun(racunSaPodacima);
                    new FmUnosRacuna(null, true).setVisible(true);
                } else {
                    prikaziPorukuGreske("Sistem ne može da nađe račun!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            prikaziPorukuGreske("Niste odabrali nijedan račun!");
        }
    }

    private void srediFormuInicijalno() {
        jbtnDetalji.setVisible(false);
        jpnlRacuniKupca.setEnabled(false);
        jpnlRacuniKupca.setVisible(false);
        int aktivan = kontroler.KontrolerKlijent.getInstance().getAktivan_sk();
        if(aktivan == util.Util.SK_PRIKAZ) {
          jpnlRacuniKupca.setVisible(true);
        }
    }

    private void osvezi() throws Exception {
        
                        
               List<OpstiDomenskiObjekat> lista = kontroler.KontrolerKlijent.getInstance().pretraziRacuneKupca(kontroler.KontrolerKlijent.getInstance().getSelektovanKupac().getKupacID() + "");
               if(!lista.isEmpty()) {    
                    postaviModelTabele(lista);
                } else {
                    postaviModelTabele(new ArrayList<OpstiDomenskiObjekat>());
                }

    }
       

}

