package Main.ABMTipoTarea;

import Main.DTOTipoTarea;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author FLIA HUDSON
 */
public class BajaTipoTarea extends javax.swing.JFrame {
    ControladorABMTipoTarea controladorABMTipoTarea;
    ABMTipoTarea abm;
    int parCodTipoTarea;
    int codTipoTarea;
    /**
     * Creates new form BajaTipoTarea
     */
    public BajaTipoTarea() {
        initComponents();
    }
    
    public void inicializaBaja(ControladorABMTipoTarea cont,ABMTipoTarea abmtt, int cod)
   {
       controladorABMTipoTarea=cont;
       abm=abmtt;
       parCodTipoTarea=cod;
       List<DTOTipoTarea> listadto = controladorABMTipoTarea.buscarTipoTarea(parCodTipoTarea);
       codTipoTareaTextField.setText((Integer.toString(cod)));
       nomActualTipoTarea.setText(listadto.get(0).getNombreTipoTarea());
       descActualTipoTarea.setText(listadto.get(0).getDescripcionTipoTarea()); 
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        descActualTipoTarea = new javax.swing.JTextField();
        nomActualTipoTarea = new javax.swing.JTextField();
        codTipoTareaTextField = new javax.swing.JTextField();
        bajaButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        label1.setText("Codigo del Tipo Tarea");

        label4.setText("Nombre actual del Tipo Tarea");

        label5.setText("Descripcion actual del Tipo Tarea");

        descActualTipoTarea.setEditable(false);

        nomActualTipoTarea.setEditable(false);
        nomActualTipoTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActualTipoTareaActionPerformed(evt);
            }
        });

        codTipoTareaTextField.setEditable(false);
        codTipoTareaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codTipoTareaTextFieldActionPerformed(evt);
            }
        });

        bajaButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bajaButton.setText("Confirmar Baja de Tipo Tarea");
        bajaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descActualTipoTarea, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bajaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomActualTipoTarea)
                            .addComponent(codTipoTareaTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codTipoTareaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomActualTipoTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descActualTipoTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bajaButton)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomActualTipoTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActualTipoTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActualTipoTareaActionPerformed

    private void codTipoTareaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codTipoTareaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codTipoTareaTextFieldActionPerformed

    private void bajaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaButtonActionPerformed
        //Intento obtener codTipoTarea
        try  {
            codTipoTarea = Integer.parseInt(codTipoTareaTextField.getText());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al ingresar codTipoTarea", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean exito;
        exito = controladorABMTipoTarea.darbajaTipoTarea(codTipoTarea);
        if (exito == true) {
        setVisible(false);
        dispose();
        abm.setVisible(true);
        }
    }//GEN-LAST:event_bajaButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        dispose();
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
            java.util.logging.Logger.getLogger(BajaTipoTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BajaTipoTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BajaTipoTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BajaTipoTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BajaTipoTarea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bajaButton;
    private javax.swing.JTextField codTipoTareaTextField;
    private javax.swing.JTextField descActualTipoTarea;
    private javax.swing.JButton jButton1;
    private java.awt.Label label1;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private javax.swing.JTextField nomActualTipoTarea;
    // End of variables declaration//GEN-END:variables
}
