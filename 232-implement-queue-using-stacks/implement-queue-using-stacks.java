import java.util.*;

class MyQueue {
    Stack<Integer> a = new Stack<>(), b = new Stack<>();

    void push(int x) { a.push(x); }

    int pop() { peek(); return b.pop(); }

    int peek() {
        if (b.isEmpty())
            while (!a.isEmpty()) b.push(a.pop());
        return b.peek();
    }

    boolean empty() { return a.isEmpty() && b.isEmpty(); }
}
