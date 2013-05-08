package ss1.dao;

import common.dao.GenericDao;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Taller;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 8/05/13
 * Time: 21:23
 */
public interface ITallerDAO extends GenericDao{
    Taller findByPK(Integer pTallerId) throws ExceptionErrorDataBase;
}
