package Main;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FLIA HUDSON
 */
public class ControladorABMTipoInstancia {
    ExpertoABMTipoInstancia expertoTI = new ExpertoABMTipoInstancia();
    public ControladorABMTipoInstancia () {
    }
    public List<DTOTipoInstancia> buscarTipoInstancia(String nomfilTipoInstancia, String nomSector, String nomTipoTarea){
       List<DTOTipoInstancia> listaTipoInstancias = expertoTI.buscarTipoInstancia(nomfilTipoInstancia, nomSector, nomTipoTarea);
       return listaTipoInstancias;
    }
    public List<DTOTipoInstancia> buscarTipoInstancias(){
       List<DTOTipoInstancia> listaTipoInstancias = expertoTI.buscarTipoInstancia();
       return listaTipoInstancias;
    }
    public List<DTOTipoInstancia> buscarTipoInstancias(int codfilTipoInstancia){
       List<DTOTipoInstancia> listaTipoInstancias = expertoTI.buscarTipoInstancia(codfilTipoInstancia);
       return listaTipoInstancias;
    }
    public void darAltaTipoInstancia(DTOTipoInstancia altaTipoInstancia){
        expertoTI.daraltaTipoInstancia(altaTipoInstancia);
    }
    public void darbajaTipoInstancia(int codTipoInstancia) {
        expertoTI.darbajaTipoInstancia(codTipoInstancia);
    }
    
    public void modificarTipoInstancia (DTOTipoInstancia modTipoInstancia) {
        expertoTI.modificarTipoInstancia(modTipoInstancia);
    }
    public List<DTOSector> buscarSectores(String nomfilSector, String codfilSector){
    List<DTOSector> listaSectores = expertoTI.buscarSectores(nomfilSector,codfilSector);
    return listaSectores;
    }
    
    public List<DTOSector> buscarSectoresVigentes(){
       List<DTOSector> listaSectores = expertoTI.buscarSectoresVigentes();
       return listaSectores;
    }
    public List<DTOTipoTarea> buscarTiposTareaVigentes(){
       List<DTOTipoTarea> listaTiposTarea = expertoTI.buscarTiposTareasVigentes();
       return listaTiposTarea;
    }
    
     public void abrirAlta()
     {
         AltaTipoInstancia alta = new AltaTipoInstancia();
         alta.inicializaAlta(this);
         alta.setVisible(true);
     }
     public void abrirConsultaTareas(DTOTipoInstancia undto)
     {
         ConsultaTareas consulta;
         consulta = new ConsultaTareas();
         consulta.inicializaconsulta(this,undto);
         consulta.setVisible(true);
     }
     public void abrirBaja(int cod)
     {
         BajaTipoInstancia baja = new BajaTipoInstancia();
         baja.inicializaBaja(this, cod);
         baja.setVisible(true);
     }
     public void abrirModificar(int cod)
     {
         ModTipoInstancia mod = new ModTipoInstancia();
         mod.inicializaModificar(this, cod);
         mod.setVisible(true);
     }   
}
