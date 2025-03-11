import java.time.LocalDateTime;
import java.util.*;

public class MejaServiceImpl implements InterfaceMejaService {
    private final List<Meja> daftarMeja;

    public MejaServiceImpl() {
        daftarMeja = new ArrayList<>();
        daftarMeja.add(new Meja(1, 2));
        daftarMeja.add(new Meja(2, 4));
        daftarMeja.add(new Meja(3, 6));
    }

    @Override
    public boolean checkAvailability(int jumlahOrang, LocalDateTime waktu) {
        return daftarMeja.stream()
                .anyMatch(meja -> !meja.isDipesan() && meja.getKapasitas() >= jumlahOrang);
    }

    @Override
    public Meja assignMeja(int jumlahOrang) {
        return daftarMeja.stream()
                .filter(meja -> !meja.isDipesan() && meja.getKapasitas() >= jumlahOrang)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Meja tidak ditemukan"));
    }
}