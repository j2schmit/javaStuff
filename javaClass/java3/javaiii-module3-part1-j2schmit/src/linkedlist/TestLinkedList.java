package linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLinkedList {

    @Test
    public void testIsEmpty() {
        LinkedList<String> linkedList = new LinkedList();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testAdd() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("Al",0);
        linkedList.add("Bert",1);
        linkedList.add("Carl",2);
        linkedList.add("Ed",3);
        assertEquals("Bert",linkedList.remove(1));
        linkedList.addFirst("Abby");
        assertEquals("Abby",linkedList.remove(0));
        linkedList.addLast("Fred");
        assertEquals("Fred",linkedList.remove(3));
    }

    @Test
    public void testRemove() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("Al",0);
        assertEquals("Al",linkedList.remove(0));
        linkedList.add("Al",0);
        linkedList.add("Bert",1);
        linkedList.add("Carl",2);
        linkedList.add("Ed",3);
        assertEquals("Carl",linkedList.remove(2));
    }

    @Test
    public void testSize() {
        LinkedList<String> linkedList = new LinkedList();
        assertEquals(0, linkedList.size());
        linkedList.add("Al",0);
        linkedList.add("Bert",1);
        linkedList.add("Carl",2);
        linkedList.add("Ed",3);
        assertEquals(4, linkedList.size());
        linkedList.remove(2);
        assertEquals(3, linkedList.size());
        linkedList.addLast("Fred");
        assertEquals(4, linkedList.size());
        linkedList.addFirst("Abby");
        assertEquals(5, linkedList.size());
    }

    @Test
    public void testToString() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("Al",0);
        linkedList.add("Bert",1);
        linkedList.add("Carl",2);
        linkedList.add("Ed",3);
        String str = "Al\nBert\nCarl\nEd\n";
        assertEquals(str, linkedList.toString());
    }
}