package com.wheaterservice.frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {

    private Scanner scanner = new Scanner(System.in);
    private final String WARNING_ONLY_LETTERS = Color.RED + ">>> Please type letter only with first being Capital! <<<" + Color.RESET;
    private final String WARNING_COORDINATE_WITHIN_RANGE = Color.RED + ">>> Please type a number from -90 to 90! <<<" + Color.RESET;

    int retrievesInteger() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.reset();
                scanner.nextLine();
                System.out.println(Color.RED + " \nPlease enter a number using only the digits 1 to 4");
            }
        }
    }

    String retrieveAndValidateCoordinates() {
        while (true) {  // Validate using regex
            float fCoordinate;
            String coordinate = scanner.next();
            if (coordinate.matches("-?[0-9]{1,2}[,.]?[0-9]{0,4}")) {
                String coordinateWithDot = coordinate.replace(',', '.');
                fCoordinate = Float.parseFloat(coordinateWithDot);
                if (fCoordinate >= -90 && fCoordinate <= 90) {
                    return coordinate;
                } else {
                    System.out.println(WARNING_COORDINATE_WITHIN_RANGE);
                }
            } else {
                System.out.println(WARNING_COORDINATE_WITHIN_RANGE);
            }
        }
    }


    String retrieveAndValidateLocation() {
        while (true) {
            String location = scanner.next();
            if (location.matches("[A-Z][a-zA-Z]+")) {
                return location;
            } else {
                System.out.println(WARNING_ONLY_LETTERS);
            }

        }
    }
}
