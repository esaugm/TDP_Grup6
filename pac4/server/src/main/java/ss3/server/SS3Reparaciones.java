/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.server;

import ss1.dao.exception.ExceptionErrorDataBase;
import ss2.exception.AppException;
import ss3.beans.Pieza;
import ss3.beans.Reparacion;
import ss3.beans.Vehiculo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

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

    public Reparacion ConsultaOrden(Integer OrdenID) throws ExceptionErrorDataBase, RemoteException;
    public ArrayList<Reparacion> ConsultaTodas() throws ExceptionErrorDataBase, RemoteException;
    public ArrayList<Reparacion> ConsultaFechaAsig(String fechaAsig) throws ExceptionErrorDataBase, RemoteException;
    public ArrayList<Reparacion> ConsultaFechaIni(String fechaIni) throws ExceptionErrorDataBase, RemoteException;
    public ArrayList<Reparacion> ConsultaFechaFin(String fechaFin) throws ExceptionErrorDataBase, RemoteException;
    public ArrayList<Reparacion> ConsultaAceptadas(Boolean aceptada) throws ExceptionErrorDataBase, RemoteException;
    public ArrayList<Reparacion> ConsultaAsignadas(Boolean asignada) throws ExceptionErrorDataBase, RemoteException;
    public ArrayList<Reparacion> ConsultaAsigMecanico(Integer idMecanico) throws ExceptionErrorDataBase, RemoteException;
    public Boolean anotaObs(Integer orden, String observaciones) throws ExceptionErrorDataBase, RemoteException;
    public Boolean asignaAMec(Integer orden, Integer idMecanico) throws ExceptionErrorDataBase, RemoteException;
    public Pieza ConsultaCodigo(Integer codigo) throws ExceptionErrorDataBase, RemoteException;
    public Pieza ConsultaPorOrden(Integer orden) throws ExceptionErrorDataBase, RemoteException;
    public ArrayList<Pieza> ConsultaPiezas() throws ExceptionErrorDataBase, RemoteException;
    public ArrayList<Pieza> ConsultaDescripcion(String descripcion) throws ExceptionErrorDataBase, RemoteException;
    public Vehiculo ConsultaChasis(String numChasis) throws ExceptionErrorDataBase, RemoteException;
    public ArrayList<Vehiculo> ConsultaMarca(String marca) throws ExceptionErrorDataBase, RemoteException;
    public Vehiculo ConsultaMatricula(String matricula) throws ExceptionErrorDataBase, RemoteException;
    public ArrayList<Vehiculo> ConsultaModelo(String modelo) throws ExceptionErrorDataBase, RemoteException;
    public Vehiculo ConsultaReparacion(Integer orden) throws ExceptionErrorDataBase, RemoteException;
    public Boolean creaReparacion(Reparacion rep) throws ExceptionErrorDataBase, AppException, RemoteException;
    public ArrayList<Reparacion> findReparacionesByTerms(Map values) throws ExceptionErrorDataBase, RemoteException;
    public Boolean aceptaReparacion(Integer orden) throws ExceptionErrorDataBase, RemoteException;
}
