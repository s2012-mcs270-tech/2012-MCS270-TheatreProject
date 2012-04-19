import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import theatreProject.domain.shared.Inventory;
import theatreProject.domain.shared.InventoryObject;


public class InventoryTest {
	
	@Before
	public void createInventory() {
		Inventory database = new Inventory(null);
		InventoryObject chair = new InventoryObject("Blue Chair", "backroom", null, null, "chair like", "neat");
		InventoryObject box = new InventoryObject("Green Box", "storage", null, null, "boxxy","cool");
		InventoryObject table = new InventoryObject("Pink Table", "storage", null, null, "cool", "neat");
	}
	
	
	@Test
	public void add() {
		database.add(chair); 
		
		
	}
	
	
	
}
