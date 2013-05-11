/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.dao;

import java.rmi.Remote;
import java.util.ArrayList;
import ss2.entity.Solicitud;
import ss2.exception.AppException;

/**
 ***************************************
 * ss2.dao.impl
 * ISolicitud32.java (windows-1252)
 ***************************************
 * Uoc Primavera 2013, Grup06
 * Fecha: 2013.05.11 20:52:01
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public interface ISolicitud extends Remote {

		void checkAndInitDAO() throws AppException;

		Boolean createSolicitud(Solicitud solicitud) throws AppException;

		Boolean deleteSolicitud(Solicitud solicitud) throws AppException;

		ArrayList<Solicitud> getSolicitud() throws AppException;

		ArrayList<Solicitud> getSolicitudbyANY(String freetext) throws AppException;

		Solicitud getSolicitudbyNumSolicitud(Integer numsolicitud) throws AppException;

		Boolean modifySolicitud(Solicitud solicitud) throws AppException;

}
