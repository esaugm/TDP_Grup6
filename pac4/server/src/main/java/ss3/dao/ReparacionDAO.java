package ss3.dao;

import common.dao.GenericDao;
import java.util.ArrayList;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss2.exception.AppException;
import ss3.beans.Reparacion;


/**
 * TDP Grup6
 * User: Fernando Gómez
 * Date: 13/05/13
 * Time: 21:23
 */


public interface ReparacionDAO extends GenericDao{
    public void checkAndInitDAO() throws AppException;
    public Reparacion findByPK(Integer pOrdenReparacion) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> findByDataAssignacio(String pDataAssignacio) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> findByDataInici(String pDataInici) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> findByDataFi(String pDataFi) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> findByAceptada(Boolean aceptada) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> findByAsignada(Boolean asignada) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> findByIdMecanico(Integer idMecanico) throws ExceptionErrorDataBase;
    /*public Boolean asignaAJefeTaller(Integer orden, Integer idJefeTaller) throws ExceptionErrorDataBase;
    public Boolean aceptaReparacion(Integer orden) throws ExceptionErrorDataBase;*/
    public Boolean anotaObservacion(Integer orden, String observaciones) throws ExceptionErrorDataBase;
    public Boolean asignaAMecanico(Integer orden, Integer idMecanico) throws ExceptionErrorDataBase;
    public Boolean createReparacion(Reparacion rep) throws ExceptionErrorDataBase, AppException;
}
