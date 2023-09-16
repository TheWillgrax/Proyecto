/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package I_PARCIAL.EstructurasRepetitiva;

/**
 *
 * @author omarm
 */
public class EjercicioVelocidad5Reloj {

    
        
   public static void main(String[] args) throws InterruptedException{
    
        for (int i = 1; i <= 50; i++) {
            System.out.println(i);
        }
        
        
        for (int i = 50; i >= 1; i--) {
            System.out.println(i);
        }
        
        
        for (int i = 1; i <= 99; i = i +2) {
            
        }
        
        
        for (int i = 1; i <= 80; i++) {
            for (int j = 0; j < 24; j++) {
                System.out.println("*");
            }
            System.out.println("*");
        }
        
        
        for (int i = 0; i <= 24; i++) {
            
            if(i == 24){
                System.out.println("00:00:00");
                return;
            }
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    
                    System.out.println(i+ ":" + j +":" + k );
                    Thread.sleep(900);
                }
            }
        }
   }
}
                
            
  
        
