package main.java.ss1.dao;

import ss1.dao.TallerDAO;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Taller;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 18:03
 */
public class TallerDAOTest {
    
    public static void main(String[] args){
        TallerDAO tallerDAO = new TallerDAO();
        
        testFindTallerById(tallerDAO);
    }

    private static void testFindTallerById(TallerDAO tallerDAO) {
        try {
            Taller taller = tallerDAO.findByPK(1);
            System.out.println("Taller1: " + taller.getAdreca());
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
