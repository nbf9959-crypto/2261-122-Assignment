import java.io.File;
import java.util.Scanner;


public class JavaFiles {
    public static void main(String[] args) {
        String path = "resources/grades_010.csv";
        File file = new File(path); 

        System.out.println(file.exists());
    }

    public static void readInFileWithScanner(String path) {
        File file = new File(path); 

        try {
            Scanner scanner = new Scanner(file); 

            while(scanner.hasNext()) {
                String.out.println
            }
             
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
