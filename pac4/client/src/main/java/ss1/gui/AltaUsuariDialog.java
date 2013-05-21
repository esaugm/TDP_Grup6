package ss1.gui;

import common.entity.PerfilUsuari;
import common.rmi.Client;
import common.utils.TDSLanguageUtils;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Taller;
import ss1.entity.Usuari;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 20/05/13
 * Time: 14:47
 */
public class AltaUsuariDialog extends JDialog {
    private Client client;
    private String altaUsuariLabel = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.altaUsuariLabel");
    private String idLabel = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.idLabel");
    private String tallerLabel = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.tallerLabel");
    private String nifLabelTxt = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.nifLabel");
    private String nomLabelTxt = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.nomLabel");
    private String adrecaLabellTxt = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.adrecaLabel");
    private String poblacioLabelTxt = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.poblacioLabel");
    private String zipLabelTxt = TDSLanguageUtils.getMessage("gestioUsuari.altaUsuariDialog.zipLabel");
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
    private JTextField adrecaTextField;
    private JTextField poblacioTextField;
    private JTextField zipTextField;
    private JTextField usuariTextField;
    private JTextField contrasenyaTextField;
    private JTextField repetirpwdTextField;
    private JCheckBox actiuCheckBox;
    private JComboBox perfilComboBox;
    private JComboBox tallerComboBox;
    private JLabel lblAltas;
    private JButton okButton;


    public AltaUsuariDialog(Client pClient) throws ExceptionErrorDataBase, RemoteException {
        client = pClient;
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(100, 100, 551, 477);
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
            tallerLbl.setBounds(243, 257, 46, 14);
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
            nifTextField.setBounds(346, 42, 162, 20);
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
            nomTextField.setBounds(346, 76, 162, 20);
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
            cognomTextField.setBounds(346, 111, 162, 20);
            contentPanel.add(cognomTextField);
        }
        {
            JLabel adrecaLabel = new JLabel(adrecaLabellTxt);
            adrecaLabel.setBounds(243, 151, 46, 14);
            contentPanel.add(adrecaLabel);
        }
        {
            adrecaTextField = new JTextField();
            adrecaTextField.setColumns(10);
            adrecaTextField.setBounds(346, 148, 162, 20);
            contentPanel.add(adrecaTextField);
        }
        {
            JLabel poblacioLabel = new JLabel(poblacioLabelTxt);
            poblacioLabel.setBounds(243, 188, 46, 14);
            contentPanel.add(poblacioLabel);
        }
        {
            poblacioTextField = new JTextField();
            poblacioTextField.setColumns(10);
            poblacioTextField.setBounds(346, 185, 162, 20);
            contentPanel.add(poblacioTextField);
        }
        {
            JLabel zipLabel = new JLabel(zipLabelTxt);
            zipLabel.setBounds(243, 222, 46, 14);
            contentPanel.add(zipLabel);
        }
        {
            zipTextField = new JTextField();
            zipTextField.setColumns(10);
            zipTextField.setBounds(346, 219, 162, 20);
            contentPanel.add(zipTextField);
        }
        {
            JLabel usuariLabel = new JLabel(usuariLabelTxt);
            usuariLabel.setBounds(42, 295, 46, 14);
            contentPanel.add(usuariLabel);
        }
        {
            usuariTextField = new JTextField();
            usuariTextField.setColumns(10);
            usuariTextField.setBounds(98, 292, 113, 20);
            contentPanel.add(usuariTextField);
        }
        {
            tallerComboBox = new JComboBox();
            Vector<Taller> tallers = new Vector<Taller>(client.listaTallers());
            tallerComboBox.setModel(new DefaultComboBoxModel(tallers));
            tallerComboBox.setBounds(346, 254, 162, 20);
            tallerComboBox.setEnabled(false);
            contentPanel.add(tallerComboBox);
        }
        {
            JLabel contrasenyaLabel = new JLabel(pwdLabel);
            contrasenyaLabel.setBounds(243, 295, 73, 14);
            contentPanel.add(contrasenyaLabel);
        }
        {
            contrasenyaTextField = new JTextField();
            contrasenyaTextField.setColumns(10);
            contrasenyaTextField.setBounds(346, 292, 162, 20);
            contentPanel.add(contrasenyaTextField);
        }
        {
            JLabel perfilLabel = new JLabel(perfilLabelTxt);
            perfilLabel.setBounds(42, 329, 46, 14);
            contentPanel.add(perfilLabel);
        }
        {
            perfilComboBox = new JComboBox();
            perfilComboBox.setModel(new DefaultComboBoxModel(PerfilUsuari.values()));
            perfilComboBox.setBounds(98, 326, 113, 20);
            perfilComboBox.addActionListener(new PerfilActionListener());
            contentPanel.add(perfilComboBox);
        }
        {
            JLabel repetirpwdLabel = new JLabel(repitePwdLabel);
            repetirpwdLabel.setBounds(243, 326, 113, 14);
            contentPanel.add(repetirpwdLabel);
        }
        {
            repetirpwdTextField = new JTextField();
            repetirpwdTextField.setColumns(10);
            repetirpwdTextField.setBounds(346, 323, 162, 20);
            contentPanel.add(repetirpwdTextField);
        }

        actiuCheckBox = new JCheckBox(actiuLabel);
        actiuCheckBox.setBounds(98, 363, 97, 23);
        actiuCheckBox.setSelected(true);
        contentPanel.add(actiuCheckBox);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                okButton = new JButton(okBtnLabel);
                okButton.setActionCommand("OK");
                okButton.addActionListener(new AltaUsuariActionListener());
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton(calcelBtnLabel);
                cancelButton.setActionCommand("Cancel");
                cancelButton.addActionListener(new CalcelAltaUsuariActionListener());
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

    private class AltaUsuariActionListener implements ActionListener {
        private String[] camposMissing;
        private boolean validPasswd = false;
        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkInputDataOK()) {
                Usuari newUsuari = new Usuari();
                newUsuari.setNom(nomTextField.getText());
                newUsuari.setCognoms(cognomTextField.getText());
                newUsuari.setContrasenya(contrasenyaTextField.getText());
                newUsuari.setActiu(actiuCheckBox.isSelected());
                newUsuari.setAdreca(adrecaTextField.getText());
                newUsuari.setCodiPostal(zipTextField.getText());
                newUsuari.setNif(nifTextField.getText());
                newUsuari.setPerfil((PerfilUsuari)perfilComboBox.getSelectedItem());
                newUsuari.setPoblacio(poblacioTextField.getText());
                newUsuari.setReparacionsAssignades(0);
                newUsuari.setTaller(((Taller)tallerComboBox.getSelectedItem()).getId());
                newUsuari.setUsuari(usuariTextField.getText());

                try {
                    client.altaUsuari(newUsuari);
                } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                    //todo i18n mensajes de error
                    JOptionPane.showMessageDialog(contentPanel, "Error de BD", "BD Error", JOptionPane.ERROR_MESSAGE);
                    exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (RemoteException e1) {
                    //todo i18n mensajes de error
                    JOptionPane.showMessageDialog(contentPanel, "Error conectando con server", "Server Error", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (Exception e2){
                    //todo i18n mensajes de error
                    JOptionPane.showMessageDialog(contentPanel, "Error", "Generic Error", JOptionPane.ERROR_MESSAGE);
                    e2.printStackTrace();
                }
                dispose();
            } else {
                StringBuilder camposMiss = new StringBuilder();
                //todo i18n mensajes de error
                camposMiss.append("Error en campos obligatorios:").append("\n");
                for (String campoMiss : camposMissing) {
                    if (campoMiss != null) camposMiss.append(campoMiss).append(" está vacío.").append("\n");
                }
                if (!validPasswd) camposMiss.append("Contraseña y Repetir contraseña no son iguales").append("\n");
                validPasswd=false; //para que vuelva a comprobar el password al reintentar
                JOptionPane.showMessageDialog(contentPanel, camposMiss, "Missing Fields", JOptionPane.ERROR_MESSAGE);
            }
        }


        private boolean checkInputDataOK() {
            camposMissing = new String[9];
            int i=1;
            if (nomTextField.getText().isEmpty()){
                camposMissing[i]=nomLabelTxt;
                i++;
            }
            if (cognomTextField.getText().isEmpty()){
                camposMissing[i]=cognomLabelTxt;
                i++;
            }
            if (contrasenyaTextField.getText().isEmpty()){
                camposMissing[i]=pwdLabel;
                i++;
            }
            if (adrecaTextField.getText().isEmpty()){
                camposMissing[i]=adrecaLabellTxt;
                i++;
            }
            if (zipTextField.getText().isEmpty()){
                camposMissing[i]=zipLabelTxt;
                i++;
            }
            if (nifTextField.getText().isEmpty()){
                camposMissing[i]=nifLabelTxt;
                i++;
            }
            if (poblacioTextField.getText().isEmpty()){
                camposMissing[i]=poblacioLabelTxt;
                i++;
            }
            if (usuariTextField.getText().isEmpty()){
                camposMissing[i]=usuariLabelTxt;
                i++;
            }
            if (contrasenyaTextField.getText().equals(repetirpwdTextField.getText())) validPasswd=true;
            //Si no hay missing field y el passwd y su repetición son iguales, true
            return i==1 && validPasswd;
        }
    }

    private class PerfilActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (perfilComboBox.getSelectedItem().equals(PerfilUsuari.MECANIC) || perfilComboBox.getSelectedItem().equals(PerfilUsuari.CAPTALLER)){
                tallerComboBox.setEnabled(true);
            }
        }
    }

    private class CalcelAltaUsuariActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
