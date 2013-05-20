package ss1.gui;

import common.utils.TDSLanguageUtils;
import ss1.entity.Taller;

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
    public BaixaTallerDialog(Taller pTaller) {
        super();
        taller=pTaller;
        setBaixaDialogProperties();
        disableTextBoxes();
    }


    private void setBaixaDialogProperties() {
        updateTitle(baixaTallerLabel);
        updateOKButtonText(okBtnLabel);
    }
}
