public class Kendaraan {
    String platNomor;
    String tipe;
    String merk;

   public Kendaraan(String plat, String tipe, String merk){
        platNomor = plat;
        this.tipe = tipe;
        this.merk = merk;
    }

     void tampilInformasi() {
        System.out.println("Plat Nomor  : " + platNomor);
        System.out.println("Tipe        : " + tipe);
        System.out.println("Merk        : " + merk);
        System.out.println("---------------------------");
    }
}
