/*
Chimaltenango, 22 de julio de 2023
Programador: William Monroy
Descripcion: Ejemplo de estructura condicional simple
 */
package I_PARCIAL;

import java.util.Scanner;

public class Ejercicio_03 {
    public static void main(String[] args){
        System.out.println("Ejemplo de Estructura Condicional Simple");
        Scanner teclado=new Scanner(System.in);
        float sueldo;
        System.out.println("Ingrese el sueldo");
        sueldo=teclado.nextFloat();
        if (sueldo>3000){
            System.out.println("Esta persona debe abonar impuestos");
            
        }
}
}