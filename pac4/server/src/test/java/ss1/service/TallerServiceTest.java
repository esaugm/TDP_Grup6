package ss1.service;

import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Taller;
import ss1.service.impl.TallerService;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 18:08
 */
public class TallerServiceTest {
    
    public static void main(String[] args){
        TallerService tallerService = new TallerService();
        
        testFindTallerById(tallerService);
    }

    private static void testFindTallerById(TallerService tallerService) {
        try {
            for (int i=1;i<7;i++) {
                Taller taller = tallerService.findTallerById(i);
                if (taller!=null) {
                    System.out.println("Taller"+i+": " + taller.getAdreca());
                } else {
                    System.out.println("Taller con id " + i + " no existe");
                }
            }
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }
    }
}
