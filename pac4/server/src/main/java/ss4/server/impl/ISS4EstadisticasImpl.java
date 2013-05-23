package ss4.server.impl;

import ss1.server.ISS1ConexioManteniment;
import ss4.model.EstadisticaReparaciones;
import ss4.server.ISS4Estadisticas;
import ss4.service.EstadisticasService;
import ss4.service.impl.EstadisticasServiceImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 23/05/13
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 */
public class ISS4EstadisticasImpl extends UnicastRemoteObject implements ISS4Estadisticas, Serializable {

    private EstadisticasService estadisticasService;

    public ISS4EstadisticasImpl() throws RemoteException {
        super();
        this.estadisticasService = new EstadisticasServiceImpl();
    }


    @Override
    public List<EstadisticaReparaciones> findReparacionesByTerms(Map values) throws RemoteException {
        return estadisticasService.findReparacionesByTerms(values);
    }

    @Override
    public List<EstadisticaReparaciones> findReparacionesByTermsClientes(Map values) throws RemoteException {
        return estadisticasService.findReparacionesByTermsClientes(values);
    }
}
