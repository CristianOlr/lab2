package BNM;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class ReadCsvFile {
    private static final String SAMPLE_CSV_FILE_PATH = "datesList.csv";

    public static List<String> parserCSV() throws IOException {
        List<String> arrayarstring = new ArrayList<>();
        try (Reader reader = new BufferedReader(new FileReader(SAMPLE_CSV_FILE_PATH))) {
            try (CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
                for (CSVRecord csvRecord : csvParser) {

                    String dates = csvRecord.get(0);
                    arrayarstring.add(dates);

                    System.out.println("Nr: " + csvRecord.getRecordNumber());
                    System.out.println("Date: " + dates);
                }
            }
        }

        System.out.println("\nSelected dates are:");
        for (String ar : arrayarstring) {
            System.out.println(ar);
        }
        return arrayarstring;
    }
}
