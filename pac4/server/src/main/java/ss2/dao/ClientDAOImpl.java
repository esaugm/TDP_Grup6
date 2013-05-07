/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ss2.dao;

import common.utils.GestorBBDD;
import ss2.beans.Client;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ss2.exception.AppException;

/**
 ***************************************
 * edu.uoc.tdp.pac4.SS2
 * ClientDAOImpl.java (UTF8)
 ***************************************
 * Uoc Primavera 2013, Grup06
 * Fecha: 2013.05.05 23:38:32
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public class ClientDAOImpl extends GestorBBDD implements GestorClientInterface {

	protected Connection		connection;
	protected PreparedStatement	preparedstatement;
	protected ResultSet			resultset;

	public ClientDAOImpl() {
	}

	@Override
	public ArrayList <Client> getClient () throws AppException {
		String SQL="SELECT * from client";
		ArrayList <Client> listaclient = new ArrayList<Client>();

		try {
			connection = getConnection();
		} catch (ClassNotFoundException ex) {
			throw new AppException(ex);
		} catch (IOException ex) {
			throw new AppException(ex);
		} catch (SQLException ex) {
			throw new AppException(ex);
		}

		System.out.println(SQL);
		try {
			preparedstatement = connection.prepareStatement(SQL);
			resultset = preparedstatement.executeQuery();
			System.out.println(resultset);

//public Client(String Nom, String Cognoms, String AdreÃ§a, String nif, String poblacio, Integer codiPostal, Integer numClient, Date dataAlta) {

			while (resultset.next()) {
				Client cliente = new Client(
					resultset.getString("nom"),
					resultset.getString("cognoms"),
					resultset.getString("adreca"),
					resultset.getString("nif"),
					resultset.getString("poblacio"),
					resultset.getInt("codipostal"),
					resultset.getInt("numclient"),
					resultset.getDate("dataalta")
					);
				System.out.println(cliente);
				listaclient.add(cliente);
			}
			System.out.println(listaclient);

		} catch (SQLException ex) {
			throw new AppException(ex);
		} finally {
			freeResources(connection, preparedstatement, resultset);
		}
		return listaclient;
	}

}
