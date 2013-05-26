/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.gui;

import common.entity.PerfilUsuari;
import common.rmi.Client;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.entity.Usuari;
import ss1.entity.exception.ExceptionMaximoReparacionesAsignadas;
import ss1.entity.exception.ExceptionNoReparacionesAsignadas;
import ss1.service.filter.FilterItems;
import ss2.entity.Solicitud;
import ss2.entity.StockPeca;
import ss2.exception.AppException;
import ss3.beans.Pieza;
import ss3.beans.Reparacion;
/**
 *
 * @author Fernando
 */
public class AsignacionAMecanico extends JDialog {

    Client cliente;
    JTable jTable1;
    JTable jTable2;
    JScrollPane scrollPane1;
    JScrollPane scrollPane2;
    /**
     * Creates new form AMecanico
     */
    public AsignacionAMecanico(Client cliente, Integer orden, String matricula, String marca, String modelo) throws ExceptionErrorDataBase, AppException, RemoteException, ExceptionTipoObjetoFiltroNoPermitido {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(75, 75, 850, 500);
        initComponents();
        this.cliente = cliente;
        jTable1 = crearTabla();
        scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(10, 180, 385, 75);
        add(scrollPane1);
        scrollPane1.setViewportView(jTable1);
        jTable2 = crearTabla2();
        scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(425, 180, 385, 75);
        add(scrollPane2);
        scrollPane2.setViewportView(jTable2);
        rellenaCabecero(orden,matricula,marca,modelo);
        rellenaTablaAsignado(cliente.ConsultaOrden(orden));
        rellenaTablaMecanicos(cliente.ConsultaOrden(orden));
        
    }

     public void rellenaCabecero(Integer orden, String matricula, String marca, String modelo){
        jTextField7.setText(orden.toString());
        jTextField8.setText(matricula);
        jTextField9.setText(marca);
        jTextField10.setText(modelo);
    }
     
    public void rellenaTablaAsignado(Reparacion repa) throws AppException, ExceptionErrorDataBase, RemoteException, ExceptionTipoObjetoFiltroNoPermitido {
                //Se rellena la tabla de mecánicos asignados
                Usuari usu=null;
                if(!repa.getIdMecanico().toString().isEmpty()&&repa.getIdMecanico()!=0){
                    usu = cliente.buscarUsuariPorId(repa.getIdMecanico());
        
                    DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                    int rowCount = tableModel.getRowCount();
                    int i=0;

                    if (repa.getIdOrden() > 0){
                            if(i==rowCount-1)
                                tableModel.addRow(new Object[]{});
                            tableModel.setValueAt(usu.getId(),i, 0);
                            tableModel.setValueAt(usu.getNom(),i,1);
                            tableModel.setValueAt(usu.getCognoms(),i,2);     
                     }
                    i++;
                    for (int rowIdx=i;rowIdx<rowCount ;rowIdx++){
                        tableModel.setValueAt("",rowIdx,0);
                        tableModel.setValueAt("",rowIdx,1);
                        tableModel.setValueAt("",rowIdx,2);
                    }
                

                jTable1 = createTabla(tableModel);
                scrollPane1.setViewportView(jTable1);
                }else
                    jButton4.setEnabled(false);
    }
    
    public void rellenaTablaMecanicos(Reparacion repa) throws AppException, ExceptionErrorDataBase, RemoteException, ExceptionTipoObjetoFiltroNoPermitido {
                //Se rellena la tabla de mecánicos posibles a asignar
                ArrayList<Usuari> lUsu=null;
                FilterItems filterItems = new FilterItems();
                filterItems.addFilterValue("perfil",PerfilUsuari.MECANIC.toString());
                lUsu = (ArrayList<Usuari>) cliente.filtrarUsuaris(filterItems);
        
                DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
                int rowCount2 = tableModel2.getRowCount();
                int j=0;
                Iterator it = lUsu.iterator();
                Usuari usu2 = null;
                while(it.hasNext()){
                    usu2 = (Usuari) it.next();
                    if (repa.getIdOrden() > 0){
                        if(j==rowCount2-1)
                            tableModel2.addRow(new Object[]{});
                        tableModel2.setValueAt(usu2.getId(),j, 0);
                        tableModel2.setValueAt(usu2.getNom(),j,1);
                        tableModel2.setValueAt(usu2.getCognoms(),j,2);
                        tableModel2.setValueAt(usu2.getReparacionsAssignades(),j,3);     
                    }
                    j++;
                }
                
                for (int rowIdx2=j;rowIdx2<rowCount2 ;rowIdx2++){
                    tableModel2.setValueAt("",rowIdx2,0);
                    tableModel2.setValueAt("",rowIdx2,1);
                    tableModel2.setValueAt("",rowIdx2,2);
                    tableModel2.setValueAt("",rowIdx2,3);
                }
                

                jTable2 = createTabla(tableModel2);
                scrollPane2.setViewportView(jTable2);
                
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void filtraMecanicos(ArrayList<Usuari> listUsuarios) throws ExceptionErrorDataBase, ExceptionTipoObjetoFiltroNoPermitido, RemoteException{
                
                    ArrayList<Usuari> lUsu=listUsuarios;
                        
                    DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
                    int rowCount2 = tableModel2.getRowCount();
                    int j=0;
                    Iterator it = lUsu.iterator();
                    Usuari usu2 = null;
                    while(it.hasNext()){
                        usu2 = (Usuari) it.next();
                        if(j==rowCount2-1)
                            tableModel2.addRow(new Object[]{});
                        tableModel2.setValueAt(usu2.getId(),j, 0);
                        tableModel2.setValueAt(usu2.getNom(),j,1);
                        tableModel2.setValueAt(usu2.getCognoms(),j,2);
                        tableModel2.setValueAt(usu2.getReparacionsAssignades(),j,3);
                        j++;
                    }

                    for (int rowIdx2=j;rowIdx2<rowCount2 ;rowIdx2++){
                        tableModel2.setValueAt("",rowIdx2,0);
                        tableModel2.setValueAt("",rowIdx2,1);
                        tableModel2.setValueAt("",rowIdx2,2);
                        tableModel2.setValueAt("",rowIdx2,3);
                    }


                    jTable2 = createTabla(tableModel2);
                    scrollPane2.setViewportView(jTable2);
             
    }
    
    private JTable crearTabla() {
        DefaultTableModel tableModel = (new DefaultTableModel(
                new Object[][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                },
                new String[] {"Id","Nombre", "Apellidos"}
        ){
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        return createTabla(tableModel);
    }

    private JTable crearTabla2() {
        DefaultTableModel tableModel = (new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                },
                new String[] {"Id","Nombre", "Apellidos","Reparaciones Asig."}
        ){
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, String.class, Integer.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        return createTabla2(tableModel);
    }
    
    private JTable createTabla(DefaultTableModel tableModel) {
        JTable table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.setModel(tableModel);
        table.setRowSelectionAllowed(true);

        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(85);
        table.getColumnModel().getColumn(0).setMinWidth(85);
        table.getColumnModel().getColumn(0).setMaxWidth(85);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setMinWidth(150);
        table.getColumnModel().getColumn(1).setMaxWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setMinWidth(150);
        table.getColumnModel().getColumn(2).setMaxWidth(150);
        table.setBounds(10, 180, 385, 75);
        return table;
    }
    
    private JTable createTabla2(DefaultTableModel tableModel) {
        JTable table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.setModel(tableModel);
        table.setRowSelectionAllowed(true);

        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(85);
        table.getColumnModel().getColumn(0).setMinWidth(85);
        table.getColumnModel().getColumn(0).setMaxWidth(85);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(1).setMaxWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(2).setMaxWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setMinWidth(100);
        table.getColumnModel().getColumn(3).setMaxWidth(100);
        table.setBounds(425, 180, 385, 75);
        return table;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Asignación Mecánico");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 11, 361, 51);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel2.setText("Orden Reparación:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 30, 100, 14);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(120, 30, 110, 20);

        jLabel3.setText("Matrícula:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(270, 30, 50, 14);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(320, 30, 107, 20);

        jLabel4.setText("Marca:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(460, 30, 40, 14);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(500, 30, 110, 20);

        jLabel5.setText("Modelo:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(640, 30, 40, 14);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(680, 30, 134, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 68, 830, 0);

        jButton6.setText("Salir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(730, 350, 80, 23);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(null);

        jLabel8.setText("Orden Reparación:");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(10, 30, 110, 14);

        jTextField7.setEditable(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField7);
        jTextField7.setBounds(120, 30, 120, 20);

        jLabel9.setText("Matrícula:");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(270, 30, 60, 14);

        jTextField8.setEditable(false);
        jPanel5.add(jTextField8);
        jTextField8.setBounds(337, 30, 90, 20);

        jLabel11.setText("Marca:");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(440, 30, 40, 14);

        jTextField9.setEditable(false);
        jPanel5.add(jTextField9);
        jTextField9.setBounds(494, 30, 100, 20);

        jLabel13.setText("Modelo:");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(620, 30, 50, 14);

        jTextField10.setEditable(false);
        jPanel5.add(jTextField10);
        jTextField10.setBounds(675, 30, 100, 20);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(10, 68, 800, 69);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Mecánico asignadas a la reparación");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(80, 150, 270, 20);

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(310, 270, 80, 23);

        jLabel6.setText("Mecánico");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(470, 260, 60, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(530, 270, 110, 20);

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(650, 270, 80, 23);

        jButton3.setText("Asignar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(730, 270, 80, 23);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Mecánico");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(580, 150, 120, 17);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(!jTextField1.getText().isEmpty()){
            ArrayList<Usuari> lUsu2 = null;
            FilterItems filterItems = new FilterItems();
            filterItems.addFilterValue("nom",jTextField1.getText().toString());

            try {
                lUsu2 = (ArrayList<Usuari>) cliente.filtrarUsuaris(filterItems);
                filtraMecanicos(lUsu2);
            } catch (ExceptionErrorDataBase ex) {
                ex.printStackTrace();
            } catch (ExceptionTipoObjetoFiltroNoPermitido ex) {
                ex.printStackTrace();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }else{
            try {
                rellenaTablaMecanicos(cliente.ConsultaOrden(Integer.parseInt(jTextField7.getText())));
            } catch (ExceptionErrorDataBase ex) {
                ex.printStackTrace();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            } catch (ExceptionTipoObjetoFiltroNoPermitido ex) {
                ex.printStackTrace();
            }
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int idUsu = (Integer) jTable2.getValueAt(jTable2.getSelectedRow(), 0);
            cliente.asignaAMec(Integer.parseInt(jTextField7.getText()), idUsu);
                       
            Usuari usu4 = cliente.buscarUsuariPorId(idUsu);
            usu4.incrementarReparacionsAssignades();
            cliente.modificaUsuari(usu4);
            
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            Object[] datos = {(Integer)jTable2.getValueAt(jTable2.getSelectedRow(), 0),jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString(),jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString()}; // Cantidad de columnas de la tabla
            modelo.addRow(datos);
            modelo.moveRow(jTable1.getRowCount()-1, jTable1.getRowCount()-1, 0);
            
            jButton4.setEnabled(true);
                      
        } catch (ExceptionErrorDataBase ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } catch (ExceptionMaximoReparacionesAsignadas ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            if(!jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().isEmpty()){
                int idUsu = (Integer)jTable1.getValueAt(0, 0);
                cliente.desasignaMec(Integer.parseInt(jTextField7.getText()),idUsu);
                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                model.removeRow(jTable1.getSelectedRow());
                Object[] datos = {"","",""};
                model.addRow(datos);
                
                Usuari usu3 = null;
                usu3 = cliente.buscarUsuariPorId(idUsu);
                usu3.decrementaReparacionsAssignades();
                cliente.modificaUsuari(usu3);
                jButton4.setEnabled(false);
            }else{
                Avisos av = new Avisos("Esta fila está vacía. No hay nada que eliminar.");
                av.setVisible(true);
                av.setModal(true);
            }
            
            
            
        } catch (ExceptionErrorDataBase ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } catch (ExceptionNoReparacionesAsignadas ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
