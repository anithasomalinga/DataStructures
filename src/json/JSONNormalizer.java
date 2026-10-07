package json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONNormalizer {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("src/json/input.json");
            List<Sensor> sensors = mapper.readValue(file, new TypeReference<>() {});
            // Convert to compact JSON string
            String jsonString = mapper.writeValueAsString(sensors);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Timestamp correctTS(String str) {
        return new Timestamp(System.currentTimeMillis());
    }
    private static Double correctTemperature(String str) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            double value = Double.parseDouble(matcher.group());
            System.out.println("Extracted Double: " + value); // Output: -29.4
            return value;
        }
        return 0.0;
    }
    private static String correctSensor(String str) {
        return str == null ? "" : str.trim().toUpperCase();
    }
}
