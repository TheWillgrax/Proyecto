/*
 * Chimaltenango 11 agosto de 2023.
 * Programador: William Omar Monroy Perez
 * Descripción del programa: Programa el cual permite la utilizacion de las funciones CRUD
 */
package I_PARCIAL;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException; //Este permite encontrar errores
import java.io.PrintWriter; //Creacion del archivo
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;  
public class Laboratorio {
    
  static Scanner teclado = new Scanner(System.in);
  
  public void registrar(){
    //ATRIBUTOS
    String registro;
    String codigoProducto;
    String nombreProducto;
    int cantidadExistente;
    float precioUnitario;
    String tipoHelado;
  
    //Ingreso de datos en el fichero
    System.out.println("***************************************");
    System.out.println("          REGISTRO DE HELADOS          ");
    System.out.println("***************************************");
    System.out.print("Ingrese código del producto: ");
    codigoProducto = teclado.nextLine();
    System.out.print("Ingrese nombre del producto: ");
    nombreProducto = teclado.nextLine();
    System.out.print("Ingrese cantidad del producto: ");
    cantidadExistente = Integer.parseInt(teclado.nextLine());
    while(cantidadExistente<0){ //Validacion para que no se pueda ingresar una cantidad negativa
        System.out.print("ERROR! Cantidad no válida, Ingrese otra cantidad: ");
        cantidadExistente = Integer.parseInt(teclado.nextLine());
    }
    System.out.print("Ingrese precio del producto: ");
    precioUnitario = Float.parseFloat(teclado.nextLine());
    while(precioUnitario<0){ //Validacion para que no se pueda ingresar un precio menor que 0
        System.out.print("ERROR! Precio no válido, Ingrese otro precio: ");
        precioUnitario = Float.parseFloat(teclado.nextLine());
    }
    System.out.print("Ingrese el tipo de Helado,Cono,Vaso,Sellado: ");
    tipoHelado= teclado.nextLine();
    registro = codigoProducto + "_" + nombreProducto + "_" + cantidadExistente + "_" + precioUnitario+"_"+tipoHelado; //Contatenacion y transformacion en un solo registro
    try(FileWriter fw = new FileWriter("c:/ficheros/datos.txt", true); PrintWriter salida = new PrintWriter(fw)){
        salida.println(registro);
        System.out.println("--------------------------------------");
        System.out.println("PRODUCTO INGRESADO EXISTOSAMENTE!");
    }catch(IOException ex){
        System.out.println("--------------------------------------");
        System.out.println(ex.getMessage());
    }
  }
  
  public void mostrar(){
      String linea;
      float granTotal = 0, total = 0;
      boolean vacio = true;
      System.out.println("***************************************");
      System.out.println("                 HELADOS               ");
      System.out.println("***************************************");
      try (BufferedReader br = new BufferedReader(new FileReader("c:/ficheros/datos.txt"))) {
            while ((linea = br.readLine()) != null) {
                vacio = false;
                // Divide en componente utilizando: "_"
                String[] componente = linea.split("_");
                if (componente.length >= 5){ //Verificacion de componentes (Código, Nombre, Cantidad y Precio)
                    // Mostrar datos
                    System.out.println("Código: " + componente[0]);
                    System.out.println("Nombre: " + componente[1]);
                    System.out.println("Cantidad: " + componente[2]);
                    System.out.println("Precio Unitario: Q" + componente[3]);
                    System.out.println("Tipo de Helado: "+ componente[4]);
                    total =  Float.parseFloat(componente[2]) * Float.parseFloat(componente[3]);
                    System.out.println("Total: Q" + total);
                    granTotal = granTotal + total;
                    System.out.println("--------------------------------------");
                } else {
                    System.out.println("Registro incompleto: " + linea);
                }
            }
            if(vacio){
                System.out.println("El documento está vacío, no hay datos");
            }else{
                System.out.println("GRAN TOTAL: Q" + granTotal);
            }
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo: " + e.getMessage());
        }
  }
  
  public void ingresar(){
      String cod, nuevoRegistro;
      int cantidad;
      float total;
      boolean vacio = true, productoInexistente = true;
      System.out.println("Ingrese el código del producto: ");
      cod = teclado.nextLine();
      System.out.println("***************************************");
      System.out.println("                 HELADOS               ");
      System.out.println("***************************************");
      try {
            // Crear objetos para leer y escribir en archivos
            BufferedReader reader = new BufferedReader(new FileReader("c:/ficheros/datos.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("c:/ficheros/datos_temp.txt"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                vacio = false;
                // Dividir la línea en partes usando el "_" como separador
                String[] componente = linea.split("_");
                if (componente.length >= 5) {
                    // Verificar si el registro coincide con el que se va a modificar
                    if (cod.equals(componente[0])) {
                        productoInexistente = false;
                        // Muestra los datos 
                        System.out.println("Código: " + componente[0]);
                        System.out.println("Código: " + componente[0]);
                        System.out.println("Nombre: " + componente[1]);
                        System.out.println("Cantidad: " + componente[2]);
                        System.out.println("Precio Unitario: Q" + componente[3]);
                        System.out.println("Tipo de Helado:"+componente[4]);
                        total =  Float.parseFloat(componente[2]) * Float.parseFloat(componente[3]);
                        System.out.println("Total: Q" + total);
                        System.out.println("--------------------------------------");
                        // Realiza el registro modificado
                        System.out.println("Escribe la cantidad a ingresar: ");
                        cantidad = Integer.parseInt(componente[2]) + Integer.parseInt(teclado.nextLine());
                        while(cantidad<Integer.parseInt(componente[2])){
                            System.out.print("ERROR! Cantidad no válida, Ingrese otra cantidad: ");
                            cantidad = Integer.parseInt(componente[2]) + Integer.parseInt(teclado.nextLine());
                        }
                        LocalDateTime fechaHoraActual = LocalDateTime.now();
                        String fechaHoraTexto = fechaHoraActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        nuevoRegistro = componente[0] +"_"+ componente[1] +"_"+ cantidad +"_"+ componente[3] +"_"+componente[4]+"_"+ "Ingreso: " + fechaHoraTexto;
                        writer.write(nuevoRegistro);
                        // Datos modificados
                        System.out.println("***************************************");
                        System.out.println("           HELADO MODIFICADO           ");
                        System.out.println("***************************************");
                        System.out.println("Código: " + componente[0]);
                        System.out.println("--------------------------------------");
                        System.out.println("Código: " + componente[0]);
                        System.out.println("Nombre: " + componente[1]);
                        System.out.println("Cantidad: " + cantidad);
                        System.out.println("Precio Unitario: Q" + componente[3]);
                        System.out.println("Tipo de Helado: "+componente[4]);
                        total =  cantidad * Float.parseFloat(componente[3]);
                        System.out.println("Total: Q" + total);
                        System.out.println("--------------------------------------");
                    } else {
                        // Conserva el dato original
                        writer.write(linea);
                    }
                    // Agregar un salto de línea después de cada registro
                    writer.newLine();
                }
            }
            // Cerrar los objetos de lectura y escritura
            reader.close();
            writer.close();
            // Eliminacion del archivo viejo
            File archivoOriginal = new File("c:/ficheros/datos.txt");
            archivoOriginal.delete();
            // Renombra el archivo nuevo con el nombre del viejo
            File archivoTemporal = new File("c:/ficheros/datos_temp.txt");
            String directorio = archivoTemporal.getParent();
            File archivoNuevo = new File(directorio, "datos.txt");
            archivoTemporal.renameTo(archivoNuevo);
            if(vacio){
                System.out.println("--------------------------------------");
                System.out.println("El documento está vacío, no hay datos");
            }else if(productoInexistente){
                System.out.println("--------------------------------------");
                System.out.println("El código que ingresaste no existe");
            }else{
                System.out.println("Producto ingresado exitosamente.");
            }
        } catch (IOException e) {
            System.out.println("Error al modificar el registro: " + e.getMessage());
        }
  }
  
  public void extraer(){
      String cod, nuevoRegistro;
      int cantidad;
      float total;
      boolean vacio = true, productoInexistente = true;
      System.out.println("Ingrese el código del producto: ");
      cod = teclado.nextLine();
      System.out.println("***************************************");
      System.out.println("                 HELADO                ");
      System.out.println("***************************************");
      try {
            // Crear objetos para leer y escribir en archivos
            BufferedReader reader = new BufferedReader(new FileReader("c:/ficheros/datos.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("c:/ficheros/datos_temp.txt"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                vacio = false;
                // Dividir la línea en partes usando el "_" como separador
                String[] componente = linea.split("_");
                if (componente.length >= 5) {
                    // Verificar si el registro coincide con el que se va a modificar
                    if (cod.equals(componente[0])) {
                        productoInexistente = false;
                        // Muestra datos
                        System.out.println("Código: " + componente[0]);
                        System.out.println("Nombre: " + componente[1]);
                        System.out.println("Cantidad: " + componente[2]);
                        System.out.println("Precio Unitario: Q" + componente[3]);
                        System.out.println("Tipo de Helado: "+componente[4]);
                        total =  Float.parseFloat(componente[2]) * Float.parseFloat(componente[3]);
                        System.out.println("Total: Q" + total);
                        System.out.println("--------------------------------------");
                        // Escribe el registro modificado
                        System.out.println("Escribe la cantidad a ingresar: ");
                        cantidad = Integer.parseInt(componente[2]) - Integer.parseInt(teclado.nextLine());
                        while(cantidad>Integer.parseInt(componente[2]) || cantidad < 0){
                            System.out.print("ERROR! Cantidad no válida, Ingrese otra cantidad: ");
                            cantidad = Integer.parseInt(componente[2]) - Integer.parseInt(teclado.nextLine());
                        }
                        LocalDateTime fechaHoraActual = LocalDateTime.now();
                        String fechaHoraTexto = fechaHoraActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        nuevoRegistro = componente[0] +"_"+ componente[1] +"_"+ cantidad +"_"+ componente[3] +"_"+componente[4]+"_"+"Extracción: " + fechaHoraTexto;
                        writer.write(nuevoRegistro);
                        // Muestra los datos modificados
                        System.out.println("***************************************");
                        System.out.println("           HELADO MODIFICADO           ");
                        System.out.println("***************************************");
                        System.out.println("--------------------------------------");
                        System.out.println("Código: " + componente[0]);
                        System.out.println("Nombre: " + componente[1]);
                        System.out.println("Cantidad: " + cantidad);
                        System.out.println("Precio Unitario: Q" + componente[3]);
                        System.out.println("Tipo de Helado: "+componente[4]);
                        total =  cantidad * Float.parseFloat(componente[3]);
                        System.out.println("Total: Q" + total);
                        System.out.println("--------------------------------------");
                    } else {
                        // Corseva los registros originales
                        writer.write(linea);
                    }
                    // Agregar un salto de línea después de cada registro
                    writer.newLine();
                }
            }
            // Cerrar los objetos de lectura y escritura
            reader.close();
            writer.close();
            // Elimina el archivo viejo
            File archivoOriginal = new File("c:/ficheros/datos.txt");
            archivoOriginal.delete();
            // Renombra el archivo nuevo con el nombre del viejo
            File archivoTemporal = new File("c:/ficheros/datos_temp.txt");
            String directorio = archivoTemporal.getParent();
            File archivoNuevo = new File(directorio, "datos.txt");
            archivoTemporal.renameTo(archivoNuevo);
            if(vacio){
                System.out.println("--------------------------------------");
                System.out.println("El documento está vacío, no hay datos");
            }else if(productoInexistente){
                System.out.println("--------------------------------------");
                System.out.println("El código que ingresaste no existe");
            }else{
                System.out.println("Producto extraido exitosamente.");
            }
        } catch (IOException e) {
            System.out.println("Error al modificar el registro: " + e.getMessage());
        }
  }
  
   public void Buscar(){
      String Helado, nuevoRegistro;
      int cantidad;
      float total;
      boolean vacio = true, productoInexistente = true;
      System.out.println("Ingrese el tipo de helado que busca: ");
      Helado = teclado.nextLine();
      System.out.println("***************************************");
      System.out.println("                 HELADOS               ");
      System.out.println("***************************************");
      try {
            // Crear objetos para leer y escribir en archivos
            BufferedReader reader = new BufferedReader(new FileReader("c:/ficheros/datos.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("c:/ficheros/datos_temp.txt"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                vacio = false;
                // Dividir la línea en partes usando el "_" como separador
                String[] componente = linea.split("_");
                if (componente.length >= 5) {
                    // Verificar si el registro coincide con el que se va a modificar
                    if (Helado.equals(componente[4])) {
                        productoInexistente = false;
                        // Muestra los datos 
                        System.out.println("Código: " + componente[0]);
                        System.out.println("Código: " + componente[0]);
                        System.out.println("Nombre: " + componente[1]);
                        System.out.println("Cantidad: " + componente[2]);
                        System.out.println("Precio Unitario: Q" + componente[3]);
                        System.out.println("Tipo de Helado:"+componente[4]);
                        total =  Float.parseFloat(componente[2]) * Float.parseFloat(componente[3]);
                        System.out.println("Total: Q" + total);
                        System.out.println("--------------------------------------");
                    } else {
                        // Conserva el dato original
                        writer.write(linea);
                    }
                    // Agregar un salto de línea después de cada registro
                    writer.newLine();
                }
            }
            // Cerrar los objetos de lectura y escritura
            reader.close();
            writer.close();
            if(vacio){
                System.out.println("--------------------------------------");
                System.out.println("El documento está vacío, no hay datos");
            }else if(productoInexistente){
                System.out.println("--------------------------------------");
                System.out.println("El tipo de helado que ingresaste no existe");
            }else{
                System.out.println("Productos Encontrados.");
            }
        } catch (IOException e) {
            System.out.println("Error al modificar el registro: " + e.getMessage());
        }
  }
  
  public static void main(String[] args) throws InterruptedException {
        int opcion;
        Laboratorio metodo = new Laboratorio();
        do{
            System.out.println("************************************");
            System.out.println("      SISTEMA DE LA HELADERIA       ");
            System.out.println("************************************");
            System.out.println("======================================");
            System.out.println("1)...Registrar producto en el inventario");
            System.out.println("2)...Mostrar productos del inventario");
            System.out.println("3)...Ingresar producto al inventario");
            System.out.println("4)...Extraer  producto del inventario");
            System.out.println("5)...Buscar un helado por un tipo");
            System.out.println("6)...Salir");
            System.out.println("--------------------------------------");
            System.out.print("Elija la opcion que desea utilizar: ");
            opcion = Integer.parseInt(teclado.nextLine());
            System.out.println("======================================");
            switch(opcion){
                case 1:
                    metodo.registrar();
                break;
                case 2:
                    metodo.mostrar();
                break;
                case 3:
                    metodo.ingresar();
                break;
                case 4:
                    metodo.extraer();
                break;
                case 5:
                    metodo.Buscar();
                case 6:
                break;
                default:
                Thread.sleep(1500);
                System.out.println("Opcion invalida, intente de nuevo");
            }
        }while(opcion != 6);
    }
}