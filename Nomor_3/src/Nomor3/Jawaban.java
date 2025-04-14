package Nomor3;

public class Jawaban {
    private String namajawaban, pengirim, pemeriksa;
    private int nilai, status;

    public Jawaban(String namajawaban, String pengirim) {
        this.namajawaban = namajawaban;
        this.pengirim = pengirim;
    }

    public String getNamajawaban() {
        return namajawaban;
    }

    public void setNamajawaban(String namajawaban) {
        this.namajawaban = namajawaban;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getPemeriksa() {
        return pemeriksa;
    }

    public void setPemeriksa(String pemeriksa) {
        this.pemeriksa = pemeriksa;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
