package ss1.entity;

import common.entity.PerfilUsuari;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 18/05/13
 * Time: 12:44
 * Clase que contiene el Usuari que ha hecho login y su hora de conexión
 */
public class UsuariConectat {
    private Usuari usuari;
    private long horaConexio;

    public UsuariConectat(Usuari usuari, long horaConexio) {
        this.usuari = usuari;
        this.horaConexio = horaConexio;
    }

    @Deprecated
    public PerfilUsuari getPerfil(){
        return usuari.getPerfil();
    }
    
    public String getPerfilString(){
        return usuari.getPerfil().toString();
    }

    public Integer getTaller(){
        return usuari.getTaller();
    }

    public boolean isAdministrador(){
        return usuari.isAdministrador();
    }

    public boolean isAdministratiu(){
        return usuari.isAdministratiu();
    }

    public boolean isCapTaller(){
        return usuari.isCapTaller();
    }

    public boolean isMecanic(){
        return usuari.isMecanic();
    }

    public String getNom(){
        return usuari.getNom();
    }

    public boolean checkIfPasswordOk(String text) {
        return usuari.getContrasenya().equals(text);
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari newUsuari) {
        usuari = newUsuari;
    }
}
