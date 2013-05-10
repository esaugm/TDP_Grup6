package ss1.dao;

import common.dao.GenericDao;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.entity.Taller;
import ss1.service.filter.FilterItems;

import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 8/05/13
 * Time: 21:23
 */
public interface ITallerDAO extends GenericDao{

    List<Taller> findAll() throws ExceptionErrorDataBase;

    void createTaller(Taller pTaller) throws ExceptionErrorDataBase;

    void deleteTaller(Taller pTaller) throws ExceptionErrorDataBase;

    void baixaTaller(Taller pTaller) throws ExceptionErrorDataBase;

    void modifyTaller(Taller pTaller) throws ExceptionErrorDataBase;

    List<Taller> findTallerByFilter(FilterItems pTallerFilter) throws ExceptionTipoObjetoFiltroNoPermitido, ExceptionErrorDataBase;

    Taller findByPK(Integer pTallerId) throws ExceptionErrorDataBase;
}
