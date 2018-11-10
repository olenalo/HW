import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        List list = new LinkedList();
        modify(list);

        HashSet s = new HashSet();

    }

    private static void modify(List list) {
        list.add(new Object());
        list.get(0);

        Iterator i = new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }

}
