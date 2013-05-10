
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.dao;

//~--- non-JDK imports --------------------------------------------------------
import ss2.entity.Solicitud;

import ss2.exception.AppException;

//~--- JDK imports ------------------------------------------------------------

import java.rmi.Remote;

import java.util.ArrayList;

/**
 * **************************************
 * ISolicitud.java (UTF-8)
 * **************************************
 * Uoc Primavera 2013,
 * Grup06
 * Fecha: 2013.05.06 0:47:17
 * @author jiquintana (jiquintana@uoc.edu)
 *
 */
public interface ISolicitud extends Remote {

    public void checkAndInitDAO() throws AppException;

    public ArrayList<Solicitud> getSolicitud() throws AppException;

    public ArrayList<Solicitud> getSolicitudbyPK(String nif) throws AppException;

    public Solicitud getSolicitudbyNumSolicitud(Integer numclient) throws AppException;

    public ArrayList<Solicitud> getSolicitudbyANY(String freetext) throws AppException;

    public Boolean createSolicitud(Solicitud cliente) throws AppException;

    public Boolean modifySolicitud(Solicitud cliente) throws AppException;

    public Boolean deleteSolicitud(Solicitud cliente) throws AppException;
}
