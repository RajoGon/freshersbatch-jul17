import java.util.Scanner;
import java.util.*;  

abstract class DesertItem{

	abstract public double getCost();

}

class Candy extends DesertItem{
	
	public static double tax=7;
	public double getCost(){
		return 100 + tax;
	}
}

class Cookie extends DesertItem{
	
	public static double tax=7;
	public double getCost(){
		return 200 + tax;
	}
}

class IceCream extends DesertItem{
	
	public static double tax=7;
	public double getCost(){
		return 90 + tax;
	}
}


class ManageShop{
		private static ManageShop manage = new ManageShop( );
		private ManageShop(){}
		public static ManageShop getInstance( ) {
      	return manage;
   		}

		private static ArrayList<Candy> candies=new ArrayList<Candy>();
 		private static ArrayList<Cookie> cookies=new ArrayList<Cookie>();
 		private static ArrayList<IceCream> icecreams=new ArrayList<IceCream>();
 		private static double totalcost=0.0;

 		public void addCandies(int quantity){
 			Candy c[] = new Candy[quantity];
			for(int i=0 ; i<c.length ; i++){
			candies.add(c[i]);
			}
			System.out.println(quantity+" candies added. Total candies are, "+candies.size());
 		}

 		public void addCookies(int quantity){
 			Cookie e[] = new Cookie[quantity];
			for(int i=0 ; i<e.length ; i++){
			cookies.add(e[i]);
			}
			System.out.println(quantity+" cookies added. Total cookies are, "+cookies.size());
 		}

 		public void addIceCream(int quantity){
 			IceCream ice[] = new IceCream[quantity];
			for(int i=0 ; i<ice.length ; i++){
			icecreams.add(ice[i]);
			}
			System.out.println(quantity+" ice creams added.Total ice creams are,"+icecreams.size());
 		}

 		public void removeCandies(int quantity){
 			for (int i=0 ; i<quantity ; i++) {
    			candies.remove(0);
				}
				System.out.println("You purchased, "+quantity+" candies, now only"+candies.size()+" remain.\n");

 		}
 		public void removeCookies(int quantity){
 			for (int i=0 ; i<quantity ; i++) {
    			cookies.remove(0);
				}
				System.out.println("You purchased, "+quantity+" cookies, now only"+cookies.size()+" remain.\n");
 		}

		public void removeIceCreams(int quantity){
 			for (int i=0 ; i<quantity ; i++) {
    			icecreams.remove(0);
				}
				System.out.println("You purchased, "+quantity+" ice creams, now only"+icecreams.size()+" remain.\n");
 		}



}

//Main Shop entry point
 public class ShopApplicationTwo{

 	public static void main(String[] args) {

 		ManageShop manage = ManageShop.getInstance( );
 		Candy c = new Candy();
 		Cookie e = new Cookie();
 		IceCream ice = new IceCream();


 		int choice;
		int itemchoice;
		int quantity;
		char again;
		int totalcost = 0;
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
						
						if(itemchoice == 1){
							manage.addCandies(quantity);
						}
						else if(itemchoice == 2){
							manage.addCookies(quantity);
						}
						else if(itemchoice == 3){
							manage.addIceCream(quantity);
						}
						else{
							System.out.println("Wrong input\n");
						}

						break;

				case 2: System.out.println("Which item to you want to buy \n 1.) Candy \n 2.) Cookie \n 3.) Ice cream");
						itemchoice=scan.nextInt();
						System.out.println("Enter quantity");
						quantity=scan.nextInt();
						
						if(itemchoice == 1){
							manage.removeCandies(quantity);
							System.out.println("\nTotal cost = "+(c.getCost()/60)*quantity+" dollars");
							
						}
						else if(itemchoice == 2){
							manage.removeCookies(quantity);
							System.out.println("\nTotal cost = "+e.getCost()/70*quantity+" euros");
						}
						else if(itemchoice == 3){
							manage.removeIceCreams(quantity);
							System.out.println("\nTotal cost = "+ice.getCost()/1*quantity+" rupees");
						}
						else{
							System.out.println("Wrong input\n");
						}


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