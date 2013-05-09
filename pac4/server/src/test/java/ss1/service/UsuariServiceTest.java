package ss1.service;

import common.entity.PerfilUsuari;
import ss1.dao.exception.ExceptionContrasenyaIncorrecta;
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
        
        testChangePassword(usuariService);
    }

    private static void testChangePassword(UsuariService usuariService) {
        Usuari usuariNuevo = new Usuari();
        usuariNuevo.setPerfil(PerfilUsuari.ADMINISTRATIU);
        usuariNuevo.setContrasenya("blahblah");
        usuariNuevo.setTaller(3);
        usuariNuevo.setUsuari("usuariTest");
        try {
            System.out.println("Creando usuario nuevo: usuariTest");
            usuariService.altaUsuari(usuariNuevo);
            
            Usuari usuariCambio = usuariService.findUsuariByUsuariLogin("usuariTest");
            System.out.println("Cambiando password correcto");
            ChangePasswordItem changePasswordItem = new ChangePasswordItem(usuariCambio, "blahblah", "cambiado!");
            usuariService.changePassword(changePasswordItem);
            System.out.println("Cambiando password erroneo");
            ChangePasswordItem changePasswordErroneo = new ChangePasswordItem(usuariCambio, "blahblah", "cambiado2");
            usuariService.changePassword(changePasswordErroneo);
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        } catch (ExceptionContrasenyaIncorrecta exceptionContrasenyaIncorrecta) {
            exceptionContrasenyaIncorrecta.printStackTrace();
        }
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
