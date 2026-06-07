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
                double tempValue = scnr.nextDouble();

                // Your integrated unit-validation block starts here
                boolean validUnit = false;
                while (!validUnit) {
                    System.out.print("Enter the unit (C or F): ");
                    String unitValue = scnr.next();

                    if (unitValue.equalsIgnoreCase("C") || unitValue.equalsIgnoreCase("F")) {
                        double result = convertTemperature(tempValue, unitValue);
                        String fromUnit = unitValue.toUpperCase();
                        String toUnit = fromUnit.equals("C") ? "F" : "C";

                        // Formats dynamically using your specified placeholder arguments
                        System.out.printf("%.2f\u00B0%s is equal to %.2f\u00B0%s%n",
                                tempValue, fromUnit, result, toUnit);

                        validUnit = true; // Breaks out of the inner unit-prompt loop
                    } else {
                        System.out.println("Error: Unrecognized unit. Please enter C or F.");
                    }
                }
                // Your integrated unit-validation block ends here

            }
            // 2. If it's not a double, check if it's the command to stop
            else if (scnr.hasNext()) {
                String textInput = scnr.next();

                if (textInput.equalsIgnoreCase("stop")) {
                    keepRunning = false; // Gracefully terminates the program
                } else {
                    System.out.println("Error: Invalid temperature input. Please enter a valid number.");
                }
            }
        }
        scnr.close();
    }
}