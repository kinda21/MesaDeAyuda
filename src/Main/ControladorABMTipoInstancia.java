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
    public List<DTOTipoInstancia> buscarTipoInstancia(String nomfilTipoInstancia, String nomSector){
       List<DTOTipoInstancia> listaTipoInstancias = expertoTI.buscarTipoInstancia(nomfilTipoInstancia, nomSector);
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
    public boolean darAltaTipoInstancia(int codtipoinstancia, int codSector, String nomTI, List<DTOTipoTarea> tareas){
        return expertoTI.daraltaTipoInstancia(codtipoinstancia,codSector,nomTI,tareas);
    }
    public boolean darbajaTipoInstancia(int codTipoInstancia) {
        return expertoTI.darbajaTipoInstancia(codTipoInstancia);
    }
    
    public boolean modificarTipoInstancia (int codtipoinstancia,int codSector, String nomTI, List<DTOTipoTarea> tareas) {
        return expertoTI.modificarTipoInstancia(codtipoinstancia,codSector, nomTI, tareas);
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
    
     public void abrirAlta(ABMTipoInstancia abm)
     {
         AltaTipoInstancia alta = new AltaTipoInstancia();
         alta.inicializaAlta(this,abm);
         alta.setVisible(true);
     }
     public void abrirConsultaTareas(DTOTipoInstancia undto)
     {
         ConsultaTareas consulta;
         consulta = new ConsultaTareas();
         consulta.inicializaconsulta(this,undto);
         consulta.setVisible(true);
     }
     public void abrirBaja(int cod,ABMTipoInstancia abm)
     {
         BajaTipoInstancia baja = new BajaTipoInstancia();
         baja.inicializaBaja(this, abm, cod);
         baja.setVisible(true);
     }
     public void abrirModificar(int cod,ABMTipoInstancia abm)
     {
         ModTipoInstancia mod = new ModTipoInstancia();
         mod.inicializaModificar(this,abm, cod);
         mod.setVisible(true);
     }   
}
