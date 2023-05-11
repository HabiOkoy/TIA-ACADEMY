
import java.util.*;
public class kalkulator {
    public static void main(String[] args){
        Scanner inoutUser;
        float nilai1,nilai2,jumlah;
        String operator;
        inoutUser = new Scanner(System.in);

        System.out.print("opeartor = ");
        operator = inoutUser.next();

        System.out.print("Masukan Nilai 1 = " );
        nilai1 = inoutUser.nextFloat();

        System.out.print("Masukan Nilai 2 = ");
        nilai2 = inoutUser.nextFloat();

        switch (operator){

            case "+":
                jumlah = nilai1 + nilai2;
                System.out.println("hasil = " + jumlah);
                break;

            case "-":
                jumlah = nilai1 - nilai2;
                System.out.println("hasil = " + jumlah);
                break;


            case "*":
                jumlah = nilai1 * nilai2;
                System.out.println("hasil = " + jumlah);
                break;


            case "/":
                jumlah = nilai1 / nilai2;
                System.out.println("hasil = " + jumlah);
                break;

            default:
                System.out.println("tidak di temukan");
                break;
        }
    }

}
