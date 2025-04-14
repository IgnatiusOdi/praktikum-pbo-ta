package Nomor1;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private int saldo;
    private ArrayList<Application> myapp;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.saldo = 1000;
        myapp = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void addApllication(Application baru) {
        myapp.add(new Application(baru.getNama(),baru.getMaker(),baru.getHarga()));
    }

    public void showMyApp() {
        for (int i = 0; i < myapp.size(); i++) {
            System.out.println((i+1) + ". " + myapp.get(i).getNama() + " - " + myapp.get(i).getMaker());
        }
    }
}
