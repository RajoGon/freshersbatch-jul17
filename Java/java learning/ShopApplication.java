import java.util.Scanner;

abstract class DesertItem{
	public static  int totalitems;
	public static double tax;
	abstract public double getCost();
	public static  void addItemToStore(){};
	public static boolean removeItemFromStore(){return true;};
}

class Candy extends DesertItem{
	public static  int totalitems = 0;
	public static double tax=7;
	public double getCost(){
		return 100 + tax;
	}
	public static void addItemToStore(int quantity){
		totalitems = totalitems + quantity;
		System.out.println("Number of candies =," + totalitems);
	}
	public static boolean removeItemFromStore(int quantity){
		if(quantity < totalitems){
		totalitems = totalitems - quantity;	
		return true;
		}
		else{
		System.out.println("Sorry, only "+totalitems+ " candies are available.");
		return false;
		}
	}

}
class Cookie extends DesertItem{
	public static  int totalitems = 0;
	public static double tax=9;
	public double getCost(){
		return 150 + tax;
	}
	public static  void addItemToStore(int quantity){
		totalitems = totalitems + quantity;
		System.out.println("Number of cookies =," + totalitems);
	}
	public static boolean removeItemFromStore(int quantity){
		if(quantity < totalitems){
		totalitems = totalitems - quantity;	
		return true;
		}
		else{
		System.out.println("Sorry, only "+totalitems+ " cookies are available.");
		return false;
		}
		
	}
}

class IceCream extends DesertItem{
	public static  int totalitems = 0;
	public static double tax=11;
	public double getCost(){
		return 90 + tax;
	}
	public static void addItemToStore(int quantity){
		totalitems = totalitems + quantity;
		System.out.println("Number of ice creams =," + totalitems);
	}

	public static boolean removeItemFromStore(int quantity){
		if(quantity < totalitems){
		totalitems = totalitems - quantity;	
		return true;
		}
		else{
		System.out.println("Sorry, only "+totalitems+ " ice creams are available.");
		return false;
		}	
	}	
}


class ManageShop{
	public static double cost=0;
	public static void addItem(int itemchoice, int quantity){
		// Add items to store
		if(itemchoice==1){
			Candy.addItemToStore(quantity);
		}
		else if(itemchoice==2){
			Cookie.addItemToStore(quantity);
		}
		else if(itemchoice==3){
			IceCream.addItemToStore(quantity);	
		}
		else{
			System.out.println("Wrong input, try again");
		}
	}

	public static void getItem(int itemchoice, int quantity){

		Candy c = new Candy();
		Cookie e = new Cookie();
		IceCream i = new IceCream();
		boolean flag;
		//Remove items from store
		if(itemchoice==1){

			flag = Candy.removeItemFromStore(quantity);
			if(flag == true){
			cost =( quantity * c.getCost()) /60;
			System.out.println("You purchased "+quantity+" candies and total cost is "+cost+" dollars.");
			cost = 0 ;		
			}
			else{
				System.out.println("\n Try again");
			}

		}
		else if(itemchoice==2){
			flag = Cookie.removeItemFromStore(quantity);
			if(flag == true){
			cost =( quantity * c.getCost()) /70;
			System.out.println("You purchased "+quantity+" cookies and total cost is "+cost+" euros.");
			cost = 0 ;		
			}
			else{
				System.out.println("\n Try again");
			}
		}
		else if(itemchoice==3){
			flag = IceCream.removeItemFromStore(quantity);
			if(flag == true){
			cost =( quantity * c.getCost()) /1;
			System.out.println("You purchased "+quantity+" ice creams and total cost is "+cost+" rupees.");
			cost = 0 ;		
			}
			else{
				System.out.println("\n Try again");
			}
		}
		else{
			System.out.println("Wrong input, try again");
		}

	 }
}
//Main Shop entry point
 public class ShopApplication{
 	public static void main(String[] args) {
 		int choice;
		int itemchoice;
		int quantity;
		char again;
		Scanner scan = new Scanner(System.in);
		do{
		System.out.println(" ***** Menu*****");
		System.out.println("Enter choice");
		System.out.println("1.) Shopkeeper");
		System.out.println("2.) Customer");
		choice = scan.nextInt();
		switch (choice)
            {
				case 1: System.out.println("Which item to you want to add \n 1.) Candy \n 2.) Cookie \n 3.) Ice cream");
						itemchoice=scan.nextInt();
						System.out.println("Enter quantity");
						quantity=scan.nextInt();
						ManageShop.addItem(itemchoice,quantity);
						break;

				case 2: System.out.println("Which item to you want to buy \n 1.) Candy \n 2.) Cookie \n 3.) Ice cream");
						itemchoice=scan.nextInt();
						System.out.println("Enter quantity");
						quantity=scan.nextInt();
						ManageShop.getItem(itemchoice,quantity);
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