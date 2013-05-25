/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3.gui;

import common.rmi.Client;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss2.entity.Solicitud;
import ss2.exception.AppException;
import ss3.beans.Reparacion;
import ss3.beans.Vehiculo;
/**
 *
 * @author Fernando
 */
public class Reparaciones extends JPanel {

    /**
     * Creates new form Reparaciones
     */
    
    public Client cliente;
    private DefaultTableModel dtm;
    JTable jTable1;
    JScrollPane scrollPane;
     
    
    public Reparaciones(Client cli) throws ExceptionErrorDataBase, RemoteException {
        cliente = cli;
        initComponents();
               
        jTable1 = crearTabla();
        scrollPane = new JScrollPane();
        scrollPane.setBounds(5, 190, 830, 125);
        add(scrollPane);
        scrollPane.setViewportView(jTable1);
        rellenaTabla(cliente.ConsultaTodas());
        
    }
    
    public void rellenaTabla(ArrayList<Reparacion> repa) throws AppException, ExceptionErrorDataBase, RemoteException {
        
        
        try {
                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                int rowCount = tableModel.getRowCount();
                Iterator itRep = repa.iterator();
                int i=0;
                Reparacion r1 = new Reparacion();
                Solicitud s1 = new Solicitud();
                Vehiculo v1 = new Vehiculo();
                
                while (itRep.hasNext()){
                    r1 = (Reparacion) itRep.next();
                    s1 = cliente.buscaSolicitudbynumrep(r1.getIdOrden());
                    v1 = cliente.ConsultaReparacion(r1.getIdOrden());
                    if (r1.getIdOrden() > 0){
                        if(i==rowCount-1) 
                            tableModel.addRow(new Object[]{});
                        tableModel.setValueAt(r1.getIdOrden(), i, 0);
                        tableModel.setValueAt(s1.getDataAlta(),i,1);
                        tableModel.setValueAt(r1.getContador(),i,2);
                        tableModel.setValueAt(v1.getMatricula(),i,3);
                        tableModel.setValueAt(v1.getMarca(),i,4);
                        tableModel.setValueAt(v1.getModelo(),i,5);
                        tableModel.setValueAt(r1.getObservaciones(),i,6);
                        if (r1.isAceptada())
                            tableModel.setValueAt("SI",i,7);
                        else
                            tableModel.setValueAt("NO",i,7);
                        if (r1.isAsignada())
                            tableModel.setValueAt("SI",i,8);
                        else
                            tableModel.setValueAt("NO",i,8);
                        i++;
                    }
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

                jTable1 = createTabla(tableModel);
                scrollPane.setViewportView(jTable1);
                
            } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
                //todo pensar que se hace aqui
                exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (RemoteException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

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
                new String[] {"Orden","Fecha Entrada","Cont. Minutos", "Matrícula","Marca","Modelo","Observaciones","Aceptada","Asignada"}
        ){
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class
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
        table.getColumnModel().getColumn(6).setPreferredWidth(205);
        table.getColumnModel().getColumn(6).setMinWidth(205);
        table.getColumnModel().getColumn(6).setMaxWidth(205);
        table.getColumnModel().getColumn(7).setResizable(false);
        table.getColumnModel().getColumn(7).setPreferredWidth(56);
        table.getColumnModel().getColumn(7).setMinWidth(56);
        table.getColumnModel().getColumn(7).setMaxWidth(56);
        table.getColumnModel().getColumn(8).setResizable(false);
        table.getColumnModel().getColumn(8).setPreferredWidth(56);
        table.getColumnModel().getColumn(8).setMinWidth(56);
        table.getColumnModel().getColumn(8).setMaxWidth(56);
        table.setBounds(10, 190, 830, 125);
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Reparación");
        add(jLabel1);
        jLabel1.setBounds(324, 11, 196, 51);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel8.setText("De (aaaa-mm-dd)");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(440, 16, 101, 14);

        jLabel9.setText("Hasta (aaa-mm-dd)");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(440, 57, 101, 14);
        jPanel1.add(jTextField6);
        jTextField6.setBounds(551, 13, 71, 20);
        jPanel1.add(jTextField7);
        jTextField7.setBounds(551, 54, 71, 20);

        jLabel10.setText("Nombre Cliente");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(632, 16, 79, 14);

        jLabel11.setText("Apellido Cliente");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(632, 57, 79, 14);
        jPanel1.add(jTextField8);
        jTextField8.setBounds(715, 13, 98, 20);
        jPanel1.add(jTextField9);
        jTextField9.setBounds(715, 54, 98, 20);

        jLabel2.setText("Nº Orden");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 20, 51, 14);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(70, 20, 63, 20);

        jLabel3.setText("Matricula");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 20, 54, 14);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(220, 20, 75, 20);

        jLabel4.setText("Marca");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(160, 50, 46, 14);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(220, 50, 75, 20);

        jLabel5.setText("Modelo");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(160, 90, 46, 14);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(220, 80, 75, 20);

        jCheckBox1.setText("¿Aceptada?");
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(331, 12, 81, 23);

        jCheckBox2.setText("¿Asignada?");
        jPanel1.add(jCheckBox2);
        jCheckBox2.setBounds(333, 53, 79, 23);

        add(jPanel1);
        jPanel1.setBounds(10, 68, 0, 120);

        jButton8.setText("Consultar/Filtrar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        add(jButton8);
        jButton8.setBounds(10, 360, 140, 52);

        jButton9.setText("Detalle");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        add(jButton9);
        jButton9.setBounds(290, 360, 90, 52);

        jButton10.setText("Aceptar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        add(jButton10);
        jButton10.setBounds(380, 360, 90, 52);

        jButton11.setText("Asignar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        add(jButton11);
        jButton11.setBounds(470, 360, 100, 52);

        jButton12.setText("Finalizar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        add(jButton12);
        jButton12.setBounds(570, 360, 90, 52);

        jButton13.setText("Salir");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        add(jButton13);
        jButton13.setBounds(750, 360, 93, 52);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Nº Orden");

        jLabel7.setText("Matricula");

        jLabel12.setText("Marca");

        jLabel13.setText("Modelo");

        jLabel14.setText("Desde (aaaa-mm-dd)");

        jLabel15.setText("Hasta (aaaa-mm-dd)");

        jLabel16.setText("Nombre Cliente");

        jLabel17.setText("Apellido Cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jTextField16))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14)
                                .addComponent(jLabel16)
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(jPanel2);
        jPanel2.setBounds(10, 70, 830, 110);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Map values = new LinkedHashMap();
                try {
                    if (!jTextField14.getText().isEmpty()) {
                        values.put("nomCliente", jTextField14.getText());
                    }
                    if (!jTextField15.getText().isEmpty()) {
                        values.put("apeCliente", jTextField15.getText());
                    }
                    if (!jTextField13.getText().isEmpty()) {
                        values.put("desde", jTextField13.getText());
                    }
                    if (!jTextField16.getText().isEmpty()) {
                        values.put("hasta", jTextField16.getText());
                    }
                    if (!jTextField5.getText().isEmpty()) {
                        values.put("orden", jTextField5.getText());
                    }
                    if (!jTextField17.getText().isEmpty()) {
                        values.put("matricula", jTextField17.getText());
                    }
                    if (!jTextField18.getText().isEmpty()) {
                        values.put("marca", jTextField18.getText());
                    }
                    if (!jTextField19.getText().isEmpty()) {
                        values.put("modelo", jTextField19.getText());
                    }
                    
                    rellenaTabla(cliente.ConsultaReparacionesByTerms(values));
                } catch (RemoteException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (ExceptionErrorDataBase ex) {
                    ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        DetalleReparacionAsig dra = new DetalleReparacionAsig(cliente, (Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 3), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 4), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 5));
        dra.setVisible(true);
        dra.setModal(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if (jTable1.getValueAt(jTable1.getSelectedRow(), 7).equals("NO"))
            try {
                cliente.aceptaReparacion((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            } catch (ExceptionErrorDataBase ex) {
                ex.printStackTrace();
            } catch (RemoteException ex) {
                ex.printStackTrace();
        }
        PiezasReparacion pr = new PiezasReparacion(cliente, (Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 3), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 4), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 5));
        pr.setVisible(true);
        pr.setModal(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        //Si está aceptada pero no asignada a Mecanico, abrirá la pantalla AsignarAMecanico
        //Si está aceptada y asignada, mostrará un mensaje indicando que ya está asignada y dará la posibilidad de asignar otro
        //Si no está aceptada y pulsamos en ASignada, saldrá un mensaje indicando que aún no se ha aceptado la orden
        if (jTable1.getValueAt(jTable1.getSelectedRow(), 7).equals("SI")&&jTable1.getValueAt(jTable1.getSelectedRow(), 8).equals("NO")){
            AsignacionAMecanico aam = new AsignacionAMecanico(cliente, (Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 3), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 4), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 5));
            aam.setVisible(true);
            aam.setModal(true);
        }
        if (jTable1.getValueAt(jTable1.getSelectedRow(), 7).equals("SI")&&jTable1.getValueAt(jTable1.getSelectedRow(), 8).equals("SI")){
            
            AsignacionAMecanico aam = new AsignacionAMecanico(cliente, (Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 3), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 4), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 5));
            aam.setVisible(true);
            aam.setModal(true);
            Avisos av = new Avisos("Esta reparación ya asignada, sin embargo, puede cambiar al mecánico si lo desea.");
            av.setVisible(true);
            av.setModal(true);
        }
        if (jTable1.getValueAt(jTable1.getSelectedRow(), 7).equals("NO")){
            Avisos av = new Avisos("Esta reparación aún no ha sido aceptada.");
            av.setVisible(true);
            av.setModal(true);
        }
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        Avisos av=null;
        if(jTable1.getValueAt(jTable1.getSelectedRow(),7).equals("NO")){
            av = new Avisos("Esta reparación aún no ha sido aceptada. No puede finalizarse");
            av.setVisible(true);
            av.setModal(true);
        }else{
            try {
                Solicitud sol = cliente.buscaSolicitudbynumrep((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                if (sol.getFinalitzada()){
                    av = new Avisos("Esta reparación ya está finalizada.");
                    av.setVisible(true);
                    av.setModal(true);
                }else{
                    sol.setFinalitzada(true);
                    cliente.modificaSolicitud(sol);
                }
            } catch (AppException ex) {
                ex.printStackTrace();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
            jButton8ActionPerformed(evt);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
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
