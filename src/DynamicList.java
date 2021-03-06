//4737
//Assignment #3
//COP 3530

import java.util.HashSet;
import java.util.Set;
import java.util.jar.Pack200;

public class DynamicList {

    private DynamicNode list;
    private int size;


    public DynamicList() {
        list = null;
        size = 0;
    }

    public void intersection(DynamicList x) {


        DynamicNode t1 = list, t2 = x.list;
        int sizeOfT1 = 0;
        int sizeOfT2 = 0;


        //Print out list
        while (t1 != null) {
            sizeOfT1++;
            t1 = t1.getNext();
        }


        //print second list
        while (t2 != null) {
            sizeOfT2++;
            t2 = t2.getNext();
        }

        Object array1[] = new Object[sizeOfT1];
        Object array2[] = new Object[sizeOfT2];


        //create arrays with enough elements to hold contents of list
        t1 = list;
        sizeOfT1 = 0;
        while (t1 != null) {
            array1[sizeOfT1] = t1.getInfo();
            sizeOfT1++;
            t1 = t1.getNext();
        }


        t2 = x.list;
        sizeOfT2 = 0;
        while (t2 != null) {
            array2[sizeOfT2] = t2.getInfo();
            sizeOfT2++;
            t2 = t2.getNext();
        }

        //if objects are equal, make the intersection holder bigger
        int newArraySize = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {

                if (array1[i].toString().equals(array2[j].toString())) {
                    newArraySize++;
                }
            }
        }

        //contain instersection's objects
        Object unionArray[] = new Object[newArraySize];
        newArraySize = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {

                if (array1[i].toString().equals(array2[j].toString())) {
                    unionArray[newArraySize] = array1[i];
                    newArraySize++;
                }
            }
        }

        DynamicList newList = new DynamicList();

        //put intersection objects into list
        for (int i = 0; i < unionArray.length; i++) {
            newList.insertLast(unionArray[i]);
        }

        //printing
        System.out.println();
        System.out.println("Intersection:");
        newList.print();
    }


    public void union(DynamicList x) {

        Set<Integer> set = new HashSet<>();

        DynamicNode t1 = list, t2 = x.list;
        int sizeOfT1 = 0;
        int sizeOfT2 = 0;

        /////printing stuff
        while (t1 != null) {
            System.out.print(t1.getInfo());
            sizeOfT1++;
            t1 = t1.getNext();
        }

        System.out.println();

        while (t2 != null) {
            System.out.print(t2.getInfo());
            sizeOfT2++;
            t2 = t2.getNext();
        }
///////////////////////////////////////
        System.out.println();

        Object array1[] = new Object[sizeOfT1];
        Object array2[] = new Object[sizeOfT2];

        ////put objects in array
        t1 = list;
        sizeOfT1 = 0;
        while (t1 != null) {
            array1[sizeOfT1] = t1.getInfo();
            sizeOfT1++;
            t1 = t1.getNext();
        }

        ////put objects in array
        t2 = x.list;
        sizeOfT2 = 0;
        while (t2 != null) {
            array2[sizeOfT2] = t2.getInfo();
            sizeOfT2++;
            t2 = t2.getNext();
        }


        int newArraySize = sizeOfT1 + sizeOfT2;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {

                set.add(Integer.valueOf(array1[i].toString()));
                set.add(Integer.valueOf(array2[j].toString()));
            }
        }

        DynamicList newList = new DynamicList();

        for (int i = 0; i < set.size(); i++) {
            newList.insertLast(set.toArray()[i]);
        }

        System.out.println();
        System.out.println("Union:");
        newList.print();


    }

    public void deleteEverySecond() {

        ///printing
        System.out.println("Delete Every Second:");
        insertLast(1);
        insertLast(2);
        insertLast(3);
        insertLast(4);
        insertLast(5);
        insertLast(6);
        insertLast(7);
        insertLast(8);
        print();


        if (list == null)
            return;

        DynamicNode prior = list;
        DynamicNode present = list.getNext();

        while (prior != null && present != null) {
            //alter link of prior node
            prior.next = present.getNext();

            //open up node
            present = null;

            ///update nodes
            prior = prior.getNext();
            if (prior != null)
                present = prior.getNext();
        }

        print();

    }

    public void print() {

        /*
        Create a new dynamic node list to reference the original list
        We do this so we don't mess up the original list's references
        when other operations are performed
         */
        DynamicNode list = this.list;

        /*
        While list is not null, print out the info
        contained in the list, then make list:DyanmicNode reference
        the next location in the DynamicNode list
         */
        while (list != null) {
            System.out.print(list.getInfo());
            list = list.getNext();
        }
        System.out.println();
    }

    //Reverse a list, so that the last element becomes the first, and so on
    public void reverseIteratively() {


        //initialize 3 DynamicNodes
        //current node references list
        //the other 2 reference nothing;
        DynamicNode currentNode = list;
        DynamicNode nextNode = null;
        DynamicNode priorNode = null;

        /*
        currentNode references list so we can alter currentNode
        without messing up list's references.

        While current node not null
            nextNode references the next node in currentNode's link
            currentNode then sets its next node as the previous node (
         */
        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(priorNode);
            priorNode = currentNode;
            currentNode = nextNode;
        }

        list = priorNode;
    }

    //Combine two ordered list into a single ordered list
    public void Concat(DynamicList x) {

        while (x.list != null) {

            insertLast(x.list.getInfo());
            x.list = x.list.getNext();

        }

    }

    //Returns the sum of the integers in a list
    public int SumList() {

        int sum = 0;

        //Iterate through DynamicList adding each element
        while (list != null) {

            IntData x = (IntData) list.getInfo();
            sum += x.getData();
            list = list.getNext();

        }
        return sum;
    }


    public boolean isEmpty() {
        return list == null;
    }


    public void insertFirst(Object x) {
        DynamicNode q = new DynamicNode(x, null);
        if (!isEmpty())
            q.setNext(list);
        list = q;
    }

    public void insertAfter(DynamicNode p, Object x) {
        if (p == null) {
            System.out.println("void insertion");
            System.exit(1);
        }

        DynamicNode q = new DynamicNode(x, p.getNext());
        p.setNext(q);
    }

    public Object deleteFirst() {
        if (isEmpty()) {
            System.out.println("void deletion");
            System.exit(1);
        }

        Object temp = list.getInfo();
        if (list.getNext() == null)
            list = null;
        else
            list = list.getNext();
        return temp;
    }

    public Object deleteAfter(DynamicNode p) {
        if (p == null || p.getNext() == null) {
            System.out.println("void deletion");
            System.exit(1);
        }

        DynamicNode q = p.getNext();
        Object temp = q.getInfo();
        p.setNext(q.getNext());
        return temp;
    }

    public void place(Sortable x) {
        DynamicNode p, q = null;
        for (p = list; p != null && x.compareTo(p.getInfo()) > 0; p = p.getNext())
            q = p;
        if (q == null)
            insertFirst(x);
        else
            insertAfter(q, x);

    }

    public void insertLast(Object x) {
        DynamicNode p = new DynamicNode(x, null);
        DynamicNode q = null;

        if (isEmpty())
            list = p;
        else {


            for (q = list; q.getNext() != null; q = q.getNext())
                ;

            q.setNext(p);

        }

    }

    public DynamicNode search(Object x) {
        DynamicNode p;
        for (p = list; p != null; p = p.getNext())
            if (p.getInfo().equals(x))
                return p;

        return null;
    } // end search

    public void removeX(Object x) {
        DynamicNode p = list, q = null;
        while (p != null) {
            if (p.getInfo().equals(x)) {
                p = p.getNext();
                if (q == null)
                    deleteFirst();
                else
                    deleteAfter(q);
            } else {
                // advance to the next node in the list
                q = p;
                p = p.getNext();
            }

        } // end while

    }// end removex


} // end dynamic list
