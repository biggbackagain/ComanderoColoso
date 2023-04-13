/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author garci
 */
public class empleadosBL {
    private int NoEmpleado;
    private String Contrasena;
    private String NombreEmpleado;
    private String ApellidoEmpleado;
    private int AdministradorEmpleado;

    public int AdministradorEmpleado() {
        return AdministradorEmpleado;
    }

    public int setAdministradorEmpleado(int AdministradorEmpleado) {
        this.AdministradorEmpleado = AdministradorEmpleado;
        return 0;
    }
    

    public int getNoEmpleado() {
        return NoEmpleado;
    }

    public void setNoEmpleado(int NoEmpleado) {
        this.NoEmpleado = NoEmpleado;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getNombreEmpleado() {
        return NombreEmpleado;
    }

    public void setNombreEmpleado(String NombreEmpleado) {
        this.NombreEmpleado = NombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return ApellidoEmpleado;
    }

    public void setApellidoEmpleado(String ApellidoEmpleado) {
        this.ApellidoEmpleado = ApellidoEmpleado;
    }
    
    
    
}
