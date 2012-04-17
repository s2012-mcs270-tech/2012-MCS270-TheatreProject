package theatreProject.domain.shared;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;


public class Inventory {
	private ArrayList<InventoryObject> database;

	public Inventory(ArrayList<InventoryObject> database){
		this.database = database;
	}


	public ArrayList<InventoryObject> getDatabase() {
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
		String[] words = parameter.split(" ");
		for (InventoryObject obj : database) {
			if (obj.description.indexOf(words[0])!=-1 || obj.classification.equals(words[0])) {
				found.add(obj);
			}
		}
		if (words.length>1) {
			for (int i=1; i<words.length; i++) {	
				for (InventoryObject obj : found) {
					if ((obj.description.indexOf(words[i])==-1) || !obj.classification.equals(words[i])) {
						found.remove(obj);
					}
				}
			}
		}
		return found;
	}
}
