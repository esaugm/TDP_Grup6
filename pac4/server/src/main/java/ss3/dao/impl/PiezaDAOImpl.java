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
import java.text.SimpleDateFormat;
import ss2.entity.StockPeca;
import ss2.exception.AppException;
import ss3.beans.Pieza;
import ss3.beans.Reparacion;
import ss3.dao.PiezaDAO;

/**
 * TDP Grup6
 * User: Fernando Gomez
 * Date: 9/05/13
 * Time: 15:40
 */
public class PiezaDAOImpl extends GenericDaoImpl implements PiezaDAO {

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
                    rs.getInt("codiPieza"),
                    rs.getString("descripcion"),
                    rs.getFloat("pvp"),
                    rs.getFloat("pvd"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("idProveedor"));
                
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
                    rs.getInt("codiPieza"),
                    rs.getString("descripcion"),
                    rs.getFloat("pvp"),
                    rs.getFloat("pvd"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("idProveedor"));
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
     
     public ArrayList<Reparacion> findByDataInici(String pDataInici) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from reparacio where datainici = ?");
            java.sql.Date fechaDate2 = null;
            try {
                  SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                  fechaDate2 = new java.sql.Date(sdf.parse(pDataInici).getTime());
            } catch (Exception ex) {
                  System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
            }
            ps.setDate(1,fechaDate2);

            rs = ps.executeQuery();

            while (rs.next()){
                Reparacion toReturn = new Reparacion(
                    rs.getInt("ordrereparacio"),
                    rs.getInt("idcaptaller"),
                    rs.getBoolean("acceptada"),
                    rs.getInt("idmecanic"),
                    rs.getBoolean("assignada"),
                    rs.getInt("comptador"),
                    rs.getString("observacions"),
                    rs.getInt("numcom"),
                    rs.getDate("dataassignacio"),
                    rs.getDate("datainici"),
                    rs.getDate("datafi"));
                listaReparaciones.add(toReturn);
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
        return listaReparaciones;
    }
     
     public ArrayList<Reparacion> findByDataFi(String pDataFi) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from reparacio where datafi = ?");
            java.sql.Date fechaDate3 = null;
            try {
                  SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                  fechaDate3 = new java.sql.Date(sdf.parse(pDataFi).getTime());
            } catch (Exception ex) {
                  System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
            }
            ps.setDate(1,fechaDate3);

            rs = ps.executeQuery();

            while (rs.next()){
                Reparacion toReturn = new Reparacion(
                    rs.getInt("ordrereparacio"),
                    rs.getInt("idcaptaller"),
                    rs.getBoolean("acceptada"),
                    rs.getInt("idmecanic"),
                    rs.getBoolean("assignada"),
                    rs.getInt("comptador"),
                    rs.getString("observacions"),
                    rs.getInt("numcom"),
                    rs.getDate("dataassignacio"),
                    rs.getDate("datainici"),
                    rs.getDate("datafi"));
                listaReparaciones.add(toReturn);
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
        return listaReparaciones;
    }
     
     public ArrayList<Reparacion> findByAceptada(Boolean aceptada) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from reparacio where acceptada = ? order by ordrereparacio");
            ps.setBoolean(1,aceptada);

            rs = ps.executeQuery();

            while (rs.next()){
                Reparacion toReturn = new Reparacion(
                    rs.getInt("ordrereparacio"),
                    rs.getInt("idcaptaller"),
                    rs.getBoolean("acceptada"),
                    rs.getInt("idmecanic"),
                    rs.getBoolean("assignada"),
                    rs.getInt("comptador"),
                    rs.getString("observacions"),
                    rs.getInt("numcom"),
                    rs.getDate("dataassignacio"),
                    rs.getDate("datainici"),
                    rs.getDate("datafi"));
                listaReparaciones.add(toReturn);
            }

        } catch (ClassNotFoundException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(conn, ps, rs);
        }
        return listaReparaciones;
    }
     
     public ArrayList<Reparacion> findByAsignada(Boolean asignada) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from reparacio where assignada = ? order by ordrereparacio");
            ps.setBoolean(1,asignada);

            rs = ps.executeQuery();

            while (rs.next()){
                Reparacion toReturn = new Reparacion(
                    rs.getInt("ordrereparacio"),
                    rs.getInt("idcaptaller"),
                    rs.getBoolean("acceptada"),
                    rs.getInt("idmecanic"),
                    rs.getBoolean("assignada"),
                    rs.getInt("comptador"),
                    rs.getString("observacions"),
                    rs.getInt("numcom"),
                    rs.getDate("dataassignacio"),
                    rs.getDate("datainici"),
                    rs.getDate("datafi"));
                listaReparaciones.add(toReturn);
            }

        } catch (ClassNotFoundException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(conn, ps, rs);
        }
        return listaReparaciones;
    }
}
