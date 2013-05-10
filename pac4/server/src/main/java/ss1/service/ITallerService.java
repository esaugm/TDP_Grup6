package ss1.service;

import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.entity.Taller;
import ss1.service.filter.FilterItems;

import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 18:56
 */
public interface ITallerService {
    public Taller findTallerByID(Integer pId) throws ExceptionErrorDataBase;

    public void altaTaller(Taller pUsuari) throws ExceptionErrorDataBase;

    public void baixaTaller(Taller pUsuari) throws ExceptionErrorDataBase;

    public void modificaTaller(Taller pUsuari) throws ExceptionErrorDataBase;

    public void deleteTaller(Taller pTaller) throws ExceptionErrorDataBase;

    public List<Taller> findAllTaller() throws ExceptionErrorDataBase;

    public List<Taller> findAllTallerByTallerFilter(FilterItems pUsuariFilter) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido;


}
