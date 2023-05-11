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
public class MethodOverloading {
    
    // Method untuk menghitung volume balok
    public static double volBalok(double p, double l, double t) {
        return p * l * t;
    }
    
    // Method untuk menghitung volume bola
    public static double volBola(double r) {
        return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
    }
    
    // Method untuk menghitung volume tabung
    public static double volTabung(double r, double t) {
        return Math.PI * Math.pow(r, 2) * t;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan = 0;
        
        while (pilihan != 4) {
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
            
            switch(pilihan) {
                case 1:
                    System.out.println("=======================================");
                    System.out.println("|         PROGRAM MENGHITUNG           |");
                    System.out.println("|            VOLUME BALOK              |");
                    System.out.println("=======================================");
                    
                    System.out.println("Volume Balok");
                    System.out.print("Panjang = ");
                    double panjang = input.nextDouble();
                    System.out.print("Lebar = ");
                    double lebar = input.nextDouble();
                    System.out.print("Tinggi = ");
                    double tinggi = input.nextDouble();
                    double volBalok = volBalok(panjang, lebar, tinggi);
                    System.out.println("Volume Balok = " + volBalok);
                    break;
                case 2:
                    System.out.println("=======================================");
                    System.out.println("|         PROGRAM MENGHITUNG           |");
                    System.out.println("|            VOLUME BOLA               |");
                    System.out.println("=======================================");
                    
                    System.out.println("Volume Bola");
                    System.out.print("Jari-jari = ");
                    double jariJariBola = input.nextDouble();
                    double volBola = volBola(jariJariBola);
                    System.out.println("Volume Bola = " + volBola);
                    break;
                case 3:
                    System.out.println("=======================================");
                    System.out.println("|         PROGRAM MENGHITUNG           |");
                    System.out.println("|            VOLUME TABUNG             |");
                    System.out.println("=======================================");
                    
                    System.out.println("Volume Tabung");
                    System.out.print("Jari-jari = ");
                    double jariJariTabung = input.nextDouble();
                    System.out.print("Tinggi = ");
                    double tinggiTabung = input.nextDouble();
                    double volTabung = volTabung(jariJariTabung, tinggiTabung);
                    System.out.println("Volume Tabung = " + volTabung);
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Input salah!");
                    break;
            }
        }
    }
}

