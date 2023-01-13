/*
* This program is to help customers estimate insurance premiums 
* that change from one year to the next over a period of 20 years 
* based on the number of accidents that the driver has caused. 
*/

import java.util.Random;      //Needed to generate random #
import java.util.Scanner;     //Needed for keyboard input
public class Insurance
{
   public static void main(String [] args)
   {     
      Random generator = new Random();
      Scanner keyboard = new Scanner(System.in);
      
      //variables
      String runProgram = " ";
      double beginningPremium = 0.0;
      double premium = 0.0;
      int years = 1;
      int accidents = 0;
      String word = "N/A";
      
      System.out.println("Welcome to [COMPANY NAME] Insurance Estimator");
      System.out.println("This program helps to estimate insurance premiums");
      System.out.println("over a period of 30 years, given the following rules:");
      System.out.printf("%-30s%30s\n","# of Accidents","Premium +/-");       //Table Chart
      System.out.printf("%-30s%30s\n%-30s%30s\n","0","-10%","1","+10%");
      System.out.printf("%-30s%30s\n%-30s%30s\n","2","+20%","3","+50%");
      System.out.printf("%-30s%30s\n","4 or more","Drop Client");
      
      System.out.println("Please enter fenderbender to start the program again or No to quit."); //runProgram
      runProgram = keyboard.nextLine();
      runProgram = runProgram.toLowerCase();
      
      while (runProgram.equals("fenderbender"))    //while outer loop
      {
         System.out.println("Please enter the insurance premium for Year 1:");
         beginningPremium = keyboard.nextDouble();
           
         System.out.printf("%-15s%-30s%-15s\n","***************","[COMPANY NAME] Insurance","***************");
         System.out.printf("%-5s%25s%15s%20s\n","Year","Beginning Premium","Accident","Premium +/-");
         premium = 0.0;
         
         for (int i = 1; i <= 30; i++)    //for inner loop
         {
            accidents = generator.nextInt(5);
            years = i;
            
            if (accidents == 0)
            {
               premium = beginningPremium * -.10;
            }
            if (accidents == 1)
            {
               premium = beginningPremium * .10;
            }
            if (accidents == 2)
            {
               premium = beginningPremium * .20;
            } 
            if (accidents == 3)
            {
               premium = beginningPremium * .50;
            }
            
            if (accidents == 4)
            {
               System.out.printf("%-5d%25.2f%15d%20s\n", i, beginningPremium, accidents, "N/A");
               System.out.println("Sorry, 4 accidents mean we drop you as a client.");
               break;      //breaks loop
            }
            
            System.out.printf("%-5d%25.2f%15d%20.2f\n", i, beginningPremium, accidents, premium);
            beginningPremium = beginningPremium + premium;
            
            if (i % 5 == 0)
            {
               premium = beginningPremium * .10;
               System.out.println("After 5 years, we increase premium by 10% after adjusting for the current year's accidents.");
            }  
         }  //end for 
         
         System.out.println("Please enter fenderbender to start the program again or No to quit."); //runProgram
         keyboard.nextLine();
         runProgram = keyboard.nextLine();
         runProgram = runProgram.toLowerCase();
                      
      }  //end while
      
      System.out.println("Thank you for driving with [COMPANY NAME] Insurance.");
      
   }  //end main
}  //end class