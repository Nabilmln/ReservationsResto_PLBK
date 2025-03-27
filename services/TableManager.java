package services;
import java.time.LocalDateTime;
import model.Table;

public interface TableManager {
    boolean checkAvailability(int jumlahOrang, LocalDateTime waktu);
    Table assignMeja(int jumlahOrang);
}