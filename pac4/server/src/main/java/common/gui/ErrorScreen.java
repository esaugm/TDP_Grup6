package common.gui;

import common.utils.TDSLanguageUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 19/05/13
 * Time: 12:23
 */
public class ErrorScreen extends JFrame implements ActionListener {

    private JPanel contentPane;
    private String title = TDSLanguageUtils.getMessage("Panel6.title");
    private String acep = TDSLanguageUtils.getMessage("Panel6.button1");


    /**
     * Create the frame.
     */
    public ErrorScreen(String pErrorMessage) {
        setResizable(false);
        setTitle(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 384, 136);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCapProvedorPot = new JLabel(pErrorMessage);
        lblCapProvedorPot.setForeground(Color.RED);
        lblCapProvedorPot.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCapProvedorPot.setBounds(26, 11, 327, 41);
        contentPane.add(lblCapProvedorPot);

        JButton btnAcceptar = new JButton(acep);
        btnAcceptar.setBounds(141, 63, 89, 23);
        contentPane.add(btnAcceptar);
        btnAcceptar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
