package Entidades;
import java.util.*;

/**
 *
 * @author milig
 */

public class CasoInstancia extends Entidad {
    
    private Date fechaHoraInicioPlanificada;
    private Date fechaHoraFinPlanificada;
    private Date fechaHoraInicioReal;
    private Date fechaHoraFinReal;
    private String observaciones;
    private int ordenCasoInstancia;    
    
    private EstadoCasoInstancia estadocasoinstancia;
    private Especialista especialista;
    private TipoInstancia tipoinstancia; 
    private List<CasoInstanciaTarea> listaCasoInstanciaTarea = new ArrayList<>();
    
    public CasoInstancia() {
    }

    public Date getFechaHoraInicioPlanificada() {
        return fechaHoraInicioPlanificada;
    }

    public void setFechaHoraInicioPlanificada(Date fechaHoraInicioPlanificada) {
        this.fechaHoraInicioPlanificada = fechaHoraInicioPlanificada;
    }

    public Date getFechaHoraFinPlanificada() {
        return fechaHoraFinPlanificada;
    }

    public void setFechaHoraFinPlanificada(Date fechaHoraFinPlanificada) {
        this.fechaHoraFinPlanificada = fechaHoraFinPlanificada;
    }

    public Date getFechaHoraInicioReal() {
        return fechaHoraInicioReal;
    }

    public void setFechaHoraInicioReal(Date fechaHoraInicioReal) {
        this.fechaHoraInicioReal = fechaHoraInicioReal;
    }

    public Date getFechaHoraFinReal() {
        return fechaHoraFinReal;
    }

    public void setFechaHoraFinReal(Date fechaHoraFinReal) {
        this.fechaHoraFinReal = fechaHoraFinReal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getOrdenCasoInstancia() {
        return ordenCasoInstancia;
    }

    public void setOrdenCasoInstancia(int ordenCasoInstancia) {
        this.ordenCasoInstancia = ordenCasoInstancia;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public TipoInstancia getTipoinstancia() {
        return tipoinstancia;
    }

    public void setTipoinstancia(TipoInstancia tipoinstancia) {
        this.tipoinstancia = tipoinstancia;
    }

    public List<CasoInstanciaTarea> getListaCasoInstanciaTarea() {
        return listaCasoInstanciaTarea;
    }

    public void setListaCasoInstanciaTarea(List<CasoInstanciaTarea> listaCasoInstanciaTarea) {
        this.listaCasoInstanciaTarea = listaCasoInstanciaTarea;
    }
    
    public void addListaCasoInstanciaTarea (CasoInstanciaTarea casoinstanciatarea){
        listaCasoInstanciaTarea.add(casoinstanciatarea);
    }

    public EstadoCasoInstancia getEstadocasoinstancia() {
        return estadocasoinstancia;
    }

    public void setEstadocasoinstancia(EstadoCasoInstancia estadocasoinstancia) {
        this.estadocasoinstancia = estadocasoinstancia;
    }

}
