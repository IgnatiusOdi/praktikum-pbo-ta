package Nomor3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);
        ArrayList<Mahasiswa> mhs = new ArrayList<>();
        ArrayList<Dosen> dsn = new ArrayList<>();
        ArrayList<Modul> listmodul = new ArrayList<>();

        while (true) {
            System.out.println("=====Login E-Class=====");
            System.out.print("Username : ");
            String username = scan.nextLine();
            System.out.print("Password : ");
            String password = scan.nextLine();

            if (username.equals("admin") && password.equals("admin")) {
                while (true) {
                    System.out.println("≡≡≡Admin E-Class≡≡≡");
                    System.out.println("1. Add Mahasiswa");
                    System.out.println("2. Add Asisten");
                    System.out.println("3. Add Dosen");
                    System.out.println("4. List Semua Mahasiswa");
                    System.out.println("5. List Semua Dosen");
                    System.out.println("0. Exit");
                    System.out.print(">> ");
                    int input = scanint.nextInt();
                    if (input == 1) {
                        //ADD MAHASISWA
                        System.out.println("≡≡≡Add Mahasiswa≡≡≡");
                        System.out.print("Masukkan NRP : ");
                        String nrp = scan.nextLine();
                        System.out.print("Masukkan Nama : ");
                        String nama = scan.nextLine();

                        boolean ada = false;
                        for (int i = 0; i < mhs.size(); i++) {
                            if (mhs.get(i).getUsername().equals(nrp)) {
                                ada = true;
                                break;
                            }
                        }
                        if (!ada) {
                            char[] temp = nrp.toCharArray();
                            password = "";
                            for (int i = temp.length; i >= 0; i--) {
                                password += temp[i];
                            }
                            mhs.add(new Mahasiswa(username,password,nama));
                            System.out.println("Berhasil Tambah Mahasiswa");
                        } else {
                            System.out.println("Gagal Tambah Mahasiswa");
                        }
                    } else if (input == 2) {
                        //ADD ASISTEN
                        System.out.println("≡≡≡Add Asisten≡≡≡");
                        ArrayList<Mahasiswa> counter = new ArrayList<>();
                        System.out.print("Search Nama Mahasiswa : ");
                        String search = scan.nextLine();
                        for (int i = 0; i < mhs.size(); i++) {
                            String nama = mhs.get(i).getNama().toString();
                            if (nama.contains(search)) {
                                counter.add(mhs.get(i));
                            }
                        }
                        for (int i = 0; i < counter.size(); i++) {
                            System.out.println((i+1) + ". " + counter.get(i).getUsername() + " - " + counter.get(i).getNama());
                        }
                        System.out.print(">> ");
                        input = scanint.nextInt();
                        if (input > 0 && input <= counter.size()) {
                            input--;
                            Mahasiswa temp = counter.get(input);
                            if (temp.getStatus() == 0) {
                                temp.setStatus(1);
                            } else {
                                System.out.println("Error, sudah terdaftar");
                            }
                        } else {
                            System.out.println("Error input!");
                        }
                    } else if (input == 3) {
                        //ADD DOSEN
                        System.out.println("≡≡≡Add Dosen≡≡≡");
                        System.out.print("Username : ");
                        username = scan.nextLine();
                        System.out.print("Nama : ");
                        String nama = scan.nextLine();

                        boolean ada = false;
                        for (int i = 0; i < dsn.size(); i++) {
                            if (dsn.get(i).getUsername().equals(username)) {
                                ada = true;
                                break;
                            }
                        }
                        if (!ada) {
                            dsn.add(new Dosen(username,username,nama));
                            System.out.println("Berhasil Menambah Dosen!");
                        } else {
                            System.out.println("Username sudah terdaftar");
                        }
                    } else if (input == 4) {
                        //LIST MAHASISWA
                        System.out.println("≡≡≡List Mahasiswa≡≡≡");
                        for (int i = 0; i < mhs.size(); i++) {
                            System.out.println((i+1) + ". " + mhs.get(i).getUsername() + " - " + mhs.get(i).getNama());
                        }
                    } else if (input == 5) {
                        //LIST DOSEN
                        System.out.println("≡≡≡List Dosen≡≡≡");
                        for (int i = 0; i < dsn.size(); i++) {
                            System.out.println((i+1) + ". " + dsn.get(i).getUsername() + " - " + dsn.get(i).getNama());
                        }
                    } else if (input == 0) {
                        //EXIT
                        break;
                    }
                }
            } else {
                boolean mahasiswa = false;
                boolean dosen = false;
                int index = -1;
                for (int i = 0; i < mhs.size(); i++) {
                    if (mhs.get(i).getUsername().equals(mahasiswa)) {
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    //MAHASISWA
                    Mahasiswa active = mhs.get(index);
                    if (active.getPassword().equals(password)) {
                        if (active.getStatus() == 0) {
                            while (true) {
                                System.out.println("≡≡≡Menu Mahasiswa≡≡≡");
                                System.out.println("Halo " + active.getNama() + "!");
                                System.out.println("1. Upload Jawaban Soal");
                                System.out.println("0. Exit");
                                System.out.print(">> ");
                                int input = scanint.nextInt();
                                if (input == 1) {
                                    System.out.println("≡≡≡List Modul≡≡≡");
                                    for (int i = 0; i < listmodul.size(); i++) {
                                        System.out.println((i+1) + ". " + listmodul.get(i).getNamamodul());
                                    }
                                    System.out.print(">> ");
                                    input = scanint.nextInt();
                                    if (input > 0 && input <= listmodul.size()) {
                                        input--;
                                        Modul sekarang = listmodul.get(input);
                                        System.out.print("Nama Jawaban Soal : ");
                                        String namajawaban = scan.nextLine();
                                        sekarang.addQueue(namajawaban,active.getNama().toString());
                                        System.out.println("Berhasil upload jawaban soal!");
                                    } else {
                                        System.out.println("Modul tidak ditemukan");
                                    }
                                } else if (input == 0) {
                                    //EXIT
                                    break;
                                }
                            }
                        } else {
                            while (true) {
                                System.out.println("≡≡≡Menu Mahasiswa≡≡≡");
                                System.out.println("Halo " + active.getNama() + "!");
                                System.out.println("1. Upload Jawaban Soal");
                                System.out.println("2. Input Nilai");
                                System.out.println("0. Exit");
                                System.out.print(">> ");
                                int input = scanint.nextInt();
                                if (input == 1) {
                                    System.out.println("≡≡≡List Modul≡≡≡");
                                    for (int i = 0; i < listmodul.size(); i++) {
                                        System.out.println((i+1) + ". " + listmodul.get(i).getNamamodul());
                                    }
                                    System.out.print(">> ");
                                    input = scanint.nextInt();
                                    if (input > 0 && input <= listmodul.size()) {
                                        input--;
                                        Modul sekarang = listmodul.get(input);
                                        System.out.print("Nama Jawaban Soal : ");
                                        String namajawaban = scan.nextLine();
                                        sekarang.addQueue(namajawaban,active.getNama().toString());
                                        System.out.println("Berhasil upload jawaban soal!");
                                    } else {
                                        System.out.println("Modul tidak ditemukan");
                                    }
                                } else if (input == 2) {
                                    //INPUT NILAI
                                    System.out.println("≡≡≡List Modul≡≡≡");
                                    for (int i = 0; i < listmodul.size(); i++) {
                                        System.out.println((i+1) + ". " + listmodul.get(i).getNamamodul());
                                    }
                                    System.out.print(">> ");
                                    input = scanint.nextInt();
                                    if (input > 0 && input <= listmodul.size()) {
                                        System.out.println("≡≡≡Input Nilai≡≡≡");
                                        Modul sekarang = listmodul.get(0);
                                        sekarang.getQueue();
                                        int nilai = scanint.nextInt();
                                        sekarang.removeTopQueue(nilai,active.getNama().toString());
                                    } else {
                                        System.out.println("Modul tidak ditemukan");
                                    }
                                } else if (input == 0) {
                                    //EXIT
                                    break;
                                }
                            }
                        }
                    } else{
                        System.out.println("Gagal login");
                    }
                } else {
                    for (int i = 0; i < dsn.size(); i++) {
                        if (dsn.get(i).getUsername().equals(username)) {
                            index = i;
                            break;
                        }
                    }
                    if (index != -1) {
                        Dosen active = dsn.get(index);
                        if (active.getPassword().equals(password)) {
                            while (true) {
                                System.out.println("≡≡≡Menu Dosen≡≡≡");
                                System.out.println("1. Buat Modul");
                                System.out.println("2. Input Nilai");
                                System.out.println("3. List Semua Jawaban");
                                System.out.println("0. Exit");
                                System.out.print(">> ");
                                int input = scanint.nextInt();
                                if (input == 1) {
                                    System.out.println("≡≡≡Buat Modul≡≡≡");
                                    System.out.print("Masukkan nama modul : ");
                                    String namamodul = scan.nextLine();
                                    System.out.print("Jenis : ");
                                    String jenis = scan.nextLine();
                                    listmodul.add(new Modul(namamodul,jenis));
                                    System.out.println("Berhasil tambah modul!");
                                } else if (input == 2) {
                                    for (int i = 0; i < listmodul.size(); i++) {
                                        System.out.println((i+1) + ". " + listmodul.get(i).getNamamodul());

                                    }
                                } else if (input == 3) {

                                } else if (input == 0) {
                                    //EXIT
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Gagal login");
                        }
                    } else {
                        System.out.println("Gagal login");
                    }
                }
            }
        }
    }
}
