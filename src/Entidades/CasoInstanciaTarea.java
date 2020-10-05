package Entidades;
import java.util.*;

/**
 *
 * @author milig
 */

public class CasoInstanciaTarea extends Entidad {
    
    private Date fechaHoraInicioCasoInstanciaTarea;
    private Date fechaHoraFinCasoInstanciaTarea;
    private String observacionesCasoInstanciaTarea;
    
    private TipoTarea tipotarea;

    public CasoInstanciaTarea() {
    }

    public Date getFechaHoraInicioCasoInstanciaTarea() {
        return fechaHoraInicioCasoInstanciaTarea;
    }

    public void setFechaHoraInicioCasoInstanciaTarea(Date fechaHoraInicioCasoInstanciaTarea) {
        this.fechaHoraInicioCasoInstanciaTarea = fechaHoraInicioCasoInstanciaTarea;
    }

    public Date getFechaHoraFinCasoInstanciaTarea() {
        return fechaHoraFinCasoInstanciaTarea;
    }

    public void setFechaHoraFinCasoInstanciaTarea(Date fechaHoraFinCasoInstanciaTarea) {
        this.fechaHoraFinCasoInstanciaTarea = fechaHoraFinCasoInstanciaTarea;
    }

    public String getObservacionesCasoInstanciaTarea() {
        return observacionesCasoInstanciaTarea;
    }

    public void setObservacionesCasoInstanciaTarea(String observacionesCasoInstanciaTarea) {
        this.observacionesCasoInstanciaTarea = observacionesCasoInstanciaTarea;
    }

    public TipoTarea getTipotarea() {
        return tipotarea;
    }

    public void setTipotarea(TipoTarea tipotarea) {
        this.tipotarea = tipotarea;
    }
   
}
