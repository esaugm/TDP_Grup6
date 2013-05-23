package common.ui;

import common.rmi.Client;
import common.utils.TDSLanguageUtils;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.UsuariConectat;
import ss1.gui.GestioTallerPanel;
import ss1.gui.GestioUsuariPanel;
import ss1.gui.LoginDialog;
import ss3.gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.rmi.ConnectException;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 15/05/13
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
public class MenuSS3 extends JFrame {
    private JPanel _mainPanel;
    private LoginDialog loginDialog;
    private UsuariConectat usuariConectat;
    private Client client;
    private int loginTries=0;

    private JMenuBar _mainMenu;
    private JMenu _inicioMenu;
    private JMenu _ReparacioMenu;
    private JMenu _StockMenu;
    private JMenu _AvisosMenu;
    private JMenuItem _gestioRepMenu;
    private JMenuItem _RepAsigMenu;
    private JMenuItem _quitBtnMenu;

    //i18n messages
    private String title = TDSLanguageUtils.getMessage("gestioReparacions.title");
    private String menuInicio = TDSLanguageUtils.getMessage("gestioReparacions.menuInicio");
    private String menuReparacions = TDSLanguageUtils.getMessage("gestioReparacions.menuReparacions");
    private String menuRepAsig = TDSLanguageUtils.getMessage("gestioReparacions.menuRepAsigText");
    private String menuAviso = TDSLanguageUtils.getMessage("gestioReparacions.menuAvisoText");
    private String menuGestioReparacio = TDSLanguageUtils.getMessage("gestioReparacions.menuGestioReparacioText");
    private String menuStock = TDSLanguageUtils.getMessage("gestioReparacions.menuStockText");
    private String repAsigTitle = TDSLanguageUtils.getMessage("gestioReparacions.menuRepAsigTitle");
    private String gestioReparacioTitle = TDSLanguageUtils.getMessage("gestioReparacions.menuGestioReparacioTitle");
    private String stockTitle = TDSLanguageUtils.getMessage("gestioReparacions.menuStockTitle");
    private String avisoTitle = TDSLanguageUtils.getMessage("gestioReparacions.menuAvisoTitle");
    private String salirBtt = TDSLanguageUtils.getMessage("gestioReparacions.salir");

    public MenuSS3() throws Exception {
        initComponents();
    }

    private void initComponents() throws Exception {

        _mainPanel = new JPanel();
        _mainMenu = new JMenuBar();

        _inicioMenu = new JMenu();
        _quitBtnMenu = new JMenuItem();




       // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setJMenuBar(_mainMenu);
        //Iniciamos al panel principal que siempre estara vivo i sera el controlador de todo.
        _mainPanel.setLayout(new BorderLayout());
        _mainPanel.setVisible(true);


        setContentPane(_mainPanel);

        _quitBtnMenu.setText(salirBtt);
        _inicioMenu.add(_quitBtnMenu);
        _quitBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });
        _inicioMenu.setText(menuInicio);
        _mainMenu.add(_inicioMenu);

        _ReparacioMenu = new JMenu();
        _ReparacioMenu.setText(menuReparacions);
        _RepAsigMenu = new JMenuItem();
        _RepAsigMenu.setText(menuRepAsig);
        _RepAsigMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuRepAsig(evt);
            }
        });
        _ReparacioMenu.add(_RepAsigMenu);

        _gestioRepMenu = new JMenuItem();
        _gestioRepMenu.setText(menuGestioReparacio);
        _gestioRepMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuGesRep(evt);
            }
        });
        _ReparacioMenu.add(_gestioRepMenu);
        _mainMenu.add(_ReparacioMenu);
        
    }

    private void openMenuRepAsig(ActionEvent evt) {
        removePanelFromMain();
        ReparacionesAsignadas ra = new ReparacionesAsignadas();
        setTitle(title + " - " + repAsigTitle);
        ra.setLayout(new BorderLayout());


        _mainPanel.add(ra, BorderLayout.CENTER);
        _mainPanel.validate();
    }
    
    private void openMenuGesRep(ActionEvent evt) {
        removePanelFromMain();
        Reparaciones ra = new Reparaciones();
        setTitle(title + " - " + gestioReparacioTitle);
        ra.setLayout(new BorderLayout());


        _mainPanel.add(ra, BorderLayout.CENTER);
        _mainPanel.validate();
    }
    
   
    private void salir(java.awt.event.ActionEvent evt) {
        System.exit(-1);
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
                    new MenuSS3().setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
