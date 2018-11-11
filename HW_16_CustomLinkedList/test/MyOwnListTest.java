import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
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
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testIsEmptyThrowsException() {
        assertNull(list.get(0)); // `checkIndex()` throws an exception
    }

    @org.junit.Test
    public void testAdd() {
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
    public void testAddByIndex() {
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
    public void testAddAll() {
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
    public void testAddAllFromEmptyList() {
        list.addAll(new LinkedList<>());
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void testAddAllByIndexFromEmptyList() {
        list.addAll(0, new LinkedList<>());
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void testAddAllByIndexToEmpyList() {
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
    }

    @org.junit.Test
    public void testAddAllByIndexInTheMiddle() {
        LinkedList<Integer> someList = new LinkedList<>();
        someList.add(1);
        someList.add(2);
        someList.add(3);
        list.addAll(0, someList);
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
    public void testAddAllByIndexWrongIndexFailure() {
        list.addAll(1, new LinkedList<>());
    }

    @org.junit.Test(expected = NegativeArraySizeException.class)
    public void testAddAllByIndexNegativeArraySizeException() {
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
    public void testGetOutOfSingleElementsListSuccess() {
        list.add(1);
        assertEquals(new Integer(1), list.get(0));
        assertEquals(list.get(0), list.getFirst());
        assertEquals(list.get(list.size() - 1), list.getLast());
    }

    @org.junit.Test
    public void testGetOutOfMultipleElementsListSuccess() {
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
    public void testGetFromEmptyArrayShouldFail() {
        assertEquals(new Integer(1), list.get(0));
    }

    @org.junit.Test
    public void testRemoveByIndexFromSingleElementListSuccess() {
        list.add(11);
        assertEquals(new Integer(11), list.remove(0));
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void testRemoveByIndexConsecutiveRemovalSuccess() {
        // Need to fill and empty a list out first to ensure the node is cleaned up
        list.add(0);
        list.remove(0);
        // Remove from the middle
        list.add(11);
        list.add(22);
        list.add(33);
        assertEquals(new Integer(22), list.remove(1));
        assertEquals(2, list.size());
        assertEquals(new Integer(11), list.get(0));
        assertEquals(new Integer(33), list.get(1));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByIndexFromEmptyListShouldFail() {
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
    public void testRemoveByElementFromSingleElementListSuccess() {
        list.add(11);
        assertTrue(list.remove(new Integer(11)));
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void testRemoveByElementConsecutiveRemovalSuccess() {
        // Need to fill and empty a list out first to ensure the node is cleaned up
        list.add(0);
        list.remove(new Integer(0));
        // Remove from the middle
        list.add(11);
        list.add(22);
        list.add(33);
        assertTrue(list.remove(new Integer(22)));
        assertEquals(2, list.size());
        assertEquals(new Integer(11), list.get(0));
        assertEquals(new Integer(33), list.get(1));
    }

    @org.junit.Test
    public void testRemoveByElementNonExistingShouldReturnFalse() {
        // Empty list
        assertFalse(list.remove(new Integer(11)));
        // Populated
        list.add(11);
        assertFalse(list.remove(new Integer(22)));
    }

    @Test
    public void testRemoveAllWithSameTypes() {
        ArrayList<Integer> someList = new ArrayList<>();
        someList.add(1);
        someList.add(22); // No exception should be thrown when calling the method
        someList.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.removeAll(someList));
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveAllWithDifferentTypes() {
        list.add(1);
        ArrayList<String> strList = new ArrayList<>();
        strList.add("Lisa");
        assertFalse(list.removeAll(strList));
    }

    @Test
    public void testRemoveAllWhenNoSuchElement() {
        list.add(1);
        ArrayList<Integer> anotherList = new ArrayList<>();
        anotherList.add(333);
        assertFalse(list.removeAll(anotherList));
    }

    @Test
    public void testRemoveAllFromEmptyList() {
        ArrayList<Integer> someList = new ArrayList<>();
        someList.add(1);
        assertFalse(list.removeAll(someList));
    }

    @org.junit.Test
    public void testIndexOf() {
        assertEquals(-1, list.indexOf(1));

        list.add(1);
        assertEquals(0, list.indexOf(1));
        assertEquals(-1, list.indexOf(2));

        list.add(2);
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));

        assertEquals(-1, list.indexOf(-2));
    }

    @org.junit.Test
    public void testLastIndexOf() {
        assertEquals(-1, list.lastIndexOf(1));

        list.add(1);
        assertEquals(0, list.lastIndexOf(1));
        list.add(1);
        assertEquals(1, list.lastIndexOf(1));

        list.add(2);
        assertEquals(1, list.lastIndexOf(1));

        list.add(1);
        assertEquals(3, list.lastIndexOf(1));

        assertEquals(-1, list.lastIndexOf(3));

        assertEquals(-1, list.lastIndexOf(-3));
    }

    @org.junit.Test
    public void testRetainAll() {
        // Some should remain
        ArrayList<Integer> someList = new ArrayList<>();
        someList.add(1);
        someList.add(2);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertTrue(list.retainAll(someList));
        /*
        for (int el: list) {
            System.out.println("---" + el);
        }
        */
        // assertEquals(2, list.size()); // FIXME
        assertEquals(new Integer(1), list.get(0));
        assertEquals(new Integer(2), list.get(1));

    }

    @org.junit.Test
    public void testRetainAllSameElementsShouldNotChange() {
        list.add(1);
        list.add(2);
        // Nothing changes
        ArrayList<Integer> anotherList = new ArrayList<>();
        anotherList.add(1);
        anotherList.add(2);
        assertFalse(list.retainAll(anotherList));
        assertEquals(2, list.size());
    }

    @org.junit.Test
    public void testRetainAllOutOfEmptyCollection() {
        // No exception is thrown if an empty collection is passed
        list.add(1);
        ArrayList<Integer> emptyList = new ArrayList<>();
        assertTrue(list.retainAll(emptyList));
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void testRetainAllNoElementsRemain() {
        list.add(1);
        ArrayList<Integer> otherList = new ArrayList<>();
        otherList.add(1111);
        assertTrue(list.retainAll(otherList));
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void testRetainAllInEmptyList() {
        // No exception is thrown if the list is empty
        ArrayList<Integer> someList = new ArrayList<>();
        someList.add(1);
        assertFalse(list.retainAll(someList));
    }

    @org.junit.Test
    public void testContains() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertFalse(list.contains(33));
        assertFalse(list.contains("3"));
    }

    @org.junit.Test
    public void testContainsAllGeneralCase() {
        ArrayList<Integer> someList = new ArrayList<>();
        someList.add(1);
        someList.add(2);
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.containsAll(someList));
    }
    @org.junit.Test
    public void testContainsAllNoOccurrencesShouldBeFalse() {
        ArrayList<Integer> someList = new ArrayList<>();
        someList.add(1111);
        assertFalse(list.containsAll(someList));
    }

    @org.junit.Test
    public void testContainsAllOutOfEmptyListShouldBeFalse() {
        ArrayList<Integer> someList = new ArrayList<>();
        assertFalse(list.containsAll(someList));
    }

    @org.junit.Test
    public void testIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        int[] array = new int[] {1, 2, 3};

        int counter = 0;
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Integer element = (Integer) iter.next();
            // Ensure a guarantee of order is provided
            assertEquals(new Integer(array[counter]), element);
            counter++;
        }
        assertEquals(3, counter);

        // Should be the same with simple loop
        int counter2 = 0;
        for (Integer element: list) {
            assertEquals(new Integer(array[counter2]), element);
            counter2++;
        }
        assertEquals(3, counter2);
    }
}
