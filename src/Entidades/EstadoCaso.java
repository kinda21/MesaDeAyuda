package Entidades;
import java.util.*;

/**
 *
 * @author milig
 */

public class EstadoCaso extends Entidad {
   
    private int codEstadoCaso;
    private String nombreEstadoCaso;
    private Date fechaHoraFinVigenciaEC;

    public EstadoCaso() {
    }

    public int getCodEstadoCaso() {
        return codEstadoCaso;
    }

    public void setCodEstadoCaso(int codEstadoCaso) {
        this.codEstadoCaso = codEstadoCaso;
    }

    public String getNombreEstadoCaso() {
        return nombreEstadoCaso;
    }

    public void setNombreEstadoCaso(String nombreEstadoCaso) {
        this.nombreEstadoCaso = nombreEstadoCaso;
    }

    public Date getFechaHoraFinVigenciaEC() {
        return fechaHoraFinVigenciaEC;
    }

    public void setFechaHoraFinVigenciaEC(Date fechaHoraFinVigenciaEC) {
        this.fechaHoraFinVigenciaEC = fechaHoraFinVigenciaEC;
    }
    
    
}
