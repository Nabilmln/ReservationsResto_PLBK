import model.Customer;
import services.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notifier notifier = new EmailNotifier();
        ReservationService reservationService = new ReservationServiceImpl(notifier);

        System.out.println("=== RESTAURANT RESERVATION SYSTEM ===");

        while (true) {
            try {
                System.out.print("\nEnter your name: ");
                String name = scanner.nextLine();
                
                System.out.print("Enter your email: ");
                String email = scanner.nextLine();
                
                System.out.print("Number of guests: ");
                int guests = Integer.parseInt(scanner.nextLine());
                
                System.out.print("Reservation time (dd-MM-yyyy HH:mm): ");
                String inputTime = scanner.nextLine();
                
                LocalDateTime dateTime = LocalDateTime.parse(inputTime, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

                Customer customer = new Customer(name, email);
                reservationService.createReservation(customer, guests, dateTime);

                
                System.out.print("Make another reservation? (y/n): ");
                if (!scanner.nextLine().equalsIgnoreCase("y")) break;
                
            } catch (DateTimeParseException e) {
                System.out.println("[ERROR] Invalid date format! Use dd-MM-yyyy HH:mm.");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Number of guests must be a number!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        scanner.close();
        System.out.println("Thank you!");
    }
}
