package data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignUpData  {
    public static List<String[]> readUserDataFromCSV(String csvFileName) {
        List<String[]> userData = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\user\\IdeaProjects\\DemoBlaze\\src\\main\\resources\\data\\" + csvFileName))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                userData.add(nextLine);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return userData;
    }
}

