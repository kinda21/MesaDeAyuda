package Main;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FLIA HUDSON
 */
public class ControladorABMSector {
    ExpertoABMSector expertosector = new ExpertoABMSector();
    public ControladorABMSector () {
    }
    
    public List<DTOSector> buscarSectores(){
       List<DTOSector> listaSectores = expertosector.buscarSectores();
       return listaSectores;
    }
    public void darAltaSector(DTOSector altaSector){
        expertosector.daraltaSector(altaSector);
    }
    public void darbajaSector(int codSector) {
        expertosector.darbajaSector(codSector);
    }
    public void modificarSector (int codSector, String nomSector, String descSector) {
        try {
            expertosector.modificarSector(codSector, nomSector, descSector);
        } catch (Exception ex) {
            Logger.getLogger(ControladorABMSector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public List<DTOSector> buscarSectores(String nomfilSector){
       List<DTOSector> listaSectores = expertosector.buscarSectores(nomfilSector);
       return listaSectores;
    }
     public List<DTOSector> buscarSectores(int codfilSector){
       List<DTOSector> listaSectores = expertosector.buscarSectores(codfilSector);
       return listaSectores;
    }
     public void abrirModificar(int cod)
     {
         ModSector mod = new ModSector();
         mod.inicializaModificar(this, cod);
         mod.setVisible(true);
     }
     public void abrirBaja(int cod)
     {
         BajaSector baja = new BajaSector();
         baja.inicializaBaja(this, cod);
         baja.setVisible(true);
     }
     public void abrirAlta()
     {
         AltaSector alta = new AltaSector();
         alta.inicializaAlta(this);
         alta.setVisible(true);
     }
     
   
    
}
