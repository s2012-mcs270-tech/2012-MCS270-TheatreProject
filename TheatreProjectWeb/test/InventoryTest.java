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


	@Before
	public void createInventory() {
		Inventory database = new Inventory(null);
		ArrayList<InventoryObject> testsearch = new ArrayList<InventoryObject>();
		Image pic = new Image();
		Status stat = null;
		InventoryObject chair1 = new InventoryObject("Blue Chair", "backroom", pic, stat, "chair like", "neat like");
		InventoryObject chair2 = new InventoryObject("Blue Chair", "backroom", pic, stat, "chair full", "neat full");
		InventoryObject box = new InventoryObject("Green Box", "storage", null, null, "boxxy","cool");
		InventoryObject table = new InventoryObject("Pink Table", "storage", null, null, "cool", "baller");
	}
	
	
	@Test
	public void searchFindOneInDescription {				//Test search method on object description
		database.add(chair1);
		testsearch.add(chair1);
		assertEquals(testsearch, database.search("chair"));	
	}

	public void searchFindOneInClassification {				//Test search method on object classification
		database.add(chair1);
		testsearch.add(chair1);
		assertEquals(testsearch, database.search("neat"));
	}

	public void searchFindTwoInDescription {
		database.add(chair1);
		database.add(chair2);
		testsearch.add(chair1);
		assertEquals(testsearch, database.search("neat like"));
	}
