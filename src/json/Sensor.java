package json;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sensor {

    private JsonNode sensorId;

    @JsonProperty("timestamp")
    private JsonNode timestamp;

    @JsonProperty("temperatureC")
    private JsonNode temperatureC;

    @JsonAnySetter
    public void handleAnyField(String key, JsonNode value) {
        if (key.trim().toLowerCase().startsWith("time") || key.trim().toLowerCase().startsWith("ts")) {
            timestamp = value;
        } else if (key.trim().toLowerCase().startsWith("sensor") || key.trim().toLowerCase().startsWith("id")) {
            sensorId = value;
        } else if (key.trim().toLowerCase().startsWith("temp")) {
            temperatureC = value;
        }
    }

    public String getSensorId() {
        if (sensorId == null) return  "";
        String str = sensorId.asText();
        return str == null ? "" : str.trim().toUpperCase();
    }

    public long getTimestamp() {
        if (timestamp == null) return 0;
        String input = timestamp.asText();
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        // 1. Regex check: Must be digits only
        if (!input.matches("\\d+")) {
            return 0;
        }
        long MAX_REASONABLE_EPOCH = 4102444800000L;

        try {
            // 2. Parse check: Must fit inside a Java Long type
            long value = Long.parseLong(input);

            // 3. Scale/Range check: Epoch ms for current eras are 13 digits long.
            // A 10-digit number means it's in seconds instead of milliseconds.
            return value > 0 && value <= MAX_REASONABLE_EPOCH ? value : 0;

        } catch (NumberFormatException e) {
            return 0; // Fits outside the maximum capacity of a Long
        }
    }

    public Double getTemperatureC() {
        if (temperatureC == null) return 0.0;
        String str = temperatureC.asText();
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            double value = Double.parseDouble(matcher.group());
            System.out.println("Extracted Double: " + value); // Output: -29.4
            return value;
        }
        return 0.0;
    }
}
