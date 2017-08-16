package com.collections;

import java.util.*;

class ChatRoom{
	String name;
	ArrayList<String> messageList = new ArrayList<String>();
	HashSet<String> users=new HashSet<String>(); 
	ChatRoom(String name){
		this.name = name;
		this.messageList.add("Default Message for chatroom, "+name);
	}
	public ArrayList<String> getMessages() {
		return this.messageList;		
	}
	public HashSet<String> getUsers() {
		return this.users;		
	}
	
	public void addUser(String username){	
		users.add(username);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	public void addMessage(String message) {
		this.messageList.add(message);
	}
}
public class ChatApp {

	public static void main(String[] args) {

		HashSet<ChatRoom> chatrooms=new HashSet<ChatRoom>();

		boolean logged = false;
		String currentUserLoggedIn=null;
				
		
		int choice;
		char again;
		String tempInput;
		String tempMessage;
		Scanner scan = new Scanner(System.in);
		Scanner scanmessage = new Scanner(System.in);
		do{
		System.out.println(" ***** Menu*****");
		System.out.println("Enter choice");
		System.out.println("1.) Create a Chatroom");
		System.out.println("2.) Add User");
		System.out.println("3.) User login");
		System.out.println("4.) Send Message");
		System.out.println("5.) Display the messages from a specific chatroom");
		System.out.println("6.) List down all users belonging to the specified chat room.");
		System.out.println("7.) Logout");
		System.out.println("8.) Delete a user");
		System.out.println("9.) Delete a chatroom");
		choice = scan.nextInt();
		switch (choice)
            {
				case 1:	System.out.println("Enter Chatroom name");
						tempInput = scan.next();					
						chatrooms.add(new ChatRoom(tempInput));
						System.out.println("Create new Chatroom, "+tempInput);
						break;
						
				case 2: System.out.println("In which chatroom do you want to register user? ");
						tempInput = scan.next();
						if(chatrooms!=null)		{	
							 for (ChatRoom obj : chatrooms) {
								 
							       if(obj.name.equals(tempInput)) {
							    	   System.out.println("In Chatroom : "+obj.name);
							    	   System.out.println("Enter username");
							    	   tempMessage = scan.next();
							    	   obj.addUser(tempMessage);
							    	   System.out.println("Added user, "+tempMessage);
							    	  
							       }else if(obj.name.equals(null)) {
							    	   System.out.println("No such chatroom");
							       }else {
							    	   System.out.println("No such chatroom");
							       }
						      } 
							}else {
								System.out.println("No chatrooms in database, make one.");
							}

						System.out.println("Created new user, "+tempInput);
						break;	
						
				case 3: if(logged==true) {
							System.out.println(currentUserLoggedIn+" is already logged in. Please logout first.");
							break;
						}
					
						System.out.println("Enter Chatroom user belongs too");
						tempInput = scan.next();
						
						for (ChatRoom obj : chatrooms) {
							 
						       if(obj.name.equals(tempInput)) {
						    	   System.out.println("Enter user name");
						    	   tempInput = scan.next();
						    	   if(obj.users.contains(tempInput) == true) {
										System.out.println("Logged in as, "+tempInput);
										currentUserLoggedIn = tempInput;
										logged = true;
									}else {
										System.out.println("No such user exists.");
									}
						    	  
						       }else {
						    	   System.out.println("No such chatroom");
						       }
					      } 

						break;	
				case 4: System.out.println("In which chatroom do you want to send message? ");
						tempInput = scanmessage.nextLine();

						if(chatrooms!=null)		{	
						 for (ChatRoom obj : chatrooms) {
							 
						       if(obj.name.equals(tempInput)) {
						    	   System.out.println("In Chatroom : "+obj.name);
						    	   System.out.println("Enter Message now");
						    	   tempMessage = scan.next();
						    	   obj.addMessage(tempMessage);
						    	   System.out.println("Added your message");
						    	  
						       }else {
						    	   System.out.println("No such chatroom");
						       }
					      } 
						}else {
							System.out.println("No chatrooms in database, make one.");
						}
						break;
						
				case 5: System.out.println("Which chatroom's messages do you want to read? ");
				tempInput = scan.next();
						ArrayList<String> currentMessages = new ArrayList<String>();
						 for (ChatRoom obj : chatrooms) {
						       if(obj.name.equals(tempInput)) {
						    	   currentMessages = obj.getMessages();
						    	   Iterator<String> itr = currentMessages.iterator();
						    	   System.out.println("Messages are");
						    	   while(itr.hasNext()) {
						    		   System.out.println(itr.next());
						    	   }
						       }else {
						    	   System.out.println("No such chatroom");
						       }
					      } 
						 
						break;
				case 6: System.out.println("Which chatroom's users do you want to see? ");
					tempInput = scan.next();
					HashSet<String> currentUsers=new HashSet<String>();
					for (ChatRoom obj : chatrooms) {
					       if(obj.name.equals(tempInput)) {
					    	   currentUsers = obj.getUsers();
					    	   Iterator<String> itr = currentUsers.iterator();
					    	   System.out.println("Registered users are,");
					    	   while(itr.hasNext()) {
					    		   System.out.println(itr.next());
					    	   }
					       }else {
					    	   System.out.println("No such chatroom");
					       }
				      } 
						break;
				case 7: System.out.println("Logging out, "+ currentUserLoggedIn);
						currentUserLoggedIn = null;
						logged = false;
						break;
				case 8: System.out.println("From which chatroom do you want to delete, user ");
						tempInput = scan.next();
						
						for (ChatRoom obj : chatrooms) {					 
						       if(obj.name.equals(tempInput)) {
						    	   System.out.println("Enter User you want to delete");
						    	   tempInput = scan.next();
						    	   if(obj.users.contains(tempInput) == true) {
										obj.users.remove(tempInput);
										System.out.println("Removed user, "+tempInput);
										if(logged==true) {		
											System.out.println("Since "+currentUserLoggedIn+" was logged in, we have logged him out.");
											currentUserLoggedIn = null;
											logged = false;
											
										}
									}else {
										System.out.println("No such user exists.");
									};
						    	  
						       }else {
						    	   System.out.println("No such chatroom");
						       }
					      } 
						break;
				case 9:	System.out.println("Which chatroom do you want to delete?");
						tempInput = scan.next();						
						for (ChatRoom obj : chatrooms) {					 
						       if(obj.name.equals(tempInput)) {						    	   
						    	  chatrooms.remove(obj);
						    	  System.out.println("Removed, "+obj.name);
						       }else {
						    	   System.out.println("No such chatroom");
						       }
					      } 
						break;
				default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
		System.out.println("\nDo you want to continue ? ");
		again = scan.next().charAt(0);   
		}while(again == 'Y'|| again == 'y');
		scan.close();
		scanmessage.close();
	}

}
