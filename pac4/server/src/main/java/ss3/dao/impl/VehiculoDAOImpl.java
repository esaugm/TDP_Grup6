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
import ss3.beans.Vehiculo;
import ss3.dao.VehiculoDAO;

/**
 * TDP Grup6
 * User: Fernando Gomez
 * Date: 9/05/13
 * Time: 15:40
 */
public class VehiculoDAOImpl extends GenericDaoImpl implements VehiculoDAO {

    public VehiculoDAOImpl(){
    }

    @Override
    public Vehiculo findByChasis(String pChasis) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vehiculo toReturn = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from vehicle where num_chasis = ?");
            ps.setString(1,pChasis);

            rs = ps.executeQuery();

            if (rs.next()){
                toReturn = new Vehiculo(
                    rs.getString("marca"),
                    rs.getString("tipus"),
                    rs.getString("num_chasis"),
                    rs.getString("model"),
                    rs.getString("matricula"),
                    rs.getString("color"),
                    rs.getDate("anyo"),
                    rs.getInt("numreparacio"));
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

     public ArrayList<Vehiculo> findByMarca(String pMarca) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from vehicle where marca = ?");
            ps.setString(1,pMarca);

            rs = ps.executeQuery();

            while (rs.next()){
                Vehiculo toReturn = new Vehiculo(
                    rs.getString("marca"),
                    rs.getString("tipus"),
                    rs.getString("num_chasis"),
                    rs.getString("model"),
                    rs.getString("matricula"),
                    rs.getString("color"),
                    rs.getDate("anyo"),
                    rs.getInt("numreparacio"));
                listaVehiculos.add(toReturn);
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
        return listaVehiculos;
    }

     public ArrayList<Vehiculo> findByANY(String freetext) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        try{
            conn = getConnection();
	    // String SQL = "SELECT * from client where (client.*)::text ilike ?";
            ps = conn.prepareStatement("select * from vehicle where (vehicle.*)::text ilike ?");
            //ps.setString(1,pMarca);
	    ps.setString(1, '%' + freetext + '%');

            rs = ps.executeQuery();

            while (rs.next()){
                Vehiculo toReturn = new Vehiculo(
                    rs.getString("marca"),
                    rs.getString("tipus"),
                    rs.getString("num_chasis"),
                    rs.getString("model"),
                    rs.getString("matricula"),
                    rs.getString("color"),
                    rs.getDate("anyo"),
                    rs.getInt("numreparacio"));
                listaVehiculos.add(toReturn);
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
        return listaVehiculos;
    }

     public Vehiculo findByMatricula(String pMatricula) throws ExceptionErrorDataBase {
         Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vehiculo toReturn = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from vehicle where matricula = ?");
            ps.setString(1,pMatricula);

            rs = ps.executeQuery();

            if (rs.next()){
                toReturn = new Vehiculo(
                    rs.getString("marca"),
                    rs.getString("tipus"),
                    rs.getString("num_chasis"),
                    rs.getString("model"),
                    rs.getString("matricula"),
                    rs.getString("color"),
                    rs.getDate("anyo"),
                    rs.getInt("numreparacio"));
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

     public ArrayList<Vehiculo> findByModelo(String pModelo) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from vehicle where model = ?");

            ps.setString(1,pModelo);

            rs = ps.executeQuery();

            while (rs.next()){
                Vehiculo toReturn = new Vehiculo(
                    rs.getString("marca"),
                    rs.getString("tipus"),
                    rs.getString("num_chasis"),
                    rs.getString("model"),
                    rs.getString("matricula"),
                    rs.getString("color"),
                    rs.getDate("anyo"),
                    rs.getInt("numreparacio"));
                listaVehiculos.add(toReturn);
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
        return listaVehiculos;
    }

    public Vehiculo findByOrden(Integer pOrden) throws ExceptionErrorDataBase {
         Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vehiculo toReturn = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from vehicle where numreparacio = ?");
            ps.setInt(1, pOrden);

            rs = ps.executeQuery();

            if (rs.next()){
                toReturn = new Vehiculo(
                    rs.getString("marca"),
                    rs.getString("tipus"),
                    rs.getString("num_chasis"),
                    rs.getString("model"),
                    rs.getString("matricula"),
                    rs.getString("color"),
                    rs.getDate("anyo"),
                    rs.getInt("numreparacio"));
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
