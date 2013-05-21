package ss1.entity;

import common.entity.PerfilUsuari;
import ss1.entity.exception.ExceptionMaximoReparacionesAsignadas;
import ss1.entity.exception.ExceptionNoReparacionesAsignadas;

import java.io.Serializable;
import java.util.Date;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 15:49
 * Clase que implementa la entidad Usuari
 */
public class Usuari implements Serializable {
    
    private Integer id;
    //todo añadir campos a la tabla
    private String nom;
    private String cognoms;
    private String adreca;
    private String nif;
    private String poblacio;
    private String codiPostal;
    private Integer taller;
    private String usuari;
    private PerfilUsuari perfil;
    private String contrasenya;
    private Boolean actiu;
    private Date dataAlta;
    private Date dataModificacio;
    private Date dataBaixa;
    private Integer reparacionsAssignades;
    private int maxReparacions = 2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public String getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(String codiPostal) {
        this.codiPostal = codiPostal;
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

    public Boolean isActiu() {
        return actiu;
    }

    public void setActiu(Boolean actiu) {
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

    /**
     * Incrementa en 1 el número de reparaciones asignadas al Usuari. Se utiliza para el momento en que se asigna una reparacion
     * a un Usuari del tipo PerfilUsuari.MECANIC
     * @throws ExceptionMaximoReparacionesAsignadas si el Usuari tiene ya asignadas las 2 reparaciones permitidas
     */
    public void incrementarReparacionsAssignades() throws ExceptionMaximoReparacionesAsignadas {
        if (this.reparacionsAssignades<maxReparacions){
            reparacionsAssignades++;
        } else throw new ExceptionMaximoReparacionesAsignadas();
    }

    /**
     * Decrementa en 1 el número de reparaciones asignadas al Usuari. Se utiliza para el momento de desasignar una reparación
     * de un Usuari del tipo  PerfilUsuari.MECANIC
     * @throws ExceptionNoReparacionesAsignadas si al Usuari no le quedan reparaciones asignadas
     */
    public void decrementaReparacionsAssignades() throws ExceptionNoReparacionesAsignadas {
        if (this.reparacionsAssignades>0){
            reparacionsAssignades--;
        } else throw new ExceptionNoReparacionesAsignadas();
    }

    /**
     * Metodo para ver si un Usuari del tipo PerfilUsuari.MECANIC se le puede asignar una reparación
     * @return true si se le puede asignar una reparación, false si no.
     */
    public boolean isDisponible(){
        return reparacionsAssignades<maxReparacions;

    }
    
    public boolean isAdministrador(){
        return perfil.equals(PerfilUsuari.ADMINISTRADOR); 
    }
    
    public boolean isAdministratiu(){
        return perfil.equals(PerfilUsuari.ADMINISTRATIU);
    }
    
    public boolean isCapTaller(){
        return perfil.equals(PerfilUsuari.CAPTALLER);
    }
    
    public boolean isMecanic(){
        return perfil.equals(PerfilUsuari.MECANIC);
    }

    public void setReparacionsAssignades(int pReparacionsassignades) {
        reparacionsAssignades=pReparacionsassignades;
    }
}
