package ss1.server;

import ss1.dao.exception.ExceptionContrasenyaIncorrecta;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.dao.exception.ExceptionUsuariNoExisteix;
import ss1.entity.Taller;
import ss1.entity.Usuari;
import ss1.service.filter.FilterItems;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 12/05/13
 * Time: 13:13
 */
public interface ISS1ConexioManteniment extends Remote {
    public Usuari usuariLogin(String pUsuariLogin, String pContrasenya) throws ExceptionContrasenyaIncorrecta, ExceptionErrorDataBase, ExceptionUsuariNoExisteix, RemoteException;
    
    public Usuari usuariLoginWithChangePassword(String pUsuariLogin, String pOldContrasenya, String pNewContrasenya) throws ExceptionContrasenyaIncorrecta, ExceptionUsuariNoExisteix, ExceptionErrorDataBase, RemoteException;
    
    public List<Usuari> getAllUsuaris() throws ExceptionErrorDataBase, RemoteException;
    
    public List<Usuari> getAllUsuarisByFilter(FilterItems pFilterItems) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido, RemoteException;
    
    public void altaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase, RemoteException;
    
    public void baixaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase, RemoteException;
    
    public void modificaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase, RemoteException;

    public List<Taller> getAllTallers() throws ExceptionErrorDataBase, RemoteException;

    public List<Taller> getAllTallerByFilter(FilterItems pFilterItems) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido, RemoteException;

    public void altaTaller(Taller pTaller) throws ExceptionErrorDataBase, RemoteException;

    public void baixaTaller(Taller pTaller) throws ExceptionErrorDataBase, RemoteException;

    public void modificaTaller(Taller pTaller) throws ExceptionErrorDataBase, RemoteException;
    
    public Taller getTallerById(Integer pId) throws ExceptionErrorDataBase, RemoteException;

    public Usuari findUsuariByPK(Integer pId) throws ExceptionErrorDataBase, RemoteException;

    public List<Usuari> getAllCapsTaller() throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido, RemoteException;
}
