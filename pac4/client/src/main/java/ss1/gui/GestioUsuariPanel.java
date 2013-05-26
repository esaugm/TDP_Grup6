package ss1.gui;

import common.entity.PerfilUsuari;
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
 * Time: 16:33
 */
public class GestioUsuariPanel extends JPanel{
    private Client client;
    private List<Usuari> filteredUsuariList;
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
    private String criteriFiltreNomLblText = TDSLanguageUtils.getMessage("gestioUsuari.criteriFiltreNomText");
    private String criteriFiltreCognomLblText = TDSLanguageUtils.getMessage("gestioUsuari.criteriFiltreCognomText");
    private String criteriFiltreNONELblText = TDSLanguageUtils.getMessage("gestioUsuari.criteriFiltreNONEText");
    private String comboSiValueText = TDSLanguageUtils.getMessage("gestioUsuari.comboSiValueText");
    private String comboNoValueText = TDSLanguageUtils.getMessage("gestioUsuari.comboNoValueText");

    JTextField idTxt;
    JTextField nomTxt;
    JTextField usuariTxt;
    JTextField apellidosTextField;
    JTextField nifTextField;
    JComboBox tallerComboBox;
    JComboBox perfilUsuariCmb;
    JComboBox activoCbx;
    JTable filteringTbl;
    JScrollPane scrollPane;

    public GestioUsuariPanel(Client pClient) throws ExceptionErrorDataBase, RemoteException {
        client=pClient;

        JButton btnAltas = new JButton(altesBtnLabel);
        btnAltas.addActionListener(new GestioAltaUsuariActionListener());
        btnAltas.setBounds(25, 29, 129, 23);
        add(btnAltas);

        JSeparator separator = new JSeparator();
        separator.setBounds(25, 63, 917, 2);
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
        lblId.setBounds(25, 135, 51, 14);
        add(lblId);

        idTxt = new JTextField();
        idTxt.setBounds(25, 160, 51, 20);
        add(idTxt);
        idTxt.setColumns(10);

        usuariTxt = new JTextField();
        usuariTxt.setColumns(10);
        usuariTxt.setBounds(591, 160, 140, 20);
        add(usuariTxt);

        nomTxt = new JTextField();
        nomTxt.setColumns(10);
        nomTxt.setBounds(147, 160, 140, 20);
        add(nomTxt);

        JLabel nombreLbl = new JLabel(criteriFiltreNomLblText);
        nombreLbl.setHorizontalAlignment(SwingConstants.CENTER);
        nombreLbl.setBounds(147, 135, 140, 14);
        add(nombreLbl);

        JLabel cognomLabel = new JLabel(criteriFiltreCognomLblText);
        cognomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cognomLabel.setBounds(297, 135, 140, 14);
        add(cognomLabel);

        apellidosTextField = new JTextField();
        apellidosTextField.setColumns(10);
        apellidosTextField.setBounds(297, 160, 134, 20);
        add(apellidosTextField);

        JLabel cifLabel = new JLabel("CIF");
        cifLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cifLabel.setBounds(86, 135, 51, 14);
        add(cifLabel);

        nifTextField = new JTextField();
        nifTextField.setColumns(10);
        nifTextField.setBounds(86, 160, 51, 20);
        add(nifTextField);
        
        JLabel usuariLbl = new JLabel(criteriFiltreUsuariLblText);
        usuariLbl.setHorizontalAlignment(SwingConstants.CENTER);
        usuariLbl.setBounds(591, 135, 140, 14);;
        add(usuariLbl);

        JLabel lblTaller = new JLabel(criteriFiltreTallerLblText);
        lblTaller.setHorizontalAlignment(SwingConstants.CENTER);
        lblTaller.setBounds(447, 135, 140, 14);
        add(lblTaller);

        JLabel perfilLbl = new JLabel(criteriFiltrePerfilLblText);
        perfilLbl.setHorizontalAlignment(SwingConstants.CENTER);
        perfilLbl.setBounds(741, 135, 140, 14);
        add(perfilLbl);

        JLabel actiuLbl = new JLabel(criteriFiltreActiuLblText);
        actiuLbl.setHorizontalAlignment(SwingConstants.CENTER);
        actiuLbl.setBounds(891, 135, 51, 14);
        add(actiuLbl);

        tallerComboBox = new JComboBox();
        //añadimos la lista de todos los talleres al comboBox
        Vector<Taller> tallers = new Vector<Taller>(client.listaTallers());
        //añadimos un taller vacío para que este seleccionado por defecto: significa que no se quiere filtrar por taller
        Taller emptyTaller =  new Taller();
        emptyTaller.setNom(criteriFiltreNONELblText);
        emptyTaller.setId(-1);
        tallers.add(0,emptyTaller);
        tallerComboBox.setModel(new DefaultComboBoxModel(tallers));
        tallerComboBox.setBounds(441, 160, 140, 20);
        add(tallerComboBox);

        perfilUsuariCmb = new JComboBox();
        String[] perfilUsuariCmbValues= new String[] {"-", PerfilUsuari.ADMINISTRADOR.toString(), PerfilUsuari.ADMINISTRATIU.toString(),
                                                        PerfilUsuari.CAPTALLER.toString(),PerfilUsuari.MECANIC.toString()};
        perfilUsuariCmb.setModel(new DefaultComboBoxModel(perfilUsuariCmbValues));
        perfilUsuariCmb.setSelectedIndex(0);
        perfilUsuariCmb.setBounds(741, 160, 140, 20);
        add(perfilUsuariCmb);

        JButton btnFiltrar = new JButton(filtrarBtnLabel);
        btnFiltrar.addActionListener(new FiltrarActionListener());
        btnFiltrar.setBounds(823, 442, 119, 23);
        add(btnFiltrar);

        filteringTbl = crearTabla();

        add(filteringTbl);

        activoCbx = new JComboBox();
        activoCbx.setModel(new DefaultComboBoxModel(new String[]{"-", comboSiValueText, comboNoValueText}));
        activoCbx.setBounds(891, 160, 51, 20);
        add(activoCbx);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 191, 933, 240);
        add(scrollPane);
        scrollPane.setViewportView(filteringTbl);

    }

    private JTable crearTabla() {
        DefaultTableModel tableModel = (new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                },
                new String[] {
                        "ID", "NIF", "Nombre", "Apellidos", "Taller", "Usuario", "Perfil", "Activo"
                }
        ){
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, String.class, String.class, Taller.class, String.class, String.class, String.class
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
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setMinWidth(150);
        table.getColumnModel().getColumn(4).setMaxWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setMinWidth(150);
        table.getColumnModel().getColumn(5).setMaxWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setMinWidth(150);
        table.getColumnModel().getColumn(6).setMaxWidth(150);
        table.getColumnModel().getColumn(7).setResizable(false);
        table.getColumnModel().getColumn(7).setPreferredWidth(56);
        table.getColumnModel().getColumn(7).setMinWidth(56);
        table.getColumnModel().getColumn(7).setMaxWidth(56);
        table.setBounds(25, 191, 918, 240);
        return table;
    }


    private class GestioAltaUsuariActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AltaUsuariDialog altaUsuariDialog = null;
            try {
                altaUsuariDialog = new AltaUsuariDialog(client);
            } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                //todo pensar que se hace aqui
                exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (RemoteException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            altaUsuariDialog.setVisible(true);
            altaUsuariDialog.setModal(true);
        }
    }

    private class GestioModificacioUsuariActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ModificaUsuariDialog modificaUsuariDialog = null;
            try {
                int selectedRow = filteringTbl.getSelectedRow();
                if(selectedRow==-1){
                    JOptionPane.showMessageDialog(filteringTbl, "No hay seleccionado ningún usuario", "Usuario no seleccionado Error", JOptionPane.ERROR_MESSAGE);

                }
                Integer selectedUsuariId = Integer.parseInt((String) filteringTbl.getValueAt(selectedRow, 0));
                Usuari selectedUsuari=null;
                for (Usuari usuari : filteredUsuariList) {
                    if (usuari.getId().equals(selectedUsuariId)) {
                        selectedUsuari = usuari;
                        break;
                    }
                }
                System.out.println("usuari selected: " + selectedUsuari.getUsuari());
                modificaUsuariDialog = new ModificaUsuariDialog(client, selectedUsuari);
            } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                //todo pensar que hacer aqui
                exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (RemoteException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            modificaUsuariDialog.setVisible(true);
            modificaUsuariDialog.setModal(true);
        }
    }

    private class GestioBaixaUsuariActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //todo pasar por parametro el Usuari seleccionado al constructor
            BaixaUsuariDialog baixaUsuariDialog = null;
            try {
                int selectedRow = filteringTbl.getSelectedRow();
                if(selectedRow==-1){
                    JOptionPane.showMessageDialog(filteringTbl, "No hay seleccionado ningún usuario", "Usuario no seleccionado Error", JOptionPane.ERROR_MESSAGE);

                }
                Integer selectedUsuariId = Integer.parseInt((String) filteringTbl.getValueAt(selectedRow, 0));
                Usuari selectedUsuari=null;
                for (Usuari usuari : filteredUsuariList) {
                    if (usuari.getId().equals(selectedUsuariId)) {
                        selectedUsuari = usuari;
                        break;
                    }
                }
                System.out.println("usuari selected: " + selectedUsuari.getUsuari());
                baixaUsuariDialog = new BaixaUsuariDialog(client, selectedUsuari);
            } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                //todo pensar que hacer aqui
                exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (RemoteException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            baixaUsuariDialog.setVisible(true);
            baixaUsuariDialog.setModal(true);
        }
    }

    private class FiltrarActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //crear FilterItems con los valores de filtro
            FilterItems filterItems = new FilterItems();
            if (!idTxt.getText().isEmpty()) filterItems.addFilterValue("id",Integer.parseInt(idTxt.getText()));
            if (!usuariTxt.getText().isEmpty()) filterItems.addFilterValue("usuari",usuariTxt.getText());
            if (!criteriFiltreNONELblText.equals(((Taller) tallerComboBox.getSelectedItem()).getNom())) 
                filterItems.addFilterValue("taller",((Taller) tallerComboBox.getSelectedItem()).getId());
            if(!"-".equals(perfilUsuariCmb.getSelectedItem().toString())) filterItems.addFilterValue("perfil",perfilUsuariCmb.getSelectedItem());
            if(!"-".equals(activoCbx.getSelectedItem().toString())) filterItems.addFilterValue("actiu", activoCbx.getSelectedItem().toString().equals(comboSiValueText));
            if(!nomTxt.getText().isEmpty()) filterItems.addFilterValue("nom", nomTxt.getText());
            if(!nifTextField.getText().isEmpty()) filterItems.addFilterValue("nif", nifTextField.getText());
            if(!apellidosTextField.getText().isEmpty()) filterItems.addFilterValue("cognom", apellidosTextField.getText());
                    
            //pedir al interface los valores filtrados y rellenar la tabla
            try {
                DefaultTableModel tableModel = (DefaultTableModel) filteringTbl.getModel();
                int rowCount = tableModel.getRowCount();
                filteredUsuariList = client.filtrarUsuaris(filterItems);
                int i=0;
                for (Usuari usuari : filteredUsuariList) {
                    if(i==rowCount-1) tableModel.addRow(new Object[]{});
                    tableModel.setValueAt(usuari.getId().toString(),i, 0);
                    tableModel.setValueAt(usuari.getNif(),i, 1);
                    tableModel.setValueAt(usuari.getNom(),i, 2);
                    tableModel.setValueAt(usuari.getCognoms(),i, 3);
                    tableModel.setValueAt(usuari.getTaller().toString(),i, 4);
                    tableModel.setValueAt(usuari.getUsuari(),i, 5);
                    tableModel.setValueAt(usuari.getPerfil().toString(),i, 6);
                    tableModel.setValueAt(usuari.isActiu()?comboSiValueText:comboNoValueText,i, 7);
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
