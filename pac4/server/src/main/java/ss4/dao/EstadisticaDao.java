package ss4.dao;

import ss4.model.EstadisticaReparaciones;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 22/05/13
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
public interface EstadisticaDao {

    public List<EstadisticaReparaciones> findReparacionesByTerms(Map values);

    public List<EstadisticaReparaciones> findReparacionesByTermsClientes(Map values);
}
