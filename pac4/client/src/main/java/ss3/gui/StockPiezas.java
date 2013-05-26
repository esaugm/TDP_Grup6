/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.gui;

import common.rmi.Client;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.entity.Taller;
import ss1.entity.Usuari;
import ss1.entity.UsuariConectat;
import ss1.entity.exception.ExceptionNoReparacionesAsignadas;
import ss1.gui.LoginDialog;
import ss2.entity.Solicitud;
import ss2.entity.StockPeca;
import ss2.exception.AppException;
import ss3.beans.Pedido;
import ss3.beans.Pieza;
import ss3.beans.Reparacion;
import ss3.beans.Vehiculo;

/**
 *
 * @author Fernando
 */
public class StockPiezas extends javax.swing.JPanel {

    LoginDialog loginDialog;
    public Client cliente;
    JTable jTable1;
    JScrollPane scrollPane;
    JTable jTable2;
    JScrollPane scrollPane2;
    JFrame topFrame;
    UsuariConectat uC;
    /**
     * Creates new form StockPiezas
     */
    public StockPiezas(Client cli, UsuariConectat uC) throws ExceptionErrorDataBase, RemoteException {
        cliente = cli;
        initComponents();
               
        jTable1 = crearTabla();
        scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 130, 725, 100);
        add(scrollPane);
        scrollPane.setViewportView(jTable1);
        
        jTable2 = crearTabla2();
        scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(20, 320, 665, 90);
        add(scrollPane2);
        scrollPane2.setViewportView(jTable2);
        
        topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        rellenaTabla(cliente.consultaStockPiezas(uC.getTaller()));
    }

    public void rellenaTabla(ArrayList<StockPeca> stoPeca) throws ExceptionErrorDataBase {
        jButton3.setEnabled(false);
        try {
                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                int rowCount = tableModel.getRowCount();
                Iterator itRep = stoPeca.iterator();
                int i=0;
                Pieza p1;
                StockPeca sp1;
                while (itRep.hasNext()){
                    sp1 = (StockPeca) itRep.next();
                    p1 = cliente.ConsultaCodigo(sp1.getCodipeca());
                    if(i==rowCount-1) 
                        tableModel.addRow(new Object[]{});
                    tableModel.setValueAt(p1.getCodiPieza(),i, 0);
                    tableModel.setValueAt(p1.getMarca(),i,1);
                    tableModel.setValueAt(p1.getModelo(),i,2);
                    tableModel.setValueAt(sp1.getStockminim(),i,3);
                    tableModel.setValueAt(sp1.getStock(),i,4);
                    tableModel.setValueAt(p1.getPvd(),i,5);
                    tableModel.setValueAt(p1.getDescripcion(),i,6);
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
                }
                jTable1 = createTabla(tableModel);
                scrollPane.setViewportView(jTable1);
                
                DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
                int rowCount2 = tableModel2.getRowCount();
                int j=0;
                for (int rowIdy=j;rowIdy<rowCount2 ;rowIdy++){
                    tableModel2.setValueAt("",rowIdy,0);
                    tableModel2.setValueAt("",rowIdy,1);
                    tableModel2.setValueAt("",rowIdy,2);
                    tableModel2.setValueAt("",rowIdy,3);
                    tableModel2.setValueAt("",rowIdy,4);
                    tableModel2.setValueAt("",rowIdy,5);
                    tableModel2.setValueAt("",rowIdy,6);
                }
                jTable2 = createTabla2(tableModel2);
                scrollPane2.setViewportView(jTable2);
            
            } catch (RemoteException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

    }

    private JTable crearTabla() {
        DefaultTableModel tableModel = (new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                },
                new String[] {"Codigo","Marca","Modelo", "Stock Min.","Stock","Precio","Descripción"}
        ){
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, String.class, Integer.class, Integer.class, Integer.class, String.class
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
        table.getColumnModel().getColumn(0).setPreferredWidth(75);
        table.getColumnModel().getColumn(0).setMinWidth(75);
        table.getColumnModel().getColumn(0).setMaxWidth(75);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(1).setMaxWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setMinWidth(80);
        table.getColumnModel().getColumn(2).setMaxWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setMinWidth(80);
        table.getColumnModel().getColumn(3).setMaxWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setMinWidth(80);
        table.getColumnModel().getColumn(4).setMaxWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setMinWidth(80);
        table.getColumnModel().getColumn(5).setMaxWidth(80);
        table.getColumnModel().getColumn(6).setPreferredWidth(230);
        table.getColumnModel().getColumn(6).setMinWidth(230);
        table.getColumnModel().getColumn(6).setMaxWidth(230);
        table.setBounds(20, 130, 725, 100);
        return table;
    }
    
    private JTable crearTabla2() {
        DefaultTableModel tableModel = (new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                },
                new String[] {"Codigo","Marca","Modelo", "Unidades","Precio","PRecio Total","Descripción"}
        ){
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, String.class, Integer.class, Integer.class, Integer.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        return createTabla(tableModel);
    }

    private JTable createTabla2(DefaultTableModel tableModel) {
        JTable table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.setModel(tableModel);
        table.setRowSelectionAllowed(true);

        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(75);
        table.getColumnModel().getColumn(0).setMinWidth(75);
        table.getColumnModel().getColumn(0).setMaxWidth(75);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(1).setMaxWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setMinWidth(80);
        table.getColumnModel().getColumn(2).setMaxWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setMinWidth(80);
        table.getColumnModel().getColumn(3).setMaxWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setMinWidth(80);
        table.getColumnModel().getColumn(4).setMaxWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setMinWidth(80);
        table.getColumnModel().getColumn(5).setMaxWidth(80);
        table.getColumnModel().getColumn(6).setPreferredWidth(155);
        table.getColumnModel().getColumn(6).setMinWidth(155);
        table.getColumnModel().getColumn(6).setMaxWidth(155);
        table.setBounds(20, 320, 665, 90);
        return table;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Stock Piezas");
        add(jLabel1);
        jLabel1.setBounds(273, 11, 219, 51);

        jButton2.setText("Realizar Pedido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(10, 460, 150, 23);

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(180, 460, 80, 23);

        jButton6.setText("Salir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6);
        jButton6.setBounds(687, 458, 60, 23);

        jButton5.setText("Añadir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(660, 240, 83, 23);

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel11.setText("Piezas añadidas para realizar el pedido");
        add(jLabel11);
        jLabel11.setBounds(170, 280, 446, 32);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        Object[] datos = {(Integer)jTable1.getValueAt(jTable1.getSelectedRow(), 0),jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString(),jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString(),1,(Float)jTable1.getValueAt(jTable1.getSelectedRow(), 5),(Float)jTable1.getValueAt(jTable1.getSelectedRow(), 5),jTable1.getValueAt(jTable1.getSelectedRow(), 6)}; // Cantidad de columnas de la tabla
        modelo.addRow(datos);
        modelo.moveRow(jTable2.getRowCount()-1, jTable2.getRowCount()-1, 0);
        jButton3.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
 
            // TODO add your handling code here:
            if(!jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString().isEmpty()){
                DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
                model.removeRow(jTable2.getSelectedRow());
                jTable2.getSelectionModel().setSelectionInterval(0,0);
                
            }else{
                Avisos av = new Avisos("Esta fila está vacía. No hay nada que eliminar.");
                av.setVisible(true);
                av.setModal(true);
            }
            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        /*jTable2.getSelectionModel().setSelectionInterval(0, 0);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        try {
            Taller tall = cliente.findTallerById(uC.getTaller());
            Pieza p2 = cliente.ConsultaCodigo(Integer.parseInt(jTable2.getValueAt(0, 0).toString()));
            StockPeca sp2 = cliente.consultaStockPiezabyCodigoPieza(Integer.parseInt(p2.getCodiPieza().toString()), uC.getTaller());
            //Pedido ped = new Pedido(true,dateFormat.format(date),p2.getCodiPieza(),tall.getCapTaller(),p2.getIdProveedor(),);
        } catch (ExceptionErrorDataBase ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }*/
        Avisos av = new Avisos("Función no implementada. Disculpe las molestias.");
        av.setVisible(true);
        av.setModal(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2ActionPerformed(java.awt.event.ActionEvent evt){
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    // End of variables declaration//GEN-END:variables
}
