
package javaapplication2;

/**
 *
 * @author garci
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public class conexion 
{
    String strConexionDB= "jdbc:sqlite:src/javaapplication2/sqliteadmin/sistema.s3db";
    Connection conn = null;
    public conexion()
    {
        try 
        {
           Class.forName("org.sqlite.JDBC");
           conn=DriverManager.getConnection(strConexionDB);
           System.out.println("Conexion Establecida");
           
        } 
        catch (Exception e) 
        {
            System.out.println("Error de Conexion"+e);
        }
        
    }
    public int ejecutarSentenciaSQL(String strSentenciaSQL)
    {
        try 
        {
            PreparedStatement pstm=conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            pstm.close();
            
            return 1;
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Numero De Pedido Repetido, verifique su comanda!");
            return 0;
        }
       
        
    }
     public int ejecutarSentenciaSQL2(String strSentenciaSQL, String strSentenciaInsert)
    {
        try 
        {
            PreparedStatement pstm=conn.prepareStatement(strSentenciaSQL);
            
            ResultSet respuesta = pstm.executeQuery();
            if(respuesta.next())
            {
                pstm.execute();
                respuesta.close();
                ejecutarSentenciaSQL(strSentenciaInsert);
                return 1;
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Verifique su informacion y sus derechos");
                return 0;
            }              
                
          
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Numero De Pedido Repetido, verifique su comanda!");
            return 0;
        }
        
       
        
    }
     
     public int ejecutarSentenciaPermiso(String strSentenciaSQL)
    {
        try 
        {
            PreparedStatement pstm=conn.prepareStatement(strSentenciaSQL);
            
            ResultSet respuesta = pstm.executeQuery();
            if(respuesta.next())
            {
                pstm.execute();
                respuesta.close();
                return 1;
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Dato incorrecto");
                return 0;
            }              
                
         
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Numero De Pedido Repetido, verifique su comanda!");
            
            return 0;
        }
        
       
        
    }
     
     
     
    public ResultSet consultarRegistros(String strSentenciaSQL)
    {
        try 
        {
             PreparedStatement pstm=conn.prepareStatement(strSentenciaSQL);
             ResultSet respuesta = pstm.executeQuery();
             return respuesta;
     
            
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            return null;
        }
     
       
    }
    
}
