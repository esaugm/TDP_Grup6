package ss1.gui;

import common.entity.PerfilUsuari;
import common.utils.TDSLanguageUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 19/05/13
 * Time: 16:33
 */
public class GestioUsuariPanel extends JPanel{
    private String altesBtnLabel = TDSLanguageUtils.getMessage("gestioUsuari.altesBtnLabel");
    private String modificacionsBtnLabel = TDSLanguageUtils.getMessage("gestioUsuari.modificacionsBtnLabel");
    private String baixesBtnLabel = TDSLanguageUtils.getMessage("gestioUsuari.baixesBtnLabel");
    private String filtrarBtnLabel = TDSLanguageUtils.getMessage("gestioUsuari.filtrarBtnLabel");
    private String salirBtnLabel = TDSLanguageUtils.getMessage("gestioUsuari.salirBtnLabel");
    private String criterisFiltreLblText = TDSLanguageUtils.getMessage("gestioUsuari.criterisFiltreText");
    private String criteriFiltreIDLblText = TDSLanguageUtils.getMessage("gestioUsuari.criteriFiltreIDText");
    private String criteriFiltreUsuariLblText = TDSLanguageUtils.getMessage("gestioUsuari.criteriFiltreUsuariText");
    private String criteriFiltreTallerLblText = TDSLanguageUtils.getMessage("gestioUsuari.criteriFiltreTallerText");
    private String criteriFiltrePerfilLblText = TDSLanguageUtils.getMessage("gestioUsuari.criteriFiltrePerfilText");
    private String criteriFiltreActiuLblText = TDSLanguageUtils.getMessage("gestioUsuari.criteriFiltreActiuText");
    private String comboSiValueText = TDSLanguageUtils.getMessage("gestioUsuari.comboSiValueText");
    private String comboNoValueText = TDSLanguageUtils.getMessage("gestioUsuari.comboNoValueText");


    public GestioUsuariPanel() {

        JButton btnAltas = new JButton(altesBtnLabel);
        btnAltas.addActionListener(new GestioAltaUsuariActionListener());
        btnAltas.setBounds(25, 29, 129, 23);
        add(btnAltas);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 63, 724, 2);
        add(separator);

        JButton btnModificaciones = new JButton(modificacionsBtnLabel);
        btnModificaciones.addActionListener(new GestioModificacioUsuariActionListener());
        btnModificaciones.setBounds(25, 76, 200, 23);
        add(btnModificaciones);

        JButton btnBajas = new JButton(baixesBtnLabel);
        btnBajas.addActionListener(new GestioBaixaUsuariActionListener());
        btnBajas.setBounds(255, 76, 200, 23);
        add(btnBajas);

        JLabel lblCriteriosFiltro = new JLabel(criterisFiltreLblText);
        lblCriteriosFiltro.setBounds(25, 110, 87, 14);
        add(lblCriteriosFiltro);

        JLabel lblId = new JLabel(criteriFiltreIDLblText);
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setBounds(25, 135, 80, 14);
        add(lblId);

        JTextField idTxt = new JTextField();
        idTxt.setBounds(25, 160, 80, 20);
        add(idTxt);
        idTxt.setColumns(10);

        JTextField usuariTxt = new JTextField();
        usuariTxt.setColumns(10);
        usuariTxt.setBounds(126, 160, 140, 20);
        add(usuariTxt);

        JLabel UsuariLbl = new JLabel(criteriFiltreUsuariLblText);
        UsuariLbl.setHorizontalAlignment(SwingConstants.CENTER);
        UsuariLbl.setBounds(126, 135, 140, 14);
        add(UsuariLbl);

        JLabel lblTaller = new JLabel(criteriFiltreTallerLblText);
        lblTaller.setHorizontalAlignment(SwingConstants.CENTER);
        lblTaller.setBounds(276, 135, 80, 14);
        add(lblTaller);

        JLabel perfilLbl = new JLabel(criteriFiltrePerfilLblText);
        perfilLbl.setHorizontalAlignment(SwingConstants.CENTER);
        perfilLbl.setBounds(376, 135, 140, 14);
        add(perfilLbl);

        JLabel actiuLbl = new JLabel(criteriFiltreActiuLblText);
        actiuLbl.setHorizontalAlignment(SwingConstants.CENTER);
        actiuLbl.setBounds(526, 135, 80, 14);
        add(actiuLbl);

        JComboBox tallerComboBox = new JComboBox();
        //todo ESAU: rellenar con valores reales de taller
        tallerComboBox.setModel(new DefaultComboBoxModel(new String[] {"-", "1", "2", "3", "4"}));
        tallerComboBox.setBounds(276, 160, 80, 20);
        add(tallerComboBox);

        JComboBox perfilUsuariCmb = new JComboBox();
        String[] perfilUsuariCmbValues= new String[] {"-", PerfilUsuari.ADMINISTRADOR.toString(), PerfilUsuari.ADMINISTRATIU.toString(),
                                                        PerfilUsuari.CAPTALLER.toString(),PerfilUsuari.MECANIC.toString()};
        perfilUsuariCmb.setModel(new DefaultComboBoxModel(perfilUsuariCmbValues));
        perfilUsuariCmb.setSelectedIndex(0);
        perfilUsuariCmb.setBounds(376, 160, 140, 20);
        add(perfilUsuariCmb);

        JButton btnFiltrar = new JButton(filtrarBtnLabel);
        btnFiltrar.addActionListener(new FiltrarActionListener());
        btnFiltrar.setBounds(629, 159, 89, 23);
        add(btnFiltrar);

        JTable filteringTbl = new JTable();
        filteringTbl.setCellSelectionEnabled(true);
        filteringTbl.setColumnSelectionAllowed(true);
        filteringTbl.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        criteriFiltreIDLblText, criteriFiltreUsuariLblText, criteriFiltreTallerLblText, criteriFiltrePerfilLblText, criteriFiltreActiuLblText
                }
        ) {
            Class[] columnTypes = new Class[] {
                    Object.class, String.class, Integer.class, String.class, Boolean.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        filteringTbl.getColumnModel().getColumn(0).setResizable(false);
        filteringTbl.getColumnModel().getColumn(0).setPreferredWidth(100);
        filteringTbl.getColumnModel().getColumn(0).setMinWidth(100);
        filteringTbl.getColumnModel().getColumn(0).setMaxWidth(100);
        filteringTbl.getColumnModel().getColumn(1).setResizable(false);
        filteringTbl.getColumnModel().getColumn(1).setPreferredWidth(150);
        filteringTbl.getColumnModel().getColumn(1).setMinWidth(150);
        filteringTbl.getColumnModel().getColumn(1).setMaxWidth(150);
        filteringTbl.getColumnModel().getColumn(2).setPreferredWidth(100);
        filteringTbl.getColumnModel().getColumn(2).setMinWidth(100);
        filteringTbl.getColumnModel().getColumn(2).setMaxWidth(100);
        filteringTbl.getColumnModel().getColumn(3).setPreferredWidth(150);
        filteringTbl.getColumnModel().getColumn(3).setMinWidth(150);
        filteringTbl.getColumnModel().getColumn(3).setMaxWidth(150);
        filteringTbl.getColumnModel().getColumn(4).setResizable(false);
        filteringTbl.getColumnModel().getColumn(4).setPreferredWidth(80);
        filteringTbl.getColumnModel().getColumn(4).setMinWidth(80);
        filteringTbl.getColumnModel().getColumn(4).setMaxWidth(80);
        filteringTbl.setBounds(25, 191, 580, 255);
        add(filteringTbl);

        JButton btnSalir = new JButton(salirBtnLabel);
        btnSalir.addActionListener(new SalirActionListener());
        btnSalir.setBounds(578, 29, 140, 23);
        add(btnSalir);

        JComboBox activoCbx = new JComboBox();
        activoCbx.setModel(new DefaultComboBoxModel(new String[] {"-", comboSiValueText, comboNoValueText}));
        activoCbx.setBounds(526, 160, 80, 20);
        add(activoCbx);

    }


    private class GestioAltaUsuariActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AltaUsuariDialog altaUsuariDialog = new AltaUsuariDialog();
            altaUsuariDialog.setVisible(true);
            altaUsuariDialog.setModal(true);
        }
    }

    private class GestioModificacioUsuariActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //todo pasar por parametro el Usuari seleccionado al constructor
            ModificaUsuariDialog modificaUsuariDialog = new ModificaUsuariDialog(null);
            modificaUsuariDialog.setVisible(true);
            modificaUsuariDialog.setModal(true);
        }
    }

    private class GestioBaixaUsuariActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //todo pasar por parametro el Usuari seleccionado al constructor
            BaixaUsuariDialog baixaUsuariDialog = new BaixaUsuariDialog(null);
            baixaUsuariDialog.setVisible(true);
            baixaUsuariDialog.setModal(true);
        }
    }

    private class FiltrarActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    private class SalirActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
