package ss4.gui;

import common.utils.TDSLanguageUtils;
import ss4.model.EstadisticaReparaciones;
import ss4.model.ReparacionTableModel;
import ss4.server.ISS4Estadisticas;
import ss4.util.DateFormat;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class ReparacionesEstaPanel extends JPanel {
    private JTextField _textNomMecanic;
    private JTextField _textNomClient;
    private JTextField _textIdReparacio;
    private JFormattedTextField _ftextInici;
    private JFormattedTextField _ftextFin;
    private JButton _btnBuscar;
    private JTable _tableReparaciones;
    private ReparacionTableModel _model;
    private List<EstadisticaReparaciones> _reparaciones;
    private ISS4Estadisticas _remote;
    private JPanel panel;
    private JLabel lblIdReparacion;
    private JLabel lblNombreCliente;
    private JLabel lblNombreMecanico;
    private JLabel lblFechaInicio;
    private JLabel lblFechaFin;
    private JScrollPane scrollPane;
    private JButton _btnImprimir;

    /**
     * Create the panel.
     */
    public ReparacionesEstaPanel(ISS4Estadisticas remote) throws ParseException {
        _remote = remote;
        _reparaciones = new ArrayList<EstadisticaReparaciones>();

        _model = new ReparacionTableModel(_reparaciones);
        setLayout(new BorderLayout(0, 0));
        _tableReparaciones = new JTable(_model);
        _tableReparaciones.setBorder(new EmptyBorder(15, 0, 0, 0));
        _tableReparaciones.setRowSelectionAllowed(false);
        _tableReparaciones.getTableHeader().setVisible(true);

        _tableReparaciones.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(_tableReparaciones);

        add(scrollPane, BorderLayout.CENTER);

        panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{155, 150, 150, 150, 139, 31, 89, 0, 0};
        gbl_panel.rowHeights = new int[]{46, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        _btnBuscar = new JButton(TDSLanguageUtils.getMessage("client.ss4.button.search"));
        _btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Map values = new LinkedHashMap();
                try {
                    if (!_textIdReparacio.getText().isEmpty()) {
                        values.put("idReparacion", Integer.valueOf(_textIdReparacio.getText()));
                    }
                    if (!_textNomClient.getText().isEmpty()) {
                        values.put("cliente", _textNomClient.getText());
                    }
                    if (!_textNomMecanic.getText().isEmpty()) {
                        values.put("mecanico", _textNomMecanic.getText());
                    }
                    if (!_ftextInici.getText().isEmpty()) {
                        values.put("inicio", _ftextInici.getText());
                    }
                    if (!_ftextFin.getText().isEmpty()) {
                        values.put("fin", _ftextFin.getText());
                    }
                    _reparaciones = _remote.findReparacionesByTerms(values);
                    if(_reparaciones.size()==0){
                        JOptionPane.showMessageDialog(panel, "No se han encontrado datos con los parametros de busqueda , porfavor Modique su busqueda.");
                    }
                    _model.reloadData(_reparaciones);
                    scrollPane.repaint();

                    System.out.println(_tableReparaciones.getRowCount());
                } catch (RemoteException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        lblIdReparacion = new JLabel(TDSLanguageUtils.getMessage("client.ss4.label.idReparacion"));
        lblIdReparacion.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblIdReparacion = new GridBagConstraints();
        gbc_lblIdReparacion.anchor = GridBagConstraints.SOUTH;
        gbc_lblIdReparacion.insets = new Insets(0, 0, 5, 5);
        gbc_lblIdReparacion.gridx = 0;
        gbc_lblIdReparacion.gridy = 0;
        panel.add(lblIdReparacion, gbc_lblIdReparacion);

        lblNombreCliente = new JLabel(TDSLanguageUtils.getMessage("client.ss4.label.cliente"));
        lblNombreCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblNombreCliente = new GridBagConstraints();
        gbc_lblNombreCliente.anchor = GridBagConstraints.SOUTH;
        gbc_lblNombreCliente.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombreCliente.gridx = 1;
        gbc_lblNombreCliente.gridy = 0;
        panel.add(lblNombreCliente, gbc_lblNombreCliente);

        lblNombreMecanico = new JLabel(TDSLanguageUtils.getMessage("client.ss4.label.mecanico"));
        lblNombreMecanico.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblNombreMecanico = new GridBagConstraints();
        gbc_lblNombreMecanico.anchor = GridBagConstraints.SOUTH;
        gbc_lblNombreMecanico.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombreMecanico.gridx = 2;
        gbc_lblNombreMecanico.gridy = 0;
        panel.add(lblNombreMecanico, gbc_lblNombreMecanico);

        lblFechaInicio = new JLabel(TDSLanguageUtils.getMessage("client.ss4.label.finicio"));
        lblFechaInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblFechaInicio = new GridBagConstraints();
        gbc_lblFechaInicio.anchor = GridBagConstraints.SOUTH;
        gbc_lblFechaInicio.insets = new Insets(0, 0, 5, 5);
        gbc_lblFechaInicio.gridx = 3;
        gbc_lblFechaInicio.gridy = 0;
        panel.add(lblFechaInicio, gbc_lblFechaInicio);

        lblFechaFin = new JLabel(TDSLanguageUtils.getMessage("client.ss4.label.ffin"));
        lblFechaFin.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblFechaFin = new GridBagConstraints();
        gbc_lblFechaFin.anchor = GridBagConstraints.SOUTH;
        gbc_lblFechaFin.insets = new Insets(0, 0, 5, 5);
        gbc_lblFechaFin.gridx = 4;
        gbc_lblFechaFin.gridy = 0;
        panel.add(lblFechaFin, gbc_lblFechaFin);

        _textIdReparacio = new JTextField();
        GridBagConstraints gbc__textIdReparacio = new GridBagConstraints();
        gbc__textIdReparacio.fill = GridBagConstraints.HORIZONTAL;
        gbc__textIdReparacio.insets = new Insets(0, 0, 0, 5);
        gbc__textIdReparacio.gridx = 0;
        gbc__textIdReparacio.gridy = 1;
        panel.add(_textIdReparacio, gbc__textIdReparacio);
        _textIdReparacio.setColumns(10);

        _textNomClient = new JTextField();
        _textNomClient.setColumns(10);
        panel.add(_textNomClient);
        GridBagConstraints gbc__textNomClient = new GridBagConstraints();
        gbc__textNomClient.fill = GridBagConstraints.HORIZONTAL;
        gbc__textNomClient.insets = new Insets(0, 0, 0, 5);
        gbc__textNomClient.gridx = 1;
        gbc__textNomClient.gridy = 1;
        panel.add(_textNomClient, gbc__textNomClient);


        _textNomMecanic = new JTextField();
        _textNomMecanic.setColumns(10);
        panel.add(_textNomMecanic);
        GridBagConstraints gbc__textNomMecanic = new GridBagConstraints();
        gbc__textNomMecanic.fill = GridBagConstraints.HORIZONTAL;
        gbc__textNomMecanic.insets = new Insets(0, 0, 0, 5);
        gbc__textNomMecanic.gridx = 2;
        gbc__textNomMecanic.gridy = 1;
        panel.add(_textNomMecanic, gbc__textNomMecanic);

        _ftextInici = new JFormattedTextField(new DateFormat());
        panel.add(_ftextInici);
        GridBagConstraints gbc__ftextInici = new GridBagConstraints();
        gbc__ftextInici.fill = GridBagConstraints.HORIZONTAL;
        gbc__ftextInici.insets = new Insets(0, 0, 0, 5);
        gbc__ftextInici.gridx = 3;
        gbc__ftextInici.gridy = 1;
        panel.add(_ftextInici, gbc__ftextInici);

        _ftextFin = new JFormattedTextField(new DateFormat());
        panel.add(_ftextFin);
        GridBagConstraints gbc__ftextFin = new GridBagConstraints();
        gbc__ftextFin.fill = GridBagConstraints.HORIZONTAL;
        gbc__ftextFin.insets = new Insets(0, 0, 0, 5);
        gbc__ftextFin.gridx = 4;
        gbc__ftextFin.gridy = 1;
        panel.add(_ftextFin, gbc__ftextFin);
        panel.add(_btnBuscar);
        GridBagConstraints gbc__btnBuscar = new GridBagConstraints();
        gbc__btnBuscar.insets = new Insets(0, 0, 0, 5);
        gbc__btnBuscar.anchor = GridBagConstraints.NORTHWEST;
        gbc__btnBuscar.gridx = 6;
        gbc__btnBuscar.gridy = 1;
        panel.add(_btnBuscar, gbc__btnBuscar);
        
        _btnImprimir = new JButton(TDSLanguageUtils.getMessage("client.ss4.button.print"));
        _btnImprimir.addActionListener(new PrintWindow());


        GridBagConstraints gbc__btnImprimir = new GridBagConstraints();
        gbc__btnImprimir.fill = GridBagConstraints.HORIZONTAL;
        gbc__btnImprimir.gridx = 7;
        gbc__btnImprimir.gridy = 1;
        panel.add(_btnImprimir, gbc__btnImprimir);


    }
}
