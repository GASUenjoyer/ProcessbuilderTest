package SysInfo;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchInFile {
    public static void main(String absolutePath, String pattern, String tempFileLog) {

        boolean contains = false;
        try (FileInputStream fin = new FileInputStream(absolutePath)) {
            String result = "";
            int i = -1;
            while ((i = fin.read()) != -1) {
                result = result + (char) i;
            }
            contains = result.contains(pattern);
            if (contains == true) {
                try (FileWriter writer = new FileWriter(tempFileLog, true)) {
                    String text = "File on \"" + absolutePath + "\" contain pattern \"" + pattern + "\"\n";
                    writer.write(text);
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                try (FileWriter writer = new FileWriter(tempFileLog, true)) {
                    String text = "File on \"" + absolutePath + "\" not contain pattern \"" + pattern + "\"\n";
                    writer.write(text);
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
