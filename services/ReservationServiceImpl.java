package services;
import model.Customer;
import model.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationServiceImpl implements ReservationService {
    private final Notifier notifier;

    public ReservationServiceImpl(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void createReservation(Customer customer, int guests, LocalDateTime dateTime) {
        Table table = Table.findAvailableTable(guests);
        if (table == null) {
            throw new IllegalStateException("[ERROR] No available tables.");
        }
    
        table.setReserved(true);
        String reservationDetails = "Reservation for " + customer.getName() +
                                    "\nTable No: " + table.getId() +
                                    "\nTime: " + dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    
        notifier.sendConfirmation(customer, "Reservation confirmed!\n" + reservationDetails);
    }
    
}
