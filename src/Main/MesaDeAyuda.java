package Main;

import java.util.List;

/**
 *
 * @author milig
 */
public class MesaDeAyuda {

    public static void main(String[] args) {
       MainMenu menu = new MainMenu();
       menu.setVisible(true);
       // Controlador().Metodo();
       ControladorABMTipoInstancia control = new ControladorABMTipoInstancia();
       List<DTOTipoInstancia> lista = control.buscarTipoInstancias();
       System.out.println("break");
    }
    
}
