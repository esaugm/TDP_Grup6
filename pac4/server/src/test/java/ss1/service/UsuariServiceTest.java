package ss1.service;

import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Usuari;
import ss1.service.impl.UsuariService;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 17:59
 */
public class UsuariServiceTest {
    
    public static void main(String[] args){
        UsuariService usuariService = new UsuariService();
        
        testFindUsuariByID(usuariService);
    }

    private static void testFindUsuariByID(UsuariService usuariService) {
        try {
            Usuari usuari = usuariService.findUsuariByID(1);
            System.out.println("Usuari1: " +usuari.getUsuari());
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }
    }


}
