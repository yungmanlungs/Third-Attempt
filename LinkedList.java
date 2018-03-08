package customlinkedlist;
public class LinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    public int size = 0;
    
    //add node to first index of list
    public void addFirst(E e){
        Node<E> newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        
        if(tail == null) {
            tail = head;
            size++;           
        }
    }
    
    //return size of list
    public int getSize() {
        return size;
    }
    
    //print the list
    public void print() {
        Node<E> current = head;
        while(current != null)
        {
            System.out.println(current.element);
            current = current.next;
        }
    }
    
    //add value to last index of the list
    public void addLast(E e){
        if (tail == null) {
            head = tail;
            tail = new Node<>(e);
        }
        else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }
    
    //add value to selected index of list
    public void add(int index, E e){
        if(index == 0) {
            addFirst(e);
        }
        else if(index >= size) {
            addLast(e);
        }
        else{
            Node<E> current = head;
            
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }
    
    //remove value in the first index of list
    public E removeFirst() {
        Node<E> temp = head;
        if(size == 0)
            return null;
        else {
            head = head.next;
            size--;
            
            if(head == null) {
                tail = null;
            }
            return temp.element;
        }
    }
    
    //remove value of last index in list
    public E removeLast() {
        switch (size) {
            case 0:
                return null;
            case 1:
            {
                Node<E> temp = head;
                head = tail;
                tail = null;
                size = 0;
                return temp.element;
            }
            default:
            {
                Node<E> current = head;
                for (int i = 0; i < size - 2; i++) {
                    current = current.next;
                }
                Node temp = tail;
                tail = current;
                tail.next = null;
                size--;
                return current.element;
            }
        }
    }
    
 //remove value of selected index in the list
    public E remove(int index) {
        if(index < 0 || index >= size)
            return null;
        else if(index ==0)
            return removeFirst();
        else if(index == size - 1)
            return removeLast();
        else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) 
            {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }
}
//the end boi
