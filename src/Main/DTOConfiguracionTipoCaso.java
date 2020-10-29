package Main;

import Entidades.TipoCaso;
import Entidades.TipoCasoTipoInstancia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FLIA HUDSON
 */
public class DTOConfiguracionTipoCaso {
    private int nroConfigTC;
    private Date fechaInicioVigencia;
    private Date fechaFinVigencia;
    private Date fechaVerificacion;
    private String nombreTC;

    private List<DTOTipoCasoTipoInstancia> listadtosTCTI = new ArrayList();

    public DTOConfiguracionTipoCaso() {
    }

    public int getNroConfigTC() {
        return nroConfigTC;
    }
    public String getNombreTC() {
        return nombreTC;
    }
    public void setNombreTC(String nombreTC) {
        this.nombreTC = nombreTC;
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
    public List<DTOTipoCasoTipoInstancia> getListaDTOTipoCasoTipoInstancia() {
        return listadtosTCTI;
    }

    public void setListaTipoCasoTipoInstancia(List<DTOTipoCasoTipoInstancia> listadtosTCTI) {
        this.listadtosTCTI = listadtosTCTI;
    }
    
    public void addListaTipoCasoTipoInstancia(DTOTipoCasoTipoInstancia dtoTCTI){
        listadtosTCTI.add(dtoTCTI);
    }
}
