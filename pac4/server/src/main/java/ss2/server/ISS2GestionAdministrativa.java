/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.server;

import java.io.Serializable;
import java.util.ArrayList;
import ss2.entity.Client;
import ss2.entity.Solicitud;
import ss2.entity.StockPeca;
import ss2.exception.AppException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 ***************************************
 * ss2.server.impl ISS2GestionAdministrativa.java (UTF-8)
 * **************************************
 *
 * Uoc Primavera 2013, Grup06 Fecha: 2013.05.15 12:19:50
 *
 * @author jiquintana (José Ignacio Quintana)
 *
 */
public interface ISS2GestionAdministrativa extends Remote {

    Boolean altaCliente(Client client) throws AppException, RemoteException;

    Boolean altaSolicitud(Solicitud solicitud) throws AppException, RemoteException;

    Integer altaSolicitudRetNumsol(Solicitud solicitud) throws AppException, RemoteException;

    Solicitud altaSolicitudRetSolicitud(Solicitud solicitud) throws AppException, RemoteException;

    Boolean bajaCliente(Client client) throws AppException, RemoteException;

    ArrayList<Client> buscaCliente(String freetext) throws AppException, RemoteException;

    ArrayList<Client> buscaClientebyNIF(String nif) throws AppException, RemoteException;

    Client buscaClientebynumclient(Integer numclient) throws AppException, RemoteException;

    ArrayList<Solicitud> buscaSolicitudbyANY(String freetext) throws AppException, RemoteException;

    Solicitud buscaSolicitudbynumsol(Integer numsolicitud) throws AppException, RemoteException;
    
    Solicitud buscaSolicitudbynumrep(Integer orden) throws AppException, RemoteException;

    ArrayList<Solicitud> consultaSolicitudes() throws AppException, RemoteException;

    StockPeca consultaStockPiezabyCodigoPieza(Integer codigoPieza, Integer idTaller) throws AppException, RemoteException;

    StockPeca consultaStockPiezabyCodigoStockPieza(Integer codigoPieza, Integer idTaller) throws AppException, RemoteException;

    ArrayList<StockPeca> consultaStockPiezas(Integer idTaller) throws AppException, RemoteException;

    Solicitud finalizaSolicitud(Integer numsolicitud) throws AppException, RemoteException;
    /*
     Boolean deleteSolicitud(Solicitud solicitud) throws AppException;
     */

    ArrayList<Client> listaClientes() throws AppException, RemoteException;

    Boolean modificaCliente(Client client) throws AppException, RemoteException;

    Boolean modificaSolicitud(Solicitud solicitud) throws AppException, RemoteException;

    Solicitud modificaSolicitudwithRet(Solicitud solicitud) throws AppException, RemoteException;

    Integer modificaStockPieza_Stock(Integer codigoPieza, Integer idTaller, Integer incremento) throws AppException, RemoteException;

    Integer modificaStockPieza_StockMinimo(Integer codigoPieza, Integer idTaller, Integer incremento) throws AppException, RemoteException;
}
