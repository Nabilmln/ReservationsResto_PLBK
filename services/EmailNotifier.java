package services;

import model.Customer;

public class EmailNotifier implements Notifier {
    @Override
    public void sendConfirmation(Customer customer, String message) {
        System.out.println("\n=== NOTIFICATION ===");
        System.out.println("To: " + customer.getEmail());
        System.out.println(message);
        System.out.println("====================\n");
    }
}
