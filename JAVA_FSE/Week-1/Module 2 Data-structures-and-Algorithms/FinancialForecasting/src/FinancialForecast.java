package src;

import java.util.HashMap;
import java.util.Map;

/**
 * FinancialForecast - predicts future value using recursive growth calculation.
 *
 * Recursion concept:
 *  - A method calls itself with a smaller sub-problem until a base case is reached.
 *  - Future value after n periods = presentValue * (1 + growthRate)^n
 *    can be expressed recursively as:
 *      FV(n) = FV(n-1) * (1 + growthRate)   where FV(0) = presentValue
 *
 * Time Complexity (plain recursion):
 *  - O(n) — each call reduces n by 1, so there are n+1 stack frames.
 *  - Risk: stack overflow for very large n.
 *
 * Optimisation — Memoisation (top-down DP):
 *  - Cache previously computed results in a HashMap.
 *  - Each unique n is computed only once → still O(n) but avoids recomputation
 *    in scenarios where FV is called multiple times for overlapping sub-problems.
 *
 * Alternative optimisation — use Math.pow() for O(1) / O(log n) exponentiation
 * or fast power recursion (divide-and-conquer) which is O(log n).
 */
public class FinancialForecast {

    // ----------------------------------------------------------------
    // Plain recursion  — O(n) time, O(n) stack space
    // ----------------------------------------------------------------
    public static double calculateFutureValue(double presentValue,
                                              double growthRate,
                                              int    periods) {
        if (periods == 0) {
            return presentValue;   // base case
        }
        return calculateFutureValue(presentValue, growthRate, periods - 1)
               * (1 + growthRate);
    }

    // ----------------------------------------------------------------
    // Memoised recursion  — O(n) time, O(n) space (cache + stack)
    // ----------------------------------------------------------------
    private static final Map<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValueMemo(double presentValue,
                                                   double growthRate,
                                                   int    periods) {
        if (periods == 0) {
            return presentValue;
        }
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
        double result = calculateFutureValueMemo(presentValue, growthRate, periods - 1)
                        * (1 + growthRate);
        memo.put(periods, result);
        return result;
    }

    // ----------------------------------------------------------------
    // Fast-power recursion  — O(log n) time
    // FV = PV * (1 + r)^n  computed via repeated squaring
    // ----------------------------------------------------------------
    public static double calculateFutureValueFast(double presentValue,
                                                   double growthRate,
                                                   int    periods) {
        return presentValue * fastPow(1 + growthRate, periods);
    }

    private static double fastPow(double base, int exp) {
        if (exp == 0) return 1.0;
        if (exp % 2 == 0) {
            double half = fastPow(base, exp / 2);
            return half * half;
        } else {
            return base * fastPow(base, exp - 1);
        }
    }
}
