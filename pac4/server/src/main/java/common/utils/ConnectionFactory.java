package common.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {
    private final String propertiesFile = "conf/jdbc.properties";
    private final String driverClassName = "org.postgresql.Driver";
    private final String connectionUrl;
    private final String dbUser;
    private final String dbPwd;

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() throws IOException, ClassNotFoundException {
        Class.forName(driverClassName);
        Properties prop = new Properties();
        prop.load(ClassLoader.getSystemClassLoader().getResourceAsStream(propertiesFile));
        connectionUrl = prop.getProperty("url");
        dbUser = prop.getProperty("username");
        dbPwd = prop.getProperty("password");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
    }

    public static ConnectionFactory getInstance() throws ClassNotFoundException, IOException {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

    /**
     * Método util para cerrar recursos de BD: cierra el recurso de cada tipo que se le pasa por parámetro
     * Si no se necesita cerrar recursos de los tres tipos, se le pasa el que se quiere cerrar y los demas null
     * @param conn Connection, puede ser null
     * @param ps PreparedStatement, puede ser null
     * @param rs ResultSet, puede ser null
     */
    public static void freeResources(Connection conn, PreparedStatement ps, ResultSet rs){

        if (rs!=null ){
            try {
                if (!rs.isClosed()) rs.close();
            } catch (SQLException e) {
                System.out.println("Exception trying to close ResultSet");
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                if (!ps.isClosed()) ps.close();
            } catch (SQLException e) {
                System.out.println("Exception trying to close PreparedStatement");
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                if (!conn.isClosed()) conn.close();
            } catch (SQLException e) {
                System.out.println("Exception trying to close Connection");
                e.printStackTrace();
            }
        }
    }
}
