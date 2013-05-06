/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uoc.tdp.pac4.beans;

import java.util.ArrayList;

/**
 ***************************************
 * edu.uoc.tdp.pac4.beans
 * Peca.java (windows-1252)
 ***************************************
 * Uoc Primavera 2013, Grup06
 * Fecha: 2013.05.05 20:50:08
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class Peca implements java.io.Serializable {

	private Integer	CodiPeca;
	private String	Descripcio;
	private Float	PVP;
	private Float	PVD;
	private String	Marca;
	private String	Model;
	private Integer	IdProveidor;

	public static final Integer PECA_UNDEF = -1;

	public Peca() {
	}

	public Peca(String Descripcio, Float PVP, Float PVD, String Marca, String Model, Integer IdProveidor) {
		super();
		this.Descripcio = Descripcio;
		this.PVP = PVP;
		this.PVD = PVD;
		this.Marca = Marca;
		this.Model = Model;
		this.IdProveidor = IdProveidor;
		this.CodiPeca = PECA_UNDEF;
	}

	public Peca(Integer CodiPeca, String Descripcio, Float PVP, Float PVD, String Marca, String Model, Integer IdProveidor) {
		super();
		this.CodiPeca = CodiPeca;
		this.Descripcio = Descripcio;
		this.PVP = PVP;
		this.PVD = PVD;
		this.Marca = Marca;
		this.Model = Model;
		this.IdProveidor = IdProveidor;
	}

	public Integer getCodiPeca() {
		return CodiPeca;
	}

	public void setCodiPeca(Integer CodiPeca) {
		this.CodiPeca = CodiPeca;
	}

	public String getDescripcio() {
		return Descripcio;
	}

	public void setDescripcio(String Descripcio) {
		this.Descripcio = Descripcio;
	}

	public Float getPVP() {
		return PVP;
	}

	public void setPVP(Float PVP) {
		this.PVP = PVP;
	}

	public Float getPVD() {
		return PVD;
	}

	public void setPVD(Float PVD) {
		this.PVD = PVD;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String Marca) {
		this.Marca = Marca;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String Model) {
		this.Model = Model;
	}

	public Integer getIdProveidor() {
		return IdProveidor;
	}

	public void setIdProveidor(Integer IdProveidor) {
		this.IdProveidor = IdProveidor;
	}

	@Override
	public String toString() {
		return "Peca{" + "CodiPeca=" + CodiPeca + ", Descripcio=" + Descripcio + ", PVP=" + PVP + ", PVD=" + PVD + ", Marca=" + Marca + ", Model=" + Model + ", IdProveidor=" + IdProveidor + '}';
	}

	public Object[] toArray() {
		ArrayList<Object> values = new ArrayList<Object>();

		values.add(CodiPeca);
		values.add(Descripcio);
		values.add(PVP);
		values.add(PVD);
		values.add(Marca);
		values.add(Model);
		values.add(IdProveidor);

		return values.toArray();
	}
	
}
