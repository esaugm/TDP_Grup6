package ss1.service;

import ss1.dao.UsuariDAO;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Usuari;
import ss1.service.filter.FilterItem;

import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 17:35
 */
public class UsuariService implements IUsuariService{
    
    private UsuariDAO usuariDAO;

    public UsuariService() {
        this.usuariDAO = new UsuariDAO();
    }
    
    public Usuari findUsuariByID(Integer pId) throws ExceptionErrorDataBase {
    return usuariDAO.findByPK(pId);
}

    public Usuari findUsuariByUsuariLogin(String pUsuariLogin) throws ExceptionErrorDataBase {
        return usuariDAO.findByUsuariLogin(pUsuariLogin);
    }

    public void altaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase {
        usuariDAO.createUsuari(pUsuari);
    }

    public void baixaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase {
        usuariDAO.deleteUsuari(pUsuari);
    }

    public void modificaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase {
        usuariDAO.modifyUsuari(pUsuari);
    }

    public void changePassword(ChangePasswordItem pChangePasswordItem){
        //todo implement it!
    }

    public List<Usuari> findAllUsuari(){
        //todo implement it!
        return null;
    }

    public List<Usuari> findAllUsuariByUsuariFilter(FilterItem pUsuariFilter){
        //todo implement it!
        return null;
    }

    public Integer getIdForNewUsuari(){
        //todo implement it!
        //todo ESAU: creo que no es seguro pedir el nuevo id a la sequencia de BD antes de persistir el nuevo Usuari
        //todo ESAU: (pueden abortar el alta a medias y quedaran id's vacios que no se podrán recuperar)
        return null;
    }
}
