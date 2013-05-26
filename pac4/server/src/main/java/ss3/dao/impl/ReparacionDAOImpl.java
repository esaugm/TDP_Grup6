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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ss2.exception.AppException;
import ss3.beans.Reparacion;
import ss3.dao.ReparacionDAO;

/**
 * TDP Grup6
 * User: Fernando Gomez
 * Date: 9/05/13
 * Time: 15:40
 */
public class ReparacionDAOImpl extends GenericDaoImpl implements ReparacionDAO {

    public ReparacionDAOImpl(){
    }
    
    @Override
    public void checkAndInitDAO() throws AppException {
        checkSequence("reparacio_id_seq");
    }

    private void checkSequence(String sequenceName) throws AppException {
        String SQL1 = "SELECT * from " + sequenceName;
        String SQL2 = "CREATE SEQUENCE " + sequenceName + " start 4";
        Boolean wasconnected = false;
        Boolean sequenceexists = false;
        Integer result;
        Reparacion reparacion = new Reparacion();

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
    
    public ArrayList<Reparacion> findAll() throws ExceptionErrorDataBase{
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from reparacio order by ordrereparacio");
                  
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
    
     public ArrayList<Reparacion> findByDataAssignacio(String pDataAssignacio) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from reparacio where dataassignacio = ?");
            java.sql.Date fechaDate = null;
            try {
                  SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                  fechaDate = new java.sql.Date(sdf.parse(pDataAssignacio).getTime());
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
    
     public ArrayList<Reparacion> findByIdMecanico(Integer idMecanico) throws ExceptionErrorDataBase{
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select * from reparacio where idmecanic = ? order by ordrereparacio");
            ps.setInt(1,idMecanico);

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
     
     public Boolean asignaAJefeTaller(Integer orden, Integer idJefeTaller) throws ExceptionErrorDataBase{
        Boolean succeded = false;
        Boolean wasconnected = false;

        String SQL = "UPDATE reparacio SET idcaptaller = ? WHERE ordrereparacio = ? ";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, idJefeTaller);
            ptmt.setInt(2, orden);

            if (ptmt.executeUpdate() > 0) {
                succeded = true;
            }
         } catch (ClassNotFoundException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return succeded;
     }
     
     public Boolean aceptaReparacion(Integer orden) throws ExceptionErrorDataBase{
        Boolean succeded = false;
        Boolean wasconnected = false;

        String SQL = "UPDATE reparacio SET acceptada = true WHERE ordrereparacio = ?";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, orden);

            if (ptmt.executeUpdate() > 0) {
                succeded = true;
            }
         } catch (ClassNotFoundException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return succeded;
     }
     
      public Boolean anotaObservacion(Integer orden, String observaciones) throws ExceptionErrorDataBase{
        Boolean succeded = false;
        Boolean wasconnected = false;

        String SQL = "UPDATE reparacio SET observacions = ? WHERE ordrereparacio = ?";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setString(1, observaciones);
            ptmt.setInt(2, orden);

            if (ptmt.executeUpdate() > 0) {
                succeded = true;
            }
         } catch (ClassNotFoundException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return succeded;
      }
      
      public Boolean asignaAMecanico(Integer orden, Integer idMecanico) throws ExceptionErrorDataBase{
           
        Boolean succeded = false;
        Boolean wasconnected = false;

        String SQL = "UPDATE reparacio SET idmecanic = ? WHERE ordrereparacio = ? ";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, idMecanico);
            ptmt.setInt(2, orden);

            if (ptmt.executeUpdate() > 0) {
                succeded = true;
            }
         } catch (ClassNotFoundException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return succeded;
      }
      
      public Boolean desasignaMecanico(Integer orden, Integer idMecanico) throws ExceptionErrorDataBase{
           
        Boolean succeded = false;
        Boolean wasconnected = false;

        String SQL = "UPDATE reparacio SET idmecanic = ? WHERE ordrereparacio = ? and idmecanic = ?";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, idMecanico);
            ptmt.setInt(2, orden);

            if (ptmt.executeUpdate() > 0) {
                succeded = true;
            }
         } catch (ClassNotFoundException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);
        }

        return succeded;
      }
      
      public Boolean createReparacion(Reparacion rep) throws ExceptionErrorDataBase, AppException{
          Boolean succeded = false;
        Boolean wasconnected = false;
        String SQL = "INSERT INTO reparacio "
            + "(idcaptaller,acceptada,idmecanic,assignada,comptador,observacions,numcom) "
            + "VALUES (?,?,?,?,?,?,?)";

        try {
            connection = getConnection();
            wasconnected = true;
            ptmt = connection.prepareStatement(SQL);
            ptmt.setInt(1, rep.getIdJefeTaller());
            ptmt.setBoolean(2, rep.isAceptada());
            ptmt.setInt(3, rep.getIdMecanico());
            ptmt.setBoolean(4, rep.isAsignada());
            ptmt.setInt(5, rep.getContador());
            ptmt.setString(6, rep.getObservaciones());
            ptmt.setInt(7,rep.getNumcom());
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
      
      public ArrayList<Reparacion> findReparacionesByTerms(Map values) throws ExceptionErrorDataBase{
        ArrayList<Reparacion> list = new ArrayList<Reparacion>();
        Boolean isFirst = new Boolean(true);

        try {

            String queryString = "SELECT " +
                    " reparacio.ordrereparacio" +
                    " FROM reparacio  " +
                    " JOIN solicitud ON reparacio.ordrereparacio = solicitud.numreparacio" +
                    " JOIN client   ON solicitud.client = client.nif " +
                    " JOIN usuari ON reparacio.idmecanic = usuari.id" +
                    " JOIN vehicle ON reparacio.ordrereparacio = vehicle.numreparacio";

            if (values.size() > 0) {
                queryString += " WHERE ";
            }

            Iterator itr = values.entrySet().iterator();


            while (itr.hasNext()) {
                Map.Entry e = (Map.Entry) itr.next();

               if (e.getKey().equals("nomCliente")) {
                    if (isFirst) {
                        queryString += "  LOWER(client.nom) like '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                        isFirst = false;

                    } else {
                        queryString += " AND LOWER(client.nom) like '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                    }
               }else if (e.getKey().equals("apeCliente")) {
                    if (isFirst) {
                        queryString += "  LOWER(client.cognoms) like '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                        isFirst = false;

                    } else {
                        queryString += " AND LOWER(client.cognoms) like '%" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                    }
               }else if (e.getKey().equals("desde")) {
                    if (isFirst) {
                        queryString += "  solicitud.dataalta >= '" + String.valueOf(e.getValue()).toLowerCase() + "'";
                        isFirst = false;

                    } else {
                        queryString += " AND solicitud.dataalta >= '" + String.valueOf(e.getValue()).toLowerCase() + "'";
                    }
               }else if (e.getKey().equals("hasta")) {
                    if (isFirst) {
                        queryString += "  solicitud.dataalta <= '" + String.valueOf(e.getValue()).toLowerCase() + "'";
                        isFirst = false;

                    } else {
                        queryString += " AND solicitud.dataalta <= '" + String.valueOf(e.getValue()).toLowerCase() + "'";
                    }
               }else if (e.getKey().equals("orden")) {
                    if (isFirst) {
                        queryString += "  reparacio.ordrereparacio = '" + String.valueOf(e.getValue()).toLowerCase() + "'";
                        isFirst = false;

                    } else {
                        queryString += " AND reparacio.ordrereparacio = '" + String.valueOf(e.getValue()).toLowerCase() + "'";
                    }
               }else if (e.getKey().equals("matricula")) {
                    if (isFirst) {
                        queryString += "  LOWER(vehicle.matricula) like '" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                        isFirst = false;

                    } else {
                        queryString += " AND LOWER(vehicle.matricula) like '" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                    }
               }else if (e.getKey().equals("marca")) {
                    if (isFirst) {
                        queryString += "  LOWER(vehicle.marca) like '" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                        isFirst = false;

                    } else {
                        queryString += " AND LOWER(vehicle.marca) like '" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                    }
               }else if (e.getKey().equals("modelo")) {
                    if (isFirst) {
                        queryString += "  LOWER(vehicle.model) like '" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                        isFirst = false;

                    } else {
                        queryString += " AND LOWER(vehicle.model) like '" + String.valueOf(e.getValue()).toLowerCase() + "%'";
                    }
               }
               
                    
            }
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next())
                list.add(findByPK(resultSet.getInt(1)));
                     
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.freeResources(connection, ptmt, resultSet);


        }

        return list;
      }
}
