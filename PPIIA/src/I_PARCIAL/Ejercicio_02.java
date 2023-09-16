/*
*
Chimaltenango, 22 de julio de 2023
Programador: William Monroy
Descripcion: Ejemplo de Estructura Secuencial
 */
package I_PARCIAL;

import java.util.Scanner;

public class Ejercicio_02 {
    public static void main(String[] args) {
        System.out.println("Ejemplo de estructura secuencial");
        Scanner teclado=new Scanner (System.in);
        int num1,num2,suma,producto;
        System.out.println("Ingrese primer valor");
        num1=teclado.nextInt();
        System.out.println("Ingrese segundo valor");
        num2=teclado.nextInt();
        suma=num1+num2;
        producto=num1*num2;
        System.out.print("La suma de los valores es: ");
        System.out.println(suma);
        System.out.print("El producto de los dos valores es: ");
        System.out.println(producto);
                
    }
}
