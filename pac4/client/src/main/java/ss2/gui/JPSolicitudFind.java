/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.gui;

import common.utils.TDSLanguageUtils;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import ss2.entity.Solicitud;
import ss2.helpers.SolicitudTableModel;
import ss2.server.ISS2GestionAdministrativa;

/**
 *
 * @author josi
 */
public class JPSolicitudFind extends javax.swing.JPanel {
	private ISS2GestionAdministrativa clienteRMISS2;
	private common.rmi.Client rmiclient;
	private SolicitudTableModel stm;
	private ArrayList<Solicitud> als;
	private JPanel pp;
	/**
	 * Creates new form JPSolicitudFind
	 */
	public JPSolicitudFind(common.rmi.Client cliente) {
	   rmiclient = cliente;
	   initComponents();
	   l_busqueda.setText(TDSLanguageUtils.getMessage("client.SS2.busqueda"));
	   c_busqueda.setText("");
	   b_OK.setText(TDSLanguageUtils.getMessage("client.SS2.btnOK"));
	   b_Aux.setText(TDSLanguageUtils.getMessage("client.SS2.btnNew_a"));
	   l_hint.setText(TDSLanguageUtils.getMessage("client.SS2.Solicitud.ENTER.hint"));
	   try {
	      clienteRMISS2 = rmiclient.get_remoteSS2();
           } catch (Exception ex) {
		JOptionPane.showMessageDialog(null,
		   ex.getLocalizedMessage(),
		   "Excepcion ",
		   JOptionPane.ERROR_MESSAGE);
	   }

	   SolicitudRefresh();

	}

	public void modifySolicitud() {
	   Solicitud selectedSolicitud, newSelectedSolicitud;
	   Integer selectedRow = JTListaSolicitud.getSelectedRow();

	   System.out.println(JTListaSolicitud.getValueAt(selectedRow, 0));
	   Integer ID = Integer.parseInt(JTListaSolicitud.getValueAt(selectedRow, 0).toString());

	   selectedSolicitud=stm.getSolicitudbyID(ID);
	   DlgSolicitudModifica modificaSolicitudfrm = new DlgSolicitudModifica(null,true);
	   modificaSolicitudfrm.SetDialogData(selectedSolicitud);
	   modificaSolicitudfrm.setClient(rmiclient);

	   if (modificaSolicitudfrm.showDialog()==1) {
	      newSelectedSolicitud = modificaSolicitudfrm.GetDialogData();
	      newSelectedSolicitud.setNumSol(selectedSolicitud.getNumSol());
	      System.out.println("OK: "+ newSelectedSolicitud);

	      // TODO Aqui Guardamos!!!
	      try {
	         if (!clienteRMISS2.altaSolicitud(newSelectedSolicitud)) {
		   JOptionPane.showMessageDialog(null,
		   //"Solicitud no guardado",
		   TDSLanguageUtils.getMessage("client.SS2.Solicitud.ErrorNotSaved"),
		   "Error",
		   JOptionPane.WARNING_MESSAGE);
		 } else {
		   JOptionPane.showMessageDialog(null,
		   //"Solicitud guardado",
		   TDSLanguageUtils.getMessage("client.SS2.Solicitud.ErrorSaved"),
		   "OK",
		   JOptionPane.INFORMATION_MESSAGE);
		 }


	      } catch (Exception ex) {
		JOptionPane.showMessageDialog(null,
		   ex.getLocalizedMessage(),
		   "Excepcion ",
		   JOptionPane.ERROR_MESSAGE);
	      }


	   } else {
	      System.out.println("Cancel: "+modificaSolicitudfrm.GetDialogData());

	   }
           modificaSolicitudfrm.dispose();
	   SolicitudRefresh();
	}

	public void newSolicitud() {
	   Solicitud  newSolicitud;
	   ArrayList<Solicitud> alnif;

/*	   DlgSolicitudNuevo newSolicitudfrm = new DlgSolicitudNuevo(null,true);

	   if (newSolicitudfrm.showDialog()==1) {
              SolicitudRefresh();
	      newSolicitud = newSolicitudfrm.GetDialogData();
	      System.out.println("OK: "+ newSolicitud);

	      // TODO Aqui Guardamos!!!
	      try {
		 alnif = clienteRMISS2.buscaSolicitudbyNIF(newSolicitud.getNif());
		 if ( !alnif.isEmpty() ) {
			JOptionPane.showMessageDialog(null,
			//"Solicitud duplicado",
			TDSLanguageUtils.getMessage("client.SS2.Solicitud.ErrorDup"),
			"Error",
			JOptionPane.INFORMATION_MESSAGE);
		 } else if (clienteRMISS2.altaSolicitud(newSolicitud)) {
			JOptionPane.showMessageDialog(null,
			//"Solicitud guardado",
			TDSLanguageUtils.getMessage("client.SS2.Solicitud.ErrorSaved"),
			"OK",
			JOptionPane.INFORMATION_MESSAGE);
		      } else {
			JOptionPane.showMessageDialog(null,
			//"Solicitud no guardado",
			TDSLanguageUtils.getMessage("client.SS2.Solicitud.ErrorNotSaved"),
			"Error",
			JOptionPane.WARNING_MESSAGE);
		      }


	      } catch (Exception ex) {
		JOptionPane.showMessageDialog(null,
		   ex.getLocalizedMessage(),
		   "Excepcion ",
		   JOptionPane.ERROR_MESSAGE);
	      }


	   } else {
	      System.out.println("Cancel: "+newSolicitudfrm.GetDialogData());

	   }
           newSolicitudfrm.dispose();
	   SolicitudRefresh();

*/
	}

	private void SolicitudRefresh() {

	   try {
	      //alc = clienteRMISS2.listaSolicituds();
	      //alc = clienteRMISS2.buscaSolicitud("arce");
	      als = clienteRMISS2.buscaSolicitudbyANY(c_busqueda.getText());
	   } catch (Exception ex) {
		JOptionPane.showMessageDialog(null,
		   ex.getLocalizedMessage(),
		   "Excepcion ",
		   JOptionPane.ERROR_MESSAGE);
	   }
	   stm = new SolicitudTableModel();
	   TableModel tms = stm.Solicitud2TableModel(als);
	   JTListaSolicitud.setModel(tms);
	   JTListaSolicitud.getTableHeader().setReorderingAllowed(false);

	}


	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                l_busqueda = new javax.swing.JLabel();
                c_busqueda = new javax.swing.JTextField();
                l_hint = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                JTListaSolicitud = new javax.swing.JTable();
                b_OK = new javax.swing.JButton();
                b_Aux = new javax.swing.JButton();
                p_msg = new java.awt.Panel();

                setMinimumSize(new java.awt.Dimension(318, 338));

                l_busqueda.setText("l_busqueda");

                c_busqueda.setText("c_busqueda");
                c_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                c_busquedaKeyPressed(evt);
                        }
                });

                l_hint.setFont(l_hint.getFont().deriveFont((l_hint.getFont().getStyle() | java.awt.Font.ITALIC) & ~java.awt.Font.BOLD, l_hint.getFont().getSize()-1));
                l_hint.setText("l_hint");

                JTListaSolicitud.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {

                        }
                ));
                JTListaSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                JTListaSolicitudMouseClicked(evt);
                        }
                });
                jScrollPane1.setViewportView(JTListaSolicitud);

                b_OK.setText("jOK");
                b_OK.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                b_OKActionPerformed(evt);
                        }
                });

                b_Aux.setText("jAux");
                b_Aux.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                b_AuxActionPerformed(evt);
                        }
                });

                p_msg.setBackground(new java.awt.Color(204, 204, 255));

                javax.swing.GroupLayout p_msgLayout = new javax.swing.GroupLayout(p_msg);
                p_msg.setLayout(p_msgLayout);
                p_msgLayout.setHorizontalGroup(
                        p_msgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                );
                p_msgLayout.setVerticalGroup(
                        p_msgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 20, Short.MAX_VALUE)
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(p_msg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(l_busqueda)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(c_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(l_hint)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(b_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(b_Aux, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 108, Short.MAX_VALUE)))
                                                .addContainerGap())))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l_busqueda)
                                        .addComponent(c_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addComponent(l_hint)
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(b_OK)
                                        .addComponent(b_Aux))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p_msg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );
        }// </editor-fold>//GEN-END:initComponents


        private void b_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_OKActionPerformed
		//TODO
		setVisible(false);
        }//GEN-LAST:event_b_OKActionPerformed

        private void JTListaSolicitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTListaSolicitudMouseClicked
	  if (evt.getClickCount() == 2) {
            modifySolicitud();
           }
        }//GEN-LAST:event_JTListaSolicitudMouseClicked

        private void c_busquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_busquedaKeyPressed
	   int key = evt.getKeyCode();
	   if (key == KeyEvent.VK_ENTER) {
              SolicitudRefresh();
	   }

        }//GEN-LAST:event_c_busquedaKeyPressed

        private void b_AuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_AuxActionPerformed
           newSolicitud();
        }//GEN-LAST:event_b_AuxActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        javax.swing.JTable JTListaSolicitud;
        javax.swing.JButton b_Aux;
        javax.swing.JButton b_OK;
        javax.swing.JTextField c_busqueda;
        javax.swing.JScrollPane jScrollPane1;
        javax.swing.JLabel l_busqueda;
        javax.swing.JLabel l_hint;
        java.awt.Panel p_msg;
        // End of variables declaration//GEN-END:variables
}
