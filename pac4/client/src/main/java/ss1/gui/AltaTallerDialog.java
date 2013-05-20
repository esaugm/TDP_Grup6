package ss1.gui;

import common.utils.TDSLanguageUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 20/05/13
 * Time: 18:20
 */
public class AltaTallerDialog extends JDialog{

    private String altaTallerLabel = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.altaTallerLabel");
    private String idLabel = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.idLabel");
    private String jefeTallerLabel = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.jefeTallerLabel");
    private String cifLabelTxt = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.cifLabel");
    private String nomLabelTxt = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.nomLabel");
    private String adrecaLabelTxt = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.adrecaLabel");
    private String fechasLabelTxt = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.fechasLabel");
    private String telefonLabel = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.telefonLabel");
    private String webLabelTxt = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.webLabel");
    private String capacidadLabelTxt = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.capacidadLabel");
    private String actiuLabel = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.actiuLabel");
    private String fechaAltaLabel = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.fechaAltaLabel");
    private String fechaBaixaLabel = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.fechaBajaLabel");
    private String fechaModifLabel = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.fechaModificacionLabel");
    private String okBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.okBtnLabel");
    private String cancelBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.altaTallerDialog.cancelBtnLabel");

    private final JPanel contentPanel = new JPanel();
    private JTextField idTextField;
    private JTextField cifTextField;
    private JTextField nomTextField;
    private JTextField adrecaTextField;
    private JTextField fechaAltaText;
    private JTextField telefonoTextField;
    private JTextField webTextField;
    private JTextField capacitatTextField;
    private JTextField fechaModifTextField;
    private JTextField fechaBajaTextField;
    private JLabel lblAltaTaller;
    private JButton okButton;


    public AltaTallerDialog() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(100, 100, 551, 442);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            lblAltaTaller = new JLabel(altaTallerLabel);
            lblAltaTaller.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblAltaTaller.setHorizontalAlignment(SwingConstants.CENTER);
            lblAltaTaller.setBounds(172, 11, 190, 14);
            contentPanel.add(lblAltaTaller);
        }
        {
            JLabel lblId = new JLabel(idLabel);
            lblId.setBounds(42, 48, 46, 14);
            contentPanel.add(lblId);
        }
        {
            idTextField = new JTextField();
            idTextField.setEnabled(false);
            idTextField.setEditable(false);
            idTextField.setBounds(98, 45, 113, 20);
            contentPanel.add(idTextField);
            idTextField.setColumns(10);
        }
        {
            JLabel capTallerLbl = new JLabel(jefeTallerLabel);
            capTallerLbl.setBounds(243, 157, 73, 14);
            contentPanel.add(capTallerLbl);
        }
        {
            JLabel cifLabel = new JLabel(cifLabelTxt);
            cifLabel.setBounds(243, 45, 73, 14);
            contentPanel.add(cifLabel);
        }
        {
            cifTextField = new JTextField();
            cifTextField.setColumns(10);
            cifTextField.setBounds(377, 42, 86, 20);
            contentPanel.add(cifTextField);
        }
        {
            JLabel nomLabel = new JLabel(nomLabelTxt);
            nomLabel.setBounds(243, 73, 73, 14);
            contentPanel.add(nomLabel);
        }
        {
            nomTextField = new JTextField();
            nomTextField.setColumns(10);
            nomTextField.setBounds(377, 70, 86, 20);
            contentPanel.add(nomTextField);
        }
        {
            JLabel adrecaLabel = new JLabel(adrecaLabelTxt);
            adrecaLabel.setBounds(243, 101, 73, 14);
            contentPanel.add(adrecaLabel);
        }
        {
            adrecaTextField = new JTextField();
            adrecaTextField.setColumns(10);
            adrecaTextField.setBounds(377, 98, 86, 20);
            contentPanel.add(adrecaTextField);
        }
        {
            JLabel fechasLabel = new JLabel(fechasLabelTxt);
            fechasLabel.setBounds(42, 260, 46, 14);
            contentPanel.add(fechasLabel);
        }
        {
            fechaAltaText = new JTextField();
            fechaAltaText.setColumns(10);
            fechaAltaText.setBounds(203, 257, 113, 20);
            contentPanel.add(fechaAltaText);
        }
        {
            JComboBox tallerComboBox = new JComboBox();
            tallerComboBox.setModel(new DefaultComboBoxModel(new String[] {"-", "1", "2", "3", "4"}));
            tallerComboBox.setBounds(377, 154, 86, 20);
            contentPanel.add(tallerComboBox);
        }
        {
            JLabel telefonoLabel = new JLabel(telefonLabel);
            telefonoLabel.setBounds(243, 188, 73, 14);
            contentPanel.add(telefonoLabel);
        }
        {
            telefonoTextField = new JTextField();
            telefonoTextField.setColumns(10);
            telefonoTextField.setBounds(377, 185, 86, 20);
            contentPanel.add(telefonoTextField);
        }
        {
            JLabel webLabel = new JLabel(webLabelTxt);
            webLabel.setBounds(243, 219, 113, 14);
            contentPanel.add(webLabel);
        }
        {
            webTextField = new JTextField();
            webTextField.setColumns(10);
            webTextField.setBounds(377, 216, 86, 20);
            contentPanel.add(webTextField);
        }

        JCheckBox actiuCheckBox = new JCheckBox(actiuLabel);
        actiuCheckBox.setBounds(377, 253, 97, 23);
        contentPanel.add(actiuCheckBox);
        {
            JLabel capacitatLabel = new JLabel(capacidadLabelTxt);
            capacitatLabel.setBounds(243, 129, 73, 14);
            contentPanel.add(capacitatLabel);
        }
        {
            capacitatTextField = new JTextField();
            capacitatTextField.setColumns(10);
            capacitatTextField.setBounds(377, 126, 86, 20);
            contentPanel.add(capacitatTextField);
        }
        {
            JLabel altaLabel = new JLabel(fechaAltaLabel);
            altaLabel.setBounds(135, 260, 46, 14);
            contentPanel.add(altaLabel);
        }
        {
            JLabel modificacioLabel = new JLabel(fechaModifLabel);
            modificacioLabel.setBounds(135, 288, 58, 14);
            contentPanel.add(modificacioLabel);
        }
        {
            fechaModifTextField = new JTextField();
            fechaModifTextField.setColumns(10);
            fechaModifTextField.setBounds(203, 285, 113, 20);
            contentPanel.add(fechaModifTextField);
        }
        {
            JLabel baixaLabel = new JLabel(fechaBaixaLabel);
            baixaLabel.setBounds(135, 316, 46, 14);
            contentPanel.add(baixaLabel);
        }
        {
            fechaBajaTextField = new JTextField();
            fechaBajaTextField.setColumns(10);
            fechaBajaTextField.setBounds(203, 313, 113, 20);
            contentPanel.add(fechaBajaTextField);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                okButton = new JButton(okBtnLabel);
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton(cancelBtnLabel);
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    protected void updateTitle(String pNewTitle){
        lblAltaTaller.setText(pNewTitle);
    }

    protected void updateOKButtonText(String pNewText){
        okButton.setText(pNewText);
    }

    protected void disableTextBoxes(){
        idTextField.setEnabled(false);
        idTextField.setEditable(false);
        cifTextField.setEnabled(false);
        cifTextField.setEditable(false);
        nomTextField.setEnabled(false);
        nomTextField.setEditable(false);
        adrecaTextField.setEnabled(false);
        adrecaTextField.setEditable(false);
        fechaAltaText.setEnabled(false);
        fechaAltaText.setEditable(false);
        telefonoTextField.setEnabled(false);
        telefonoTextField.setEditable(false);
        webTextField.setEnabled(false);
        webTextField.setEditable(false);
        capacitatTextField.setEnabled(false);
        capacitatTextField.setEditable(false);
        fechaModifTextField.setEnabled(false);
        fechaModifTextField.setEditable(false);
        fechaBajaTextField.setEnabled(false);
        fechaBajaTextField.setEditable(false);

    }
}
