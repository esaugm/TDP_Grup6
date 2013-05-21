package common.rmi;

import ss1.dao.exception.ExceptionContrasenyaIncorrecta;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionUsuariNoExisteix;
import ss1.entity.Usuari;
import ss1.server.ISS1ConexioManteniment;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

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
    //todo añadir Interface y JNDI para cada subsistema


        /**
         * Starts the connection with the server
         * @throws java.rmi.RemoteException if there's some problem connecting with the server
         */
        public void connect() throws Exception{
            System.out.println("Connecting with the server...");
            Registry registry = LocateRegistry.getRegistry(URL, PORT);
            remoteSS1 = (ISS1ConexioManteniment) registry.lookup(JNDI_SS1_NAME);
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

}
