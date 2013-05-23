package ss4.service.impl;

import ss4.dao.EstadisticaDao;
import ss4.dao.impl.EstadisticaDaoImpl;
import ss4.model.EstadisticaReparaciones;
import ss4.service.EstadisticasService;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 23/05/13
 * Time: 8:57
 * To change this template use File | Settings | File Templates.
 */
public class EstadisticasServiceImpl implements EstadisticasService {
    private EstadisticaDao estadisticaDao;

    public EstadisticasServiceImpl() {
        estadisticaDao = new EstadisticaDaoImpl();
    }

    @Override
    public List<EstadisticaReparaciones> findReparacionesByTerms(Map values) {
        return estadisticaDao.findReparacionesByTerms(values);
    }

    @Override
    public List<EstadisticaReparaciones> findReparacionesByTermsClientes(Map values) {
        return estadisticaDao.findReparacionesByTermsClientes(values);
    }
}
