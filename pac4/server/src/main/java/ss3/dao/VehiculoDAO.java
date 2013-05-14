package ss3.dao;

import common.dao.GenericDao;
import java.util.ArrayList;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss3.beans.Vehiculo;


/**
 * TDP Grup6
 * User: Fernando Gómez
 * Date: 13/05/13
 * Time: 19:00
 */
public interface VehiculoDAO extends GenericDao{
    public Vehiculo findByChasis(String pChasis) throws ExceptionErrorDataBase;
    public ArrayList<Vehiculo> findByMarca(String pMarca) throws ExceptionErrorDataBase;
    public ArrayList<Vehiculo> findByMatricula(String pMatricula) throws ExceptionErrorDataBase;
    public ArrayList<Vehiculo> findByModelo(String pModelo) throws ExceptionErrorDataBase;
    public ArrayList<Vehiculo> findByOrden(Integer pOrden) throws ExceptionErrorDataBase;

}
