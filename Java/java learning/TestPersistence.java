abstract class Persistance{
	abstract public void persist();
}

class FilePersistence extends Persistance{
	public void persist(){
		System.out.println("Persisting File");
	}
}
class DatabasePersistence extends Persistance{
	public void persist(){
		System.out.println("Persisting Database");
	}
}
class PersistanceFactory{
	public static DatabasePersistence getPersistance(){
		return new DatabasePersistence();
	}
}
public class TestPersistence{
	public static void main(String[] args) {
		Persistance P = PersistanceFactory.getPersistance();
		P.persist();
	}
}