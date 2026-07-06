package src;

/**
 * ForecastTest - demonstrates future value prediction using three approaches.
 *
 * Formula: FV = PV * (1 + r)^n
 *  PV = present value
 *  r  = annual growth rate (decimal)
 *  n  = number of periods (years)
 */
public class ForecastTest {

    public static void main(String[] args) {
        double presentValue = 10_000.00;   // $10,000 initial investment
        double growthRate   = 0.08;        // 8% annual growth
        int[]  periods      = {1, 5, 10, 20, 30};

        System.out.println("=== Financial Forecast ===");
        System.out.printf("Present Value : $%.2f%n", presentValue);
        System.out.printf("Growth Rate   : %.0f%%%n", growthRate * 100);
        System.out.println();
        System.out.printf("%-8s %-20s %-20s %-20s%n",
                "Years", "Plain Recursion", "Memoised", "Fast-Power (O(log n))");
        System.out.println("-".repeat(72));

        for (int n : periods) {
            double plain  = FinancialForecast.calculateFutureValue(presentValue, growthRate, n);
            double memo   = FinancialForecast.calculateFutureValueMemo(presentValue, growthRate, n);
            double fast   = FinancialForecast.calculateFutureValueFast(presentValue, growthRate, n);

            System.out.printf("%-8d $%-19.2f $%-19.2f $%-19.2f%n", n, plain, memo, fast);
        }
    }
}
