package view;

import handler.Action;
import handler.Table;
import model.Invoice;
import model.Line;
import model.Tableheader;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Aratech
 */
public class frame extends javax.swing.JFrame {

    /**
     * Creates new form InvoiceJFram
     */
    public frame() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        invHTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        invLTable = new javax.swing.JTable();
        createInvoiceButton = new javax.swing.JButton();
        createInvoiceButton.addActionListener(actionListener);
        deleteInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton.addActionListener(actionListener);
        createLineButton = new javax.swing.JButton();
        createLineButton.addActionListener(actionListener);
        deleteLineButton = new javax.swing.JButton();
        deleteLineButton.addActionListener(actionListener);
        invNumLbl0 = new javax.swing.JLabel();
        invDateLbl = new javax.swing.JLabel();
        custNameLbl = new javax.swing.JLabel();
        invTotalLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(actionListener);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(actionListener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invHTable.setModel(new javax.swing.table.DefaultTableModel(
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
        invHTable.getSelectionModel().addListSelectionListener(selectionListener);
        jScrollPane1.setViewportView(invHTable);

        invLTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(invLTable);

        createInvoiceButton.setText("Create New Invoice");

        deleteInvoiceButton.setText("Delete Invoice");
        deleteInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvoiceButtonActionPerformed(evt);
            }
        });

        createLineButton.setText("New Item");
        createLineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createLineButtonActionPerformed(evt);
            }
        });

        deleteLineButton.setText("Delete Item");
        deleteLineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLineButtonActionPerformed(evt);
            }
        });

        invNumLbl0.setText(".............................");

        invDateLbl.setText(".............................");

        custNameLbl.setText(".............................");

        invTotalLbl.setText(".............................");

        jLabel1.setText("Invoice Number:");

        jLabel2.setText("Invoice Date:");

        jLabel3.setText("Customer Name:");

        jLabel4.setText("Invoice Total:");

        jMenu1.setText("File");

        loadMenuItem.setText("Load File");
        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save File");
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel4))
                                                                .addGap(78, 78, 78)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(invDateLbl)
                                                                        .addComponent(invNumLbl0)
                                                                        .addComponent(custNameLbl)
                                                                        .addComponent(invTotalLbl)))
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addComponent(createInvoiceButton)
                                                .addGap(29, 29, 29)
                                                .addComponent(deleteInvoiceButton)
                                                .addGap(129, 129, 129)
                                                .addComponent(createLineButton)
                                                .addGap(39, 39, 39)
                                                .addComponent(deleteLineButton)))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invNumLbl0)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invDateLbl)
                                                        .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(custNameLbl)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invTotalLbl)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(createInvoiceButton)
                                        .addComponent(deleteInvoiceButton)
                                        .addComponent(createLineButton)
                                        .addComponent(deleteLineButton))
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createLineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createLineButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createLineButtonActionPerformed

    private void deleteLineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLineButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteLineButtonActionPerformed

    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadMenuItemActionPerformed

    private void deleteInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvoiceButtonActionPerformed

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
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvoiceButton;
    private javax.swing.JButton createLineButton;
    private javax.swing.JLabel custNameLbl;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteLineButton;
    private javax.swing.JLabel invDateLbl;
    private javax.swing.JTable invHTable;
    private javax.swing.JTable invLTable;
    private javax.swing.JLabel invNumLbl0;
    private javax.swing.JLabel invTotalLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    private Action actionListener = new Action (this);
    private ArrayList<Invoice> invoicesArray;
    private ArrayList<Line> linesArray;
    private Tableheader TableheaderModel;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private Table selectionListener = new Table(this);

    public ArrayList<Line> getLinesArray() {
        return linesArray;
    }

    public void setLinesArray(ArrayList<Line> linesArray) {
        this.linesArray = linesArray;
    }

    public void setInvoicesArray(ArrayList<Invoice> invoicesArray) {
        this.invoicesArray = invoicesArray;
    }

    public ArrayList<Invoice> getInvoicesArray() {
        return invoicesArray;
    }

    public Invoice getInvObject(int code) {
        for (Invoice inv : invoicesArray) {
            if (inv.getInvoiceNumber() == code) {
                return inv;
            }
        }
        return null;
    }

    public Tableheader getTableheaderModel() {
        return TableheaderModel;
    }

    public void setTableheaderModel(Tableheader TableheaderModel) {
        this.TableheaderModel = TableheaderModel;
    }

    public JTable getinvHTable() {
        return invHTable;
    }

    public JTable getInvLTable() {
        return invLTable;
    }

    public JLabel getCustNameLbl() {
        return custNameLbl;
    }

    public JLabel getInvDateLbl() {
        return invDateLbl;
    }

    public JLabel getInvNumLbl() {
        return invNumLbl0;
    }

    public JLabel getInvTotaLbl() {
        return invTotalLbl;
    }

    public Action getActionListener() {
        return actionListener;
    }





}