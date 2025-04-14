package Nomor3;

public abstract class Template<T> {
    private T username, password, nama;

    public Template(T username, T password, T nama) {
        this.username = username;
        this.password = password;
        this.nama = nama;
    }

    public T getUsername() {
        return username;
    }

    public T getPassword() {
        return password;
    }

    public void setUsername(T username) {
        this.username = username;
    }

    public void setPassword(T password) {
        this.password = password;
    }

    public T getNama() {
        return nama;
    }

    public void setNama(T nama) {
        this.nama = nama;
    }
}
