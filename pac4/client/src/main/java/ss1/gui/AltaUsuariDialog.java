package ss1.gui;

import common.entity.PerfilUsuari;
import common.utils.TDSLanguageUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 20/05/13
 * Time: 14:47
 */
public class AltaUsuariDialog extends JDialog {
    private String altaUsuariLabel = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.altaUsuariLabel");
    private String idLabel = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.idLabel");
    private String tallerLabel = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.tallerLabel");
    private String nifLabelTxt = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.nifLabel");
    private String nomLabelTxt = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.nomLabel");
    private String cognomLabelTxt = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.cognomLabel");
    private String usuariLabelTxt = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.usuariLabel");
    private String pwdLabel = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.pwdLabel");
    private String repitePwdLabel = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.repitePwdLabel");
    private String perfilLabelTxt = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.perfilLabel");
    private String actiuLabel = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.actiuLabel");
    private String okBtnLabel = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.okBtnLabel");
    private String calcelBtnLabel = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.cancelBtnLabel");

    private final JPanel contentPanel = new JPanel();
    private JTextField idTextField;
    private JTextField nifTextField;
    private JTextField nomTextField;
    private JTextField cognomTextField;
    private JTextField usuariTextField;
    private JTextField contrasenyaTextField;
    private JTextField repetirpwdTextField;
    private JLabel lblAltas;
    private JButton okButton;


    public AltaUsuariDialog() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(100, 100, 551, 426);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            lblAltas = new JLabel(altaUsuariLabel);
            lblAltas.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblAltas.setHorizontalAlignment(SwingConstants.CENTER);
            lblAltas.setBounds(172, 11, 190, 14);
            contentPanel.add(lblAltas);
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
            JLabel tallerLbl = new JLabel(tallerLabel);
            tallerLbl.setBounds(243, 150, 46, 14);
            contentPanel.add(tallerLbl);
        }
        {
            JLabel nifLabel = new JLabel(nifLabelTxt);
            nifLabel.setBounds(243, 45, 46, 14);
            contentPanel.add(nifLabel);
        }
        {
            nifTextField = new JTextField();
            nifTextField.setColumns(10);
            nifTextField.setBounds(377, 42, 86, 20);
            contentPanel.add(nifTextField);
        }
        {
            JLabel nomLabel = new JLabel(nomLabelTxt);
            nomLabel.setBounds(243, 79, 46, 14);
            contentPanel.add(nomLabel);
        }
        {
            nomTextField = new JTextField();
            nomTextField.setColumns(10);
            nomTextField.setBounds(377, 76, 86, 20);
            contentPanel.add(nomTextField);
        }
        {
            JLabel cognomLabel = new JLabel(cognomLabelTxt);
            cognomLabel.setBounds(243, 114, 46, 14);
            contentPanel.add(cognomLabel);
        }
        {
            cognomTextField = new JTextField();
            cognomTextField.setColumns(10);
            cognomTextField.setBounds(377, 111, 86, 20);
            contentPanel.add(cognomTextField);
        }
        {
            JLabel usuariLabel = new JLabel(usuariLabelTxt);
            usuariLabel.setBounds(42, 188, 46, 14);
            contentPanel.add(usuariLabel);
        }
        {
            usuariTextField = new JTextField();
            usuariTextField.setColumns(10);
            usuariTextField.setBounds(98, 185, 113, 20);
            contentPanel.add(usuariTextField);
        }
        {
            JComboBox tallerComboBox = new JComboBox();
            tallerComboBox.setModel(new DefaultComboBoxModel(new String[] {"-", "1", "2", "3", "4"}));
            tallerComboBox.setBounds(377, 147, 86, 20);
            contentPanel.add(tallerComboBox);
        }
        {
            JLabel contrasenyaLabel = new JLabel(pwdLabel);
            contrasenyaLabel.setBounds(243, 188, 73, 14);
            contentPanel.add(contrasenyaLabel);
        }
        {
            contrasenyaTextField = new JTextField();
            contrasenyaTextField.setColumns(10);
            contrasenyaTextField.setBounds(377, 185, 86, 20);
            contentPanel.add(contrasenyaTextField);
        }
        {
            JLabel perfilLabel = new JLabel(perfilLabelTxt);
            perfilLabel.setBounds(42, 222, 46, 14);
            contentPanel.add(perfilLabel);
        }
        {
            JComboBox perfilComboBox = new JComboBox();
            perfilComboBox.setModel(new DefaultComboBoxModel(PerfilUsuari.values()));
            perfilComboBox.setBounds(98, 219, 113, 20);
            contentPanel.add(perfilComboBox);
        }
        {
            JLabel repetirpwdLabel = new JLabel(repitePwdLabel);
            repetirpwdLabel.setBounds(243, 219, 113, 14);
            contentPanel.add(repetirpwdLabel);
        }
        {
            repetirpwdTextField = new JTextField();
            repetirpwdTextField.setColumns(10);
            repetirpwdTextField.setBounds(377, 216, 86, 20);
            contentPanel.add(repetirpwdTextField);
        }

        JCheckBox actiuCheckBox = new JCheckBox(actiuLabel);
        actiuCheckBox.setBounds(98, 256, 97, 23);
        contentPanel.add(actiuCheckBox);
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
                JButton cancelButton = new JButton(calcelBtnLabel);
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
    
    protected void updateTitle(String pNewTitle){
        lblAltas.setText(pNewTitle);
    }
    
    protected void updateOKButtonText(String pNewText){
        okButton.setText(pNewText);
    }

    protected void disableTextBoxes(){
        idTextField.setEnabled(false);
        idTextField.setEditable(false);
        nifTextField.setEnabled(false);
        nifTextField.setEditable(false);
        nomTextField.setEnabled(false);
        nomTextField.setEditable(false);
        cognomTextField.setEnabled(false);
        cognomTextField.setEditable(false);
        usuariTextField.setEnabled(false);
        usuariTextField.setEditable(false);
        contrasenyaTextField.setEnabled(false);
        contrasenyaTextField.setEditable(false);
        repetirpwdTextField.setEnabled(false);
        repetirpwdTextField.setEditable(false);
    }
}
