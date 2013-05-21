package ss1.gui;

import common.utils.TDSLanguageUtils;
import ss1.entity.Taller;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 20/05/13
 * Time: 18:40
 */
public class ModificaTallerDialog extends AltaTallerDialog{
    private String modificaUsuariLabel = TDSLanguageUtils.getMessage("gestioTaller.modificaTallerDialog.modificaTallerLabel");
    private String okBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.modificaTallerDialog.okBtnLabel");
    private Taller taller;

    public ModificaTallerDialog(Taller pTaller) {
        super();
        this.taller = pTaller;
        setModificaDialogProperties();
    }

    private void setModificaDialogProperties() {
        updateTitle(modificaUsuariLabel);
        updateOKButtonText(okBtnLabel);
    }
}
