/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trainticketsystem;
import java.util.Scanner;
import java.util.Random;

public class TrainTicketSystem {

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         Random random = new Random();
        boolean bookingConfirmed = false;
           while(!bookingConfirmed){
               
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your departure city:");
        String departure = scanner.nextLine();
        System.out.println("Enter your destination:");
        String destination = scanner.nextLine();
        System.out.println("Enter number of tickets:");
        int numberOfTickets = scanner.nextInt();
        if (numberOfTickets <1) {
            System.out.println("Invalid number of tickets");
        }
       
        if(departure.equals(destination)) {
            System.out.println("Invalid:  Departure and destination cannot be the same");
        } else {
            System.out.println("Route is valid");
        }
        int ticketPrice = 0;
        if (departure.equals("Pretoria")&& destination.equals ("Johannesburg")) {
           ticketPrice = 50; 
        }
        if (departure.equals("Pretoria")&& destination.equals ("Cape Town")) {
           ticketPrice = 300; 
        }
        if (departure.equals("Pretoria")&& destination.equals ("Durban")) {
           ticketPrice = 250; 
        }
        if (departure.equals("Durban")&& destination.equals ("Pretoria")) {
           ticketPrice = 250; 
        }
        if (departure.equals("Durban")&& destination.equals ("Cape Town")) {
           ticketPrice = 400; 
        }
        if (departure.equals("Durban")&& destination.equals ("Polokwane")) {
           ticketPrice = 300; 
        }
        if (departure.equals("Cape Town")&& destination.equals ("East London")) {
           ticketPrice = 200; 
         
        }
        int totalPrice = ticketPrice * numberOfTickets;
           System.out.println("R"+ totalPrice);
           scanner.nextLine();
           System.out.println("Would you like to confirm payment?");
          
           String confirmation = scanner.nextLine();   
           if (confirmation.equals("yes")) {
        System.out.println("The booking is confirmed");
          int number = random.nextInt(100);
          System.out.println("TB"+number);
        bookingConfirmed = true;
           
}  else {
          System.out.println("You may re-enter your details.");
           
           }
        }
      }
}
       
