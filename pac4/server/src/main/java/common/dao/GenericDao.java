package common.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 05/05/13
 * Time: 08:38
 * To change this template use File | Settings | File Templates.
 */
public interface GenericDao {

    public Connection getConnection() throws SQLException;
}
