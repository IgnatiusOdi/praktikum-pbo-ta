package Nomor3;

import java.util.ArrayList;

public class Modul {
    private String namamodul;
    private String jenis;
    private ArrayList<Jawaban> jawaban = new ArrayList<Jawaban>();
    private ArrayList<Jawaban> queue = new ArrayList<>();

    public Modul(String namamodul, String jenis) {
        this.namamodul = namamodul;
        this.jenis = jenis;
    }

    public String getNamamodul() {
        return namamodul;
    }

    public void setNamamodul(String namamodul) {
        this.namamodul = namamodul;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void addQueue(String namajawaban, String pengirim) {
        queue.add(new Jawaban(namajawaban, pengirim));
    }

    public void getQueue() {
        System.out.println(namamodul + " - " + jawaban.get(0).getNamajawaban());
        System.out.println(jawaban.get(0).getPengirim());
        System.out.println(jenis);
        System.out.print("Masukkan nilai : ");
    }
    public void removeTopQueue(int nilai, String pemeriksa) {
        queue.get(0).setNilai(nilai);
        queue.get(0).setPemeriksa(pemeriksa);
        queue.get(0).setStatus(1);
        jawaban.add(queue.get(0));
        queue.remove(0);
    }
}
