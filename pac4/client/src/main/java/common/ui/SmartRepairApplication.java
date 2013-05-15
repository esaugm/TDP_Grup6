package common.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextLayout;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 15/05/13
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
public class SmartRepairApplication extends JFrame {
    private JPanel _mainPanel;

    private JMenuBar _mainMenu;
    private JMenu _inicioMenu;
    private JMenuItem _inicioBtnMenu;
    private JMenuItem _quitBtnMenu;


    public SmartRepairApplication() {
        initComponents();
    }

    private void initComponents() {

        _mainPanel = new JPanel();
        _mainMenu = new JMenuBar();

        _inicioBtnMenu = new JMenuItem();
        _inicioMenu = new JMenu();
        _quitBtnMenu = new JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart Repair");
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setJMenuBar(_mainMenu);
        //Iniciamos al panel principal que siempre estara vivo i sera el controlador de todo.
        _mainPanel.setLayout(new BorderLayout());
        _mainPanel.setVisible(true);
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
                    new SmartRepairApplication().setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
