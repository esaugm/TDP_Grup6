package ss1.dao;

import common.utils.GestorBBDD;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Taller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 17:51
 */
public class TallerDAO {
    private GestorBBDD gdb;

    public TallerDAO() {
        this.gdb = new GestorBBDD();
    }
    
    public Taller findByPK(Integer pTallerId) throws ExceptionErrorDataBase {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Taller toReturn = null;
        try{
            conn = gdb.getConnection();
            ps = conn.prepareStatement("select id, cif, adreca, capacitat, capTaller, telefon, web, actiu, dataApertura, " +
                                       "dataModificacio, dataBaixa from taller where id = ?");
            ps.setLong(1,pTallerId);

            rs = ps.executeQuery();

            if (rs.next()){
                toReturn = new Taller();
                toReturn.setId(rs.getInt("id"));
                toReturn.setCif(rs.getString("cif"));
                toReturn.setAdreca(rs.getString("adreca"));
                toReturn.setCapacitat(rs.getInt("capacitat"));
                toReturn.setCapTaller(rs.getInt("capTaller"));
                toReturn.setTelefon(rs.getString("telefon"));
                toReturn.setWeb(rs.getString("web"));
                toReturn.setActiu(rs.getBoolean("actiu"));
                toReturn.setDataApertura(rs.getDate("dataApertura"));
                toReturn.setDataModificacio(rs.getDate("dataModificacio"));
                toReturn.setDataBaixa(rs.getDate("dataBaixa"));
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
            GestorBBDD.freeResources(conn,ps,rs);
        }
        return toReturn;
    }
}
