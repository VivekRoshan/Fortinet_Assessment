/**
 * Resolution: reverse(Node head) -> Iterate trough the linked list. 
 * In loop, change next to prev, prev to current and current to next.
 * 
 *Time Complexity: O(N) where N is the size of the linkedlist.
 *Space Complexity: O(N) where N is the size of the linkedlist.
 */
package problem_1_2_3;

import org.junit.Test;

import static org.junit.Assert.*;


//definintion of a Node is already given
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
//custom class for reversing a linkedlist
public class ReversingAlinkedList {
	Node head;
	public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
	//to insert into a linked list
	public Node Insert(Node head, int data)
	{
		Node temp = head;
	    Node addition = new Node(data);
	    if(temp != null)
	    {
	        while(temp.next != null)
	        {
	            temp = temp.next;
	        }
	    }
	    temp.next = addition;
	    addition.next = null;
	    return head;
	}
 
    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    @Test
	public void testReverse1(){
		ReversingAlinkedList list = new ReversingAlinkedList();
		list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        
        //another list same as list is created in order to compare the reversed list with original.
        //list2 is like a temp variable for comparison
        ReversingAlinkedList list2 = new ReversingAlinkedList();
        list2.head = new Node(1);
        list2.head.next = new Node(2);
        list2.head.next.next = new Node(3);
        list2.head.next.next.next = new Node(4);
        list.head = list.reverse(list.head);
        list.printList(list.head);
        System.out.println();
        list2.printList(list2.head);
        //matching the first ith element of list2 with n-ith element of list
        assertEquals(list2.head.data, list.head.next.next.next.data );
        assertEquals(list2.head.next.data, list.head.next.next.data );
        assertEquals(list2.head.next.next.data, list.head.next.data );
        assertEquals(list2.head.next.next.next.data, list.head.data );
	}
    //if the lists are completely empty including head is null
    @Test
	public void testReverse2(){
		ReversingAlinkedList list = new ReversingAlinkedList();
        //another list same as list is created in order to compare the reversed list with original.
        //list2 is like a temp variable for comparison
        ReversingAlinkedList list2 = new ReversingAlinkedList();
        list.head = list.reverse(list.head);        
        //matching the first ith element of list2 with n-ith element of list
        assertNull(list.head); 
        assertNull(list2.head);
        assertEquals(list2.head, list.head);   
	}
    //list has only 1 element.
    @Test
	public void testReverse3(){
		ReversingAlinkedList list = new ReversingAlinkedList();
		list.head = new Node(1);
        //another list same as list is created in order to compare the reversed list with original.
        //list2 is like a temp variable for comparison
        ReversingAlinkedList list2 = new ReversingAlinkedList();
        list2.head = new Node(1);        
        list.head = list.reverse(list.head);
        //matching the first ith element of list2 with n-ith element of list
        assertNotNull(list.head); 
        assertNotNull(list2.head);
        assertEquals(list2.head.data, list.head.data);   
	}
    

    public static void main(String[] args) {
        ReversingAlinkedList list = new ReversingAlinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
        
        ReversingAlinkedList list1 = new ReversingAlinkedList();
        Node head1 = new Node(1);
        head1 = list1.Insert(head1, 2);
        head1 = list1.Insert(head1, 3);
        head1 = list1.Insert(head1, 4);
        System.out.println();
        list1.printList(head1);
        head1 = list1.reverse(head1);
        System.out.println();
        list1.printList(head1);
        System.out.println();
        
        System.out.println("Given Linked list");
        list.printList(list.head);
        list.head = list.reverse(list.head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(list.head);
    }
}
	

