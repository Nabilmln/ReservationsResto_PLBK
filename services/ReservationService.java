package services;
import java.time.LocalDateTime;
import model.Customer;

public interface ReservationService {
    void createReservation(Customer customer, int guests, LocalDateTime dateTime);
}