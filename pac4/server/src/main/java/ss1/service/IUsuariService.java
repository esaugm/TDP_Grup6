package ss1.service;

import ss1.dao.exception.ExceptionContrasenyaIncorrecta;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.dao.exception.ExceptionUsuariNoExisteix;
import ss1.entity.Usuari;
import ss1.service.filter.FilterItems;

import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 18:54
 */
public interface IUsuariService {

    public Usuari findUsuariByID(Integer pId) throws ExceptionErrorDataBase;

    public Usuari findUsuariByUsuariLogin(String pUsuariLogin) throws ExceptionErrorDataBase, ExceptionUsuariNoExisteix;

    public void altaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase;

    public void baixaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase;

    public void modificaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase;

    public void changePassword(ChangePasswordItem pChangePasswordItem) throws ExceptionErrorDataBase, ExceptionContrasenyaIncorrecta;

    public List<Usuari> findAllUsuari() throws ExceptionErrorDataBase;

    public List<Usuari> findAllUsuariByUsuariFilter(FilterItems pUsuariFilter) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido;

}
