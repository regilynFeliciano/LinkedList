import java.util.*;

public class ListElement {
	private ListElement next;
	private ListElement prev; 	//for doubly linked
	private int data;

	public ListElement() {		//default constructor
		this.data = 0;
		this.next = null;
		this.prev = null;
	}

	public ListElement(int data) {	//constructor with data arg
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	/**
	 * Setters and getters for next and data
	 **/
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return this.data;
	}
	public void setNext(ListElement next) {
		this.next = next;
	}
	public ListElement getNext() {
		return this.next;
	}
	public void setPrev(ListElement prev) {
		this.prev = prev;
	}
	public ListElement getPrev() {
		return this.prev;
	}
}
