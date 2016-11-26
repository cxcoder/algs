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
    private int size;
    private int capacity;
    public RingBuffer(int size) {
        items = new String[size];
        capacity = size;
    }
    public int getLost() {
        return lost;
    }
    public int size() {
        return size;
    }
    public void put(String st) {
        int next = head + 1;
        if (next >= capacity) {
            next = 0;
        }
        if (next == tail) {
            lost++;
            print();
            return;
        }
        items[next] = st;
        head = next;
        print();
    }
    public String take() {
        return null;
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
    }
}
