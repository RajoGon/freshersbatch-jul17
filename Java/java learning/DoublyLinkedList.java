import java.util.Scanner;
//Class to create the nodes
class Node{
	Node prev;
	int data;
	Node next;
	public Node(){
		//System.out.println("Linked list started ");
        next = null;
        prev = null;
        data = 0;
    }
}

// Class to create and manage the linked list
public class DoublyLinkedList{
	public static Node temp;
	public static Node start;
	public static int count=0;
	public int insertpos;
	/* public addNode(){
		Node s = new Node();
	}  */
	public void addHeadNode(){
		System.out.println("Head node added");
		Node head = new Node();
		temp = head;
		start = head;
	}
	public void addNode(int val){
		System.out.println("Node added with val, "+val);
		Node createnewnode = new Node();
		createnewnode.data=val;
		temp.next = createnewnode;
		createnewnode.prev = temp;
		temp = createnewnode;
		count++;
	}
	public void insertNode(int pos, int val){
		Node tempinsert = start;
		for(insertpos=0;insertpos<pos;insertpos++)
		{
			tempinsert = tempinsert.next;
		}
		Node createnewnode = new Node();
		createnewnode.data=val;
		createnewnode.next=tempinsert.next;
		tempinsert.next.prev = createnewnode;
		tempinsert.next = createnewnode;	
		createnewnode.prev = tempinsert;
		count++;
	}
	public void printLinkedList(){
		Node traverse = new Node();
		traverse = start.next;
		for(int i=0;i<count;i++)
		{
			System.out.print(traverse.data+"->");
			traverse=traverse.next;
		}
	}
	public void deleteNode(int pos){
		Node tempinsert = start;
		for(insertpos=0;insertpos<pos;insertpos++)
		{
			tempinsert = tempinsert.next;
		}
		tempinsert.next.prev=tempinsert.prev;
		tempinsert.prev.next= tempinsert.next;
		count--;
	}
	public static void main(String args[]){
		DoublyLinkedList a = new DoublyLinkedList();
		a.addHeadNode();
		int choice;
		int dataentry;
		int position;
		char again;
		Scanner scan = new Scanner(System.in);
		do{
		System.out.println(" ***** Menu*****");
		System.out.println("Enter choice");
		System.out.println("1.) Add node");
		System.out.println("2.) Insert node at specific position");
		System.out.println("3.) Delete node");
		System.out.println("4.) Count nodes");
		System.out.println("5.) Print Linked list");
		choice = scan.nextInt();
		switch (choice)
            {
				case 1: System.out.println("Enter data");
						dataentry=scan.nextInt();
						a.addNode(dataentry);
						break;
				case 2: System.out.println("Enter position");				
						position = scan.nextInt();
						position--;
						System.out.println("Enter data");
						dataentry=scan.nextInt();
						a.insertNode(position,dataentry);
						break;						
				case 3: System.out.println("Enter position to delete");				
						position = scan.nextInt();						
						a.deleteNode(position);
						break;
				case 4: System.out.println("\nTotal Nodes are, "+count);
						break;
				case 5: a.printLinkedList();	
						break;
				
				default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
		System.out.println("\nDo you want to continue ? ");
		again = scan.next().charAt(0);   
		}while(again == 'Y'|| again == 'y');  
		
		
	}
}