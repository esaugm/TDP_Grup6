/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.service.impl;

import ss2.service.IClientService;
import java.util.ArrayList;
import ss2.dao.IClientDAO;
import ss2.dao.impl.ClientDAO;
import ss2.entity.Client;
import ss2.exception.AppException;

/**
 ***************************************
 * ss2.service.impl ClientService.java (UTF-8)
 * **************************************
 *
 * Uoc Primavera 2013, Grup06 Fecha: 2013.05.14 10:15:02
 *
 * @author jiquintana (José Ignacio Quintana)
 *
 */
public class ClientService implements IClientService {

    IClientDAO clientDAO;

    public ClientService() throws AppException {
        this.clientDAO = new ClientDAO();
        this.clientDAO.checkAndInitDAO();
    }

    @Override
    public Boolean altaCliente(Client client) throws AppException {
        return clientDAO.createClient(client);
    }

    @Override
    public Boolean bajaCliente(Client client) throws AppException {
        return clientDAO.deleteClient(client);
    }

    @Override
    public Boolean modificaCliente(Client client) throws AppException {
        return clientDAO.modifyClient(client);
    }

    @Override
    public ArrayList<Client> buscaCliente(String freetext) throws AppException {
        return clientDAO.getClientbyANY(freetext);
    }

    @Override
    public ArrayList<Client> buscaClientebyNIF(String nif) throws AppException {
        return clientDAO.getClientbyPK(nif);
    }

    @Override
    public Client buscaClientebynumclient(Integer numclient) throws AppException {
        return clientDAO.getClientbyNumClient(numclient);
    }

    @Override
    public ArrayList<Client> listaClientes() throws AppException {
        return clientDAO.getClient();
    }
}
