/**
 *  File Name: MySingleLinkedList.java
 *  Desc: xxxx
 *  Author: cyhe
 *  Created Time: 2016-11-24 16:32:27
 */
public class MySingleLinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    private static class Node {
        private int data;
        private Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public MySingleLinkedList(){
        head = tail = null;
        size = 0;
    }
    
    public void addLast(int it) {
        Node node = new Node(it, null);
        if(head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }
    
    public void addBefore(int it) {
        Node node = new Node(it, null);
        if(head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }
    
    public void add(int it){
        addLast(it);
    }
    public void add(int index, int it) {
        if(index < 0 || index > size) {
            System.out.println("不合法的参数["+index+"], size=" + size);
            return;
        }
        Node n = new Node(it, null);
        if(index == 0) {
            n.next = head;
            head = n;
        } else {
            Node prev = node(index -1);
            n.next = prev.next;
            prev.next = n;            
        }
        size++;
    }
    
    public void remove(int index){
        if(index < 0 || index > size - 1) {
            System.out.println("不合法的参数["+index+"], size=" + size);
            return;
        }
        if(index == 0) {
            head = head.next;
        } else {
            Node prev = node(index-1);                
            Node del = prev.next;
            prev.next = del.next;
            del = null;                            
        }
        size--;
    }
    
    public Node node(int index){
        Node p = head;
        for(int i=0; i<index; i++)
            p = p.next;
        return p;
    }
    
    public void print(){
        Node p = head;
        while (p!=null) {
            System.out.print(p.data + ", ");
            p = p.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        MySingleLinkedList myLinkedList = new MySingleLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.print();
        myLinkedList.add(4, 9);
        myLinkedList.remove(0);
        myLinkedList.print();
    }
}
