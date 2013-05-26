package common.ui;

import common.rmi.Client;
import common.utils.TDSLanguageUtils;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.entity.UsuariConectat;
import ss1.gui.ChangePasswordDialog;
import ss1.gui.GestioTallerPanel;
import ss1.gui.GestioUsuariPanel;
import ss1.gui.LoginDialog;
import ss2.exception.AppException;
import ss2.gui.JPClienteFind;
import ss2.gui.JPSolicitud;
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
    private ChangePasswordDialog changePasswordDialog;
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
    private JMenuItem _changePasswdMenu;
    private JMenuItem _estaReparaciones;
    private JMenuItem _estaReparacionesClientes;
    private JMenuItem _estaReparacionesEmpleados;


    private JMenu	_M_gestionAdministrativa;
    private JMenuItem	_M_gaClientes;
    private JMenuItem	_M_gaSolicitudes;
    private JMenuItem	_M_gaStock;

    private JPanel	_P_gaClientes;
    private JPanel	_P_gaSolicitudes;
    private JPanel	_P_gaStock;



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
    private String menuChangePwd = TDSLanguageUtils.getMessage("client.menuCambioPasswd");


    public SmartRepairApplication() throws Exception {
        initComponents();
    }

    private void initComponents() throws Exception {

        client = new Client();
        try {
            client.connect();
        } catch (ConnectException e) {
            JOptionPane.showMessageDialog(this, "Error conectando con server", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }

        showLoginDialog();

        if (usuariConectat!= null) {
            paintMenusUsingUsuariConectat();
        } else {
            doDisconnectAndClose();
        }

    }

    private void paintMenusUsingUsuariConectat() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);
        setExtendedState(Frame.MAXIMIZED_BOTH);

        //Iniciamos al panel principal que siempre estara vivo i sera el controlador de todo.
        _mainPanel = new JPanel();
        _mainPanel.setLayout(new BorderLayout());
        _mainPanel.setVisible(true);
        setContentPane(_mainPanel);
        _mainMenu = new JMenuBar();
        setJMenuBar(_mainMenu);

        paintInicioMenu();

        if (usuariConectat.isAdministrador()) {
            paintMantenimentMenu();
        }

	if (usuariConectat.isAdministratiu()) {
	    SS2GestionAdministrativaMenu();
	}

        painReparacionsMenu();

        paintEstadisticasMenu();
        validate();
    }

    private void showLoginDialog() {
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
        _inicioMenu = new JMenu();
        _inicioMenu.setText(menuInicio);
        _mainMenu.add(_inicioMenu);

        _inicioBtnMenu = new JMenuItem();
        _inicioBtnMenu.setText(menuCambiarUsuario);
        _inicioBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                usuariConectat=null;
                loginTries=0;
                showLoginDialog();
                if (usuariConectat!= null) {
                    paintMenusUsingUsuariConectat();
                } else {
                    doDisconnectAndClose();
                }
            }
        });
        _inicioMenu.add(_inicioBtnMenu);

        _changePasswdMenu = new JMenuItem();
        _changePasswdMenu.setText(menuChangePwd);
        _changePasswdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showChangePasswdDialog();
                paintMenusUsingUsuariConectat();
            }


        });
        _inicioMenu.add(_changePasswdMenu);

        _quitBtnMenu = new JMenuItem();
        _quitBtnMenu.setText(menuSalir);
        _quitBtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                doDisconnectAndClose();
            }
        });
        _inicioMenu.add(_quitBtnMenu);
        _inicioMenu.setVisible(true);

    }
    private void showChangePasswdDialog() {
        changePasswordDialog = new ChangePasswordDialog(this,true, client, usuariConectat);
        changePasswordDialog.setLayout(new BorderLayout());
        changePasswordDialog.setVisible(true);
        changePasswordDialog.setModal(false);
        changePasswordDialog.setResizable(false);
    }

    private void doDisconnectAndClose() {
        client.disconnect();
        dispose();
    }

    private void paintReparacionsMenu() {
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
        _estadisticasMenu = new JMenu(TDSLanguageUtils.getMessage("client.ss4.menu.estadisticas"));
        _estaReparaciones = new JMenuItem(TDSLanguageUtils.getMessage("client.ss4.menu.items.reparaciones"));
        _estaReparaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    openEstadisticasReparaciones(evt);
                } catch (Exception ex) {
                    Logger.getLogger(SmartRepairApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        _estaReparacionesClientes = new JMenuItem(TDSLanguageUtils.getMessage("client.ss4.menu.items.clientes"));
        _estaReparacionesClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    openEstadisticasReparacionesClientes(evt);
                } catch (Exception ex) {
                    Logger.getLogger(SmartRepairApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        _estaReparacionesEmpleados = new JMenuItem(TDSLanguageUtils.getMessage("client.ss4.menu.items.empleados"));
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

     private void paintGestionAdministrativaMenu() {
        _M_gestionAdministrativa = new JMenu(TDSLanguageUtils.getMessage("client.menuGestionAdministrativa"));
        _M_gaClientes	= new JMenuItem(TDSLanguageUtils.getMessage("client.menuGA_Clientes"));
        _M_gaSolicitudes	= new JMenuItem(TDSLanguageUtils.getMessage("client.menuGA_Solicitud"));
        _M_gaStock	= new JMenuItem(TDSLanguageUtils.getMessage("client.menuGA_Stock"));

            _M_gaClientes.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        openCliente(evt);
                    } catch (Exception ex) {
                        Logger.getLogger(SmartRepairApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

        _M_gaSolicitudes.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        openSolicitud(evt);
                    } catch (Exception ex) {
                        Logger.getLogger(SmartRepairApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

        _M_gestionAdministrativa.add(_M_gaClientes);
        _M_gestionAdministrativa.add(_M_gaSolicitudes);
        _M_gestionAdministrativa.add(_M_gaStock);

        _mainMenu.add(_M_gestionAdministrativa);
     }


    private void openCliente(java.awt.event.ActionEvent evt) throws ParseException {
        removePanelFromMain();
        _P_gaClientes  = new JPClienteFind(client);
        _mainPanel.add(_P_gaClientes, BorderLayout.CENTER);
        _mainPanel.validate();
    }

    private void openSolicitud(java.awt.event.ActionEvent evt) throws ParseException {
        removePanelFromMain();
        _P_gaSolicitudes  = new JPSolicitudFind(client);
        _mainPanel.add(_P_gaSolicitudes, BorderLayout.CENTER);

        _mainPanel.validate();
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
