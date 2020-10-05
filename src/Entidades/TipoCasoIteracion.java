package Entidades;

/**
 *
 * @author milig
 */

public class TipoCasoIteracion extends Entidad {
    
    private int numeroDeIteracion;
    private int coeficienteReduccionTipo;

    public TipoCasoIteracion() {
    }

    public int getNumeroDeIteracion() {
        return numeroDeIteracion;
    }

    public void setNumeroDeIteracion(int numeroDeIteracion) {
        this.numeroDeIteracion = numeroDeIteracion;
    }

    public int getCoeficienteReduccionTipo() {
        return coeficienteReduccionTipo;
    }

    public void setCoeficienteReduccionTipo(int coeficienteReduccionTipo) {
        this.coeficienteReduccionTipo = coeficienteReduccionTipo;
    }
    
}
