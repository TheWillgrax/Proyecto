/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package I_PARCIAL.BasedeDatosEjercicioPractica;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    Connection con;
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdejercicio", "root", "");
        }catch(Exception e){
            System.err.println("No se puedo establecer la conexion con la base de datos: "+ e);
        }
    }
    public Connection getConnection(){
        return con;
    }
    
}
