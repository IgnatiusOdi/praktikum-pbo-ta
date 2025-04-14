package Nomor3;

public class Mahasiswa extends Template {
    private int status; //0 Mahasiswa 1 Asisten
    public Mahasiswa(String username, String password, String nama) {
        super(username, password, nama);
        this.status = 0;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
