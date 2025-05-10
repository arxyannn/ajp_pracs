// Implement Singleton Design Pattern
// Write a Java class that ensures only one instance is created. Show how to access this instance from multiple points.


public class LoggerExample {

    // Singleton Logger class
    static class Logger {
        private static Logger instance;

        // Private constructor
        private Logger() {}

        // Method to get the single instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Logging method
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    // Main method to access logger from multiple points
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is from logger1");
        logger2.log("This is from logger2");

        // Check if both are the same instance
        System.out.println("Are both logger instances the same? " + (logger1 == logger2));
    }
}