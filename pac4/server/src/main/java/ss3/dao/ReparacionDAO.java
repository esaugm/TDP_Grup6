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
    public Reparacion findByPK(Integer pOrdenReparacion) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> findByDataAssignacio(String pDataAssignacio) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> findByDataInici(String pDataInici) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> findByDataFi(String pDataFi) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> findByAceptada(Boolean aceptada) throws ExceptionErrorDataBase;
    public ArrayList<Reparacion> findByAsignada(Boolean asignada) throws ExceptionErrorDataBase;
}
