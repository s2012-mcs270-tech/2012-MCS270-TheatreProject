import static org.junit.Assert.assertEquals;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import theatreProject.shared.Status;
import theatreProject.server.PersistenceImpl;
import theatreProject.shared.InventoryObject;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;



public class InventoryTest {
	
	 	ArrayList<InventoryObject> listdata	  = new ArrayList<InventoryObject>();
		ArrayList<InventoryObject> testsearch = new ArrayList<InventoryObject>();	 	
		Image pic = null;
	//	Status checkedIn = new Status(null, "warehouse", null, null,null);
	//	Status checkedOut = new Status(null,"elsewhere", null, null,null);
		//object #; # refers to the number in its description
		InventoryObject object1;// = new InventoryObject("", "object", "backroom", null, checkedOut, "1", "");
//		InventoryObject object2 = new InventoryObject("", "object", "backroom", null, checkedIn, "2", "");
//		InventoryObject object3 = new InventoryObject("", "object", "backroom", null, checkedOut, "3", "");
//		InventoryObject object12 = new InventoryObject("", "object", "storage", null, null,"1 2", "");
//		InventoryObject object123 = new InventoryObject("", "object", "storage", null, null, "1 2 3", "");
//		InventoryObject object23  = new InventoryObject("", "object", "storage", null, null, "1 2 3", "");
//		InventoryObject object13 = new InventoryObject("", "object", "storage", null, null,"1 3", "");
		
		
		
		@Before
	public void clear() {									//Reinitialize database and testsearch
		listdata = new ArrayList<InventoryObject>();
		testsearch = new ArrayList<InventoryObject>();
	}

		private final LocalServiceTestHelper helper =
				new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

		@Before
		public void setUp() {
			helper.setUp();
		//	object1 = new InventoryObject("ID1", "object", "backroom", null, checkedOut, "1", "");
		}

		@After
		public void tearDown() {
			helper.tearDown();
		}


		
		
	@Test
	public void searchFindOneInDescription() {				//Find one object with only one parameter
		
										//found parameter is the first word in description
		testsearch.add(object1);
		assertEquals(testsearch, (new PersistenceImpl()).search("1"));	
	}
	
//	@Test
//	public void searchFindOneObjectWithTwoWords() { 		 //Find one object with only one parameter
//		database.add(object12);								 //found parameter is the first word in description
//		database.add(object2);
//		testsearch.add(object12);
//		assertEquals(testsearch, database.search("1 2"));
//		}
//	
//	@Test
//	public void searchFindOneBeyondFirstWord() { 			  //Find one object with only one parameter
//		database.add(object12);							   	  //found parameter is the second word in description
//		testsearch.add(object12);
//		assertEquals(testsearch, database.search("2"));
//	}
//	@Test
//	public void searchFindTwoObjectsWithOneWord() {			  //Find two objects with only one parameter
//		database.add(object1);								  //found parameter is the first word in description
//		database.add(object12);
//		testsearch.add(object1);
//		testsearch.add(object12);
//		assertEquals(testsearch, database.search("1"));
//	}
//	@Test
//	public void searchFindTwoObjectsWithTwoWords() {		  //Find two objects with two parameters
//		database.add(object12);								  //found parameters are the first two in description
//		database.add(object123);
//		testsearch.add(object12);
//		testsearch.add(object123);
//		assertEquals(testsearch, database.search("1 2"));
//	}
//	@Test
//	public void searchFindOneObjectWithThreeWords() {		  //Find one object with only one parameter
//		database.add(object123);							  //found parameter is the first three in description
//		testsearch.add(object123);
//		assertEquals(testsearch, database.search("1 2 3"));
//	}
//	@Test
//	public void searchFindTwoObjectWithTwoWordsBeyondFirstWord() { //Find two objects with two parameters
//		database.add(object23);									   //found parameters are beyond the first in description
//		database.add(object123);
//		testsearch.add(object23);
//		testsearch.add(object123);
//		assertEquals(testsearch, database.search("2 3"));
//	}
//	@Test
//	public void searchFindThreeObjectsWithOneWord() {			  //Find three objects with one parameter
//		database.add(object1);									  //found parameter is the first in description
//		database.add(object12);								  
//		database.add(object123);
//		testsearch.add(object1);
//		testsearch.add(object12);
//		testsearch.add(object123);
//		assertEquals(testsearch, database.search("1"));
//		
//	}
//	
//	@Test
//	public void searchcheckOutList() {
//		database.add(object1);
//		database.add(object2);
//		database.add(object3);
//		testsearch.add(object1);
//		testsearch.add(object3);
//		assertEquals(testsearch, database.checkOutList());
}
