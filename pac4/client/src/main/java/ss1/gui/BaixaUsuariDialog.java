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
public class BaixaUsuariDialog extends AltaUsuariDialog {
    private String baixaUsuariLabel = TDSLanguageUtils.getMessage("gestioUsuari.baixaUsuariDialog.baixaUsuariLabel");
    private String okBtnLabel = TDSLanguageUtils.getMessage("gestioUsuari.baixaUsuariDialog.okBtnLabel");
    private Usuari usuari;
    public BaixaUsuariDialog(Client pClient, Usuari pUsuari) throws ExceptionErrorDataBase, RemoteException {
        super(pClient);
        usuari=pUsuari;
        setBaixaDialogProperties();
        disableTextBoxes();
    }


    private void setBaixaDialogProperties() {
        updateTitle(baixaUsuariLabel);
        updateOKButtonText(okBtnLabel);
    }
}
