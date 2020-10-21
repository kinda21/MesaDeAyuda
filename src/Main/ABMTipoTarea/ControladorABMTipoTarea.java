package Main.ABMTipoTarea;
import Main.ABMTipoTarea.ABMTipoTarea;
import Main.ABMTipoTarea.BajaTipoTarea;
import Main.ABMTipoTarea.AltaTipoTarea;
import Main.ABMTipoTarea.ExpertoABMTipoTarea;
import Main.ABMTipoTarea.ModTipoTarea;
import Main.DTOTipoTarea;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FLIA HUDSON
 */
public class ControladorABMTipoTarea {
    ExpertoABMTipoTarea expertoTipoTarea = new ExpertoABMTipoTarea();
    public ControladorABMTipoTarea () {
    }
    
    public List<DTOTipoTarea> buscarTipoTarea(){
       List<DTOTipoTarea> listaTipoTarea = expertoTipoTarea.buscarTiposTarea();
       return listaTipoTarea;
    }
    public boolean darAltaTipoTarea(int codTipoTarea, String nomTipoTarea, String descTipoTarea){
        return expertoTipoTarea.daraltaTipoTarea(codTipoTarea,nomTipoTarea,descTipoTarea);
    }
    public boolean darbajaTipoTarea(int codTipoTarea) {
        return expertoTipoTarea.darbajaTipoTarea(codTipoTarea);
    }
    public boolean modificarTipoTarea (int codTipoTarea, String nomTipoTarea, String descTipoTarea) {
        return expertoTipoTarea.modificarTipoTarea(codTipoTarea, nomTipoTarea, descTipoTarea);
    }
    public List<DTOTipoTarea> buscarTipoTarea(String nomfilTipoTarea, String codfilTipoTarea){
    List<DTOTipoTarea> listaTipoTarea = expertoTipoTarea.buscarTiposTarea(nomfilTipoTarea,codfilTipoTarea);
    return listaTipoTarea;
    }
     public List<DTOTipoTarea> buscarTipoTarea(String nomfilTipoTarea){
       List<DTOTipoTarea> listaTipoTarea = expertoTipoTarea.buscarTiposTarea(nomfilTipoTarea);
       return listaTipoTarea;
    }
     public List<DTOTipoTarea> buscarTipoTarea(int codfilTipoTarea){
       List<DTOTipoTarea> listaTipoTarea = expertoTipoTarea.buscarTiposTarea(codfilTipoTarea);
       return listaTipoTarea;
    }
     public void abrirModificar(int cod,ABMTipoTarea abm)
     {
         ModTipoTarea mod = new ModTipoTarea();
         mod.inicializaModificar(this,abm, cod);
         mod.setVisible(true);
     }
     public void abrirBaja(int cod,ABMTipoTarea abm)
     {
         BajaTipoTarea baja = new BajaTipoTarea();
         baja.inicializaBaja(this,abm, cod);
         baja.setVisible(true);
     }
     public void abrirAlta(ABMTipoTarea abm)
     {
         AltaTipoTarea alta = new AltaTipoTarea();
         alta.inicializaAlta(this,abm);
         alta.setVisible(true);
     }
     
   
    
}
