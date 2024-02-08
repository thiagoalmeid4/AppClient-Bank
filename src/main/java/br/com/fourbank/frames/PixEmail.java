package br.com.fourbank.frames;

import br.com.fourbank.models.AccountDestinyModel;
import br.com.fourbank.models.TransactionPixModel;
import br.com.fourbank.models.TransactionResponseModel;
import br.com.fourbank.services.ServiceRequest;
import br.com.fourbank.utils.MoneyFormat;
import br.com.fourbank.utils.PdfUtils;
import br.com.fourbank.utils.SessionExpiry;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class PixEmail extends JDialog {

    private ServiceRequest serviceRequest = new ServiceRequest();
    
    private Frame previousFrame;
    
    public PixEmail(Frame parent) {
        super(parent,true);
        this.previousFrame = parent;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        fieldKey = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        fieldDestiny = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        fieldValue = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        jPanel2.setOpaque(false);

        fieldKey.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EMAIL");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-pesquisar-35.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("VALOR R$");

        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("DESTINO:");

        fieldDestiny.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fieldDestiny.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setForeground(new java.awt.Color(223, 84, 84));
        jButton2.setText("ENVIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        fieldValue.setForeground(new java.awt.Color(51, 51, 51));
        fieldValue.setFormatterFactory(MoneyFormat.getMoneyFormatter());
        fieldValue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(label)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fieldDestiny, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fieldKey, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addContainerGap(155, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(26, 26, 26))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldKey))
                .addGap(18, 18, 18)
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 300);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bradesco_gradiente.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private boolean session() throws Exception {
        if (!SessionExpiry.execute()) {
            JOptionPane.showMessageDialog(null, "Sessão Expirada!", null, JOptionPane.INFORMATION_MESSAGE);
            new LoginFrame().setVisible(true);
            this.dispose();
            this.previousFrame.dispose();
            return false;
        }
        return true;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (session()) {
                if (!fieldKey.getText().contains("@")) {
                    JOptionPane.showMessageDialog(null, "Email inválido", null, JOptionPane.WARNING_MESSAGE);
                } else {
                    var result = serviceRequest.getAccountByPix(fieldKey.getText());
                    if (Integer.parseInt(result.get("status").toString()) != 200) {
                        JOptionPane.showMessageDialog(null, result.get("erro"), null, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        AccountDestinyModel account = (AccountDestinyModel) result.get("contaDestino");
                        fieldDestiny.setText(account.getName());
                    }
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(PixEmail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (session()) {
                String key = fieldKey.getText();
                double valuePix = MoneyFormat.getValue(fieldValue.getText());
                var pixTransaction = new TransactionPixModel(
                        valuePix,
                        key);
                var result = serviceRequest.transactionByPix(pixTransaction);
                if (Integer.parseInt(result.get("status").toString()) != 200) {
                    JOptionPane.showMessageDialog(null, result.get("erro"), null, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    TransactionResponseModel transacao = (TransactionResponseModel) result.get("transacao");
                    PdfUtils.gerarEVisualizarPDF(transacao.getDateTransaction(), transacao.getCustomerNameOrigin(),
                            transacao.getCustomerNameDestiny(), transacao.getValue().toString(),
                            transacao.getTypeTransaction(), transacao.getIdTransaction());
                    this.dispose();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PixEmail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fieldDestiny;
    private javax.swing.JTextField fieldKey;
    private javax.swing.JFormattedTextField fieldValue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
