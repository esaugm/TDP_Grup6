/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.dao;

import ss2.beans.Client;
import java.util.ArrayList;
import ss2.exception.AppException;

/**
 ***************************************
 * edu.uoc.tdp.pac4.SS2 GestorClientInterface.java (windows-1252)
 * ************************************** Uoc Primavera 2013, Grup06 Fecha:
 * 2013.05.06 0:47:17
 *
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public interface GestorClientInterface {

    ArrayList<Client> getClient() throws AppException;

    public ArrayList<Client> getClientbyPK(String nif) throws AppException;

    public Client getClientbyNC(Integer numclient) throws AppException;
}
