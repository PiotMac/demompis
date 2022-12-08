import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DataTransfer toFile = new DataTransfer();
        toFile.activate();
        System.out.println("Działa");
    }
}