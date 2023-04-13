/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author garci
 */

import javax.swing.JOptionPane;
public class pedidosBL 
{
   private int noPedido;
   private int noEmpleado;
   private int totalVenta;
   private String fechactual;
  

    public int getNoPedido() {
        return noPedido;
    }

    public void setNoPedido(int noPedido) {
        try 
        {
            this.noPedido = noPedido;
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Ingresa solamente NUMEROS y no Agregues, elimines dejando espacios en blanco");
        }
        
    }

    public int getNoEmpleado() {
        return noEmpleado;
    }

    public void setNoEmpleado(int noEmpleado) {
        try 
        {
            this.noEmpleado = noEmpleado;
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Ingresa solamente NUMEROS y no Agregues, elimines dejando espacios en blanco");
        }
        
        
        
    }

    public int getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(int totalVenta) {
        
        try 
        {
           this.totalVenta = totalVenta;
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Ingresa solamente NUMEROS y no Agregues, elimines dejando espacios en blanco");
        }
        
    }

    public String getFechactual() {
        return fechactual;
    }

    public void setFechactual(String fechactual) {
        
        try 
        {
           this.fechactual = fechactual;
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Ingresa solamente NUMEROS y no Agregues, elimines dejando espacios en blanco");
        }
        
    }

   

 
   
   
}