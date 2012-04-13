import java.sql.DatabaseMetaData;
import java.util.ArrayList;


public class inventory {
	
	private ArrayList<inventoryObject> database;

	public ArrayList<inventoryObject> getDatebase() {
		return database;
	}

	public void setDatabase(ArrayList<inventoryObject> database) {
		this.database = database;
	}
	
	public void add(inventoryObject obj) {
		database.add(obj);
	}
	
	public void remove(inventoryObject obj) {
		if (database.contains(obj)) {
			database.remove(obj);
			}
		else System.out.println("Wrong!");
	}
	
	
	public ArrayList<inventoryObject> search(String parameter) {
		
		ArrayList<inventoryObject> found = new ArrayList<inventoryObject>(); 
		for (obj in database) {
			
		}
	}
	
	
	
}
