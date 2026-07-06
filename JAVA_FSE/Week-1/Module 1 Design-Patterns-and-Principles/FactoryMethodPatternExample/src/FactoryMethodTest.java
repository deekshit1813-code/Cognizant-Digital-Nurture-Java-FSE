package src;

/**
 * Test class demonstrating the Factory Method Pattern.
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        // Use factories to create each document type — the caller never calls 'new' directly.
        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };

        for (DocumentFactory factory : factories) {
            Document doc = factory.createDocument();
            System.out.println("--- " + doc.getClass().getSimpleName() + " ---");
            doc.open();
            doc.save();
            doc.close();
            System.out.println();
        }
    }
}
