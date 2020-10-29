package Main.ABMTipoCaso;

import Entidades.*;
import Main.DTOTipoCasoIteracion;
import Main.DTOTipoCaso;
import Main.DTOCriterio;
import Main.FachadaPersistencia;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FLIA HUDSON
 */
public class ExpertoABMTipoCaso {
    public ExpertoABMTipoCaso() {
    }

    public List<DTOTipoCaso> buscarTipoCasos(String nomfilTipoCaso, String codfilTipoCaso){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOTipoCaso> listaTipoCasos = new ArrayList<>();
        //si los 2 argumentos vienen vacios traigo todos los TC
        if (nomfilTipoCaso.equals("") && codfilTipoCaso.equals("")) {
            List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", null);
            for (Object x : objetoList) {
                TipoCaso tipoCasoleido = (TipoCaso) x;
                DTOTipoCaso tipocaso = new DTOTipoCaso();
                tipocaso.setCodTipoCaso(tipoCasoleido.getCodTipoCaso());
                tipocaso.setFechaFinVigenciaTipoCaso(tipoCasoleido.getFechaFinVigenciaTipoCaso());
                tipocaso.setNombreTipoCaso(tipoCasoleido.getNombreTipoCaso());
                tipocaso.setNumeroMaximaIteracion(tipoCasoleido.getNumeroMaximaIteracion());
                List<DTOTipoCasoIteracion> listaIteraciones = new ArrayList<>();
                for (TipoCasoIteracion x2 : tipoCasoleido.getListaTipoCasoIteracion()) {
                    TipoCasoIteracion iteracionleida = x2;
                    DTOTipoCasoIteracion iteracion = new DTOTipoCasoIteracion();
                    iteracion.setCoeficienteReduccionTipo(iteracionleida.getCoeficienteReduccionTipo());
                    iteracion.setNumeroDeIteracion(iteracionleida.getNumeroDeIteracion());
                    listaIteraciones.add(iteracion);
                    tipocaso.addListaTipoCasoIteracion(iteracion);
                }
            listaTipoCasos.add(tipocaso);
            }
        }
        //si solo viene el nombre traigo todos los TC con ese nombre
        if (!nomfilTipoCaso.equals("") && codfilTipoCaso.equals("")) {
            List<DTOCriterio> criterioList = new ArrayList<>();
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("nombreTipoCaso");
            dto.setOperacion("like");
            dto.setValor(nomfilTipoCaso);
            criterioList.add(dto);
            List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", criterioList);
            for (Object x : objetoList) {
                TipoCaso tipoCasoleido = (TipoCaso) x;
                DTOTipoCaso tipocaso = new DTOTipoCaso();
                tipocaso.setCodTipoCaso(tipoCasoleido.getCodTipoCaso());
                tipocaso.setFechaFinVigenciaTipoCaso(tipoCasoleido.getFechaFinVigenciaTipoCaso());
                tipocaso.setNombreTipoCaso(tipoCasoleido.getNombreTipoCaso());
                tipocaso.setNumeroMaximaIteracion(tipoCasoleido.getNumeroMaximaIteracion());
                List<DTOTipoCasoIteracion> listaIteraciones = new ArrayList<>();
                for (TipoCasoIteracion x2 : tipoCasoleido.getListaTipoCasoIteracion()) {
                    TipoCasoIteracion iteracionleida = x2;
                    DTOTipoCasoIteracion iteracion = new DTOTipoCasoIteracion();
                    iteracion.setCoeficienteReduccionTipo(iteracionleida.getCoeficienteReduccionTipo());
                    iteracion.setNumeroDeIteracion(iteracionleida.getNumeroDeIteracion());
                    listaIteraciones.add(iteracion);
                    tipocaso.addListaTipoCasoIteracion(iteracion);
                }
            listaTipoCasos.add(tipocaso);
            }
        }
        //si solo viene el código del TC traigo a todos los TC con ese código
        if (nomfilTipoCaso.equals("") && !codfilTipoCaso.equals("")) {
            int codigotc;
            try  {
            codigotc=(Integer.parseInt(codfilTipoCaso));
            }
            catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese un número entero para buscar por código.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return listaTipoCasos=null;
            }
            List<DTOCriterio> criterioList = new ArrayList<>();
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("codTipoCaso");
            dto.setOperacion("=");
            dto.setValor(codigotc);
            criterioList.add(dto);
            List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", criterioList);
            for (Object x : objetoList) {
                TipoCaso tipoCasoleido = (TipoCaso) x;
                DTOTipoCaso tipocaso = new DTOTipoCaso();
                tipocaso.setCodTipoCaso(tipoCasoleido.getCodTipoCaso());
                tipocaso.setFechaFinVigenciaTipoCaso(tipoCasoleido.getFechaFinVigenciaTipoCaso());
                tipocaso.setNombreTipoCaso(tipoCasoleido.getNombreTipoCaso());
                tipocaso.setNumeroMaximaIteracion(tipoCasoleido.getNumeroMaximaIteracion());
                List<DTOTipoCasoIteracion> listaIteraciones = new ArrayList<>();
                for (TipoCasoIteracion x2 : tipoCasoleido.getListaTipoCasoIteracion()) {
                    TipoCasoIteracion iteracionleida = x2;
                    DTOTipoCasoIteracion iteracion = new DTOTipoCasoIteracion();
                    iteracion.setCoeficienteReduccionTipo(iteracionleida.getCoeficienteReduccionTipo());
                    iteracion.setNumeroDeIteracion(iteracionleida.getNumeroDeIteracion());
                    listaIteraciones.add(iteracion);
                    tipocaso.addListaTipoCasoIteracion(iteracion);
                }
            listaTipoCasos.add(tipocaso);
            }
            }
        //si vienen los dos argumentos inicializados busco todos los tipo instancia que cumpla con ambos
        if (!nomfilTipoCaso.equals("") && !codfilTipoCaso.equals("")) {
            int codigotc;
            try  {
            codigotc=(Integer.parseInt(codfilTipoCaso));
            }
            catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese un número entero para buscar por código.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return listaTipoCasos=null;
            }
            List<DTOCriterio> criterioList = new ArrayList<>();
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("codTipoCaso");
            dto.setOperacion("=");
            dto.setValor(codigotc);
            DTOCriterio dto2 = new DTOCriterio();
            dto2.setAtributo("nombreTipoCaso");
            dto2.setOperacion("like");
            dto2.setValor(nomfilTipoCaso);
            criterioList.add(dto);
            criterioList.add(dto2);
            List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", criterioList);
            for (Object x : objetoList) {
                TipoCaso tipoCasoleido = (TipoCaso) x;
                DTOTipoCaso tipocaso = new DTOTipoCaso();
                tipocaso.setCodTipoCaso(tipoCasoleido.getCodTipoCaso());
                tipocaso.setFechaFinVigenciaTipoCaso(tipoCasoleido.getFechaFinVigenciaTipoCaso());
                tipocaso.setNombreTipoCaso(tipoCasoleido.getNombreTipoCaso());
                tipocaso.setNumeroMaximaIteracion(tipoCasoleido.getNumeroMaximaIteracion());
                List<DTOTipoCasoIteracion> listaIteraciones = new ArrayList<>();
                for (TipoCasoIteracion x2 : tipoCasoleido.getListaTipoCasoIteracion()) {
                    TipoCasoIteracion iteracionleida = x2;
                    DTOTipoCasoIteracion iteracion = new DTOTipoCasoIteracion();
                    iteracion.setCoeficienteReduccionTipo(iteracionleida.getCoeficienteReduccionTipo());
                    iteracion.setNumeroDeIteracion(iteracionleida.getNumeroDeIteracion());
                    listaIteraciones.add(iteracion);
                    tipocaso.addListaTipoCasoIteracion(iteracion);
                }
            listaTipoCasos.add(tipocaso);
            }
            }
    FachadaPersistencia.getInstance().finalizarTransaccion();   
    return listaTipoCasos;   
    } 
    public List<DTOTipoCaso> buscarTipoCasosVigentes(){  
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOTipoCaso> listaTipoCasos = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("fechaFinVigenciaTipoCaso");
        dto.setOperacion("=");
        dto.setValor(null);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", criterioList);
            for (Object x : objetoList) {
                TipoCaso tipoCasoleido = (TipoCaso) x;
                DTOTipoCaso tipocaso = new DTOTipoCaso();
                tipocaso.setCodTipoCaso(tipoCasoleido.getCodTipoCaso());
                tipocaso.setFechaFinVigenciaTipoCaso(tipoCasoleido.getFechaFinVigenciaTipoCaso());
                tipocaso.setNombreTipoCaso(tipoCasoleido.getNombreTipoCaso());
                tipocaso.setNumeroMaximaIteracion(tipoCasoleido.getNumeroMaximaIteracion());
                List<DTOTipoCasoIteracion> listaIteraciones = new ArrayList<>();
                for (TipoCasoIteracion x2 : tipoCasoleido.getListaTipoCasoIteracion()) {
                    TipoCasoIteracion iteracionleida = x2;
                    DTOTipoCasoIteracion iteracion = new DTOTipoCasoIteracion();
                    iteracion.setCoeficienteReduccionTipo(iteracionleida.getCoeficienteReduccionTipo());
                    iteracion.setNumeroDeIteracion(iteracionleida.getNumeroDeIteracion());
                    listaIteraciones.add(iteracion);
                    tipocaso.addListaTipoCasoIteracion(iteracion);
                }
            listaTipoCasos.add(tipocaso);
        }
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaTipoCasos;
    }        

    public boolean daraltaTipoCaso(int codtipocaso, String nomTC, int maxiteraciones,List<DTOTipoCasoIteracion> iteraciones) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        TipoCaso nuevoTC = new TipoCaso();
        try {
        nuevoTC.setCodTipoCaso(codtipocaso);
        nuevoTC.setFechaFinVigenciaTipoCaso(null);
        nuevoTC.setNombreTipoCaso(nomTC);
        nuevoTC.setNumeroMaximaIteracion(maxiteraciones);
        List<TipoCasoIteracion> iteracionesdealta = new ArrayList();
        for (Object x : iteraciones){
            DTOTipoCasoIteracion undto = (DTOTipoCasoIteracion) x;
            int numero,coef;
            numero = undto.getNumeroDeIteracion();
            coef = undto.getCoeficienteReduccionTipo();
            TipoCasoIteracion iteraciondealta = new TipoCasoIteracion();
            iteraciondealta.setNumeroDeIteracion(numero);
            iteraciondealta.setCoeficienteReduccionTipo(coef);
            iteracionesdealta.add(iteraciondealta);
        }
        nuevoTC.setListaTipoCasoIteracion(iteracionesdealta);
        if (nuevoTC.getNumeroMaximaIteracion()<0) {
            JOptionPane.showMessageDialog(null, "El número máximo de iteraciones es incorrecto, no puede ser menor a 0");
            return false;
        }
        if (nuevoTC.getNombreTipoCaso().equals("")) {
            JOptionPane.showMessageDialog(null, "El nombre ingresado es incorrecto, valor nulo no aceptado");
            return false;
        }
        if (nuevoTC.getCodTipoCaso()<= 0){
            JOptionPane.showMessageDialog(null, "El codigo ingresado es incorrecto, valor nulo o negativo no aceptado.");
            return false;
        }
        List objetoList3 = FachadaPersistencia.getInstance().buscar("TipoCaso", null);
        for (Object x2 : objetoList3) {
            TipoCaso TCaverificar = (TipoCaso) x2;
            if(nuevoTC.getCodTipoCaso()== TCaverificar.getCodTipoCaso()){
                JOptionPane.showMessageDialog(null, "El codigo ingresado no es valido, ya existe un Tipo Caso con ese código.");
                return false;
            }
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear el Tipo Caso");
            return false; 
        }
        FachadaPersistencia.getInstance().guardar(nuevoTC);
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return true;
        }
    public boolean modificarTipoCaso(int codtipocaso,String nomTC,int maxiteraciones,List<DTOTipoCasoIteracion> iteraciones) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        if (nomTC.equals("")) {
            JOptionPane.showMessageDialog(null, "El nombre ingresado es incorrecto, valor nulo no aceptado");
            return false;
        }
        if (codtipocaso<0) {
            JOptionPane.showMessageDialog(null, "El código ingresado es incorrecto, valor menor a cero no aceptado");
            return false;
        }
        if (maxiteraciones<0) {
            JOptionPane.showMessageDialog(null, "El número de iteraciones ingresado es incorrecto, valor menor a cero no aceptado");
            return false;
        }
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoCaso");
        dto.setOperacion("=");
        dto.setValor(codtipocaso);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", criterioList);
        TipoCaso TCamodificar = (TipoCaso)objetoList.get(0);
        if (TCamodificar.getFechaFinVigenciaTipoCaso()!= null) {
            JOptionPane.showMessageDialog(null, "El Tipo Caso a modificar se encuentra dado de baja");
            return false;
        }
        TCamodificar.setNombreTipoCaso(nomTC);
        TCamodificar.setNumeroMaximaIteracion(maxiteraciones);
        TCamodificar.getListaTipoCasoIteracion().clear();
        List<TipoCasoIteracion> iteracionesmodificadas = new ArrayList();
        for (Object x : iteraciones){
            DTOTipoCasoIteracion undto = (DTOTipoCasoIteracion) x;
            int numero,coef;
            numero = undto.getNumeroDeIteracion();
            coef = undto.getCoeficienteReduccionTipo();
            TipoCasoIteracion iteracionmodificada = new TipoCasoIteracion();
            iteracionmodificada.setNumeroDeIteracion(numero);
            iteracionmodificada.setCoeficienteReduccionTipo(coef);
            iteracionesmodificadas.add(iteracionmodificada);
        }
        TCamodificar.getListaTipoCasoIteracion().addAll(iteracionesmodificadas);
        FachadaPersistencia.getInstance().guardar(TCamodificar);
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return true;
    }
    public boolean darbajaTipoCaso(int codTipoCaso) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoCaso");
        dto.setOperacion("=");
        dto.setValor(codTipoCaso);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", criterioList);
        TipoCaso tipoCasodebaja = (TipoCaso)objetoList.get(0);
        if (tipoCasodebaja.getFechaFinVigenciaTipoCaso()!= null){
            JOptionPane.showMessageDialog(null,"Este Tipo Caso ya esta dado de baja" );
            return false;
        }
        Date fechadehoy = new Date();
        tipoCasodebaja.setFechaFinVigenciaTipoCaso(fechadehoy);
        FachadaPersistencia.getInstance().guardar(tipoCasodebaja);
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return true;
        }
    
    }