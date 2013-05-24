package ss4.service;

import ss4.model.EstadisticaReparaciones;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 23/05/13
 * Time: 8:56
 * To change this template use File | Settings | File Templates.
 */
public interface EstadisticasService {
    public List<EstadisticaReparaciones> findReparacionesByTerms(Map values);
    public List<EstadisticaReparaciones> findReparacionesByTermsClientes(Map values);
}
