package ss3.beans;

import java.util.ArrayList;
import ss3.beans.*;
import java.util.Date;

/**
 * TDP Grup6
 * User: Fernando Gomez
 * Date: 7/05/13
 * Time: 19:00
 */
public class Pieza implements java.io.Serializable {
    
    private Integer codiPieza;
    private String descripcion;
    private float pvp;
    private float pvd;
    private String marca;
    private String modelo;
    private Integer idProveedor;

    public Pieza(){
    }
    
    public Pieza(Integer codiPieza, String descripcion, float pvp, float pvd, String marca, String modelo, Integer idProveedor) {
        this.codiPieza = codiPieza;
        this.descripcion = descripcion;
        this.pvp = pvp;
        this.pvd = pvd;
        this.marca = marca;
        this.modelo = modelo;
        this.idProveedor = idProveedor;
    }
    

    public Integer getCodiPieza() {
        return codiPieza;
    }

    public void setCodiPieza(Integer codiPieza) {
        this.codiPieza = codiPieza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public float getPvd() {
        return pvd;
    }

    public void setPvd(float pvd) {
        this.pvd = pvd;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    

@Override
	public String toString() {
		return "\n\nPieza{\n" + "Codigo Pieza= " + codiPieza + ", Descripcion= " + descripcion + ", PVP= " + pvp + ", PVD= " + pvd + ", Marca= " + marca + ", Modelo= " + modelo + ", IdProveedor= " + idProveedor + "\n}";
        
	}

	public Object[] toArray() {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(codiPieza);
		values.add(descripcion);
		values.add(pvp);
		values.add(pvd);
		values.add(marca);
		values.add(modelo);
		values.add(idProveedor);
                
		return values.toArray();
	}
}
