package Main;

import Entidades.*;
import java.util.*;


public class Experto {

    public void Metodo() {
        crearElementos();
    }
    
    void crearElementos() {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        Date fecha = new Date();

        //sectores
        Sector s1 = new Sector();
        s1.setCodSector(001);
        s1.setNombreSector("Servidores"); 
        s1.setDescripcionSector("En este sector se trata lo relacionado al area de la Empresa de servidores.");
        FachadaPersistencia.getInstance().guardar(s1);
 
        Sector s2 = new Sector();
        s2.setCodSector(002);
        s2.setNombreSector("Mantenimiento de Redes");        
        s2.setDescripcionSector("En este sector se trata lo relacionado al area de mantenimiento de redes.");
        FachadaPersistencia.getInstance().guardar(s2);
   
        Sector s3 = new Sector();
        s3.setCodSector(003);
        s3.setNombreSector("Tecnicos a Domicilio");      
        s3.setDescripcionSector("En este sector trabajan los empleados que realizan trabajo a domicilio.");
        FachadaPersistencia.getInstance().guardar(s3);
        
        Sector s4 = new Sector();
        s4.setCodSector(004);
        s4.setNombreSector("Arquitectura de Nodos");    
        s4.setDescripcionSector("En este sector se trata lo relacionado a la arquitectura de nodos.");
        FachadaPersistencia.getInstance().guardar(s4);
     
        Sector s5 = new Sector();
        s5.setCodSector(005);
        s5.setNombreSector("Direccionamiento de Flujo de Datos");        
        s5.setDescripcionSector("En este sector se trata lo relacionado al direccionamiento de flujo de datos.");
        FachadaPersistencia.getInstance().guardar(s5);
        
        Sector s6 = new Sector();
        s6.setCodSector(006);
        s6.setNombreSector("Servicio Telefonia");       
        s6.setDescripcionSector("En este sector se trata lo relacionado al servicio de prestacion de servicio de telefonia.");
        s6.setFechaHoraFinVigenciaSector(fecha);
        FachadaPersistencia.getInstance().guardar(s6);

        //tipostareas
        TipoTarea tt1 = new TipoTarea();
        tt1.setCodTipoTarea(1);
        tt1.setNombreTipoTarea("Verificacion Enrutamiento");  
        tt1.setDescripcionTipoTarea("Se realizan controles de enrutamiento con los servidores y el cliente.");
        FachadaPersistencia.getInstance().guardar(tt1);
        
        TipoTarea tt2 = new TipoTarea();
        tt2.setCodTipoTarea(2);
        tt2.setNombreTipoTarea("Verificacion direccion IP");  
        tt2.setDescripcionTipoTarea("Se realizan controles asociados con el direccionamiento IP del cliente.");
        FachadaPersistencia.getInstance().guardar(tt2);
        
        TipoTarea tt3 = new TipoTarea();
        tt3.setCodTipoTarea(3);
        tt3.setNombreTipoTarea("Verificacion de Funcionamiento de Modems");  
        tt3.setDescripcionTipoTarea("El tecnico debe comprobar el funcionamiento del modem.");
        FachadaPersistencia.getInstance().guardar(tt3);
        
        TipoTarea tt4 = new TipoTarea();
        tt4.setCodTipoTarea(4);
        tt4.setNombreTipoTarea("Verificacion de fichas RJ45");  
        tt4.setDescripcionTipoTarea("El tecnico realiza el control de las fichas para comprobar que no esten averiadas.");
        FachadaPersistencia.getInstance().guardar(tt4);
        
        TipoTarea tt5 = new TipoTarea();
        tt5.setCodTipoTarea(5);
        tt5.setNombreTipoTarea("Control de Arquitectura de Flujo de Datos");  
        tt5.setDescripcionTipoTarea("Se realizan los controles asociados al funcionamiento correcto de el flujo de datos.");
        FachadaPersistencia.getInstance().guardar(tt5);
        
        TipoTarea tt6 = new TipoTarea();
        tt6.setCodTipoTarea(6);
        tt6.setNombreTipoTarea("Conexion de Linea Telefonica Domestica");  
        tt6.setDescripcionTipoTarea("El tecnico debe realizar los trabajos asociados a la conexion de lineas telefonica.");
        tt6.setFechaFinVigenciaTipoTarea(fecha);
        FachadaPersistencia.getInstance().guardar(tt6);
        
        TipoTarea tt7 = new TipoTarea();
        tt7.setCodTipoTarea(7);
        tt7.setNombreTipoTarea("Verificacion de Tono Telefonico");  
        tt7.setDescripcionTipoTarea("El tecnico realiza verificaciones de funcionamiento de telefono con tono.");
        tt7.setFechaFinVigenciaTipoTarea(fecha);
        FachadaPersistencia.getInstance().guardar(tt7);
        
        TipoTarea tt8 = new TipoTarea();
        tt8.setCodTipoTarea(8);
        tt8.setNombreTipoTarea("Eliminacion de Nodos Antiguos");  
        tt8.setDescripcionTipoTarea("Se realiza la eliminacion de los nodos antiguos que no se encuentran en uso.");
        FachadaPersistencia.getInstance().guardar(tt8);
        
        TipoTarea tt9 = new TipoTarea();
        tt9.setCodTipoTarea(9);
        tt9.setNombreTipoTarea("Testeo de Velocidades");  
        tt9.setDescripcionTipoTarea("Se realizan tests de las velocidades salientes y/o entrantes.");
        FachadaPersistencia.getInstance().guardar(tt9);
        
        TipoTarea tt10 = new TipoTarea();
        tt10.setCodTipoTarea(10);
        tt10.setNombreTipoTarea("Mantenimiento de Servidores");  
        tt10.setDescripcionTipoTarea("Se realiza las tareas asociadas al mantenimiento semanal de los servidores.");
        FachadaPersistencia.getInstance().guardar(tt10);        
        
        TipoTarea tt11 = new TipoTarea();
        tt11.setCodTipoTarea(11);
        tt11.setNombreTipoTarea("Seteo de Telefonos VoIP");
        tt11.setDescripcionTipoTarea("Se realiza el seteo de los telefonos VoIP para su uso posterior.");
        FachadaPersistencia.getInstance().guardar(tt11);
        
        TipoTarea tt12 = new TipoTarea();
        tt12.setCodTipoTarea(12);
        tt12.setNombreTipoTarea("Mantenimiento de Memoria");  
        tt12.setDescripcionTipoTarea("Se realiza las tareas asociadas al mantenimiento de memoria a traves de su limpieza.");
        FachadaPersistencia.getInstance().guardar(tt12); 
        
        TipoTarea tt13 = new TipoTarea();
        tt13.setCodTipoTarea(13);
        tt13.setNombreTipoTarea("Performance Boost Up sobre Servidores");  
        tt13.setDescripcionTipoTarea("Se realiza las tareas de boosting de servidores para su mejor funcionamiento.");
        FachadaPersistencia.getInstance().guardar(tt13); 
        
        //tipocasoiteracion
        TipoCasoIteracion tci1 = new TipoCasoIteracion();
        tci1.setNumeroDeIteracion(1);
        tci1.setCoeficienteReduccionTipo(0); 
        
        TipoCasoIteracion tci2 = new TipoCasoIteracion();
        tci2.setNumeroDeIteracion(2);
        tci2.setCoeficienteReduccionTipo(5);  
        
        TipoCasoIteracion tci3 = new TipoCasoIteracion();
        tci3.setNumeroDeIteracion(3);
        tci3.setCoeficienteReduccionTipo(10); 
        
        TipoCasoIteracion tci4 = new TipoCasoIteracion();
        tci4.setNumeroDeIteracion(4);
        tci4.setCoeficienteReduccionTipo(15);
        
        TipoCasoIteracion tci5 = new TipoCasoIteracion();
        tci5.setNumeroDeIteracion(1);
        tci5.setCoeficienteReduccionTipo(20); 
        
        TipoCasoIteracion tci6 = new TipoCasoIteracion();
        tci6.setNumeroDeIteracion(2);
        tci6.setCoeficienteReduccionTipo(35); 
               
        //tipocaso
        TipoCaso tc1 = new TipoCaso();
        tc1.setCodTipoCaso(1);
        tc1.setNombreTipoCaso("Falla de Conexion");
        tc1.setNumeroMaximaIteracion(4);
           
        tc1.addListaTipoCasoIteracion(tci1);
        tc1.addListaTipoCasoIteracion(tci2);
        tc1.addListaTipoCasoIteracion(tci3);
        tc1.addListaTipoCasoIteracion(tci4);
       
        TipoCaso tc2 = new TipoCaso();
        tc2.setCodTipoCaso(2);
        tc2.setNombreTipoCaso("Baja Recepcion en Llamadas");
        tc2.setNumeroMaximaIteracion(2);
           
        tc2.addListaTipoCasoIteracion(tci5);
        tc2.addListaTipoCasoIteracion(tci6);  
                
        FachadaPersistencia.getInstance().guardar(tc1);
        FachadaPersistencia.getInstance().guardar(tc2);
        
        //Tipoinstancias      
        TipoInstancia ti1 = new TipoInstancia();
        ti1.setCodTipoInstancia(1);
        ti1.setNombreTipoInstancia("Visita a Domicilio");
        //fechaHoraFinVigenciaTipoInstancia
        
        ti1.setSector(s3);
        ti1.addListaTipoTarea(tt3);
        ti1.addListaTipoTarea(tt4);        
        FachadaPersistencia.getInstance().guardar(ti1);
        
        TipoInstancia ti2 = new TipoInstancia();
        ti2.setCodTipoInstancia(2);
        ti2.setNombreTipoInstancia("Mantenimiento General de Servidores");
        
        ti2.setSector(s1);
        ti2.addListaTipoTarea(tt13);
        ti2.addListaTipoTarea(tt12);        
        ti2.addListaTipoTarea(tt10);        
        FachadaPersistencia.getInstance().guardar(ti2);
        
        TipoInstancia ti3 = new TipoInstancia();
        ti3.setCodTipoInstancia(3);
        ti3.setNombreTipoInstancia("Conexion a Linea Telefonica");
        ti3.setFechaHoraFinVigenciaTipoInstancia(fecha);
        
        ti3.setSector(s6);
        ti3.addListaTipoTarea(tt6);
        ti3.addListaTipoTarea(tt7);          
        FachadaPersistencia.getInstance().guardar(ti3);
        
        TipoInstancia ti4 = new TipoInstancia();
        ti4.setCodTipoInstancia(4);
        ti4.setNombreTipoInstancia("Configuracion de Red");
        
        ti4.setSector(s2);
        ti4.addListaTipoTarea(tt1);
        ti4.addListaTipoTarea(tt2);    
        ti4.addListaTipoTarea(tt3);
        ti4.addListaTipoTarea(tt9);
        FachadaPersistencia.getInstance().guardar(ti4);
        
        TipoInstancia ti5 = new TipoInstancia();
        ti5.setCodTipoInstancia(5);
        ti5.setNombreTipoInstancia("Verificacion de Conexion Remoto");
        
        ti5.setSector(s2);
        ti5.addListaTipoTarea(tt1);
        ti5.addListaTipoTarea(tt2);        
        ti5.addListaTipoTarea(tt9);        
        FachadaPersistencia.getInstance().guardar(ti5);
        
        //tipocasotipoinstancia
        TipoCasoTipoInstancia tcti1 = new TipoCasoTipoInstancia();
        tcti1.setMinutosMaximaResolucion(72);
        tcti1.setOrdenTipoCasoTipoInstancia(1);
        //minutosMaximaResolucion
        //ordenTipoCasoTipoInstancia
        
        //guardar tipoinstancia
        tcti1.setTipoinstancia(ti1);
        //FachadaPersistencia.getInstance().guardar(tcti1);

        TipoCasoTipoInstancia tcti2 = new TipoCasoTipoInstancia();
        tcti2.setMinutosMaximaResolucion(80);
        tcti2.setOrdenTipoCasoTipoInstancia(1);
        tcti2.setTipoinstancia(ti3);
        //FachadaPersistencia.getInstance().guardar(tcti2);
        
        TipoCasoTipoInstancia tcti3 = new TipoCasoTipoInstancia();
        tcti3.setMinutosMaximaResolucion(52);
        tcti3.setOrdenTipoCasoTipoInstancia(2);
        tcti3.setTipoinstancia(ti5);
        //FachadaPersistencia.getInstance().guardar(tcti3);
        
        //configuraciontipocaso 
        //nroConfig, fechaInicioVigencia, fechaFinVigencia, fechaVerificacion
        ConfiguracionTipoCaso configtc1 = new ConfiguracionTipoCaso();
        configtc1.setNroConfigTC(1); 
        //configtc1.setFechaVerificacion();
        //configtc1.setFechaInicioVigencia();
        configtc1.setFechaFinVigencia(fecha);
        configtc1.setTipocaso(tc2);
        configtc1.addListaTipoCasoTipoInstancia(tcti2); 
        
        
        ConfiguracionTipoCaso configtc2 = new ConfiguracionTipoCaso();
        configtc2.setNroConfigTC(2);               
        configtc2.setTipocaso(tc1);
        configtc2.addListaTipoCasoTipoInstancia(tcti1);
         
        
        ConfiguracionTipoCaso configtc3 = new ConfiguracionTipoCaso();
        configtc3.setNroConfigTC(3); 
        configtc3.setTipocaso(tc1);
        configtc3.addListaTipoCasoTipoInstancia(tcti3);    
        
        FachadaPersistencia.getInstance().guardar(configtc1);
        FachadaPersistencia.getInstance().guardar(configtc2);
        FachadaPersistencia.getInstance().guardar(configtc3);
        
	FachadaPersistencia.getInstance().finalizarTransaccion();
    }
    
    void busquedaDeUnElementoPorAtributo() {
    }
    
    void busquedaDeUnElementoPorAtributoNulo() {
    }
    
    void buscarTodosLosObjetosDeUnaClase() {
    }
    
    void buscarUnObjetoPorRelacion(){
    }
    
    void buscoUnObjetoQueContieneAOtroObjeto(){
    }
    
}
