package Main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FLIA HUDSON
 */
public class ConsultaTareas extends javax.swing.JFrame {
    ControladorABMTipoInstancia controladorABMTI;
    DTOTipoInstancia tipoinstancia;
    javax.swing.table.DefaultTableModel miTabla=new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Tipo Tarea","Nombre Tipo Tarea", "Descripción Tipo Tarea", "Fin Vigencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
    /**
     * Creates new form ConsultaTareas
     */
    public ConsultaTareas() {
        initComponents();
    }
    public void inicializaconsulta(ControladorABMTipoInstancia cont,DTOTipoInstancia undto){
       controladorABMTI=cont;
       tipoinstancia = undto;
       codTITextField.setText((Integer.toString(undto.getCodTipoInstancia())));
       nomTITextField.setText(undto.getNombreTipoInstancia());
       nomSectorTextField.setText(undto.getNombreSector());
       List <DTOTipoTarea> listatipotarea = ordenaDTOTipoTarea(undto.getListaDTOTipoTarea());
         for (int i=0;i<listatipotarea.size();i++)
        {
            DTOTipoTarea untipotarea = listatipotarea.get(i);
            miTabla.addRow(new Object[]{untipotarea.getCodTipoTarea(),untipotarea.getNombreTipoTarea(),untipotarea.getDescripcionTipoTarea(),untipotarea.getFechaFinVigenciaTipoTarea()});
            TablaTipoInstancias.setModel(miTabla);
        }
    }
     private  List<DTOTipoTarea> ordenaDTOTipoTarea(List<DTOTipoTarea> listadtoTipoTarea)
    {
        List<DTOTipoTarea> ordenado,aux;
        ordenado=new ArrayList<DTOTipoTarea>();
        aux= new ArrayList<DTOTipoTarea>();
        for (int i=0; i< listadtoTipoTarea.size();i++)
        {
            aux.add(listadtoTipoTarea.get(i));
        }
        for (int i=0; i< listadtoTipoTarea.size();i++)
        {
            int ultCod=0;
            DTOTipoTarea saux=null;
            for(int j=0;j<aux.size();j++)
            {
                if(ultCod ==0)
                {
                    ultCod=aux.get(j).getCodTipoTarea();
                    saux=aux.get(j);
                }
                if (ultCod >aux.get(j).getCodTipoTarea())
                {
                    ultCod=aux.get(j).getCodTipoTarea();
                    saux=aux.get(j);
                }
            }
            ordenado.add(saux);
            aux.remove(saux);
        }
         return ordenado; 
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codTITextField = new javax.swing.JTextField();
        nomTITextField = new javax.swing.JTextField();
        nomSectorTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaTipoInstancias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información Tipo Instancia");

        jLabel1.setText("Código Tipo Instancia:");

        jLabel2.setText("Nombre Tipo Instancia:");

        jLabel3.setText("Sector:");

        codTITextField.setEditable(false);
        codTITextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codTITextFieldActionPerformed(evt);
            }
        });

        nomTITextField.setEditable(false);
        nomTITextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomTITextFieldActionPerformed(evt);
            }
        });

        nomSectorTextField.setEditable(false);
        nomSectorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomSectorTextFieldActionPerformed(evt);
            }
        });

        backButton.setText("Volver");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        TablaTipoInstancias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código Tipo Tarea", "Nombre Tipo Tarea", "Descripcion Tipo Tarea", "Fin Vigencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaTipoInstancias.setColumnSelectionAllowed(true);
        TablaTipoInstancias.setRowHeight(20);
        jScrollPane3.setViewportView(TablaTipoInstancias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codTITextField, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(nomSectorTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(nomTITextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codTITextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomTITextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nomSectorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codTITextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codTITextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codTITextFieldActionPerformed

    private void nomTITextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomTITextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomTITextFieldActionPerformed

    private void nomSectorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomSectorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomSectorTextFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
       setVisible(false);
       dispose(); 
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaTareas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaTipoInstancias;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField codTITextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nomSectorTextField;
    private javax.swing.JTextField nomTITextField;
    // End of variables declaration//GEN-END:variables
}
