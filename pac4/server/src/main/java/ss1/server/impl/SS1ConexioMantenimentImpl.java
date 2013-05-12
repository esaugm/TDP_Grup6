package ss1.server.impl;

import ss1.dao.exception.ExceptionContrasenyaIncorrecta;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.dao.exception.ExceptionUsuariNoExisteix;
import ss1.entity.Taller;
import ss1.entity.Usuari;
import ss1.server.ISS1ConexioManteniment;
import ss1.service.ChangePasswordItem;
import ss1.service.filter.FilterItems;
import ss1.service.impl.TallerService;
import ss1.service.impl.UsuariService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 12/05/13
 * Time: 13:20
 */
public class SS1ConexioMantenimentImpl extends UnicastRemoteObject implements ISS1ConexioManteniment,Serializable {
    private static final long serialVersionUID = 1L;
    private UsuariService usuariService;
    private TallerService tallerService;

    protected SS1ConexioMantenimentImpl() throws RemoteException {
        super();
        usuariService = new UsuariService();
        tallerService = new TallerService();
    }

    @Override
    public Usuari usuariLogin(String pUsuariLogin, String pContrasenya) throws ExceptionContrasenyaIncorrecta, ExceptionErrorDataBase, ExceptionUsuariNoExisteix {
        Usuari toReturn = usuariService.findUsuariByUsuariLogin(pUsuariLogin);
        if (toReturn!=null && toReturn.getContrasenya().equals(pContrasenya)){
            return toReturn;
        } else throw new ExceptionContrasenyaIncorrecta("Error de contrasenya incorrecta");
    }

    @Override
    public Usuari usuariLoginWithChangePassword(String pUsuariLogin, String pOldContrasenya, String pNewContrasenya) throws ExceptionContrasenyaIncorrecta, ExceptionUsuariNoExisteix, ExceptionErrorDataBase {
        Usuari oldUsuari = usuariService.findUsuariByUsuariLogin(pUsuariLogin);
        ChangePasswordItem changePasswordItem = new ChangePasswordItem(oldUsuari,pOldContrasenya,pNewContrasenya);
        usuariService.changePassword(changePasswordItem);
        return changePasswordItem.getUsuariWithNewPassword();
    }

    @Override
    public List<Usuari> getAllUsuaris() throws ExceptionErrorDataBase {
        return usuariService.findAllUsuari();
    }

    @Override
    public List<Usuari> getAllUsuarisByFilter(FilterItems pFilterItems) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido {
        return usuariService.findAllUsuariByUsuariFilter(pFilterItems);
    }

    @Override
    public void altaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase {
        usuariService.altaUsuari(pUsuari);
    }

    @Override
    public void baixaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase {
        usuariService.baixaUsuari(pUsuari);
    }

    @Override
    public void modificaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase {
        usuariService.modificaUsuari(pUsuari);
    }

    @Override
    public List<Taller> getAllTallers() throws ExceptionErrorDataBase {
        return tallerService.findAllTaller();
    }

    @Override
    public List<Taller> getAllTallerByFilter(FilterItems pFilterItems) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido {
        return tallerService.findAllTallerByTallerFilter(pFilterItems);
    }

    @Override
    public void altaTaller(Taller pTaller) throws ExceptionErrorDataBase {
        tallerService.altaTaller(pTaller);
    }

    @Override
    public void baixaTaller(Taller pTaller) throws ExceptionErrorDataBase {
        tallerService.baixaTaller(pTaller);
    }

    @Override
    public void modificaTaller(Taller pTaller) throws ExceptionErrorDataBase {
        tallerService.modificaTaller(pTaller);
    }
}
