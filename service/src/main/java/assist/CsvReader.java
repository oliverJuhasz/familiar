package assist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CsvReader {

    private String separator = ","; //TODO - as Bean
    private String line;

    public List<String[]> getData(String resourceName) throws IOException {
        List<String[]> result = new ArrayList<>();
        File file = new File(
                Objects.requireNonNull(getClass().getClassLoader().getResource(resourceName)).getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {
            String[] scores = line.split(separator);
            result.add(scores);
        }
        return result;
    }

}
