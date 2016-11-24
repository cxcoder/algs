/**
 *  File Name: MyLinkedList.java
 *  Desc: xxxx
 *  Author: cyhe
 *  Created Time: 2016-11-24 16:32:27
 */
public class MyLinkedList {
    private Node first;
    private Node last;
    private int size;
    private static class Node {
        private int data;
        private Node prev;
        private Node next;
        public Node(Node prev, int data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
        
    public MyLinkedList(){
        first = last = null;
    }
    public void linkLast(int it) {
        Node n = new Node(null, it, null);
        if (last == null) {
           first = last = n; 
        } else {
            n.next = last.next;
            last.next = n;
            n.prev = last;            
            last = n;
        }
        size++;
    }
    
    public void linkBefore(int it) {
        Node n = new Node(null, it, null);
        if (first == null) {
           first = last = n; 
        } else {
            n.prev = first.prev;
            first.prev = n;
            n.next = first;
            first = n;
        }
        size++;
    }
    public void addPrev(int index, int it){
        if(index < 0 || index > size) {
            System.out.println("IndexOutOfBound. index=" + index + ", size=" + size);
            return;
        }
        Node x = new Node(null, it, null);
        if(index == 0){
           x.prev = first.prev;
           x.next = first;
           first = x;
        } else {
           Node p = node(index); 
           x.prev = p.prev;
           p.prev.next = x;
           p.prev = x;
           x.next = p;
        }
        size++;
   }
    public void unlink(int index){
        if(index < 0 || index >= size) {
            System.out.println("IndexOutOfBound. index=" + index + ", size=" + size);
            return;
        }
        if(index == 0){
            first = first.next;
        } else {
            Node x = node(index);
            Node p = x.prev;
            p.next = x.next;
            x.next.prev = p;
            x = null;
        }
    }
    public Node node(int index) {
        if(index < (size >> 1)){
            Node p = first;
            for(int i=0; i<index; i++) {
                p = p.next;
            }
            return p;
        } else {
            Node p = last;
            for(int i=size; i>index; i--) {
                p = p.prev;
            }
            return p;
        }
    }
    public void print(){
        Node p = first;
        while (p != null) {
            System.out.print(p.data + ", ");
            p = p.next;
        }
        System.out.print("size=" + size + "\n");
    }
    public static void main (String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.linkLast(1);myList.linkLast(2);myList.linkLast(3);
        myList.print();
        myList.addPrev(3, 9);
        myList.print();
        myList.unlink(2);
        myList.print();
    }
}
