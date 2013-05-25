
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.dao.impl;

//~--- non-JDK imports --------------------------------------------------------
import common.dao.impl.GenericDaoImpl;

import common.utils.ConnectionFactory;

import ss2.dao.ISolicitudDAO;

import ss2.entity.Solicitud;

import ss2.exception.AppException;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;

/**
 *
 * SolicitudDAO.java (UTF8)
 *
 * Uoc Primavera 2013, Grup06 Fecha: 2013.05.09 21:56:32
 *
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class SolicitudDAO extends GenericDaoImpl implements ISolicitudDAO {

    public SolicitudDAO() {
    }

    @Override
    public void checkAndInitDAO() throws AppException {
        checkSequence("solicitud_id_seq");
    }

    private void checkSequence(String sequenceName) throws AppException {
        String SQL1 = "SELECT * from " + sequenceName;
        String SQL2 = "CREATE SEQUENCE " + sequenceName + " start 10";
        Boolean wasconnected = false;
        Boolean sequenceexists = false;
        Integer result;
        Solicitud solicitud = new Solicitud();

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
    public ArrayList<Solicitud> getSolicitud() throws AppException {
        String SQL = "SELECT * from solicitud";
        ArrayList<Solicitud> listasolicitud = new ArrayList<Solicitud>();

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Solicitud solicitud = new Solicitud(
                    resultSet.getInt("numsol"),
                    resultSet.getString("comentaris"),
                    resultSet.getDate("dataalta"),
                    resultSet.getDate("datafinalitzacio"),
                    resultSet.getString("client"),
                    resultSet.getInt("numreparacio"),
                    resultSet.getBoolean("pendent"),
                    resultSet.getBoolean("finalitzada"),
                    resultSet.getInt("asseguradora"),
                    resultSet.getString("numPoliza"),
                    resultSet.getInt("idtaller"));
                listasolicitud.add(solicitud);
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

        return listasolicitud;
    }

    @Override
    public Solicitud getSolicitudbyNumSolicitud(Integer numsolicitud) throws AppException {
        String SQL = "SELECT * from solicitud where numsol = ?";
        Solicitud solicitud = new Solicitud();

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setLong(1, numsolicitud);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                solicitud = new Solicitud(
                    resultSet.getInt("numsol"),
                    resultSet.getString("comentaris"),
                    resultSet.getDate("dataalta"),
                    resultSet.getDate("datafinalitzacio"),
                    resultSet.getString("client"),
                    resultSet.getInt("numreparacio"),
                    resultSet.getBoolean("pendent"),
                    resultSet.getBoolean("finalitzada"),
                    resultSet.getInt("asseguradora"),
                    resultSet.getString("numPoliza"),
                    resultSet.getInt("idtaller"));
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

        return solicitud;
    }
    
    @Override
    public Solicitud getSolicitudbyNumReparacion(Integer orden) throws AppException {
        String SQL = "SELECT * from solicitud where numreparacio = ?";
        Solicitud solicitud = new Solicitud();

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setLong(1, orden);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                solicitud = new Solicitud(
                    resultSet.getInt("numsol"),
                    resultSet.getString("comentaris"),
                    resultSet.getDate("dataalta"),
                    resultSet.getDate("datafinalitzacio"),
                    resultSet.getString("client"),
                    resultSet.getInt("numreparacio"),
                    resultSet.getBoolean("pendent"),
                    resultSet.getBoolean("finalitzada"),
                    resultSet.getInt("asseguradora"),
                    resultSet.getString("numPoliza"),
                    resultSet.getInt("idtaller"));
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

        return solicitud;
    }

    @Override
    public ArrayList<Solicitud> getSolicitudbyANY(String freetext) throws AppException {
        String SQL = "SELECT * from solicitud where (solicitud.*)::text ilike ?";
        ArrayList<Solicitud> listasolicitud = new ArrayList<Solicitud>();

        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, '%' + freetext + '%');
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                Solicitud solicitud = new Solicitud(
                    resultSet.getInt("numsol"),
                    resultSet.getString("comentaris"),
                    resultSet.getDate("dataalta"),
                    resultSet.getDate("datafinalitzacio"),
                    resultSet.getString("client"),
                    resultSet.getInt("numreparacio"),
                    resultSet.getBoolean("pendent"),
                    resultSet.getBoolean("finalitzada"),
                    resultSet.getInt("asseguradora"),
                    resultSet.getString("numPoliza"),
                    resultSet.getInt("idtaller"));
                listasolicitud.add(solicitud);
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

        return listasolicitud;
    }

    @Override
    public Boolean createSolicitudRetBoolean(Solicitud solicitud) throws AppException {
        Boolean succeded = false;
        Boolean wasconnected = false;
        String SQL = "INSERT INTO solicitud "
            + "(comentaris,client,numreparacio,"
            + "asseguradora,numpoliza,idtaller) VALUES (?,?,?,?,?,?)";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, solicitud.getComentaris());
            ptmt.setString(2, solicitud.getClient());
            ptmt.setInt(3, solicitud.getNumReparacio());
            ptmt.setInt(4, solicitud.getAsseguradora());
            ptmt.setString(5, solicitud.getNumPoliza());
            ptmt.setInt(6, solicitud.getIdtaller());

            if (ptmt.executeUpdate() > 0) {
                succeded = true;
            } else {
                System.err.println(ptmt.getWarnings());
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
    public Integer createSolicitudRetNumsol(Solicitud solicitud) throws AppException {
        Boolean succeded = false;
        Boolean wasconnected = false;
        //Solicitud solicitud;
        Integer numsolicitud = new Integer(0);

        String SQL = "INSERT INTO solicitud "
            + "(comentaris,client,numreparacio,"
            + "asseguradora,numpoliza,idtaller) VALUES (?,?,?,?,?,?) returning numsol";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, solicitud.getComentaris());
            ptmt.setString(2, solicitud.getClient());
            ptmt.setInt(3, solicitud.getNumReparacio());
            ptmt.setInt(4, solicitud.getAsseguradora());
            ptmt.setString(5, solicitud.getNumPoliza());
            ptmt.setInt(6, solicitud.getIdtaller());

            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                numsolicitud = resultSet.getInt("numsol");
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

        return numsolicitud;
    }

    @Override
    public Solicitud createSolicitudRetSolicitud(Solicitud solicitud) throws AppException {
        Boolean succeded = false;
        Boolean wasconnected = false;
        //Solicitud solicitud;

        String SQL = "INSERT INTO solicitud "
            + "(comentaris,client,numreparacio,"
            + "asseguradora,numpoliza,idtaller) VALUES (?,?,?,?,?,?) returning *";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, solicitud.getComentaris());
            ptmt.setString(2, solicitud.getClient());
            ptmt.setInt(3, solicitud.getNumReparacio());
            ptmt.setInt(4, solicitud.getAsseguradora());
            ptmt.setString(5, solicitud.getNumPoliza());
            ptmt.setInt(6, solicitud.getIdtaller());

            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                solicitud = new Solicitud(
                    resultSet.getInt("numsol"),
                    resultSet.getString("comentaris"),
                    resultSet.getDate("dataalta"),
                    resultSet.getDate("datafinalitzacio"),
                    resultSet.getString("client"),
                    resultSet.getInt("numreparacio"),
                    resultSet.getBoolean("pendent"),
                    resultSet.getBoolean("finalitzada"),
                    resultSet.getInt("asseguradora"),
                    resultSet.getString("numPoliza"),
                    resultSet.getInt("idtaller"));
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

        return solicitud;
    }

    @Override
    public Boolean modifySolicitud(Solicitud solicitud) throws AppException {
        Integer rowsmodified;
        Boolean succeded = false;
        Boolean wasconnected = false;

        String SQL = "UPDATE Solicitud SET comentaris = ?, "
            + "client = ?, numreparacio = ?, pendent = ?, finalitzada = ?, "
            + "asseguradora = ?, numpoliza = ?, idtaller = ? where numsol = ?";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, solicitud.getComentaris());
            ptmt.setString(2, solicitud.getClient());
            ptmt.setInt(3, solicitud.getNumReparacio());
            ptmt.setBoolean(4, solicitud.getPendent());
            ptmt.setBoolean(5, solicitud.getFinalitzada());
            ptmt.setInt(6, solicitud.getAsseguradora());
            ptmt.setString(7, solicitud.getNumPoliza());
            ptmt.setInt(8, solicitud.getIdtaller());
            ptmt.setInt(9, solicitud.getNumSol());

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
    public Solicitud modifySolicitudretSolicitud(Solicitud solicitud) throws AppException {
        Integer rowsmodified;
        Boolean succeded = false;
        Boolean wasconnected = false;
        Solicitud newsolicitud = new Solicitud();

        String SQL = "UPDATE Solicitud SET comentaris = ?, "
            + "client = ?, numreparacio = ?, pendent = ?, finalitzada = ?, "
            + "asseguradora = ?, numpoliza = ?, idtaller = ? where numsol = ? returning *";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, solicitud.getComentaris());
            ptmt.setString(2, solicitud.getClient());
            ptmt.setInt(3, solicitud.getNumReparacio());
            ptmt.setBoolean(4, solicitud.getPendent());
            ptmt.setBoolean(5, solicitud.getFinalitzada());
            ptmt.setInt(6, solicitud.getAsseguradora());
            ptmt.setString(7, solicitud.getNumPoliza());
            ptmt.setInt(8, solicitud.getIdtaller());
            ptmt.setInt(9, solicitud.getNumSol());

            if (ptmt.executeUpdate() > 0) {
                solicitud = new Solicitud(
                    resultSet.getInt("numsol"),
                    resultSet.getString("comentaris"),
                    resultSet.getDate("dataalta"),
                    resultSet.getDate("datafinalitzacio"),
                    resultSet.getString("client"),
                    resultSet.getInt("numreparacio"),
                    resultSet.getBoolean("pendent"),
                    resultSet.getBoolean("finalitzada"),
                    resultSet.getInt("asseguradora"),
                    resultSet.getString("numPoliza"),
                    resultSet.getInt("idtaller"));
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

        return solicitud;
    }

    @Override
    public Boolean deleteSolicitud(Solicitud solicitud) throws AppException {
        Integer rowsmodified;
        Boolean succeded = false;
        Boolean wasconnected = false;
        String SQL = "DELETE FROM Solicitud WHERE numsol = ?";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, solicitud.getNumSol());

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
//~ Formatted by Jindent --- http://www.jindent.com

