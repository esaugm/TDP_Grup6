/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.service;

import java.util.ArrayList;
import java.util.Map;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss2.exception.AppException;
import ss3.beans.Reparacion;

/**
 *
 * @author Fernando
 */
public interface ReparacionService {
    
    public Reparacion ConsultaOrden(Integer OrdenID) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaTodas() throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaFechaAsig(String fechaAsig) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaFechaIni(String fechaIni) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaFechaFin(String fechaFin) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaAceptadas(Boolean aceptada) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaAsignadas(Boolean asignada) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaAsigMecanico(Integer idMecanico) throws ExceptionErrorDataBase;
    public Boolean anotaObs(Integer orden, String observaciones) throws ExceptionErrorDataBase;
    public Boolean asignaAMec(Integer orden, Integer idMecanico) throws ExceptionErrorDataBase;
    public Boolean desasignaMec(Integer orden, Integer idMecanico) throws ExceptionErrorDataBase;
    public Boolean creaReparacion(Reparacion rep) throws ExceptionErrorDataBase, AppException;
    public ArrayList<Reparacion> findReparacionesByTerms(Map values) throws ExceptionErrorDataBase;
    public Boolean aceptaReparacion(Integer orden) throws ExceptionErrorDataBase;
}
