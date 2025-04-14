package Nomor1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);
        ArrayList<User> user = new ArrayList<>();
        ArrayList<Application> app = new ArrayList<>();

        while(true) {
            System.out.println("===Googol Play Store===");
            System.out.print("Username : ");
            String username = scan.nextLine();
            System.out.print("Password : ");
            String password = scan.nextLine();

            if (username.equals("admin") && password.equals("admin")) {
                System.out.println("Welcome Admin!");
                while (true) {
                    System.out.println("===Googol Play Store===");
                    System.out.println("======Menu Admin======");
                    System.out.println("Welcome, Admin!");
                    System.out.println("1. Register User");
                    System.out.println("2. Add Application");
                    System.out.println("3. List User");
                    System.out.println("4. List Application");
                    System.out.println("5. Exit Menu");
                    System.out.print(">> ");
                    int input = scanint.nextInt();
                    if (input == 1) {
                        //REGISTER USER
                        System.out.println("======Add User======");
                        while (true) {
                            System.out.print("Username: ");
                            username = scan.nextLine();
                            System.out.print("Password: ");
                            password = scan.nextLine();

                            boolean ada = false;
                            for (int i = 0; i < user.size(); i++) {
                                if (user.get(i).getUsername().equals(username)) {
                                    ada = true;
                                    break;
                                }
                            }
                            if (!ada) {
                                user.add(new User(username,password));
                                System.out.println("User berhasil didaftarkan!");
                                break;
                            } else {
                                System.out.println("Username is already used!");
                            }
                        }
                    } else if (input == 2) {
                        //ADD APPLICATION
                        System.out.println("======Add Application======");
                        System.out.print("App Name: ");
                        String appname = scan.nextLine();
                        System.out.print("App Maker: ");
                        String appmaker = scan.nextLine();
                        System.out.print("Price: ");
                        int price = scanint.nextInt();
                        app.add(new Application(appname,appmaker,price));
                        System.out.println(appname + " Application has successfully been added!");
                    } else if (input == 3) {
                        //LIST USER
                        System.out.println("======List User======");
                        for (int i = 0; i < user.size(); i++) {
                            System.out.println((i+1) + ". " + user.get(i).getUsername() + " - " + user.get(i).getPassword());
                        }
                    } else if (input == 4) {
                        //LIST APPLICATION
                        System.out.println("======List Application======");
                        for (int i = 0; i < app.size(); i++) {
                            System.out.println((i+1) + ". " + app.get(i).getNama() + " - " + app.get(i).getMaker());
                        }
                    } else if (input == 5) {
                        //EXIT
                        break;
                    }
                }
            } else {
                int index = -1;
                for (int i = 0; i < user.size(); i++) {
                    if (user.get(i).getUsername().equals(username)) {
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    User active = user.get(index);
                    if (active.getPassword().equals(password)) {
                        System.out.println("Welcome " + active.getUsername() + "!");
                        while (true) {
                            System.out.println("===Googol Play Store===");
                            System.out.println("======Menu User======");
                            System.out.println("Welcome, " + active.getUsername() + "!");
                            System.out.println("Saldo : " + active.getSaldo());
                            System.out.println("1. Download Applications");
                            System.out.println("2. My Applications");
                            System.out.println("3. Exit Menu");
                            System.out.print(">> ");
                            int input = scanint.nextInt();
                            if (input == 1) {
                                //DOWNLOAD APPLICATIONS
                                System.out.println("======List Application======");
                                for (int i = 0; i < app.size(); i++) {
                                    System.out.println((i+1) + ". " + app.get(i).getNama() + " - " + app.get(i).getMaker());
                                }
                                System.out.println("====Download Application====");
                                System.out.print("Pick an App : ");
                                input = scanint.nextInt();
                                if (input > 0 && input <= app.size()) {
                                    input--;
                                    Application search = app.get(input);
                                    if (active.getSaldo()-search.getHarga() >= 0) {
                                        active.setSaldo(active.getSaldo()-search.getHarga());
                                        active.addApllication(search);
                                        System.out.println("You have successfully downloaded " + search.getNama());
                                    } else {
                                        System.out.println("Saldo tidak mencukupi");
                                    }
                                } else {
                                    System.out.println("Application not found");
                                }
                            } else if (input == 2) {
                                //MY APPLICATIONS
                                active.showMyApp();
                            } else if (input == 3) {
                                //EXIT MENU
                                break;
                            }
                        }
                    } else {
                        System.out.println("User gagal login");
                    }
                } else {
                    System.out.println("User gagal login");
                }
            }
        }
    }
}
