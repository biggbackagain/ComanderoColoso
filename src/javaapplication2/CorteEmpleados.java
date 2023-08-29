/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication2;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author garci
 */
public class CorteEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form CorteEmpleados
     *
     */
    DefaultTableModel model;

    public CorteEmpleados() {

        initComponents();
        String[] titulos = {"NoPedido", "NoEmpleado", "TotalVenta", "Fecha"};
        model = new DefaultTableModel(null, titulos);
        tableRepartidores.setModel(model);
        mostrarDatos();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        repartidoresCorteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRepartidores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        repartidoresLogo = new javax.swing.JLabel();
        cortedeRepartidoresText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setTitle("Corte de Repartidores");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        repartidoresCorteBtn.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        repartidoresCorteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/cut.png"))); // NOI18N
        repartidoresCorteBtn.setText("CORTE");
        repartidoresCorteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repartidoresCorteBtnActionPerformed(evt);
            }
        });
        getContentPane().add(repartidoresCorteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 176, -1));

        tableRepartidores.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        tableRepartidores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableRepartidores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 11, 388, 473));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 278, -1, -1));

        repartidoresLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/Logo-removebg-preview.png"))); // NOI18N
        getContentPane().add(repartidoresLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 80, -1, -1));

        cortedeRepartidoresText.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        cortedeRepartidoresText.setText("CORTE DE REPARTIDORES");
        getContentPane().add(cortedeRepartidoresText, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 33, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 315, -1, -1));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 315, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 321, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 327, -1, 59));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void repartidoresCorteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repartidoresCorteBtnActionPerformed
        // TODO add your handling code here:

        limpiarTabla();
        busquedaDatos();


    }//GEN-LAST:event_repartidoresCorteBtnActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here

    }//GEN-LAST:event_formWindowClosed
    public void cerrarVentana() {
        frameUsuario f = new frameUsuario();
        f.setVisible(true);
        setVisible(false);
    }

    public void limpiarTabla() {
        for (int i = 0; i < tableRepartidores.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
    }

    public void busquedaDatos() {

        conexion objConexion = new conexion();
        
        int result = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de empleado"));
        try {
            int cont=0;
            LocalDateTime ldt = LocalDateTime.now();
            String Fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt);
            System.out.println(Fecha);
            
           
            ResultSet resultado = objConexion.consultarRegistros("SELECT NoPedido, NoEmpleado, TotalVenta, Fecha FROM Pedidos WHERE NoEmpleado= " + result + " AND Fecha BETWEEN '" + Fecha + " 00:00:00' AND '" + Fecha + " 23:59:59'");

            while (resultado.next()) {
                Object[] oUsuario = {resultado.getString("NoPedido"), resultado.getString("NoEmpleado"), resultado.getString("TotalVenta"), resultado.getString("Fecha")};
                model.addRow(oUsuario);
                cont++;
            }
            jLabel4.setText("<html> <h1 style='text-align: center;'>TOTAL A PAGAR EMPLEADO #" + result + "</h1> <h3 style='text-align: center;'>  <br>TOTAL DE PEDIDOS: "+cont+" Y LA COMISION ES DE: $"+ cont*5+".00 PESOS</h3></html>");

            resultado.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese solamente números y no deje espacios en blanco");

        }
        sumDatos(result);

    }

    public void mostrarDatos() {

        conexion objConexion = new conexion();
        try {

            LocalDateTime ldt = LocalDateTime.now();
            String Fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt);
            System.out.println(Fecha);
            ResultSet resultado = objConexion.consultarRegistros("SELECT *FROM Pedidos WHERE Fecha BETWEEN '" + Fecha + " 00:00:00' AND '" + Fecha + " 23:59:59'");
            while (resultado.next()) {
                Object[] oUsuario = {resultado.getString("NoPedido"), resultado.getString("NoEmpleado"), resultado.getString("TotalVenta"), resultado.getString("Fecha")};
                model.addRow(oUsuario);
            }
            resultado.close();

        } catch (Exception e) {
            System.out.println(e);
            limpiarTabla();

        }

    }

    public void sumDatos(double result) {

        conexion objConexion = new conexion();
        double d = 0;
        try {

            LocalDateTime ldt = LocalDateTime.now();
            String Fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt);
            System.out.println(Fecha);
            ResultSet resultado = objConexion.consultarRegistros("SELECT SUM (TotalVenta) as TotalAmo FROM Pedidos WHERE NoEmpleado = '" + result + "' AND Fecha BETWEEN '" + Fecha + " 00:00:00' AND '" + Fecha + " 23:59:59'");
            if (resultado.getString("TotalAmo") == null) {
                jLabel4.setText("");
                jLabel6.setText("           NO TIENE VENTA");
                resultado.close();
            } else {
                d = Double.parseDouble(resultado.getString("TotalAmo"));
                jLabel6.setText("<html> <br><h2 style='text-align: right;'>                 $" + d + "0 PESOS </h2></html>");
                
                resultado.close();

            }

        } catch (Exception e) {
            limpiarTabla();
            System.out.println(e);
            mostrarDatos();

        }

    }

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
            java.util.logging.Logger.getLogger(CorteEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CorteEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CorteEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CorteEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CorteEmpleados().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cortedeRepartidoresText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton repartidoresCorteBtn;
    private javax.swing.JLabel repartidoresLogo;
    private javax.swing.JTable tableRepartidores;
    // End of variables declaration//GEN-END:variables
}
