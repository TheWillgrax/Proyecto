/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package I_PARCIAL.BaseDeDatos;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion_Usuarios {
    Connection conectar;
    public Connection Conexion_Usuarios(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
        }catch(Exception e){
            System.err.println("No se puedo establecer la conexion con la base de datos: "+ e);
        }
        return conectar;
    }
    
}
