import java.util.Stack;
import java.util.function.BooleanSupplier;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int factorial(int n) {
        if (n == 0) {
            return 1; // BASE CASE
        } else {
            return n * factorial(n - 1); // SELF-CALL
        }
    }

    public static int factorialWithLoop(int n) {
        int factorialResult = 1;

        for(int i = n; i > 0; i--) {
            factorialResult *= i;
        }
        return factorialResult;
    }

    public static void a() {
        System.out.println("START A");
        b();
        System.out.println("END A");
    }

    public static void b() {
        System.out.println("START B");
        c();
        System.out.println("END B");
    }

    public static void c() {
        System.out.println("START C");
        System.out.println("END C");
        // b();
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.runTreeTraversal(1,8);

        System.out.println("Computing factorial...");;
        System.out.println(factorial(5));
        System.out.println("Calculation ended");
        System.out.println("Calculation of factorial without recursion:");
        System.out.println(factorialWithLoop(5));

        Stack<Integer> stackExample = new Stack<>();
        stackExample.add(6); // NOTE: push returns the item itself, add returns true if item successfully added (NOTE #2: false is almost never really returned...)
        stackExample.add(4); // NOTE: push returns the item itself, add returns true if item successfully added (NOTE #2: false is almost never really returned...)
        stackExample.add(9); // NOTE: push returns the item itself, add returns true if item successfully added (NOTE #2: false is almost never really returned...)
        stackExample.add(1); // NOTE: push returns the item itself, add returns true if item successfully added (NOTE #2: false is almost never really returned...)

        System.out.println("Stack items:");
        for (int stackItem : stackExample) {
            System.out.println(stackItem);
        }

        System.out.println("Stack items:");
        do {
            System.out.println(stackExample.pop());
        } while (stackExample.size() > 0);

        // stack also influences "normal" functions calls
        a();
    }
}