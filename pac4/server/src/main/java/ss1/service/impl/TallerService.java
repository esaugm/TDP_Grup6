package ss1.service.impl;

import ss1.dao.ITallerDAO;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.dao.impl.TallerDAO;
import ss1.entity.Taller;
import ss1.service.ITallerService;
import ss1.service.filter.FilterItems;

import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 18:07
 */
public class TallerService implements ITallerService {

    private ITallerDAO tallerDAO;

    public TallerService() {
        this.tallerDAO = new TallerDAO();
    }

    public Taller findTallerById(Integer pTallerId) throws ExceptionErrorDataBase {
        return tallerDAO.findByPK(pTallerId);
    }

    @Override
    public Taller findTallerByID(Integer pId) throws ExceptionErrorDataBase {
        return tallerDAO.findByPK(pId);
    }

    @Override
    public void altaTaller(Taller pTaller) throws ExceptionErrorDataBase {
        tallerDAO.createTaller(pTaller);
    }

    @Override
    public void baixaTaller(Taller pTaller) throws ExceptionErrorDataBase {
        tallerDAO.baixaTaller(pTaller);
    }

    @Override
    public void modificaTaller(Taller pTaller) throws ExceptionErrorDataBase {
        tallerDAO.modifyTaller(pTaller);
    }

    @Override
    public void deleteTaller(Taller pTaller) throws ExceptionErrorDataBase {
        tallerDAO.deleteTaller(pTaller);
    }

    @Override
    public List<Taller> findAllTaller() throws ExceptionErrorDataBase {
        return tallerDAO.findAll();
    }

    @Override
    public List<Taller> findAllTallerByTallerFilter(FilterItems pTallerFilter) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido {
        return tallerDAO.findTallerByFilter(pTallerFilter);
    }
}
