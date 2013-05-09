/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.dao.impl;

import common.dao.impl.GenericDaoImpl;
//import common.utils.GestorBBDD;
import static common.utils.GestorBBDD.freeResources;
import ss2.entity.Client;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ss2.dao.IClient;
import ss2.exception.AppException;

/**
 ***************************************
 * ClientDAO.java (UTF8)
 * *************************************
 * Uoc Primavera 2013,
 * Grup06
 * Fecha: 2013.05.05 23:38:32
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class ClientDAO extends GenericDaoImpl implements IClient {

   // protected Connection connection;
    protected PreparedStatement preparedstatement;
    protected ResultSet resultset;

    public ClientDAO() {
    }

    @Override
    public void checkAndInitDAO() throws AppException {
        checkSequence("client_id_seq");
    }

    private void checkSequence(String sequenceName) throws AppException {
        String SQL1 = "SELECT * from " + sequenceName;
        String SQL2 = "CREATE SEQUENCE " + sequenceName + " start 250000";
        Boolean wasconnected = false;
        Boolean sequenceexists = false;
        Integer result;

        Client client = new Client();

        try {
            connection = getConnection();
            wasconnected = true;
            preparedstatement = connection.prepareStatement(SQL1);
            resultset = preparedstatement.executeQuery();
        } catch (ClassNotFoundException ex) {
        } catch (IOException ex) {
        } catch (SQLException ex) {
            if (wasconnected && !sequenceexists) {
                // No existe la secuencia => la creamos
                try {
                    preparedstatement = connection.prepareStatement(SQL2);
                    preparedstatement.executeUpdate();
                } catch (SQLException ex2) {
                    // no hemos podido crear la secuencia => throw
                    throw new AppException(ex2);
                }
            } else {
                // la secuencia ya existe => do nothing
            }
        } finally {
            freeResources(connection, preparedstatement, resultset);
        }
    }

    @Override
    public ArrayList<Client> getClient() throws AppException {
        String SQL = "SELECT * from client";
        ArrayList<Client> listaclient = new ArrayList<Client>();

        try {
            connection = getConnection();

            preparedstatement = connection.prepareStatement(SQL);
            resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                Client cliente = new Client(
                        resultset.getString("nom"),
                        resultset.getString("cognoms"),
                        resultset.getString("adreca"),
                        resultset.getString("nif"),
                        resultset.getString("poblacio"),
                        resultset.getInt("codipostal"),
                        resultset.getInt("numclient"),
                        resultset.getDate("dataalta"));
                listaclient.add(cliente);
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            freeResources(connection, preparedstatement, resultset);
        }
        return listaclient;
    }

    @Override
    public ArrayList<Client> getClientbyPK(String nif) throws AppException {
        String SQL = "SELECT * from client where nif like ?";
        ArrayList<Client> listaclient = new ArrayList<Client>();

        try {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(SQL);
            preparedstatement.setString(1, nif + '%');
            resultset = preparedstatement.executeQuery();

            while (resultset.next()) {
                Client cliente = new Client(
                        resultset.getString("nom"),
                        resultset.getString("cognoms"),
                        resultset.getString("adreca"),
                        resultset.getString("nif"),
                        resultset.getString("poblacio"),
                        resultset.getInt("codipostal"),
                        resultset.getInt("numclient"),
                        resultset.getDate("dataalta"));
                listaclient.add(cliente);
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            freeResources(connection, preparedstatement, resultset);
        }
        return listaclient;
    }

    @Override
    public Client getClientbyNumClient(Integer numclient) throws AppException {
        String SQL = "SELECT * from client where numclient = ?";
        Client client = new Client();

        try {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(SQL);
            preparedstatement.setLong(1, numclient);
            resultset = preparedstatement.executeQuery();

            while (resultset.next()) {
                client = new Client(
                        resultset.getString("nom"),
                        resultset.getString("cognoms"),
                        resultset.getString("adreca"),
                        resultset.getString("nif"),
                        resultset.getString("poblacio"),
                        resultset.getInt("codipostal"),
                        resultset.getInt("numclient"),
                        resultset.getDate("dataalta"));
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            freeResources(connection, preparedstatement, resultset);
        }
        return client;
    }

    @Override
    public ArrayList<Client> getClientbyANY(String freetext) throws AppException {
        String SQL = "SELECT * from client where (client.*)::text ilike ?";
        ArrayList<Client> listaclient = new ArrayList<Client>();

        try {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(SQL);
            preparedstatement.setString(1, '%' + freetext + '%');
            resultset = preparedstatement.executeQuery();

            while (resultset.next()) {
                Client cliente = new Client(
                        resultset.getString("nom"),
                        resultset.getString("cognoms"),
                        resultset.getString("adreca"),
                        resultset.getString("nif"),
                        resultset.getString("poblacio"),
                        resultset.getInt("codipostal"),
                        resultset.getInt("numclient"),
                        resultset.getDate("dataalta"));
                listaclient.add(cliente);
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            freeResources(connection, preparedstatement, resultset);
        }
        return listaclient;
    }

    @Override
    public Boolean createClient(Client cliente) throws AppException {
        Boolean succeded = false;
        Boolean wasconnected = false;
        String SQL = "INSERT INTO Client "
                + "(nom,cognoms,adreca,nif,poblacio,codipostal,numclient,dataalta) "
                + "VALUES (?,?,?,?,?,?,nextval('client_id_seq'),now())";

        try {
            connection = getConnection();
            wasconnected = true;
            preparedstatement = connection.prepareStatement(SQL);
            preparedstatement.setString(1, cliente.getnom());
            preparedstatement.setString(2, cliente.getcognoms());
            preparedstatement.setString(3, cliente.getadreca());
            preparedstatement.setString(4, cliente.getNif());
            preparedstatement.setString(5, cliente.getPoblacio());
            preparedstatement.setInt(6, cliente.getCodiPostal());
            //preparedstatement.setInt(7,cliente.getNumClient());
            if (preparedstatement.executeUpdate() > 0) {
                succeded = true;
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            if (!wasconnected) {
                throw new AppException(ex);
            }
        } finally {
            freeResources(connection, preparedstatement, resultset);
        }
        return succeded;
    }

    @Override
    public Boolean modifyClient(Client cliente) throws AppException {
        Integer rowsmodified;
        Boolean succeded = false;
        Boolean wasconnected = false;

        String SQL = "UPDATE Client SET "
                + "nom = ?, cognoms = ?, adreca = ?, poblacio = ?, "
                + "codipostal = ? where nif = ?";

        try {
            connection = getConnection();
            wasconnected = true;
            preparedstatement = connection.prepareStatement(SQL);
            preparedstatement.setString(1, cliente.getnom());
            preparedstatement.setString(2, cliente.getcognoms());
            preparedstatement.setString(3, cliente.getadreca());
            preparedstatement.setString(4, cliente.getPoblacio());
            preparedstatement.setInt(5, cliente.getCodiPostal());
            preparedstatement.setString(6, cliente.getNif());
            if (preparedstatement.executeUpdate() > 0) {
                succeded = true;
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            if (!wasconnected) {
                throw new AppException(ex);
            }
        } finally {
            freeResources(connection, preparedstatement, resultset);
        }
        return succeded;
    }

    @Override
    public Boolean deleteClient(Client cliente) throws AppException {
        Integer rowsmodified;
        Boolean succeded = false;
        Boolean wasconnected = false;

        String SQL = "DELETE FROM Client WHERE nif = ?";

        try {
            connection = getConnection();
            wasconnected = true;
            preparedstatement = connection.prepareStatement(SQL);
            preparedstatement.setString(1, cliente.getNif());
            if (preparedstatement.executeUpdate() > 0) {
                succeded = true;
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            if (!wasconnected) {
                throw new AppException(ex);
            }
        } finally {
            freeResources(connection, preparedstatement, resultset);
        }
        return succeded;
    }
}
