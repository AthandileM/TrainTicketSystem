 Train Ticket Booking System

 About the Project
This is a Java-based train ticket booking system that allows users to enter passenger and journey details, check supported routes, calculate ticket costs and confirm bookings. The application uses a MySQL database to retrieve route information and save booking details.

 Features
- Enter passenger details.
- Enter departure and destination cities.
- Check whether a selected route is supported.
- Validate departure dates and prevent users from selecting dates in the past.
- Calculate the total cost based on the ticket price and number of tickets.
- Confirm a booking before saving it.
- Generate a booking reference number.
- Save booking information in the MySQL database.
- Allow users to make another booking.

 Technologies Used
- Java
- MySQL
- JDBC
- NetBeans
- MySQL Workbench

 Database
The project uses a MySQL database called TrainTicketDB.

It contains two main tables:
- Routes_Table – stores the available routes and their ticket prices.
- Booking_Table – stores passenger and booking details.

The database export is included in this repository as TrainTicketDB.sql.

 Project Structure
- TrainTicketSystem.java – contains the main program and handles the booking process and database connection.
- TrainTicketDB.sql – contains the exported database.

 How to Run the Project
1. Install Java JDK and MySQL Server.
2. Import TrainTicketDB.sql into MySQL Workbench.
3. Add MySQL Connector/J to the project's libraries.
4. Set up the database connection.
5. Create a Windows environment variable called `DB_PASSWORD` and set its value to your own MySQL password.
6. Open the project in NetBeans and run `TrainTicketSystem.java`.

Purpose
I developed this project to practise and improve my Java programming and database integration skills while working on a practical problem related to train ticket booking. I wanted to create a system that could manage passenger details, check routes, calculate ticket costs and save booking information in a database. While working on the project, I gained experience using Java, MySQL, JDBC and SQL to connect an application to a database.

Note:The system asks users to confirm payment before saving a booking. It does not currently connect to an actual payment gateway.

