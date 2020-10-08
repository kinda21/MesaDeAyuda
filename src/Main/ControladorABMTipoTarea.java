package Main;
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
    public void darAltaTipoTarea(DTOTipoTarea altaTipoTarea){
        expertoTipoTarea.daraltaTipoTarea(altaTipoTarea);
    }
    public void darbajaTipoTarea(int codTipoTarea) {
        expertoTipoTarea.darbajaTipoTarea(codTipoTarea);
    }
    public void modificarTipoTarea (int codTipoTarea, String nomTipoTarea, String descTipoTarea) {
        try {
            expertoTipoTarea.modificarTipoTarea(codTipoTarea, nomTipoTarea, descTipoTarea);
        } catch (Exception ex) {
            Logger.getLogger(ControladorABMTipoTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public List<DTOTipoTarea> buscarTipoTarea(String nomfilTipoTarea){
       List<DTOTipoTarea> listaTipoTarea = expertoTipoTarea.buscarTiposTarea(nomfilTipoTarea);
       return listaTipoTarea;
    }
     public List<DTOTipoTarea> buscarTipoTarea(int codfilTipoTarea){
       List<DTOTipoTarea> listaTipoTarea = expertoTipoTarea.buscarTiposTarea(codfilTipoTarea);
       return listaTipoTarea;
    }
     public void abrirModificar(int cod)
     {
         ModTipoTarea mod = new ModTipoTarea();
         mod.inicializaModificar(this, cod);
         mod.setVisible(true);
     }
     public void abrirBaja(int cod)
     {
         BajaTipoTarea baja = new BajaTipoTarea();
         baja.inicializaBaja(this, cod);
         baja.setVisible(true);
     }
     public void abrirAlta()
     {
         AltaTipoTarea alta = new AltaTipoTarea();
         alta.inicializaAlta(this);
         alta.setVisible(true);
     }
     
   
    
}
