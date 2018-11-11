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
        assertEquals(1, list.size);
        assertEquals(new Integer(1), list.getFirst());
        assertEquals(list.getFirst(), list.getLast());

        assertTrue(list.add(2));
        assertEquals(2, list.size);
        assertEquals(new Integer(1), list.getFirst());
        assertEquals(new Integer(2), list.getLast());

        assertTrue(list.add(3));
        assertEquals(3, list.size);
        assertEquals(new Integer(1), list.getFirst());
        assertEquals(new Integer(3), list.getLast());
    }

    @org.junit.Test
    public void testAddByIndexSuccess() {
        list.add(0,5);
        assertEquals(new Integer(5), list.getFirst());

        list.add(1,6);
        assertEquals(new Integer(6), list.get(1));

        list.add(2,7);
        assertEquals(new Integer(7), list.get(2));
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
    }

    @org.junit.Test
    public void testSet() {
    }

    @org.junit.Test
    public void testClear() {
    }

    @org.junit.Test
    public void testGetSuccess() {
        list.add(1);
        assertEquals(new Integer(1), list.get(0));
        assertEquals(list.get(0), list.getFirst());
        assertEquals(list.get(list.size - 1), list.getLast());
    }

    @org.junit.Test
    public void testGetOutOfMultipleElementsSuccess() {
        list.add(1);
        list.add(2);
        assertEquals(new Integer(1), list.get(0));
        assertEquals(new Integer(2), list.get(list.size - 1));
        assertEquals(list.get(0), list.getFirst());
        assertEquals(list.get(list.size - 1), list.getLast());
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
    public void testRemove() {
    }

    @org.junit.Test
    public void testIndexOf() {
    }

    @org.junit.Test
    public void testLastIndexOf() {
    }
}
