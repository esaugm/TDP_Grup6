package ss1.gui;

/**
 * TDP Grup6
 * User: Esaú González, Juan Asperó
 * Date: 26/05/13
 * Time: 12:45
 */

import common.rmi.Client;
import common.utils.TDSLanguageUtils;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Usuari;
import ss1.entity.UsuariConectat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class ChangePasswordDialog extends JDialog {
    
    private Client client;
    private UsuariConectat usuariConectat;

    private static String titleLbl= TDSLanguageUtils.getMessage("changePwdDialog.titleLbl");
    private static String oldPasswordLbl= TDSLanguageUtils.getMessage("changePwdDialog.oldPasswdLbl");
    private static String newPasswordLbl= TDSLanguageUtils.getMessage("changePwdDialog.newPasswdLbl");
    private static String confirmaPasswordLbl= TDSLanguageUtils.getMessage("changePwdDialog.confirmaPasswdLbl");

    private JPanel contentPane;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private JButton btnAceptar;
    private Label label_2;
    private JPasswordField repeatPasswdField;

    private String[] camposMissing;
    private boolean validOldPasswd = false;
    private boolean validRepeatedPasswd = false;


    /**
     * Create the frame.
     * @param modal
     */
    public ChangePasswordDialog(Frame owner, boolean modal, Client pClient, UsuariConectat pUsuariConectat) {
        super(owner,modal);
        client=pClient;
        usuariConectat = pUsuariConectat;

        setTitle(titleLbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 414, 442);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        oldPasswordField = new JPasswordField();
        oldPasswordField.setBounds(198, 116, 150, 25);
        contentPane.add(oldPasswordField);
        oldPasswordField.setColumns(10);

        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(198, 170, 150, 25);
        contentPane.add(newPasswordField);

        Label oldPwdLabel = new Label(oldPasswordLbl);
        oldPwdLabel.setBounds(44, 116, 126, 25);
        contentPane.add(oldPwdLabel);
        oldPwdLabel.setFont(new Font("Dialog", Font.BOLD, 12));

        Label newPasswordLabel = new Label(newPasswordLbl);
        newPasswordLabel.setBounds(44, 170, 126, 25);
        contentPane.add(newPasswordLabel);
        newPasswordLabel.setFont(new Font("Dialog", Font.BOLD, 12));

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(44, 304, 140, 25);
        btnAceptar.addActionListener(new ChangePasswordActionListener());
        contentPane.add(btnAceptar);

        label_2 = new Label("SmartRepair");
        label_2.setFont(new Font("Dialog", Font.BOLD, 20));
        label_2.setBounds(130, 27, 163, 33);
        contentPane.add(label_2);

        repeatPasswdField = new JPasswordField();
        repeatPasswdField.setBounds(198, 223, 150, 25);
        contentPane.add(repeatPasswdField);

        Label confirmaPwdLabel = new Label(confirmaPasswordLbl);
        confirmaPwdLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        confirmaPwdLabel.setBounds(44, 223, 140, 25);
        contentPane.add(confirmaPwdLabel);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(208, 304, 140, 25);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        contentPane.add(btnCancelar);

    }
    protected boolean checkInputDataOK() {
        camposMissing = new String[3];
        int i=1;
        if (oldPasswordField.getText().isEmpty()){
            camposMissing[i]=oldPasswordLbl;
            i++;
        }
        if (newPasswordField.getText().isEmpty()){
            camposMissing[i]=newPasswordLbl;
            i++;
        }
        if (repeatPasswdField.getText().isEmpty()){
            camposMissing[i]=confirmaPasswordLbl;
            i++;
        }
        
        if (newPasswordField.getText().equals(repeatPasswdField.getText())) validRepeatedPasswd=true;
        if (usuariConectat.checkIfPasswordOk(oldPasswordField.getText())) validOldPasswd=true;
        //Si no hay missing field, el passwd y su repetición son iguales y el password antiguo corresponde al usuario true
        return i==1 && validRepeatedPasswd && validOldPasswd;
    }

    private class ChangePasswordActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (checkInputDataOK()) {
                Usuari newUsuari = usuariConectat.getUsuari();
                newUsuari.setContrasenya(newPasswordField.getText());
                try {
                    client.modificaUsuari(newUsuari);
                    usuariConectat.setUsuari(newUsuari);
                } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                    //todo i18n mensajes de error
                    JOptionPane.showMessageDialog(contentPane, "Error de BD", "BD Error", JOptionPane.ERROR_MESSAGE);
                    exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (RemoteException e1) {
                    //todo i18n mensajes de error
                    JOptionPane.showMessageDialog(contentPane, "Error conectando con server", "Server Error", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (Exception e2){
                    //todo i18n mensajes de error
                    JOptionPane.showMessageDialog(contentPane, "Error", "Generic Error", JOptionPane.ERROR_MESSAGE);
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
                if (!validRepeatedPasswd) camposMiss.append("Contraseña y Repetir contraseña no son iguales").append("\n");
                validRepeatedPasswd=false; //para que vuelva a comprobar el password al reintentar
                if (!validOldPasswd) camposMiss.append("La contraseña actual no es correcta").append("\n");
                validOldPasswd=false;
                JOptionPane.showMessageDialog(contentPane, camposMiss, "Missing Fields", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
