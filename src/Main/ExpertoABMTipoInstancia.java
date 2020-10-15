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
            tipoinstancia.setCodSector(sectorleido.getCodSector());
            tipoinstancia.setNombreSector(sectorleido.getNombreSector());
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
    public List<DTOTipoInstancia> buscarTipoInstancia(String nomfilTipoInstancia, String nomSector){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOTipoInstancia> listaTipoInstancia = new ArrayList<>();
        //si los 2 argumentos vienen vacios traigo todos los TI
        if (nomfilTipoInstancia.equals("") && nomSector.equals("")) {
            List objetoList = FachadaPersistencia.getInstance().buscar("TipoInstancia", null);
            for (Object x : objetoList) {
                TipoInstancia tipoInstancialeida = (TipoInstancia) x;
                DTOTipoInstancia tipoinstancia = new DTOTipoInstancia();
                tipoinstancia.setCodTipoInstancia(tipoInstancialeida.getCodTipoInstancia());
                tipoinstancia.setFechaHoraFinVigenciaTipoInstancia(tipoInstancialeida.getFechaHoraFinVigenciaTipoInstancia());
                tipoinstancia.setNombreTipoInstancia(tipoInstancialeida.getNombreTipoInstancia());
                Sector sectorleido = (Sector) tipoInstancialeida.getSector();
                tipoinstancia.setCodSector(sectorleido.getCodSector());
                tipoinstancia.setNombreSector(sectorleido.getNombreSector());
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
        }
        //si solo viene el nombre traigo todos los TI con ese nombre
        if (!nomfilTipoInstancia.equals("") && nomSector.equals("")) {
            List<DTOCriterio> criterioList = new ArrayList<>();
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("nombreTipoInstancia");
            dto.setOperacion("like");
            dto.setValor(nomfilTipoInstancia);
            criterioList.add(dto);
            List objetoList = FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList);
            for (Object x : objetoList) {
                TipoInstancia tipoInstancialeida = (TipoInstancia) x;
                DTOTipoInstancia tipoinstancia = new DTOTipoInstancia();
                tipoinstancia.setCodTipoInstancia(tipoInstancialeida.getCodTipoInstancia());
                tipoinstancia.setFechaHoraFinVigenciaTipoInstancia(tipoInstancialeida.getFechaHoraFinVigenciaTipoInstancia());
                tipoinstancia.setNombreTipoInstancia(tipoInstancialeida.getNombreTipoInstancia());
                Sector sectorleido = (Sector) tipoInstancialeida.getSector();
                tipoinstancia.setCodSector(sectorleido.getCodSector());
                tipoinstancia.setNombreSector(sectorleido.getNombreSector());
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
        }
        //si solo viene el nombre del sector traigo a todos los TI que contengan a ese sector
        if (nomfilTipoInstancia.equals("") && !nomSector.equals("")) {
            List<DTOCriterio> criterioList = new ArrayList<>();
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("nombreSector");
            dto.setOperacion("like");
            dto.setValor(nomSector);
            criterioList.add(dto);
            List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
            for (Object x : objetoList) {
                Sector sectoracomparar = (Sector) x;
                dto.setAtributo("sector");
                dto.setOperacion("=");
                dto.setValor(sectoracomparar);
                criterioList.clear();
                criterioList.add(dto);
                List objetoList2 = FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList);
                for (Object x2 : objetoList2) {
                    TipoInstancia tipoInstancialeida = (TipoInstancia) x2;
                    DTOTipoInstancia tipoinstancia = new DTOTipoInstancia();
                    tipoinstancia.setCodTipoInstancia(tipoInstancialeida.getCodTipoInstancia());
                    tipoinstancia.setFechaHoraFinVigenciaTipoInstancia(tipoInstancialeida.getFechaHoraFinVigenciaTipoInstancia());
                    tipoinstancia.setNombreTipoInstancia(tipoInstancialeida.getNombreTipoInstancia());
                    Sector sectorleido = (Sector) tipoInstancialeida.getSector();
                    tipoinstancia.setCodSector(sectorleido.getCodSector());
                    tipoinstancia.setNombreSector(sectorleido.getNombreSector());
                    List<DTOTipoTarea> listaTipoTarea = new ArrayList<>();
                    for (TipoTarea x3 : tipoInstancialeida.getListaTipoTarea() ) {
                        TipoTarea tipotarealeida = x3;
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
            }
        
        }
        //si vienen los dos argumentos inicializados busco todos los tipo instancia que cumpla con ambos
        if (!nomfilTipoInstancia.equals("") && !nomSector.equals("")) {
            List<DTOCriterio> criterioList = new ArrayList<>();
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("nombreSector");
            dto.setOperacion("like");
            dto.setValor(nomSector);
            criterioList.add(dto);
            List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
            for (Object x : objetoList) {
                Sector sectoracomparar = (Sector) x;
                dto.setAtributo("sector");
                dto.setOperacion("=");
                dto.setValor(sectoracomparar);
                criterioList.clear();
                DTOCriterio dto2 = new DTOCriterio();
                dto2.setAtributo("nombreTipoInstancia");
                dto2.setOperacion("like");
                dto2.setValor(nomfilTipoInstancia);
                criterioList.add(dto);
                criterioList.add(dto2);
                List objetoList2 = FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList);
                for (Object x2 : objetoList2) {
                    TipoInstancia tipoInstancialeida = (TipoInstancia) x2;
                    DTOTipoInstancia tipoinstancia = new DTOTipoInstancia();
                    tipoinstancia.setCodTipoInstancia(tipoInstancialeida.getCodTipoInstancia());
                    tipoinstancia.setFechaHoraFinVigenciaTipoInstancia(tipoInstancialeida.getFechaHoraFinVigenciaTipoInstancia());
                    tipoinstancia.setNombreTipoInstancia(tipoInstancialeida.getNombreTipoInstancia());
                    Sector sectorleido = (Sector) tipoInstancialeida.getSector();
                    tipoinstancia.setCodSector(sectorleido.getCodSector());
                    tipoinstancia.setNombreSector(sectorleido.getNombreSector());
                    List<DTOTipoTarea> listaTipoTarea = new ArrayList<>();
                    for (TipoTarea x3 : tipoInstancialeida.getListaTipoTarea() ) {
                        TipoTarea tipotarealeida = x3;
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
            }
        
                }

        
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
            tipoinstancia.setCodSector(sectorleido.getCodSector());
            tipoinstancia.setNombreSector(sectorleido.getNombreSector());
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
    public List<DTOSector> buscarSectores(String filNombreSector, String filCodSector){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOSector> listaSectores = new ArrayList<>();
        //si vienen vacios busco todos los sectores
        if ("".equals(filNombreSector) && "".equals(filCodSector)) {
            List objetoList = FachadaPersistencia.getInstance().buscar("Sector", null);
            for (Object x : objetoList) {
            Sector sectorleido = (Sector) x;
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            listaSectores.add(sector);
            }
        }
        //si filCodSector viene vacío y filNombreSector no, busco sector por nombre
        if ("".equals(filCodSector) && !"".equals(filNombreSector)){
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
        }
        //si filCodSector no viene vacío y filNomSector viene vacío busco por codigo sector
        if (!"".equals(filCodSector) && "".equals(filNombreSector)){
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("codSector");
            dto.setOperacion("=");
            dto.setValor(Integer.parseInt(filCodSector));
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
        }
        //si ninguno viene vacío, busco todos los que tengan el nombre y sean mayores? al codigo enviado
        if (!"".equals(filCodSector) && !"".equals(filNombreSector)) {
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("nombreSector");
            dto.setOperacion("like");
            dto.setValor(filNombreSector);
            criterioList.add(dto);
            DTOCriterio dto2 = new DTOCriterio();
            dto2.setAtributo("codSector");
            dto2.setOperacion(">=");
            dto2.setValor(Integer.parseInt(filCodSector));      
            criterioList.add(dto2);
            // List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
            List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
            for (Object x : objetoList) {
                Sector sectorleido = (Sector) x;
                //if (sectorleido.getCodSector()>=Integer.parseInt(filCodSector)) {
                    DTOSector sector = new DTOSector();
                    sector.setCodSector(sectorleido.getCodSector());
                    sector.setDescripcionSector(sectorleido.getDescripcionSector());
                    sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
                    sector.setNombreSector(sectorleido.getNombreSector());
                    listaSectores.add(sector);
                //} 
            }
        }   
        return listaSectores; 
    }    
    public List<DTOSector> buscarSectoresVigentes(){  
       // FachadaPersistencia.getInstance().iniciarTransaccion();
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
    public boolean daraltaTipoInstancia(int codtipoinstancia, int codSector, String nomTI, List<DTOTipoTarea> tareas) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        TipoInstancia nuevoTI = new TipoInstancia();
        try {
        nuevoTI.setCodTipoInstancia(codtipoinstancia);
        nuevoTI.setFechaHoraFinVigenciaTipoInstancia(null);
        nuevoTI.setNombreTipoInstancia(nomTI);
        if (nuevoTI.getNombreTipoInstancia().equals("")) {
            JOptionPane.showMessageDialog(null, "El nombre ingresado es incorrecto, valor nulo no aceptado");
            return false;
        }
        int codigosector = codSector;
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codSector");
        dto.setOperacion("=");
        dto.setValor(codigosector);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
        Sector sectoraAsignar = (Sector)objetoList.get(0);
        if(sectoraAsignar.getFechaHoraFinVigenciaSector() != null){
            JOptionPane.showMessageDialog(null, "El Sector ingresado es incorrecto, ya fue dado de baja");
            return false;
        }
        nuevoTI.setSector(sectoraAsignar);
        List listatareasAsignadas = tareas;
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
                    return false;
                }
                listaTiposTarea.add(tipotarea);
            }
        nuevoTI.setListaTipoTarea(listaTiposTarea);
        List objetoList3 = FachadaPersistencia.getInstance().buscar("TipoInstancia", null);
        if(nuevoTI.getCodTipoInstancia()== 0){
            JOptionPane.showMessageDialog(null, "El codigo ingresado es incorrecto, valor nulo no aceptado.");
                    return false;
        }else if(nuevoTI.getCodTipoInstancia()< 0){
                JOptionPane.showMessageDialog(null, "El codigo ingresado es incorrecto, valor negativo no aceptado.");
                return false;
        }else
            for (Object x3 : objetoList3) {
                TipoInstancia TIaverificar = (TipoInstancia) x3;
                if(nuevoTI.getCodTipoInstancia()== TIaverificar.getCodTipoInstancia()){
                    JOptionPane.showMessageDialog(null, "El codigo ingresado no es valido, ya existe un Tipo Instancia con ese código.");
                    return false;
                }  
            }
        }
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al crear el Sector");
            return false; }
        //System.out.println("!");
        //System.out.println("Guardando nuevo Tipo Instancia");
        FachadaPersistencia.getInstance().guardar(nuevoTI);
        return true;
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        }
        public boolean modificarTipoInstancia(int codtipoinstancia, int codSector, String nomTI, List<DTOTipoTarea> tareas) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        int codigoTI = codtipoinstancia;
        /* CONTROL PREVIO A MODIFICAR INSTANCIA
        if (nomTI.equals("")) {
                JOptionPane.showMessageDialog(null, "El nombre ingresado es incorrecto, valor nulo no aceptado");
                return false;
            }*/
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoInstancia");
        dto.setOperacion("=");
        dto.setValor(codigoTI);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList);
        TipoInstancia TIamodificar = (TipoInstancia)objetoList.get(0);
        if (TIamodificar.getFechaHoraFinVigenciaTipoInstancia() != null) {
            JOptionPane.showMessageDialog(null, "El Tipo Instancia a modificar se encuentra dado de baja");
            return false;
        }
        List<TipoTarea> listaTiposTarea = new ArrayList<>();
            TIamodificar.setNombreTipoInstancia(nomTI);
            if (TIamodificar.getNombreTipoInstancia().equals("")) {
                JOptionPane.showMessageDialog(null, "El nombre ingresado es incorrecto, valor nulo no aceptado");
                return false;
            }
            dto.setAtributo("codSector");
            dto.setOperacion("=");
            dto.setValor(codSector);
            criterioList.clear();
            criterioList.add(dto);
            Sector sectorasignado = (Sector)FachadaPersistencia.getInstance().buscar("Sector", criterioList).get(0);
            if(sectorasignado.getFechaHoraFinVigenciaSector() != null){
                JOptionPane.showMessageDialog(null, "El Sector ingresado es incorrecto, ya fue dado de baja");
                return false;
                }
            TIamodificar.setSector(sectorasignado);
            TIamodificar.setListaTipoTarea(listaTiposTarea);
            List<DTOTipoTarea> listatareasAsignadas = new ArrayList<>();
            listatareasAsignadas = tareas;
            for (Object x : listatareasAsignadas) {
                DTOTipoTarea DTOtipotarealeida = (DTOTipoTarea) x;  
                dto.setAtributo("codTipoTarea");
                dto.setOperacion("=");
                dto.setValor(DTOtipotarealeida.getCodTipoTarea());
                criterioList.clear();
                criterioList.add(dto);
                TipoTarea tipotarea = (TipoTarea) FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList).get(0);
                if(tipotarea.getFechaFinVigenciaTipoTarea() != null){
                        JOptionPane.showMessageDialog(null, "El Tipo Tarea ingresado es incorrecto, ya fue dado de baja");
                        return false;
                    }
                listaTiposTarea.add(tipotarea);   
            }          
        TIamodificar.setListaTipoTarea(listaTiposTarea);
        FachadaPersistencia.getInstance().guardar(TIamodificar);
 //       FachadaPersistencia.getInstance().finalizarTransaccion();
        return true;
    }
    public boolean darbajaTipoInstancia(int codTipoInstancia) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoInstancia");
        dto.setOperacion("=");
        dto.setValor(codTipoInstancia);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList);
        TipoInstancia tipoInstanciadebaja = (TipoInstancia)objetoList.get(0);
        if (tipoInstanciadebaja.getFechaHoraFinVigenciaTipoInstancia()!= null){
            JOptionPane.showMessageDialog(null,"Este Tipo Instancia ya esta dado de baja" );
            return false;
        }
        Date fechadehoy = new Date();
        tipoInstanciadebaja.setFechaHoraFinVigenciaTipoInstancia(fechadehoy);
        FachadaPersistencia.getInstance().guardar(tipoInstanciadebaja);
        return true;
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        }
    
    }
    
