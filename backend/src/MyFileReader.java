import java.io.*;

public class MyFileReader {
    void readFile(final File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            System.out.println(reader.readLine());
            System.out.println(Utility.calcSha256Sum(file));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("This is IO Exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
