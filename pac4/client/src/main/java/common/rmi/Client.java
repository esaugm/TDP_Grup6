package common.rmi;

import ss1.dao.exception.ExceptionContrasenyaIncorrecta;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.dao.exception.ExceptionUsuariNoExisteix;
import ss1.entity.Taller;
import ss1.entity.Usuari;
import ss1.server.ISS1ConexioManteniment;
import ss1.service.filter.FilterItems;
import ss3.beans.Reparacion;
import ss3.server.SS3Reparaciones;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 19/05/13
 * Time: 12:12
 */
public class Client {
    
    private final String URL = "localhost";
    private final int PORT = 1099;
    
    private ISS1ConexioManteniment remoteSS1;
    private final String JNDI_SS1_NAME = "ConexioManteniment";
    private SS3Reparaciones remoteSS3;
    private final String JNDI_SS3_NAME = "Reparaciones";
    //todo añadir Interface y JNDI para cada subsistema


        /**
         * Starts the connection with the server
         * @throws java.rmi.RemoteException if there's some problem connecting with the server
         */
        public void connect() throws Exception{
            System.out.println("Connecting with the server...");
            Registry registry = LocateRegistry.getRegistry(URL, PORT);
            remoteSS1 = (ISS1ConexioManteniment) registry.lookup(JNDI_SS1_NAME);
            remoteSS3 = (SS3Reparaciones) registry.lookup(JNDI_SS3_NAME);
            //todo añadir los interfaces de cada subsistema
            System.out.println("Connected!");
        }

        public void disconnect(){
            System.out.println("Disconnecting from server...");
            System.exit(0);
        }

        public Usuari makeLogin(String pUsuari, String pPasswd) throws RemoteException, ExceptionUsuariNoExisteix, ExceptionContrasenyaIncorrecta, ExceptionErrorDataBase {
            return remoteSS1.usuariLogin(pUsuari,pPasswd);
        }

    public void altaUsuari(Usuari newUsuari) throws ExceptionErrorDataBase, RemoteException {
        remoteSS1.altaUsuari(newUsuari);
    }

    public List<Taller> listaTallers() throws ExceptionErrorDataBase, RemoteException {
        return remoteSS1.getAllTallers();
    }
    
    public List<Usuari> filtrarUsuaris(FilterItems pFilterItems) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido, RemoteException {
        return remoteSS1.getAllUsuarisByFilter(pFilterItems);
        
    }
    
    public Reparacion ConsultaOrden(Integer OrdenID) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaOrden(OrdenID);
    }
    
    public ArrayList<Reparacion> ConsultaFechaAsig(String fechaAsig) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaFechaAsig(fechaAsig);
    }
    
    public ArrayList<Reparacion> ConsultaFechaIni(String fechaIni) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaFechaIni(fechaIni);
    }
    
    public ArrayList<Reparacion> ConsultaFechaFin(String fechaFin) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaFechaFin(fechaFin);
    }
    
    public ArrayList<Reparacion> ConsultaAceptadas(Boolean aceptada) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaAceptadas(aceptada);
    }
    
    public ArrayList<Reparacion> ConsultaAsignadas(Boolean asignada) throws ExceptionErrorDataBase, RemoteException {
        return remoteSS3.ConsultaAsignadas(asignada);
    }
    
    public Boolean anotaObs(Integer orden, String observaciones) throws ExceptionErrorDataBase, RemoteException{
        return remoteSS3.anotaObs(orden, observaciones);
    }
}
