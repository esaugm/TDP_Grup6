/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.service;

import java.util.ArrayList;
import ss2.entity.Solicitud;
import ss2.exception.AppException;

/**
 ***************************************
 * ss2.service.impl ISolicitudService.java (UTF-8)
 * **************************************
 *
 * Uoc Primavera 2013, Grup06 Fecha: 2013.05.15 11:37:44
 *
 * @author jiquintana (José Ignacio Quintana)
 *
 */
public interface ISolicitudService {

    Boolean altaSolicitud(Solicitud solicitud) throws AppException;

    Integer altaSolicitudRetNumsol(Solicitud solicitud) throws AppException;

    Solicitud altaSolicitudRetSolicitud(Solicitud solicitud) throws AppException;

    ArrayList<Solicitud> buscaSolicitudbyANY(String freetext) throws AppException;

    Solicitud buscaSolicitudbynumsol(Integer numsolicitud) throws AppException;

    ArrayList<Solicitud> consultaSolicitudes() throws AppException;

    Solicitud finalizaSolicitud(Integer numsolicitud) throws AppException;
    /*
     Boolean deleteSolicitud(Solicitud solicitud) throws AppException;
     */

    Boolean modificaSolicitud(Solicitud solicitud) throws AppException;

    Solicitud modificaSolicitudwithRet(Solicitud solicitud) throws AppException;
}
