import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyOwnList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node newNode = new Node<T>(t, last, first);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for(T t: c){
            add(t);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Node<T> current = getNode(index);
        for (T element: c) {
            Node<T> addingElement = new Node<T>(element, current.getPrev(), current);
            current.setPrev(addingElement);
            current = addingElement;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public T get(int index) {
        Node<T> current = getNode(index);
        return current.getElement();

    }

    private Node<T> getNode(int index) {
        checkIndex(index);
        int counter = 0;
        Node<T> current = first;
        while(counter != index){
            counter++;
            current = current.getNext();
        }
        return current;
    }

    private void checkIndex(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(index < 0){
            throw new NegativeArraySizeException();
        }
    }

    @Override
    public T set(int index, T element) {
        Node<T> current = getNode(index);
        T prevElement = current.getElement();
        current.setElement(element);
        return prevElement;
    }

    @Override
    public void add(int index, T element) {
        Node<T> current = getNode(index);
        Node<T> addingElement = new Node<T>(element, current.getPrev(), current);
        size++;
        current.setPrev(addingElement);
    }

    @Override
    public T remove(int index) {
        Node<T> current = getNode(index);
        Node<T> prev = current.getPrev();
        Node<T> next = current.getNext();

        prev.setNext(next);
        next.setPrev(prev);
        size--;
        return current.getElement();
    }

    @Override
    public int indexOf(Object o) {
        int counter = 0;
        Node<T> current = first;
        while(current.getElement() != o){
            counter++;
            current = current.getNext();
            if(counter == size){
                return -1;
            }
        }
        return counter;
    }

    @Override
    public int lastIndexOf(Object o) {
        int counter = 0;
        Node<T> current = last;
        while(current.getElement() != o){
            counter++;
            current = current.getPrev();
            if(counter == size){
                return -1;
            }
        }

        return size - counter;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw  new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw  new UnsupportedOperationException();
    }
}
