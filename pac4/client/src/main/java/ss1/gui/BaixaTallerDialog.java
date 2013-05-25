package ss1.gui;

import common.rmi.Client;
import common.utils.TDSLanguageUtils;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.entity.Taller;

import java.rmi.RemoteException;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 20/05/13
 * Time: 18:40
 */
public class BaixaTallerDialog extends AltaTallerDialog{
    private String baixaTallerLabel = TDSLanguageUtils.getMessage("gestioTaller.baixaTallerDialog.baixaTallerLabel");
    private String okBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.baixaTallerDialog.okBtnLabel");
    private Taller taller;
    public BaixaTallerDialog(Taller pTaller, Client pClient) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido, RemoteException {
        super(pClient);
        taller=pTaller;
        setBaixaDialogProperties();
        disableTextBoxes();
    }


    private void setBaixaDialogProperties() {
        updateTitle(baixaTallerLabel);
        updateOKButtonText(okBtnLabel);
    }
}
