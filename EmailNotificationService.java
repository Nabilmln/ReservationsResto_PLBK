public class EmailNotificationService implements InterfaceNotificationService {
    @Override
    public void sendConfirmation(Pelanggan pelanggan, String pesan) {
        System.out.println("\n=== NOTIFIKASI ===");
        System.out.println("Kepada: " + pelanggan.getEmail());
        System.out.println(pesan);
        System.out.println("==================\n");
    }
}