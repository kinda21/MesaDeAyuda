package Main.ABMTipoInstancia;

import Main.DTOSector;
import Main.DTOTipoInstancia;
import Main.DTOTipoTarea;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author FLIA HUDSON
 */
public class ModTipoInstancia extends javax.swing.JFrame {
    ControladorABMTipoInstancia controladorABMTI;
    ABMTipoInstancia abmTI;
    int parCodTipoInstancia;
    DTOTipoInstancia dtomod = new DTOTipoInstancia();
    List<DTOTipoTarea> listatipostareaVigentes;
    List<DTOTipoTarea> listatipostareaVigentesTemporal;
    List<DTOTipoTarea> listaTiposTareaParaAlta;
    List<DTOSector> listasectores;
    String codfilSector;
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
    javax.swing.table.DefaultTableModel miTablaElegidas=new javax.swing.table.DefaultTableModel(
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
    /*NO SIRVEN
    DefaultListModel milista = new DefaultListModel();
    DefaultListModel milista2 = new DefaultListModel();
    */  
    public ModTipoInstancia() {
        initComponents();
    }
    public void setVisible(boolean b) {
        super.setVisible(b);
    }
    public void inicializaModificar(ControladorABMTipoInstancia cont,ABMTipoInstancia abm, int cod){
       controladorABMTI=cont;
       abmTI=abm;
       parCodTipoInstancia=cod;
       listatipostareaVigentes = ordenaDTOTipoTarea (controladorABMTI.buscarTiposTareaVigentes());
       listatipostareaVigentesTemporal = listatipostareaVigentes;
       List<DTOTipoInstancia> dtoTipoInstancia = controladorABMTI.buscarTipoInstancias(parCodTipoInstancia);
       codTipoInstanciaTextField.setText((Integer.toString(dtoTipoInstancia.get(0).getCodTipoInstancia())));
       nomSectorTextField.setText(dtoTipoInstancia.get(0).getNombreSector());
       nomModTipoInstanciaTextField.setText(dtoTipoInstancia.get(0).getNombreTipoInstancia());
       codModSectorTextField.setText(Integer.toString(dtoTipoInstancia.get(0).getCodSector()));
       List<DTOTipoTarea> listaTiposTareaRecibidos=ordenaDTOTipoTarea(dtoTipoInstancia.get(0).getListaDTOTipoTarea());
       listaTiposTareaParaAlta = new ArrayList<>();
       for (int i=0;i<listaTiposTareaRecibidos.size();i++)
        {
            DTOTipoTarea unTipoTarea = listaTiposTareaRecibidos.get(i);
            List<DTOTipoTarea> listaux = listatipostareaVigentes;
            for (int j=0;j<listaux.size();j++) {
                if (unTipoTarea.equals(listaux.get(j))==true) {
                    listaTiposTareaParaAlta.add(listaux.get(j));
                    listatipostareaVigentesTemporal.remove(listaux.get(j));
                }
            }
            
        }
        poblarTablaTareasVigentes(listatipostareaVigentesTemporal);
        poblarTablaTareasElegidas(listaTiposTareaParaAlta);
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

        jLabel3 = new javax.swing.JLabel();
        sectoresComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomModTipoInstanciaTextField = new javax.swing.JTextField();
        codTipoInstanciaTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TiposTareaVigentesTable = new javax.swing.JTable();
        agregarTareaButton = new javax.swing.JButton();
        removerTareaButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TiposTareaElegidasTable = new javax.swing.JTable();
        modTipoInstanciaButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        nomSectorTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        codModSectorTextField = new javax.swing.JTextField();

        jLabel3.setText("Nuevo Sector Tipo Instancia:");

        sectoresComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectoresComboBoxActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Tipo Instancia");

        jLabel1.setText("Código Tipo Instancia:");

        jLabel2.setText("Nuevo Nombre Tipo Instancia:");

        nomModTipoInstanciaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomModTipoInstanciaTextFieldActionPerformed(evt);
            }
        });

        codTipoInstanciaTextField.setEditable(false);
        codTipoInstanciaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codTipoInstanciaTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Elija los Tipos de Tarea vigentes que pertenecerán al Tipo Instancia");

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
        TiposTareaVigentesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TiposTareaVigentesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TiposTareaVigentesTable);

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

        modTipoInstanciaButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        modTipoInstanciaButton.setText("Modificar Tipo Instancia");
        modTipoInstanciaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modTipoInstanciaButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Volver");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        nomSectorTextField.setEditable(false);
        nomSectorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomSectorTextFieldActionPerformed(evt);
            }
        });
        nomSectorTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomSectorTextFieldKeyReleased(evt);
            }
        });

        jLabel7.setText("Nombre de Sector:");

        jLabel8.setText("Ingrese nuevo código de Sector:");

        codModSectorTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codModSectorTextFieldFocusLost(evt);
            }
        });
        codModSectorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codModSectorTextFieldActionPerformed(evt);
            }
        });
        codModSectorTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codModSectorTextFieldKeyReleased(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modTipoInstanciaButton)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                                        .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(removerTareaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(agregarTareaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(5, 5, 5))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomModTipoInstanciaTextField))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codTipoInstanciaTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codModSectorTextField)
                            .addComponent(nomSectorTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codTipoInstanciaTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomModTipoInstanciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(codModSectorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(nomSectorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(agregarTareaButton)
                        .addGap(28, 28, 28)
                        .addComponent(removerTareaButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modTipoInstanciaButton)
                    .addComponent(cancelarButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomModTipoInstanciaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomModTipoInstanciaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomModTipoInstanciaTextFieldActionPerformed

    private void codTipoInstanciaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codTipoInstanciaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codTipoInstanciaTextFieldActionPerformed

    private void sectoresComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectoresComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectoresComboBoxActionPerformed

    private void agregarTareaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTareaButtonActionPerformed
        int a;
        try {
            a= (Integer) TiposTareaVigentesTable.getModel().getValueAt(TiposTareaVigentesTable.getSelectedRow(), 0);
            }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Seleccione un Tipo de Tarea para asignar", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        for (int i=0;i<listatipostareaVigentesTemporal.size();i++)
        {
            DTOTipoTarea unTipoTarea = listatipostareaVigentesTemporal.get(i);
            if (a==unTipoTarea.getCodTipoTarea()){  
                listaTiposTareaParaAlta.add(unTipoTarea);
                listatipostareaVigentesTemporal.remove(unTipoTarea);
                poblarTablaTareasVigentes(listatipostareaVigentesTemporal);
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
                listatipostareaVigentesTemporal.add(unTipoTarea);
                listaTiposTareaParaAlta.remove(unTipoTarea);
                poblarTablaTareasVigentes(listatipostareaVigentesTemporal);
                poblarTablaTareasElegidas(listaTiposTareaParaAlta);
            }
        }
    }//GEN-LAST:event_removerTareaButtonActionPerformed

    private void modTipoInstanciaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modTipoInstanciaButtonActionPerformed
        int codtipoinstancia,codSector;
        try  {
            codtipoinstancia=(Integer.parseInt(codTipoInstanciaTextField.getText()));
            codSector =(Integer.parseInt(codModSectorTextField.getText()));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al ingresar codSector. Por favor ingrese un número", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nomTI = nomModTipoInstanciaTextField.getText();
        List<DTOTipoTarea> tareas = listaTiposTareaParaAlta;
        Boolean exito = controladorABMTI.modificarTipoInstancia(codtipoinstancia, codSector, nomTI, tareas);    
        if (exito == true) {
        setVisible(false);
        dispose();
        abmTI.setVisible(true);
        }
    }//GEN-LAST:event_modTipoInstanciaButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void nomSectorTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomSectorTextFieldKeyReleased
       /* nomfilSector=nomSectorTextField.getText();
        codfilSector="";
        List<DTOSector> listaSectoresfiltrados = controladorABMTI.buscarSectores(nomfilSector,codfilSector);
        sectoresComboBox.removeAllItems();
        for (int i=0;i<listaSectoresfiltrados.size();i++)
        {
            DTOSector unSector = listaSectoresfiltrados.get(i);
             sectoresComboBox.addItem(unSector);
        }*/
    }//GEN-LAST:event_nomSectorTextFieldKeyReleased

    private void codModSectorTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codModSectorTextFieldKeyReleased
        if ("".equals(codModSectorTextField.getText())){
            nomSectorTextField.setText("");
            return;
        }
        if (!"".equals(codModSectorTextField.getText())) try { 
            Integer a= Integer.parseInt(codModSectorTextField.getText());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ingrese un número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
            codModSectorTextField.setText(null);
            return;
        }
        codfilSector=codModSectorTextField.getText();
        List<DTOSector> listaSectoresfiltrados = controladorABMTI.buscarSectores("",codfilSector);
        if (listaSectoresfiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No existe un Sector con el código ingresado", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        nomSectorTextField.setText(listaSectoresfiltrados.get(0).getNombreSector());
    }//GEN-LAST:event_codModSectorTextFieldKeyReleased

    private void codModSectorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codModSectorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codModSectorTextFieldActionPerformed

    private void nomSectorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomSectorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomSectorTextFieldActionPerformed

    private void codModSectorTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codModSectorTextFieldFocusLost
        if ("".equals(codModSectorTextField.getText())){
            nomSectorTextField.setText("");
            return;
        }
        if (!"".equals(codModSectorTextField.getText())) try { 
            Integer a= Integer.parseInt(codModSectorTextField.getText());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ingrese un número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
            codModSectorTextField.setText(null);
            return;
        }
        codfilSector=codModSectorTextField.getText();
        List<DTOSector> listaSectoresfiltrados = controladorABMTI.buscarSectores("",codfilSector);
        if (listaSectoresfiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No existe un Sector con el código ingresado", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        nomSectorTextField.setText(listaSectoresfiltrados.get(0).getNombreSector());
    }//GEN-LAST:event_codModSectorTextFieldFocusLost

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
            java.util.logging.Logger.getLogger(ModTipoInstancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModTipoInstancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModTipoInstancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModTipoInstancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModTipoInstancia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TiposTareaElegidasTable;
    private javax.swing.JTable TiposTareaVigentesTable;
    private javax.swing.JButton agregarTareaButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField codModSectorTextField;
    private javax.swing.JTextField codTipoInstanciaTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton modTipoInstanciaButton;
    private javax.swing.JTextField nomModTipoInstanciaTextField;
    private javax.swing.JTextField nomSectorTextField;
    private javax.swing.JButton removerTareaButton;
    private javax.swing.JComboBox<DTOSector> sectoresComboBox;
    // End of variables declaration//GEN-END:variables
}
