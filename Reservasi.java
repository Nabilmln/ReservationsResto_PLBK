import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservasi {
    private Pelanggan pelanggan;
    private Meja meja;
    private LocalDateTime waktu;

    public Reservasi(Pelanggan pelanggan, Meja meja, LocalDateTime waktu) {
        this.pelanggan = pelanggan;
        this.meja = meja;
        this.waktu = waktu;
        meja.setDipesan(true);
    }

    @Override
    public String toString() {
        return "Reservasi untuk " + pelanggan.getNama() +
               "\nMeja No: " + meja.getId() +
               "\nWaktu: " + waktu.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}