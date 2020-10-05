package Entidades;

/**
 *
 * @author milig
 */

public class TipoCasoTipoInstancia extends Entidad {
    
    private int minutosMaximaResolucion;
    private int ordenTipoCasoTipoInstancia;
    
    private TipoInstancia tipoinstancia;

    public TipoCasoTipoInstancia() {
    }

    public int getMinutosMaximaResolucion() {
        return minutosMaximaResolucion;
    }

    public void setMinutosMaximaResolucion(int minutosMaximaResolucion) {
        this.minutosMaximaResolucion = minutosMaximaResolucion;
    }

    public int getOrdenTipoCasoTipoInstancia() {
        return ordenTipoCasoTipoInstancia;
    }

    public void setOrdenTipoCasoTipoInstancia(int ordenTipoCasoTipoInstancia) {
        this.ordenTipoCasoTipoInstancia = ordenTipoCasoTipoInstancia;
    }

    public TipoInstancia getTipoinstancia() {
        return tipoinstancia;
    }

    public void setTipoinstancia(TipoInstancia tipoinstancia) {
        this.tipoinstancia = tipoinstancia;
    }

}
