/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package I_PARCIAL.BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion2 {
    Connection con;
    public Conexion2(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdventa", "root", "");
        }catch(Exception e){
            System.err.println("No se puedo establecer la conexion con la base de datos: "+ e);
        }
    }
    public Connection getConnection(){
        return con;
    }
    
}
