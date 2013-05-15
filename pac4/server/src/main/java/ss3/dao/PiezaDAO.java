package ss3.dao;

import common.dao.GenericDao;
import java.util.ArrayList;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss2.exception.AppException;
import ss3.beans.Pieza;


/**
 * TDP Grup6
 * User: Fernando Gómez
 * Date: 13/05/13
 * Time: 21:23
 */
public interface PiezaDAO extends GenericDao{
    void checkAndInitDAO() throws AppException;
    public Pieza findByCodiPieza(Integer pCodiPieza) throws ExceptionErrorDataBase;
    public ArrayList<Pieza> findByDescripcion(String pDescripcion) throws ExceptionErrorDataBase;
}
