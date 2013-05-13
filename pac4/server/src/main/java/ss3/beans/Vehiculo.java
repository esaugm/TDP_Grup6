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
public class Vehiculo implements java.io.Serializable {
    
    private Integer numChasis;
    private String marca;
    private String tipo;
    private String modelo;
    private String matricula;
    private String color;
    private Date anio;
    private Integer numReparacion;

    public Vehiculo(Integer numChasis, String marca, String tipo, String modelo, String matricula, String color, Date anio, Integer numReparacion) {
        this.numChasis = numChasis;
        this.marca = marca;
        this.tipo = tipo;
        this.modelo = modelo;
        this.matricula = matricula;
        this.color = color;
        this.anio = anio;
        this.numReparacion = numReparacion;
    }
    

    public Integer getNumChasis() {
        return numChasis;
    }

    public void setNumChasis(Integer numChasis) {
        this.numChasis = numChasis;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public Integer getNumReparacion() {
        return numReparacion;
    }

    public void setNumReparacion(Integer numReparacion) {
        this.numReparacion = numReparacion;
    }

@Override
	public String toString() {
		return "\n\nVehículo{\n" + "Nº Chasis= " + numChasis + ", Marca= " + marca + ", Tipo= " + tipo + ", Matrícula= " + matricula + ", Color= " + color + ", Año= " + anio + ", NumReparacion= " + numReparacion + "\n}";
        
	}

	public Object[] toArray() {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(numChasis);
		values.add(marca);
		values.add(tipo);
		values.add(matricula);
		values.add(color);
		values.add(anio);
		values.add(numReparacion);
                
		return values.toArray();
	}

}
