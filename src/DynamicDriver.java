//4737
//Assignment #2
//COP 3530

public class DynamicDriver {

    public static void main(String args[]) {

        DynamicList list, list2;

        list = new DynamicList();
        list2 = new DynamicList();

        list.insertLast(new IntData(1));
        list.insertLast(new IntData(2));
        list.insertLast(new IntData(3));
        list.print();

        list2.insertLast(new IntData(4));
        list2.insertLast(new IntData(5));
        list2.insertLast(new IntData(6));
        list2.print();
//
        list.Concat(list2);
        list.print();
        System.out.println(list.SumList());

        list.reverseIteratively();
        list.print();

    }
}
