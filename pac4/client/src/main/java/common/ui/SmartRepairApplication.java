package common.ui;

import common.rmi.Client;
import common.utils.TDSLanguageUtils;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.UsuariConectat;
import ss1.gui.GestioTallerPanel;
import ss1.gui.GestioUsuariPanel;
import ss1.gui.LoginDialog;
import ss3.gui.Reparaciones;
import ss3.gui.ReparacionesAsignadas;
import ss3.gui.StockPiezas;
import ss4.gui.ReparacionesClienteEstaPanel;
import ss4.gui.ReparacionesEstaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private int loginTries = 0;

    private JMenuBar _mainMenu;
    private JMenu _inicioMenu;
    private JMenu _mantenimentMenu;
    private JMenu _applicationMenu;
    private JMenu _estadisticasMenu;
    private JMenuItem _gestioUsuarisMenu;
    private JMenuItem _gestioTallersMenu;
    private JMenu _administracioMenu;
 
    private JMenu _reparacioMenu;
    private JMenuItem _stockMenu;
    private JMenuItem _avisosMenu;
    private JMenuItem _gestioRepMenu;
    private JMenuItem _repAsigMenu;


    private JMenuItem _inicioBtnMenu;
    private JMenuItem _quitBtnMenu;
    private JMenuItem _estaReparaciones;
    private JMenuItem _estaReparacionesClientes;
    private JMenuItem _estaReparacionesEmpleados;


    //i18n messages
    private String title = TDSLanguageUtils.getMessage("client.title");
    private String menuGestioTallers = TDSLanguageUtils.getMessage("client.menuGestioTallerText");
    private String menuGestioUsuaris = TDSLanguageUtils.getMessage("client.menuGestioUsuariText");
    private String menuReparacio = TDSLanguageUtils.getMessage("client.menuReparacioText");
    private String menuManteniment = TDSLanguageUtils.getMessage("client.menuManteniment");
    private String menuApplication = TDSLanguageUtils.getMessage("client.menuApplication");
    private String gestioUsuarisTitle = TDSLanguageUtils.getMessage("client.menuGestioUsuariTitle");
    private String gestioTallersTitle = TDSLanguageUtils.getMessage("client.menuGestioTallerTitle");
    private String ReparacioTitle = TDSLanguageUtils.getMessage("client.menuGestioReparacioTitle");
    private String menuReparacions = TDSLanguageUtils.getMessage("client.menuReparacions");
    private String menuRepAsig = TDSLanguageUtils.getMessage("client.menuRepAsigText");
    private String menuAviso = TDSLanguageUtils.getMessage("client.menuAvisoText");
    private String menuGestioReparacio = TDSLanguageUtils.getMessage("client.menuGestioReparacioText");
    private String menuStock = TDSLanguageUtils.getMessage("client.menuStockText");
    private String repAsigTitle = TDSLanguageUtils.getMessage("client.menuRepAsigTitle");
    private String gestioReparacioTitle = TDSLanguageUtils.getMessage("client.menuGestioReparacioTitle");
    private String stockTitle = TDSLanguageUtils.getMessage("client.menuStockTitle");
    private String avisoTitle = TDSLanguageUtils.getMessage("client.menuAvisoTitle");


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

        _inicioMenu.add(_inicioBtnMenu);
        _quitBtnMenu.setText("Pantalla 2 Son pantallas de pruebas !!!");
        _inicioMenu.add(_quitBtnMenu);

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

        _applicationMenu = new JMenu();
        _applicationMenu.setText(menuApplication);

_reparacioMenu = new JMenu();
        _reparacioMenu.setText(menuReparacions);
        _repAsigMenu = new JMenuItem();
        _repAsigMenu.setText(menuRepAsig);
        _repAsigMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuRepAsig(evt);
            }
        });
        _reparacioMenu.add(_repAsigMenu);

        _gestioRepMenu = new JMenuItem();
        _gestioRepMenu.setText(menuGestioReparacio);
        _gestioRepMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    openMenuGesRep(evt);
                } catch (ExceptionErrorDataBase ex) {
                    Logger.getLogger(SmartRepairApplication.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(SmartRepairApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        _reparacioMenu.add(_gestioRepMenu);
        
        _stockMenu = new JMenuItem();
        _stockMenu.setText(menuStock);
        _stockMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openStock(evt);
            }
        });
        _reparacioMenu.add(_stockMenu);
        _mainMenu.add(_reparacioMenu);
        paintEstadisticasMenu();


    }

    private void openMenuUsuaris(ActionEvent evt) {
        removePanelFromMain();
        GestioUsuariPanel usuariPanel = null;
        try {
            usuariPanel = new GestioUsuariPanel(client);
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            JOptionPane.showMessageDialog(_mainPanel, "Error de BD", "BD Error", JOptionPane.ERROR_MESSAGE);
            exceptionErrorDataBase.printStackTrace();
        } catch (RemoteException e) {
            JOptionPane.showMessageDialog(_mainPanel, "Error conexion con Servidor", "Remote Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
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

    private void openMenuRepAsig(ActionEvent evt) {
        removePanelFromMain();
        ReparacionesAsignadas ra = new ReparacionesAsignadas();
        setTitle(title + " - " + repAsigTitle);
        ra.setLayout(new BorderLayout());


        _mainPanel.add(ra, BorderLayout.CENTER);
        _mainPanel.validate();
    }
    
    private void openMenuGesRep(ActionEvent evt) throws ExceptionErrorDataBase, RemoteException {
        removePanelFromMain();
        Reparaciones ra = new Reparaciones(client);
        setTitle(title + " - " + gestioReparacioTitle);
        ra.setLayout(new BorderLayout());


        _mainPanel.add(ra, BorderLayout.CENTER);
        _mainPanel.validate();
    }
    
    private void openStock(ActionEvent evt) {
        removePanelFromMain();
        StockPiezas sp = new StockPiezas();
        setTitle(title + " - " + stockTitle);
        sp.setLayout(new BorderLayout());


        _mainPanel.add(sp, BorderLayout.CENTER);
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

    private void openEstadisticasReparaciones(java.awt.event.ActionEvent evt) throws ParseException {
        removePanelFromMain();
        ReparacionesEstaPanel panel = new ReparacionesEstaPanel(client.get_remoteSS4());


        _mainPanel.add(panel, BorderLayout.CENTER);
        _mainPanel.validate();


    }
    private void openEstadisticasReparacionesClientes(java.awt.event.ActionEvent evt) throws ParseException {
        removePanelFromMain();
        ReparacionesClienteEstaPanel panel = new ReparacionesClienteEstaPanel(client.get_remoteSS4());
        _mainPanel.add(panel, BorderLayout.CENTER);
        _mainPanel.validate();


    }
    private void openEstadisticasReparacionesEmpleados(java.awt.event.ActionEvent evt) throws ParseException {
        removePanelFromMain();
       ReparacionesClienteEstaPanel panel = new ReparacionesClienteEstaPanel(client.get_remoteSS4());
        _mainPanel.add(panel, BorderLayout.CENTER);
        _mainPanel.validate();


    }

    private void paintEstadisticasMenu() {
        _estadisticasMenu = new JMenu("Estadisticas");
        _estaReparaciones = new JMenuItem("Estadisticas Reparaciones");
        _estaReparaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    openEstadisticasReparaciones(evt);
                } catch (Exception ex) {
                    Logger.getLogger(SmartRepairApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        _estaReparacionesClientes = new JMenuItem("Estadisticas Clientes");
        _estaReparacionesClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    openEstadisticasReparacionesClientes(evt);
                } catch (Exception ex) {
                    Logger.getLogger(SmartRepairApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        _estaReparacionesEmpleados = new JMenuItem("Estadisticas Empleados");
        _estaReparacionesEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    openEstadisticasReparacionesEmpleados(evt);
                } catch (Exception ex) {
                    Logger.getLogger(SmartRepairApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        _estadisticasMenu.add(_estaReparaciones);
        _estadisticasMenu.add(_estaReparacionesClientes);
        _estadisticasMenu.add(_estaReparacionesEmpleados);
        _mainMenu.add(_estadisticasMenu);
    }

    private void repaintMainMenuByUserRole(UsuariConectat usuariConectat) {
       //TODO EN ESTE METODO COMPLETEMOS CADA UNO SU PARTE , DESPUES DE HACER EL LOGIN , EN FUNCION DEL ROLE DE SUARIO QUE PINTE UNOS MENUS U OTROS.
        // SI VEIS EL METODO  paintEstadisticasMenu() , SI LE LLAMAIS PINTARA TODO EL MENU DE MENU ESTADISTICO , CREO QUE ES RAPIDO I LIMPIO , SI CADA UNO
        //HACE UN METODO PARECIDO PERO CON SUS MENUS , SERAN FACILMENTE MANEJABLES .
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
