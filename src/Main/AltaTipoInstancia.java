package Main;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author FLIA HUDSON
 */
public class AltaTipoInstancia extends javax.swing.JFrame {
    ControladorABMTipoInstancia controladorABMTI;
    ABMTipoInstancia abmTI;
    List<DTOTipoTarea> listatipostareaVigentes;
    List<DTOTipoTarea> listaTiposTareaParaAlta;
    List<DTOSector> listasectores;
    String nomfilSector;
    String codfilSector;
    javax.swing.table.DefaultTableModel miTablaDisponibles=new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código TT","Nombre Tipo Tarea"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
    javax.swing.table.DefaultTableModel miTablaElegidas=new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código TT","Nombre Tipo Tarea"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
    /*NO SIRVEN
    DefaultListModel milista = new DefaultListModel();
    DefaultListModel milista2 = new DefaultListModel();
    */  
    public AltaTipoInstancia() {
        initComponents();
    }
    public void setVisible(boolean b) {
        
        listasectores = controladorABMTI.buscarSectoresVigentes();
        for (int i=0;i<listasectores.size();i++)
        {
            DTOSector unSector = listasectores.get(i);
            sectoresComboBox.addItem(unSector);
        }
        List<DTOTipoTarea> listatipostarea = controladorABMTI.buscarTiposTareaVigentes();
        listatipostareaVigentes = ordenaDTOTipoTarea(listatipostarea);
        poblarTablaTareasVigentes(listatipostarea);
        for (int i=0;i<listatipostarea.size();i++)
        {
            DTOTipoTarea unTipoTarea = listatipostarea.get(i);
            miTablaDisponibles.addRow(new Object[]{unTipoTarea.getCodTipoTarea(),unTipoTarea.getNombreTipoTarea()});
        }
        super.setVisible(b);
    }
    public void inicializaAlta(ControladorABMTipoInstancia cont,ABMTipoInstancia abm){
       controladorABMTI=cont;
       abmTI = abm;
       listaTiposTareaParaAlta = new ArrayList<>();
    }
    public void poblarTablaTareasVigentes (List<DTOTipoTarea> listatipostarea) {
        List<DTOTipoTarea> listaordenada = ordenaDTOTipoTarea(listatipostarea);
        miTablaDisponibles.setRowCount(0);
        for (int i=0;i<listaordenada.size();i++)
        {
            DTOTipoTarea unTipoTarea = listaordenada.get(i);
            miTablaDisponibles.addRow(new Object[]{unTipoTarea.getCodTipoTarea(),unTipoTarea.getNombreTipoTarea()});
        }
        TiposTareaVigentesTable.setModel(miTablaDisponibles);
    }
    public void poblarTablaTareasElegidas (List<DTOTipoTarea> listatipostarea) {
        List<DTOTipoTarea> listaordenada = ordenaDTOTipoTarea(listatipostarea);
        miTablaElegidas.setRowCount(0);
        for (int i=0;i<listaordenada.size();i++)
        {
            DTOTipoTarea unTipoTarea = listaordenada.get(i);
            miTablaElegidas.addRow(new Object[]{unTipoTarea.getCodTipoTarea(),unTipoTarea.getNombreTipoTarea()});
        }
        TiposTareaElegidasTable.setModel(miTablaElegidas);
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

        sectoresComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codaltaTipoInstanciaTextField = new javax.swing.JTextField();
        nomaltaTipoInstanciaTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        altaTipoInstanciaButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TiposTareaVigentesTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TiposTareaElegidasTable = new javax.swing.JTable();
        agregarTareaButton = new javax.swing.JButton();
        removerTareaButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        codSectorTextField = new javax.swing.JTextField();
        nomSectorTextField = new javax.swing.JTextField();

        sectoresComboBox.setEditable(true);
        sectoresComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectoresComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Sector al que pertenece el Tipo Instancia:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta Tipo Instancia");

        jLabel1.setText("Código Tipo Instancia:");

        jLabel2.setText("Nombre Tipo Instancia:");

        codaltaTipoInstanciaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codaltaTipoInstanciaTextFieldActionPerformed(evt);
            }
        });

        nomaltaTipoInstanciaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomaltaTipoInstanciaTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Elija los Tipos de Tarea vigentes que pertenecerán al Tipo Instancia");

        altaTipoInstanciaButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        altaTipoInstanciaButton.setText("Dar alta al Tipo Instancia");
        altaTipoInstanciaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaTipoInstanciaButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

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
        TiposTareaVigentesTable.setColumnSelectionAllowed(true);
        TiposTareaVigentesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TiposTareaVigentesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TiposTareaVigentesTable);
        TiposTareaVigentesTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (TiposTareaVigentesTable.getColumnModel().getColumnCount() > 0) {
            TiposTareaVigentesTable.getColumnModel().getColumn(0).setMinWidth(0);
            TiposTareaVigentesTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        }

        TiposTareaElegidasTable.setModel(new javax.swing.table.DefaultTableModel(
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
        TiposTareaElegidasTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TiposTareaElegidasTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TiposTareaElegidasTable);
        TiposTareaElegidasTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (TiposTareaElegidasTable.getColumnModel().getColumnCount() > 0) {
            TiposTareaElegidasTable.getColumnModel().getColumn(0).setMinWidth(0);
            TiposTareaElegidasTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        }

        agregarTareaButton.setText("-->");
        agregarTareaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTareaButtonActionPerformed(evt);
            }
        });

        removerTareaButton.setText("<--");
        removerTareaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerTareaButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre de Sector asignado:");

        jLabel6.setText("Ingrese Código de Sector a asignar:");

        codSectorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codSectorTextFieldActionPerformed(evt);
            }
        });
        codSectorTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codSectorTextFieldKeyReleased(evt);
            }
        });

        nomSectorTextField.setEditable(false);
        nomSectorTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomSectorTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomaltaTipoInstanciaTextField)
                                    .addComponent(codaltaTipoInstanciaTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomSectorTextField)
                                    .addComponent(codSectorTextField))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(altaTipoInstanciaButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cancelarButton))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(agregarTareaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                        .addComponent(removerTareaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codaltaTipoInstanciaTextField)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomaltaTipoInstanciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(codSectorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nomSectorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(agregarTareaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removerTareaButton))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(altaTipoInstanciaButton)
                    .addComponent(cancelarButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void codaltaTipoInstanciaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codaltaTipoInstanciaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codaltaTipoInstanciaTextFieldActionPerformed

    private void nomaltaTipoInstanciaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomaltaTipoInstanciaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomaltaTipoInstanciaTextFieldActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        setVisible(false);
        dispose(); 
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void sectoresComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectoresComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectoresComboBoxActionPerformed

    private void altaTipoInstanciaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaTipoInstanciaButtonActionPerformed
        int codSector,codtipoinstancia;
        try  {
            codtipoinstancia=(Integer.parseInt(codaltaTipoInstanciaTextField.getText()));
            codSector=(Integer.parseInt(codSectorTextField.getText()));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al ingresar codSector. Por favor ingrese un número", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nomTI = nomaltaTipoInstanciaTextField.getText();
        List<DTOTipoTarea> tareas = listaTiposTareaParaAlta;
        Boolean exito = controladorABMTI.darAltaTipoInstancia(codtipoinstancia,codSector,nomTI,tareas);
        if (exito == true) {
        setVisible(false);
        dispose();
        abmTI.setVisible(true);
        }     
    }//GEN-LAST:event_altaTipoInstanciaButtonActionPerformed

    private void agregarTareaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTareaButtonActionPerformed
        int a;
        try {
            a= (Integer) TiposTareaVigentesTable.getModel().getValueAt(TiposTareaVigentesTable.getSelectedRow(), 0);
            }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Seleccione un Tipo de Tarea para asignar", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        for (int i=0;i<listatipostareaVigentes.size();i++)
        {
            DTOTipoTarea unTipoTarea = listatipostareaVigentes.get(i);
            if (a==unTipoTarea.getCodTipoTarea()){  
                listatipostareaVigentes.remove(unTipoTarea);
                listaTiposTareaParaAlta.add(unTipoTarea);
                poblarTablaTareasVigentes(listatipostareaVigentes);
                poblarTablaTareasElegidas(listaTiposTareaParaAlta);
            }
        }
    }//GEN-LAST:event_agregarTareaButtonActionPerformed

    private void removerTareaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerTareaButtonActionPerformed
        int a;
        try  {
              a= (Integer) TiposTareaElegidasTable.getModel().getValueAt(TiposTareaElegidasTable.getSelectedRow(), 0);
             }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Seleccione un Tipo de Tarea asignada", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (int i=0;i<listaTiposTareaParaAlta.size();i++)
        {
            DTOTipoTarea unTipoTarea = listaTiposTareaParaAlta.get(i);
            if (a==unTipoTarea.getCodTipoTarea())
            {
                listatipostareaVigentes.add(unTipoTarea);
                listaTiposTareaParaAlta.remove(unTipoTarea);
                poblarTablaTareasVigentes(listatipostareaVigentes);
                poblarTablaTareasElegidas(listaTiposTareaParaAlta);
            }
        }
    }//GEN-LAST:event_removerTareaButtonActionPerformed

    private void codSectorTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codSectorTextFieldKeyReleased
        if ("".equals(codSectorTextField.getText())){
            nomSectorTextField.setText("");
            return;
        }
        if (!"".equals(codSectorTextField.getText())) try { 
            Integer a= Integer.parseInt(codSectorTextField.getText());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ingrese un número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        nomfilSector="";
        codfilSector=codSectorTextField.getText();
        List<DTOSector> listaSectoresfiltrados = controladorABMTI.buscarSectores("",codfilSector);
        nomSectorTextField.setText(listaSectoresfiltrados.get(0).getNombreSector());
       /* REMOVIDO
        sectoresComboBox.removeAllItems();
        for (int i=0;i<listaSectoresfiltrados.size();i++)
        {
            DTOSector unSector = listaSectoresfiltrados.get(i);
            sectoresComboBox.addItem(unSector);
        }
        */
    }//GEN-LAST:event_codSectorTextFieldKeyReleased

    private void nomSectorTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomSectorTextFieldKeyReleased
        /* REMOVIDO
        nomfilSector=nomSectorTextField.getText();
        codfilSector="";
        List<DTOSector> listaSectoresfiltrados = controladorABMTI.buscarSectores(nomfilSector,codfilSector);
        sectoresComboBox.removeAllItems();
        for (int i=0;i<listaSectoresfiltrados.size();i++)
        {
            DTOSector unSector = listaSectoresfiltrados.get(i);
            sectoresComboBox.addItem(unSector);
        }*/
    }//GEN-LAST:event_nomSectorTextFieldKeyReleased

    private void codSectorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codSectorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codSectorTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AltaTipoInstancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaTipoInstancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaTipoInstancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaTipoInstancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaTipoInstancia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TiposTareaElegidasTable;
    private javax.swing.JTable TiposTareaVigentesTable;
    private javax.swing.JButton agregarTareaButton;
    private javax.swing.JButton altaTipoInstanciaButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField codSectorTextField;
    private javax.swing.JTextField codaltaTipoInstanciaTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField nomSectorTextField;
    private javax.swing.JTextField nomaltaTipoInstanciaTextField;
    private javax.swing.JButton removerTareaButton;
    private javax.swing.JComboBox<DTOSector> sectoresComboBox;
    // End of variables declaration//GEN-END:variables
}
