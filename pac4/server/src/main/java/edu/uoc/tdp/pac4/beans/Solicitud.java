/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uoc.tdp.pac4.beans;

import java.util.ArrayList;
import java.util.Date;

/**
 ***************************************
 * edu.uoc.tdp.pac4.beans
 * Solicitud.java (windows-1252)
 ***************************************
 * Uoc Primavera 2013, Grup06
 * Fecha: 2013.05.05 21:50:36
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class Solicitud implements java.io.Serializable{

	private Integer numSol;
	private String	comentaris;
	private Date	dataAlta;
	private Date	dataFinalitzacio;
	private String	client;
	private Integer	numReparacio;
	private Boolean	pendent;
	private Boolean	finalitzada;
	private Integer	asseguradora;
	private String	numPoliza;

	public static final Integer SOLICITUD_UNDEF = -1;

	public Solicitud() {
	}

	public Solicitud(String comentaris, Date dataAlta, Date dataFinalitzacio, String client, Integer numReparacio, Boolean pendent, Boolean finalitzada, Integer asseguradora, String numPoliza) {
		super();
		this.comentaris = comentaris;
		this.dataAlta = dataAlta;
		this.dataFinalitzacio = dataFinalitzacio;
		this.client = client;
		this.numReparacio = numReparacio;
		this.pendent = pendent;
		this.finalitzada = finalitzada;
		this.asseguradora = asseguradora;
		this.numPoliza = numPoliza;
		this.numSol = SOLICITUD_UNDEF;
	}

	public Solicitud(Integer numSol, String comentaris, Date dataAlta, Date dataFinalitzacio, String client, Integer numReparacio, Boolean pendent, Boolean finalitzada, Integer asseguradora, String numPoliza) {
		this.numSol = numSol;
		this.comentaris = comentaris;
		this.dataAlta = dataAlta;
		this.dataFinalitzacio = dataFinalitzacio;
		this.client = client;
		this.numReparacio = numReparacio;
		this.pendent = pendent;
		this.finalitzada = finalitzada;
		this.asseguradora = asseguradora;
		this.numPoliza = numPoliza;
	}

	public Integer getNumSol() {
		return numSol;
	}

	public void setNumSol(Integer numSol) {
		this.numSol = numSol;
	}

	public String getComentaris() {
		return comentaris;
	}

	public void setComentaris(String comentaris) {
		this.comentaris = comentaris;
	}

	public Date getDataAlta() {
		return dataAlta;
	}

	public void setDataAlta(Date dataAlta) {
		this.dataAlta = dataAlta;
	}

	public Date getDataFinalitzacio() {
		return dataFinalitzacio;
	}

	public void setDataFinalitzacio(Date dataFinalitzacio) {
		this.dataFinalitzacio = dataFinalitzacio;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Integer getNumReparacio() {
		return numReparacio;
	}

	public void setNumReparacio(Integer numReparacio) {
		this.numReparacio = numReparacio;
	}

	public Boolean getPendent() {
		return pendent;
	}

	public void setPendent(Boolean pendent) {
		this.pendent = pendent;
	}

	public Boolean getFinalitzada() {
		return finalitzada;
	}

	public void setFinalitzada(Boolean finalitzada) {
		this.finalitzada = finalitzada;
	}

	public Integer getAsseguradora() {
		return asseguradora;
	}

	public void setAsseguradora(Integer asseguradora) {
		this.asseguradora = asseguradora;
	}

	public String getNumPoliza() {
		return numPoliza;
	}

	public void setNumPoliza(String numPoliza) {
		this.numPoliza = numPoliza;
	}

	@Override
	public String toString() {
		return "Solicitud{" + "numSol=" + numSol + ", comentaris=" + comentaris + ", dataAlta=" + dataAlta + ", dataFinalitzacio=" + dataFinalitzacio + ", client=" + client + ", numReparacio=" + numReparacio + ", pendent=" + pendent + ", finalitzada=" + finalitzada + ", asseguradora=" + asseguradora + ", numPoliza=" + numPoliza + '}';
	}

	public Object[] toArray() {
		ArrayList<Object> values = new ArrayList<Object>();

		values.add(numSol);
		values.add(comentaris);
		values.add(dataAlta);
		values.add(dataFinalitzacio);
		values.add(client);
		values.add(numReparacio);
		values.add(pendent);
		values.add(finalitzada);
		values.add(asseguradora);
		values.add(numPoliza);

		return values.toArray();
	}








}
