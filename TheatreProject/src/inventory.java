import java.sql.DatabaseMetaData;
import java.util.ArrayList;


public class Inventory {
	private ArrayList<InventoryObject> database;
	
	public Inventory(ArrayList<InventoryObject> database){
		this.database = database;
	}
	
	
	public ArrayList<InventoryObject> getDatebase() {
		return database;
	}
    
	public void setDatabase(ArrayList<InventoryObject> database) {
		this.database = database;
	}
	
	public void add(InventoryObject obj) {
		database.add(obj);
	}
	
	public void remove(InventoryObject obj) {
		if (database.contains(obj)) {
			database.remove(obj);
        }
		else System.out.println("Wrong!");
	}
	
	
	public ArrayList<InventoryObject> search(String parameter) {
		
		ArrayList<InventoryObject> found = new ArrayList<InventoryObject>(); 
		for (obj in database) {
			
		}
	}
	
	
	
}
