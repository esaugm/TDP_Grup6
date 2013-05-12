package ss1.service;

import ss1.entity.Usuari;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 18:48
 * Item con los datos para el cambio de password, se utilizará para obtener los datos desde la GUI y pasarlos al nivel
 * de negocio para comprobaciones y si es correcto, cambio de password
 */
public class ChangePasswordItem {
    
    private Usuari usuari;
    private String oldPassword;
    private String newPassword;

    public ChangePasswordItem(Usuari usuari, String oldPassword, String newPassword) {
        this.usuari = usuari;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
    
    public Usuari getUsuariWithNewPassword(){
        usuari.setContrasenya(newPassword);
        return usuari;
    }
}
