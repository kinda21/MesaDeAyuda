package Main;

import java.util.Date;

/**
 *
 * @author FLIA HUDSON
 */
public class DTOTipoTarea {
    private int codTipoTarea;
    private String nombreTipoTarea;
    private String descripcionTipoTarea;
    private Date fechaFinVigenciaTipoTarea;

    public DTOTipoTarea() {
    }

    public int getCodTipoTarea() {
        return codTipoTarea;
    }

    public void setCodTipoTarea(int codTipoTarea) {
        this.codTipoTarea = codTipoTarea;
    }

    public String getNombreTipoTarea() {
        return nombreTipoTarea;
    }

    public void setNombreTipoTarea(String nombreTipoTarea) {
        this.nombreTipoTarea = nombreTipoTarea;
    }

    public String getDescripcionTipoTarea() {
        return descripcionTipoTarea;
    }

    public void setDescripcionTipoTarea(String descripcionTipoTarea) {
        this.descripcionTipoTarea = descripcionTipoTarea;
    }

    public Date getFechaFinVigenciaTipoTarea() {
        return fechaFinVigenciaTipoTarea;
    }

    public void setFechaFinVigenciaTipoTarea(Date fechaFinVigenciaTipoTarea) {
        this.fechaFinVigenciaTipoTarea = fechaFinVigenciaTipoTarea;
    }
}
