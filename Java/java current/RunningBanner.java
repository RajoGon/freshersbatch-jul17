package banner;
public class RunningBanner{
	static StringBuilder st1 =new  StringBuilder("Welcome to Java ");
	public static void main(String[] args) {
		char ch;
		for(int i=0;;i++){
			ch = st1.charAt(0);
			st1.deleteCharAt(0); 
			st1 = st1.append(ch);
			try{
  				Thread.sleep(50);
				}catch(InterruptedException ex){
 					 //do stuff
				}
			System.out.print(st1 +"\r");
		}
	}
}