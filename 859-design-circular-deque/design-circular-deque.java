class MyCircularDeque {
    int[] q;
    int front = 0, rear = 0, size = 0, cap;

    public MyCircularDeque(int k) {
        cap = k;
        q = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + cap) % cap;
        q[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        q[rear] = value;
        rear = (rear + 1) % cap;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % cap;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + cap) % cap;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : q[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : q[(rear - 1 + cap) % cap];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }
}
