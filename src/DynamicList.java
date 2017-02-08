//4737
//Assignment #2
//COP 3530

public class DynamicList {

    private DynamicNode list;
    private int size;


    public DynamicList() {
        list = null;
        size = 0;
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
