package Main.ABMTipoCaso;
import Main.DTOTipoCaso;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FLIA HUDSON
 */
public class ControladorTipoCaso {
    ExpertoABMTipoCaso expertoTC = new ExpertoABMTipoCaso();
    public ControladorTipoCaso () {
    }
    

     public boolean daraltaTipoCaso(int codtipocaso, String nomTC, int maxiteraciones){
        return expertoTC.daraltaTipoCaso(codtipocaso, nomTC, maxiteraciones);
        }
    public boolean darbajaTipoCaso(int codtipocaso) {
        return expertoTC.darbajaTipoCaso(codtipocaso);
    }
    public boolean modificarTipoCaso (int codtipocaso, String nomTC,int maxiteraciones) {
        return expertoTC.modificarTipoCaso(codtipocaso, nomTC, maxiteraciones);
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
