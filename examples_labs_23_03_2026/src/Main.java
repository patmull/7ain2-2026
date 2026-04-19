import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int factorialByRecursion(int n) {
        // BASE CASE / ZÁKL. PŘÍPAD
        if (n == 0) {
            return 1;
        } else {
            // RECURSIVE CASE / REKURZIVNÍ
            int newN = n-1; // DIFFERENCE / ZMĚNA
            return n * factorialByRecursion(newN);
        }
    }

    public static int factorialByLoop(int n) {
        int result = 1;
        for(int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public static int fibonacciByRecursion(int n) {
        if(n == 0) {return 0;}
        else if (n == 1) {return 1;}
        else {
            return fibonacciByRecursion(n-1)
                + fibonacciByRecursion(n-2);
        }
    }

    public static int sumOfNestedSubsets(List<Object> portfolio) {
        // NOTICE: This time we use the for loop to enhance this. We can do it without any loop, just recursively,
        // but it gets messier...
        int sum = 0;

        for (Object item : portfolio) { // BASE CASE TOO! (handles {})
            if (item instanceof Integer) { // BASE CASE
                sum += ((Integer) item).intValue(); // do not continue with recursion => popping the item from the top of the stack
            } else if (item instanceof List) { // RECURSIVE CASE
                List<Object> actualItem = (List<Object>) item;
                sum += sumOfNestedSubsets(actualItem); // Recursive call
            }
        } // This time the end is not handled by return, but by the end of the for loop (but non-recursive case still needs to contain no recursion)...

        return sum; //  NOTICE: We do not always need to return in the recursion if wrapped around something else...
    }

    public static void main(String[] args) {
        System.out.println(factorialByRecursion(5));
        System.out.println(factorialByLoop(5));

        System.out.println(factorialByRecursion(0));
        System.out.println(factorialByRecursion(0));

        System.out.println(fibonacciByRecursion(6));

        // {{{...}, ...,{...}}, ... , {...}}
        ArrayList portfolio = new ArrayList<>(
                Arrays.asList(
                        1,
                        Arrays.asList(2,Arrays.asList(4,5,6)),
                        Arrays.asList(4,5,6),
                        8
                )
        );

        System.out.println(sumOfNestedSubsets(portfolio));
    }
}