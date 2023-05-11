//Import class yang dibutuhkan
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
public class penjualanBarang {
    public static void main(String args[])
    {
        //Inisialisasi objek untuk masing-masing kelas
         Scanner input = new Scanner(System.in);
         DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
         DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
         //Deklarasi variabel
         int jum=0, i=0;
         double total_bayar=0;
         //Deklarasi array
         int [] kode = new int[5];
         int [] qty = new int[5];
         int [] harga = new int[5];
         double [] sub_total = new double[5];
         double [] diskon= new double [5];
         String [] barang = new String[5];
         
         System.out.println("Selamat Datang Masukan Barang Yang Akan Di Jual");
         
         System.out.print("Masukan Jumlah Barang Yang Ingin di Jual : ");
         jum=input.nextInt();
         System.out.println(" ");
         //Memasukan elemen didalam array
         for (i=0; i<jum;i++){
              System.out.print("Masukan Kode Barang Ke-"+(i+1)+" : ");
              kode[i]=input.nextInt();
              System.out.print("Masukan qty Barang Ke-"+(i+1)+" : ");
              qty[i]=input.nextInt();
              //Menentukan barang berdasarkan kode yang dimmasukan
              switch (kode[i]){
                  case 1 : 
                            barang[i]="Apel     ";
                            harga[i]=1000;
                            diskon[i]=0;
                            break;
                  case 2 : 
                            barang[i]="Minyak   ";
                            harga[i]=4000;
                            diskon[i]=0;
                            break;
                  case 3 : 
                            barang[i]="Kopi     ";
                            harga[i]=1000;
                            diskon[i]=0;
                            break;
                  case 4 : 
                            barang[i]="Susu     ";
                            harga[i]=1000;
                            diskon[i]=0;
                            break;
                  case 5 : 
                            barang[i]="Telur    ";
                            harga[i]=2000;
                            diskon[i]=0;
                            break;
                  default : 
                            System.out.println("Kode Barang Tidak Tersedia");
              }
         }
          //Pengaturan format number
          formatRp.setCurrencySymbol("Rp. ");
          formatRp.setMonetaryDecimalSeparator(',');
          formatRp.setGroupingSeparator('.');
          kursIndonesia.setDecimalFormatSymbols(formatRp);
          
          System.out.println(" ");
          System.out.println("No   Nama Barang             Harga           QTY  Diskon   Sub Total");  
          //Menampilkan seluruh elemen di dalam array
          for (i=0; i<jum;i++){ 
             sub_total[i]=((qty[i]*harga[i])-(qty[i]*harga[i]*diskon[i]));
             total_bayar+=sub_total[i];
              System.out.println(i+1+"    "+barang[i]+"   "+kursIndonesia.format(harga[i])+"    "+qty[i]+"     "+(int)(diskon[i]*100)+"%"+"     "+kursIndonesia.format(sub_total[i])); 
          }
          System.out.println(" ");
          //Menampilkan total bayar
          System.out.println("Total Bayar : "+kursIndonesia.format(total_bayar));
    }
}