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

    public PerfilUsuari getPerfil(){
        return usuari.getPerfil();
    }

}
