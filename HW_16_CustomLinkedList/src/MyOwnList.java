import java.util.*;
import java.util.function.Consumer;

public class MyOwnList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    private class MyOwnIterator implements Iterator<T> {
        private Node<T> lastReturned;
        private Node<T> next;
        private int nextIndex;

        MyOwnIterator(int index) {
            next = (index == size) ? null : getNode(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public T next() {
            checkIndex(nextIndex);
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = next;
            next = next.getNext();
            nextIndex++;
            return lastReturned.getElement();
        }

        @Override
        public void remove() {
            // TODO implement
            throw  new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer action) {
            // TODO implement
            throw  new UnsupportedOperationException();
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean add(T t) {
        Node<T> newElement = new Node<>(t, this.last, null);
        Node<T> last = this.last;
        this.last = newElement;
        if (last == null) {
            this.first = newElement;
        } else {
            last.setNext(newElement);
        }
        this.size++;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (this.isEmpty() || index == this.size) {
            checkIndex(index);
            this.add(element);
        } else {
            Node<T> current = getNode(index);
            Node<T> addingElement = new Node<>(element, current.getPrev(), current);
            this.size++;
            current.getPrev().setNext(addingElement);
            current.setPrev(addingElement);
        }
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
        if (this.isEmpty() || index == this.size) {
            checkIndex(index);
            this.addAll(c);
        } else {
            for (T element : c) {
                this.add(index, element);
                index++;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    public T get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        T el = null;
        Node<T> current = getNode(index);
        if (current != null) {
            el = current.getElement();
        }
        return el;
    }

    public T getFirst() {
        Node<T> node = this.first;
        if (node == null)
            throw new NoSuchElementException();
        return node.getElement();
    }

    public T getLast() {
        Node<T> node = this.last;
        if (node == null)
            throw new NoSuchElementException();
        return node.getElement();
    }

    private Node<T> getNode(int index) {
        checkIndex(index);
        int counter = 0;
        Node<T> current = this.first;
        while(counter != index){
            counter++;
            current = current.getNext();
        }
        return current;
    }

    private Node<T> getNode(Object o) {
        Node<T> current = this.first;
        if (current != null) {
            int counter = 0;
            while (counter < this.size()) {
                if(current.getElement().equals(o)) {
                    return current;
                }
                current = current.getNext();
                counter++;
            }
        }
        return current;
    }

    private void checkIndex(int index) {
        if (this.isEmpty()) {
            if (index > 0) {
                throw new IndexOutOfBoundsException();
            }
        } else if (index > this.size) {
                throw new IndexOutOfBoundsException();
        }
        if(index < 0){
            throw new NegativeArraySizeException();
        }
    }

    @Override
    public T set(int index, T element) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = getNode(index);
        T prevElement = current.getElement();
        current.setElement(element);
        return prevElement;
    }

    private void unlinkNode(Node<T> current, Node<T> prev, Node<T> next) {
        if (prev == null) {
            this.first = next;
        } else {
            prev.setNext(next);
            current.setPrev(null);
        }
        if (next == null) {
            this.last = prev;
        } else {
            next.setPrev(prev);
            current.setNext(null);
        }
        current.setElement(null);
    }

    @Override
    public T remove(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = getNode(index);
        Node<T> prev = current.getPrev();
        Node<T> next = current.getNext();
        T element = current.getElement();
        unlinkNode(current, prev, next);
        this.size--;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = getNode(o);
        if (current == null) {
            return false;
        } else {
            Node<T> prev = current.getPrev();
            Node<T> next = current.getNext();
            unlinkNode(current, prev, next);
            this.size--;
            return true;
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for (Object o: c) {
            if (this.remove(o)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = false;
        for (T element: this) {
            // System.out.println(element);
            if (!c.contains(element)) {
                if(this.remove(element)) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public int indexOf(Object o) {
        if (this.isEmpty()) {
            return -1;
        }
        int counter = 0;
        Node<T> current = this.first;
        while(current.getElement() != o){
            counter++;
            current = current.getNext();
            if(counter == this.size){
                return -1;
            }
        }
        return counter;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (this.isEmpty()) {
            return -1;
        }
        int counter = 1;
        Node<T> current = this.last;
        while(current.getElement() != o){
            counter++;
            current = current.getPrev();
            if(counter == this.size){
                return -1;
            }
        }

        return this.size - counter;
    }

    @Override
    public boolean contains(Object o) {
        for (T element: this) {
            if (o.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.isEmpty()) {
            return false;
        }
        for(Object o: c) {
            if(!this.contains(o)) {
                return false;
            }
        }
        return true;
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
    public MyOwnIterator iterator() {
        return new MyOwnIterator(0);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        // TODO implement
        throw  new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO implement
        throw  new UnsupportedOperationException();
    }

}
