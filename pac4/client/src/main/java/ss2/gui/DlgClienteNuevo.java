/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.gui;

import common.utils.TDSLanguageUtils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import ss2.entity.Client;
import ss2.helpers.NIF;
import ss2.helpers.StringValidate;



/**
 *
 * @author josi
 */
public final class DlgClienteNuevo extends javax.swing.JDialog {
    private Boolean editable = false;
    private int returnValue;

    public int showDialog() {
        setVisible(true);
	l_error.setText("");
	return returnValue;
    }

    public void hiliteControl(JTextField mycomp, String msg) {
	l_error.setText(TDSLanguageUtils.getMessage(msg));
        mycomp.requestFocus();
        mycomp.setForeground(Color.RED);
	l_error.setForeground(Color.RED);
    }

    public void hiliteControl(JPanel mycomp, String msg) {
	l_error.setText(TDSLanguageUtils.getMessage(msg));
        mycomp.requestFocus();
        mycomp.setForeground(Color.RED);
	l_error.setForeground(Color.RED);
    }

    public Boolean ValidateData() {
        Boolean validvalue = true;
	StringValidate validstring = new StringValidate();

	// c_nifCliente.setText(c_nifCliente.getText().toUpperCase());

	c_nifCliente.setForeground(Color.BLACK);
	c_nombreCliente.setForeground(Color.BLACK);
	c_apellidosCliente.setForeground(Color.BLACK);
	c_direccionCliente.setForeground(Color.BLACK);
	c_poblacionCliente.setForeground(Color.BLACK);
	c_codigoPostalCliente.setForeground(Color.BLACK);


	if (validvalue) {
            if (c_nifCliente.getText().length() > 9 ) {
                hiliteControl(c_nifCliente, "client.SS2.Client.ErrorLen.nif");
                validvalue = false;
            }
        }

	if (validvalue) {
            if (c_nombreCliente.getText().length() > 15 ) {
                hiliteControl(c_nombreCliente, "client.SS2.Client.ErrorLen.nom");
                validvalue = false;
            }
        }
	if (validvalue) {
            if (c_apellidosCliente.getText().length() > 35 ) {
                hiliteControl(c_apellidosCliente, "client.SS2.Client.ErrorLen.cognoms");
                validvalue = false;
            }
        }
	if (validvalue) {
            if (c_direccionCliente.getText().length() > 50 ) {
                hiliteControl(c_direccionCliente, "client.SS2.Client.ErrorLen.adreca");
                validvalue = false;
            }
        }
	if (validvalue) {
            if (c_poblacionCliente.getText().length() > 40 ) {
                hiliteControl(c_poblacionCliente, "client.SS2.Client.ErrorLen.poblacio");
                validvalue = false;
            }
        }
	if (validvalue) {
            if (c_codigoPostalCliente.getText().length() > 5 ) {
                hiliteControl(c_codigoPostalCliente, "client.SS2.Client.ErrorLen.codipostal");
                validvalue = false;
            }
        }


	if (validvalue) {
            validvalue = (validstring.isValid_CIF_NIE_NIF(c_nifCliente.getText()));
            if (!validvalue) {
                hiliteControl(c_nifCliente, "client.SS2.Client.ErrorCRC.nif");
		 validvalue = false;
            }
        }



	if (validvalue) {
            validvalue = (validstring.isValidCPStrict(c_codigoPostalCliente.getText()));
            if (!validvalue) {
                hiliteControl(c_codigoPostalCliente, "client.SS2.Client.ErrorNumeric.CP");
		 validvalue = false;
            }
        }

        return validvalue;
    }

    public void InitDialogData() {
	c_numeroCliente.setText("*");
	c_fechAltaCliente.setText("*");
	c_nifCliente.setText("00000000A");
	c_nombreCliente.setText("xx");
	c_apellidosCliente.setText("xx");
	c_direccionCliente.setText("xx");
	c_poblacionCliente.setText("xx");
	c_codigoPostalCliente.setText("00000");
    }

    public Client GetDialogData() {
        Client cliente = new Client();

        cliente.setNif(c_nifCliente.getText());
	cliente.setnom(c_nombreCliente.getText());
	cliente.setcognoms(c_apellidosCliente.getText());
	cliente.setadreca(c_direccionCliente.getText());
	cliente.setPoblacio(c_poblacionCliente.getText());
	cliente.setCodiPostal(Integer.parseInt(c_codigoPostalCliente.getText()));
        return cliente;
    }


    /**
     * Creates new form ClienteUsuarioModifica
     */
    public DlgClienteNuevo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

	InitDialogData();
	setTitle(TDSLanguageUtils.getMessage("client.SS2.Client.NuevoDialog"));
	b_OK.setText(TDSLanguageUtils.getMessage("client.SS2.btnOK"));
	b_Cancel.setText(TDSLanguageUtils.getMessage("client.SS2.btnCancel"));
	l_numeroCliente.setText(TDSLanguageUtils.getMessage("client.SS2.Client.numclient"));
	l_fechAltaCliente.setText(TDSLanguageUtils.getMessage("client.SS2.Client.dataalta"));
	l_nifCliente.setText(TDSLanguageUtils.getMessage("client.SS2.Client.nif"));
	l_nombreCliente.setText(TDSLanguageUtils.getMessage("client.SS2.Client.nom"));
	l_apellidosCliente.setText(TDSLanguageUtils.getMessage("client.SS2.Client.cognoms"));
	l_direccionCliente.setText(TDSLanguageUtils.getMessage("client.SS2.Client.adreca"));
	l_poblacionCliente.setText(TDSLanguageUtils.getMessage("client.SS2.Client.poblacio"));
	l_codigoPostalCliente.setText(TDSLanguageUtils.getMessage("client.SS2.Client.codipostal"));
	l_error.setText("");
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
                jPanel1 = new javax.swing.JPanel();
                l_numeroCliente = new javax.swing.JLabel();
                c_numeroCliente = new javax.swing.JLabel();
                l_fechAltaCliente = new javax.swing.JLabel();
                c_fechAltaCliente = new javax.swing.JLabel();
                l_nifCliente = new javax.swing.JLabel();
                c_nifCliente = new javax.swing.JTextField();
                c_nombreCliente = new javax.swing.JTextField();
                l_nombreCliente = new javax.swing.JLabel();
                c_apellidosCliente = new javax.swing.JTextField();
                l_apellidosCliente = new javax.swing.JLabel();
                c_direccionCliente = new javax.swing.JTextField();
                l_direccionCliente = new javax.swing.JLabel();
                c_poblacionCliente = new javax.swing.JTextField();
                l_poblacionCliente = new javax.swing.JLabel();
                c_codigoPostalCliente = new javax.swing.JTextField();
                l_codigoPostalCliente = new javax.swing.JLabel();
                b_OK = new javax.swing.JButton();
                b_Cancel = new javax.swing.JButton();
                p_msg = new java.awt.Panel();
                l_error = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
                setTitle(TDSLanguageUtils.getMessage("ss1.ClienteModificaUsuario.titulo"));
                setMinimumSize(null);
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosing(java.awt.event.WindowEvent evt) {
                                formWindowClosing(evt);
                        }
                });

                l_numeroCliente.setText("l_numeroCliente");

                c_numeroCliente.setText("c_numeroCliente");

                l_fechAltaCliente.setText("l_fechAltaCliente");

                c_fechAltaCliente.setText("c_fechAltaCliente");

                l_nifCliente.setText("l_nifCliente");

                c_nifCliente.setText("c_nifCliente");
                c_nifCliente.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusLost(java.awt.event.FocusEvent evt) {
                                c_nifClienteFocusLost(evt);
                        }
                });

                c_nombreCliente.setText("c_nombreCliente");

                l_nombreCliente.setText("l_nombreCliente");

                c_apellidosCliente.setText("c_l_apellidosCliente");

                l_apellidosCliente.setText("l_apellidosCliente");

                c_direccionCliente.setText("c_l_direccionCliente");

                l_direccionCliente.setText("l_direccionCliente");

                c_poblacionCliente.setText("c_poblacionCliente");

                l_poblacionCliente.setText("l_poblacionCliente");

                c_codigoPostalCliente.setText("c_codigoPostalCliente");

                l_codigoPostalCliente.setText("l_codigoPostalCliente");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(l_fechAltaCliente)
                                        .addComponent(l_numeroCliente)
                                        .addComponent(l_direccionCliente)
                                        .addComponent(l_codigoPostalCliente)
                                        .addComponent(l_poblacionCliente)
                                        .addComponent(l_nifCliente)
                                        .addComponent(l_nombreCliente)
                                        .addComponent(l_apellidosCliente))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(c_numeroCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(c_fechAltaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(c_nifCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(c_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(c_apellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(c_direccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(c_poblacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(c_codigoPostalCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_numeroCliente)
                                        .addComponent(c_numeroCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_fechAltaCliente)
                                        .addComponent(c_fechAltaCliente))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_nifCliente)
                                        .addComponent(c_nifCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_nombreCliente)
                                        .addComponent(c_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_apellidosCliente)
                                        .addComponent(c_apellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_direccionCliente)
                                        .addComponent(c_direccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_poblacionCliente)
                                        .addComponent(c_poblacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_codigoPostalCliente)
                                        .addComponent(c_codigoPostalCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                );

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

                p_msg.setBackground(new java.awt.Color(204, 204, 255));
                p_msg.setPreferredSize(new java.awt.Dimension(368, 30));

                l_error.setText("jLabel1");

                javax.swing.GroupLayout p_msgLayout = new javax.swing.GroupLayout(p_msg);
                p_msg.setLayout(p_msgLayout);
                p_msgLayout.setHorizontalGroup(
                        p_msgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(p_msgLayout.createSequentialGroup()
                                .addComponent(l_error)
                                .addGap(0, 0, Short.MAX_VALUE))
                );
                p_msgLayout.setVerticalGroup(
                        p_msgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_msgLayout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addComponent(l_error)
                                .addGap(1, 1, 1))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(128, 128, 128)
                                                                .addComponent(b_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(b_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addComponent(p_msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(b_OK)
                                        .addComponent(b_Cancel))
                                .addGap(20, 20, 20)
                                .addComponent(p_msg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void b_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_OKActionPerformed
                // TODO add your handling code here:
	   returnValue = 0;
	   if (ValidateData()) {
		returnValue = 1;
		setVisible(false);
	   }
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

        private void c_nifClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_nifClienteFocusLost
                // TODO add your handling code here:
		String numberST = c_nifCliente.getText();;
		Integer number;

		try {
   		   number = Integer.parseInt(numberST);
		   c_nifCliente.setText(numberST+NIF.trobarLletra(number));
		} catch (NumberFormatException ex) {}

        }//GEN-LAST:event_c_nifClienteFocusLost

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
            java.util.logging.Logger.getLogger(DlgClienteNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgClienteNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgClienteNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgClienteNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
		DlgClienteNuevo dialog = new DlgClienteNuevo(new javax.swing.JFrame(), true);
                //ClienteUsuarioModifica dialog = new ClienteUsuarioModifica(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton b_Cancel;
        private javax.swing.JButton b_OK;
        private javax.swing.ButtonGroup buttonGroup1;
        private javax.swing.JTextField c_apellidosCliente;
        private javax.swing.JTextField c_codigoPostalCliente;
        private javax.swing.JTextField c_direccionCliente;
        private javax.swing.JLabel c_fechAltaCliente;
        private javax.swing.JTextField c_nifCliente;
        private javax.swing.JTextField c_nombreCliente;
        private javax.swing.JLabel c_numeroCliente;
        private javax.swing.JTextField c_poblacionCliente;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel l_apellidosCliente;
        private javax.swing.JLabel l_codigoPostalCliente;
        private javax.swing.JLabel l_direccionCliente;
        private javax.swing.JLabel l_error;
        private javax.swing.JLabel l_fechAltaCliente;
        private javax.swing.JLabel l_nifCliente;
        private javax.swing.JLabel l_nombreCliente;
        private javax.swing.JLabel l_numeroCliente;
        private javax.swing.JLabel l_poblacionCliente;
        private java.awt.Panel p_msg;
        // End of variables declaration//GEN-END:variables
}
