package common.dao.impl;

import common.dao.GenericDao;
import common.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 05/05/13
 * Time: 08:39
 * To change this template use File | Settings | File Templates.
 */
public class GenericDaoImpl implements GenericDao {

    protected Connection connection = null;
    protected PreparedStatement ptmt = null;
    protected ResultSet resultSet = null;

    public Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
}
