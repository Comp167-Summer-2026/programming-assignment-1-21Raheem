import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
        double convertedTemp = 0.0;

        // Case-insensitive check for unit types
        if (unit.equalsIgnoreCase("C")) {
            convertedTemp = (temperature * 9.0 / 5.0) + 32.0;
        } else if (unit.equalsIgnoreCase("F")) {
            convertedTemp = (temperature - 32.0) * 5.0 / 9.0;
        }

        return convertedTemp;
    } // <--- This closes convertTemperature

    // 1. Re-add the red main method block header here:
    public static void main(String[] args) {

        // 2. Your main program logic (Scanner loop, look-ahead checks) goes here

    } // <--- 3. Re-add the red main method closing brace here

} // <--- 4. Re-add the red class closing brace here