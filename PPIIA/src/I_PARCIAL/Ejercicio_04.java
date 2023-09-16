/*
Chimaltenango, 22 de julio de 2023
Programador: William Monroy
Descripcion: Ejemplo de estructura condicional compuesta
 */
package I_PARCIAL;

import java.util.Scanner;

public class Ejercicio_04 {
    public static void main(String[] args) {
        System.out.println("Ejemplo de Estructura Condicional Compuesta");
        Scanner teclado=new Scanner (System.in);
            int num1,num2;
            System.out.println("Ingrese primer valor: ");
            num1=teclado.nextInt();
            System.out.println("Ingrese segundo valor: ");
            num2=teclado.nextInt();
            if (num1>num2){
                System.out.println(num1);
            }else {
                System.out.println(num2);
            }
    }
}
