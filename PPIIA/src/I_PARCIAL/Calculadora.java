/*
Chimaltenango, 22 de julio de 2023
Programador: William Monroy
Descripcion: Ejemplo de una calculadora con menu
 */
package I_PARCIAL;

import java.util.Scanner;
public class Calculadora {
    public static void main(String[] args) {
        int opcion;
        Scanner teclado=new Scanner (System.in);
        do{
            System.out.println("Calculadora");
            System.out.println("1......Suma");
            System.out.println("2......Resta");
            System.out.println("3......Multiplicacion");
            System.out.println("4......Division");
            System.out.println("5......Salir");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1:{System.out.println("Suma");
                        float a,b,c;
                        System.out.println("Ingrese Primer Numero");
                        a=teclado.nextFloat();
                        System.out.println("Ingrese segundo numero");
                        b=teclado.nextFloat();
                        c=a+b;
                        System.out.println("La suma es: "+c);
                        break;}
                case 2:{System.out.println("Resta");
                        float a,b,c;
                        System.out.println("Ingrese Primer Numero");
                        a=teclado.nextFloat();
                        System.out.println("Ingrese segundo numero");
                        b=teclado.nextFloat();
                        c=a-b;
                        System.out.println("La resta es: "+c);
                        break;}
                case 3:{System.out.println("Multiplicacion");
                        float a,b,c;
                        System.out.println("Ingrese Primer Numero");
                        a=teclado.nextFloat();
                        System.out.println("Ingrese segundo numero");
                        b=teclado.nextFloat();
                        c=a*b;
                        System.out.println("La multiplicacion es: "+c);
                        break;}
                case 4:{System.out.println("Division");
                        float a,b,c;
                        System.out.println("Ingrese Primer Numero");
                        a=teclado.nextFloat();
                        do{
                        System.out.println("Ingrese segundo numero");
                        b=teclado.nextFloat();
                        }while(b==0);
                        c=a/b;
                        System.out.println("La division es: "+c);
                        break;}
        }
    }while(opcion!=5);
}
}

