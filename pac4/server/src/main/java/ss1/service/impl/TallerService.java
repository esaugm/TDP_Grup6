package ss1.service.impl;

import ss1.dao.ITallerDAO;
import ss1.dao.exception.ExceptionErrorDataBase;
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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Taller findUsuariByUsuariLogin(String pUsuariLogin) throws ExceptionErrorDataBase {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void altaTaller(Taller pUsuari) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void baixaTaller(Taller pUsuari) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void modificaTaller(Taller pUsuari) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Taller> findAllTaller() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Taller> findAllTallerByTallerFilter(FilterItems pUsuariFilter) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
