/**
 *  File Name: RingBuffer.java
 *  Desc: xxxx 
 *  Author: cyhe 
 *  Created Time: 2016-11-26 21:10:31
 */
import java.util.Arrays;
public class RingBuffer {
    // Thread Unsafe 
    private int head;
    private int tail;
    private int lost;
    private String[] items;
    private int capacity;
    public RingBuffer(int size) {
        items = new String[size];
        capacity = size;
    }
    public int getLost() {
        return lost;
    }
    public void put(String st) {
        if ((tail+1)%capacity == head) {
            lost++;
            print();
            return;
        }
        items[tail] = st;
        tail = (tail + 1) % capacity;
        print();
    }
    public String take() {
        if(head == tail) return null;
        String st = items[head];
        items[head] = null;
        head = (head + 1) % capacity;
        return st;
    }
    public void print() {
        System.out.println(Arrays.toString(items) + ", head=" + head + ", tail=" + tail + ", lost=" + lost);
    }
    public static void main(String[] args) {
        RingBuffer rb = new RingBuffer(5);
        rb.put("1");
        rb.put("2");
        rb.put("3");
        rb.put("4");
        rb.put("5");
        System.out.println("============================");
        String st = null;
        while ((st = rb.take()) != null) {
            System.out.print("take " + st + ", ");
            rb.print();
        }
    }
}
