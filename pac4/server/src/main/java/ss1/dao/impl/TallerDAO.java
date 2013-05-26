package ss1.dao.impl;

import common.dao.impl.GenericDaoImpl;
import common.utils.ConnectionFactory;
import ss1.dao.ITallerDAO;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.entity.Taller;
import ss1.service.filter.FilterItems;
import ss1.service.filter.FilterTupla;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 17:51
 */
public class TallerDAO extends GenericDaoImpl implements ITallerDAO {

    @Override
    public List<Taller> findAll() throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Taller> toReturn = new ArrayList<Taller>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select id, nom, cif, adreca, capacitat, capTaller, telefon, web, actiu , dataApertura, dataModificacio, " +
                    "dataBaixa from taller");

            rs = ps.executeQuery();

            toReturn = extractTallerListFromResultSet(rs);


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

    private List<Taller> extractTallerListFromResultSet(ResultSet rs) throws SQLException {
        List<Taller> toReturn = new ArrayList<Taller>();
        while (rs.next()){
            toReturn.add(createTallerByResultSet(rs));
        }
        return toReturn;
    }

    private Taller createTallerByResultSet(ResultSet rs) throws SQLException {
        Taller taller = new Taller();
        taller.setId(rs.getInt("id"));
        taller.setCif(rs.getString("cif"));
        taller.setNom(rs.getString("nom"));
        taller.setAdreca(rs.getString("adreca"));
        taller.setCapacitat(rs.getInt("capacitat"));
        taller.setCapTaller(rs.getInt("capTaller"));
        taller.setTelefon(rs.getString("telefon"));
        taller.setWeb(rs.getString("web"));
        taller.setActiu(rs.getBoolean("actiu"));
        taller.setDataApertura(rs.getDate("dataApertura"));
        taller.setDataModificacio(rs.getDate("dataModificacio"));
        taller.setDataBaixa(rs.getDate("dataBaixa"));
        return taller;
    }

    @Override
    public void createTaller(Taller pTaller) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("insert into taller (cif, adreca, capacitat, capTaller, telefon, web, actiu, nom) " +
                    " values (?,?,?,?,?,?,?,?)");
            ps.setString(1, pTaller.getCif());
            ps.setString(2, pTaller.getAdreca());
            ps.setInt(3, pTaller.getCapacitat());
            ps.setInt(4, pTaller.getCapTaller());
            ps.setString(5, pTaller.getTelefon());
            ps.setString(6, pTaller.getWeb());
            ps.setBoolean(7, pTaller.isActiu());
            ps.setString(8, pTaller.getNom());

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
            ConnectionFactory.freeResources(conn, ps, null);
        }
    }

    @Override
    public void deleteTaller(Taller pTaller) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("delete from taller where id = ? ");

            ps.setInt(1, pTaller.getId());

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
    public void baixaTaller(Taller pTaller) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("update taller set actiu=? , dataBaixa=now() where id=?");

            ps.setBoolean(1, false);
            ps.setInt(2, pTaller.getId());

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
    public void modifyTaller(Taller pTaller) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("update taller set cif=?, adreca=?, capacitat=?, capTaller=?, telefon=?, " +
                    "web=?, actiu=?, nom=?,  dataModificacio=now() where id=?");

            ps.setString(1, pTaller.getCif());
            ps.setString(2, pTaller.getAdreca());
            ps.setInt(3, pTaller.getCapacitat());
            ps.setInt(4, pTaller.getCapTaller());
            ps.setString(5, pTaller.getTelefon());
            ps.setString(6, pTaller.getWeb());
            ps.setBoolean(7, pTaller.isActiu());
            ps.setString(8, pTaller.getNom());
            ps.setInt(9, pTaller.getId());

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
    public List<Taller> findTallerByFilter(FilterItems pTallerFilter) throws ExceptionTipoObjetoFiltroNoPermitido, ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Taller> toReturn = new ArrayList<Taller>();
        String query = "select id, nom, cif, adreca, capacitat, capTaller, telefon, web, actiu , dataApertura, dataModificacio, " +
                       "dataBaixa from taller ";
        try{
            conn = getConnection();
            Set<String> atributos =  pTallerFilter.getAllAtributeNames();
            ArrayList<FilterTupla> filterTuplas = new ArrayList<FilterTupla>();
            int i = 0;
            if (!atributos.isEmpty()) query = query + "where ";
            for (String atributo : atributos) {
                if(pTallerFilter.isFilteringByAttribute(atributo)){
                    i++;
                    query = query + atributo + "=? and ";
                    filterTuplas.add(new FilterTupla(i, pTallerFilter.getFilterValueForAttribute(atributo)));
                }

            }
            if (i>0) query = query.substring(0, query.length()-4);
            ps = conn.prepareStatement(query);
            for (FilterTupla filterTupla : filterTuplas) {
                if (filterTupla.getFieldToFilter() instanceof String) {
                    ps.setString(filterTupla.getQueryPosition(),(String)filterTupla.getFieldToFilter());
                } else if ((filterTupla.getFieldToFilter() instanceof Boolean)){
                    ps.setBoolean(filterTupla.getQueryPosition(), (Boolean)filterTupla.getFieldToFilter());
                } else if (filterTupla.getFieldToFilter() instanceof Integer){
                    ps.setInt(filterTupla.getQueryPosition(), (Integer)filterTupla.getFieldToFilter());
                }  else {
                    throw new ExceptionTipoObjetoFiltroNoPermitido("Error tipo de objeto " + filterTupla.getFieldToFilter() + " no permitido para este filtro.");
                }

            }


            rs = ps.executeQuery();

            while (rs.next()){
                toReturn.add(createTallerByResultSet(rs));
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
    public Taller findByPK(Integer pTallerId) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Taller toReturn = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement("select id, nom, cif, adreca, capacitat, capTaller, telefon, web, actiu, dataApertura, " +
                                       "dataModificacio, dataBaixa from taller where id = ?");
            ps.setLong(1,pTallerId);

            rs = ps.executeQuery();

            if (rs.next()){
                toReturn = createTallerByResultSet(rs);
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
            ConnectionFactory.freeResources(conn, ps, rs);
        }
        return toReturn;
    }
}
