
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package ss2.dao.impl;

//~--- non-JDK imports --------------------------------------------------------

import common.dao.impl.GenericDaoImpl;

import common.utils.ConnectionFactory;

import ss2.dao.ISolicitud;

import ss2.entity.Solicitud;

import ss2.exception.AppException;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

/**
 *
 * SolicitudDAO.java (UTF8)
 *
 * Uoc Primavera 2013,
 * Grup06
 * Fecha: 2013.05.09 21:56:32
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class SolicitudDAO extends GenericDaoImpl implements ISolicitud {

    // protected Connection connection;
    protected PreparedStatement preparedstatement;
    protected ResultSet         resultset;

    public SolicitudDAO() {}

    @Override
    public void checkAndInitDAO() throws AppException {
        checkSequence("solicitud_id_seq");
    }

    private void checkSequence(String sequenceName) throws AppException {
        String  SQL1           = "SELECT * from " + sequenceName;
        String  SQL2           = "CREATE SEQUENCE " + sequenceName + " start 10";
        Boolean wasconnected   = false;
        Boolean sequenceexists = false;
        Integer result;
        Solicitud  solicitud = new Solicitud();

        try {
            connection        = getConnection();
            wasconnected      = true;
            preparedstatement = connection.prepareStatement(SQL1);
            resultset         = preparedstatement.executeQuery();
        } catch (ClassNotFoundException ex) {}
        catch (IOException ex) {}
        catch (SQLException ex) {
            if (wasconnected &&!sequenceexists) {

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
            ConnectionFactory.freeResources(connection, preparedstatement, resultset);
        }
    }

    @Override
    public ArrayList<Solicitud> getSolicitud() throws AppException {
        String SQL = "SELECT * from solicitud";
        ArrayList<Solicitud> listasolicitud = new ArrayList<Solicitud>();

        try {
            connection        = getConnection();
            preparedstatement = connection.prepareStatement(SQL);
            resultset         = preparedstatement.executeQuery();

            while (resultset.next()) {
                Solicitud solicitud = new Solicitud(
					resultset.getInt("numsol"),
					resultset.getString("comentaris"),
					resultset.getDate("dataalta"),
					resultset.getDate("datafinalitzacio"),
					resultset.getString("client"),
                    resultset.getInt("numreparacio"),
                    resultSet.getBoolean("pendent"),
					resultSet.getBoolean("finalitzada"),
					resultset.getInt("asseguradora"),
					resultset.getString("numPoliza"),
					resultset.getInt("idtaller"));
                listasolicitud.add(solicitud);
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, preparedstatement, resultset);
        }

        return listasolicitud;
    }

    @Override
    public Solicitud getSolicitudbyNumSolicitud(Integer numsolicitud) throws AppException {
        String SQL    = "SELECT * from solicitud where numsolicitud = ?";
        Solicitud solicitud = new Solicitud();

        try {
            connection        = getConnection();
            preparedstatement = connection.prepareStatement(SQL);
            preparedstatement.setLong(1, numsolicitud);
            resultset = preparedstatement.executeQuery();

            while (resultset.next()) {
                solicitud = new Solicitud(
					resultset.getInt("numsol"),
					resultset.getString("comentaris"),
					resultset.getDate("dataalta"),
					resultset.getDate("datafinalitzacio"),
					resultset.getString("client"),
                    resultset.getInt("numreparacio"),
                    resultSet.getBoolean("pendent"),
					resultSet.getBoolean("finalitzada"),
					resultset.getInt("asseguradora"),
					resultset.getString("numPoliza"),
					resultset.getInt("idtaller"));
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, preparedstatement, resultset);
        }

        return solicitud;
    }

    @Override
    public ArrayList<Solicitud> getSolicitudbyANY(String freetext) throws AppException {
        String            SQL         = "SELECT * from solicitud where (solicitud.*)::text ilike ?";
        ArrayList<Solicitud> listasolicitud = new ArrayList<Solicitud>();

        try {
            connection        = getConnection();
            preparedstatement = connection.prepareStatement(SQL);
            preparedstatement.setString(1, '%' + freetext + '%');
            resultset = preparedstatement.executeQuery();

            while (resultset.next()) {
				Solicitud solicitud = new Solicitud(
					resultset.getInt("numsol"),
					resultset.getString("comentaris"),
					resultset.getDate("dataalta"),
					resultset.getDate("datafinalitzacio"),
					resultset.getString("client"),
                    resultset.getInt("numreparacio"),
                    resultSet.getBoolean("pendent"),
					resultSet.getBoolean("finalitzada"),
					resultset.getInt("asseguradora"),
					resultset.getString("numPoliza"),
					resultset.getInt("idtaller"));
				listasolicitud.add(solicitud);
            }
        } catch (ClassNotFoundException ex) {
            throw new AppException(ex);
        } catch (IOException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            ConnectionFactory.freeResources(connection, preparedstatement, resultset);
        }

        return listasolicitud;
    }

    @Override
    public Boolean createSolicitud(Solicitud solicitud) throws AppException {
        Boolean succeded     = false;
        Boolean wasconnected = false;
        String  SQL          = "INSERT INTO solicitud "+
				"(comentaris,client,numreparacio,"+
				"asseguradora,numpoliza,idtaller) VALUES (?,?,?,?,?,?)";

        try {
            connection        = getConnection();
            wasconnected      = true;
            preparedstatement = connection.prepareStatement(SQL);
			preparedstatement.setString(1, solicitud.getComentaris());
			preparedstatement.setString(2, solicitud.getClient());
			preparedstatement.setInt(3, solicitud.getNumReparacio());
			preparedstatement.setInt(4, solicitud.getAsseguradora());
			preparedstatement.setString(5, solicitud.getNumPoliza());
			preparedstatement.setInt(6, solicitud.getIdtaller());

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
            ConnectionFactory.freeResources(connection, preparedstatement, resultset);
        }

        return succeded;
    }

    @Override
    public Boolean modifySolicitud(Solicitud solicitud) throws AppException {
        Integer rowsmodified;
        Boolean succeded     = false;
        Boolean wasconnected = false;
        String  SQL          = "UPDATE Solicitud SET comentaris = ?, "
				+ "client = ?, numreparacio = ?, pendent = ?, finalitzada = ?, "
                + "asseguradora = ?, numpoliza = ?, idtaller = ? where numsol = ?";

        try {
            connection        = getConnection();
            wasconnected      = true;
            preparedstatement = connection.prepareStatement(SQL);
			preparedstatement.setString(1, solicitud.getComentaris());
			preparedstatement.setString(2, solicitud.getClient());
			preparedstatement.setInt(3, solicitud.getNumReparacio());
			preparedstatement.setBoolean(4, solicitud.getPendent());
			preparedstatement.setBoolean(5, solicitud.getFinalitzada());
			preparedstatement.setInt(6, solicitud.getAsseguradora());
			preparedstatement.setString(7, solicitud.getNumPoliza());
			preparedstatement.setInt(8, solicitud.getIdtaller());

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
            ConnectionFactory.freeResources(connection, preparedstatement, resultset);
        }

        return succeded;
    }

    @Override
    public Boolean deleteSolicitud(Solicitud solicitud) throws AppException {
        Integer rowsmodified;
        Boolean succeded     = false;
        Boolean wasconnected = false;
        String  SQL          = "DELETE FROM Solicitud WHERE numsol = ?";

        try {
            connection        = getConnection();
            wasconnected      = true;
            preparedstatement = connection.prepareStatement(SQL);
			preparedstatement.setInt(1, solicitud.getNumSol());

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
            ConnectionFactory.freeResources(connection, preparedstatement, resultset);
        }

        return succeded;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
