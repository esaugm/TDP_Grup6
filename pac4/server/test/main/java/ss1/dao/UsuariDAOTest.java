package main.java.ss1.dao;

import common.entity.PerfilUsuari;
import ss1.dao.UsuariDAO;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Usuari;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 17:27
 */
public class UsuariDAOTest {
    public static void main(String[] args){
        UsuariDAO usuariDAO = new UsuariDAO();

        testFindUsuariByPK(usuariDAO);
        
        testFindUsuariByUsuariLogin(usuariDAO);
        
        testAltaUsuari(usuariDAO);
        
        testBaixaUsuari(usuariDAO);
        
        testModificacioUsuari(usuariDAO);


    }

    private static void testAltaUsuari(UsuariDAO usuariDAO) {
        Usuari usuariNou = new Usuari();
        usuariNou.setTaller(1);
        usuariNou.setUsuari("test1");
        usuariNou.setPerfil(PerfilUsuari.ADMINISTRADOR);
        usuariNou.setContrasenya("12345");
        //usuariNou.setActiu(true); TODO by default
        //usuariNou.setDataAlta(); TODO by default
        //usuariNou.setReparacionsAssignades(0); TODO by default
        
        Usuari usuariNou2 = new Usuari();
        usuariNou2.setTaller(2);
        usuariNou2.setUsuari("test2");
        usuariNou2.setPerfil(PerfilUsuari.CAPTALLER);
        usuariNou2.setContrasenya("67890");

        try {
            usuariDAO.createUsuari(usuariNou);
            usuariDAO.createUsuari(usuariNou2);
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }
        System.out.println("Usuari creat correctament!");
    }

    private static void testBaixaUsuari(UsuariDAO usuariDAO) {

        try {
            Usuari usuariPerBorrar = usuariDAO.findByUsuariLogin("test1");
            usuariDAO.deleteUsuari(usuariPerBorrar);
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }
        System.out.println("Usuari esborrat correctament!");
    }

    private static void testModificacioUsuari(UsuariDAO usuariDAO) {
        Usuari usuariPerModificar = null;
        try {
            usuariPerModificar = usuariDAO.findByUsuariLogin("test2");
            
            usuariPerModificar.setUsuari("testModif");
            usuariPerModificar.setContrasenya("09876");
            
            usuariDAO.modifyUsuari(usuariPerModificar);
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }

        System.out.println("USuari modificat correctament!");
    }

    private static void testFindUsuariByUsuariLogin(UsuariDAO usuariDAO) {
        try {
            Usuari usuari = usuariDAO.findByUsuariLogin("pepelui1");
            System.out.println("Usuari con login pepelui1, password " + usuari.getContrasenya());
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }
    }

    private static void testFindUsuariByPK(UsuariDAO usuariDAO){
        try {
            Usuari usuari = usuariDAO.findByPK(1);
            System.out.println("Usuari1: " +usuari.getUsuari());

            usuari = usuariDAO.findByPK(2);
            System.out.println("Usuari2: " +usuari.getUsuari());

            usuari = usuariDAO.findByPK(3);
            System.out.println("Usuari3: " +usuari.getUsuari());

            usuari = usuariDAO.findByPK(4);
            System.out.println("Usuari4: " +usuari.getUsuari());
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }

    }
}
