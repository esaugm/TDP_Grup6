/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.gui;

import common.utils.TDSLanguageUtils;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import ss2.entity.Client;
import ss2.entity.Solicitud;
import ss2.helpers.ClientCBModel;
import ss2.server.ISS2GestionAdministrativa;
import ss3.server.SS3Reparaciones;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ComboBoxModel;
import ss1.entity.UsuariConectat;
import ss2.helpers.VehiculoCBModel;
import ss3.beans.Vehiculo;




/**
 *
 * @author josi
 */
public final class DlgSolicitudModifica extends javax.swing.JDialog {
    private int returnValue;
    common.rmi.Client rmiclient;
    private ISS2GestionAdministrativa clienteRMISS2;
    private SS3Reparaciones clienteRMISS3;

    private ClientCBModel ccbm;
    private ArrayList<Client> alc;
    private Client clienteSelected;

    private VehiculoCBModel vcbm;
    private ArrayList<Vehiculo> alv;
    private Vehiculo vehiculoSelected;
    Boolean vs = false;
    Boolean cs = false;


    public int showDialog() {
        setVisible(true);
	return returnValue;
    }

    public void setClient(common.rmi.Client cliente) {
        this.rmiclient = cliente;
	try {
	   clienteRMISS2 = rmiclient.get_remoteSS2();
	   clienteRMISS3 = rmiclient.get_remoteSS3();
        } catch (Exception ex) {
	   JOptionPane.showMessageDialog(null,
	   ex.getLocalizedMessage(),
	   "Excepcion ",
	   JOptionPane.ERROR_MESSAGE);
	}
    }

    private void ClientRefresh() {
	   try {
	      alc = clienteRMISS2.buscaCliente( b_cliente_filtro.getText() );
	      if (alc.size()>0) { cbox_cliente.setEnabled(true); }
	   } catch (Exception ex) {
		JOptionPane.showMessageDialog(null,
		   ex.getLocalizedMessage(),
		   "Excepcion ",
		   JOptionPane.ERROR_MESSAGE);
	   }
	   ccbm = new ClientCBModel();
	   ComboBoxModel cbmc = ccbm.Client2ComboBoxModel(alc);
	   cbox_cliente.setModel(cbmc);

	   try {
	      alv = clienteRMISS3.ConsultaMatriculas(b_vehiculo_filtro.getText() );
	      if (alv.size()>0) { cbox_vehiculo.setEnabled(true); }
	   } catch (Exception ex) {
		JOptionPane.showMessageDialog(null,
		   ex.getLocalizedMessage(),
		   "Excepcion ",
		   JOptionPane.ERROR_MESSAGE);
	   }

	   vcbm = new VehiculoCBModel();
	   ComboBoxModel cbmv = vcbm.Vehiculo2ComboBoxModel(alv);
	   cbox_vehiculo.setModel(cbmv);
	   //JTListaClientes.setModel(tmc);
	   //JTListaClientes.getTableHeader().setReorderingAllowed(false);

	}

    public void SetDialogData(Solicitud solicitud) {

	b_cliente_filtro.setText("");
	c_nifCliente.setText("");
	c_nombreCliente.setText("");

	b_vehiculo_filtro.setText("");
	c_matricula.setText("");
	c_marca.setText("");
	c_comments.setText("");
	c_poliza.setText("");

    }

    public Solicitud GetDialogData() {
        Solicitud solicitud = new Solicitud();

	solicitud.setClient(clienteSelected.getNif());
	solicitud.setComentaris(c_comments.getText());
	solicitud.setPendent(true);
	solicitud.setFinalitzada(false);
	solicitud.setNumPoliza(c_poliza.getText());
	solicitud.setAsseguradora(1);
	solicitud.setIdtaller(-1);
	return solicitud;
    }

    public DlgSolicitudModifica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
	initComponents();

	setTitle(TDSLanguageUtils.getMessage("client.SS2.Solicitud.CreaDialog"));
	b_OK.setText(TDSLanguageUtils.getMessage("client.SS2.btnSave"));
	b_Cancel.setText(TDSLanguageUtils.getMessage("client.SS2.btnCancel"));
	b_newVehicle.setText(TDSLanguageUtils.getMessage("client.SS2.Solicitud.newvehiculo"));
	b_Buscar.setText(TDSLanguageUtils.getMessage("client.SS2.busqueda"));

	l_nifCliente.setText(TDSLanguageUtils.getMessage("client.SS2.Solicitud.nif"));
	l_nombreCliente.setText(TDSLanguageUtils.getMessage("client.SS2.Solicitud.nom"));

	l_matricula.setText(TDSLanguageUtils.getMessage("client.SS2.Solicitud.matricula"));
	l_marca.setText(TDSLanguageUtils.getMessage("client.SS2.Solicitud.marca"));

	l_poliza.setText(TDSLanguageUtils.getMessage("client.SS2.Solicitud.poliza"));
	l_comments.setText(TDSLanguageUtils.getMessage("client.SS2.Solicitud.comments"));

	cbox_cliente.setEnabled(false);
	cbox_cliente.setModel(new DefaultComboBoxModel());
	cbox_vehiculo.setEnabled(false);
	cbox_vehiculo.setModel(new DefaultComboBoxModel());
	b_OK.setEnabled(false);
        JRootPane rootPanel = this.getRootPane();
        InputMap iMap =	rootPanel.getInputMap(
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escape");

        ActionMap aMap = rootPanel.getActionMap();
        aMap.put("escape", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            };
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                buttonGroup1 = new javax.swing.ButtonGroup();
                jPanel3 = new javax.swing.JPanel();
                jPanel1 = new javax.swing.JPanel();
                p_cliente = new javax.swing.JPanel();
                b_cliente_filtro = new javax.swing.JTextField();
                cbox_cliente = new javax.swing.JComboBox();
                l_nifCliente = new javax.swing.JLabel();
                c_nifCliente = new javax.swing.JTextField();
                l_nombreCliente = new javax.swing.JLabel();
                c_nombreCliente = new javax.swing.JTextField();
                p_vehiculo = new javax.swing.JPanel();
                b_vehiculo_filtro = new javax.swing.JTextField();
                cbox_vehiculo = new javax.swing.JComboBox();
                l_matricula = new javax.swing.JLabel();
                c_matricula = new javax.swing.JTextField();
                l_marca = new javax.swing.JLabel();
                c_marca = new javax.swing.JTextField();
                jPanel2 = new javax.swing.JPanel();
                l_poliza = new javax.swing.JLabel();
                c_poliza = new javax.swing.JTextField();
                l_comments = new javax.swing.JLabel();
                c_comments = new javax.swing.JTextField();
                b_Buscar = new javax.swing.JButton();
                b_OK = new javax.swing.JButton();
                b_Cancel = new javax.swing.JButton();
                b_newVehicle = new javax.swing.JButton();

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
                );
                jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
                );

                setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
                setTitle(TDSLanguageUtils.getMessage("ss1.ClienteModificaUsuario.titulo"));
                setMinimumSize(null);
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosing(java.awt.event.WindowEvent evt) {
                                formWindowClosing(evt);
                        }
                });

                p_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(TDSLanguageUtils.getMessage("client.SS2.Solicitud.client")));
                p_cliente.setName(""); // NOI18N

                b_cliente_filtro.setText("b_cliente_filtro");

                cbox_cliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                cbox_cliente.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                cbox_clienteItemStateChanged(evt);
                        }
                });

                l_nifCliente.setText("l_nifCliente");

                c_nifCliente.setText("c_nifCliente");

                l_nombreCliente.setText("l_nombreCliente");

                c_nombreCliente.setText("c_nombreCliente");

                javax.swing.GroupLayout p_clienteLayout = new javax.swing.GroupLayout(p_cliente);
                p_cliente.setLayout(p_clienteLayout);
                p_clienteLayout.setHorizontalGroup(
                        p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(p_clienteLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(l_nifCliente)
                                        .addComponent(l_nombreCliente)
                                        .addComponent(b_cliente_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(c_nombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                        .addComponent(cbox_cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(c_nifCliente))
                                .addContainerGap())
                );
                p_clienteLayout.setVerticalGroup(
                        p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(p_clienteLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(b_cliente_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbox_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_nifCliente)
                                        .addComponent(c_nifCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_nombreCliente)
                                        .addComponent(c_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                );

                p_vehiculo.setBorder(javax.swing.BorderFactory.createTitledBorder(TDSLanguageUtils.getMessage("client.SS2.Solicitud.vehiculo")));

                b_vehiculo_filtro.setText("b_vehiculo_filtro");

                cbox_vehiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                cbox_vehiculo.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                cbox_vehiculoItemStateChanged(evt);
                        }
                });

                l_matricula.setText("l_matricula");

                c_matricula.setText("c_matricula");

                l_marca.setText("l_marca");

                c_marca.setText("c_marca");

                javax.swing.GroupLayout p_vehiculoLayout = new javax.swing.GroupLayout(p_vehiculo);
                p_vehiculo.setLayout(p_vehiculoLayout);
                p_vehiculoLayout.setHorizontalGroup(
                        p_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(p_vehiculoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(p_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(l_matricula)
                                        .addComponent(l_marca)
                                        .addComponent(b_vehiculo_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(p_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(c_matricula, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                        .addComponent(c_marca)
                                        .addComponent(cbox_vehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                p_vehiculoLayout.setVerticalGroup(
                        p_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(p_vehiculoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(p_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(p_vehiculoLayout.createSequentialGroup()
                                                .addComponent(b_vehiculo_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_vehiculoLayout.createSequentialGroup()
                                                .addComponent(cbox_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(p_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_matricula)
                                        .addComponent(c_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(p_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_marca)
                                        .addComponent(c_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                );

                jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

                l_poliza.setText("l_poliza");

                c_poliza.setText("c_poliza");

                l_comments.setText("l_comments");

                c_comments.setText("c_comments");

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(c_comments, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(c_poliza, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(l_poliza)
                                                        .addComponent(l_comments))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(l_poliza)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(c_poliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(l_comments)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_comments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                );

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(p_cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(p_vehiculo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(p_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );

                b_Buscar.setText("jButton1");
                b_Buscar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                b_BuscarActionPerformed(evt);
                        }
                });

                b_OK.setText("jOK");
                b_OK.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                b_OKActionPerformed(evt);
                        }
                });

                b_Cancel.setText("jCancel");
                b_Cancel.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                b_CancelActionPerformed(evt);
                        }
                });

                b_newVehicle.setText("jNuevo");
                b_newVehicle.setPreferredSize(new java.awt.Dimension(67, 23));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(b_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(b_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(b_newVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(b_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)
                                .addComponent(b_Buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(b_OK)
                                        .addComponent(b_Cancel)
                                        .addComponent(b_newVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void b_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_OKActionPerformed
                // TODO add your handling code here:
	   returnValue = 1;
	   setVisible(false);
        }//GEN-LAST:event_b_OKActionPerformed

        private void b_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_CancelActionPerformed
                // TODO add your handling code here:
		returnValue = 0;
		setVisible(false);

        }//GEN-LAST:event_b_CancelActionPerformed

        private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
                // TODO add your handling code here:
		b_CancelActionPerformed(null);
        }//GEN-LAST:event_formWindowClosing

        private void b_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_BuscarActionPerformed
                // TODO add your handling code here:
		ClientRefresh();
        }//GEN-LAST:event_b_BuscarActionPerformed

        private void cbox_clienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbox_clienteItemStateChanged
            // TODO add your handling code here:
	if (cbox_cliente.getSelectedIndex()> 0) {
		clienteSelected = ccbm.getClientbyPos(cbox_cliente.getSelectedIndex());
		cs = true;
		c_nifCliente.setText(clienteSelected.getNif());
		c_nombreCliente.setText(clienteSelected.getnom()+" "+clienteSelected.getcognoms());

	} else {
		cs = false;
		c_nifCliente.setText("");
		c_nombreCliente.setText("");

	}
        }//GEN-LAST:event_cbox_clienteItemStateChanged

        private void cbox_vehiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbox_vehiculoItemStateChanged
                // TODO add your handling code here:
	if (cbox_vehiculo.getSelectedIndex()> 0) {
		vehiculoSelected = vcbm.getVehiculotbyPos(cbox_vehiculo.getSelectedIndex());
		vs = true;
		c_matricula.setText(vehiculoSelected.getMatricula());
		c_marca.setText(vehiculoSelected.getMarca()+" "+vehiculoSelected.getColor());


	} else {
		vs = false;
		c_matricula.setText("");
		c_marca.setText("");
	}
	if (vs && cs) {
		b_OK.setEnabled(true);
	}
        }//GEN-LAST:event_cbox_vehiculoItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgSolicitudModifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgSolicitudModifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgSolicitudModifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgSolicitudModifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
		DlgClienteModifica dialog = new DlgClienteModifica(new javax.swing.JFrame(), true);
                //ClienteUsuarioModifica dialog = new ClienteUsuarioModifica(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton b_Buscar;
        private javax.swing.JButton b_Cancel;
        private javax.swing.JButton b_OK;
        private javax.swing.JTextField b_cliente_filtro;
        private javax.swing.JButton b_newVehicle;
        private javax.swing.JTextField b_vehiculo_filtro;
        private javax.swing.ButtonGroup buttonGroup1;
        private javax.swing.JTextField c_comments;
        private javax.swing.JTextField c_marca;
        private javax.swing.JTextField c_matricula;
        private javax.swing.JTextField c_nifCliente;
        private javax.swing.JTextField c_nombreCliente;
        private javax.swing.JTextField c_poliza;
        private javax.swing.JComboBox cbox_cliente;
        private javax.swing.JComboBox cbox_vehiculo;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JLabel l_comments;
        private javax.swing.JLabel l_marca;
        private javax.swing.JLabel l_matricula;
        private javax.swing.JLabel l_nifCliente;
        private javax.swing.JLabel l_nombreCliente;
        private javax.swing.JLabel l_poliza;
        private javax.swing.JPanel p_cliente;
        private javax.swing.JPanel p_vehiculo;
        // End of variables declaration//GEN-END:variables
}
