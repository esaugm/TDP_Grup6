/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.service;

import java.util.ArrayList;
import ss2.entity.Client;
import ss2.exception.AppException;

/**
 ***************************************
 * ss2.service.impl IClientService.java (UTF-8)
 * **************************************
 *
 * Uoc Primavera 2013, Grup06 Fecha: 2013.05.15 11:38:12
 *
 * @author jiquintana (José Ignacio Quintana)
 *
 */
public interface IClientService {

    Boolean altaCliente(Client client) throws AppException;

    Boolean bajaCliente(Client client) throws AppException;

    ArrayList<Client> buscaCliente(String freetext) throws AppException;

    ArrayList<Client> buscaClientebyNIF(String nif) throws AppException;

    Client buscaClientebynumclient(Integer numclient) throws AppException;

    ArrayList<Client> listaClientes() throws AppException;

    Boolean modificaCliente(Client client) throws AppException;
}
