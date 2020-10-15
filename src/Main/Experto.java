package Main;

import Entidades.*;
import Main.DTOCriterio;
import java.util.*;


public class Experto {

    public void Metodo() {
        crearElementos();
    }
    
    void crearElementos() {
        FachadaPersistencia.getInstance().iniciarTransaccion();
       // PRUEBAS SECTOR Y BUSQUEDA
        Sector sector = new Sector();
        sector.setCodSector(1);
        sector.setDescripcionSector("Recepcion de llamados");
        sector.setFechaHoraFinVigenciaSector(new Date());
        sector.setNombreSector("CALL CENTER");
        Sector sector2 = new Sector(2,"CENTRO DE COMPUTOS","otro sector");
        System.out.println("Sector 1");
         System.out.println(sector.getNombreSector());
         System.out.println(sector.getCodSector());
         System.out.println(sector.getDescripcionSector());
         System.out.println(sector.getFechaHoraFinVigenciaSector());
        System.out.println("Sector 2");
         System.out.println(sector2.getNombreSector());
         System.out.println(sector2.getCodSector());
         System.out.println(sector2.getDescripcionSector());
         System.out.println(sector2.getFechaHoraFinVigenciaSector());
         sector.setCodSector(12);
        FachadaPersistencia.getInstance().guardar(sector);
        FachadaPersistencia.getInstance().guardar(sector2);
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("codSector");
        criterio1.setOperacion("=");
        criterio1.setValor(12);
        List<DTOCriterio> criterioList = new ArrayList<>();
        criterioList.add(criterio1);
        Sector sector3 = (Sector)FachadaPersistencia.getInstance().buscar("Sector", criterioList).get(0);
        System.out.println("Sector 3");
         System.out.println(sector3.getNombreSector());
         System.out.println(sector3.getCodSector());
         System.out.println(sector3.getDescripcionSector());
         System.out.println(sector3.getFechaHoraFinVigenciaSector());
        
        // PRUEBAS TIPOTAREA
        
        TipoTarea tipotarea1 = new TipoTarea();
        tipotarea1.setCodTipoTarea(3);
        tipotarea1.setDescripcionTipoTarea("Este es un tipo de tarea");
        tipotarea1.setFechaFinVigenciaTipoTarea(null);
        tipotarea1.setNombreTipoTarea("Revisión");
        FachadaPersistencia.getInstance().guardar(tipotarea1);
        
        DTOCriterio criterio2 = new DTOCriterio();
        criterio2.setAtributo("codTipoTarea");
        criterio2.setOperacion("=");
        criterio2.setValor(3);
        // PRUEBA BUSQUEDA Y MUESTRA DE VARIOS TIPOTAREA
        List<DTOCriterio> criterioList2 = new ArrayList<>();
        criterioList2.add(criterio2);
        List ttareas = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList2);
        for (Object x : ttareas) {
            TipoTarea ttamostrar = (TipoTarea) x;
            System.out.println(ttamostrar.getCodTipoTarea());
            System.out.println(ttamostrar.getNombreTipoTarea());
            System.out.println(ttamostrar.getDescripcionTipoTarea());
            System.out.println(ttamostrar.getFechaFinVigenciaTipoTarea());
        }    
        //PRUEBAS CREAR, BUSCAR Y MOSTRAR TIPO INSTANCIA Y SUS TAREAS
        TipoInstancia tipoInst = new TipoInstancia();
        tipoInst.setCodTipoInstancia(1);
        tipoInst.setFechaHoraFinVigenciaTipoInstancia(null);
        tipoInst.setListaTipoTarea((List<TipoTarea>)(Object)ttareas);
        tipoInst.setNombreTipoInstancia("Tipo Instancia");
        tipoInst.setSector(sector);
        FachadaPersistencia.getInstance().guardar(tipoInst);
        DTOCriterio criterio3 = new DTOCriterio();
        criterio3.setAtributo("codTipoInstancia");
        criterio3.setOperacion("=");
        criterio3.setValor(0);
        List<DTOCriterio> criterioList3 = new ArrayList<>();
        criterioList3.add(criterio3);
        List resultsetTI = FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList3);
        for (Object x : resultsetTI) {
            TipoInstancia tiamostrar = (TipoInstancia) x;
            System.out.println(tiamostrar.getCodTipoInstancia());
            System.out.println(tiamostrar.getNombreTipoInstancia());
            System.out.println(tiamostrar.getFechaHoraFinVigenciaTipoInstancia());
            for (TipoTarea x2 : tiamostrar.getListaTipoTarea()) {
                TipoTarea ttamostrar2 = x2;
                System.out.println(ttamostrar2.getCodTipoTarea());
                System.out.println(ttamostrar2.getNombreTipoTarea());
                System.out.println(ttamostrar2.getDescripcionTipoTarea());
                System.out.println(ttamostrar2.getFechaFinVigenciaTipoTarea());
            }
        }    
        FachadaPersistencia.getInstance().finalizarTransaccion();
    }
    
    void busquedaDeUnElementoPorAtributo() {
    }
    
    void busquedaDeUnElementoPorAtributoNulo() {
    }
    
    void buscarTodosLosObjetosDeUnaClase() {
    }
    
    void buscarUnObjetoPorRelacion(){
    }
    
    void buscoUnObjetoQueContieneAOtroObjeto(){
    }
    
}
