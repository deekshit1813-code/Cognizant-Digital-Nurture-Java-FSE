package src;

/**
 * Test class to verify that only one instance of Logger is created.
 */
public class SingletonTest {

    public static void main(String[] args) {
        // Obtain two references to the Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Singleton works: both references point to the same Logger instance.");
        } else {
            System.out.println("Singleton FAILED: different instances were created.");
        }

        // Use the logger
        logger1.log("Application started.");
        logger2.warn("Low memory warning.");
        logger1.error("Null pointer encountered.");

        // Confirm same hash code
        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());
    }
}
