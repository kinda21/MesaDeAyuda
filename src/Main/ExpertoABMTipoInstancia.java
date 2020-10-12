package Main;

import Entidades.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FLIA HUDSON
 */
public class ExpertoABMTipoInstancia {
    public ExpertoABMTipoInstancia() {
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
    
    public List<DTOTipoInstancia> buscarTipoInstancia(){  
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoInstancia", null);
        List<DTOTipoInstancia> listaTipoInstancia = new ArrayList<>();
        for (Object x : objetoList) {
            TipoInstancia tipoInstancialeida = (TipoInstancia) x;
            DTOTipoInstancia tipoinstancia = new DTOTipoInstancia();
            tipoinstancia.setCodTipoInstancia(tipoInstancialeida.getCodTipoInstancia());
            tipoinstancia.setFechaHoraFinVigenciaTipoInstancia(tipoInstancialeida.getFechaHoraFinVigenciaTipoInstancia());
            tipoinstancia.setNombreTipoInstancia(tipoInstancialeida.getNombreTipoInstancia());
            Sector sectorleido = (Sector) tipoInstancialeida.getSector();
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            tipoinstancia.setDTOSector(sector);
            List<DTOTipoTarea> listaTipoTarea = new ArrayList<>();
            for (TipoTarea x2 : tipoInstancialeida.getListaTipoTarea() ) {
            TipoTarea tipotarealeida = x2;
            DTOTipoTarea tipotarea = new DTOTipoTarea();
            tipotarea.setCodTipoTarea(tipotarealeida.getCodTipoTarea());
            tipotarea.setDescripcionTipoTarea(tipotarealeida.getDescripcionTipoTarea());
            tipotarea.setFechaFinVigenciaTipoTarea(tipotarealeida.getFechaFinVigenciaTipoTarea());
            tipotarea.setNombreTipoTarea(tipotarealeida.getNombreTipoTarea());
            listaTipoTarea.add(tipotarea);
            tipoinstancia.addListaTipoTarea(tipotarea);
            }
            listaTipoInstancia.add(tipoinstancia);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaTipoInstancia;
        }
    public List<DTOTipoInstancia> buscarTipoInstancia(String nomfilTipoInstancia){  
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("nombreTipoInstancia");
        dto.setOperacion("like");
        dto.setValor(nomfilTipoInstancia);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList);
        List<DTOTipoInstancia> listaTipoInstancia = new ArrayList<>();
        for (Object x : objetoList) {
            TipoInstancia tipoInstancialeida = (TipoInstancia) x;
            DTOTipoInstancia tipoinstancia = new DTOTipoInstancia();
            tipoinstancia.setCodTipoInstancia(tipoInstancialeida.getCodTipoInstancia());
            tipoinstancia.setFechaHoraFinVigenciaTipoInstancia(tipoInstancialeida.getFechaHoraFinVigenciaTipoInstancia());
            tipoinstancia.setNombreTipoInstancia(tipoInstancialeida.getNombreTipoInstancia());
            Sector sectorleido = (Sector) tipoInstancialeida.getSector();
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            tipoinstancia.setDTOSector(sector);
            List<DTOTipoTarea> listaTipoTarea = new ArrayList<>();
            for (TipoTarea x2 : tipoInstancialeida.getListaTipoTarea() ) {
            TipoTarea tipotarealeida = x2;
            DTOTipoTarea tipotarea = new DTOTipoTarea();
            tipotarea.setCodTipoTarea(tipotarealeida.getCodTipoTarea());
            tipotarea.setDescripcionTipoTarea(tipotarealeida.getDescripcionTipoTarea());
            tipotarea.setFechaFinVigenciaTipoTarea(tipotarealeida.getFechaFinVigenciaTipoTarea());
            tipotarea.setNombreTipoTarea(tipotarealeida.getNombreTipoTarea());
            listaTipoTarea.add(tipotarea);
            tipoinstancia.addListaTipoTarea(tipotarea);
            }
            listaTipoInstancia.add(tipoinstancia);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaTipoInstancia;
        }
    public List<DTOTipoInstancia> buscarTipoInstancia(int codfilTipoInstancia){  
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoInstancia");
        dto.setOperacion("=");
        dto.setValor(codfilTipoInstancia);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList);
        List<DTOTipoInstancia> listaTipoInstancia = new ArrayList<>();
        for (Object x : objetoList) {
            TipoInstancia tipoInstancialeida = (TipoInstancia) x;
            DTOTipoInstancia tipoinstancia = new DTOTipoInstancia();
            tipoinstancia.setCodTipoInstancia(tipoInstancialeida.getCodTipoInstancia());
            tipoinstancia.setFechaHoraFinVigenciaTipoInstancia(tipoInstancialeida.getFechaHoraFinVigenciaTipoInstancia());
            tipoinstancia.setNombreTipoInstancia(tipoInstancialeida.getNombreTipoInstancia());
            Sector sectorleido = (Sector) tipoInstancialeida.getSector();
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            tipoinstancia.setDTOSector(sector);
            List<DTOTipoTarea> listaTipoTarea = new ArrayList<>();
            for (TipoTarea x2 : tipoInstancialeida.getListaTipoTarea() ) {
            TipoTarea tipotarealeida = x2;
            DTOTipoTarea tipotarea = new DTOTipoTarea();
            tipotarea.setCodTipoTarea(tipotarealeida.getCodTipoTarea());
            tipotarea.setDescripcionTipoTarea(tipotarealeida.getDescripcionTipoTarea());
            tipotarea.setFechaFinVigenciaTipoTarea(tipotarealeida.getFechaFinVigenciaTipoTarea());
            tipotarea.setNombreTipoTarea(tipotarealeida.getNombreTipoTarea());
            listaTipoTarea.add(tipotarea);
            tipoinstancia.addListaTipoTarea(tipotarea);
            }
            listaTipoInstancia.add(tipoinstancia);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaTipoInstancia;
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
            listaSectores.add(sector);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaSectores;
        }
    public List<DTOTipoTarea> buscarTiposTarea(){  
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", null);
        List<DTOTipoTarea> listaTiposTarea = new ArrayList<>();
        for (Object x : objetoList) {
            TipoTarea tipotarealeida = (TipoTarea) x;
            DTOTipoTarea tipotarea = new DTOTipoTarea();
            tipotarea.setCodTipoTarea(tipotarealeida.getCodTipoTarea());
            tipotarea.setDescripcionTipoTarea(tipotarealeida.getDescripcionTipoTarea());
            tipotarea.setFechaFinVigenciaTipoTarea(tipotarealeida.getFechaFinVigenciaTipoTarea());
            tipotarea.setNombreTipoTarea(tipotarealeida.getNombreTipoTarea());
            //System.out.println(sector.getCodSector());
            //System.out.println(sector.getDescripcionSector());
            //System.out.println(sector.getFechaHoraFinVigenciaSector());
            //System.out.println(sector.getNombreSector());
            listaTiposTarea.add(tipotarea);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaTiposTarea;
        }
    public List<DTOTipoTarea> buscarTiposTareasVigentes(){  
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOTipoTarea> listaTiposTarea = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("fechaFinVigenciaTipoTarea");
        dto.setOperacion("=");
        dto.setValor(null);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList);
        for (Object x : objetoList) {
            TipoTarea tipotarealeida = (TipoTarea) x;
            DTOTipoTarea tipotarea = new DTOTipoTarea();
            tipotarea.setCodTipoTarea(tipotarealeida.getCodTipoTarea());
            tipotarea.setDescripcionTipoTarea(tipotarealeida.getDescripcionTipoTarea());
            tipotarea.setFechaFinVigenciaTipoTarea(tipotarealeida.getFechaFinVigenciaTipoTarea());
            tipotarea.setNombreTipoTarea(tipotarealeida.getNombreTipoTarea());
            listaTiposTarea.add(tipotarea);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaTiposTarea;
        }
    public void daraltaTipoInstancia(DTOTipoInstancia altatipoinstancia) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        TipoInstancia nuevoTI = new TipoInstancia();
        try {
        nuevoTI.setCodTipoInstancia(altatipoinstancia.getCodTipoInstancia());
        nuevoTI.setFechaHoraFinVigenciaTipoInstancia(null);
        nuevoTI.setNombreTipoInstancia(altatipoinstancia.getNombreTipoInstancia());
        int codSector = altatipoinstancia.getDTOSector().getCodSector();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codSector");
        dto.setOperacion("=");
        dto.setValor(codSector);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
        Sector SectoraAsignar = (Sector)objetoList.get(0);
        nuevoTI.setSector(SectoraAsignar);
        List listatareasAsignadas = altatipoinstancia.getListaDTOTipoTarea();
        List<TipoTarea> listaTiposTarea = new ArrayList<>();
        for (Object x : listatareasAsignadas) {
            DTOTipoTarea DTOtipotarealeida = (DTOTipoTarea) x;
            int codTarea = DTOtipotarealeida.getCodTipoTarea();    
            dto.setAtributo("codTipoTarea");
            dto.setOperacion("=");
            dto.setValor(codTarea);
            criterioList.clear();
            criterioList.add(dto);
            List objetoList2 = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList);
            for (Object x2 : objetoList2) {
                TipoTarea tipotarea = (TipoTarea) x2;
                if(tipotarea.getFechaFinVigenciaTipoTarea() != null){
                    JOptionPane.showMessageDialog(null, "El Tipo Tarea ingresado es incorrecto, ya fue dado de baja");
                    return;
                }
                listaTiposTarea.add(tipotarea);
            }
        nuevoTI.setListaTipoTarea(listaTiposTarea);
        List objetoList3 = FachadaPersistencia.getInstance().buscar("TipoInstancia", null);
        List<DTOTipoInstancia> listaTiposInstancia = new ArrayList<>();
        if(nuevoTI.getCodTipoInstancia()== 0){
            JOptionPane.showMessageDialog(null, "El codigo ingresado es incorrecto, valor nulo no aceptado.");
                    return;
        }else if(nuevoTI.getCodTipoInstancia()< 0){
                JOptionPane.showMessageDialog(null, "El codigo ingresado es incorrecto, valor negativo no aceptado.");
                return;
        }else
            for (Object x3 : objetoList3) {
                TipoInstancia TIaverificar = (TipoInstancia) x3;
                if(nuevoTI.getCodTipoInstancia()== TIaverificar.getCodTipoInstancia()){
                    JOptionPane.showMessageDialog(null, "El codigo ingresado no es valido, valor repetido.");
                    return;
                }  
            }
        }
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al crear el Sector");
             }
        //System.out.println("!");
        //System.out.println("Guardando nuevo Tipo Instancia");
        FachadaPersistencia.getInstance().guardar(nuevoTI);
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        }
        public void modificarTipoInstancia(DTOTipoInstancia modtipoinstancia) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoInstancia");
        dto.setOperacion("=");
        dto.setValor(modtipoinstancia.getCodTipoInstancia());
        criterioList.add(dto);
        TipoInstancia TIamodificar = (TipoInstancia)FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList).get(0);
        List<TipoTarea> listaTiposTarea = new ArrayList<>();
        try {
            TIamodificar.setNombreTipoInstancia(modtipoinstancia.getNombreTipoInstancia());
            dto.setAtributo("codSector");
            dto.setOperacion("=");
            dto.setValor(modtipoinstancia.getDTOSector().getCodSector());
            criterioList.clear();
            criterioList.add(dto);
            Sector sectorasignado = (Sector)FachadaPersistencia.getInstance().buscar("Sector", criterioList);
            TIamodificar.setSector(sectorasignado);
            TIamodificar.getListaTipoTarea().clear();
            List<DTOTipoTarea> listatareasAsignadas = modtipoinstancia.getListaDTOTipoTarea();
            for (Object x : listatareasAsignadas) {
                DTOTipoTarea DTOtipotarealeida = (DTOTipoTarea) x;
                int codTarea = DTOtipotarealeida.getCodTipoTarea();    
                dto.setAtributo("codTipoTarea");
                dto.setOperacion("=");
                dto.setValor(codTarea);
                criterioList.clear();
                criterioList.add(dto);
                List objetoList2 = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList);
                for (Object x2 : objetoList2) {
                    TipoTarea tipotarea = (TipoTarea) x2;
                    if(tipotarea.getFechaFinVigenciaTipoTarea() != null){
                        JOptionPane.showMessageDialog(null, "El Tipo Tarea ingresado es incorrecto, ya fue dado de baja");
                        return;
                    }
                    listaTiposTarea.add(tipotarea);
                }
            }
        }    
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al crear el Sector");
             }    
        TIamodificar.setListaTipoTarea(listaTiposTarea);
        FachadaPersistencia.getInstance().guardar(TIamodificar);
        System.out.println("!");
        System.out.println("Guardando TI");
    }
    public void darbajaTipoInstancia(int codTipoInstancia) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoInstancia");
        dto.setOperacion("=");
        dto.setValor(codTipoInstancia);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList);
        TipoInstancia tipoInstanciadebaja = (TipoInstancia)objetoList.get(0);
        Date fechadehoy = new Date();
        tipoInstanciadebaja.setFechaHoraFinVigenciaTipoInstancia(fechadehoy);
        FachadaPersistencia.getInstance().guardar(tipoInstanciadebaja);
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        }
    
    }
    
