package ss3.dao;

import ss3.dao.*;
import common.dao.GenericDao;
import java.sql.Date;
import java.util.ArrayList;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss3.beans.Reparacion;


/**
 * TDP Grup6
 * User: Esaú González
 * Date: 8/05/13
 * Time: 21:23
 */
public interface ReparacionDAO extends GenericDao{
    Reparacion findByPK(Integer pOrdenReparacion) throws ExceptionErrorDataBase;
    ArrayList<Reparacion> findByDataAssignacio(String pDataAssignacio) throws ExceptionErrorDataBase;
    ArrayList<Reparacion> findByDataInici(String pDataInici) throws ExceptionErrorDataBase;
    ArrayList<Reparacion> findByDataFi(String pDataFi) throws ExceptionErrorDataBase;
}
