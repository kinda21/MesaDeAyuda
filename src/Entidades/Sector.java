package Entidades;
import java.util.*;

/**
 *
 * @author milig
 */

public class Sector extends Entidad {
    
    private int codSector;
    private String nombreSector;
    private String descripcionSector;
    private Date fechaHoraFinVigenciaSector;

    public Sector () {
    }
    public Sector (int cod, String nom, String desc) {
        codSector=cod;
        nombreSector=nom;
        descripcionSector=desc;
        fechaHoraFinVigenciaSector=null;
        
    }
    public int getCodSector() {
        return codSector;
    }

    public void setCodSector(int codSector) {
        this.codSector = codSector;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
    }

    public String getDescripcionSector() {
        return descripcionSector;
    }

    public void setDescripcionSector(String descripcionSector) {
        this.descripcionSector = descripcionSector;
    }

    public Date getFechaHoraFinVigenciaSector() {
        return fechaHoraFinVigenciaSector;
    }

    public void setFechaHoraFinVigenciaSector(Date fechaHoraFinVigenciaSector) {
        this.fechaHoraFinVigenciaSector = fechaHoraFinVigenciaSector;
    }

}
