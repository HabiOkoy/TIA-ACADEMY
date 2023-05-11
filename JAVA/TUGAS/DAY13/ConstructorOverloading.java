/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAY_12;

/**
 *
 * @author Xiao You
 */
import java.util.*;

public class ConstructorOverloading {
    Scanner sc = new Scanner(System.in);

    public ConstructorOverloading() {
        System.out.println("=======================================");
        System.out.println("|         PROGRAM MENGHITUNG           |");
        System.out.println("|         VOLUME BANGUN RUANG          |");
        System.out.println("=======================================");
        System.out.println("| MENU                                 |");
        System.out.println("| 1. Volume Balok                      |");
        System.out.println("| 2. Volume Bola                       |");
        System.out.println("| 3. Volume Tabung                     |");
        System.out.println("| 4. Keluar                            |");
        System.out.println("=======================================");
        System.out.print("Pilih nomor: ");
        int pilihan = sc.nextInt();

        switch (pilihan) {
            case 1:
                volBalok();
                break;
            case 2:
                volBola(0);
                break;
            case 3:
                volTabung(0, 0);
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    }

    public void volBalok() {
        System.out.println("=======================================");
        System.out.println("|         PROGRAM MENGHITUNG           |");
        System.out.println("|            VOLUME BALOK              |");
        System.out.println("=======================================");
                
        System.out.print("Panjang = ");
        double panjang = sc.nextDouble();
        System.out.print("Lebar = ");
        double lebar = sc.nextDouble();
        System.out.print("Tinggi = ");
        double tinggi = sc.nextDouble();
        double volumeBalok = panjang * lebar * tinggi;
        System.out.println("=======================================");
        System.out.printf("| Volume Balok = %.2f                   |\n", volumeBalok);
        System.out.println("=======================================");
                
    }

    public void volBola(int x) {
        System.out.println("=======================================");
        System.out.println("|         PROGRAM MENGHITUNG           |");
        System.out.println("|            VOLUME BOLA               |");
        System.out.println("=======================================");
        
        System.out.println("Volume Bola");
        System.out.print("Jari-jari = ");
        double r = sc.nextDouble();

        double volume = (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
        System.out.println("=======================================");
        System.out.printf("| Volume Balok = %.2f                   |\n", volume);
        System.out.println("=======================================");
    }

    public void volTabung(int x, int y) {
        System.out.println("=======================================");
        System.out.println("|         PROGRAM MENGHITUNG           |");
        System.out.println("|            VOLUME TABUNG             |");
        System.out.println("=======================================");
        
        System.out.println("Volume Tabung");
        System.out.print("Jari-jari = ");
        double r = sc.nextDouble();
        System.out.print("Tinggi = ");
        double tinggi = sc.nextDouble();

        double volume = Math.PI * Math.pow(r, 2) * tinggi;
        System.out.println("=======================================");
        System.out.printf("| Volume Balok = %.2f                   |\n", volume);
        System.out.println("=======================================");
    }

    public static void main(String[] args) {
        new ConstructorOverloading();
    }
}

