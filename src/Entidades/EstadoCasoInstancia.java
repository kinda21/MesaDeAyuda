package Entidades;
import java.util.*;

/**
 *
 * @author milig
 */

public class EstadoCasoInstancia extends Entidad {
    
    private int codEstadoCasoInstancia;
    private String nombreEstadoCasoInstancia;
    private Date fechaHoraFinVigenciaECI;

    public EstadoCasoInstancia() {
    }

    public int getCodEstadoCasoInstancia() {
        return codEstadoCasoInstancia;
    }

    public void setCodEstadoCasoInstancia(int codEstadoCasoInstancia) {
        this.codEstadoCasoInstancia = codEstadoCasoInstancia;
    }

    public String getNombreEstadoCasoInstancia() {
        return nombreEstadoCasoInstancia;
    }

    public void setNombreEstadoCasoInstancia(String nombreEstadoCasoInstancia) {
        this.nombreEstadoCasoInstancia = nombreEstadoCasoInstancia;
    }

    public Date getFechaHoraFinVigenciaECI() {
        return fechaHoraFinVigenciaECI;
    }

    public void setFechaHoraFinVigenciaECI(Date fechaHoraFinVigenciaECI) {
        this.fechaHoraFinVigenciaECI = fechaHoraFinVigenciaECI;
    }
    
    
}
