/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.service.impl;

import java.util.ArrayList;
import java.util.Map;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss2.exception.AppException;
import ss3.beans.Reparacion;
import ss3.dao.ReparacionDAO;
import ss3.dao.impl.ReparacionDAOImpl;
import ss3.service.ReparacionService;

/**
 *
 * @author Fernando
 */
public class ReparacionServiceImpl implements ReparacionService {
    
    private ReparacionDAO reparacion;
    
    /**
     *
     * @param OrdenID
     * @return
     * @throws ExceptionErrorDataBase
     */
    public ReparacionServiceImpl(){
        this.reparacion = new ReparacionDAOImpl();
    }
    
    public Reparacion ConsultaOrden(Integer OrdenID) throws ExceptionErrorDataBase{
        return reparacion.findByPK(OrdenID);
    }
    public ArrayList<Reparacion> ConsultaTodas() throws ExceptionErrorDataBase{
        return reparacion.findAll();
    }
    
    public ArrayList<Reparacion> ConsultaFechaAsig(String fechaAsig) throws ExceptionErrorDataBase{
        return reparacion.findByDataAssignacio(fechaAsig);
    }
    
    public ArrayList<Reparacion> ConsultaFechaIni(String fechaIni) throws ExceptionErrorDataBase{
        return reparacion.findByDataInici(fechaIni);
    }
    
    public ArrayList<Reparacion> ConsultaFechaFin(String fechaFin) throws ExceptionErrorDataBase{
        return reparacion.findByDataFi(fechaFin);
    }
    
    public ArrayList<Reparacion> ConsultaAceptadas(Boolean aceptada) throws ExceptionErrorDataBase{
        return reparacion.findByAceptada(aceptada);
    }
    
    public ArrayList<Reparacion> ConsultaAsignadas(Boolean asignada) throws ExceptionErrorDataBase{
        return reparacion.findByAsignada(asignada);
    }
    
    public ArrayList<Reparacion> ConsultaAsigMecanico(Integer idMecanico) throws ExceptionErrorDataBase{
        return reparacion.findByIdMecanico(idMecanico);
    }
    
    public Boolean asignaAJT(Integer orden, Integer idJefeTaller) throws ExceptionErrorDataBase{
        return reparacion.asignaAJefeTaller(orden, idJefeTaller);
    }
    
    public Boolean aceptaReparacion(Integer orden) throws ExceptionErrorDataBase{
        return reparacion.aceptaReparacion(orden);
    }
    
    public Boolean anotaObs(Integer orden, String observaciones) throws ExceptionErrorDataBase{
        return reparacion.anotaObservacion(orden, observaciones);
    }
    
    public Boolean asignaAMec(Integer orden, Integer idMecanico) throws ExceptionErrorDataBase{
        return reparacion.asignaAMecanico(orden, idMecanico);
    }
    
    public Boolean creaReparacion(Reparacion rep) throws ExceptionErrorDataBase, AppException{
        return reparacion.createReparacion(rep);
    }
    
    public ArrayList<Reparacion> findReparacionesByTerms(Map values) throws ExceptionErrorDataBase{
        return reparacion.findReparacionesByTerms(values);
    }
}
