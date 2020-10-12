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
    
    public List<DTOTipoInstancia> buscarTipoInstancias(){
       List<DTOTipoInstancia> listaTipoInstancias = expertoTI.buscarTipoInstancia();
       return listaTipoInstancias;
    }
    public List<DTOTipoInstancia> buscarTipoInstancias(String nomfilTipoInstancia){
       List<DTOTipoInstancia> listaTipoInstancias = expertoTI.buscarTipoInstancia(nomfilTipoInstancia);
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
        try {
            expertoTI.modificarTipoInstancia(modTipoInstancia);
        } catch (Exception ex) {
            Logger.getLogger(ControladorABMSector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<DTOSector> buscarSectores(String nomfilSector){
       List<DTOSector> listaSectores = expertoTI.buscarSectores(nomfilSector);
       return listaSectores;
    }
     public List<DTOSector> buscarSectores(int codfilSector){
       List<DTOSector> listaSectores = expertoTI.buscarSectores(codfilSector);
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
