import java.util.Scanner;

// Superclass: Barang
// Kelas ini berfungsi untuk menyimpan informasi tentang barang yang dijual
class Barang {
    private String kodeBarang;   // Kode barang
    private String namaBarang;   // Nama barang
    private double hargaBarang;  // Harga barang

    // Constructor untuk menginisialisasi objek Barang
    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    // Getter untuk kode barang
    public String getKodeBarang() {
        return kodeBarang;
    }

    // Getter untuk nama barang
    public String getNamaBarang() {
        return namaBarang;
    }

    // Getter untuk harga barang
    public double getHargaBarang() {
        return hargaBarang;
    }
}

// Subclass: Transaksi (Inheritance)
// Kelas ini mewarisi sifat dari Barang dan menambah fitur transaksi
class Transaksi extends Barang {
    private int jumlahBeli;  // Jumlah barang yang dibeli

    // Constructor untuk menginisialisasi objek Transaksi
    public Transaksi(String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang);  // Memanggil constructor kelas Barang
        this.jumlahBeli = jumlahBeli;
    }

    // Metode untuk menghitung total harga transaksi
    public double hitungTotal() {
        return getHargaBarang() * jumlahBeli;  // Menggunakan metode getHargaBarang dari superclass
    }
}

// Kelas utama untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Meminta input dari pengguna
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = Double.parseDouble(scanner.nextLine());  // Mengkonversi input menjadi double

            // Validasi harga barang harus lebih dari 0
            if (hargaBarang <= 0) {
                throw new IllegalArgumentException("Harga barang harus lebih dari 0!");
            }

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = Integer.parseInt(scanner.nextLine());  // Mengkonversi input menjadi integer

            // Validasi jumlah beli harus lebih dari 0
            if (jumlahBeli <= 0) {
                throw new IllegalArgumentException("Jumlah beli harus lebih dari 0!");
            }

            // Membuat objek Transaksi
            Transaksi transaksi = new Transaksi(kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Menampilkan hasil transaksi
            System.out.println("\n--- Detail Transaksi ---");
            System.out.println("No Faktur: " + noFaktur);
            System.out.println("Kode Barang: " + transaksi.getKodeBarang());
            System.out.println("Nama Barang: " + transaksi.getNamaBarang());
            System.out.println("Harga Barang: Rp" + transaksi.getHargaBarang());
            System.out.println("Jumlah Beli: " + jumlahBeli);
            System.out.println("Total: Rp" + transaksi.hitungTotal());

        } catch (NumberFormatException e) {
            // Menangani kesalahan jika input harga atau jumlah beli bukan angka
            System.out.println("Error: Input harus berupa angka untuk harga barang atau jumlah beli!");

        } catch (IllegalArgumentException e) {
            // Menangani kesalahan jika harga atau jumlah beli tidak valid
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            // Menangani kesalahan yang tidak terduga
            System.out.println("Error: Terjadi kesalahan yang tidak diketahui.");

        } finally {
            // Menutup scanner untuk menghindari kebocoran sumber daya
            scanner.close();
        }
    }
}
