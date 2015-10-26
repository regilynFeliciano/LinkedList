import java.util.*;

public class LinkedListTest {
 
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
 
        // add elements to LinkedList
        myList.addElement(9);
        myList.addElement(4);
        myList.addElement(7);
        myList.addElement(3);
        myList.addElement(2);
 
        /*
         * Please note that primitive values can not be added into LinkedList
         * directly. They must be converted to their corresponding wrapper
         * class.
         */
 
        System.out.println("Print list from head: ");
        myList.PrintListHead();
        System.out.println("Print list from tail: ");
        myList.PrintListTail();
        System.out.println("Get 3rd element: " + myList.getElement(3).getData());
        System.out.println("Delete 2nd element: " + myList.deleteElement(2).getData());
        System.out.println("Get 3rd element: " + myList.getElement(3).getData());
        System.out.println("Print list from head: ");
        myList.PrintListHead();
        System.out.println("Print list from tail: ");
        myList.PrintListTail();
    }
}

class LinkedList {
	private ListElement head;
	private ListElement tail;
	private ListElement currPtr;
	private ListElement prevPtr;
	private ListElement temp;
	private int numList;

	//constructor for empty linked list
	public LinkedList() {
		head = new ListElement();
		tail = new ListElement();
		head.setNext(tail);
		tail.setPrev(head);
		numList = 0;
	}

	//method to insert an element into list
	public void addElement(int le) {
		temp = new ListElement(le);
		currPtr = head;
		//move currPtr to end of linked list and insert there
		while (currPtr.getNext() != tail) {
			currPtr = currPtr.getNext();
		}

		temp.setPrev(currPtr);		//connect temp's prev as currPtr
		temp.setNext(tail);			//connect temp's next as tail
		currPtr.setNext(temp);		//connect currPtr's next as temp
		tail.setPrev(temp);			//connect tail's prev as temp

		numList++;					//increase number of list elements
	}

	public ListElement getElement(int index) {
		if (index <= 0)
			return null;			//index must be larger than 0
		currPtr = head.getNext();	//start at beginning
		//
		for (int i=1; i<=index; i++) {
			if (currPtr.getNext() == tail) {
				return null;		//return null if index is higher than numList
			}
			//inc currPtr unless index is beyond scope of linked list
			currPtr = currPtr.getNext();
		}
		return currPtr;	//return data of currPtr once at index
	}

	public ListElement deleteElement(int index) {
		ListElement del = new ListElement();
		if (index <=0)
			return null;			//index must be larger than 0
		currPtr = head; 	//start just before beginning
		for (int i=1; i<=index; i++) {
			if (currPtr.getNext() == tail) {
				return null;		//return null if index>numList
			}
			//inc currPtr unless index is > than numList
			prevPtr = currPtr;
			currPtr = currPtr.getNext();
		}
		del = currPtr.getNext();	//store deleting value to temp
		temp = currPtr.getNext().getNext();
		//link the nodes on either side of deleted node
		currPtr.setNext(temp);
		temp.setPrev(currPtr);

		numList--;					//dec number of list elements
		return del;
	}

	public void PrintListHead() {
		currPtr = head.getNext();	//start at beginning of list
		String list = "";
		while (currPtr != tail) {
			list += currPtr.getData() + " ";
			currPtr = currPtr.getNext();
		}
		//display list on console
      System.out.println("Linked List: " + list);
	}

	public void PrintListTail() {
		currPtr = tail.getPrev();	//start at end of list
		String list = "";
		while (currPtr != head) {
			list += currPtr.getData() + " ";
			currPtr = currPtr.getPrev();
		}

		//display list on console
        System.out.println("Linked List: " + list);
	}
}
