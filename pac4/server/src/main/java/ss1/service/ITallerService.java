package ss1.service;

import ss1.dao.exception.ExceptionErrorDataBase;
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

    public Taller findUsuariByUsuariLogin(String pUsuariLogin) throws ExceptionErrorDataBase;

    public void altaTaller(Taller pUsuari);

    public void baixaTaller(Taller pUsuari);

    public void modificaTaller(Taller pUsuari);

    public List<Taller> findAllTaller();

    public List<Taller> findAllTallerByTallerFilter(FilterItems pUsuariFilter);


}
