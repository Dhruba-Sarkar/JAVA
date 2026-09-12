package LinkedList.Construction;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // add a node at the end of linkedList
    public void addLast(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        this.size++;
    }

    // add a node at the start of the linkedlist
    public void addFirst(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        this.size++;
    }

    // Remove a node from the last of the LinkedList
    public void removeLast() {
        if (head == null) {// size = 0
            System.out.println("Nothing to remove, LinkedList is empty!!");
            return;
        } else if (head == tail) { // size = 1
            head = null;
            tail = null;
        } else {
            // Reach the second last node
            Node temp = head;
            while (temp.next != tail) {
                Node tempKaNext = temp.next;
                temp = tempKaNext;
            }
            temp.next = null; // removing the last node
            tail = temp; // shifting tail
        }
        this.size--;
    }

    // Remove a node from the Start of the LinkedList
    public void removeFirst() {
        if (head == null) {// size = 0
            System.out.println("Nothing to remove, LinkedList is empty!!");
            return;
        }
        if (head == tail) { // size = 1
            head = null;
            tail = null;
        } else {
            Node headKaNext = head.next;
            head = headKaNext;
        }
        size--;
    }

    // Get Node At Index
    public Node getNodeAt(int idx) {
        if (idx < 0 || idx >= size) { // Invalid index
            System.out.println("Index out of bounds");
            return null;
        }
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            // temp = temo.next;
            Node tempKaNext = temp.next;
            temp = tempKaNext;
        }
        return temp;
    }

    // Add Node At Index
    public void addNodeAt(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Inex out of bounds");
            return;
        }
        if (idx == 0) {
            addFirst(val);
            return;
        } else if (idx == size) {
            addLast(val);
            return;
        }
        Node newNode = new Node(val);
        Node prevNode = getNodeAt(idx - 1);
        Node nextNode = prevNode.next;

        prevNode.next = null; // Disconnecting the previous node
        prevNode.next = newNode; // Connecting the previous node with new node
        newNode.next = nextNode; // Connecting the new node with the rest of the list

        size++;
    }

    // Remove Node At Index
    public void removeNodeAt(int idx) {
        if (idx < 0 || idx >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        if (idx == 0) {
            removeFirst();
            return;
        }
        if (idx == size - 1) {
            removeLast();
            return;
        }
        Node prevNode = getNodeAt(idx - 1);
        Node nodeToDelete = prevNode.next;
        Node nextNode = nodeToDelete.next;

        prevNode.next = null; // Disconnecting the previous node
        prevNode.next = nextNode; // Connecting the previous node with the next node
    }

    // Reverse the LinkedList
    public void reverseLinkedListDataIteratively() {
        int i = 0;
        int j = size - 1;
        while (i < j) {
            Node NodeAtI = getNodeAt(i);
            Node NodeAtJ = getNodeAt(j);
            int dataAtI = NodeAtI.data;
            int dataAtJ = NodeAtJ.data;

            // Swap Data
            NodeAtI.data = dataAtJ;
            NodeAtJ.data = dataAtI;

            i++;
            j--;

        }
    }

    // Reverse the LinkedList O(N)
    public void reverseLinkedList() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            // save currKaNext as we are going to break connection with next
            Node currKaNext = curr.next;

            // Reverse the pointer to point at prev
            curr.next = prev;

            // Move prev and curr
            prev = curr;
            curr = currKaNext;
        }
        // Swap head and tail
        tail = head;
        head = prev; // New head is the last node which is pointed by prev
    }

    // Display the LinkedList
    public void display() {
        Node temp = head;

        while (temp != null) {
            // print
            System.out.print(temp.data + ", ");
            // find next
            Node tempKaNext = temp.next;
            // move to next
            temp = tempKaNext;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(5);
        ll.addFirst(10);
        ll.addLast(13);
        ll.addFirst(15);
        ll.addFirst(20);

        ll.display();

        // System.out.println(ll.getNodeAt(2).data);

        // ll.addNodeAt(3, 50);
        // ll.display();

        // ll.removeNodeAt(3);
        // ll.display();

        ll.reverseLinkedList();
        ll.display();

    }
}