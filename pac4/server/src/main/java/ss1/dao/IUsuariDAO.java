package ss1.dao;

import common.dao.GenericDao;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.entity.Usuari;
import ss1.service.filter.FilterItems;

import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 8/05/13
 * Time: 21:25
 */
public interface IUsuariDAO extends GenericDao {
    List<Usuari> findAll() throws ExceptionErrorDataBase;

    Usuari findByPK(Integer pUsuariId) throws ExceptionErrorDataBase;

    Usuari findByUsuariLogin(String pUsuariLogin) throws ExceptionErrorDataBase;

    void createUsuari(Usuari pUsuari) throws ExceptionErrorDataBase;

    void deleteUsuari(Usuari pUsuari) throws ExceptionErrorDataBase;

    void modifyUsuari(Usuari pUsuari) throws ExceptionErrorDataBase;

    List<Usuari> findUsuariByFilter(FilterItems pUsuariFilter) throws ExceptionTipoObjetoFiltroNoPermitido, ExceptionErrorDataBase;
}
