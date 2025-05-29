import java.util.Scanner;

public class Main {
    static AllMethod antrianKendaraan = new AllMethod();
    static QueueTransaksi riwayatTransaksi = new QueueTransaksi(100);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n-- Menu SPBU --");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahAntrian(input);
                    break;
                case 2:
                    antrianKendaraan.displayAll();
                    break;
                case 3:
                    System.out.println(">> Jumlah kendaraan dalam antrian: " + antrianKendaraan.size());
                    break;
                case 4:
                    layaniKendaraan(input);
                    break;
                case 5:
                    riwayatTransaksi.displayAll();
                    break;
                case 0:
                    System.out.println(">> Terima kasih telah menggunakan layanan kami.");
                    break;
                default:
                    System.out.println(">> Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);

        input.close();
    }

    static void tambahAntrian(Scanner input) {
        System.out.print("Masukkan Plat Nomor     : ");
        String plat = input.nextLine();
        System.out.print("Masukkan Tipe Kendaraan : ");
        String tipe = input.nextLine();
        System.out.print("Masukkan Merk Kendaraan : ");
        String merk = input.nextLine();

        Kendaraan kendaraan = new Kendaraan(plat, tipe, merk);
        antrianKendaraan.addLast(kendaraan);
        System.out.println(">> Transaksi berhasil dicatat.");
    }

    static void layaniKendaraan(Scanner input) {
        if (antrianKendaraan.isEmpty()) {
            System.out.println(">> Tidak ada kendaraan dalam antrian.");
            return;
        }

        Kendaraan kendaraan = antrianKendaraan.removeFirst();
        System.out.println("Petugas melayani " + kendaraan.platNomor);
        System.out.print("Masukkan Jenis BBM       : ");
        String namaBBM = input.nextLine();
        System.out.print("Masukkan Harga per liter : Rp ");
        double hargaPerLiter = input.nextDouble();
        System.out.print("Masukkan Jumlah liter    : ");
        double liter = input.nextDouble();

        BBM bbm = new BBM(namaBBM, hargaPerLiter);
        TransaksiPengisian transaksi = new TransaksiPengisian(kendaraan, bbm, liter);
        riwayatTransaksi.enqueue(transaksi);
        System.out.println(">> Transaksi berhasil dilayani.");
    }
}
