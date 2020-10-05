package Entidades;
import java.util.*;

/**
 *
 * @author milig
 */

public class Especialista extends Entidad {
    
    private int nroLegajoEspecialista;
    private int cuitEspecialista;
    private String nombreApellidoEspecialista;
    private Date fechaHoraFinVigenciaEspecialista;
    
    private Sector sector;

    public Especialista() {
    }

    public int getNroLegajoEspecialista() {
        return nroLegajoEspecialista;
    }

    public void setNroLegajoEspecialista(int nroLegajoEspecialista) {
        this.nroLegajoEspecialista = nroLegajoEspecialista;
    }

    public int getCuitEspecialista() {
        return cuitEspecialista;
    }

    public void setCuitEspecialista(int cuitEspecialista) {
        this.cuitEspecialista = cuitEspecialista;
    }

    public String getNombreApellidoEspecialista() {
        return nombreApellidoEspecialista;
    }

    public void setNombreApellidoEspecialista(String nombreApellidoEspecialista) {
        this.nombreApellidoEspecialista = nombreApellidoEspecialista;
    }

    public Date getFechaHoraFinVigenciaEspecialista() {
        return fechaHoraFinVigenciaEspecialista;
    }

    public void setFechaHoraFinVigenciaEspecialista(Date fechaHoraFinVigenciaEspecialista) {
        this.fechaHoraFinVigenciaEspecialista = fechaHoraFinVigenciaEspecialista;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
  
}
