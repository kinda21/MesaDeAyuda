package Entidades;
import java.util.*;

/**
 *
 * @author milig
 */

public class Caso extends Entidad {

    private int numeroCaso;
    private Date fechaHoraFinCaso;
    private Date fechaHoraIngresoCaso;
    private Date fechaHoraCaducidadCaso;
    private int numeroCliente;
    private int numeroIteracion;
    private String observacionCaso;
    
    private EstadoCaso estadocaso; //* a 1
    private Caso casoiteracion;                                         
    private List<CasoInstancia> listaCasoInstancia = new ArrayList<>(); //*
    private TipoCaso tipocaso;
    
    public Caso() {
    }

    public int getNumeroCaso() {
        return numeroCaso;
    }

    public void setNumeroCaso(int numeroCaso) {
        this.numeroCaso = numeroCaso;
    }

    public Date getFechaHoraFinCaso() {
        return fechaHoraFinCaso;
    }

    public void setFechaHoraFinCaso(Date fechaHoraFinCaso) {
        this.fechaHoraFinCaso = fechaHoraFinCaso;
    }

    public Date getFechaHoraIngresoCaso() {
        return fechaHoraIngresoCaso;
    }

    public void setFechaHoraIngresoCaso(Date fechaHoraIngresoCaso) {
        this.fechaHoraIngresoCaso = fechaHoraIngresoCaso;
    }

    public Date getFechaHoraCaducidadCaso() {
        return fechaHoraCaducidadCaso;
    }

    public void setFechaHoraCaducidadCaso(Date fechaHoraCaducidadCaso) {
        this.fechaHoraCaducidadCaso = fechaHoraCaducidadCaso;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getNumeroIteracion() {
        return numeroIteracion;
    }

    public void setNumeroIteracion(int numeroIteracion) {
        this.numeroIteracion = numeroIteracion;
    }

    public String getObservacionCaso() {
        return observacionCaso;
    }

    public void setObservacionCaso(String observacionCaso) {
        this.observacionCaso = observacionCaso;
    }   

    public EstadoCaso getEstadocaso() {
        return estadocaso;
    }

    public void setEstadocaso(EstadoCaso estadocaso) {
        this.estadocaso = estadocaso;
    }

    public List<CasoInstancia> getListaCasoInstancia() {
        return listaCasoInstancia;
    }

    public void setListaCasoInstancia(List<CasoInstancia> listaCasoInstancia) {
        this.listaCasoInstancia = listaCasoInstancia;
    }
    
    public void addListaCasoInstancia(CasoInstancia casoinstancia){
        listaCasoInstancia.add(casoinstancia);
    }
    
    public TipoCaso getTipocaso() {
        return tipocaso;
    }

    public void setTipocaso(TipoCaso tipocaso) {
        this.tipocaso = tipocaso;
    }

    public Caso getCasoiteracion() {
        return casoiteracion;
    }

    public void setCasoiteracion(Caso casoiteracion) {
        this.casoiteracion = casoiteracion;
    }
    
}
