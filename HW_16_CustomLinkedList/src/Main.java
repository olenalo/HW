import java.util.*;

public class Main {

    public static void main(String[] args) {
        List list = new LinkedList();
        // modify(list);
        HashSet s = new HashSet();

        // Explore the behaviour:

        // list.add(0, 1);
        // list.add(1, 1);
        // list.add(2, 2);
        list.add(0);
        list.add(1);
        list.add(2);
        System.out.println("Size v0: " + list.size());
        System.out.println("First element v0: " + list.get(0));
        System.out.println("Second element v0: " + list.get(1));
        System.out.println("Third element v0: " + list.get(2));
        System.out.println("--------------------------");
        list.add(1, 11);
        System.out.println("Size v1: " + list.size());
        System.out.println("First element v1: " + list.get(0));
        System.out.println("Second element v1: " + list.get(1));
        System.out.println("Third element v1: " + list.get(2));
        System.out.println("Fourth element v1: " + list.get(3));
        System.out.println("--------------------------");

        List list2 = new LinkedList();
        list2.add(0);
        list2.add(111);
        list2.add(222);

        list2.addAll(1, list);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }

        List list3 = new LinkedList();
        try {
            list3.set(0, 11);
            System.out.println("Here we are");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

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
