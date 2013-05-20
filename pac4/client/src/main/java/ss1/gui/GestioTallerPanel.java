package ss1.gui;

import common.utils.TDSLanguageUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 19/05/13
 * Time: 16:35
 */
public class GestioTallerPanel extends JPanel{

    private String altesBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.altesBtnLabel");
    private String modificacionsBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.modificacionsBtnLabel");
    private String baixesBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.baixesBtnLabel");
    private String filtrarBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.filtrarBtnLabel");
    private String salirBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.salirBtnLabel");
    private String criterisFiltreLblText = TDSLanguageUtils.getMessage("gestioTaller.criterisFiltreText");
    private String criteriFiltreIDLblText = TDSLanguageUtils.getMessage("gestioTaller.criteriFiltreIDText");
    private String criteriFiltreNomLblText = TDSLanguageUtils.getMessage("gestioTaller.criteriFiltreNomText");
    private String criteriFiltreAdrecaLblText = TDSLanguageUtils.getMessage("gestioTaller.criteriFiltreAdrecaText");
    private String criteriFiltreCapacidadLblText = TDSLanguageUtils.getMessage("gestioTaller.criteriFiltreCapacidadText");
    private String criteriFiltreCIFLblText = TDSLanguageUtils.getMessage("gestioTaller.criteriFiltreCIFText");
    private String criteriFiltreCapTallerLblText = TDSLanguageUtils.getMessage("gestioTaller.criteriFiltreCapTallerText");
    private String criteriFiltreTelefonLblText = TDSLanguageUtils.getMessage("gestioTaller.criteriFiltreTelefonText");
    private String criteriFiltreWebLblText = TDSLanguageUtils.getMessage("gestioTaller.criteriFiltreWebText");
    private String criteriFiltreActiuLblText = TDSLanguageUtils.getMessage("gestioTaller.criteriFiltreActiuText");
    private String comboSiValueText = TDSLanguageUtils.getMessage("gestioTaller.comboSiValueText");
    private String comboNoValueText = TDSLanguageUtils.getMessage("gestioTaller.comboNoValueText");

    private static final long serialVersionUID = 1L;
    private JTextField idTxt;
    private JTextField nomTxt;
    private JTable filteringTbl;
    private JTextField adrecaTextField;
    private JTextField capacidadTextField;
    private JTextField cifTextField;
    private JTextField jefeTallerTextField;
    private JTextField telefonTextField;
    private JTextField webTextField_1;


    public GestioTallerPanel() {
        setLayout(null);

        JButton btnAltas = new JButton(altesBtnLabel);
        btnAltas.setBounds(25, 29, 129, 23);
        add(btnAltas);
        btnAltas.addActionListener(new GestionAltaTallerActionListener());

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 63, 986, 2);
        add(separator);

        JButton btnModificaciones = new JButton(modificacionsBtnLabel);
        btnModificaciones.addActionListener(new GestionModificacionTallerActionListener());
        btnModificaciones.setBounds(25, 76, 200, 23);
        add(btnModificaciones);

        JButton btnBajas = new JButton(baixesBtnLabel);
        btnBajas.addActionListener(new GestionBajaTallerActionListener());
        btnBajas.setBounds(255, 76, 200, 23);
        add(btnBajas);

        JLabel lblCriteriosFiltro = new JLabel(criterisFiltreLblText);
        lblCriteriosFiltro.setBounds(25, 110, 87, 14);
        add(lblCriteriosFiltro);

        JLabel lblId = new JLabel(criteriFiltreIDLblText);
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setBounds(25, 135, 51, 14);
        add(lblId);

        idTxt = new JTextField();
        idTxt.setBounds(25, 160, 51, 20);
        add(idTxt);
        idTxt.setColumns(10);

        nomTxt = new JTextField();
        nomTxt.setColumns(10);
        nomTxt.setBounds(147, 160, 140, 20);
        add(nomTxt);

        JLabel nombreLbl = new JLabel(criteriFiltreNomLblText);
        nombreLbl.setHorizontalAlignment(SwingConstants.CENTER);
        nombreLbl.setBounds(147, 135, 140, 14);
        add(nombreLbl);

        JLabel actiuLbl = new JLabel(criteriFiltreActiuLblText);
        actiuLbl.setHorizontalAlignment(SwingConstants.CENTER);
        actiuLbl.setBounds(931, 135, 51, 14);
        add(actiuLbl);

        JButton btnFiltrar = new JButton(filtrarBtnLabel);
        btnFiltrar.setBounds(863, 442, 119, 23);
        add(btnFiltrar);

        filteringTbl = new JTable();
        filteringTbl.setCellSelectionEnabled(true);
        filteringTbl.setColumnSelectionAllowed(true);
        filteringTbl.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                },
                new String[] {
                        criteriFiltreIDLblText, criteriFiltreCIFLblText, criteriFiltreNomLblText, criteriFiltreAdrecaLblText, criteriFiltreCapacidadLblText, criteriFiltreCapTallerLblText, criteriFiltreTelefonLblText, criteriFiltreWebLblText, criteriFiltreActiuLblText
                }
        ) {
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, String.class, String.class, Integer.class, Object.class, String.class, String.class, Boolean.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        filteringTbl.getColumnModel().getColumn(0).setResizable(false);
        filteringTbl.getColumnModel().getColumn(0).setPreferredWidth(56);
        filteringTbl.getColumnModel().getColumn(0).setMinWidth(56);
        filteringTbl.getColumnModel().getColumn(0).setMaxWidth(56);
        filteringTbl.getColumnModel().getColumn(1).setResizable(false);
        filteringTbl.getColumnModel().getColumn(1).setPreferredWidth(61);
        filteringTbl.getColumnModel().getColumn(1).setMinWidth(61);
        filteringTbl.getColumnModel().getColumn(1).setMaxWidth(61);
        filteringTbl.getColumnModel().getColumn(2).setPreferredWidth(150);
        filteringTbl.getColumnModel().getColumn(2).setMinWidth(150);
        filteringTbl.getColumnModel().getColumn(2).setMaxWidth(150);
        filteringTbl.getColumnModel().getColumn(3).setPreferredWidth(145);
        filteringTbl.getColumnModel().getColumn(3).setMinWidth(145);
        filteringTbl.getColumnModel().getColumn(3).setMaxWidth(145);
        filteringTbl.getColumnModel().getColumn(4).setPreferredWidth(45);
        filteringTbl.getColumnModel().getColumn(4).setMinWidth(45);
        filteringTbl.getColumnModel().getColumn(4).setMaxWidth(45);
        filteringTbl.getColumnModel().getColumn(5).setPreferredWidth(150);
        filteringTbl.getColumnModel().getColumn(5).setMinWidth(150);
        filteringTbl.getColumnModel().getColumn(5).setMaxWidth(150);
        filteringTbl.getColumnModel().getColumn(6).setPreferredWidth(150);
        filteringTbl.getColumnModel().getColumn(6).setMinWidth(150);
        filteringTbl.getColumnModel().getColumn(6).setMaxWidth(150);
        filteringTbl.getColumnModel().getColumn(7).setPreferredWidth(150);
        filteringTbl.getColumnModel().getColumn(7).setMinWidth(150);
        filteringTbl.getColumnModel().getColumn(7).setMaxWidth(150);
        filteringTbl.getColumnModel().getColumn(8).setResizable(false);
        filteringTbl.getColumnModel().getColumn(8).setPreferredWidth(56);
        filteringTbl.getColumnModel().getColumn(8).setMinWidth(56);
        filteringTbl.getColumnModel().getColumn(8).setMaxWidth(56);
        filteringTbl.setBounds(25, 191, 958, 240);
        add(filteringTbl);

        JButton btnSalir = new JButton(salirBtnLabel);
        btnSalir.setBounds(856, 29, 140, 23);
        add(btnSalir);

        JComboBox activoCbx = new JComboBox();
        activoCbx.setModel(new DefaultComboBoxModel(new String[] {"-", comboSiValueText, comboNoValueText}));
        activoCbx.setBounds(931, 160, 51, 20);
        add(activoCbx);

        JLabel adrecaLabel = new JLabel(criteriFiltreAdrecaLblText);
        adrecaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        adrecaLabel.setBounds(297, 135, 140, 14);
        add(adrecaLabel);

        adrecaTextField = new JTextField();
        adrecaTextField.setColumns(10);
        adrecaTextField.setBounds(297, 160, 140, 20);
        add(adrecaTextField);

        JLabel capacitatLabel = new JLabel(criteriFiltreCapacidadLblText);
        capacitatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        capacitatLabel.setBounds(427, 135, 62, 14);
        add(capacitatLabel);

        capacidadTextField = new JTextField();
        capacidadTextField.setColumns(10);
        capacidadTextField.setBounds(444, 160, 34, 20);
        add(capacidadTextField);

        JLabel cifLabel = new JLabel(criteriFiltreCIFLblText);
        cifLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cifLabel.setBounds(86, 135, 51, 14);
        add(cifLabel);

        cifTextField = new JTextField();
        cifTextField.setColumns(10);
        cifTextField.setBounds(86, 160, 51, 20);
        add(cifTextField);

        JLabel capTallerLabel = new JLabel(criteriFiltreCapTallerLblText);
        capTallerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        capTallerLabel.setBounds(488, 135, 140, 14);
        add(capTallerLabel);

        jefeTallerTextField = new JTextField();
        jefeTallerTextField.setColumns(10);
        jefeTallerTextField.setBounds(488, 160, 140, 20);
        add(jefeTallerTextField);

        JLabel telefonLabel = new JLabel(criteriFiltreTelefonLblText);
        telefonLabel.setHorizontalAlignment(SwingConstants.CENTER);
        telefonLabel.setBounds(638, 135, 140, 14);
        add(telefonLabel);

        telefonTextField = new JTextField();
        telefonTextField.setColumns(10);
        telefonTextField.setBounds(638, 160, 140, 20);
        add(telefonTextField);

        JLabel webLabel = new JLabel(criteriFiltreWebLblText);
        webLabel.setHorizontalAlignment(SwingConstants.CENTER);
        webLabel.setBounds(788, 135, 140, 14);
        add(webLabel);

        webTextField_1 = new JTextField();
        webTextField_1.setColumns(10);
        webTextField_1.setBounds(788, 160, 140, 20);
        add(webTextField_1);

    }

    private class GestionAltaTallerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AltaTallerDialog altaTallerDialog = new AltaTallerDialog();
            altaTallerDialog.setVisible(true);
            altaTallerDialog.setModal(true);
        }
    }

    private class GestionModificacionTallerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //todo pasarle el usuario seleccionado en el filtro
            ModificaTallerDialog modificaTallerDialog = new ModificaTallerDialog(null);
            modificaTallerDialog.setVisible(true);
            modificaTallerDialog.setModal(true);
        }
    }

    private class GestionBajaTallerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //todo pasarle el usuario seleccionado en el filtro
            BaixaTallerDialog baixaTallerDialog = new BaixaTallerDialog(null);
            baixaTallerDialog.setVisible(true);
            baixaTallerDialog.setModal(true);
        }
    }
}
