package ss4.server;

import ss4.model.EstadisticaReparaciones;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 23/05/13
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 */
public interface ISS4Estadisticas extends Remote {

    public List<EstadisticaReparaciones> findReparacionesByTerms(Map values) throws RemoteException;

    public List<EstadisticaReparaciones> findReparacionesByTermsClientes(Map values) throws RemoteException;
}
