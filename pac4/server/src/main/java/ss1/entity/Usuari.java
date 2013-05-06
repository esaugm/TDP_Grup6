package ss1.entity;

import common.entity.PerfilUsuari;
import common.entity.Persona;

import java.util.Date;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 15:49
 * Clase que implementa la entidad Usuari
 */
public class Usuari extends Persona {
    
    private Integer id;
    private Integer taller;
    private String usuari;
    private PerfilUsuari perfil;
    private String contrasenya;
    private boolean actiu;
    private Date dataAlta;
    private Date dataModificacio;
    private Date dataBaixa;
    private Integer reparacionsAssignades;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaller() {
        return taller;
    }

    public void setTaller(Integer taller) {
        this.taller = taller;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public PerfilUsuari getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuari perfil) {
        this.perfil = perfil;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public boolean isActiu() {
        return actiu;
    }

    public void setActiu(boolean actiu) {
        this.actiu = actiu;
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }

    public Date getDataModificacio() {
        return dataModificacio;
    }

    public void setDataModificacio(Date dataModificacio) {
        this.dataModificacio = dataModificacio;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Integer getReparacionsAssignades() {
        return reparacionsAssignades;
    }

    public void setReparacionsAssignades(Integer reparacionsAssignades) {
        this.reparacionsAssignades = reparacionsAssignades;
    }
}
