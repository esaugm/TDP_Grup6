package ss3.beans;

import ss3.beans.*;
import java.util.Date;

/**
 * TDP Grup6
 * User: Fernando Gomez
 * Date: 7/05/13
 * Time: 19:00
 */
public class Reparacion {
    
    private Integer idOrden;
    private Integer idJefeTaller;
    private boolean aceptada;
    private Integer idMecanico;
    private boolean asignada;
    private double contador;
    private String observaciones;
    private Integer numcom;
    private Date fechaAsigna;
    private Date fechaIni;
    private Date fechaFin;

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getIdJefeTaller() {
        return idJefeTaller;
    }

    public void setIdJefeTaller(Integer idJefeTaller) {
        this.idJefeTaller = idJefeTaller;
    }

    public boolean isAceptada() {
        return aceptada;
    }

    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    }

    public Integer getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(Integer idMecanico) {
        this.idMecanico = idMecanico;
    }

    public boolean isAsignada() {
        return asignada;
    }

    public void setAsignada(boolean asignada) {
        this.asignada = asignada;
    }

    public double getContador() {
        return contador;
    }

    public void setContador(double contador) {
        this.contador = contador;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getNumcom() {
        return numcom;
    }

    public void setNumcom(Integer numcom) {
        this.numcom = numcom;
    }

    public Date getFechaAsigna() {
        return fechaAsigna;
    }

    public void setFechaAsigna(Date fechaAsigna) {
        this.fechaAsigna = fechaAsigna;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
