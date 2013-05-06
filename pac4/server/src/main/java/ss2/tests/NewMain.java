/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.tests;

import ss2.dao.ClientDAOImpl;
import ss2.dao.GestorClientInterface;
import ss2.beans.Client;
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
