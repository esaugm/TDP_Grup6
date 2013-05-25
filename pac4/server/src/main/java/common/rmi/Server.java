package common.rmi;

import ss1.server.impl.SS1ConexioMantenimentImpl;
import ss3.server.impl.SS3ReparacionesImpl;
import ss4.server.ISS4Estadisticas;
import ss4.server.impl.ISS4EstadisticasImpl;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import ss2.server.impl.SS2GestionAdministrativaImpl;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 19/05/13
 * Time: 12:13
 */
public class Server {
    private final int PORT = 1099;
    private final String JNDI_SS1_NAME = "ConexioManteniment";
    private final String JNDI_SS2_NAME = "GestionAdministrativa";
    private final String JNDI_SS3_NAME = "Reparaciones";
    private final String JNDI_SS4_NAME = "Estadisticas";
    /*ToDo: añadir cada uno de los nombres de cada subsistema, por ejemplo:
    private final String JNDI_SS2_NAME = "SS2";
    private final String JNDI_SS3_NAME = "SS3";
    private final String JNDI_SS4_NAME = "SS4";
    */


    public static void main(String args[]) throws IOException {
        new Server();

    }


    public void start() throws Exception {
        System.out.println("Iniciando servidor RMI...");
        Registry registry = LocateRegistry.createRegistry(PORT);
        SS1ConexioMantenimentImpl objetoRemotoSS1 = new SS1ConexioMantenimentImpl();
        registry.rebind(JNDI_SS1_NAME, objetoRemotoSS1);
        SS2GestionAdministrativaImpl objetoRemotoSS2 = new SS2GestionAdministrativaImpl();
        registry.rebind(JNDI_SS2_NAME, objetoRemotoSS2);
        SS3ReparacionesImpl objetoRemotoSS3 = new SS3ReparacionesImpl();
        registry.rebind(JNDI_SS3_NAME, objetoRemotoSS3);
        ISS4Estadisticas objetoRemotoSS4 = new ISS4EstadisticasImpl();
        registry.rebind(JNDI_SS4_NAME, objetoRemotoSS4);
        /* Añadir cada implementacion del servidor por subsistema
        SS2Impl objetoRemotoSS2 = new SS2Impl();
        registry.rebind(JNDI_SS2_NAME, objetoRemotoSS2);
        ...
        */

        System.out.println("Servidor iniciado!");

    }

    public void stop() {
        System.out.println("Parando servidor RMI...");
        System.exit(0);
    }
}
