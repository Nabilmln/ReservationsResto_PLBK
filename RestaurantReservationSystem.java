import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class RestaurantReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InterfaceMejaService mejaService = new MejaServiceImpl();
        InterfaceNotificationService notifService = new EmailNotificationService();
        InterfaceReservasiService reservasiService = new ReservasiServiceImpl(mejaService, notifService);

        System.out.println("=== SISTEM RESERVASI RESTORAN ===");

        while(true) {
            try {
                System.out.print("\nMasukkan nama: ");
                String nama = scanner.nextLine();
                
                System.out.print("Masukkan email: ");
                String email = scanner.nextLine();
                
                System.out.print("Jumlah orang: ");
                int jumlahOrang = Integer.parseInt(scanner.nextLine());
                
                System.out.print("Waktu reservasi (dd-MM-yyyy HH:mm): ");
                String waktuInput = scanner.nextLine();
                
                LocalDateTime waktu = LocalDateTime.parse(waktuInput, 
                    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

                Pelanggan pelanggan = new Pelanggan(nama, email);
                reservasiService.createReservation(pelanggan, jumlahOrang, waktu);
                
                System.out.print("Lanjutkan reservasi? (y/n): ");
                if(!scanner.nextLine().equalsIgnoreCase("y")) break;
                
            } catch (DateTimeParseException e) {
                System.out.println("[ERROR] Format tanggal salah! Gunakan dd-MM-yyyy HH:mm");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Jumlah orang harus angka!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        scanner.close();
        System.out.println("Terima kasih!");
    }
}