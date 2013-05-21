package ss1.gui;

import common.rmi.Client;
import common.utils.TDSLanguageUtils;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Usuari;

import java.rmi.RemoteException;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 20/05/13
 * Time: 15:07
 */
public class ModificaUsuariDialog extends AltaUsuariDialog {
    private String modificaUsuariLabel = TDSLanguageUtils.getMessage("gestioUsuari.modificaUsuariDialog.modificaUsuariLabel");
    private String okBtnLabel = TDSLanguageUtils.getMessage("gestioUsuari.modificaUsuariDialog.okBtnLabel");
    private Usuari usuari;

    public ModificaUsuariDialog(Client pClient, Usuari usuari) throws ExceptionErrorDataBase, RemoteException {
        super(pClient);
        this.usuari = usuari;
        setModificaDialogProperties();
    }

    private void setModificaDialogProperties() {
        updateTitle(modificaUsuariLabel);
        updateOKButtonText(okBtnLabel);
    }
}
