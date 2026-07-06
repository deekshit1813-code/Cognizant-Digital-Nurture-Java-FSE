package src;

/**
 * Concrete document: Excel (.xlsx)
 */
public class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Excel document (.xlsx)");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document (.xlsx)");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document (.xlsx)");
    }
}
