public class SingleTon{
	private SingleTon(){
		System.out.println("Created Singleton class");
	}
	public static void main(String args[]){
		SingleTon a = new SingleTon();
	}
}
class InheritSingleton extends SingleTon{

	public InheritSingleton(){
		System.out.println("Inheriting SingleTon");
	}
	public static void main(String args[]){
		InheritSingleton a = new InheritSingleton();
	}
}