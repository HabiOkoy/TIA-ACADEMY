import java.util.Scanner;
import java.util.Arrays;
public class TugasD3W2 {
  public static void main(String[] args) {
    
    //Membuat Array
    int[] angka = new int[3];
    
    //Scanner
    Scanner in = new Scanner(System.in);
    
    //Input Angka
    for (int i = 0; i<angka.length; i++){
    System.out.print("Index[" + i + "] = ");
    angka[i] = in.nextInt();
    }
    System.out.println();
    System.out.println("Panjang Array Integer adalah " + angka.length);
    System.out.println();
    System.out.println("Array Integer " + Arrays.toString(angka));
    
  }
}
