package main.java.common.utils;


import common.utils.GestorBBDD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TDP PAC3
 * Esaú González, Juan Asperó
 * Date: 21/04/13
 * Time: 12:47
 * Tester para el componente GestorBBDD
 */
public class GestorBBDDTest {
    
    public static void main(String[] args){

        GestorBBDD gbd = new GestorBBDD();

        try {
            Connection conn = gbd.getConnection();
            System.out.println("¡CONEXIÓN A BD CREADA!");

            PreparedStatement ps = conn.prepareStatement("select * from usuari");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("Id marca: " + rs.getLong("id") + ". Nom: " + rs.getString("usuari") + ". Perfil: " + rs.getString("perfil") + ". Data alta: " + rs.getDate("dataAlta") + ".");
            }
            GestorBBDD.freeResources(conn,ps,rs);
            System.out.println("¡RECURSOS DE BD LIBERADOS!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
