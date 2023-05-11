/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAY_14;

/**
 *
 * @author Xiao You
 */
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedInputAndOutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data;
        do {
        System.out.println("=======================================");
        System.out.println("|            PROGRAM JAVA             |");
        System.out.println("|          WRITER AND READER          |");
        System.out.println("=======================================");
        System.out.println("| MENU                                |");
        System.out.println("| 1. Tulis String ke File             |");
        System.out.println("| 2. Baca String dari File            |");
        System.out.println("| 3. Keluar                           |");
        System.out.println("=======================================");
        System.out.print("Pilih nomor: ");
        data = scanner.nextInt();
        scanner.nextLine(); 

            switch (data) {
                case 1:
                    System.out.println("=======================================");
                    System.out.println("|            PROGRAM JAVA             |");
                    System.out.println("|            TULIS STRING             |");
                    System.out.println("=======================================");
                    System.out.print("Masukkan nama Directory: ");
                    String namaDirectory = scanner.nextLine();
                    System.out.print("Masukkan nama File: ");
                    String namaFile = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Tempat Lahir: ");
                    String tempatLahir = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Lahir: ");
                    String tanggalLahir = scanner.nextLine();
                    String content = nama + "\n\n" + tempatLahir + "\n\n" + tanggalLahir;

                    try {
                        File directory = new File(namaDirectory);
                        if (!directory.exists()) {
                            directory.mkdirs(); 
                        }

                        File file = new File(namaDirectory + "\\" + namaFile);
                        FileWriter writer = new FileWriter(file);
                        writer.write(content);
                        writer.close();

                        System.out.println("Berhasil menulis ke file " + namaFile);
                    } catch (IOException e) {
                        System.out.println("Terjadi kesalahan saat menulis ke file " + namaFile);
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    System.out.println("=======================================");
                    System.out.println("|            PROGRAM JAVA             |");
                    System.out.println("|            BACA STRING              |");
                    System.out.println("=======================================");
                    System.out.print("Masukkan nama Directory: ");
                    namaDirectory = scanner.nextLine();
                    System.out.print("Masukkan nama File: ");
                    namaFile = scanner.nextLine();

                    try {
                        File file = new File(namaDirectory + "\\" + namaFile);
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                        fileScanner.close();
                    } catch (IOException e) {
                        System.out.println("Terjadi kesalahan saat membaca file " + namaFile);
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    System.out.println("=======================================");
                    System.out.println("|            TERIMA KASIH             |");
                    System.out.println("=======================================");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

            System.out.println();
        } while (data != 3);

        scanner.close();
    }
}
