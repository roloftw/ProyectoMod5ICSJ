/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author PC
 */
public class Modulo3 extends javax.swing.JFrame {

    /**
     * Creates new form Modulo3
     */
    public Modulo3() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane_mod3 = new javax.swing.JTabbedPane();
        jPanel_ranking = new javax.swing.JPanel();
        box_rankingProductos_seleccioneCategorias = new javax.swing.JComboBox<>();
        lab_rankingProductos_seleccioneCategoria = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_historialVentas_productosVenta = new javax.swing.JTable();
        btn_rankingProductos_buscar = new javax.swing.JButton();
        lab_rankingProductos_background3 = new javax.swing.JLabel();
        jPanel_historial = new javax.swing.JPanel();
        cal_historialVentas_fechaDesde = new com.toedter.calendar.JDateChooser();
        cal_historialVentas_fechaHasta = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lab_historialVentas_background3 = new javax.swing.JLabel();
        jPanel_ventasCliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txta_ventasCliente = new javax.swing.JTextArea();
        box_ventasCliente_clientes = new javax.swing.JComboBox<>();
        lab_ventasCliente_background3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane_mod3.setBackground(new java.awt.Color(0, 51, 0));
        jTabbedPane_mod3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jPanel_ranking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        box_rankingProductos_seleccioneCategorias.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        box_rankingProductos_seleccioneCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semillas", "Bongs", "Sustratos", "Articulos Indoor" }));
        jPanel_ranking.add(box_rankingProductos_seleccioneCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, 20));

        lab_rankingProductos_seleccioneCategoria.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lab_rankingProductos_seleccioneCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lab_rankingProductos_seleccioneCategoria.setText("Seleccione Categoria");
        jPanel_ranking.add(lab_rankingProductos_seleccioneCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        tab_historialVentas_productosVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Producto", "Venta"
            }
        ));
        jScrollPane1.setViewportView(tab_historialVentas_productosVenta);
        if (tab_historialVentas_productosVenta.getColumnModel().getColumnCount() > 0) {
            tab_historialVentas_productosVenta.getColumnModel().getColumn(1).setMinWidth(45);
            tab_historialVentas_productosVenta.getColumnModel().getColumn(1).setMaxWidth(45);
        }

        jPanel_ranking.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 390, 147));

        btn_rankingProductos_buscar.setText("Buscar");
        btn_rankingProductos_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rankingProductos_buscarActionPerformed(evt);
            }
        });
        jPanel_ranking.add(btn_rankingProductos_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        lab_rankingProductos_background3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.jpg"))); // NOI18N
        lab_rankingProductos_background3.setText("jLabel1");
        jPanel_ranking.add(lab_rankingProductos_background3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 1000, 640));

        jTabbedPane_mod3.addTab("Ranking de Productos", jPanel_ranking);

        jPanel_historial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel_historial.add(cal_historialVentas_fechaDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 87, -1, -1));
        jPanel_historial.add(cal_historialVentas_fechaHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 87, -1, -1));

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel_historial.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 330, 133));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione el periodo");
        jPanel_historial.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 41, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hasta");
        jPanel_historial.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 87, -1, 14));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Desde");
        jPanel_historial.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 87, -1, -1));

        lab_historialVentas_background3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.jpg"))); // NOI18N
        lab_historialVentas_background3.setText("jLabel1");
        jPanel_historial.add(lab_historialVentas_background3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 1000, 640));

        jTabbedPane_mod3.addTab("Historial de Ventas", jPanel_historial);

        jPanel_ventasCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleccione el cliente");
        jPanel_ventasCliente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 48, -1, 27));

        txta_ventasCliente.setEditable(false);
        txta_ventasCliente.setColumns(20);
        txta_ventasCliente.setRows(5);
        jScrollPane2.setViewportView(txta_ventasCliente);

        jPanel_ventasCliente.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 330, 136));

        box_ventasCliente_clientes.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        box_ventasCliente_clientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente 1", "Cliente 2", "Cliente 3", "Cliente 4" }));
        jPanel_ventasCliente.add(box_ventasCliente_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 93, 108, -1));

        lab_ventasCliente_background3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo.jpg"))); // NOI18N
        lab_ventasCliente_background3.setText("jLabel1");
        jPanel_ventasCliente.add(lab_ventasCliente_background3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 1000, 640));

        jTabbedPane_mod3.addTab("Ventas por Cliente", jPanel_ventasCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane_mod3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane_mod3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btn_rankingProductos_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rankingProductos_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_rankingProductos_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(Modulo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modulo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modulo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modulo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modulo3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> box_rankingProductos_seleccioneCategorias;
    public javax.swing.JComboBox<String> box_ventasCliente_clientes;
    public javax.swing.JButton btn_rankingProductos_buscar;
    public com.toedter.calendar.JDateChooser cal_historialVentas_fechaDesde;
    public com.toedter.calendar.JDateChooser cal_historialVentas_fechaHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel_historial;
    private javax.swing.JPanel jPanel_ranking;
    private javax.swing.JPanel jPanel_ventasCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane_mod3;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lab_historialVentas_background3;
    private javax.swing.JLabel lab_rankingProductos_background3;
    private javax.swing.JLabel lab_rankingProductos_seleccioneCategoria;
    private javax.swing.JLabel lab_ventasCliente_background3;
    public javax.swing.JTable tab_historialVentas_productosVenta;
    public javax.swing.JTextArea txta_ventasCliente;
    // End of variables declaration//GEN-END:variables
}
