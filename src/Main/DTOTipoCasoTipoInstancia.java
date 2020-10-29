package Main;

/**
 *
 * @author FLIA HUDSON
 */
public class DTOTipoCasoTipoInstancia{
    
    private int minutosMaximaResolucion;
    private int ordenTipoCasoTipoInstancia;
    private int codigotipoinstancia;
    private String nombreTipoInstancia;
    
    public DTOTipoCasoTipoInstancia() {
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
    
    public int getCodigoTipoInstancia() {
        return codigotipoinstancia;
    }

    public void setCodigoTipoInstancia(int codigotipoinstancia) {
        this.codigotipoinstancia = codigotipoinstancia;
    }
    
    public String getNombreTipoInstancia() {
        return nombreTipoInstancia;
    }

    public void setNombreTipoInstancia(String nombreTipoInstancia) {
        this.nombreTipoInstancia = nombreTipoInstancia;
    }

}