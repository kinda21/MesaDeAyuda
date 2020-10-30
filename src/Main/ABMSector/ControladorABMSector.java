package Main.ABMSector;
import Main.DTOSector;
import java.util.*;

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
    public boolean darAltaSector(int codSector, String nomSector, String descSector){
        return expertosector.daraltaSector(codSector, nomSector, descSector);
        }
    public boolean darbajaSector(int codSector) {
        return expertosector.darbajaSector(codSector);
    }
    public boolean modificarSector (int codSector, String nomSector, String descSector) {
        return expertosector.modificarSector(codSector, nomSector, descSector);
    }
     public List<DTOSector> buscarSectores(String nomfilSector){
       List<DTOSector> listaSectores = expertosector.buscarSectores(nomfilSector);
       return listaSectores;
    }
    public List<DTOSector> buscarSectores(String nomfilSector, String codfilSector){
    List<DTOSector> listaSectores = expertosector.buscarSectores(nomfilSector,codfilSector);
    return listaSectores;
    }
     public List<DTOSector> buscarSectores(int codfilSector){
       List<DTOSector> listaSectores = expertosector.buscarSectores(codfilSector);
       return listaSectores;
    }
     public void abrirModificar(int cod, ABMSector abm)
     {
         ModSector mod = new ModSector();
         mod.inicializaModificar(this, abm, cod);
         mod.setVisible(true);
     }
     public void abrirBaja(int cod,ABMSector abm)
     {
         BajaSector baja = new BajaSector();
         baja.inicializaBaja(this, abm, cod);
         baja.setVisible(true);
     }
     public void abrirAlta(ABMSector abm)
     {
         AltaSector alta = new AltaSector();
         alta.inicializaAlta(this, abm);
         alta.setVisible(true);
     }
     
   
    
}
