package br.com.fourbank.frames;

import br.com.fourbank.models.AccountInfo;
import br.com.fourbank.models.TransactionHistoryModel;
import br.com.fourbank.services.ServiceRequest;
import br.com.fourbank.utils.SessionExpiry;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author thiag
 */
public class HomeFrame extends javax.swing.JFrame {

    private ServiceRequest serviceRequest = new ServiceRequest();

    public HomeFrame() throws Exception {
        initComponents();
        initComponentsRequests();
    }

    private void initComponentsRequests() throws Exception {
        initInfoAccount();
        initTableTransactionHistory();
        initDate();

    }

    private void initInfoAccount() throws Exception {

        var result = serviceRequest.getInfoAccount();

        if (Integer.parseInt(result.get("status").toString()) == 200) {
            AccountInfo accountInfo = (AccountInfo) result.get("infoConta");
            fieldAgency.setText(accountInfo.getAccountAgency());
            fieldAccount.setText(addLastChar(accountInfo.getAccountNumber(), '-'));
            fieldBalance.setText("R$ " + accountInfo.getValue().toString());
            fieldNameCustomer.setText(accountInfo.getCustomerName());
        } else {
            System.out.println(result.get("erro").toString());
        }

    }

    private void initTableTransactionHistory() throws Exception {
        String[] columns = new String[this.tableTransactions.getColumnCount()];
        for (int i = 0; i != columns.length; i++) {
            columns[i] = this.tableTransactions.getColumnName(i);
        }

        var tableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };

        var result = serviceRequest.getHistory();

        if (Integer.parseInt(result.get("status").toString()) == 200) {
            TransactionHistoryModel[] data = (TransactionHistoryModel[]) result.get("historico");
            for (var t : data) {
                Object[] row = {t.getFlag(), t.getValue(), t.getOriginDestiny(), t.getTypeTransaction(), t.getDateTransaction()};
                tableModel.addRow(row);
            }
        }

        this.tableTransactions.setModel(tableModel);

        setColumnWidths(tableTransactions, new int[]{10, 20, 150, 20, 150});

        setColumnAlignment(tableTransactions, 0, DefaultTableCellRenderer.CENTER);
        setColumnAlignment(tableTransactions, 1, DefaultTableCellRenderer.CENTER);
        setColumnAlignment(tableTransactions, 3, DefaultTableCellRenderer.CENTER);

        tableTransactions.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                String typeFlag = (String) tableModel.getValueAt(row, 0);
                if ("Entrada".equals(typeFlag)) {
                    c.setForeground(new Color(102, 205, 170));
                } else {
                    c.setForeground(new Color(139, 0, 0));
                }
                return c;
            }
        });

        tableTransactions.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                String typeFlag = (String) tableModel.getValueAt(row, 0);
                if ("Entrada".equals(typeFlag)) {
                    c.setForeground(new Color(102, 205, 170));
                } else {
                    c.setForeground(new Color(139, 0, 0));
                }
                return c;
            }
        });

    }

    private void initDate() {
        // Obtém a data e hora atuais
        LocalDateTime agora = LocalDateTime.now();

        // Define o formato desejado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEE, dd/MM/yyyy", new Locale("pt", "BR"));

        // Formata a data e hora
        String dataHoraFormatada = agora.format(formato).toUpperCase().replace(".", "");

        fieldDate.setText(dataHoraFormatada);
    }

    private void setColumnWidths(JTable table, int[] widths) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < widths.length && i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(widths[i]);
        }
    }

    private void setColumnAlignment(JTable table, int column, int alignment) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(alignment);

        table.getColumnModel().getColumn(column).setCellRenderer(renderer);
    }

    private static String addLastChar(String input, char caractere) {
        if (input != null && !input.isEmpty()) {
            return input.substring(0, input.length() - 1) + caractere + input.charAt(input.length() - 1);
        } else {
            return input;
        }
    }

    private boolean session() throws Exception {
        if (!SessionExpiry.execute()) {
            JOptionPane.showMessageDialog(null, "Sessão Expirada!", null, JOptionPane.INFORMATION_MESSAGE);
            new LoginFrame().setVisible(true);
            this.dispose();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        fieldNameCustomer = new javax.swing.JLabel();
        fieldAgency = new javax.swing.JLabel();
        fieldAccount = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldBalance = new javax.swing.JLabel();
        fieldDate = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTransactions = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        jPanel3.setOpaque(false);

        fieldNameCustomer.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        fieldNameCustomer.setForeground(new java.awt.Color(236, 236, 236));
        fieldNameCustomer.setText("{Nome_cliente}");

        fieldAgency.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        fieldAgency.setForeground(new java.awt.Color(236, 236, 236));
        fieldAgency.setText("{agencia}");

        fieldAccount.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        fieldAccount.setForeground(new java.awt.Color(236, 236, 236));
        fieldAccount.setText("{conta}");

        jSeparator1.setBackground(new java.awt.Color(238, 235, 235));
        jSeparator1.setForeground(new java.awt.Color(227, 227, 227));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel4.setOpaque(false);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-sair-30.png"))); // NOI18N
        jLabel5.setText("Sair");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 236, 236));
        jLabel6.setText("Saldo disponível");

        fieldBalance.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        fieldBalance.setForeground(new java.awt.Color(236, 236, 236));
        fieldBalance.setText("{saldo}");

        fieldDate.setBackground(new java.awt.Color(255, 255, 255));
        fieldDate.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        fieldDate.setForeground(new java.awt.Color(232, 232, 232));
        fieldDate.setText("{data}");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 236, 236));
        jLabel9.setText("FourBank");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-reinicialização-25.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNameCustomer)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fieldAgency)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldAccount)))
                .addGap(55, 55, 55)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(fieldBalance))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(fieldNameCustomer)
                                    .addGap(15, 15, 15)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fieldAgency)
                                        .addComponent(fieldAccount))))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(fieldDate)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 720, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bradesco_gradiente.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 720, 70);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tableTransactions.setFont(new java.awt.Font("sansserif", 1, 11)); // NOI18N
        tableTransactions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "\u2b83", "VALOR R$", "ORIGEM/DESTINO", "TIPO", "DATA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTransactions.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tableTransactions.setAutoscrolls(false);
        tableTransactions.setDragEnabled(true);
        tableTransactions.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableTransactions.setShowGrid(true);
        tableTransactions.getTableHeader().setResizingAllowed(false);
        tableTransactions.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableTransactions);
        tableTransactions.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tableTransactions.getColumnModel().getColumnCount() > 0) {
            tableTransactions.getColumnModel().getColumn(0).setResizable(false);
            tableTransactions.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableTransactions.getColumnModel().getColumn(1).setResizable(false);
            tableTransactions.getColumnModel().getColumn(1).setPreferredWidth(5);
            tableTransactions.getColumnModel().getColumn(2).setResizable(false);
            tableTransactions.getColumnModel().getColumn(2).setPreferredWidth(200);
            tableTransactions.getColumnModel().getColumn(3).setResizable(false);
            tableTransactions.getColumnModel().getColumn(3).setPreferredWidth(1);
            tableTransactions.getColumnModel().getColumn(4).setResizable(false);
            tableTransactions.getColumnModel().getColumn(4).setPreferredWidth(120);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pix-35.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-transferir-35.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            if (session()) {
                initComponentsRequests();
            }
        } catch (Exception ex) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (session()) {
                new MenuPixFrame().setVisible(true);
                this.dispose();
            }
        } catch (Exception ex) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if(session()){
                var tedFrame = new TedFrame(this);
                tedFrame.setVisible(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            UIManager.setLookAndFeel(new FlatLightLaf());
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        new HomeFrame().setVisible(true);
                    } catch (Exception ex) {
                        Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fieldAccount;
    private javax.swing.JLabel fieldAgency;
    private javax.swing.JLabel fieldBalance;
    private javax.swing.JLabel fieldDate;
    private javax.swing.JLabel fieldNameCustomer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableTransactions;
    // End of variables declaration//GEN-END:variables
}
