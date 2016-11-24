/**
 *  File Name: MyArrayList.java
 *  Desc: xxxx
 *  Author: cyhe
 *  Created Time: 2016-11-24 16:32:27
 */
public class MyArrayList {
    private static final int DEFAULT_SIZE = 10;
    private int size;
    private int[] items;
    
    public MyArrayList(int size) {
        items = new int[size];
    }
    public MyArrayList(){
        this(DEFAULT_SIZE);
    }
    private void resize(){
        int oldSize = items.length;
        int newSize = oldSize + (oldSize >> 1);
        int[] temp = new int[newSize];
        System.arraycopy(items, 0, temp, 0, oldSize);
        items = temp;
    }
    
    public void add(int it){
        if(size + 1 > items.length) resize(); 
        items[size ++] = it;
    }
    public void add(int index, int it){
        if(index < 0 || index > size){
            System.out.println("IndexOutOfBound ["+index+"], size=" + size);
            return;  
        }
        if(size + 1 > items.length) resize();
        for(int i=size; i>index; i--){
            items[i] = items[i-1];
        }
        items[index] = it;
        size++;
    }
    public void remove(int index){
        if(index < 0 || index > size){
            System.out.println("IndexOutOfBound ["+index+"], size=" + size);
            return;
        }
        for(int i = index; i < size-1; i++){
            items[i] = items[i+1];
        }
        items[size-1] = 0;
        size--;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i=0; i<size; i++) {
            sb.append(items[i] + ", ");
        }
        sb.delete(sb.length()-1, sb.length());
        sb.append(']');
        return sb.toString();
    }
    public static void main(String[]args) {
        MyArrayList myList = new MyArrayList(5);
        myList.add(1);myList.add(2);myList.add(3);myList.add(4);
        myList.add(8);
        System.out.println(myList.toString() + ", size=" + myList.size);
        myList.remove(0);
    }
    
}
