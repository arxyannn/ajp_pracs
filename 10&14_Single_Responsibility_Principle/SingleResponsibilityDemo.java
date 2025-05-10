// File: SingleResponsibilityDemo.java

// Class responsible for handling user input
class UserInputHandler {
    public String getUserInput() {
        // Simulating user input
        return "Hello, World!";
    }

    public boolean validateInput(String input) {
        // Simple validation: check if input is not empty
        return input != null && !input.trim().isEmpty();
    }
}

// Class responsible for processing the input data
class DataProcessor {
    public String processData(String input) {
        // Process data: convert input to uppercase
        return input.toUpperCase();
    }
}

// Main class to demonstrate SRP
public class SingleResponsibilityDemo {
    public static void main(String[] args) {
        UserInputHandler userInputHandler = new UserInputHandler();
        DataProcessor dataProcessor = new DataProcessor();

        // Get and validate user input
        String userInput = userInputHandler.getUserInput();
        if (userInputHandler.validateInput(userInput)) {
            // Process and display the result
            String processedData = dataProcessor.processData(userInput);
            System.out.println("Processed Data: " + processedData);
        } else {
            System.out.println("Invalid input.");
        }
    }
}
