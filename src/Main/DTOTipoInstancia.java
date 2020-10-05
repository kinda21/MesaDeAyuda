package Main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FLIA HUDSON
 */
public class DTOTipoInstancia {
    private int codTipoInstancia;
    private String nombreTipoInstancia;
    private Date fechaHoraFinVigenciaTipoInstancia;
    
    private DTOSector dtosector;
    private List<DTOTipoTarea> listaDTOTipoTarea = new ArrayList<>();

    public DTOTipoInstancia() {
    }

    public int getCodTipoInstancia() {
        return codTipoInstancia;
    }

    public void setCodTipoInstancia(int codTipoInstancia) {
        this.codTipoInstancia = codTipoInstancia;
    }

    public String getNombreTipoInstancia() {
        return nombreTipoInstancia;
    }

    public void setNombreTipoInstancia(String nombreTipoInstancia) {
        this.nombreTipoInstancia = nombreTipoInstancia;
    }

    public Date getFechaHoraFinVigenciaTipoInstancia() {
        return fechaHoraFinVigenciaTipoInstancia;
    }

    public void setFechaHoraFinVigenciaTipoInstancia(Date fechaHoraFinVigenciaTipoInstancia) {
        this.fechaHoraFinVigenciaTipoInstancia = fechaHoraFinVigenciaTipoInstancia;
    }

    public DTOSector getDTOSector() {
        return dtosector;
    }

    public void setDTOSector(DTOSector sector) {
        this.dtosector = sector;
    }

    public List<DTOTipoTarea> getListaDTOTipoTarea() {
        return listaDTOTipoTarea;
    }

    public void setListaTipoTarea(List<DTOTipoTarea> listaDTOTipoTarea) {
        this.listaDTOTipoTarea = listaDTOTipoTarea;
    }
    
    public void addListaTipoTarea(DTOTipoTarea tipotarea){
        listaDTOTipoTarea.add(tipotarea);
    }
}
