package src;

/**
 * SearchAlgorithms - implements Linear Search and Binary Search on Product arrays.
 *
 * Big O Notation recap:
 *  - Describes the upper-bound growth rate of an algorithm as input size n grows.
 *  - O(1) constant, O(log n) logarithmic, O(n) linear, O(n log n) linearithmic, O(n²) quadratic.
 *
 * Linear Search:
 *  - Best case  : O(1)  — target is the first element.
 *  - Average    : O(n)  — target is somewhere in the middle.
 *  - Worst case : O(n)  — target is last or absent.
 *
 * Binary Search (requires sorted array):
 *  - Best case  : O(1)    — target is the middle element on first probe.
 *  - Average    : O(log n)
 *  - Worst case : O(log n)
 */
public class SearchAlgorithms {

    // ----------------------------------------------------------------
    // Linear Search — search by productId in an unsorted array  O(n)
    // ----------------------------------------------------------------
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.getProductId() == targetId) {
                return p;
            }
        }
        return null;   // not found
    }

    // ----------------------------------------------------------------
    // Binary Search — search by productId in a SORTED array      O(log n)
    // Array must be sorted by productId in ascending order.
    // ----------------------------------------------------------------
    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int low  = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid    = low + (high - low) / 2;   // avoids integer overflow
            int midId  = sortedProducts[mid].getProductId();

            if (midId == targetId) {
                return sortedProducts[mid];
            } else if (midId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;   // not found
    }
}
