import java.util.*;

class MinStack {
    Stack<long[]> st = new Stack<>();

    public void push(int x) {
        long min = st.isEmpty() ? x : Math.min(x, st.peek()[1]);
        st.push(new long[]{x, min});
    }
    public void pop() { st.pop(); }
    public int top() { return (int) st.peek()[0]; }
    public int getMin() { return (int) st.peek()[1]; }
}
