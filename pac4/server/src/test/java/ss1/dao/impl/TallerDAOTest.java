package ss1.dao.impl;

import junit.framework.TestCase;
import ss1.dao.ITallerDAO;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Taller;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 9/05/13
 * Time: 23:28
 */
public class TallerDAOTest extends TestCase {
    private ITallerDAO tallerDAO = new TallerDAO();
    public void testFindByPK() throws Exception {
        try {
            Taller taller = tallerDAO.findByPK(1);
            System.out.println("Taller1: " + taller.getAdreca());
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }
    }
}
