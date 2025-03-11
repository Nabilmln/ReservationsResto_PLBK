import java.time.LocalDateTime;

public class ReservasiServiceImpl implements InterfaceReservasiService {
    private final InterfaceMejaService mejaService;
    private final InterfaceNotificationService notifService;

    public ReservasiServiceImpl(InterfaceMejaService mejaService, InterfaceNotificationService notifService) {
        this.mejaService = mejaService;
        this.notifService = notifService;
    }

    @Override
    public Reservasi createReservation(Pelanggan pelanggan, int jumlahOrang, LocalDateTime waktu) {
        if (!mejaService.checkAvailability(jumlahOrang, waktu)) {
            throw new IllegalStateException("[ERROR] Meja tidak tersedia");
        }

        Meja meja = mejaService.assignMeja(jumlahOrang);
        Reservasi reservasi = new Reservasi(pelanggan, meja, waktu);
        
        notifService.sendConfirmation(pelanggan, 
            "Reservasi berhasil!\n" + reservasi.toString());
        return reservasi;
    }
}