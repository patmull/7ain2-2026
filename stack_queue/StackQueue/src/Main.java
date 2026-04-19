import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // The most basic computational model -- the finite automaton has no concept of memeory (just current states
        // it cannot solve the problem of: a^n b^n ("Are the numbers of characters in the sequence same as in the following sequence?")
        // if you add primitive memory of stack, you can solve this just by using the pushdown automaton
        // (primitive computer that has states + 1 stack)
        String testedString = "aaabbb ";
        System.out.println("PROBLEM: Do we have same # of a and b?");
        //String testedString = " ";
        //String testedString = "a ";
        //String testedString = "b ";
        //String testedString = "ab ";
        //String testedString = "aaaaaaaaaaaaaaaaabbbbbbbb ";
        //String testedString = "aaabbbbbbbb ";
        Stack<String> character1Stack = new Stack<>(); // NOTE: Deque<Integer> works same

        // Pop elements from the stack
        int i = 0;
        String inputCharRead = String.valueOf(testedString.charAt(i));
        if (inputCharRead.equals("") || inputCharRead.equals(" ") || inputCharRead.equals("b")) {
            System.out.println("NO");
            return;
        }

        while (inputCharRead.equals("a")) {
            System.out.println("push(" + character1Stack.push(inputCharRead) + ")");
            i++;
            inputCharRead = String.valueOf(testedString.charAt(i));
        }

        if (inputCharRead.equals(" ")) {
            System.out.println("NO");
            return;
        }

        while (inputCharRead.equals("b")) {
            if (!character1Stack.isEmpty()) {
                System.out.println("pop() -> " + character1Stack.pop());
                i++;
                inputCharRead = String.valueOf(testedString.charAt(i));
            } else {
                System.out.println("NO");
                return;
            }
        }

        // Exercise: make this program better
        if (String.valueOf(testedString.charAt(i)).equals("a")
                || String.valueOf(testedString.charAt(i)).equals("b")
                || !character1Stack.isEmpty()
        ) {
            System.out.println("NO");
        } else if (String.valueOf(testedString.charAt(i)).equals(" ")
                && character1Stack.isEmpty()) { // !character1Stack.pop().equals("a") && !character1Stack.pop().equals("b"))
            System.out.println("YES");
        } else {
            System.out.println(String.valueOf(testedString.charAt(i)));
            System.out.println("ERROR: Wrong input!");
        }

        System.out.println("Queue:");
        Queue<Integer> queue = new LinkedList<>(); // NOTICE: Using LinkedList for the queue. Queue is abstract.

        // Enqueue elements into the queue
        queue.add(1);
        queue.add(2); // either add or throw exception ("error")
        queue.offer(3); // ignored when queue full

        // Dequeue elements from the queue
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove()); // either remove or throw exception ("error") when queue empty
            // System.out.println(queue.poll()); // returns null when queue empty
        }
        System.out.println(queue);
    }
}