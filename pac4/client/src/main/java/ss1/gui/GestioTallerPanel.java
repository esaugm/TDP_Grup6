package ss1.gui;

import common.rmi.Client;
import common.utils.TDSLanguageUtils;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.entity.Taller;
import ss1.entity.Usuari;
import ss1.service.filter.FilterItems;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 19/05/13
 * Time: 16:35
 */
public class GestioTallerPanel extends JPanel{
    private Client client;
    private List<Taller> filteredTallerList;
    private String altesBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.altesBtnLabel");
    private String modificacionsBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.modificacionsBtnLabel");
    private String baixesBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.baixesBtnLabel");
    private String filtrarBtnLabel = TDSLanguageUtils.getMessage("gestioTaller.filtrarBtnLabel");
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
    private String criteriFiltreNONELblText = TDSLanguageUtils.getMessage("gestioTaller.criteriFiltreNONEText");
    private String comboSiValueText = TDSLanguageUtils.getMessage("gestioTaller.comboSiValueText");
    private String comboNoValueText = TDSLanguageUtils.getMessage("gestioTaller.comboNoValueText");

    private static final long serialVersionUID = 1L;
    private JTextField idTxt;
    private JTextField nomTxt;
    private JTable filteringTbl;
    private JTextField adrecaTextField;
    private JTextField capacidadTextField;
    private JTextField cifTextField;
    private JComboBox jefeTallerComboBox;
    private JTextField telefonTextField;
    private JTextField webTextField;
    private JComboBox activoCbx;
    private JScrollPane scrollPane;


    public GestioTallerPanel(Client pClient) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido, RemoteException {
        client =pClient;
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
        btnFiltrar.addActionListener(new FiltrarActionListener());
        add(btnFiltrar);

        filteringTbl = crearTabla();

        add(filteringTbl);

        activoCbx = new JComboBox();
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

        jefeTallerComboBox = new JComboBox();
        Vector<Usuari> capsTaller = new Vector<Usuari>(client.listaCapsTaller());
        jefeTallerComboBox.setModel(new DefaultComboBoxModel(capsTaller));
        jefeTallerComboBox.setBounds(488, 160, 140, 20);
        add(jefeTallerComboBox);

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

        webTextField = new JTextField();
        webTextField.setColumns(10);
        webTextField.setBounds(788, 160, 140, 20);
        add(webTextField);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 191, 970, 240);
        add(scrollPane);
        scrollPane.setViewportView(filteringTbl);

    }

    private JTable crearTabla() {
        DefaultTableModel tableModel = (new DefaultTableModel(
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
                    Integer.class, String.class, String.class, String.class, Integer.class, Object.class, String.class, String.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        return createTabla(tableModel);
    }

    private JTable createTabla(DefaultTableModel tableModel) {
        JTable table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.setModel(tableModel);
        table.setRowSelectionAllowed(true);

        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(56);
        table.getColumnModel().getColumn(0).setMinWidth(56);
        table.getColumnModel().getColumn(0).setMaxWidth(56);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(61);
        table.getColumnModel().getColumn(1).setMinWidth(61);
        table.getColumnModel().getColumn(1).setMaxWidth(61);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setMinWidth(150);
        table.getColumnModel().getColumn(2).setMaxWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(145);
        table.getColumnModel().getColumn(3).setMinWidth(145);
        table.getColumnModel().getColumn(3).setMaxWidth(145);
        table.getColumnModel().getColumn(4).setPreferredWidth(45);
        table.getColumnModel().getColumn(4).setMinWidth(45);
        table.getColumnModel().getColumn(4).setMaxWidth(45);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setMinWidth(150);
        table.getColumnModel().getColumn(5).setMaxWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setMinWidth(150);
        table.getColumnModel().getColumn(6).setMaxWidth(150);
        table.getColumnModel().getColumn(7).setPreferredWidth(150);
        table.getColumnModel().getColumn(7).setMinWidth(150);
        table.getColumnModel().getColumn(7).setMaxWidth(150);
        table.getColumnModel().getColumn(8).setResizable(false);
        table.getColumnModel().getColumn(8).setPreferredWidth(56);
        table.getColumnModel().getColumn(8).setMinWidth(56);
        table.getColumnModel().getColumn(8).setMaxWidth(56);
        table.setBounds(25, 191, 958, 240);
        add(table);
        return table;
    }

    private class GestionAltaTallerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AltaTallerDialog altaTallerDialog = null;
            try {
                altaTallerDialog = new AltaTallerDialog(client);
                altaTallerDialog.setVisible(true);
                altaTallerDialog.setModal(true);
            } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                //todo pensar que hacer aqui
                exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (RemoteException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ExceptionTipoObjetoFiltroNoPermitido exceptionTipoObjetoFiltroNoPermitido) {
                exceptionTipoObjetoFiltroNoPermitido.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    private class GestionModificacionTallerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //todo pasarle el usuario seleccionado en el filtro
            ModificaTallerDialog modificaTallerDialog = null;
            try {
                int selectedRow = filteringTbl.getSelectedRow();
                if(selectedRow==-1){
                    JOptionPane.showMessageDialog(filteringTbl, "No hay seleccionado ningún usuario", "Usuario no seleccionado Error", JOptionPane.ERROR_MESSAGE);

                }
                Integer selectedTallerId = Integer.parseInt((String) filteringTbl.getValueAt(selectedRow, 0));
                Taller selectedTaller=null;
                for (Taller taller : filteredTallerList) {
                    if (taller.getId().equals(selectedTallerId)) {
                        selectedTaller = taller;
                        break;
                    }
                }
                System.out.println("usuari selected: " + selectedTaller.getNom());

                modificaTallerDialog = new ModificaTallerDialog(selectedTaller, client);
                modificaTallerDialog.setVisible(true);
                modificaTallerDialog.setModal(true);
            } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                //todo pensar que hacer aqui
                exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ExceptionTipoObjetoFiltroNoPermitido exceptionTipoObjetoFiltroNoPermitido) {
                exceptionTipoObjetoFiltroNoPermitido.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (RemoteException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    private class GestionBajaTallerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //todo pasarle el usuario seleccionado en el filtro
            BaixaTallerDialog baixaTallerDialog = null;
            try {
                baixaTallerDialog = new BaixaTallerDialog(null, client);
                baixaTallerDialog.setVisible(true);
                baixaTallerDialog.setModal(true);
            } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                //todo pensar que hacer aqui
                exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ExceptionTipoObjetoFiltroNoPermitido exceptionTipoObjetoFiltroNoPermitido) {
                exceptionTipoObjetoFiltroNoPermitido.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (RemoteException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    private class FiltrarActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //crear FilterItems con los valores de filtro
            FilterItems filterItems = new FilterItems();
            if (!idTxt.getText().isEmpty()) filterItems.addFilterValue("id",Integer.parseInt(idTxt.getText()));
            if (!cifTextField.getText().isEmpty()) filterItems.addFilterValue("cif",cifTextField.getText());
            if (!criteriFiltreNONELblText.equals(((Usuari) jefeTallerComboBox.getSelectedItem()).getNom()))
                filterItems.addFilterValue("captaller",((Usuari) jefeTallerComboBox.getSelectedItem()).getId());
            if(!"-".equals(activoCbx.getSelectedItem().toString())) filterItems.addFilterValue("actiu", activoCbx.getSelectedItem().toString().equals(comboSiValueText));
            if(!nomTxt.getText().isEmpty()) filterItems.addFilterValue("nom", nomTxt.getText());
            if(!adrecaTextField.getText().isEmpty()) filterItems.addFilterValue("adreca", adrecaTextField.getText());
            if(!capacidadTextField.getText().isEmpty()) filterItems.addFilterValue("cognom", capacidadTextField.getText());
            if(!telefonTextField.getText().isEmpty()) filterItems.addFilterValue("telefon", telefonTextField.getText());
            if(!webTextField.getText().isEmpty()) filterItems.addFilterValue("web", webTextField.getText());

            //pedir al interface los valores filtrados y rellenar la tabla
            try {
                DefaultTableModel tableModel = (DefaultTableModel) filteringTbl.getModel();
                int rowCount = tableModel.getRowCount();
                filteredTallerList = client.filtrarTaller(filterItems);
                int i=0;
                for (Taller taller : filteredTallerList) {
                    if(i==rowCount-1) tableModel.addRow(new Object[]{});
                    tableModel.setValueAt(taller.getId().toString(),i, 0);
                    tableModel.setValueAt(taller.getCif(),i, 1);
                    tableModel.setValueAt(taller.getNom(),i, 2);
                    tableModel.setValueAt(taller.getAdreca(),i, 3);
                    tableModel.setValueAt(taller.getCapacitat().toString(),i, 4);
                    tableModel.setValueAt(taller.getCapTaller(),i, 5);
                    tableModel.setValueAt(taller.getTelefon().toString(),i, 6);
                    tableModel.setValueAt(taller.getWeb().toString(),i, 7);
                    tableModel.setValueAt(taller.isActiu()?comboSiValueText:comboNoValueText,i, 8);
                    i++;
                }
                for (int rowIdx=i;rowIdx<rowCount ;rowIdx++){
                    tableModel.setValueAt("",rowIdx,0);
                    tableModel.setValueAt("",rowIdx,1);
                    tableModel.setValueAt("",rowIdx,2);
                    tableModel.setValueAt("",rowIdx,3);
                    tableModel.setValueAt("",rowIdx,4);
                    tableModel.setValueAt("",rowIdx,5);
                    tableModel.setValueAt("",rowIdx,6);
                    tableModel.setValueAt("",rowIdx,7);
                    tableModel.setValueAt("",rowIdx,8);
                }

                filteringTbl= createTabla(tableModel);
                scrollPane.setViewportView(filteringTbl);
            } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                //todo pensar que se hace aqui
                exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ExceptionTipoObjetoFiltroNoPermitido exceptionTipoObjetoFiltroNoPermitido) {
                exceptionTipoObjetoFiltroNoPermitido.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (RemoteException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
    }
}
