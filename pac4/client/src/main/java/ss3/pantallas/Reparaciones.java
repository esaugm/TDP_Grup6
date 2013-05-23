package ss3.pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Reparaciones extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public Reparaciones() {
		
		JLabel lblReparaciones = new JLabel("Reparaciones");
		lblReparaciones.setBounds(227, 5, 178, 37);
		lblReparaciones.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		table = new JTable();
		table.setBounds(10, 125, 613, 64);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		
		JButton btnDetalle = new JButton("Detalle");
		btnDetalle.setBounds(95, 200, 65, 44);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(166, 200, 71, 44);
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.setBounds(243, 200, 69, 44);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(10, 200, 79, 44);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(322, 200, 71, 44);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(570, 200, 53, 44);
		
		JLabel lblFiltrar = new JLabel("Filtrar");
		lblFiltrar.setBounds(10, 67, 40, 14);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(48, 67, 97, 20);
		
		JLabel lblDe = new JLabel("De");
		lblDe.setBounds(163, 59, 13, 14);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(163, 90, 28, 14);
		
		textField = new JTextField();
		textField.setBounds(194, 56, 86, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(195, 87, 86, 20);
		textField_1.setColumns(10);
		
		JLabel lblNombreCliente = new JLabel("Nombre Cliente");
		lblNombreCliente.setBounds(314, 63, 73, 14);
		
		textField_2 = new JTextField();
		textField_2.setBounds(405, 60, 86, 20);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(405, 86, 86, 20);
		textField_3.setColumns(10);
		
		JLabel lblApellidoCliente = new JLabel("Apellido Cliente");
		lblApellidoCliente.setBounds(314, 90, 73, 14);
		setLayout(null);
		add(lblReparaciones);
		add(lblFiltrar);
		add(comboBox);
		add(lblDe);
		add(textField);
		add(lblHasta);
		add(textField_1);
		add(lblNombreCliente);
		add(lblApellidoCliente);
		add(textField_2);
		add(textField_3);
		add(table);
		add(btnActualizar);
		add(btnDetalle);
		add(btnAceptar);
		add(btnAsignar);
		add(btnFinalizar);
		add(btnSalir);

	}
}
