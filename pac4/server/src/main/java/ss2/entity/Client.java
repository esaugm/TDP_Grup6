/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ss2.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 ***************************************
 * Client.java (UTF8)
 ***************************************
 * Uoc Primavera 2013,
 * Grup06
 * Fecha: 2013.05.05 20:15:39
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */

public class Client implements java.io.Serializable {

	private String	nom;
	private String	cognoms;
	private String	adreca;
	private String	nif;
	private String	poblacio;
	private Integer	codipostal;
	private Integer	numclient;
	private Date	dataalta;



	public Client() {
	}

	public static final Integer getCLIENT_UNDEF() {
		return -1;
	}

	public Client(String nom, String cognoms, String adreca, String nif, String poblacio, Integer codipostal, Integer numclient, Date dataalta) {
		super();
		this.nom = nom.trim();
		this.cognoms = cognoms.trim();
		this.adreca = adreca.trim();
		this.nif = nif.trim();
		this.poblacio = poblacio.trim();
		this.codipostal = codipostal;
		this.numclient = numclient;
		this.dataalta = dataalta;
	}


	public Client(String nom, String cognoms, String adreca, String nif, String poblacio, Integer codipostal, Date dataalta) {
		super();
		this.nom = nom.trim();
		this.cognoms = cognoms.trim();
		this.adreca = adreca.trim();
		this.nif = nif.trim();
		this.poblacio = poblacio.trim();
		this.codipostal = codipostal;
		this.dataalta = dataalta;
		this.numclient = getCLIENT_UNDEF();
	}

	public String getnom() {
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom.trim();
	}

	public String getcognoms() {
		return cognoms;
	}

	public void setcognoms(String cognoms) {
		this.cognoms = cognoms.trim();
	}

	public String getadreca() {
		return adreca;
	}

	public void setadreca(String adreca) {
		this.adreca = adreca.trim();
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif.trim();
	}

	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio.trim();
	}

	public Integer getCodiPostal() {
		return codipostal;
	}

	public void setCodiPostal(Integer codipostal) {
		this.codipostal = codipostal;
	}

	public Integer getNumClient() {
		return numclient;
	}

	public void setNumClient(Integer numclient) {
		this.numclient = numclient;
	}

	public Date getDataAlta() {
		return dataalta;
	}

	public void setDataAlta(Date dataalta) {
		this.dataalta = dataalta;
	}

	@Override
	public String toString() {
		return "\nClient{" + "nom=" + nom + ", cognoms=" + cognoms + ", adreca=" + adreca + ", nif=" + nif + ", poblacio=" + poblacio + ", codipostal=" + codipostal + ", numclient=" + numclient + ", dataalta=" + dataalta + "}\n";
	}

	public Object[] toArray() {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(nom);
		values.add(cognoms);
		values.add(adreca);
		values.add(nif);
		values.add(poblacio);
		values.add(codipostal);
		values.add(numclient);
		values.add(dataalta);

		return values.toArray();
	}




}
