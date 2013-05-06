package ss1.service;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 18:48
 * Item con los datos para el cambio de password, se utilizará para obtener los datos desde la GUI y pasarlos al nivel
 * de negocio para comprobaciones y si es correcto, cambio de password
 */
public class ChangePasswordItem {
    
    private String usuari;
    private String oldPassword;
    private String newPassword;

    public ChangePasswordItem(String usuari, String oldPassword, String newPassword) {
        this.usuari = usuari;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getUsuari() {
        return usuari;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
