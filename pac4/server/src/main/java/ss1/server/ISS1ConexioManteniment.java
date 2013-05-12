package ss1.server;

import ss1.dao.exception.ExceptionContrasenyaIncorrecta;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.dao.exception.ExceptionUsuariNoExisteix;
import ss1.entity.Taller;
import ss1.entity.Usuari;
import ss1.service.filter.FilterItems;

import java.rmi.Remote;
import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 12/05/13
 * Time: 13:13
 */
public interface ISS1ConexioManteniment extends Remote {
    public Usuari usuariLogin(String pUsuariLogin, String pContrasenya) throws ExceptionContrasenyaIncorrecta, ExceptionErrorDataBase, ExceptionUsuariNoExisteix;
    
    public Usuari usuariLoginWithChangePassword(String pUsuariLogin, String pOldContrasenya, String pNewContrasenya) throws ExceptionContrasenyaIncorrecta, ExceptionUsuariNoExisteix, ExceptionErrorDataBase;
    
    public List<Usuari> getAllUsuaris() throws ExceptionErrorDataBase;
    
    public List<Usuari> getAllUsuarisByFilter(FilterItems pFilterItems) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido;
    
    public void altaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase;
    
    public void baixaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase;
    
    public void modificaUsuari(Usuari pUsuari) throws ExceptionErrorDataBase;

    public List<Taller> getAllTallers() throws ExceptionErrorDataBase;

    public List<Taller> getAllTallerByFilter(FilterItems pFilterItems) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido;

    public void altaTaller(Taller pTaller) throws ExceptionErrorDataBase;

    public void baixaTaller(Taller pTaller) throws ExceptionErrorDataBase;

    public void modificaTaller(Taller pTaller) throws ExceptionErrorDataBase;


}
