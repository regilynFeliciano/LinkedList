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
 
        System.out.println("Print list: ");
        myList.PrintList();
        System.out.println("Get 3rd element: " + myList.getElement(3).getData());
        System.out.println("Delete 2nd element: " + myList.deleteElement(2).getData());
        System.out.println("Get 3rd element: " + myList.getElement(3).getData());
        System.out.println("Print list: ");
        myList.PrintList();
    }
}

class LinkedList {
	private ListElement head;
	private ListElement currPtr;
	private ListElement temp;
	private int numList;

	//constructor for empty linked list
	public LinkedList() {
		head = new ListElement();
		numList = 0;
	}

	//method to insert an element into list
	public void addElement(int le) {
		temp = new ListElement(le);
		currPtr = head;
		//move currPtr to end of linked list and insert there
		while (currPtr.getNext() != null) {
			currPtr = currPtr.getNext();
		}
		currPtr.setNext(temp);		//append new list element at end
		numList++;					//increase number of list elements
	}

	public ListElement getElement(int index) {
		if (index <= 0)
			return null;			//index must be larger than 0
		currPtr = head.getNext();	//start at beginning
		//
		for (int i=1; i<=index; i++) {
			if (currPtr.getNext() == null) {
				return null;		//return null if index is higher than numList
			}
			//inc currPtr unless index is beyond scope of linked list
			currPtr = currPtr.getNext();
		}
		return currPtr;	//return data of currPtr once at index
	}

	public ListElement deleteElement(int index) {
		//ListElement del = new ListElement(null);
		if (index <=0)
			return null;			//index must be larger than 0
		currPtr = head; 	//start just before beginning
		for (int i=1; i<=index; i++) {
			if (currPtr.getNext() == null) {
				return null;		//return null if index>numList
			}
			//inc currPtr unless index is > than numList
			currPtr = currPtr.getNext();
		}
		temp = currPtr.getNext();	//store deleting value to temp
		//link the nodes on either side of deleted node
		currPtr.setNext(currPtr.getNext().getNext());
		numList--;					//dec number of list elements
		return temp;
	}

	public void PrintList() {
		currPtr = head.getNext();	//start at beginning of list
		String list = "";
		while (currPtr != null) {
			list += currPtr.getData() + " ";
			currPtr = currPtr.getNext();
		}
		//display list on console
      System.out.println("Linked List: " + list);
	}
}
