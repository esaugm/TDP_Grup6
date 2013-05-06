package common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 12:43
 * Clase de utilidades para BBDD: crea conexiones y libera recursos despues de usarlos.
 */
public class GestorBBDD {

    private final String propertiesFile = "conf/jdbc.properties";
    private final String driver = "org.postgresql.Driver";

    /**
     * Metode per crear una conexió a BD.
     * @return Connection conexió a BD
     * @throws SQLException Si hi ha un error al intentar crear la conexió
     * @throws IOException Si hi ha un error al intentar llegir el fitxer de properties
     * @throws ClassNotFoundException Si no troba la classe del driver de BD
     */
    public Connection getConnection() throws SQLException, IOException, ClassNotFoundException {

        Class.forName(driver);
        Properties prop = new Properties();
        prop.load(ClassLoader.getSystemClassLoader().getResourceAsStream(propertiesFile));
        String url = prop.getProperty("url");
        String user = prop.getProperty("username");
        String pwd = prop.getProperty("password");
        return DriverManager.getConnection(url, user, pwd);

    }

    /**
     * Métode util per tancar recursos de BD: tanca el recurs de cada tipus que se li passa per paràmetre.
     * Si no necessitem tancar recursos dels tres tipus, li passem el que volem tancar i la resta null
     * @param conn Connection, pot ser null
     * @param ps PreparedStatement, pot ser null
     * @param rs ResultSet, pot ser null
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
