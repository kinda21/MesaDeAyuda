package Main.ConfigurarCaso;

import Entidades.*;
import Main.DTOConfiguracionTipoCaso;
import Main.DTOTipoCasoIteracion;
import Main.DTOTipoCaso;
import Main.DTOCriterio;
import Main.DTOTipoCasoTipoInstancia;
import Main.DTOTipoInstancia;
import Main.DTOTipoTarea;
import Main.FachadaPersistencia;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FLIA HUDSON
 */
public class ExpertoConfigurar {
    public ExpertoConfigurar() {
    }
    
    public List<DTOTipoInstancia> buscarTipoInstanciaVigente(int codfilTipoInstancia){  
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoInstancia");
        dto.setOperacion("=");
        dto.setValor(codfilTipoInstancia);
        criterioList.add(dto);
        DTOCriterio dto2 = new DTOCriterio();
        dto2.setAtributo("fechaHoraFinVigenciaTipoInstancia");
        dto2.setOperacion("=");
        dto2.setValor(null);
        criterioList.add(dto2);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList);
        List<DTOTipoInstancia> listaTipoInstancia = new ArrayList<>();
        for (Object x : objetoList) {
            TipoInstancia tipoInstancialeida = (TipoInstancia) x;
            DTOTipoInstancia tipoinstancia = new DTOTipoInstancia();
            tipoinstancia.setCodTipoInstancia(tipoInstancialeida.getCodTipoInstancia());
            tipoinstancia.setFechaHoraFinVigenciaTipoInstancia(tipoInstancialeida.getFechaHoraFinVigenciaTipoInstancia());
            tipoinstancia.setNombreTipoInstancia(tipoInstancialeida.getNombreTipoInstancia());
            Sector sectorleido = (Sector) tipoInstancialeida.getSector();
            tipoinstancia.setCodSector(sectorleido.getCodSector());
            tipoinstancia.setNombreSector(sectorleido.getNombreSector());
            List<DTOTipoTarea> listaTipoTarea = new ArrayList<>();
            for (TipoTarea x2 : tipoInstancialeida.getListaTipoTarea() ) {
                TipoTarea tipotarealeida = x2;
                DTOTipoTarea tipotarea = new DTOTipoTarea();
                tipotarea.setCodTipoTarea(tipotarealeida.getCodTipoTarea());
                tipotarea.setDescripcionTipoTarea(tipotarealeida.getDescripcionTipoTarea());
                tipotarea.setFechaFinVigenciaTipoTarea(tipotarealeida.getFechaFinVigenciaTipoTarea());
                tipotarea.setNombreTipoTarea(tipotarealeida.getNombreTipoTarea());
                listaTipoTarea.add(tipotarea);
                tipoinstancia.addListaTipoTarea(tipotarea);
            }
            listaTipoInstancia.add(tipoinstancia);
        }
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaTipoInstancia;
        }
    
    public List<DTOTipoCaso> buscarTipoCasosVigentes(String nomfilTipoCaso, String codfilTipoCaso){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOTipoCaso> listaTipoCasos = new ArrayList<>();
        //si los 2 argumentos vienen vacios traigo todos los TC
        if (nomfilTipoCaso.equals("") && codfilTipoCaso.equals("")) {
            List<DTOCriterio> criterioList = new ArrayList<>();
            DTOCriterio vigente = new DTOCriterio();
            vigente.setAtributo("fechaFinVigenciaTipoCaso");
            vigente.setOperacion("=");
            vigente.setValor(null);
            criterioList.add(vigente);
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
        //si solo viene el nombre traigo todos los TC con ese nombre
        if (!nomfilTipoCaso.equals("") && codfilTipoCaso.equals("")) {
            List<DTOCriterio> criterioList = new ArrayList<>();
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("nombreTipoCaso");
            dto.setOperacion("like");
            dto.setValor(nomfilTipoCaso);
            criterioList.add(dto);
            DTOCriterio vigente = new DTOCriterio();
            vigente.setAtributo("fechaFinVigenciaTipoCaso");
            vigente.setOperacion("=");
            vigente.setValor(null);
            criterioList.add(vigente);
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
            DTOCriterio vigente = new DTOCriterio();
            vigente.setAtributo("fechaFinVigenciaTipoCaso");
            vigente.setOperacion("=");
            vigente.setValor(null);
            criterioList.add(vigente);
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
            DTOCriterio vigente = new DTOCriterio();
            vigente.setAtributo("fechaFinVigenciaTipoCaso");
            vigente.setOperacion("=");
            vigente.setValor(null);
            criterioList.add(vigente);
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
    if (listaTipoCasos.size()==0) {
        JOptionPane.showMessageDialog(null, "El Tipo Caso buscado no existe o ha sido dado de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
        return listaTipoCasos=null;
    }
    FachadaPersistencia.getInstance().finalizarTransaccion();   
    return listaTipoCasos;   
    } 
    
   /* public List<DTOTipoCaso> buscarTipoCasosVigentes(){  
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
    }*/
    
    public List<DTOConfiguracionTipoCaso> buscarConfiguraciones(String codTC){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOConfiguracionTipoCaso> listaConfiguraciones = new ArrayList<>();
        int codigotc;
            try  {
            codigotc=(Integer.parseInt(codTC));
            }
            catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese un número entero para buscar por código.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return listaConfiguraciones=null;
            }
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoCaso");
        dto.setOperacion("=");
        dto.setValor(codigotc);
        criterioList.add(dto);
        //busco el tipocaso pasado por codigo
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", criterioList);
        TipoCaso tipocaso = (TipoCaso) objetoList.get(0);
        criterioList.clear();
        objetoList.clear();
        DTOCriterio dto2 = new DTOCriterio();
        dto2.setAtributo("tipocaso");
        dto2.setOperacion("=");
        dto2.setValor(tipocaso);
        criterioList.add(dto2);
        //busco las configuracionTipocaso que tengan este tipo caso
        objetoList = FachadaPersistencia.getInstance().buscar("ConfiguracionTipoCaso", criterioList);
        for (Object x : objetoList) {
            ConfiguracionTipoCaso configleida = (ConfiguracionTipoCaso) x;
            DTOConfiguracionTipoCaso config = new DTOConfiguracionTipoCaso();
            config.setFechaFinVigencia(configleida.getFechaFinVigencia());
            config.setFechaInicioVigencia(configleida.getFechaInicioVigencia());
            config.setFechaVerificacion(configleida.getFechaVerificacion());
            config.setNroConfigTC(configleida.getNroConfigTC());
            config.setNombreTC(configleida.getTipocaso().getNombreTipoCaso());
            List<DTOTipoCasoTipoInstancia> listatctis = new ArrayList<>();
                for (TipoCasoTipoInstancia x2 : configleida.getListaTipoCasoTipoInstancia()) {
                    TipoCasoTipoInstancia tctileida = x2;
                    DTOTipoCasoTipoInstancia dtotcti = new DTOTipoCasoTipoInstancia();
                    dtotcti.setCodigoTipoInstancia(tctileida.getTipoinstancia().getCodTipoInstancia());
                    dtotcti.setMinutosMaximaResolucion(tctileida.getMinutosMaximaResolucion());
                    dtotcti.setNombreTipoInstancia(tctileida.getTipoinstancia().getNombreTipoInstancia());
                    dtotcti.setOrdenTipoCasoTipoInstancia(tctileida.getOrdenTipoCasoTipoInstancia());
                    listatctis.add(dtotcti);
                    config.addListaTipoCasoTipoInstancia(dtotcti);
                }
            listaConfiguraciones.add(config);
            }
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaConfiguraciones;
    }
    
    public DTOConfiguracionTipoCaso buscarConfiguracion(String codTC, String nroConf){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOConfiguracionTipoCaso configuracionbuscada;
        int codigotc;
            try  {
            codigotc=(Integer.parseInt(codTC));
            }
            catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese un número entero para buscar el Tipo Caso por código.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
            }
        int nroconfiguracion;
            try  {
                nroconfiguracion=(Integer.parseInt(nroConf));
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ingrese un número entero para buscar la configuración por número.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoCaso");
        dto.setOperacion("=");
        dto.setValor(codigotc);
        criterioList.add(dto);
        //busco el tipocaso pasado por codigo
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", criterioList);
        TipoCaso tipocaso = (TipoCaso) objetoList.get(0);
        criterioList.clear();
        objetoList.clear();
        DTOCriterio dto2 = new DTOCriterio();
        dto2.setAtributo("tipocaso");
        dto2.setOperacion("=");
        dto2.setValor(tipocaso);
        criterioList.add(dto2);
        DTOCriterio dto3 = new DTOCriterio();
        dto3.setAtributo("nroConfigTC");
        dto3.setOperacion("=");
        dto3.setValor(nroconfiguracion);
        criterioList.add(dto3);
        DTOConfiguracionTipoCaso config = new DTOConfiguracionTipoCaso();
        //busco la configuracionTipocaso que tenga este tipo caso y este nroconfiguracion
        objetoList = FachadaPersistencia.getInstance().buscar("ConfiguracionTipoCaso", criterioList);
        for (Object x : objetoList) {
            ConfiguracionTipoCaso configleida = (ConfiguracionTipoCaso) x;
            config.setFechaFinVigencia(configleida.getFechaFinVigencia());
            config.setFechaInicioVigencia(configleida.getFechaInicioVigencia());
            config.setFechaVerificacion(configleida.getFechaVerificacion());
            config.setNroConfigTC(configleida.getNroConfigTC());
            config.setNombreTC(configleida.getTipocaso().getNombreTipoCaso());
            List<DTOTipoCasoTipoInstancia> listatctis = new ArrayList<>();
                for (TipoCasoTipoInstancia x2 : configleida.getListaTipoCasoTipoInstancia()) {
                    TipoCasoTipoInstancia tctileida = x2;
                    DTOTipoCasoTipoInstancia dtotcti = new DTOTipoCasoTipoInstancia();
                    dtotcti.setCodigoTipoInstancia(tctileida.getTipoinstancia().getCodTipoInstancia());
                    dtotcti.setMinutosMaximaResolucion(tctileida.getMinutosMaximaResolucion());
                    dtotcti.setNombreTipoInstancia(tctileida.getTipoinstancia().getNombreTipoInstancia());
                    dtotcti.setOrdenTipoCasoTipoInstancia(tctileida.getOrdenTipoCasoTipoInstancia());
                    listatctis.add(dtotcti);
                    config.addListaTipoCasoTipoInstancia(dtotcti);
                }
            }
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return config;
    }
    
    public boolean daraltaConfiguracion (String nroConfig, String codTC, Date fechainicio, List<DTOTipoCasoTipoInstancia> listatipocasotipoinstancia ) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        ConfiguracionTipoCaso nuevaConfig = new ConfiguracionTipoCaso();
        int codigotc,numeroConfig;     
            try  {
            codigotc=(Integer.parseInt(codTC));
            }
            catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese un número entero al código del Tipo Caso a asignar", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
            }
            try  {
            numeroConfig=(Integer.parseInt(nroConfig));
            }
            catch (Exception e){
            JOptionPane.showMessageDialog(null, "El número de configuración debe serun número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
            }
        if (codigotc<=0) {
            JOptionPane.showMessageDialog(null, "El código del Tipo Caso a asignar no puede ser menor o igual a 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false; 
        }   
        if (numeroConfig<=0) {
            JOptionPane.showMessageDialog(null, "El número de configuración no puede ser menor o igual a 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        Date fechadehoy = new Date();
        if (fechainicio.before(fechadehoy)) {
            JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser menor a la fecha actual", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        if (listatipocasotipoinstancia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La configuración debe tener por lo menos un TipoCasoTipoInstancia.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoCaso");
        dto.setOperacion("=");
        dto.setValor(codigotc);
        criterioList.add(dto);
        //busco el tipocaso pasado por codigo
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", criterioList);
        if (objetoList == null) {
            JOptionPane.showMessageDialog(null, "Tipo Caso no encontrado. Ingrese código de tipo caso nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        TipoCaso tipocaso = (TipoCaso) objetoList.get(0);
        if (tipocaso.getFechaFinVigenciaTipoCaso()!=null) {
            JOptionPane.showMessageDialog(null, "El Tipo Caso ingresado ha sido dado de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //busco todas las configuraciones de ese tipo caso para ver que no haya otra con el mismo numero de configuracion
        objetoList.clear();
        criterioList.clear();
        DTOCriterio dto2 = new DTOCriterio();
        dto2.setAtributo("tipocaso");
        dto2.setOperacion("=");
        dto2.setValor(tipocaso);
        criterioList.add(dto2);
        objetoList = FachadaPersistencia.getInstance().buscar("ConfiguracionTipoCaso", criterioList);
        for (Object x : objetoList){
            ConfiguracionTipoCaso unconfigTC = (ConfiguracionTipoCaso) x;
            if (unconfigTC.getNroConfigTC()==numeroConfig) {
                JOptionPane.showMessageDialog(null, "Ya existe una configuración con el número de configuración ingresado", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        nuevaConfig.setNroConfigTC(numeroConfig);
        nuevaConfig.setFechaInicioVigencia(fechainicio);
        nuevaConfig.setTipocaso(tipocaso);
        for (Object x2 : listatipocasotipoinstancia){
            DTOTipoCasoTipoInstancia undto = (DTOTipoCasoTipoInstancia) x2;
                int minutosmax,orden,codigoTI;
                codigoTI = undto.getCodigoTipoInstancia();
                minutosmax = undto.getMinutosMaximaResolucion();
                orden = undto.getOrdenTipoCasoTipoInstancia();
                if (orden<=0) {
                JOptionPane.showMessageDialog(null, "El orden de un TipoCasoTipoInstancia no puede ser menor o igual a 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
                }
                TipoCasoTipoInstancia tipocasotipoinstanciadealta = new TipoCasoTipoInstancia();
                tipocasotipoinstanciadealta.setOrdenTipoCasoTipoInstancia(orden);
                tipocasotipoinstanciadealta.setMinutosMaximaResolucion(minutosmax);
                DTOCriterio dto3 = new DTOCriterio();
                dto3.setAtributo("codTipoInstancia");
                dto3.setOperacion("=");
                dto3.setValor(codigoTI);
                criterioList.clear();
                criterioList.add(dto3);
                objetoList.clear();
                objetoList = FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList);
                TipoInstancia tiaasignar = (TipoInstancia) objetoList.get(0);
                if (tiaasignar.getFechaHoraFinVigenciaTipoInstancia()!=null) {
                    JOptionPane.showMessageDialog(null, "El Tipo Instancia ingresado ha sido dado de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                tipocasotipoinstanciadealta.setTipoinstancia(tiaasignar);
                nuevaConfig.addListaTipoCasoTipoInstancia(tipocasotipoinstanciadealta);
            }
        FachadaPersistencia.getInstance().guardar(nuevaConfig);
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return true;
    }
    
    public boolean modificarConfiguracion (String nroConfig, String codTC, Date fechainicio, List<DTOTipoCasoTipoInstancia> listatipocasotipoinstancia ) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        ConfiguracionTipoCaso configamodificar = new ConfiguracionTipoCaso();
        int codigotc,numeroConfig;     
            try  {
            codigotc=(Integer.parseInt(codTC));
            }
            catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese un número entero al código del Tipo Caso a asignar", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
            }
            try  {
            numeroConfig=(Integer.parseInt(nroConfig));
            }
            catch (Exception e){
            JOptionPane.showMessageDialog(null, "El número de configuración debe ser un número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
            }
        if (codigotc<=0) {
            JOptionPane.showMessageDialog(null, "El código del Tipo Caso a asignar no puede ser menor o igual a 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false; 
        }   
        if (numeroConfig<=0) {
            JOptionPane.showMessageDialog(null, "El número de configuración no puede ser menor o igual a 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        Date fechadehoy = new Date();
        if (fechainicio.before(fechadehoy)) {
            JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser menor a la fecha actual", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        if (listatipocasotipoinstancia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La configuración debe tener por lo menos un TipoCasoTipoInstancia.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoCaso");
        dto.setOperacion("=");
        dto.setValor(codigotc);
        criterioList.add(dto);
        //busco el tipocaso pasado por codigo
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", criterioList);
        if (objetoList == null) {
            JOptionPane.showMessageDialog(null, "Tipo Caso no encontrado. Ingrese código de tipo caso nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        TipoCaso tipocaso = (TipoCaso) objetoList.get(0);
        if (tipocaso.getFechaFinVigenciaTipoCaso()!=null) {
            JOptionPane.showMessageDialog(null, "El Tipo Caso ingresado ha sido dado de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        objetoList.clear();
        criterioList.clear();
        DTOCriterio dto2 = new DTOCriterio();
        dto2.setAtributo("tipocaso");
        dto2.setOperacion("=");
        dto2.setValor(tipocaso);
        criterioList.add(dto2);
        DTOCriterio dto3 = new DTOCriterio();
        dto3.setAtributo("nroConfigTC");
        dto3.setOperacion("=");
        dto3.setValor(numeroConfig);
        criterioList.add(dto3);
        objetoList = FachadaPersistencia.getInstance().buscar("ConfiguracionTipoCaso", criterioList);
        configamodificar = (ConfiguracionTipoCaso) objetoList.get(0);
        if (configamodificar.getFechaVerificacion()!=null) {
            JOptionPane.showMessageDialog(null, "No se puede modificar una Configuracion ya verificada", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        configamodificar.setFechaInicioVigencia(fechainicio);
        configamodificar.getListaTipoCasoTipoInstancia().clear();
        for (Object x : listatipocasotipoinstancia){
            DTOTipoCasoTipoInstancia undto = (DTOTipoCasoTipoInstancia) x;
            int minutosmax,orden,codigoTI;
            codigoTI = undto.getCodigoTipoInstancia();
            minutosmax = undto.getMinutosMaximaResolucion();
            orden = undto.getOrdenTipoCasoTipoInstancia();
            if (orden<=0) {
                JOptionPane.showMessageDialog(null, "El orden de un TipoCasoTipoInstancia no puede ser menor o igual a 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            TipoCasoTipoInstancia tipocasotipoinstanciamodificada= new TipoCasoTipoInstancia();
            tipocasotipoinstanciamodificada.setOrdenTipoCasoTipoInstancia(orden);
            tipocasotipoinstanciamodificada.setMinutosMaximaResolucion(minutosmax);
            DTOCriterio dto4 = new DTOCriterio();
            dto4.setAtributo("codTipoInstancia");
            dto4.setOperacion("=");
            dto4.setValor(codigoTI);
            criterioList.clear();
            criterioList.add(dto4);
            objetoList.clear();
            objetoList = FachadaPersistencia.getInstance().buscar("TipoInstancia", criterioList);
            TipoInstancia tiaasignar = (TipoInstancia) objetoList.get(0);
            if (tiaasignar.getFechaHoraFinVigenciaTipoInstancia()!=null) {
                JOptionPane.showMessageDialog(null, "El Tipo Instancia ingresado ha sido dado de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            tipocasotipoinstanciamodificada.setTipoinstancia(tiaasignar);
            configamodificar.addListaTipoCasoTipoInstancia(tipocasotipoinstanciamodificada);
            }
        FachadaPersistencia.getInstance().guardar(configamodificar);
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return true;
    }
    
    public boolean darBajaConfiguracion (String nroConfig, String codTC) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        ConfiguracionTipoCaso configadardebaja = new ConfiguracionTipoCaso();
        int codigotc,numeroConfig;     
            try  {
            codigotc=(Integer.parseInt(codTC));
            }
            catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese un número entero al código del Tipo Caso a asignar", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
            }
            try  {
            numeroConfig=(Integer.parseInt(nroConfig));
            }
            catch (Exception e){
            JOptionPane.showMessageDialog(null, "El número de configuración debe ser un número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
            }
        if (codigotc<=0) {
            JOptionPane.showMessageDialog(null, "El código del Tipo Caso a asignar no puede ser menor o igual a 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false; 
        }   
        if (numeroConfig<=0) {
            JOptionPane.showMessageDialog(null, "El número de configuración no puede ser menor o igual a 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoCaso");
        dto.setOperacion("=");
        dto.setValor(codigotc);
        criterioList.add(dto);
        //busco el tipocaso pasado por codigo
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", criterioList);
        if (objetoList == null) {
            JOptionPane.showMessageDialog(null, "Tipo Caso no encontrado. Ingrese código de tipo caso nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        TipoCaso tipocaso = (TipoCaso) objetoList.get(0);
        if (tipocaso.getFechaFinVigenciaTipoCaso()!=null) {
            JOptionPane.showMessageDialog(null, "El Tipo Caso ingresado ha sido dado de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        objetoList.clear();
        criterioList.clear();
        DTOCriterio dto2 = new DTOCriterio();
        dto2.setAtributo("tipocaso");
        dto2.setOperacion("=");
        dto2.setValor(tipocaso);
        criterioList.add(dto2);
        DTOCriterio dto3 = new DTOCriterio();
        dto3.setAtributo("nroConfigTC");
        dto3.setOperacion("=");
        dto3.setValor(numeroConfig);
        criterioList.add(dto3);
        objetoList = FachadaPersistencia.getInstance().buscar("ConfiguracionTipoCaso", criterioList);
        configadardebaja = (ConfiguracionTipoCaso) objetoList.get(0);
        if (configadardebaja.getFechaFinVigencia()!=null) {
            JOptionPane.showMessageDialog(null, "La configuración ingresada ya ha sido dada de baja previamente.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Date fechadehoy = new Date();
        configadardebaja.setFechaFinVigencia(fechadehoy);
        FachadaPersistencia.getInstance().guardar(configadardebaja);
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return true;
    }
    
    public boolean verificarConfiguracion (String nroConfig, String codTC) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        ConfiguracionTipoCaso configaverificar = new ConfiguracionTipoCaso();
        int codigotc,numeroConfig;     
            try  {
            codigotc=(Integer.parseInt(codTC));
            }
            catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese un número entero al código del Tipo Caso a asignar", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
            }
            try  {
            numeroConfig=(Integer.parseInt(nroConfig));
            }
            catch (Exception e){
            JOptionPane.showMessageDialog(null, "El número de configuración debe ser un número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
            }
        if (codigotc<=0) {
            JOptionPane.showMessageDialog(null, "El código del Tipo Caso a asignar no puede ser menor o igual a 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false; 
        }   
        if (numeroConfig<=0) {
            JOptionPane.showMessageDialog(null, "El número de configuración no puede ser menor o igual a 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoCaso");
        dto.setOperacion("=");
        dto.setValor(codigotc);
        criterioList.add(dto);
        //busco el tipocaso pasado por codigo
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoCaso", criterioList);
        if (objetoList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tipo Caso no encontrado. Ingrese código de tipo caso nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        TipoCaso tipocaso = (TipoCaso) objetoList.get(0);
        if (tipocaso.getFechaFinVigenciaTipoCaso()!=null) {
            JOptionPane.showMessageDialog(null, "El Tipo Caso ingresado ha sido dado de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        objetoList.clear();
        criterioList.clear();
        DTOCriterio dto2 = new DTOCriterio();
        dto2.setAtributo("tipocaso");
        dto2.setOperacion("=");
        dto2.setValor(tipocaso);
        criterioList.add(dto2);
        DTOCriterio dto3 = new DTOCriterio();
        dto3.setAtributo("nroConfigTC");
        dto3.setOperacion("=");
        dto3.setValor(numeroConfig);
        criterioList.add(dto3);
        objetoList = FachadaPersistencia.getInstance().buscar("ConfiguracionTipoCaso", criterioList);
        configaverificar = (ConfiguracionTipoCaso) objetoList.get(0);
        
        //verifico que se cumpla el orden de los tipocasotipoinstancia
        int orden = 1;
        for (TipoCasoTipoInstancia x : configaverificar.getListaTipoCasoTipoInstancia()) {
            if (x.getOrdenTipoCasoTipoInstancia()!=orden) {
               JOptionPane.showMessageDialog(null, "Falta el TipoCasoTipoInstancia con el orden N°"+orden, "ERROR", JOptionPane.ERROR_MESSAGE);
               return false; 
            } else {
                if (orden==configaverificar.getListaTipoCasoTipoInstancia().size()) {
                    break;
                }else {
                    orden++;
                }
            }
            if (x.getTipoinstancia().getFechaHoraFinVigenciaTipoInstancia()!=null) {
               JOptionPane.showMessageDialog(null, "El Tipo Instancia asignado al TipoCasoTipoInstancia con el orden N°"+orden+" ha sido dado de baja", "ERROR", JOptionPane.ERROR_MESSAGE);
               return false; 
            }
        }
        //verifico que no exista una configuracion verificada con fechainicio mayor a la de la configuracion que estoy verificando
        criterioList.clear();
        criterioList.add(dto2);
        DTOCriterio dto4 = new DTOCriterio();
        dto4.setAtributo("fechaFinVigencia");
        dto4.setOperacion("=");
        dto4.setValor(null);
        criterioList.add(dto4);
        DTOCriterio dto5 = new DTOCriterio();
        dto5.setAtributo("fechaVerificacion");
        dto5.setOperacion("<>");
        dto5.setValor(null);
        criterioList.add(dto5);
        objetoList = FachadaPersistencia.getInstance().buscar("ConfiguracionTipoCaso", criterioList);
        if (objetoList.size()>0) {
            for (Object x : objetoList) {
                ConfiguracionTipoCaso unaconfig = (ConfiguracionTipoCaso) x;
                if (unaconfig.getFechaInicioVigencia().after(configaverificar.getFechaInicioVigencia())) {
                    JOptionPane.showMessageDialog(null, "Ya existe una configuración verificada con la fecha mayor a fecha de inicio”", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return false;
                } 
            }    
        }
        if (configaverificar.getFechaFinVigencia()!=null) {
            JOptionPane.showMessageDialog(null, "La configuración elegida ya ha sido dada de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Date fechadehoy = new Date();
        if (configaverificar.getFechaInicioVigencia().before(fechadehoy)) {
            JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser menor o igual a la fecha de hoy.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //tuve que convertir la fecha de inicio a instant para poder restarle un dia y asi asignarlo a la fecha de fin vigencia...
        Instant instant = Instant.ofEpochMilli(configaverificar.getFechaInicioVigencia().getTime());
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        LocalDateTime hoymenosundia = ldt.minusDays(1);
        instant = hoymenosundia.toInstant(ZoneOffset.UTC);
        Date datehoymenosuno = Date.from(instant);
        configaverificar.setFechaFinVigencia(datehoymenosuno);
        configaverificar.setFechaVerificacion(fechadehoy);
        JOptionPane.showMessageDialog(null, "La configuración fue verificada con éxito.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        FachadaPersistencia.getInstance().guardar(configaverificar);
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return true;   
    }
}
/*
    public boolean modificarTipoCaso(int codtipocaso,String nomTC,int maxiteraciones) {
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
    
    }*/