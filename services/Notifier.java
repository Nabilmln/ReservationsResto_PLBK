package services;
import model.Customer;
public interface Notifier {
    void sendConfirmation(Customer Customer, String pesan);
}