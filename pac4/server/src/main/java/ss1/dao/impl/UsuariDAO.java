package ss1.dao.impl;

import common.dao.impl.GenericDaoImpl;
import common.entity.PerfilUsuari;
import common.utils.ConnectionFactory;
import ss1.dao.IUsuariDAO;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Usuari;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 15:53
 */
public class UsuariDAO extends GenericDaoImpl implements IUsuariDAO {

    @Override
    public List<Usuari> findAll(){
        //todo ESAU: implementar
        return null;
    }
    
    @Override
    public Usuari findByPK(Integer pUsuariId) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuari toReturn = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select id, taller, usuari, perfil, contrasenya, actiu, dataAlta, dataModificacio, " +
                                       "dataBaixa, reparacionsassignades from usuari where id = ?");
            ps.setLong(1,pUsuariId);

            rs = ps.executeQuery();

            if (rs.next()){
                toReturn = new Usuari();
                toReturn.setId(rs.getInt("id"));
                toReturn.setTaller(rs.getInt("taller"));
                toReturn.setUsuari(rs.getString("usuari"));
                toReturn.setPerfil(PerfilUsuari.getPerfilUsuari(rs.getString("perfil")));
                toReturn.setContrasenya(rs.getString("contrasenya"));
                toReturn.setActiu(rs.getBoolean("actiu"));
                toReturn.setDataAlta(rs.getDate("dataAlta"));
                toReturn.setDataModificacio(rs.getDate("dataModificacio"));
                toReturn.setDataBaixa(rs.getDate("dataBaixa"));
                toReturn.setReparacionsAssignades(rs.getInt("reparacionsassignades"));
            }

        } catch (ClassNotFoundException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(conn,ps,rs);
        }
        return toReturn;
    }
    
    @Override
    public Usuari findByUsuariLogin(String pUsuariLogin) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuari toReturn = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select id, taller, usuari, perfil, contrasenya, actiu, dataAlta, dataModificacio, " +
                    "dataBaixa, reparacionsassignades from usuari where usuari = ?");
            ps.setString(1, pUsuariLogin);

            rs = ps.executeQuery();

            if (rs.next()){
                toReturn = new Usuari();
                toReturn.setId(rs.getInt("id"));
                toReturn.setTaller(rs.getInt("taller"));
                toReturn.setUsuari(rs.getString("usuari"));
                toReturn.setPerfil(PerfilUsuari.getPerfilUsuari(rs.getString("perfil")));
                toReturn.setContrasenya(rs.getString("contrasenya"));
                toReturn.setActiu(rs.getBoolean("actiu"));
                toReturn.setDataAlta(rs.getDate("dataAlta"));
                toReturn.setDataModificacio(rs.getDate("dataModificacio"));
                toReturn.setDataBaixa(rs.getDate("dataBaixa"));
                toReturn.setReparacionsAssignades(rs.getInt("reparacionsassignades"));
            }

        } catch (ClassNotFoundException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(conn,ps,rs);
        }
        return toReturn;
    }

    @Override
    public void createUsuari(Usuari pUsuari) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("insert into usuari (taller, usuari, perfil, contrasenya, actiu, dataAlta) " +
                                       " values (?,?,?,?,true, now())");
            ps.setInt(1, pUsuari.getTaller());
            ps.setString(2, pUsuari.getUsuari());
            ps.setString(3, pUsuari.getPerfil().toString());
            ps.setString(4, pUsuari.getContrasenya());

            ps.executeUpdate();



        } catch (ClassNotFoundException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            //todo ESAU: log exception
            if (e.getLocalizedMessage().contains("ck_usuariunic")){
                System.out.println("ERROR: Usuari ya existent!");
                //todo ESAU: throw new ExceptionUsuariExisteix
            }
            e.getClass().toString();
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(conn, ps, null);
        }
    }

    @Override
    public void deleteUsuari(Usuari pUsuari) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("delete from usuari where id = ? ");

            ps.setInt(1, pUsuari.getId());

            ps.executeUpdate();



        } catch (ClassNotFoundException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(conn,ps,null);
        }
    }

    @Override
    public void modifyUsuari(Usuari pUsuari) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("update usuari set taller=?, usuari=?, perfil=?, contrasenya=?, actiu=?, " +
                                       "dataModificacio=now(), reparacionsassignades=? where id=?");

            ps.setInt(1, pUsuari.getTaller());
            ps.setString(2, pUsuari.getUsuari());
            ps.setString(3, pUsuari.getPerfil().toString());
            ps.setString(4, pUsuari.getContrasenya());
            ps.setBoolean(5, pUsuari.isActiu());
            ps.setInt(6, pUsuari.getReparacionsAssignades());
            ps.setInt(7, pUsuari.getId());

            ps.executeUpdate();



        } catch (ClassNotFoundException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } catch (SQLException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error de sql", e);
        } catch (IOException e) {
            //todo ESAU: log exception
            throw new ExceptionErrorDataBase("Error conectando a BD", e);
        } finally {
            ConnectionFactory.freeResources(conn,ps,null);
        }
    }
}
