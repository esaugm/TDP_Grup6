/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ss2.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 ***************************************
 * Solicitud.java (UTF-8)
 ***************************************
 * Uoc Primavera 2013,
 * Grup06
 * Fecha: 2013.05.05 21:50:36
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class Solicitud implements java.io.Serializable{

	private Integer numsol;
	private String	comentaris;
	private Date	dataalta;
	private Date	datafinalitzacio;
	private String	client;
	private Integer	numreparacio;
	private Boolean	pendent;
	private Boolean	finalitzada;
	private Integer	asseguradora;
	private String	numPoliza;
	private Integer idtaller;

	public static final Integer SOLICITUD_UNDEF = -1;

	public Solicitud() {
	}

	public Solicitud(String comentaris, Date dataalta, Date datafinalitzacio, String client, Integer numreparacio, Boolean pendent, Boolean finalitzada, Integer asseguradora, String numPoliza, Integer idtaller) {
		super();
		this.comentaris = comentaris;
		this.dataalta = dataalta;
		this.datafinalitzacio = datafinalitzacio;
		this.client = client;
		this.numreparacio = numreparacio;
		this.pendent = pendent;
		this.finalitzada = finalitzada;
		this.asseguradora = asseguradora;
		this.numPoliza = numPoliza;
		this.idtaller = idtaller;
		this.numsol = SOLICITUD_UNDEF;
	}

	public Solicitud(Integer numsol, String comentaris, Date dataalta, Date datafinalitzacio, String client, Integer numreparacio, Boolean pendent, Boolean finalitzada, Integer asseguradora, String numPoliza, Integer idtaller) {
		super();
		this.numsol = numsol;
		this.comentaris = comentaris;
		this.dataalta = dataalta;
		this.datafinalitzacio = datafinalitzacio;
		this.client = client;
		this.numreparacio = numreparacio;
		this.pendent = pendent;
		this.finalitzada = finalitzada;
		this.asseguradora = asseguradora;
		this.idtaller = idtaller;
		this.numPoliza = numPoliza;
	}

		public Solicitud(String comentaris, String client, Integer numreparacio,
				Integer asseguradora, String numPoliza, Integer idtaller) {
		super();
		this.comentaris = comentaris;
		this.client = client;
		this.numreparacio = numreparacio;
		this.asseguradora = asseguradora;
		this.numPoliza = numPoliza;
		this.idtaller = idtaller;
	}


	public Integer getNumSol() {
		return numsol;
	}

	public void setNumSol(Integer numsol) {
		this.numsol = numsol;
	}

	public String getComentaris() {
		return comentaris;
	}

	public void setComentaris(String comentaris) {
		this.comentaris = comentaris;
	}

	public Date getDataAlta() {
		return dataalta;
	}

	public Date getDataFinalitzacio() {
		return datafinalitzacio;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Integer getNumReparacio() {
		return numreparacio;
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

	public Integer getIdtaller() {
		return idtaller;
	}

	public void setIdtaller(Integer idtaller) {
		this.idtaller = idtaller;
	}
	@Override
	public String toString() {
		return "Solicitud{" + "numsol=" + numsol + ", comentaris=" + comentaris + ", dataalta=" + dataalta + ", datafinalitzacio=" + datafinalitzacio + ", client=" + client + ", numreparacio=" + numreparacio + ", pendent=" + pendent + ", finalitzada=" + finalitzada + ", asseguradora=" + asseguradora + ", numPoliza=" + numPoliza + ", idtaller=" + idtaller +'}';
	}

	public Object[] toArray() {
		ArrayList<Object> values = new ArrayList<Object>();

		values.add(numsol);
		values.add(comentaris);
		values.add(dataalta);
		values.add(datafinalitzacio);
		values.add(client);
		values.add(numreparacio);
		values.add(pendent);
		values.add(finalitzada);
		values.add(asseguradora);
		values.add(numPoliza);
		values.add(idtaller);

		return values.toArray();
	}

}
