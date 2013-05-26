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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.entity.Taller;
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
public class PiezasReparacion extends JDialog {
    Client cliente;
    JTable jTable1;
    JScrollPane scrollPane;
    
    /**
     * Creates new form PiezasReparacion
     */
    public PiezasReparacion(Client cliente, Integer orden, String matricula, String marca, String modelo) throws RemoteException, ExceptionErrorDataBase {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(75, 75, 870, 520);
        initComponents();
        jTable1 = crearTabla();
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 260, 830, 75);
        add(scrollPane);
        scrollPane.setViewportView(jTable1);
        rellenaCabecero(orden,matricula,marca,modelo);
        jTextArea1.setText(cliente.ConsultaOrden(orden).getObservaciones());
    }

    
    public void rellenaCabecero(Integer orden, String matricula, String marca, String modelo) throws ExceptionErrorDataBase, RemoteException{
        jTextField6.setText(orden.toString());
        jTextField7.setText(matricula);
        jTextField8.setText(marca);
        jTextField9.setText(modelo);
        
    }
    
    public void rellenaTabla(ArrayList<Pieza> pecas) throws ExceptionErrorDataBase {
       
        try {
                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                int rowCount = tableModel.getRowCount();
                Iterator itRep = pecas.iterator();
                int i=0;
                Pieza p1 = null;
                StockPeca sp1 = null;
                while (itRep.hasNext()){
                    p1 = (Pieza) itRep.next();
                    p1 = cliente.ConsultaCodigo(sp1.getCodipeca());
                    if(i==rowCount-1) 
                        tableModel.addRow(new Object[]{});
                    tableModel.setValueAt(p1.getCodiPieza(),i, 0);
                    tableModel.setValueAt(p1.getDescripcion(),i,1);
                    tableModel.setValueAt("",i,2);
                    tableModel.setValueAt(sp1.getStock(),i,3);
                    tableModel.setValueAt(p1.getPvd(),i,4);
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
                
            
            } catch (RemoteException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

    }

    private JTable crearTabla() {
        DefaultTableModel tableModel = (new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {"Codigo","Descripción","Unidades", "Stock","Precio"}
        ){
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, Integer.class, Integer.class, Float.class
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
        table.getColumnModel().getColumn(1).setPreferredWidth(350);
        table.getColumnModel().getColumn(1).setMinWidth(350);
        table.getColumnModel().getColumn(1).setMaxWidth(350);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setMinWidth(150);
        table.getColumnModel().getColumn(2).setMaxWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(3).setMinWidth(120);
        table.getColumnModel().getColumn(3).setMaxWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setMinWidth(120);
        table.getColumnModel().getColumn(4).setMaxWidth(120);
        table.setBounds(10, 260, 830, 75);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Piezas Reparación");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(246, 11, 317, 51);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel2.setText("Orden Reparación:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 40, 110, 14);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(120, 40, 80, 20);

        jLabel3.setText("Matrícula:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(210, 40, 60, 14);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(270, 40, 107, 20);

        jLabel4.setText("Marca:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(400, 40, 40, 14);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(440, 40, 114, 20);

        jLabel5.setText("Modelo:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(570, 40, 50, 14);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(620, 40, 140, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 73, 0, 0);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel6.setText("Observaciones para la reparación");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 130, 830, 110);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");

        jButton4.setText("Buscar Pieza");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(152, 152, 152))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 381, 830, 50);

        jButton5.setText("Realizar Pedido");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(10, 440, 179, 23);

        jButton7.setText("Salir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(760, 440, 80, 23);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(null);

        jLabel7.setText("Orden Reparación:");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(20, 20, 120, 14);

        jTextField6.setEditable(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField6);
        jTextField6.setBounds(143, 20, 120, 20);

        jLabel8.setText("Matrícula:");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(280, 20, 60, 14);

        jTextField7.setEditable(false);
        jPanel4.add(jTextField7);
        jTextField7.setBounds(340, 20, 107, 20);

        jLabel9.setText("Marca:");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(470, 20, 50, 14);

        jTextField8.setEditable(false);
        jPanel4.add(jTextField8);
        jTextField8.setBounds(520, 20, 114, 20);

        jLabel10.setText("Modelo:");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(650, 20, 50, 14);

        jTextField9.setEditable(false);
        jPanel4.add(jTextField9);
        jTextField9.setBounds(704, 20, 110, 20);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(10, 68, 830, 60);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ArrayList<Pieza> lPie = null;
        try{
            lPie = cliente.ConsultaDescripcion(jTextField1.getText());
            Iterator i = lPie.iterator();
            while(i.hasNext())
                System.out.println("sale_"+i.next());
            rellenaTabla(lPie);
        } catch (ExceptionErrorDataBase ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jTable1.getSelectionModel().setSelectionInterval(0, 0);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        try {
            Pieza p2 = cliente.ConsultaCodigo(Integer.parseInt(jTable1.getValueAt(0, 0).toString()));
//            StockPeca sp2 = cliente.consultaStockPiezabyCodigoPieza(Integer.parseInt(p2.getCodiPieza().toString()), uC.getTaller());
            //Pedido ped = new Pedido(true,dateFormat.format(date),p2.getCodiPieza(),tall.getCapTaller(),p2.getIdProveedor(),);
        } catch (ExceptionErrorDataBase ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
