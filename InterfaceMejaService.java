import java.time.LocalDateTime;

public interface InterfaceMejaService {
    boolean checkAvailability(int jumlahOrang, LocalDateTime waktu);
    Meja assignMeja(int jumlahOrang);
}