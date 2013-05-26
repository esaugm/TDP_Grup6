package common.ui;

import common.rmi.Client;
import common.utils.TDSLanguageUtils;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.entity.UsuariConectat;
import ss1.gui.GestioTallerPanel;
import ss1.gui.GestioUsuariPanel;
import ss1.gui.LoginDialog;
import ss2.exception.AppException;
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
    private String menuInicio = TDSLanguageUtils.getMessage("client.menuInicioText");
    private String menuCambiarUsuario = TDSLanguageUtils.getMessage("client.menuCambiarUsuarioText");
    private String menuSalir = TDSLanguageUtils.getMessage("client.menuSalirText");
    private String menuGestioTallers = TDSLanguageUtils.getMessage("client.menuGestioTallerText");
    private String menuGestioUsuaris = TDSLanguageUtils.getMessage("client.menuGestioUsuariText");
    private String menuReparacio = TDSLanguageUtils.getMessage("client.menuReparacioText");
    private String menuManteniment = TDSLanguageUtils.getMessage("client.menuManteniment");
    private String gestioUsuarisTitle = TDSLanguageUtils.getMessage("client.menuGestioUsuariTitle");
    private String gestioTallersTitle = TDSLanguageUtils.getMessage("client.menuGestioTallerTitle");
    private String ReparacioTitle = TDSLanguageUtils.getMessage("client.menuGestioReparacioTitle");
    private String menuReparacions = TDSLanguageUtils.getMessage("client.menuReparacions");
    private String menuRepAsig = TDSLanguageUtils.getMessage("gestioReparacions.menuRepAsigText");
    private String menuAviso = TDSLanguageUtils.getMessage("client.menuAvisoText");
    private String menuGestioReparacio = TDSLanguageUtils.getMessage("gestioReparacions.menuGestioReparacioText");
    private String menuStock = TDSLanguageUtils.getMessage("gestioReparacions.menuStockText");
    private String repAsigTitle = TDSLanguageUtils.getMessage("gestioReparacions.menuRepAsigTitle");
    private String gestioReparacioTitle = TDSLanguageUtils.getMessage("gestioReparacions.menuGestioReparacioTitle");
    private String stockTitle = TDSLanguageUtils.getMessage("gestioReparacions.menuStockTitle");
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

        showLogin();

        setContentPane(_mainPanel);

        if (usuariConectat!= null) {
            paintMenusUsingUsuariConectat();
        } else {
            doDisconnectAndClose();
        }

    }

    private void paintMenusUsingUsuariConectat() {
        paintInicioMenu();

        if (usuariConectat.isAdministrador()) {
            paintMantenimentMenu();
        }

        painReparacionsMenu();

        paintEstadisticasMenu();
    }

    private void showLogin() {
        while (usuariConectat==null && loginTries<3) {
            loginTries++;
            loginDialog = new LoginDialog(this,true, client);
            loginDialog.setLayout(new BorderLayout());
            loginDialog.setVisible(true);
            loginDialog.setModal(false);
            loginDialog.setResizable(false);
            usuariConectat = loginDialog.getUsuariConectat();
            String nom = usuariConectat!=null?usuariConectat.getNom():"";
            if(usuariConectat==null && loginTries<3){
                JOptionPane.showMessageDialog(_mainPanel, "Error de login, vuelva a intentarlo", "Login Error", JOptionPane.ERROR_MESSAGE);
            } else if (usuariConectat==null && loginTries>=3) {
                JOptionPane.showMessageDialog(_mainPanel, "Máximo de reintentos superados. Cerrando Aplicacion", "Login Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(_mainPanel, "Bienvenido " + nom, "Login Successful", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void paintInicioMenu() {
        _inicioMenu.setText(menuInicio);
        _mainMenu.add(_inicioMenu);

        _inicioBtnMenu.setText(menuCambiarUsuario);
        _inicioBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                usuariConectat=null;
                loginTries=0;
                showLogin();
            }
        });
        _inicioMenu.add(_inicioBtnMenu);

        _quitBtnMenu.setText(menuSalir);
        _quitBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                doDisconnectAndClose();
            }
        });
        _inicioMenu.add(_quitBtnMenu);
    }

    private void doDisconnectAndClose() {
        client.disconnect();
        dispose();
    }

    private void painReparacionsMenu() {
        _reparacioMenu = new JMenu();
        _reparacioMenu.setText(menuReparacio);
        _repAsigMenu = new JMenuItem();
        _repAsigMenu.setText(menuRepAsig);
        _repAsigMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    openMenuRepAsig(evt);
                } catch (AppException ex) {
                    ex.printStackTrace();
                } catch (ExceptionErrorDataBase ex) {
                    ex.printStackTrace();
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });
        _reparacioMenu.add(_repAsigMenu);

        _gestioRepMenu = new JMenuItem();
        _gestioRepMenu.setText(menuGestioReparacio);
        _gestioRepMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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
            public void actionPerformed(ActionEvent evt) {
                try {
                    openStock(evt);
                } catch (ExceptionErrorDataBase ex) {
                    ex.printStackTrace();
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });
        _reparacioMenu.add(_stockMenu);
        _mainMenu.add(_reparacioMenu);
    }

    private void paintMantenimentMenu() {
        _mantenimentMenu = new JMenu();
        _mantenimentMenu.setText(menuManteniment);
        _gestioTallersMenu = new JMenuItem();
        _gestioTallersMenu.setText(menuGestioTallers);
        _gestioTallersMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    openMenuTallers(evt);
                } catch (RemoteException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                    exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (ExceptionTipoObjetoFiltroNoPermitido exceptionTipoObjetoFiltroNoPermitido) {
                    exceptionTipoObjetoFiltroNoPermitido.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });
        _mantenimentMenu.add(_gestioTallersMenu);

        _gestioUsuarisMenu = new JMenuItem();
        _gestioUsuarisMenu.setText(menuGestioUsuaris);
        _gestioUsuarisMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openMenuUsuaris(evt);
            }
        });
        _mantenimentMenu.add(_gestioUsuarisMenu);
        _mainMenu.add(_mantenimentMenu);
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

    private void openMenuTallers(ActionEvent evt) throws RemoteException, ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido {
        removePanelFromMain();
        GestioTallerPanel tallerPanel = new GestioTallerPanel(client);
        setTitle(title + " - " + gestioTallersTitle);
        tallerPanel.setLayout(new BorderLayout());


        _mainPanel.add(tallerPanel, BorderLayout.CENTER);
        _mainPanel.validate();
    }

    private void openMenuRepAsig(ActionEvent evt) throws AppException, ExceptionErrorDataBase, RemoteException {
        removePanelFromMain();
        ReparacionesAsignadas ra = new ReparacionesAsignadas(client);
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
    
    private void openStock(ActionEvent evt) throws ExceptionErrorDataBase, RemoteException {
        removePanelFromMain();
        StockPiezas sp = new StockPiezas(client,usuariConectat);
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

    private void repaintMenusByUserRole(UsuariConectat usuariConectat) {
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
