class MyCircularQueue {
    int[] q;
    int front = 0, rear = 0, size = 0, cap;

    public MyCircularQueue(int k) {
        cap = k;
        q = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        q[rear] = value;
        rear = (rear + 1) % cap;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % cap;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : q[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[(rear - 1 + cap) % cap];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }
}
