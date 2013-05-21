package common.ui;

import common.rmi.Client;
import common.utils.TDSLanguageUtils;
import ss1.entity.UsuariConectat;
import ss1.gui.GestioTallerPanel;
import ss1.gui.GestioUsuariPanel;
import ss1.gui.LoginDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.rmi.ConnectException;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 15/05/13
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
public class SmartRepairApplication extends JFrame {
    private JPanel _mainPanel;
    private LoginDialog loginDialog;
    private UsuariConectat usuariConectat;
    private Client client;
    private int loginTries=0;

    private JMenuBar _mainMenu;
    private JMenu _inicioMenu;
    private JMenu _mantenimentMenu;
    private JMenuItem _gestioUsuarisMenu;
    private JMenuItem _gestioTallersMenu;
    private JMenu _administracioMenu;
    private JMenu _reparacionsMenu;
    private JMenu _estadisticasMenu;
    private JMenuItem _inicioBtnMenu;
    private JMenuItem _quitBtnMenu;

    //i18n messages
    private String title = TDSLanguageUtils.getMessage("client.title");
    private String menuGestioTallers = TDSLanguageUtils.getMessage("client.menuGestioTallerText");
    private String menuGestioUsuaris = TDSLanguageUtils.getMessage("client.menuGestioUsuariText");
    private String menuManteniment = TDSLanguageUtils.getMessage("client.menuManteniment");
    private String gestioUsuarisTitle = TDSLanguageUtils.getMessage("client.menuGestioUsuariTitle");
    private String gestioTallersTitle = TDSLanguageUtils.getMessage("client.menuGestioTallerTitle");


    public SmartRepairApplication() throws Exception {
        initComponents();
    }

    private void initComponents() throws Exception {

        _mainPanel = new JPanel();
        _mainMenu = new JMenuBar();

        _inicioBtnMenu = new JMenuItem();
        _inicioMenu = new JMenu();
        _quitBtnMenu = new JMenuItem();




        client = new Client();
        try {
            client.connect();
        } catch (ConnectException e) {
            JOptionPane.showMessageDialog(_mainPanel, "Error conectando con server", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setJMenuBar(_mainMenu);
        //Iniciamos al panel principal que siempre estara vivo i sera el controlador de todo.
        _mainPanel.setLayout(new BorderLayout());
        _mainPanel.setVisible(true);

        //todo ESAU: abrir pantalla de login y no mostrar nada más hasta tener UsuariConectat para saber permisos y mostrar menus correspondientes
        //do {
            loginTries++;
            loginDialog = new LoginDialog(this,true, client);
            loginDialog.setLayout(new BorderLayout());
            loginDialog.setVisible(true);
            loginDialog.setModal(false);
            loginDialog.setResizable(false);
            usuariConectat = loginDialog.getUsuariConectat();
            if(usuariConectat==null){
                JOptionPane.showMessageDialog(_mainPanel,"Error de login, vuelva a intentarlo", "Login Error",JOptionPane.ERROR_MESSAGE);
            }
        //} while (loginTries<3);

        setContentPane(_mainPanel);

        _inicioBtnMenu.setText("start");
        _inicioBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnexampleActionView(evt);
            }
        });
        _inicioMenu.add(_inicioBtnMenu);
        _quitBtnMenu.setText("Pantalla 2 Son pantallas de pruebas !!!");
        _inicioMenu.add(_quitBtnMenu);
        _quitBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnexampleActionView2(evt);
            }
        });
        _inicioMenu.setText("Inicio");
        _mainMenu.add(_inicioMenu);


        //todo ESAU: segun UsuariConectat mostrar menús
        System.out.println("Usuari: " + usuariConectat.getPerfilString());

        _mantenimentMenu = new JMenu();
        _mantenimentMenu.setText(menuManteniment);
        _gestioTallersMenu = new JMenuItem();
        _gestioTallersMenu.setText(menuGestioTallers);
        _gestioTallersMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuTallers(evt);
            }
        });
        _mantenimentMenu.add(_gestioTallersMenu);

        _gestioUsuarisMenu = new JMenuItem();
        _gestioUsuarisMenu.setText(menuGestioUsuaris);
        _gestioUsuarisMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuUsuaris(evt);
            }
        });
        _mantenimentMenu.add(_gestioUsuarisMenu);
        _mainMenu.add(_mantenimentMenu);



    }

    private void openMenuUsuaris(ActionEvent evt) {
        removePanelFromMain();
        GestioUsuariPanel usuariPanel = new GestioUsuariPanel(client);
        setTitle(title + " - " + gestioUsuarisTitle);
        usuariPanel.setLayout(new BorderLayout());


        _mainPanel.add(usuariPanel, BorderLayout.CENTER);
        _mainPanel.validate();
    }

    private void openMenuTallers(ActionEvent evt) {
        removePanelFromMain();
        GestioTallerPanel tallerPanel = new GestioTallerPanel();
        setTitle(title + " - " + gestioTallersTitle);
        tallerPanel.setLayout(new BorderLayout());


        _mainPanel.add(tallerPanel, BorderLayout.CENTER);
        _mainPanel.validate();
    }

    private void mnexampleActionView(java.awt.event.ActionEvent evt) {
        removePanelFromMain();
        TestPanel test = new TestPanel();


        _mainPanel.add(test, BorderLayout.CENTER);
        _mainPanel.validate();


    }

    private void mnexampleActionView2(java.awt.event.ActionEvent evt) {
        removePanelFromMain();
        TestPanel2 test = new TestPanel2();


        _mainPanel.add(test, BorderLayout.CENTER);
        _mainPanel.validate();


    }

    private void removePanelFromMain() {
        if (_mainPanel.getComponentCount() > 0) {
            //remove All from MainPanel
            for (int i = 0; i < _mainPanel.getComponentCount(); i++) {
                _mainPanel.remove(i);
                _mainPanel.validate();
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TDSLanguageUtils.setDefaultLanguage("conf/messages");
                    new SmartRepairApplication().setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
