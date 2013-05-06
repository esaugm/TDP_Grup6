package common.entity;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 15:25
 * Clase generica que define la entidad Persona
 */
public class Persona {
    
    private String nom;
    private String cognoms;
    private String adreca;
    private String nif;
    private String poblacio;
    private Integer codiPostal;


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

    public Integer getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(Integer codiPostal) {
        this.codiPostal = codiPostal;
    }
}
