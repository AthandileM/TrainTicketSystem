/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trainticketsystem;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TrainTicketSystem {

        public static void main(String[] args) {
               String url ="jdbc:mysql://localhost:3306/TrainTicketDB";
               String username ="root";
               String password = System.getenv("DB_PASSWORD");
               String sql = "Select * from Routes_Table Where departure_city =?  and destination_city = ?";
               String insertSql = "INSERT INTO Booking_Table (booking_reference, passenger_name, route_id, ticket_price_at_booking, number_of_tickets, total_price, departure_date, booking_status) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
               try(Connection connection = DriverManager.getConnection(url,username,password)){
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
        boolean dateConfirmed = false;
        LocalDate travelDate = null;
        while (!dateConfirmed) {
         System.out.println("Enter your departure date (YYYY-MM-DD):");
         String departureDate = scanner.nextLine();
         try {
         travelDate = LocalDate.parse(departureDate);
         if (travelDate.isBefore(LocalDate.now())) {
         System.out.println("Departure date cannot be in the past.");
         continue;
           } dateConfirmed = true;
         } catch (DateTimeParseException e) {
    System.out.println("Invalid date. Please try again.");
       }
     }
        if (departure.equalsIgnoreCase(destination)) {
                    System.out.println("Invalid: Departure and destination cannot be the same.");
                    continue;
           }
              try(PreparedStatement pstmt = connection.prepareStatement(sql)){
                pstmt.setString(1,departure);
                pstmt.setString(2,destination);
                 try(  ResultSet rs = pstmt.executeQuery()){
                  if (rs.next()) {
    int routeId = rs.getInt("route_id");
    BigDecimal ticketPrice = rs.getBigDecimal("ticket_price");
        System.out.println("Route found!");
        System.out.println("Route ID: " + routeId);
        System.out.println("Ticket price: R" + ticketPrice);
                  
   
        System.out.println("Enter number of tickets:");
        
        int numberOfTickets = scanner.nextInt();
        scanner.nextLine();
        if (numberOfTickets <1) {
            System.out.println("Invalid number of tickets");
             continue;
        }
                  
          System.out.println("Route is valid");
          BigDecimal totalPrice = ticketPrice.multiply(
          BigDecimal.valueOf(numberOfTickets)
      );
          System.out.println("Total price: R" + totalPrice);
           System.out.println("Would you like to confirm payment?");
           String confirmation = scanner.nextLine();   
           if (confirmation.equals("yes")) {
           try (PreparedStatement insertPstmt = connection.prepareStatement(insertSql)) { 
          int number = random.nextInt(100);
         String bookingReference = "TB" + number;
         insertPstmt.setString(1, bookingReference);
         insertPstmt.setString(2, name);
         insertPstmt.setInt(3, routeId);
         insertPstmt.setBigDecimal(4, ticketPrice);
         insertPstmt.setInt(5, numberOfTickets);
         insertPstmt.setBigDecimal(6, totalPrice);
         insertPstmt.setDate(7, java.sql.Date.valueOf(travelDate));
         insertPstmt.setString(8, "Confirmed");
         int rowsUpdated = insertPstmt.executeUpdate();
         if (rowsUpdated == 1){
          System.out.println("The booking is confirmed");   
         System.out.println("Booking reference: " + bookingReference);
        bookingConfirmed = true;
         }
     }    
}  else {
          System.out.println("You may re-enter your details.");
           }
               
       }else { System.out.println("Route not found. Please try again");
       
            }
          }
        }
     }
   }catch(SQLException e){
        System.out.println("Database error"+ e.getMessage());
      }                   
   }
}   

        


       
