/*
Chimaltenango, 28 de julio de 2023
Programador: William Monroy
Descripcion: Ejemplo de estructura repetitiva Do While
 */
package I_PARCIAL.EstructurasRepetitiva;

import java.util.Scanner;

public class EstructuraRepetitivaDoWhile {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        int numero;
        do {
            System.out.print("Ingrese un número (ingrese 0 para finalizar): ");
            numero = input.nextInt();
            // Verificar si el número ingresado es diferente de 0 antes de incluirlo en la suma y contar.
            if (numero != 0) {
                sum += numero;
                count++;
            }
        } while (numero != 0);
        input.close();
        if (count == 0) {
            System.out.println("No se ingresaron números válidos.");
        } else {
            double promedio = (double) sum / count;
            System.out.println("El promedio de los números ingresados es: " + promedio);
        }
    }
    
}
