package src;

/**
 * Logger - Singleton class to ensure a single instance throughout the application.
 * Uses double-checked locking for thread safety.
 */
public class Logger {

    // Step 1: private static instance of itself
    private static volatile Logger instance;

    // Step 2: private constructor prevents external instantiation
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 3: public static method to get the singleton instance
    public static Logger getInstance() {
        if (instance == null) {                      // first check (no locking)
            synchronized (Logger.class) {
                if (instance == null) {              // second check (with locking)
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Sample logging methods
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public void warn(String message) {
        System.out.println("[WARN] " + message);
    }

    public void error(String message) {
        System.out.println("[ERROR] " + message);
    }
}
