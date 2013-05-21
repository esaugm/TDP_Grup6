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

    Boolean altaCliente(Client client) throws AppException;

    Boolean altaSolicitud(Solicitud solicitud) throws AppException;

    Integer altaSolicitudRetNumsol(Solicitud solicitud) throws AppException;

    Solicitud altaSolicitudRetSolicitud(Solicitud solicitud) throws AppException;

    Boolean bajaCliente(Client client) throws AppException;

    ArrayList<Client> buscaCliente(String freetext) throws AppException;

    ArrayList<Client> buscaClientebyNIF(String nif) throws AppException;

    Client buscaClientebynumclient(Integer numclient) throws AppException;

    ArrayList<Solicitud> buscaSolicitudbyANY(String freetext) throws AppException;

    Solicitud buscaSolicitudbynumsol(Integer numsolicitud) throws AppException;

    ArrayList<Solicitud> consultaSolicitudes() throws AppException;

    StockPeca consultaStockPiezabyCodigoPieza(Integer codigoPieza, Integer idTaller) throws AppException;

    StockPeca consultaStockPiezabyCodigoStockPieza(Integer codigoPieza, Integer idTaller) throws AppException;

    ArrayList<StockPeca> consultaStockPiezas(Integer idTaller) throws AppException;

    Solicitud finalizaSolicitud(Integer numsolicitud) throws AppException;
    /*
     Boolean deleteSolicitud(Solicitud solicitud) throws AppException;
     */

    ArrayList<Client> listaClientes() throws AppException;

    Boolean modificaCliente(Client client) throws AppException;

    Boolean modificaSolicitud(Solicitud solicitud) throws AppException;

    Solicitud modificaSolicitudwithRet(Solicitud solicitud) throws AppException;

    Integer modificaStockPieza_Stock(Integer codigoPieza, Integer idTaller, Integer incremento) throws AppException;

    Integer modificaStockPieza_StockMinimo(Integer codigoPieza, Integer idTaller, Integer incremento) throws AppException;
}
