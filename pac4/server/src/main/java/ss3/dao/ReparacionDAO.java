package ss3.dao;

import common.dao.GenericDao;
import java.util.ArrayList;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss3.beans.Reparacion;


/**
 * TDP Grup6
 * User: Fernando Gómez
 * Date: 13/05/13
 * Time: 21:23
 */
public interface ReparacionDAO extends GenericDao{
    Reparacion findByPK(Integer pOrdenReparacion) throws ExceptionErrorDataBase;
    ArrayList<Reparacion> findByDataAssignacio(String pDataAssignacio) throws ExceptionErrorDataBase;
    ArrayList<Reparacion> findByDataInici(String pDataInici) throws ExceptionErrorDataBase;
    ArrayList<Reparacion> findByDataFi(String pDataFi) throws ExceptionErrorDataBase;
    ArrayList<Reparacion> findByAceptada(Boolean aceptada) throws ExceptionErrorDataBase;
    ArrayList<Reparacion> findByAsignada(Boolean asignada) throws ExceptionErrorDataBase;
}
