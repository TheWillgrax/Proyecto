/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package I_PARCIAL;

import java.util.Scanner;

public class CalculadoraMetodos {
    Scanner Entrada = new Scanner(System.in); 
    public void sumar(){
       float a,b,c;
       System.out.println("***************************");
       System.out.println("      Operación Suma       ");
       System.out.println("***************************");
       System.out.print("Ingrese primver valor: ");
       a=Entrada.nextFloat();
       System.out.print("Ingrese segundo valor: ");
       b=Entrada.nextFloat();
       c=a+b;
       System.out.println("El resultado de la suma es: "+c);
}
   public void restar(){
       float a,b,c;
       System.out.println("***************************");
       System.out.println("      Operación Resta      ");
       System.out.println("***************************");
       System.out.print("Ingrese primver valor: ");
       a=Entrada.nextFloat();
       System.out.print("Ingrese segundo valor: ");
       b=Entrada.nextFloat();
       c=a-b;
       System.out.println("El resultado de la resta es: "+c);
}
   public void multiplicar(){
       float a,b,c;
       System.out.println("***************************");
       System.out.println("   Operación Multiplicar   ");
       System.out.println("***************************");
       System.out.print("Ingrese primver valor: ");
       a=Entrada.nextFloat();
       System.out.print("Ingrese segundo valor: ");
       b=Entrada.nextFloat();
       c=a*b;
       System.out.println("El resultado de la multiplicacion es: "+c);
}
   public void dividir(){
       float a,b,c;
       System.out.println("***************************");
       System.out.println("    Operación Division     ");
       System.out.println("***************************");
       System.out.print("Ingrese primver valor: ");
       a=Entrada.nextFloat();
       do{
       System.out.print("Ingrese segundo valor: ");
       b=Entrada.nextFloat();
       }while(b==0);
       c=a/b;
       System.out.println("El resultado de la divison es: "+c);
}

   public static void main(String[] args) {
        Scanner Entrada = new Scanner(System.in);
        CalculadoraMetodos invocametodos = new CalculadoraMetodos();
        int opcion;
        do{
            System.out.println("---------------------------");
            System.out.println("  Calculadora Aritmética   ");
            System.out.println("---------------------------");
            System.out.println("1....Suma");
            System.out.println("2....Resta");
            System.out.println("3....Multiplicacion");
            System.out.println("4....Division");
            System.out.println("5.... Salir");
            System.out.print("Selecciones su opcion: ");
            opcion=Entrada.nextInt();
            switch(opcion){
                case 1:{
                    invocametodos.sumar();
                        break;}
                case 2:{
                    invocametodos.restar();
                        break;}
                case 3:{
                    invocametodos.multiplicar();
                        break;}
                case 4:{
                    invocametodos.dividir();
                        break;}
        }
    }while(opcion!=5);
}
    
}
