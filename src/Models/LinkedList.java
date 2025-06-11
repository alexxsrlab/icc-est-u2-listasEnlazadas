package Models;

public class LinkedList<T>{
    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void appendToTail(T valor) {
        Node<T> nuevoNodo = new Node<>(valor);
        if (head == null) {
            head = nuevoNodo;
        } else {
            Node<T> actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevoNodo);
        }
        size++;
    }

    public T findByValue(T valor) {
        Node<T> actual = head;
        while (actual != null) {
            if (actual.getValue().equals(valor)) {
                return actual.getValue();
            }
            actual = actual.getNext();
        }
        return null;
    }

    public T deleteByValue(T valor) {
        Node<T> actual = head;
        Node<T> anterior = null;

        while (actual != null) {
            if (actual.getValue().equals(valor)) {
                if (anterior == null) {
                    head = actual.getNext();
                } else {
                    anterior.setNext(actual.getNext());
                }
                size--;
                return actual.getValue();
            }
            anterior = actual;
            actual = actual.getNext();
        }
        return null;
    }

    public void print() {
        Node<T> actual = head;
        while (actual != null) {
            System.out.println(actual.getValue());
            actual = actual.getNext();
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    
}