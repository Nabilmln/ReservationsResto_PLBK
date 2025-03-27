package services;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Customer;
import model.Table;

public class Reservation {
    private Customer customer;
    private Table table;
    private LocalDateTime dateTime;

    public Reservation(Customer customer, Table table, LocalDateTime dateTime) {
        this.customer = customer;
        this.table = table;
        this.dateTime = dateTime;
        table.setReserved(true);
    }

    @Override
    public String toString() {
        return "Reservasi untuk " + customer.getName() +
               "\nMeja No: " + table.getId() +
               "\nWaktu: " + dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}