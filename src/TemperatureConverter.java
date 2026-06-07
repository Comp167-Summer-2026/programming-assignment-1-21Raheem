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
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.print("Enter a temperature value or type 'stop' to quit: ");

            // 1. Check if the input contains a number
            if (scnr.hasNextDouble()) {
                double tempInput = scnr.nextDouble();

                System.out.print("Enter the unit (C or F): ");
                String unitInput = scnr.next();

                // Validate unit input
                if (unitInput.equalsIgnoreCase("C") || unitInput.equalsIgnoreCase("F")) {
                    double result = convertTemperature(tempInput, unitInput);

                    // Format matching expected test output
                    if (unitInput.equalsIgnoreCase("C")) {
                        System.out.printf("%.2f°C is equal to %.2f°F\n", tempInput, result);
                    } else {
                        System.out.printf("%.2f°F is equal to %.2f°C\n", tempInput, result);
                    }
                } else {
                    System.out.println("Error: Unrecognized unit label.");
                }
            }
            // 2. If it's not a double, check if it's the command to stop
            else if (scnr.hasNext()) {
                String textInput = scnr.next();

                if (textInput.equalsIgnoreCase("stop")) {
                    keepRunning = false; // Gracefully terminates the loop without a break statement
                } else {
                    System.out.println("Error: Invalid temperature input. Please enter a valid number.");
                }
            }
        }
        scnr.close();
    }
}