package HW6;

public class PriorityQueue {

    private Node head;

    private class Node {

        int value;
        int priority;
        Node next;

        public Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    public void add(int value, int priority) {

        Node newNode = new Node(value, priority);

        if (head == null || priority < head.priority) {
            newNode.next = head;
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null && current.next.priority <= priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int remove() {

        int value = head.value;
        head = head.next;
        return value;
    }
}
