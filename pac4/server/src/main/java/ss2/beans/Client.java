/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ss2.beans;

import java.util.ArrayList;
import java.util.Date;

/**
 ***************************************
 * edu.uoc.tdp.pac4.beans
 * Client.java (UTF8)
 ***************************************
 * Uoc Primavera 2013, Grup06
 * Fecha: 2013.05.05 20:15:39
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class Client implements java.io.Serializable {

	private Integer	numClient;
	private String	Nom;
	private String	Cognoms;
	private String	Adreça;
	private String	nif;
	private String	poblacio;
	private Integer	codiPostal;
	private Date	dataAlta;

	public static final Integer CLIENT_UNDEF = -1;

	public Client() {
	}

	public Client(String Nom, String Cognoms, String Adreça, String nif, String poblacio, Integer codiPostal, Integer numClient, Date dataAlta) {
		super();
		this.Nom = Nom;
		this.Cognoms = Cognoms;
		this.Adreça = Adreça;
		this.nif = nif;
		this.poblacio = poblacio;
		this.codiPostal = codiPostal;
		this.numClient = numClient;
		this.dataAlta = dataAlta;
	}


	public Client(String Nom, String Cognoms, String Adreça, String nif, String poblacio, Integer codiPostal, Date dataAlta) {
		super();
		this.Nom = Nom;
		this.Cognoms = Cognoms;
		this.Adreça = Adreça;
		this.nif = nif;
		this.poblacio = poblacio;
		this.codiPostal = codiPostal;
		this.dataAlta = dataAlta;
		this.numClient = CLIENT_UNDEF;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}

	public String getCognoms() {
		return Cognoms;
	}

	public void setCognoms(String Cognoms) {
		this.Cognoms = Cognoms;
	}

	public String getAdreça() {
		return Adreça;
	}

	public void setAdreça(String Adreça) {
		this.Adreça = Adreça;
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

	public Integer getNumClient() {
		return numClient;
	}

	public void setNumClient(Integer numClient) {
		this.numClient = numClient;
	}

	public Date getDataAlta() {
		return dataAlta;
	}

	public void setDataAlta(Date dataAlta) {
		this.dataAlta = dataAlta;
	}

	@Override
	public String toString() {
		return "Client{" + "Nom=" + Nom + ", Cognoms=" + Cognoms + ", Adre\u00e7a=" + Adreça + ", nif=" + nif + ", poblacio=" + poblacio + ", codiPostal=" + codiPostal + ", numClient=" + numClient + ", dataAlta=" + dataAlta + '}';
	}

	public Object[] toArray() {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(Nom);
		values.add(Cognoms);
		values.add(Adreça);
		values.add(nif);
		values.add(poblacio);
		values.add(codiPostal);
		values.add(numClient);
		values.add(dataAlta);

		return values.toArray();
	}




}
