/*
 * Chimaltenango 5 agosto de 2023.
 * Programador: William Monroy
 * Descripción del programa: Incorporacionn de las dos clases
 */
package I_PARCIAL;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class MiNegocio {
     String codigoProducto;
     String nombreProducto;
     int cantidadExistente;
     double precioUnitario;
     Scanner sc = new Scanner(System.in);
     
     
    public void Registrar() throws InterruptedException{
                    System.out.println("***************************************");
                    System.out.println("          REGISTRO DE HELADOS          ");
                    System.out.println("***************************************");
                    try (FileWriter fw = new FileWriter("c:/ficheros/datos.txt", true);
                    PrintWriter salida = new PrintWriter(fw)) {   
                    System.out.println("Ingrese el codigo del producto: ");
                    codigoProducto = sc.nextLine();                             //se introduce por teclado una cadena de texto 
                    System.out.println("Ingrese el nombre del producto: ");
                    nombreProducto = sc.nextLine();
                    System.out.println("La cantidad inicial del producto sera :0 ");
                    cantidadExistente = 0;
                    System.out.println("Ingrese el precio unitario del producto: ");
                    precioUnitario = sc.nextDouble();
                    salida.println(codigoProducto+" "+nombreProducto+" "+cantidadExistente+" "+precioUnitario); //se escribe la cadena en el fichero  
                    System.out.println("Producto Guardado Existosamente");
                    Thread.sleep(1500);
                    salida.close();
                    } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    }
        
    }
    public void Mostrar() throws InterruptedException{
        System.out.println("***************************");
                    System.out.println("            Leer           ");
                    System.out.println("***************************");
                    FileReader fr = null;
  
                    try {
                    fr = new FileReader("c:/ficheros/datos.txt");
                    BufferedReader entrada = new BufferedReader(fr);
                    String codigoProducto = entrada.readLine();    //se lee la primera línea del fichero
                    while (codigoProducto != null) {               //mientras no se llegue al final del fichero                   
                    System.out.println(codigoProducto);        //se muestra por pantalla
                    codigoProducto = entrada.readLine();       //se lee la siguiente línea del fichero                        
                    }
                    } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                    } catch (IOException e) {
                    System.out.println(e.getMessage());
                    } finally {
                    try {
                    if (fr != null) {
                    fr.close();
                     }
                    } catch (IOException e) {
                System.out.println(e.getMessage());
            }
       Thread.sleep(1500); }   
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner Entrada = new Scanner(System.in);
        MiNegocio invocametodos = new MiNegocio();
        int opcion;
        do{
            System.out.println("---------------------------");
            System.out.println("          FICHEROS         ");
            System.out.println("---------------------------");
            System.out.println("1....Escribir");
            System.out.println("2....Leer");
            System.out.println("3....Salir");
            opcion=Entrada.nextInt();
            switch(opcion){
            case 1:{
                invocametodos.Registrar();
                    break;}
            case 2:{
                invocametodos.Mostrar();
                    break;
                   }
                    }
        }while(opcion!=3);
      }
    
}
