package Entidades;
import java.util.*;

/**
 *
 * @author milig
 */

public class TipoInstancia extends Entidad {
    
    private int codTipoInstancia;
    private String nombreTipoInstancia;
    private Date fechaHoraFinVigenciaTipoInstancia;
    
    private Sector sector;
    private List<TipoTarea> listaTipoTarea = new ArrayList<>();

    public TipoInstancia() {
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

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public List<TipoTarea> getListaTipoTarea() {
        return listaTipoTarea;
    }

    public void setListaTipoTarea(List<TipoTarea> listaTipoTarea) {
        this.listaTipoTarea = listaTipoTarea;
    }
    
    public void addListaTipoTarea(TipoTarea tipotarea){
        listaTipoTarea.add(tipotarea);
    }
}
