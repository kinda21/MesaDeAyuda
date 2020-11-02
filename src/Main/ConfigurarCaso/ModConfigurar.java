package Main.ConfigurarCaso;

import Main.DTOConfiguracionTipoCaso;
import Main.DTOTipoCaso;
import Main.DTOTipoCasoTipoInstancia;
import Main.DTOTipoInstancia;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.jdatepicker.DateModel;
import org.jdatepicker.UtilDateModel;

/**
 *
 * @author FLIA HUDSON
 */
public class ModConfigurar extends javax.swing.JFrame {
    ControladorConfigurar cont;
    SeleccionTipoCaso select;
    ABMConfigurar config;
    String parcodTC,parnroConfiguracion;
    Date fechainicioconfig;
    DTOConfiguracionTipoCaso configamodificar;
    DTOTipoInstancia tibuscada;
    DTOConfiguracionTipoCaso configalta;
    List<DTOTipoInstancia> listaTIfiltrados;
    List<DTOTipoCasoTipoInstancia> listaTITC;
    javax.swing.table.DefaultTableModel miTabla=new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Orden","Código Tipo Instancia", "Nombre Tipo Instancia", "Minutos"
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
     * Creates new form AltaConfigurar
     */
    public ModConfigurar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void inicializaMod (ControladorConfigurar cont,ABMConfigurar config, String codigoTC,String numeroconfig, SeleccionTipoCaso select) {
       this.cont = cont;
       this.config = config;
       this.select = select;
       parnroConfiguracion = numeroconfig; 
       parcodTC = codigoTC;
       configamodificar = (DTOConfiguracionTipoCaso) cont.buscarConfiguracion(parcodTC,parnroConfiguracion);
       listaTITC = configamodificar.getListaDTOTipoCasoTipoInstancia();
       listaTIfiltrados = new ArrayList<>();
    }
    public String arreglarDate (String date) {
        String dateoriginal = date; // formato YYYY-MM-dd
        dateoriginal = dateoriginal.replace("-","/"); //formato YYYY/MM/dd
        String dia = dateoriginal.substring(8, 10);
        String mes = dateoriginal.substring(4, 8);
        String año = dateoriginal.substring(0, 4);
        String datearreglada = (dia+mes+año); // formato dd/MM/YYYY
        return datearreglada;
    }
        
    
    public void setVisible(boolean b) {
        if (b==true) {
            DTOTipoCaso tcbuscado = (DTOTipoCaso) cont.buscarTipoCasosVigentes("", parcodTC).get(0);
            codTCTextField.setText(Integer.toString(tcbuscado.getCodTipoCaso()));
            nomTCTextField.setText(tcbuscado.getNombreTipoCaso());
            nroConfigTextField.setText(parnroConfiguracion);
           // String fechainicial;
           // fechainicial = configamodificar.getFechaInicioVigencia().toString();
           // fechainicial = arreglarDate(fechainicial); 
           // jDatePicker1.getFormattedTextField().setText(fechainicial);
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(configamodificar.getFechaInicioVigencia().getTime());
            DateModel<Calendar> dateModel = (DateModel<Calendar>) jDatePicker1.getModel();
            dateModel.setValue(cal);
            if (listaTITC.size()>0){
            poblarTabla(listaTITC);
            }
            super.setVisible(b);
        }
    }
    public void poblarTabla(List<DTOTipoCasoTipoInstancia> listatitcs) {
        miTabla.setRowCount(0);
        List<DTOTipoCasoTipoInstancia> listatitcsordenadas = ordenaTITCs(listatitcs);
        for (int i=0;i<listatitcsordenadas.size();i++)
            {
                DTOTipoCasoTipoInstancia unaTITC = listatitcsordenadas.get(i);
                miTabla.addRow(new Object[]{unaTITC.getOrdenTipoCasoTipoInstancia(),unaTITC.getCodigoTipoInstancia(),unaTITC.getNombreTipoInstancia(),unaTITC.getMinutosMaximaResolucion()});
                TablaTITC.setModel(miTabla);
            }
    }
    private  List<DTOTipoCasoTipoInstancia> ordenaTITCs(List<DTOTipoCasoTipoInstancia> listatitcs)
    {
        List<DTOTipoCasoTipoInstancia> ordenado,aux;
        ordenado=new ArrayList<DTOTipoCasoTipoInstancia>();
        aux= new ArrayList<DTOTipoCasoTipoInstancia>();
        for (int i=0; i< listatitcs.size();i++)
        {
            aux.add(listatitcs.get(i));
        }
        for (int i=0; i< listatitcs.size();i++)
        {
            int ultCod=0;
            DTOTipoCasoTipoInstancia saux=null;
            for(int j=0;j<aux.size();j++)
            {
                if(ultCod ==0)
                {
                    ultCod=aux.get(j).getOrdenTipoCasoTipoInstancia();
                    saux=aux.get(j);
                }
                if (ultCod >aux.get(j).getOrdenTipoCasoTipoInstancia())
                {
                    ultCod=aux.get(j).getOrdenTipoCasoTipoInstancia();
                    saux=aux.get(j);
                }
            }
            ordenado.add(saux);
            aux.remove(saux);
        }
         return ordenado; 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nroConfigTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDatePicker1 = new org.jdatepicker.JDatePicker();
        nomTCTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        codTCTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTITC = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        maxMinutosTextField = new javax.swing.JTextField();
        ordenTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        codTITextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        nomTITextField = new javax.swing.JTextField();
        addTCTI = new javax.swing.JButton();
        removeTCTI = new javax.swing.JButton();
        modificarTCTI = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Configuracion");

        jLabel1.setText("N° Configuración:");

        nroConfigTextField.setEditable(false);
        nroConfigTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nroConfigTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Código Tipo Caso:");

        jLabel3.setText("Fecha de Inicio:");

        jDatePicker1.setShowYearButtons(true);
        jDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDatePicker1ActionPerformed(evt);
            }
        });

        nomTCTextField.setEditable(false);
        nomTCTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomTCTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre Tipo Caso:");

        codTCTextField.setEditable(false);
        codTCTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codTCTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Datos de la Configuración a modificar");

        TablaTITC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Orden", "Código Tipo Instancia", "Nombre Tipo Instancia", "Minutos Máxima Resolucion"
            }
        ));
        jScrollPane1.setViewportView(TablaTITC);
        if (TablaTITC.getColumnModel().getColumnCount() > 0) {
            TablaTITC.getColumnModel().getColumn(1).setResizable(false);
            TablaTITC.getColumnModel().getColumn(1).setHeaderValue("Código Tipo Instancia");
            TablaTITC.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Máximo minutos:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Orden:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Datos de los Tipo Caso Tipo Instancia a modificar");

        maxMinutosTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxMinutosTextFieldActionPerformed(evt);
            }
        });

        ordenTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenTextFieldActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Código Tipo Instancia:");

        codTITextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codTITextFieldFocusLost(evt);
            }
        });
        codTITextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codTITextFieldActionPerformed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Nombre Tipo Instancia:");

        nomTITextField.setEditable(false);
        nomTITextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomTITextFieldActionPerformed(evt);
            }
        });

        addTCTI.setText("Agregar Tipo Caso Tipo Instancia");
        addTCTI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTCTIActionPerformed(evt);
            }
        });

        removeTCTI.setText("Remover Tipo Caso Tipo Instancia");
        removeTCTI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTCTIActionPerformed(evt);
            }
        });

        modificarTCTI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        modificarTCTI.setText("Modificar Configuración");
        modificarTCTI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarTCTIActionPerformed(evt);
            }
        });

        backButton.setText("Volver");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nroConfigTextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codTCTextField)
                                    .addComponent(nomTCTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ordenTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(maxMinutosTextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomTITextField)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codTITextField)
                                        .addGap(2, 2, 2))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modificarTCTI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addTCTI)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeTCTI)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codTCTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(nroConfigTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nomTCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(jDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ordenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(codTITextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxMinutosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12)
                    .addComponent(nomTITextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTCTI)
                    .addComponent(removeTCTI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificarTCTI)
                    .addComponent(backButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nroConfigTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nroConfigTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nroConfigTextFieldActionPerformed

    private void nomTCTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomTCTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomTCTextFieldActionPerformed

    private void codTCTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codTCTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codTCTextFieldActionPerformed

    private void jDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDatePicker1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDatePicker1ActionPerformed

    private void ordenTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ordenTextFieldActionPerformed

    private void maxMinutosTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxMinutosTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxMinutosTextFieldActionPerformed

    private void codTITextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codTITextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codTITextFieldActionPerformed

    private void nomTITextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomTITextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomTITextFieldActionPerformed

    private void addTCTIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTCTIActionPerformed
        int minutos,numero;
        try  {
            numero=(Integer.parseInt(ordenTextField.getText()));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "El orden debe ser un número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try  {
            minutos=(Integer.parseInt(maxMinutosTextField.getText()));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "El máximo de minutos debe ser un número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DTOTipoCasoTipoInstancia undto = new DTOTipoCasoTipoInstancia();
        undto.setOrdenTipoCasoTipoInstancia(Integer.parseInt(ordenTextField.getText()));
        undto.setMinutosMaximaResolucion(Integer.parseInt(maxMinutosTextField.getText()));
        undto.setNombreTipoInstancia(tibuscada.getNombreTipoInstancia());
        undto.setCodigoTipoInstancia(tibuscada.getCodTipoInstancia());
        for (int i=0;i<listaTITC.size();i++)
        {
            DTOTipoCasoTipoInstancia unTITC = listaTITC.get(i);
            if (undto.getOrdenTipoCasoTipoInstancia()==unTITC.getOrdenTipoCasoTipoInstancia())
            {
                JOptionPane.showMessageDialog(this, "Ya hay un Tipo Caso Tipo Instancia con ese orden en la lista", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        listaTITC.add(undto);
        poblarTabla(listaTITC);
    }//GEN-LAST:event_addTCTIActionPerformed

    private void removeTCTIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTCTIActionPerformed
        int a;
        try  {
              a= (Integer) TablaTITC.getModel().getValueAt(TablaTITC.getSelectedRow(), 0);
             }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Seleccione un Tipo Caso Tipo Instancia", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (int i=0;i<listaTITC.size();i++)
        {
            DTOTipoCasoTipoInstancia unTITC = listaTITC.get(i);
            if (a==unTITC.getOrdenTipoCasoTipoInstancia())
            {
                listaTITC.remove(unTITC);
                poblarTabla(listaTITC);
            }
        }
    }//GEN-LAST:event_removeTCTIActionPerformed

    private void codTITextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codTITextFieldFocusLost
        if ("".equals(codTITextField.getText())){
            nomTITextField.setText(null);
            return;
        }
        if (!"".equals(codTITextField.getText())) try { 
            Integer a = Integer.parseInt(codTITextField.getText());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ingrese un número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
            codTITextField.setText(null);
            return;
        }
        
        listaTIfiltrados.clear();
        listaTIfiltrados = cont.buscarTipoInstanciaVigente(Integer.parseInt(codTITextField.getText()));
        if (listaTIfiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No existe un Tipo Instancia con el código ingresado o ha sido dado de baja", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        tibuscada = listaTIfiltrados.get(0);
        nomTITextField.setText(tibuscada.getNombreTipoInstancia());
    }//GEN-LAST:event_codTITextFieldFocusLost

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
        dispose(); 
    }//GEN-LAST:event_backButtonActionPerformed

    private void modificarTCTIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarTCTIActionPerformed
        /* SimpleDateFormat formatter;
        Locale locale = jDatePicker1.getLocale();
        formatter = new SimpleDateFormat("dd/MM/yyyy", locale);*/
        try {
          //fechainicioconfig = formatter.parse(jDatePicker1.getFormattedTextField().getText());
            Calendar selectedValue = (Calendar) jDatePicker1.getModel().getValue();
            fechainicioconfig = selectedValue.getTime();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Elija una fecha válida para la configuración", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
          Integer a = Integer.parseInt(nroConfigTextField.getText());
          if (a==0) {
            JOptionPane.showMessageDialog(this, "El orden debe ser mayor a 0", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;  
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ingrese un entero mayor a 0 para el numero de configuración", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Boolean exito = cont.modificarConfiguracion(parnroConfiguracion, parcodTC, fechainicioconfig, listaTITC);
        if (exito == true) {
            setVisible(false);
            dispose();
            config.setVisible(true);
        } 
    }//GEN-LAST:event_modificarTCTIActionPerformed

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
            java.util.logging.Logger.getLogger(ModConfigurar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModConfigurar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModConfigurar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModConfigurar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModConfigurar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaTITC;
    private javax.swing.JButton addTCTI;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField codTCTextField;
    private javax.swing.JTextField codTITextField;
    private org.jdatepicker.JDatePicker jDatePicker1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField maxMinutosTextField;
    private javax.swing.JButton modificarTCTI;
    private javax.swing.JTextField nomTCTextField;
    private javax.swing.JTextField nomTITextField;
    private javax.swing.JTextField nroConfigTextField;
    private javax.swing.JTextField ordenTextField;
    private javax.swing.JButton removeTCTI;
    // End of variables declaration//GEN-END:variables
}
