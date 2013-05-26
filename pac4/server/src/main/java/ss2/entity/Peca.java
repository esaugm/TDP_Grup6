/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ss2.entity;

import java.util.ArrayList;

/**
 ***************************************
 * Peca.java (UTF-8)
 ***************************************
 * Uoc Primavera 2013,
 * Grup06
 * Fecha: 2013.05.05 20:50:08
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class Peca implements java.io.Serializable {

	private Integer	codipeca;
	private String	descripcio;
	private Float	pvp;
	private Float	pvd;
	private String	marca;
	private String	model;
	private Integer	idproveidor;

	public Peca() {
	}

	public static final Integer getPECA_UNDEF() {
		return -1;
	}

	public Peca(String descripcio, Float pvp, Float pvd, String marca, String model, Integer idproveidor) {
		super();
		this.descripcio = descripcio;
		this.pvp = pvp;
		this.pvd = pvd;
		this.marca = marca;
		this.model = model;
		this.idproveidor = idproveidor;
		this.codipeca = getPECA_UNDEF();
	}

	public Peca(Integer codipeca, String descripcio, Float pvp, Float pvd, String marca, String model, Integer idproveidor) {
		super();
		this.codipeca = codipeca;
		this.descripcio = descripcio;
		this.pvp = pvp;
		this.pvd = pvd;
		this.marca = marca;
		this.model = model;
		this.idproveidor = idproveidor;
	}

	public Integer getcodipeca() {
		return codipeca;
	}

	public void setcodipeca(Integer codipeca) {
		this.codipeca = codipeca;
	}

	public String getdescripcio() {
		return descripcio;
	}

	public void setdescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public Float getpvp() {
		return pvp;
	}

	public void setpvp(Float pvp) {
		this.pvp = pvp;
	}

	public Float getpvd() {
		return pvd;
	}

	public void setpvd(Float pvd) {
		this.pvd = pvd;
	}

	public String getmarca() {
		return marca;
	}

	public void setmarca(String marca) {
		this.marca = marca;
	}

	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}

	public Integer getidproveidor() {
		return idproveidor;
	}

	public void setidproveidor(Integer idproveidor) {
		this.idproveidor = idproveidor;
	}

	@Override
	public String toString() {
		return "Peca{" + "codipeca=" + codipeca + ", descripcio=" + descripcio + ", pvp=" + pvp + ", pvd=" + pvd + ", marca=" + marca + ", model=" + model + ", idproveidor=" + idproveidor + '}';
	}

	public Object[] toArray() {
		ArrayList<Object> values = new ArrayList<Object>();

		values.add(codipeca);
		values.add(descripcio);
		values.add(pvp);
		values.add(pvd);
		values.add(marca);
		values.add(model);
		values.add(idproveidor);

		return values.toArray();
	}

}
