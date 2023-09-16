/*
 * Chimaltenango 25 agosto de 2023.
 * Programador: William Omar Monroy Perez
 * Descripción del programa: Programa que permitira la conexion con la base de datos
 */
package I_PARCIAL.BaseDeDatos;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    Connection con;
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdnegocio", "root", "");
        }catch(Exception e){
            System.err.println("No se puedo establecer la conexion con la base de datos: "+ e);
        }
    }
    public Connection getConnection(){
        return con;
    }
}
