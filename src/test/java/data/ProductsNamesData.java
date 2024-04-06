package data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductsNamesData {
    public static List<String> readProductNamesFromCSV(String csvFileName) {
        List<String> productNames = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\user\\IdeaProjects\\DemoBlaze\\src\\main\\resources\\data\\" + csvFileName))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                productNames.add(nextLine[0].trim()); // Assuming only one column and it contains product names
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return productNames;
    }
}
