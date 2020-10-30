package Main.ConfigurarCaso;

import Main.DTOConfiguracionTipoCaso;
import Main.DTOTipoCaso;
import Main.DTOTipoCasoTipoInstancia;
import Main.DTOTipoInstancia;
import java.util.*;

/**
 *
 * @author FLIA HUDSON
 */
public class ControladorConfigurar{
    ExpertoConfigurar expertoconfig = new ExpertoConfigurar();
    
    public ControladorConfigurar () {
    }
    
    public List<DTOTipoInstancia> buscarTipoInstanciaVigente(int codfilTipoInstancia) {
        return expertoconfig.buscarTipoInstanciaVigente(codfilTipoInstancia);
    }
    
    public List<DTOTipoCaso> buscarTipoCasosVigentes(String nomfilTipoCaso, String codfilTipoCaso) {
       return expertoconfig.buscarTipoCasosVigentes(nomfilTipoCaso, codfilTipoCaso);
    }
    public List<DTOConfiguracionTipoCaso> buscarConfiguraciones(String codTC){
        return expertoconfig.buscarConfiguraciones(codTC);
    }
    
    public DTOConfiguracionTipoCaso buscarConfiguracion(String codTC,String nroconf){
        return expertoconfig.buscarConfiguracion(codTC,nroconf);
    }
    
    public void abrirABM(String codtc,SeleccionTipoCaso seleccion){
       ABMConfigurar abm = new ABMConfigurar();
       abm.inicializaABM(this,codtc,seleccion);
       abm.setVisible(true);
    }
    
    public void abrirAlta (ABMConfigurar abm,String codigoTC, SeleccionTipoCaso select){
       AltaConfigurar alta = new AltaConfigurar();
       alta.inicializaAlta(this,abm, codigoTC, select);
       alta.setVisible(true);
    }
    
    public void abrirModificar (ABMConfigurar abm,String codigoTC,String nroconfig, SeleccionTipoCaso select){
       ModConfigurar mod = new ModConfigurar();
       mod.inicializaMod(this,abm, codigoTC,nroconfig, select);
       mod.setVisible(true);
    }
    public void abrirBaja (ABMConfigurar abm,String codigoTC,String nroconfig, SeleccionTipoCaso select){
       BajaConfigurar baja = new BajaConfigurar();
       baja.inicializaBaja(this,abm, codigoTC,nroconfig, select);
       baja.setVisible(true);
    }
    
    public boolean daraltaConfiguracion (String nroConfig, String codTC, Date fechainicio, List<DTOTipoCasoTipoInstancia> listatipocasotipoinstancia ) {
        return expertoconfig.daraltaConfiguracion(nroConfig, codTC, fechainicio, listatipocasotipoinstancia);
    }
    
    public boolean modificarConfiguracion (String nroConfig, String codTC, Date fechainicio, List<DTOTipoCasoTipoInstancia> listatipocasotipoinstancia ) {
        return expertoconfig.modificarConfiguracion(nroConfig, codTC, fechainicio, listatipocasotipoinstancia);
    }
    
    public boolean darBajaConfiguracion (String nroConfig, String codTC) {
        return expertoconfig.darBajaConfiguracion(nroConfig, codTC);
    }
    
    public boolean verificarConfiguracion (String nroConfig, String codTC) {
        return expertoconfig.verificarConfiguracion(nroConfig, codTC);
    }
/*    public boolean daraltaTipoCaso(int codtipocaso, String nomTC, int maxiteraciones,List<DTOTipoCasoIteracion> iteraciones){
        return expertoconfig.daraltaTipoCaso(codtipocaso, nomTC, maxiteraciones,iteraciones);
        }
    public boolean darbajaTipoCaso(int codtipocaso) {
        return expertoconfig.darbajaTipoCaso(codtipocaso);
    }
    public boolean modificarTipoCaso (int codtipocaso, String nomTC,int maxiteraciones) {
        return expertoconfig.modificarTipoCaso(codtipocaso, nomTC, maxiteraciones);
    }
     public List<DTOTipoCaso> buscarTipoCasos(String nomfilTipoCaso, String codfilTipoCaso){
       List<DTOTipoCaso> listatipocasos = expertoconfig.buscarTipoCasos(nomfilTipoCaso,codfilTipoCaso);
       return listatipocasos;
    }
     public void abrirModificar(int cod, SeleccionTipoCaso abm)
     {
         ModTipoCaso mod = new ModTipoCaso();
         mod.inicializaModificar(this, abm, cod);
         mod.setVisible(true);
     }
     public void abrirBaja(int cod,SeleccionTipoCaso abm)
     {
         BajaTipoCaso baja = new BajaTipoCaso();
         baja.inicializaBaja(this, abm, cod);
         baja.setVisible(true);
     }
     public void abrirAlta(SeleccionTipoCaso abm)
     {
         AltaTipoCaso alta = new AltaTipoCaso();
         alta.inicializaAlta(this, abm);
         alta.setVisible(true);
     }
      public void abrirConsultaTareas(DTOTipoCaso undto)
     {
         ConsultaIteraciones consulta;
         consulta = new ConsultaIteraciones();
         consulta.inicializaconsulta(this,undto);
         consulta.setVisible(true);
     }
   
 */   
}
