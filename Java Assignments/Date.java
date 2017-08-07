
class DateSwapper
{
   Date c;
   DateSwapper(Date c){
	   this.c = c;
	}
}

public class Date{
	private int day;
	private int month;
	private int year;
	//Default Constructor
	public Date(){
		this.day=02;
		this.month = 06;
		this.year=2008;
	}
	// Parametrized Constructor
	public Date(int day,int month,int year){
		this.day=day;
		this.month = month;
		this.year= year;
	}
	// Getters
	public int getDay(){
		return this.day;
		//System.out.println(this.day+"-"+this.month+"-"+this.year);
	}
	public int getMonth(){
		return this.month;
	
	}
	public int getYear(){
		return this.year;
	}
	// Setters
	public void setDay(int day){
		this.day=day;
	}
	public void setMonth(int month){
		this.month=month;
	}
	public void setYear(int year){
		this.year=year;
	}
	public static void swap(DateSwapper s2, DateSwapper s1){	
		Date temp = s2.c;
		s2.c = s1.c;
		s1.c= temp;
		
	}
	public String toString(){
		return this.day+"-"+this.month+"-"+this.year;
	}
	
	public static void main(String args[]){
		
		Date d = new Date();
		System.out.println("Using default constructor, d = "+d);
		Date d2 = new Date(5,10,2010);
		System.out.println("Using parametrized constructor, d2 = "+d2);	
		Date d3 = new Date();
		d3.setDay(11);
		d3.setMonth(12);
		d3.setYear(2017);
		DateSwapper ds2 = new DateSwapper(d2);
		DateSwapper ds3 = new DateSwapper(d3);
		System.out.println("Using setter constructor, d3 = "+d3);
		System.out.println("Before swap , d2 = "+ds2.c);
		System.out.println("Before swap , d3 = "+ds3.c);		
		swap(ds2,ds3);
		System.out.println("After swap , d2 = "+ds2.c);
		System.out.println("After swap , d3 = "+ds3.c);

		
	}
}