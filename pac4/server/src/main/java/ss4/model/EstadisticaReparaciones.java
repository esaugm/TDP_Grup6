package ss4.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 22/05/13
 * Time: 16:36
 * To change this template use File | Settings | File Templates.
 */
public class EstadisticaReparaciones implements Serializable{

    private Integer idReparacio;
    private String nomClient;
    private String nomMencanic;
    private String tipoReparacio;
    private Date inici;
    private Date fin;
    private String estado;
    private String marca;
    private String compañia;
    private String importe;

    public Integer getIdReparacio() {
        return idReparacio;
    }

    public void setIdReparacio(Integer idReparacio) {
        this.idReparacio = idReparacio;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getNomMencanic() {
        return nomMencanic;
    }

    public void setNomMencanic(String nomMencanic) {
        this.nomMencanic = nomMencanic;
    }

    public String getTipoReparacio() {
        return tipoReparacio;
    }

    public void setTipoReparacio(String tipoReparacio) {
        this.tipoReparacio = tipoReparacio;
    }

    public Date getInici() {
        return inici;
    }

    public void setInici(Date inici) {
        this.inici = inici;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadisticaReparaciones that = (EstadisticaReparaciones) o;

        if (compañia != null ? !compañia.equals(that.compañia) : that.compañia != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (fin != null ? !fin.equals(that.fin) : that.fin != null) return false;
        if (idReparacio != null ? !idReparacio.equals(that.idReparacio) : that.idReparacio != null) return false;
        if (importe != null ? !importe.equals(that.importe) : that.importe != null) return false;
        if (inici != null ? !inici.equals(that.inici) : that.inici != null) return false;
        if (marca != null ? !marca.equals(that.marca) : that.marca != null) return false;
        if (nomClient != null ? !nomClient.equals(that.nomClient) : that.nomClient != null) return false;
        if (nomMencanic != null ? !nomMencanic.equals(that.nomMencanic) : that.nomMencanic != null) return false;
        if (tipoReparacio != null ? !tipoReparacio.equals(that.tipoReparacio) : that.tipoReparacio != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReparacio != null ? idReparacio.hashCode() : 0;
        result = 31 * result + (nomClient != null ? nomClient.hashCode() : 0);
        result = 31 * result + (nomMencanic != null ? nomMencanic.hashCode() : 0);
        result = 31 * result + (tipoReparacio != null ? tipoReparacio.hashCode() : 0);
        result = 31 * result + (inici != null ? inici.hashCode() : 0);
        result = 31 * result + (fin != null ? fin.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        result = 31 * result + (compañia != null ? compañia.hashCode() : 0);
        result = 31 * result + (importe != null ? importe.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EstadisticaReparaciones{" +
                "idReparacio=" + idReparacio +
                ", nomClient='" + nomClient + '\'' +
                ", nomMencanic='" + nomMencanic + '\'' +
                ", tipoReparacio='" + tipoReparacio + '\'' +
                ", inici=" + inici +
                ", fin=" + fin +
                ", estado='" + estado + '\'' +
                ", marca='" + marca + '\'' +
                ", compañia='" + compañia + '\'' +
                ", importe='" + importe + '\'' +
                '}';
    }
}
