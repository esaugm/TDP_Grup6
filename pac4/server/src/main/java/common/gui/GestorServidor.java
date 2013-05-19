package common.gui;

import common.rmi.Server;
import common.utils.TDSLanguageUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 19/05/13
 * Time: 12:20
 */
public class GestorServidor extends JFrame implements ActionListener {

    private JPanel contentPane;
    private Label label1;
    private Server server;
    private String title = TDSLanguageUtils.getMessage("server.title");
    private String inicioPendienteLbl = TDSLanguageUtils.getMessage("server.inicioPendienteLabel");
    private String servidorIniciadoLbl = TDSLanguageUtils.getMessage("server.servidorIniciadoLabel");
    private String iniciarServidorBtn = TDSLanguageUtils.getMessage("server.iniciarServidorBtn");
    private String pararServidorBtn = TDSLanguageUtils.getMessage("server.pararServidorBtn");
    private String errorMessage = TDSLanguageUtils.getMessage("server.errorMessage");


    ErrorScreen errorScreen;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        if(args.length==1) {
            Locale locale = new Locale(args[0]);
            TDSLanguageUtils.setLanguage("i18n/messages", locale);
        }
        if(args.length==0) {
            TDSLanguageUtils.setDefaultLanguage("conf/messages");
        }


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GestorServidor frame = new GestorServidor();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GestorServidor() {
        server = new Server();
        setResizable(false);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 454, 117);
        contentPane = new JPanel();
        contentPane.setToolTipText("");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAturarServidor = new JButton(pararServidorBtn);
        btnAturarServidor.setBounds(239, 50, 189, 23);
        contentPane.add(btnAturarServidor);
        btnAturarServidor.addActionListener(this);

        JButton btnIniciarServidor = new JButton(iniciarServidorBtn);
        btnIniciarServidor.setBounds(10, 50, 189, 23);
        contentPane.add(btnIniciarServidor);
        btnIniciarServidor.addActionListener(this);

        label1 = new Label(inicioPendienteLbl);
        label1.setName("Label1");
        label1.setFont(new Font("Dialog", Font.BOLD, 12));
        label1.setBounds(10, 10, 418, 20);
        contentPane.add(label1);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(iniciarServidorBtn)){
            try {
                server.start();
            } catch (Exception e1) {
                errorScreen = new ErrorScreen(errorMessage);
                errorScreen.setVisible(true);
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            label1.setText(servidorIniciadoLbl);
            label1.setVisible(true);
        } else {
            server.stop();
        }
    }
}
