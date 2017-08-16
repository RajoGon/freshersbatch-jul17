interface Printable{
	public void printMe();
}
class Employee implements Printable{
	public void printMe(){
		System.out.println("I am an employee");
	}

}
class Circle implements Printable{
	public void printMe(){
	System.out.println("I am a circle");

	}
}
