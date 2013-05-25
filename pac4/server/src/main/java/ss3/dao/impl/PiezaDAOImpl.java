package ss3.dao.impl;

import common.dao.impl.GenericDaoImpl;
import common.utils.ConnectionFactory;
import ss1.dao.exception.ExceptionErrorDataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ss2.exception.AppException;
import ss3.beans.Pieza;
import ss3.dao.PiezaDAO;

/**
 * TDP Grup6
 * User: Fernando Gomez
 * Date: 9/05/13
 * Time: 15:40
 */
public class PiezaDAOImpl extends GenericDaoImpl implements PiezaDAO {

    public PiezaDAOImpl(){
    }

    @Override
    public void checkAndInitDAO() throws AppException {
        checkSequence("peca_id_seq");
    }

    private void checkSequence(String sequenceName) throws AppException {
        String SQL1 = "SELECT * from " + sequenceName;
        String SQL2 = "CREATE SEQUENCE " + sequenceName + " start 4";
        Boolean wasconnected = false;
        Boolean sequenceexists = false;
        Integer result;
        Pieza pieza = new Pieza();

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

    public Pieza findByCodiPieza(Integer pCodiPieza) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pieza toReturn = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from peca where codipeca = ?");
            ps.setInt(1,pCodiPieza);

            rs = ps.executeQuery();

            if (rs.next()){
                toReturn = new Pieza(
                    rs.getInt("codipeca"),
                    rs.getString("descripcio"),
                    rs.getFloat("pvp"),
                    rs.getFloat("pvd"),
                    rs.getString("marca"),
                    rs.getString("model"),
                    rs.getInt("idProveidor"));
                
            }

        } catch (ClassNotFoundException e) {
            //todo FERNANDO: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            //todo FERNANDO: log exception
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            //todo FERNANDO: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(conn, ps, rs);
        }
        return toReturn;
    }
    
    public ArrayList<Pieza> findPiezas() throws ExceptionErrorDataBase{
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Pieza> listaPieza = new ArrayList<Pieza>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from peca");
            
            rs = ps.executeQuery();

            while (rs.next()){
                Pieza toReturn = new Pieza(
                    rs.getInt("codipeca"),
                    rs.getString("descripcio"),
                    rs.getFloat("pvp"),
                    rs.getFloat("pvd"),
                    rs.getString("marca"),
                    rs.getString("model"),
                    rs.getInt("idProveidor"));
                listaPieza.add(toReturn);
            }

        } catch (ClassNotFoundException e) {
            //todo FERNANDO: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            //todo FERNANDO: log exception
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            //todo FERNANDO: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(conn, ps, rs);
        }
        return listaPieza;
    }
    
     public ArrayList<Pieza> findByDescripcion(String pDescripcion) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Pieza> listaPieza = new ArrayList<Pieza>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from peca where descripcion like ?");
            ps.setString(1,"%"+pDescripcion+"%");
            
            rs = ps.executeQuery();

            while (rs.next()){
                Pieza toReturn = new Pieza(
                    rs.getInt("codipeca"),
                    rs.getString("descripcio"),
                    rs.getFloat("pvp"),
                    rs.getFloat("pvd"),
                    rs.getString("marca"),
                    rs.getString("model"),
                    rs.getInt("idProveidor"));
                listaPieza.add(toReturn);
            }

        } catch (ClassNotFoundException e) {
            //todo FERNANDO: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            //todo FERNANDO: log exception
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            //todo FERNANDO: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(conn, ps, rs);
        }
        return listaPieza;
    }
    
    public Pieza findByOrden(Integer pOrden) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pieza toReturn = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement( "SELECT *\n" +
                                        "FROM reparacio\n" +
                                        "JOIN solicitud ON reparacio.ordrereparacio = solicitud.numreparacio\n" +
                                        "JOIN client   ON solicitud.client = client.nif\n" +
                                        "JOIN usuari ON reparacio.idmecanic = usuari.id\n" +
                                        "JOIN vehicle ON reparacio.ordrereparacio = vehicle.numreparacio\n" +
                                        "JOIN comanda ON reparacio.numcom = comanda.numcom\n" +
                                        "JOIN peca ON comanda.codipeca = peca.codipeca\n" +
                                        "WHERE reparacio.ordrereparacio = ?\n");
            ps.setInt(1,pOrden);
            
            rs = ps.executeQuery();

            if (rs.next()){
                 toReturn = new Pieza(
                    rs.getInt("codipeca"),
                    rs.getString("descripcio"),
                    rs.getFloat("pvp"),
                    rs.getFloat("pvd"),
                    rs.getString("marca"),
                    rs.getString("model"),
                    rs.getInt("idProveidor"));
            }

        } catch (ClassNotFoundException e) {
            //todo FERNANDO: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            //todo FERNANDO: log exception
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            //todo FERNANDO: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(conn, ps, rs);
        }
        return toReturn;
    }
}
