package Main.ABMTipoCaso;

import Main.DTOTipoCaso;
import Main.DTOTipoCasoIteracion;
import java.util.*;

/**
 *
 * @author FLIA HUDSON
 */
public class ControladorTipoCaso {
    ExpertoABMTipoCaso expertoTC = new ExpertoABMTipoCaso();
    public ControladorTipoCaso () {
    }
    

     public boolean daraltaTipoCaso(int codtipocaso, String nomTC, int maxiteraciones,List<DTOTipoCasoIteracion> iteraciones){
        return expertoTC.daraltaTipoCaso(codtipocaso, nomTC, maxiteraciones,iteraciones);
        }
    public boolean darbajaTipoCaso(int codtipocaso) {
        return expertoTC.darbajaTipoCaso(codtipocaso);
    }
    public boolean modificarTipoCaso (int codtipocaso, String nomTC,int maxiteraciones,List<DTOTipoCasoIteracion> iteraciones) {
        return expertoTC.modificarTipoCaso(codtipocaso, nomTC, maxiteraciones,iteraciones);
    }
     public List<DTOTipoCaso> buscarTipoCasos(String nomfilTipoCaso, String codfilTipoCaso){
       List<DTOTipoCaso> listatipocasos = expertoTC.buscarTipoCasos(nomfilTipoCaso,codfilTipoCaso);
       return listatipocasos;
    }
     public void abrirModificar(int cod, ABMTipoCaso abm)
     {
         ModTipoCaso mod = new ModTipoCaso();
         mod.inicializaModificar(this, abm, cod);
         mod.setVisible(true);
     }
     public void abrirBaja(int cod,ABMTipoCaso abm)
     {
         BajaTipoCaso baja = new BajaTipoCaso();
         baja.inicializaBaja(this, abm, cod);
         baja.setVisible(true);
     }
     public void abrirAlta(ABMTipoCaso abm)
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
   
    
}
