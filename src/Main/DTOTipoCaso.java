package Main;

import java.util.*;

/**
 *
 * @author milig
 */

public class DTOTipoCaso {
    
    private int codTipoCaso;
    private String nombreTipoCaso;
    private Date fechaFinVigenciaTipoCaso;
    private int numeroMaximaIteracion;
    
    private List<DTOTipoCasoIteracion> listaTipoCasoIteracion = new ArrayList<>();
    
    public DTOTipoCaso() {
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

    public List<DTOTipoCasoIteracion> getListaTipoCasoIteracion() {
        return listaTipoCasoIteracion;
    }

    public void setListaTipoCasoIteracion(List<DTOTipoCasoIteracion> listaTipoCasoIteracion) {
        this.listaTipoCasoIteracion = listaTipoCasoIteracion;
    }
    
    public void addListaTipoCasoIteracion(DTOTipoCasoIteracion tipocasoiteracion){
        listaTipoCasoIteracion.add(tipocasoiteracion);
    }
   
}
