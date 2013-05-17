/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.server;

import java.util.ArrayList;
import java.rmi.Remote;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss2.exception.AppException;
import ss3.beans.Pieza;
import ss3.beans.Reparacion;
import ss3.beans.Vehiculo;

/**
 ***************************************
 * ss3.server.impl SS3Reparaciones.java (UTF-8)
 * **************************************
 *
 * Uoc Primavera 2013, Grup06 Fecha: 2013.05.17 18:20:00
 *
 * @author fernandeuz (Fernando Gómez Marino)
 *
 */
public interface SS3Reparaciones extends Remote {

    public Reparacion ConsultaOrden(Integer OrdenID) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaFechaAsig(String fechaAsig) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaFechaIni(String fechaIni) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaFechaFin(String fechaFin) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaAceptadas(Boolean aceptada) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaAsignadas(Boolean asignada) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> ConsultaAsigMecanico(Integer idMecanico) throws ExceptionErrorDataBase;
    public Boolean anotaObs(Integer orden, String observaciones) throws ExceptionErrorDataBase;
    public Boolean asignaAMec(Integer orden, Integer idMecanico) throws ExceptionErrorDataBase;
    public Pieza ConsultaCodigo(Integer codigo) throws ExceptionErrorDataBase;
    public ArrayList<Pieza> ConsultaPiezas() throws ExceptionErrorDataBase;
    public ArrayList<Pieza> ConsultaDescripcion(String descripcion) throws ExceptionErrorDataBase;
    public Vehiculo ConsultaChasis(String numChasis) throws ExceptionErrorDataBase;
    public ArrayList<Vehiculo> ConsultaMarca(String marca) throws ExceptionErrorDataBase;
    public ArrayList<Vehiculo> ConsultaMatricula(String matricula) throws ExceptionErrorDataBase;
    public ArrayList<Vehiculo> ConsultaModelo(String modelo) throws ExceptionErrorDataBase;
    public ArrayList<Vehiculo> ConsultaReparacion(Integer orden) throws ExceptionErrorDataBase;
    public Boolean creaReparacion(Reparacion rep) throws ExceptionErrorDataBase, AppException;
}
