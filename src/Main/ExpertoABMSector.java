package Main;

import Entidades.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FLIA HUDSON
 */
public class ExpertoABMSector {
    public ExpertoABMSector() {
    //    PRUEBAS DE LOS MÉTODOS.
    //    FachadaPersistencia.getInstance().iniciarTransaccion();
    //    DTOSector prueba = new DTOSector();
    //    prueba.setCodSector(333);
    //    prueba.setDescripcionSector("probando ABM");
    //    prueba.setFechaHoraFinVigenciaSector(null);
    //    prueba.setNombreSector("prueba sin pantalla");
    //    daraltaSector(prueba);
    //    darbajaSector(333);
    //    modificarSector(333,"prueba superada","ya lo probe");
    }
    
    public List<DTOSector> buscarSectores(){  
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", null);
        List<DTOSector> listaSectores = new ArrayList<>();
        for (Object x : objetoList) {
            Sector sectorleido = (Sector) x;
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            //System.out.println(sector.getCodSector());
            //System.out.println(sector.getDescripcionSector());
            //System.out.println(sector.getFechaHoraFinVigenciaSector());
            //System.out.println(sector.getNombreSector());
            listaSectores.add(sector);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaSectores;
        }
    public List<DTOSector> buscarSectoresVigentes(){  
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOSector> listaSectores = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("fechaHoraFinVigenciaSector");
        dto.setOperacion("=");
        dto.setValor(null);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
        for (Object x : objetoList) {
            Sector sectorleido = (Sector) x;
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            //System.out.println(sector.getCodSector());
            //System.out.println(sector.getDescripcionSector());
            //System.out.println(sector.getFechaHoraFinVigenciaSector());
            //System.out.println(sector.getNombreSector());
            listaSectores.add(sector);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaSectores;
        }
    public List<DTOSector> buscarSectores(String filNombreSector){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOSector> listaSectores = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("nombreSector");
        dto.setOperacion("like");
        dto.setValor(filNombreSector);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
        for (Object x : objetoList) {
            Sector sectorleido = (Sector) x;
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            listaSectores.add(sector);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaSectores;
    }
    public List<DTOSector> buscarSectores(int filcodSector){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOSector> listaSectores = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codSector");
        dto.setOperacion("=");
        dto.setValor(filcodSector);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
        for (Object x : objetoList) {
            Sector sectorleido = (Sector) x;
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            listaSectores.add(sector);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaSectores;
    }
    public void daraltaSector(DTOSector altaSector) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        Sector nuevoSector = new Sector();
        try {
        nuevoSector.setCodSector(altaSector.getCodSector());
        nuevoSector.setDescripcionSector(altaSector.getDescripcionSector());
        nuevoSector.setFechaHoraFinVigenciaSector(null);
        nuevoSector.setNombreSector(altaSector.getNombreSector());
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", null);
        List<DTOSector> listaSectores = new ArrayList<>();
        if(nuevoSector.getCodSector()== 0){
            JOptionPane.showMessageDialog(null, "El codigo ingresado es incorrecto, valor nulo no aceptado.");
                    return;
        }else if(nuevoSector.getCodSector()< 0){
                JOptionPane.showMessageDialog(null, "El codigo ingresado es incorrecto, valor negativo no aceptado.");
                return;
        }else
            for (Object x : objetoList) {
                Sector sectoraverificar = (Sector) x;
                if(nuevoSector.getCodSector() == sectoraverificar.getCodSector()){
                    JOptionPane.showMessageDialog(null, "El codigo ingresado no es valido, valor repetido.");
                    return;
                }  
            }
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al crear el Sector");
             }
        FachadaPersistencia.getInstance().guardar(nuevoSector);
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        }
    public void darbajaSector(int codSector) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codSector");
        dto.setOperacion("=");
        dto.setValor(codSector);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
        Sector sectordebaja = (Sector)objetoList.get(0);
        Date fechadehoy = new Date();
        sectordebaja.setFechaHoraFinVigenciaSector(fechadehoy);
        FachadaPersistencia.getInstance().guardar(sectordebaja);
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        }
    public void modificarSector (int codSector, String nomSector, String descSector) throws Exception {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codSector");
        dto.setOperacion("=");
        dto.setValor(codSector);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
        Sector sectoramodif = (Sector)objetoList.get(0);
        if (sectoramodif.getFechaHoraFinVigenciaSector() != null){
            JOptionPane.showMessageDialog(null,"No se puede modificar un Sector dado de baja" );
            throw new Exception();
        }
        sectoramodif.setNombreSector(nomSector);
        sectoramodif.setDescripcionSector(descSector);
        FachadaPersistencia.getInstance().guardar(sectoramodif);
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        }
    }
    


    

