/*
 * CSC 1350 Programming project No 6
   @author: Mimi Baral
 * @since 10/25/2021
 */
package prog06_partypooper;

/**
 *
 * @author mimic
 */
import java.util.Scanner;
public class Prog06_PartyPooper {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args){
    Scanner in = new Scanner(System.in); 
     System.out.println("Enter the number of weeks you are going to save money: "); 		
     int weeks = in.nextInt();  
     boolean done = false; 		
     int count = 0; 		
     double sum = 0; 		
     double savings; 
     while(!done && count < weeks) { 
         System.out.println("Enter the savings for week " + (count + 1) +" (Q to exit): "); 
         if(!in.hasNextDouble()) { 					
             done = true; }
         else {
             savings = in.nextDouble();
             sum += savings;
	     count++; }
     }
     if(count > 0) {
         System.out.printf("The total savings is $%.2f", sum);
		}
     else {
			System.out.println("No data");
		}



         } 
     }
    
    
    
    
    
}   
}