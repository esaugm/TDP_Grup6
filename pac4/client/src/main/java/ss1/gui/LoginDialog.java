package ss1.gui;

import common.rmi.Client;
import common.utils.TDSLanguageUtils;
import ss1.dao.exception.ExceptionContrasenyaIncorrecta;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionUsuariNoExisteix;
import ss1.entity.Usuari;
import ss1.entity.UsuariConectat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.ConnectException;
import java.rmi.RemoteException;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 18/05/13
 * Time: 12:49
 */
public class LoginDialog extends JDialog {
    //TODO esau: usar i18n
    //i18n messages
    private static String title = TDSLanguageUtils.getMessage("loginDialog.title");
    private static String usuarilbl= TDSLanguageUtils.getMessage("loginDialog.usuariLbl");
    private static String passwdlbl= TDSLanguageUtils.getMessage("loginDialog.passwdLbl");
    private static String aceptarBtn= TDSLanguageUtils.getMessage("loginDialog.aceptarBtn");
    private static String errorLoginTitleLbl= TDSLanguageUtils.getMessage("loginDialog.errorLoginTitle");
    private static String errorLoginUsuarioNoExisteLbl= TDSLanguageUtils.getMessage("loginDialog.errorLoginUsuarioNoExisteLbl");
    private static String errorLoginPasswdIncorrectoLbl= TDSLanguageUtils.getMessage("loginDialog.errorLoginPasswdIncorrectoLbl");

    private JPanel contentPane;
    private JTextField usuariTxt;
    private JTextField passwdTxt;
    private Client client;
    private UsuariConectat usuariConectat=null;
    private int loginRetries=0;


    public LoginDialog(Frame owner, boolean modal, Client pClient) {
        super(owner, modal);
        client = pClient;

        setTitle(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(300, 100, 450, 450);
        setName("LoginDialog");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //label usuari
        JLabel lblProvedor = new JLabel(usuarilbl );
        //lblProvedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblProvedor.setBounds(80, 40, 76, 14);
        contentPane.add(lblProvedor);
        //textbox usuari
        usuariTxt = new JTextField();
        usuariTxt.setBounds(200, 40, 183, 20);
        contentPane.add(usuariTxt);
        usuariTxt.setColumns(10);

        //label contrasenya
        JLabel lblPasswd = new JLabel(passwdlbl );
        //lblProvedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblPasswd.setBounds(80, 80, 76, 14);
        contentPane.add(lblPasswd);
        //textbox contrasenya
        passwdTxt = new JTextField();
        passwdTxt.setBounds(200, 80, 183, 20);
        contentPane.add(passwdTxt);
        passwdTxt.setColumns(10);

        JButton btnAceptar = new JButton(aceptarBtn);
        btnAceptar.setBounds(80, 120, 100, 30);
        contentPane.add(btnAceptar);
        btnAceptar.setName("Aceptar");
        btnAceptar.addActionListener(new LoginActionListener());

    }

    private UsuariConectat makeLogin(String pUsuari, String pPasswd, ActionEvent evt) throws ExceptionUsuariNoExisteix, ExceptionContrasenyaIncorrecta, ExceptionErrorDataBase, RemoteException, ConnectException {
        Usuari usuari = client.makeLogin(pUsuari, pPasswd);
        return new UsuariConectat(usuari,System.currentTimeMillis());
    }

    public UsuariConectat getUsuariConectat() {
        return usuariConectat;
    }
    
    class LoginActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                usuariConectat = makeLogin(usuariTxt.getText(), passwdTxt.getText(), evt);
            } catch (ExceptionUsuariNoExisteix exceptionUsuariNoExisteix) {
                loginRetries++;
                JOptionPane.showMessageDialog(contentPane, errorLoginUsuarioNoExisteLbl, errorLoginTitleLbl, JOptionPane.ERROR_MESSAGE);
                //cleanValues();
            } catch (ExceptionContrasenyaIncorrecta exceptionContrasenyaIncorrecta) {
                loginRetries++;
                JOptionPane.showMessageDialog(contentPane, errorLoginPasswdIncorrectoLbl, errorLoginTitleLbl, JOptionPane.ERROR_MESSAGE);
                //cleanValues();
            } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                //todo show error DB
                exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (RemoteException e) {
                //todo show error Remote
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            dispose();
        }
    }

    private void cleanValues() {
        usuariTxt.setText("");
        passwdTxt.setText("");
    }
}
