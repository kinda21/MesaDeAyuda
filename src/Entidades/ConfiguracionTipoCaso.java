package Entidades;
import java.util.*;

/**
 *
 * @author milig
 */

public class ConfiguracionTipoCaso extends Entidad {
    
    private int nroConfigTC;
    private Date fechaInicioVigencia;
    private Date fechaFinVigencia;
    private Date fechaVerificacion;
    
    private TipoCaso tipocaso; 
    private List<TipoCasoTipoInstancia> listaTipoCasoTipoInstancia = new ArrayList<>();

    public ConfiguracionTipoCaso() {
    }

    public int getNroConfigTC() {
        return nroConfigTC;
    }

    public void setNroConfigTC(int nroConfigTC) {
        this.nroConfigTC = nroConfigTC;
    }

    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public Date getFechaVerificacion() {
        return fechaVerificacion;
    }

    public void setFechaVerificacion(Date fechaVerificacion) {
        this.fechaVerificacion = fechaVerificacion;
    }

    public TipoCaso getTipocaso() {
        return tipocaso;
    }

    public void setTipocaso(TipoCaso tipocaso) {
        this.tipocaso = tipocaso;
    }

    public List<TipoCasoTipoInstancia> getListaTipoCasoTipoInstancia() {
        return listaTipoCasoTipoInstancia;
    }

    public void setListaTipoCasoTipoInstancia(List<TipoCasoTipoInstancia> listaTipoCasoTipoInstancia) {
        this.listaTipoCasoTipoInstancia = listaTipoCasoTipoInstancia;
    }
    
    public void addListaTipoCasoTipoInstancia (TipoCasoTipoInstancia tipocasotipoinstancia){
        listaTipoCasoTipoInstancia.add(tipocasotipoinstancia);
    }
}
