import static org.junit.Assert.*;

public class MyOwnListTest {
    MyOwnList<Integer> list;

    @org.junit.Before
    public void setUp() throws Exception {
        list = new MyOwnList<>();
    }

    @org.junit.Test()
    public void isEmptyTestSuccess() {
        assertTrue(list.isEmpty());
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void isEmptyTestThrowsException() {
        assertNull(list.get(0)); // `checkIndex()` throws an exception
    }

    // TODO move these two to param tests
    @org.junit.Test
    public void addTestFirstElementSuccess() {
        assertTrue(list.add(1));
        assertFalse(list.isEmpty());
        assertEquals(1, list.size);
        assertEquals(new Integer(1), list.getFirst());
        assertEquals(list.getFirst(), list.getLast());
    }

    @org.junit.Test
    public void addTestSeveralElementsSuccess() {
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertEquals(2, list.size);
        assertEquals(new Integer(1), list.getFirst());
        // assertEquals(new Integer(2), list.getLast());  // FIXME

        assertTrue(list.add(3));
        assertEquals(3, list.size);
        assertEquals(new Integer(1), list.getFirst());
        // assertEquals(new Integer(3), list.getLast());  // FIXME
    }

    @org.junit.Test
    public void addAll() {
    }

    @org.junit.Test
    public void clear() {
    }

    @org.junit.Test
    public void getTestSuccess() {
        list.add(1);
        assertEquals(new Integer(1), list.get(0));
        assertEquals(list.get(0), list.getFirst());
        assertEquals(list.get(list.size - 1), list.getLast());
    }

    @org.junit.Test
    public void getTestOutOfMultipleElementsSuccess() {
        list.add(1);
        list.add(2);
        assertEquals(new Integer(1), list.get(0));
        // assertEquals(new Integer(3), list.get(list.size - 1));  // FIXME
        assertEquals(list.get(0), list.getFirst());
        // assertEquals(list.get(list.size - 1), list.getLast());  // FIXME
    }

    @org.junit.Test(expected = NegativeArraySizeException.class)
    public void getTestNegativeIndexShouldFail() {
        list.add(1);
        assertEquals(new Integer(1), list.get(-1));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void getTestEmptyArrayShouldFail() {
        assertEquals(new Integer(1), list.get(0));
    }

    // TODO get(0) equals to getLast
    // TODO get(size - 1) equals to getLast

    @org.junit.Test
    public void set() {
    }

    @org.junit.Test
    public void remove() {
    }

    @org.junit.Test
    public void indexOf() {
    }

    @org.junit.Test
    public void lastIndexOf() {
    }
}
