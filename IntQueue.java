import java.util.NoSuchElementException;

public class IntQueue {
    private int[] queue;
    private int firstIndex;
    private int lastIndex;
    private int size;

    public IntQueue(int len) {
        this.queue = new int[len];
        this.firstIndex = 0;
        this.lastIndex = 0;
        this.size = 0;
    }

    public boolean enqueue(int element) {
        if (this.size == this.queue.length) {
            return false;
        }

        this.queue[this.lastIndex] = element;
        
        this.lastIndex = (this.lastIndex + 1) % this.queue.length;
        this.size++;

        return true;
    }

    public int dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        int topElement = this.queue[this.firstIndex];
        this.firstIndex = (this.firstIndex + 1) % this.queue.length;
        this.size--;

        return topElement;
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return this.queue[this.firstIndex];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}