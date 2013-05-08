package ss1.service.impl;

import ss1.dao.IUsuariDAO;
import ss1.dao.exception.ExceptionContrasenyaIncorrecta;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.dao.impl.UsuariDAO;
import ss1.entity.Usuari;
import ss1.service.ChangePasswordItem;
import ss1.service.IUsuariService;
import ss1.service.filter.FilterItems;

import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 17:35
 */
public class UsuariService implements IUsuariService {
    
    private IUsuariDAO usuariDAO;

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

    public void changePassword(ChangePasswordItem pChangePasswordItem) throws ExceptionErrorDataBase, ExceptionContrasenyaIncorrecta {
        if (oldPasswordCorrect(pChangePasswordItem)){
            Usuari usuari = pChangePasswordItem.getUsuari();
            usuari.setContrasenya(pChangePasswordItem.getNewPassword());
            usuariDAO.modifyUsuari(usuari);
        } else {
            throw new ExceptionContrasenyaIncorrecta("Error contrasenya incorrecta");

        }
    }

    private boolean oldPasswordCorrect(ChangePasswordItem pChangePasswordItem) throws ExceptionErrorDataBase {
        Usuari usuariPersisted = usuariDAO.findByPK(pChangePasswordItem.getUsuari().getId());
        return usuariPersisted.getContrasenya().equals(pChangePasswordItem.getOldPassword());
    }

    public List<Usuari> findAllUsuari() throws ExceptionErrorDataBase {
        return usuariDAO.findAll();
    }

    public List<Usuari> findAllUsuariByUsuariFilter(FilterItems pUsuariFilter) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido {
        return usuariDAO.findUsuariByFilter(pUsuariFilter);
    }

    public Integer getIdForNewUsuari(){
        //todo implement it!
        //todo ESAU: creo que no es seguro pedir el nuevo id a la sequencia de BD antes de persistir el nuevo Usuari
        //todo ESAU: (pueden abortar el alta a medias y quedaran id's vacios que no se podrán recuperar)
        return null;
    }
}
