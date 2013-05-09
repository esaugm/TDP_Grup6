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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import ss3.beans.Reparacion;
import ss3.dao.ReparacionDAO;

/**
 * TDP Grup6
 * User: Fernando Gomez
 * Date: 9/05/13
 * Time: 15:40
 */
public class ReparacionDAOImpl extends GenericDaoImpl implements ReparacionDAO {

    @Override
    public Reparacion findByPK(Integer pOrdenReparacion) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reparacion toReturn = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from reparacio where ordrereparacio = ?");
            ps.setLong(1,pOrdenReparacion);

            rs = ps.executeQuery();

            if (rs.next()){
                toReturn = new Reparacion(
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
    
     public ArrayList<Reparacion> findByDataAssignacio(String pDataAssignacio) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from reparacio where dataassignacio = ?");
            String fecha = "2013-03-01";
            java.sql.Date fechaDate = null;
            try {
                  SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                  fechaDate = new java.sql.Date(sdf.parse(fecha).getTime());
            } catch (Exception ex) {
                  System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
            }
            ps.setDate(1,fechaDate);
            
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
     
     public ArrayList<Reparacion> findByDataInici(String pDataInici) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from reparacio where datainici = ?");
            ps.setString(1,pDataInici);

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
            ps.setString(1,pDataFi);

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
}