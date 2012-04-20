import static org.junit.Assert.assertEquals;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import theatreProject.domain.shared.Inventory;
import theatreProject.domain.shared.InventoryObject;
import theatreProject.domain.shared.Status;


public class InventoryTest {
	
	 	ArrayList<InventoryObject> listdata	  = new ArrayList<InventoryObject>();
		ArrayList<InventoryObject> testsearch = new ArrayList<InventoryObject>();	 	
		Inventory database = new Inventory(listdata);
		Image pic = null;
		Status stat = null;
		InventoryObject chair1 = new InventoryObject("Blue Chair", "backroom", null, null, "neat like");
		InventoryObject chair2 = new InventoryObject("Blue Chair", "backroom", null, null, "neat full");
		InventoryObject box = new InventoryObject("Green Box", "storage", null, null,"cool");
		InventoryObject table = new InventoryObject("Pink Table", "storage", null, null, "baller");
	
		@Before
	public void clear() {									//Reinitialize database and testsearch
		listdata = new ArrayList<InventoryObject>();
		testsearch = new ArrayList<InventoryObject>();
	}
	@Test
	public void searchFindTwoInDescription() {			
		database.add(chair1);
		database.add(chair2);
		testsearch.add(chair1);
		assertEquals(testsearch, database.search("neat like"));
		}	
	@Test
	public void searchFindOneInDescription() {				//Test search method on object description
		database.add(chair1);
		testsearch.add(chair1);
		assertEquals(testsearch, database.search("neat"));	
	}
	

	
}

