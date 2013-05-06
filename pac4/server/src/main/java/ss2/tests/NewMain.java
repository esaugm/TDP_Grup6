/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.tests;

import ss2.dao.ClientDAOImpl;
import ss2.dao.GestorClientInterface;
import ss2.beans.Client;
import java.util.ArrayList;
import ss2.exception.AppException;



/**
 *
 * @author josi
 */
public final class NewMain { //implements GestorClientInterface{

	//final ClientDAOImpl gestorClient;

	//final ArrayList <Client> lcliente;
	ArrayList <Client> lcliente;

	//final private ClientDAOImpl	gClient;

	public NewMain() {
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here



		GestorClientInterface gClient = new ClientDAOImpl();
		try {
			ArrayList <Client> lcliente = gClient.getClient();
		} catch (AppException ex) {
			ex.printStackTrace();
		}

	}




}
