package ss4.dao.impl;

import common.dao.impl.GenericDaoImpl;
import ss4.dao.EjemploDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 6/05/13
 * Time: 9:22
 * To change this template use File | Settings | File Templates.
 */
public class EjemploDaoImpl extends GenericDaoImpl implements EjemploDao {
    @Override
    public List<?> findAll() {
        List list = null;
        try {

            list = new ArrayList();
            String queryString = "SELECT * FROM marca_cotxe ";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                // llenamos datos del results a beans para devolver la lista
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return list;
    }
}
