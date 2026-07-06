package src;

/**
 * SearchTest - demonstrates Linear and Binary Search on a product catalogue.
 *
 * Comparison:
 *  - Linear Search : O(n) — no pre-requisite; works on unsorted data.
 *  - Binary Search : O(log n) — requires sorted data; much faster for large catalogues.
 *
 * For an e-commerce platform with millions of products, Binary Search (or a
 * hash-based approach) is strongly preferred over Linear Search.
 */
public class SearchTest {

    public static void main(String[] args) {

        // Unsorted array for linear search
        Product[] unsortedCatalogue = {
            new Product(305, "Smart Watch",      "Electronics"),
            new Product(102, "Running Shoes",    "Sports"),
            new Product(478, "Coffee Maker",     "Kitchen"),
            new Product(211, "Yoga Mat",         "Sports"),
            new Product(050, "Bluetooth Speaker","Electronics"),
            new Product(399, "Desk Lamp",        "Home"),
        };

        // Sorted array (by productId) for binary search
        Product[] sortedCatalogue = {
            new Product(050, "Bluetooth Speaker","Electronics"),
            new Product(102, "Running Shoes",    "Sports"),
            new Product(211, "Yoga Mat",         "Sports"),
            new Product(305, "Smart Watch",      "Electronics"),
            new Product(399, "Desk Lamp",        "Home"),
            new Product(478, "Coffee Maker",     "Kitchen"),
        };

        // --- Linear Search ---
        System.out.println("=== Linear Search ===");
        int linearTarget = 211;
        Product found = SearchAlgorithms.linearSearch(unsortedCatalogue, linearTarget);
        System.out.println("Searching for id=" + linearTarget + " -> "
                + (found != null ? found : "Not found"));

        int missingId = 999;
        found = SearchAlgorithms.linearSearch(unsortedCatalogue, missingId);
        System.out.println("Searching for id=" + missingId + " -> "
                + (found != null ? found : "Not found"));

        // --- Binary Search ---
        System.out.println("\n=== Binary Search ===");
        int binaryTarget = 399;
        found = SearchAlgorithms.binarySearch(sortedCatalogue, binaryTarget);
        System.out.println("Searching for id=" + binaryTarget + " -> "
                + (found != null ? found : "Not found"));

        found = SearchAlgorithms.binarySearch(sortedCatalogue, missingId);
        System.out.println("Searching for id=" + missingId + " -> "
                + (found != null ? found : "Not found"));
    }
}
