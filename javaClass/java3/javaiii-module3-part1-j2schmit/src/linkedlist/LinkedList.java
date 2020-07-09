package linkedlist;

public class LinkedList<T> implements LinkedListInterface<T> {

    private int counter;
    private Node<T> headNode;

    public LinkedList() {
        counter = 0;
        headNode = null;
    }

    public Node<T> getHeadNode() {
        return headNode;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void addFirst(T data) {
        Node<T> oldHeadNode = headNode;
        headNode = new Node(data, oldHeadNode);
        counter++;
    }

    @Override
    public void addLast(T data) {
        if (counter == 0) {
            headNode = new Node(data, null);
        } else {
            Node<T> node = headNode;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new Node(data, null));
        }
        counter++;
    }

    @Override
    public void add(T data, int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            addFirst(data);
            counter--;
        } else {
            int count = 0;
            Node<T> previousNode = headNode;
            while (count != index - 1) {
                count++;
                previousNode = previousNode.getNext();
            }
            Node<T> oldNode = previousNode.getNext();
            Node<T> node = new Node(data, oldNode);
            previousNode.setNext(node);
        }
        counter++;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        T data;
        if (index == 0) {
            data = headNode.getData();
            headNode = headNode.getNext();
        } else {
            int count = 0;
            Node<T> previousNode = headNode;
            while (count != index - 1) {
                count++;
                previousNode = previousNode.getNext();
            }
            Node<T> oldNode = previousNode.getNext();
            data = oldNode.getData();
            previousNode.setNext(oldNode.getNext());
        }
        counter--;
        return data;
    }

    @Override
    public String toString() {
        if (counter == 0) {
            return "\n";
        } else {
            String str = headNode.getData().toString() + "\n";
            Node<T> node = headNode.getNext();
            while (node != null) {
                str = str + node.getData().toString() + "\n";
                node = node.getNext();
            }
            return str;
        }
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}