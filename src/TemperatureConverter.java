import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
        double convertedTemp = 0.0;

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

            if (scnr.hasNextDouble()) {
                double tempInput = scnr.nextDouble();

                System.out.print("Enter the unit (C or F): ");
                String unitInput = scnr.next();

                if (unitInput.equalsIgnoreCase("C") || unitInput.equalsIgnoreCase("F")) {
                    double result = convertTemperature(tempInput, unitInput);

                    if (unitInput.equalsIgnoreCase("C")) {
                        System.out.printf("%.2f\u00B0C is equal to %.2f\u00B0F\n", tempInput, result);
                    } else {
                        System.out.printf("%.2f\u00B0F is equal to %.2f\u00B0C\n", tempInput, result);
                    }
                } else {
                    System.out.println("Error: Unrecognized unit label.");
                }
            }
            else if (scnr.hasNext()) {
                String textInput = scnr.next();

                if (textInput.equalsIgnoreCase("stop")) {
                    keepRunning = false; //
                } else {
                    System.out.println("Error: Invalid temperature input. Please enter a valid number.");
                }
            }
        }
        scnr.close();
    }
}