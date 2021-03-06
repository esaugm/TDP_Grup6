
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.dao;

//~--- non-JDK imports --------------------------------------------------------
import ss2.entity.Client;

import ss2.exception.AppException;

//~--- JDK imports ------------------------------------------------------------

import java.rmi.Remote;

import java.util.ArrayList;

/**
 * **************************************
 * IClientDAO.java (UTF-8)
 * **************************************
 * Uoc Primavera 2013,
 * Grup06
 * Fecha: 2013.05.06 0:47:17
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public interface IClientDAO extends Remote {

    public void checkAndInitDAO() throws AppException;

    public ArrayList<Client> getClient() throws AppException;

    public ArrayList<Client> getClientbyPK(String nif) throws AppException;

    public Client getClientbyNumClient(Integer numclient) throws AppException;

    public ArrayList<Client> getClientbyANY(String freetext) throws AppException;

    public Boolean createClient(Client cliente) throws AppException;

    public Boolean modifyClient(Client cliente) throws AppException;

    public Boolean deleteClient(Client cliente) throws AppException;
}
