import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Stack<String> callStack = new Stack<>();
        callStack.push("main()");
        callStack.add("Dog.bark()");
        callStack.push("Cat.bark()");
        System.out.println(callStack);
        callStack.pop();
        System.out.println(callStack);
        while(!callStack.isEmpty()) {
            callStack.pop();
        }
        System.out.println(callStack);

        Queue<String> queue = new LinkedList<>();
        queue.add("Customer 1");
        queue.add("Customer 2");
        queue.offer("Customer 3");
        System.out.println(queue);
        while(!queue.isEmpty()) {
            System.out.println(queue.remove() + " leaving...");
        }
        System.out.println(queue);

        LinkedList<String> trainRoute = new LinkedList<>();
        trainRoute.add("Ostrava - Střed");
        trainRoute.add("Ostrava - Stodolní");
        trainRoute.add("Ostrava - hl.n.");
        trainRoute.add("Ostrava - Svinov");
        trainRoute.add("Jistebník");
        trainRoute.add("Studénka");
        trainRoute.add("Sedlnice");
        trainRoute.add("Skotnice");
        trainRoute.add("...");

        for(int i = 0; i < trainRoute.size(); i++) {
            System.out.println(trainRoute.get(i));
        }

        trainRoute.add(7, "Mošnov - Ostrava Airport");

        for(String trainStation : trainRoute) {
            System.out.println(trainStation);
        }

        trainRoute.remove(); // acting like queue
        trainRoute.remove();
        trainRoute.remove(3);

        for(String trainStation : trainRoute) {
            System.out.println(trainStation);
        }

        // Queue queue =
        // LinkedList
    }
}