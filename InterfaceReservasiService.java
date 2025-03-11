import java.time.LocalDateTime;

public interface InterfaceReservasiService {
    Reservasi createReservation(Pelanggan pelanggan, int jumlahOrang, LocalDateTime waktu);
}