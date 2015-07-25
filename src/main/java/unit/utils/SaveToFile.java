package unit.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

public class SaveToFile {

    public static void saveToFile(){
        GregorianCalendar date = new GregorianCalendar();
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("course.txt", true));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
