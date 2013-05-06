/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uoc.tdp.pac4.SS2.tests;

import edu.uoc.tdp.pac4.SS2.ClientDAOImpl;
import edu.uoc.tdp.pac4.SS2.GestorClientInterface;
import edu.uoc.tdp.pac4.beans.Client;
import java.util.ArrayList;



/**
 *
 * @author josi
 */
public final class NewMain implements GestorClientInterface{

	//final ClientDAOImpl gestorClient;

	//final ArrayList <Client> lcliente;
	ArrayList <Client> lcliente;

	private ClientDAOImpl	gClient;

	public NewMain() {
		gClient = new ClientDAOImpl();
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		final GestorClientInterface gestorClient = new ClientDAOImpl();
		ArrayList <Client> lcliente = gestorClient.getClient();

	}

	public ArrayList<Client> getClient() {
	   	return gClient.getClient();
	}


}
