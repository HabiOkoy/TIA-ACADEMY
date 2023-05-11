import java.io.FileReader;

public class FileReaderExample {
    public static void main(String args[])throws Exception{
        FileReader reader=new FileReader("E:\\tia\\testprintout.txt");
        int i;

        while((i=reader.read())!=-1)
        System.out.print((char)i);

        reader.close();
        }
}