import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private Map<Integer, Long> dictionaryMemory = new HashMap<>();

    public static int factorial(int n) {
        if (n == 0) { // BASE CASE / HALT CASE
            return 1;
        } else {
            int nNew = n - 1;
            return n * factorial(nNew); // RECURSIVE CASE
        }
    }

    // a() -> b() -> c()
    // BEFORE CALL FROM a()
    // AFTER CALL FROM c()

    public static void a() {
        System.out.println("BEFORE CALL b()");
        b();
        System.out.println("AFTER CALLING b()");
    }

    public static void b() {
        System.out.println("BEFORE CALL c()");
        c();
        System.out.println("AFTER CALLING c()");
    }

    public static void c() {
        System.out.println("BEGINNING OF c()");
        System.out.println("Some routine in the c()...");
        System.out.println("END OF c()");
    }

    public static int factorialWithLoop(int n) {
        int factorialResult = 1;
        for(int i = n; i > 0; i--) {
            factorialResult *= i;
        }
        return factorialResult;
    }

    public static int fibonacci(int n) {
        if (n == 1) { // BASE
            return 1;
        } else if (n == 0) { // BASE
            return 0;
        } else {
            // RECURSIVE
            return fibonacci(n-1)
                    + fibonacci(n-2);
        }
    }

    public long fibonacciWithHashMap(int n) {
        // 1. BASE CASE
        if (n <= 1) {
            return n;
        }

        // 2. MEMORY: Have we already calculated this?
        // If yes, instantly return the saved: O(1)
        if (dictionaryMemory.containsKey(n)) {
            return dictionaryMemory.get(n);
        }

        // 3. RECURSIVE STEP: We haven't seen it yet. Calculate like always recursively...
        long result = fibonacciWithHashMap(n - 1)
                + fibonacciWithHashMap(n - 2);

        // 4. SAVE for the next time...
        dictionaryMemory.put(n, result);

        return result;
    }

    public static int fibonacciByLoop(int n) {
        int resultNew = 0;
        int i = 0; // F_(old-1) or F(n-2)
        //int iPlus1 = i + 1; // F_old or F(n-1)
        //int iPlus2 = i + 2; // F_new or F(n)
        int resultOld = 0;
        int resultOldMinus1 = 0;

        if (n == 0) {
            return 0;
        }

        while(i < n) {
            if(i == 2) {
                resultOld = 1;
                resultOldMinus1 = 1;
            } else if (i <= 1) {
                resultOld = 1;
                resultOldMinus1 = 0;
            }
            resultNew = resultOld + resultOldMinus1;
            resultOldMinus1 = resultOld; // NOTICE: Be careful of the order!
            resultOld = resultNew;
            //iPlus1++;
            //iPlus2++;
            i++;
        }

        return resultNew;
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

    public static boolean haltingFunction(int n) {
        // Examples of different ways halting can be done in function or method
        for (int i = 0; i < n; i++) {
            while(true) {
                System.out.println("Never stop!");
                if(System.currentTimeMillis() % (long) 2 == 0) { // HALT
                    break;
                }
            }
        }
        System.out.println("Nope! You stop!");
        return true;
    }

    public static boolean haltingFunction2(int n) {
        // Examples of different ways halting can be done in function or method
        for (int i = 0; i < n; i++) {
            haltingFunction2(n);
            System.out.println("Never stop!");
            if(System.currentTimeMillis() % (long) 2 == 0) { // HALT
                break;
            }
        }
        System.out.println("Nope! You stop!");
        return true;
    }

    public static boolean haltingFunction3(int n) {
        // Examples of different ways halting can be done in function or method
        if(System.currentTimeMillis() % (long) 2 == 0) { // HALT
            System.out.println("Nope! You stop!");
            return true;
        } else {
            System.out.println("Never stop!");
            haltingFunction2(n); // NOTICE: This is intentionally here to show this HALTs too...
        }

        return true;
    }

    public static boolean haltingFunction4(int n) {
        // Examples of different ways halting can be done in function or method
        for (int i = 0; i < n; i++) {
            haltingFunction4(n);
        }
        System.out.println("Nope! You stop!");
        return true;
    }


    public static void main(String[] args) {

        int n = 10;
        System.out.println("fibonacci(" + n + "):");
        System.out.println(fibonacci(n));

        System.out.println(fibonacciByLoop(n));



        haltingFunction(20);
        haltingFunction3(30);

        List<Object> portfolio = new ArrayList<>(Arrays.asList(
                1,
                Arrays.asList(2, Arrays.asList(3, 4), 5),
                Arrays.asList(6, 7),
                8
        ));

        System.out.println("Total value of portfolio:");
        System.out.println(sumOfNestedSubsets(portfolio));

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int limit = 100000;
        long timeBefore = System.currentTimeMillis();
        long timeBeforeNano = System.nanoTime();
        System.out.println("Before loop.");
        for (int i = 0; i < limit; i++) {
            if((i % 10000) == 0) {
                //System.out.println("10000 iterations.");
            }
        } // O(n)
        long timeAfter = System.currentTimeMillis();
        long timeAfterNano = System.nanoTime();

        System.out.println("After loop.");
        long timeDifference = timeAfter - timeBefore;
        long timeDifferenceNano = timeAfterNano - timeBeforeNano;
        System.out.println("Time measured: " + timeDifference + "ms " + timeDifferenceNano + "ns");

        // O(n^2)
        for(int i = 0; i < limit; i++) {
            for(int j = 0; j < limit; j++) {

                if((i % 10000) == 0) {
                    //System.out.println("i: 10000 iterations.");
                }
                if((j % 10000) == 0) {
                    //System.out.println("j: 10000 iterations.");
                }
            }
        }
        timeAfter = System.currentTimeMillis();
        timeAfterNano = System.nanoTime();


        System.out.println("After loop.");
        timeDifference = timeAfter - timeBefore;
        timeDifferenceNano = timeAfterNano - timeBeforeNano;
        System.out.println("Time measured: " + timeDifference + "ms " + timeDifferenceNano + "ns");

        // O(n^3)
        a();

        System.out.println(n + "! = ");
        System.out.println(factorial(n));
        System.out.println(factorialWithLoop(n));

        int i = 1;

        while(true) {
            System.out.println(i);
            if(i > 1000) {
                break;
            }
            i++;
        }
        System.out.println("After loop");
    }
}


