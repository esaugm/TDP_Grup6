/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.dao.impl;

import common.dao.impl.GenericDaoImpl;
import common.utils.ConnectionFactory;
import ss2.entity.Client;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ss2.dao.IClientDAO;
import ss2.exception.AppException;

/**
 ***************************************
 * ClientDAO.java (UTF8) ************************************* Uoc Primavera
 * 2013, Grup06 Fecha: 2013.05.05 23:38:32
 *
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class ClientDAO extends GenericDaoImpl implements IClientDAO {

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
            ptmt = connection.prepareStatement(SQL1);
            resultSet = ptmt.executeQuery();
        } catch (ClassNotFoundException ex) {
        } catch (IOException ex) {
        } catch (SQLException ex) {
            if (wasconnected && !sequenceexists) {
                // No existe la secuencia => la creamos
                try {
                    ptmt = connection.prepareStatement(SQL2);
                    ptmt.executeUpdate();
                } catch (SQLException ex2) {
                    // no hemos podido crear la secuencia => throw
                    throw new AppException(ex2);
                }
            } else {
                // la secuencia ya existe => do nothing
            }
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }
    }

    @Override
    public ArrayList<Client> getClient() throws AppException {
        String SQL = "SELECT * from client";
        ArrayList<Client> listaclient = new ArrayList<Client>();

        try {
            connection = getConnection();

            ptmt = connection.prepareStatement(SQL);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Client cliente = new Client(
                    resultSet.getString("nom"),
                    resultSet.getString("cognoms"),
                    resultSet.getString("adreca"),
                    resultSet.getString("nif"),
                    resultSet.getString("poblacio"),
                    resultSet.getInt("codipostal"),
                    resultSet.getInt("numclient"),
                    resultSet.getDate("dataalta"));
                listaclient.add(cliente);
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }
        return listaclient;
    }

    @Override
    public ArrayList<Client> getClientbyPK(String nif) throws AppException {
        String SQL = "SELECT * from client where nif like ?";
        ArrayList<Client> listaclient = new ArrayList<Client>();

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, nif + '%');
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                Client cliente = new Client(
                    resultSet.getString("nom"),
                    resultSet.getString("cognoms"),
                    resultSet.getString("adreca"),
                    resultSet.getString("nif"),
                    resultSet.getString("poblacio"),
                    resultSet.getInt("codipostal"),
                    resultSet.getInt("numclient"),
                    resultSet.getDate("dataalta"));
                listaclient.add(cliente);
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }
        return listaclient;
    }

    @Override
    public Client getClientbyNumClient(Integer numclient) throws AppException {
        String SQL = "SELECT * from client where numclient = ?";
        Client client = new Client();

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setLong(1, numclient);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                client = new Client(
                    resultSet.getString("nom"),
                    resultSet.getString("cognoms"),
                    resultSet.getString("adreca"),
                    resultSet.getString("nif"),
                    resultSet.getString("poblacio"),
                    resultSet.getInt("codipostal"),
                    resultSet.getInt("numclient"),
                    resultSet.getDate("dataalta"));
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }
        return client;
    }

    @Override
    public ArrayList<Client> getClientbyANY(String freetext) throws AppException {
        String SQL = "SELECT * from client where (client.*)::text ilike ?";
        ArrayList<Client> listaclient = new ArrayList<Client>();

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, '%' + freetext + '%');
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                Client cliente = new Client(
                    resultSet.getString("nom"),
                    resultSet.getString("cognoms"),
                    resultSet.getString("adreca"),
                    resultSet.getString("nif"),
                    resultSet.getString("poblacio"),
                    resultSet.getInt("codipostal"),
                    resultSet.getInt("numclient"),
                    resultSet.getDate("dataalta"));
                listaclient.add(cliente);
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }
        return listaclient;
    }

    @Override
    public Boolean createClient(Client cliente) throws AppException {
        Boolean succeded = false;
        Boolean wasconnected = false;
        String SQL = "INSERT INTO Client "
            + "(nom,cognoms,adreca,nif,poblacio,codipostal) "
            + "VALUES (?,?,?,?,?,?)";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, cliente.getnom());
            ptmt.setString(2, cliente.getcognoms());
            ptmt.setString(3, cliente.getadreca());
            ptmt.setString(4, cliente.getNif());
            ptmt.setString(5, cliente.getPoblacio());
            ptmt.setInt(6, cliente.getCodiPostal());
            //ptmt.setInt(7,cliente.getNumClient());
            if (ptmt.executeUpdate() > 0) {
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
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
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
            + "codipostal = ? where numclient = ?";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, cliente.getnom());
            ptmt.setString(2, cliente.getcognoms());
            ptmt.setString(3, cliente.getadreca());
            ptmt.setString(4, cliente.getPoblacio());
            ptmt.setInt(5, cliente.getCodiPostal());
            ptmt.setInt(6, cliente.getNumClient());
            if (ptmt.executeUpdate() > 0) {
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
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
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
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, cliente.getNif());
            if (ptmt.executeUpdate() > 0) {
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
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }
        return succeded;
    }
}
