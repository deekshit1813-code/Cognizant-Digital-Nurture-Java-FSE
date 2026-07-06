package src;

/**
 * DocumentFactory - abstract factory with the factory method createDocument().
 */
public abstract class DocumentFactory {

    // Factory method - subclasses decide which Document to instantiate
    public abstract Document createDocument();

    // Template method that uses the factory method
    public void openDocument() {
        Document doc = createDocument();
        doc.open();
    }
}
