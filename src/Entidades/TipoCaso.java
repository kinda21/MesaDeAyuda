package Entidades;
import java.util.*;

/**
 *
 * @author milig
 */

public class TipoCaso extends Entidad{
    
    private int codTipoCaso;
    private String nombreTipoCaso;
    private Date fechaFinVigenciaTipoCaso;
    private int numeroMaximaIteracion;
    
    private List<TipoCasoIteracion> listaTipoCasoIteracion = new ArrayList<>();
    
    public TipoCaso() {
    }

    public int getCodTipoCaso() {
        return codTipoCaso;
    }

    public void setCodTipoCaso(int codTipoCaso) {
        this.codTipoCaso = codTipoCaso;
    }

    public String getNombreTipoCaso() {
        return nombreTipoCaso;
    }

    public void setNombreTipoCaso(String nombreTipoCaso) {
        this.nombreTipoCaso = nombreTipoCaso;
    }

    public Date getFechaFinVigenciaTipoCaso() {
        return fechaFinVigenciaTipoCaso;
    }

    public void setFechaFinVigenciaTipoCaso(Date fechaFinVigenciaTipoCaso) {
        this.fechaFinVigenciaTipoCaso = fechaFinVigenciaTipoCaso;
    }

    public int getNumeroMaximaIteracion() {
        return numeroMaximaIteracion;
    }

    public void setNumeroMaximaIteracion(int numeroMaximaIteracion) {
        this.numeroMaximaIteracion = numeroMaximaIteracion;
    }

    public List<TipoCasoIteracion> getListaTipoCasoIteracion() {
        return listaTipoCasoIteracion;
    }

    public void setListaTipoCasoIteracion(List<TipoCasoIteracion> listaTipoCasoIteracion) {
        this.listaTipoCasoIteracion = listaTipoCasoIteracion;
    }
    
    public void addListaTipoCasoIteracion(TipoCasoIteracion tipocasoiteracion){
        listaTipoCasoIteracion.add(tipocasoiteracion);
    }
   
}
