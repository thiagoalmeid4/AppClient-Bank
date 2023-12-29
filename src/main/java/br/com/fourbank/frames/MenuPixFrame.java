package br.com.fourbank.frames;

import br.com.fourbank.models.TransactionHistoryModel;
import br.com.fourbank.services.ServiceRequest;
import br.com.fourbank.utils.SessionExpiry;
import cache.io.Cache;
import java.awt.Color;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author thiag
 */
public class MenuPixFrame extends javax.swing.JFrame {

    private ServiceRequest serviceRequest = new ServiceRequest();

    public MenuPixFrame() throws Exception {
        initComponents();
        initComponentsRequest();
    }
    
    public void initComponentsRequest() throws Exception{
        initTablePix();
    }

    private void initTablePix() throws Exception {
        Cache.clean("historico");
        
        var result = serviceRequest.getHistory();
        
        SessionExpiry.execute(Integer.parseInt(result.get("status").toString()), this);
        
        String[] columns = new String[this.tablePix.getColumnCount()];
        for (int i = 0; i != columns.length; i++) {
            columns[i] = this.tablePix.getColumnName(i);
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

        if (Integer.parseInt(result.get("status").toString()) == 200) {
            TransactionHistoryModel[] data = (TransactionHistoryModel[]) result.get("historico");
            for (var t : data) {
                if (t.getTypeTransaction().equals("PIX")) {
                    Object[] row = {t.getFlag(), t.getValue(), t.getOriginDestiny(), t.getDateTransaction()};
                    tableModel.addRow(row);
                }
            }
        }

        this.tablePix.setModel(tableModel);

        setColumnAlignment(tablePix, 0, DefaultTableCellRenderer.CENTER);
        setColumnAlignment(tablePix, 1, DefaultTableCellRenderer.CENTER);

        tablePix.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
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

        tablePix.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKeys = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePix = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        jPanel2.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 236, 236));
        jLabel9.setText("FourBank");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\thiag\\Downloads\\icons8-reinicialização-25.png")); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 561, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 720, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\thiag\\OneDrive\\Imagens\\bradesco_gradiente.png")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 720, 70);

        jToolBar1.setRollover(true);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.setForeground(new java.awt.Color(223, 84, 84));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\thiag\\Downloads\\email-35.png")); // NOI18N
        jButton1.setText("EMAIL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setForeground(new java.awt.Color(223, 84, 84));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\thiag\\Downloads\\icons8-celular-35.png")); // NOI18N
        jButton2.setText("CELULAR");
        jToolBar1.add(jButton2);

        jButton3.setForeground(new java.awt.Color(223, 84, 84));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\thiag\\Downloads\\icons8-identidade-35.png")); // NOI18N
        jButton3.setText("CPF");
        jToolBar1.add(jButton3);

        jButton4.setForeground(new java.awt.Color(223, 84, 84));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\thiag\\Downloads\\icons8-embaralhar-35.png")); // NOI18N
        jButton4.setText("ALEATÓRIA");
        jToolBar1.add(jButton4);

        tableKeys.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TIPO", "CHAVE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKeys.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableKeys);
        if (tableKeys.getColumnModel().getColumnCount() > 0) {
            tableKeys.getColumnModel().getColumn(0).setResizable(false);
            tableKeys.getColumnModel().getColumn(0).setPreferredWidth(10);
            tableKeys.getColumnModel().getColumn(1).setResizable(false);
            tableKeys.getColumnModel().getColumn(1).setPreferredWidth(500);
        }

        tablePix.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "\u2b83", "VALOR R$", "ORIGEM/DESTINO", "DATA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablePix);
        if (tablePix.getColumnModel().getColumnCount() > 0) {
            tablePix.getColumnModel().getColumn(0).setResizable(false);
            tablePix.getColumnModel().getColumn(0).setPreferredWidth(10);
            tablePix.getColumnModel().getColumn(1).setResizable(false);
            tablePix.getColumnModel().getColumn(1).setPreferredWidth(500);
            tablePix.getColumnModel().getColumn(2).setResizable(false);
            tablePix.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton5.setForeground(new java.awt.Color(223, 84, 84));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\thiag\\Downloads\\icons8-chave-35.png")); // NOI18N
        jButton5.setText("CADASTRAR CHAVE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setForeground(new java.awt.Color(223, 84, 84));
        jButton6.setText("< Voltar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel3.setText("Transações Pix");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButton6)
                .addGap(7, 7, 7))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            initComponentsRequest();
        } catch (Exception ex) {
            Logger.getLogger(MenuPixFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            new HomeFrame().setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(MenuPixFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new SaveKeyFrame().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       new PixEmail().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPixFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPixFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPixFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPixFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuPixFrame().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MenuPixFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tableKeys;
    private javax.swing.JTable tablePix;
    // End of variables declaration//GEN-END:variables
}
