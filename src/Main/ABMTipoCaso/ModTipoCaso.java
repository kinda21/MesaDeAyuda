package Main.ABMTipoCaso;


import Main.DTOTipoCaso;
import Main.DTOTipoCasoIteracion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;
/**
 *
 * @author FLIA HUDSON
 */
public class ModTipoCaso extends javax.swing.JFrame {
    ControladorTipoCaso controladorABMtc;
    ABMTipoCaso abm;
    int parCodTC, maxiteraciones;
    List <DTOTipoCasoIteracion> listaiteracionesoriginal, listaiteracionesamodificar;
    String nomTC;
    javax.swing.table.DefaultTableModel miTablaIteraciones=new javax.swing.table.DefaultTableModel(
        new Object [][] {

            },
        new String [] {
                "N° Iteración","Coeficiente de Reducción"
            }
        ) {
        boolean[] canEdit = new boolean [] {
                false,false
            };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
        }
    };
   public void inicializaModificar(ControladorTipoCaso cont,ABMTipoCaso abmtc, int cod)
   {
       controladorABMtc=cont;
       abm=abmtc;
       parCodTC=cod;
       listaiteracionesamodificar = new ArrayList();
       List<DTOTipoCaso> dtoCaso = controladorABMtc.buscarTipoCasos("",Integer.toString(parCodTC));
       codTCTextField.setText(Integer.toString(dtoCaso.get(0).getCodTipoCaso()));
       nomTCTextField.setText(dtoCaso.get(0).getNombreTipoCaso());
       maxiteraciones = dtoCaso.get(0).getNumeroMaximaIteracion()+1;
       numIteracionTextField.setText(Integer.toString(dtoCaso.get(0).getNumeroMaximaIteracion()+1));
       listaiteracionesoriginal = ordenaDTOIteraciones(dtoCaso.get(0).getListaTipoCasoIteracion());
       listaiteracionesamodificar = listaiteracionesoriginal;
       poblarTablaIteraciones(listaiteracionesoriginal);
   }
   public void poblarTablaIteraciones (List<DTOTipoCasoIteracion> listaiteraciones) {
        List<DTOTipoCasoIteracion> listaordenada = ordenaDTOIteraciones(listaiteraciones);
        miTablaIteraciones.setRowCount(0);
        for (int i=0;i<listaordenada.size();i++)
        {
            DTOTipoCasoIteracion unaiteracion = listaordenada.get(i);
            miTablaIteraciones.addRow(new Object[]{unaiteracion.getNumeroDeIteracion(),unaiteracion.getCoeficienteReduccionTipo()});
        }
        IteracionesTable.setModel(miTablaIteraciones);
    }
    private  List<DTOTipoCasoIteracion> ordenaDTOIteraciones(List<DTOTipoCasoIteracion> listaiteraciones)
    {
        List<DTOTipoCasoIteracion> ordenado,aux;
        ordenado=new ArrayList<DTOTipoCasoIteracion>();
        aux= new ArrayList<DTOTipoCasoIteracion>();
        for (int i=0; i< listaiteraciones.size();i++)
        {
            aux.add(listaiteraciones.get(i));
        }
        for (int i=0; i< listaiteraciones.size();i++)
        {
            int ultCod=0;
            DTOTipoCasoIteracion saux=null;
            for(int j=0;j<aux.size();j++)
            {
                if(ultCod ==0)
                {
                    ultCod=aux.get(j).getNumeroDeIteracion();
                    saux=aux.get(j);
                }
                if (ultCod >aux.get(j).getNumeroDeIteracion())
                {
                    ultCod=aux.get(j).getNumeroDeIteracion();
                    saux=aux.get(j);
                }
            }
            ordenado.add(saux);
            aux.remove(saux);
        }
         return ordenado; 
    }
    /**
     * Creates new form ModSector
     */
    public ModTipoCaso() {
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

        codTCTextField = new javax.swing.JTextField();
        nomTCTextField = new javax.swing.JTextField();
        numIteracionTextField = new javax.swing.JTextField();
        modButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        coefReduccionTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        IteracionesTable = new javax.swing.JTable();
        addCoefRedux = new javax.swing.JButton();
        removeCoefRedux = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Tipo Caso");

        codTCTextField.setEditable(false);
        codTCTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codTCTextFieldActionPerformed(evt);
            }
        });

        nomTCTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomTCTextFieldActionPerformed(evt);
            }
        });

        numIteracionTextField.setEditable(false);
        numIteracionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numIteracionTextFieldActionPerformed(evt);
            }
        });

        modButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        modButton.setText("Modificar Tipo Caso");
        modButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("N° Máxima Iteracion:");

        jLabel2.setText("Nuevo nombre del Tipo Caso:");

        jLabel3.setText("Codigo Tipo Caso:");

        jLabel4.setText("Coeficiente de Reduccion:");

        coefReduccionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coefReduccionTextFieldActionPerformed(evt);
            }
        });

        IteracionesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "N°Iteracion", "Coeficiente de Reducción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(IteracionesTable);

        addCoefRedux.setText("Agregar Coeficiente");
        addCoefRedux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCoefReduxActionPerformed(evt);
            }
        });

        removeCoefRedux.setText("Limpiar Lista Iteraciones");
        removeCoefRedux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCoefReduxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomTCTextField)
                            .addComponent(codTCTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(modButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(addCoefRedux, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(removeCoefRedux, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 75, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coefReduccionTextField)
                                    .addComponent(numIteracionTextField)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(codTCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomTCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numIteracionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coefReduccionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCoefRedux)
                    .addComponent(removeCoefRedux))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void modButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modButtonActionPerformed
        try  {
            parCodTC = Integer.parseInt(codTCTextField.getText());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al ingresar el código Tipo Caso", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int maxiteracionesmod;
        try  {
            maxiteracionesmod = listaiteracionesamodificar.size();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "El maximo de iteraciones ingresado debe ser un numero entero no negativo", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }           
        nomTC = nomTCTextField.getText();
        Boolean exito;
        exito = controladorABMtc.modificarTipoCaso(parCodTC, nomTC, maxiteracionesmod,listaiteracionesamodificar);
        if (exito == true) {
        setVisible(false);
        dispose();
        abm.setVisible(true);
        } 
    }//GEN-LAST:event_modButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
       setVisible(false);
       dispose();  
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void codTCTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codTCTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codTCTextFieldActionPerformed

    private void nomTCTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomTCTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomTCTextFieldActionPerformed

    private void numIteracionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numIteracionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numIteracionTextFieldActionPerformed

    private void coefReduccionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coefReduccionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coefReduccionTextFieldActionPerformed

    private void addCoefReduxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCoefReduxActionPerformed
        int coeficiente,numero;
        try  {
            coeficiente=(Integer.parseInt(coefReduccionTextField.getText()));
            numero=(Integer.parseInt(numIteracionTextField.getText()));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "El coeficiente debe ser un número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DTOTipoCasoIteracion undto = new DTOTipoCasoIteracion();
        undto.setNumeroDeIteracion(numero);
        undto.setCoeficienteReduccionTipo(coeficiente);
        listaiteracionesamodificar.add(undto);
        maxiteraciones++;
        numIteracionTextField.setText(Integer.toString(maxiteraciones));
        poblarTablaIteraciones(listaiteracionesamodificar);
    }//GEN-LAST:event_addCoefReduxActionPerformed

    private void removeCoefReduxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCoefReduxActionPerformed
        listaiteracionesamodificar.clear();
        maxiteraciones=1;
        numIteracionTextField.setText(Integer.toString(maxiteraciones));
        poblarTablaIteraciones(listaiteracionesamodificar);
    }//GEN-LAST:event_removeCoefReduxActionPerformed

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
            java.util.logging.Logger.getLogger(ModTipoCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModTipoCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModTipoCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModTipoCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModTipoCaso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable IteracionesTable;
    private javax.swing.JButton addCoefRedux;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField codTCTextField;
    private javax.swing.JTextField coefReduccionTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modButton;
    private javax.swing.JTextField nomTCTextField;
    private javax.swing.JTextField numIteracionTextField;
    private javax.swing.JButton removeCoefRedux;
    // End of variables declaration//GEN-END:variables
}
