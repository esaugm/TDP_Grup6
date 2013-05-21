/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.service.impl;

import ss2.service.ISolicitudService;
import java.util.ArrayList;
import ss2.dao.ISolicitudDAO;
import ss2.dao.impl.SolicitudDAO;
import ss2.entity.Solicitud;
import ss2.exception.AppException;

/**
 ***************************************
 * ss2.service.impl SolicitudService.java (UTF-8)
 * **************************************
 *
 * Uoc Primavera 2013, Grup06 Fecha: 2013.05.14 10:15:02
 *
 * @author jiquintana (José Ignacio Quintana)
 *
 */
public class SolicitudService implements ISolicitudService {

    ISolicitudDAO solicitudDAO;

    public SolicitudService() throws AppException {
        this.solicitudDAO = new SolicitudDAO();
        this.solicitudDAO.checkAndInitDAO();
    }

    @Override
    public Boolean altaSolicitud(Solicitud solicitud) throws AppException {
        return solicitudDAO.createSolicitudRetBoolean(solicitud);
    }

    @Override
    public Integer altaSolicitudRetNumsol(Solicitud solicitud) throws AppException {
        return solicitudDAO.createSolicitudRetNumsol(solicitud);
    }

    @Override
    public Solicitud altaSolicitudRetSolicitud(Solicitud solicitud) throws AppException {
        return solicitudDAO.createSolicitudRetSolicitud(solicitud);
    }

    @Override
    public Boolean modificaSolicitud(Solicitud solicitud) throws AppException {
        return solicitudDAO.modifySolicitud(solicitud);
    }

    @Override
    public Solicitud modificaSolicitudwithRet(Solicitud solicitud) throws AppException {
        return solicitudDAO.modifySolicitudretSolicitud(solicitud);
    }

    @Override
    public ArrayList<Solicitud> consultaSolicitudes() throws AppException {
        return solicitudDAO.getSolicitud();
    }

    @Override
    public ArrayList<Solicitud> buscaSolicitudbyANY(String freetext) throws AppException {
        return solicitudDAO.getSolicitudbyANY(freetext);
    }

    @Override
    public Solicitud buscaSolicitudbynumsol(Integer numsolicitud) throws AppException {
        return solicitudDAO.getSolicitudbyNumSolicitud(numsolicitud);
    }

    @Override
    public Solicitud finalizaSolicitud(Integer numsolicitud) throws AppException {
        Solicitud solicitud;

        solicitud = buscaSolicitudbynumsol(numsolicitud);
        solicitud.setFinalitzada(true);
        solicitud = modificaSolicitudwithRet(solicitud);

        return solicitud;
    }
    /*
     Boolean deleteSolicitud(Solicitud solicitud) throws AppException;
     */
}
