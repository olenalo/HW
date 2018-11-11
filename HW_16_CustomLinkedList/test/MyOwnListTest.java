import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyOwnListTest {
    MyOwnList<Integer> list;

    @org.junit.Before
    public void setUp() throws Exception {
        list = new MyOwnList<>();
    }

    @org.junit.Test()
    public void testIsEmptySuccess() {
        assertTrue(list.isEmpty());
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testIsEmptyThrowsException() {
        assertNull(list.get(0)); // `checkIndex()` throws an exception
    }

    @org.junit.Test
    public void testAddSuccess() {
        assertTrue(list.add(1));
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(new Integer(1), list.getFirst());
        assertEquals(list.getFirst(), list.getLast());

        assertTrue(list.add(2));
        assertEquals(2, list.size());
        assertEquals(new Integer(1), list.getFirst());
        assertEquals(new Integer(2), list.getLast());

        assertTrue(list.add(3));
        assertEquals(3, list.size());
        assertEquals(new Integer(1), list.getFirst());
        assertEquals(new Integer(3), list.getLast());
    }

    @org.junit.Test
    public void testAddByIndexSuccess() {
        list.add(0,5);
        assertFalse(list.isEmpty());
        assertEquals(new Integer(5), list.getFirst());

        list.add(1,6);
        assertEquals(new Integer(6), list.get(1));

        list.add(2,7);
        assertEquals(new Integer(7), list.get(2));
        assertEquals(3, list.size());

        // Add somewhere in the middle (non-empty)
        list.add(1,99);
        assertEquals(4, list.size());
        assertEquals(new Integer(5), list.get(0));
        assertEquals(new Integer(99), list.get(1));
        assertEquals(new Integer(6), list.get(2));
        assertEquals(new Integer(7), list.get(3));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexWrongIndexFailure() {
        list.add(1,5);
    }

    @org.junit.Test(expected = NegativeArraySizeException.class)
    public void testAddByIndexNegativeArraySizeException() {
        list.add(-1,5);
    }

    @org.junit.Test
    public void testAddAllSuccess() {
        LinkedList<Integer> someList = new LinkedList<>();
        someList.add(1);
        someList.add(2);
        someList.add(3);

        list.addAll(someList);
        assertEquals(3, list.size());
        assertEquals(new Integer(1), list.get(0));
        assertEquals(new Integer(2), list.get(1));
        assertEquals(new Integer(3), list.get(2));

        list.addAll(someList);
        assertEquals(6, list.size());
        assertEquals(new Integer(1), list.get(0));
        assertEquals(new Integer(2), list.get(1));
        assertEquals(new Integer(3), list.get(2));
        assertEquals(new Integer(1), list.get(3));
        assertEquals(new Integer(2), list.get(4));
        assertEquals(new Integer(3), list.get(5));
    }

    @org.junit.Test
    public void testAddAllEmptySuccess() {
        list.addAll(new LinkedList<>());
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void testAddAllByIndexEmptySuccess() {
        list.addAll(0, new LinkedList<>());
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void testAddAllByIndexSuccess() {
        LinkedList<Integer> someList = new LinkedList<>();
        someList.add(1);
        someList.add(2);
        someList.add(3);

        // Add to an empty list
        list.addAll(0, someList);
        assertEquals(3, list.size());
        assertEquals(new Integer(1), list.get(0));
        assertEquals(new Integer(2), list.get(1));
        assertEquals(new Integer(3), list.get(2));

        // Add somewhere in the middle (non-empty)
        list.addAll(1, someList);
        assertEquals(6, list.size());
        assertEquals(new Integer(1), list.get(0));
        assertEquals(new Integer(1), list.get(1));
        assertEquals(new Integer(2), list.get(2));
        assertEquals(new Integer(3), list.get(3));
        assertEquals(new Integer(2), list.get(4));
        assertEquals(new Integer(3), list.get(5));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllByIndexSuccessWrongIndexFailure() {
        list.addAll(1, new LinkedList<>());
    }

    @org.junit.Test(expected = NegativeArraySizeException.class)
    public void testAddAllByIndexSuccessNegativeArraySizeException() {
        list.addAll(-1, new LinkedList<>());
    }

    @org.junit.Test
    public void testSetSuccess() {
        list.add(1);
        list.set(0, 2);
        assertEquals(new Integer(2), list.get(0));
        assertEquals(1, list.size());

        list.add(22);
        list.set(1, 33);
        assertEquals(new Integer(33), list.get(1));
        assertEquals(new Integer(2), list.get(0));
        assertEquals(2, list.size());
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmptyArrayFailure() {
        list.set(0, 55);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testSetWrongIndexFailure() {
        list.add(1);
        list.set(1, 2);
    }

    @org.junit.Test(expected = NegativeArraySizeException.class)
    public void testSetNegativeIndexFailure() {
        list.add(1);
        list.set(-1, 2);
    }

    @org.junit.Test
    public void testClearSuccess() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @org.junit.Test(expected = NoSuchElementException.class)
    public void testClearGetFirstFailure() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertTrue(list.isEmpty());
        list.getFirst();
    }

    @org.junit.Test(expected = NoSuchElementException.class)
    public void testClearGetLastFailure() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        list.getLast();
    }

    @org.junit.Test
    public void testFirstSuccess() {
        list.add(1);
        assertEquals(new Integer(1), list.getFirst());

        list.add(2);
        assertEquals(new Integer(1), list.getFirst());
    }

    @org.junit.Test(expected = NoSuchElementException.class)
    public void testGetFirstFailure() {
        list.getFirst();
    }

    @org.junit.Test
    public void testLastSuccess() {
        list.add(1);
        assertEquals(new Integer(1), list.getLast());

        list.add(2);
        assertEquals(new Integer(2), list.getLast());
    }

    @org.junit.Test(expected = NoSuchElementException.class)
    public void testGetLastFailure() {
        list.getLast();
    }

    @org.junit.Test
    public void testGetSuccess() {
        list.add(1);
        assertEquals(new Integer(1), list.get(0));
        assertEquals(list.get(0), list.getFirst());
        assertEquals(list.get(list.size() - 1), list.getLast());
    }

    @org.junit.Test
    public void testGetOutOfMultipleElementsSuccess() {
        list.add(1);
        list.add(2);
        assertEquals(new Integer(1), list.get(0));
        assertEquals(new Integer(2), list.get(list.size() - 1));
        assertEquals(list.get(0), list.getFirst());
        assertEquals(list.get(list.size() - 1), list.getLast());
    }

    @org.junit.Test(expected = NegativeArraySizeException.class)
    public void testGetNegativeIndexShouldFail() {
        list.add(1);
        assertEquals(new Integer(1), list.get(-1));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmptyArrayShouldFail() {
        assertEquals(new Integer(1), list.get(0));
    }

    @org.junit.Test
    public void testRemoveByIndexEmptyListSuccess() {
        list.add(11);
        assertEquals(new Integer(11), list.remove(0));
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void testRemoveByIndexNonEmptyListSuccess() {
        // Need to fill and empty a list out first to ensure the node is cleaned up
        list.add(0);
        list.remove(0);
        assertTrue(list.isEmpty());

        // Remove from the middle
        list.add(11);
        list.add(22);
        list.add(33);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("i = " + i + "::: " + list.get(i));
        }
        assertEquals(new Integer(22), list.remove(1));  // FIXME fix the code
        assertEquals(2, list.size());
        assertEquals(new Integer(11), list.get(0));
        assertEquals(new Integer(33), list.get(1));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByIndexEmptyListShouldFail() {
        list.remove(0);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByIndexWrongIndexShouldFail() {
        list.add(1);
        list.remove(1);
    }

    @org.junit.Test(expected = NegativeArraySizeException.class)
    public void testRemoveByIndexNegativeIndexShouldFail() {
        list.add(1);
        list.remove(-1);
    }

    @org.junit.Test
    public void testIndexOf() {
    }

    @org.junit.Test
    public void testLastIndexOf() {
    }
}
