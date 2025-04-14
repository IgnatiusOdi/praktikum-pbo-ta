package Nomor1;

public class Application {
    private String nama;
    private String maker;
    private int harga;

    public Application(String nama, String maker, int harga) {
        this.nama = nama;
        this.maker = maker;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
