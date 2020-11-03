package Main.ABMTipoInstancia;

import Main.DTOTipoInstancia;
import Main.DTOTipoTarea;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author FLIA HUDSON
 */
public class BajaTipoInstancia extends javax.swing.JFrame {
    ControladorABMTipoInstancia controladorABMTipoInstancia;
    ABMTipoInstancia abmTI;
    int parCodTipoInstancia;
    int codTipoInstancia;
    List<DTOTipoTarea> listatareas;
    javax.swing.table.DefaultTableModel miTablaDisponibles=new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código TT","Nombre Tipo Tarea"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };    
    /**
     * Creates new form BajaSector
     */
    public BajaTipoInstancia() {
        initComponents();
    }
    
    public void inicializaBaja(ControladorABMTipoInstancia cont,ABMTipoInstancia abm, int cod)
   {
       abmTI = abm;
       controladorABMTipoInstancia=cont;
       parCodTipoInstancia=cod;
       List<DTOTipoInstancia> listadto = controladorABMTipoInstancia.buscarTipoInstancias(parCodTipoInstancia);
       codbajaTipoInstanciaTextField.setText((Integer.toString(listadto.get(0).getCodTipoInstancia())));
       nomBajaTipoInstanciaTextField.setText(listadto.get(0).getNombreTipoInstancia());
       nomSectorBajaTipoInstanciaTextField.setText(listadto.get(0).getNombreSector());
       listatareas = listadto.get(0).getListaDTOTipoTarea();
        for (int i=0;i<listatareas.size();i++)
        {
            DTOTipoTarea unTipoTarea = listatareas.get(i);
            miTablaDisponibles.addRow(new Object[]{unTipoTarea.getCodTipoTarea(),unTipoTarea.getNombreTipoTarea()});
            TiposTareaVigentesTable.setModel(miTablaDisponibles);
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        codbajaTipoInstanciaTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nomBajaTipoInstanciaTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TiposTareaVigentesTable = new javax.swing.JTable();
        nomSectorBajaTipoInstanciaTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BajaButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Baja Tipo Instancia");

        jLabel1.setText("Código Tipo Instancia:");

        codbajaTipoInstanciaTextField.setEditable(false);
        codbajaTipoInstanciaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codbajaTipoInstanciaTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Tipo Instancia:");

        nomBajaTipoInstanciaTextField.setEditable(false);
        nomBajaTipoInstanciaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomBajaTipoInstanciaTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Sector Tipo Instancia:");

        TiposTareaVigentesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo TT", "Nombre Tipo Tarea"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TiposTareaVigentesTable.setEnabled(false);
        TiposTareaVigentesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TiposTareaVigentesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TiposTareaVigentesTable);
        if (TiposTareaVigentesTable.getColumnModel().getColumnCount() > 0) {
            TiposTareaVigentesTable.getColumnModel().getColumn(0).setMinWidth(10);
            TiposTareaVigentesTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        }

        nomSectorBajaTipoInstanciaTextField.setEditable(false);
        nomSectorBajaTipoInstanciaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomSectorBajaTipoInstanciaTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Tareas asignadas:");

        BajaButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BajaButton.setText("Confirmar Baja de Tipo Instancia");
        BajaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BajaButtonActionPerformed(evt);
            }
        });

        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(codbajaTipoInstanciaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(nomBajaTipoInstanciaTextField)
                                    .addComponent(nomSectorBajaTipoInstanciaTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BajaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codbajaTipoInstanciaTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomBajaTipoInstanciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomSectorBajaTipoInstanciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(3, 3, 3)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BajaButton)
                    .addComponent(volverButton))
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void codbajaTipoInstanciaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codbajaTipoInstanciaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codbajaTipoInstanciaTextFieldActionPerformed

    private void nomBajaTipoInstanciaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomBajaTipoInstanciaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomBajaTipoInstanciaTextFieldActionPerformed

    private void nomSectorBajaTipoInstanciaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomSectorBajaTipoInstanciaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomSectorBajaTipoInstanciaTextFieldActionPerformed

    private void BajaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BajaButtonActionPerformed
        try  {
            codTipoInstancia = Integer.parseInt(codbajaTipoInstanciaTextField.getText());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al ingresar codSector", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Boolean exito = controladorABMTipoInstancia.darbajaTipoInstancia(codTipoInstancia);
        if (exito == true) {
        setVisible(false);
        dispose();
        abmTI.setVisible(true);
        }
    }//GEN-LAST:event_BajaButtonActionPerformed

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        setVisible(false);
        dispose();  
    }//GEN-LAST:event_volverButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BajaTipoInstancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BajaTipoInstancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BajaTipoInstancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BajaTipoInstancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BajaTipoInstancia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BajaButton;
    private javax.swing.JTable TiposTareaVigentesTable;
    private javax.swing.JTextField codbajaTipoInstanciaTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nomBajaTipoInstanciaTextField;
    private javax.swing.JTextField nomSectorBajaTipoInstanciaTextField;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
