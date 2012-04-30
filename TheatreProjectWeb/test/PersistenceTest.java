import static org.junit.Assert.*;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import theatreProject.server.PersistenceImpl;
import theatreProject.shared.Persistence;
import theatreProject.domain.shared.User;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class PersistenceTest {

	private final LocalServiceTestHelper helper =
			new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	@Before
	public void setUp() {
		helper.setUp();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void testUser() {
		Persistence p = new PersistenceImpl();
		User u = new User();
		u.setAdmin(true);
		u.setEmail("test@somewhere.com");
		u.setExtraInfo("something");
		u.setName("J Doe");
		p.saveUser(u);
		User u2 = p.getUser(u.getEmail());
		assertEquals(u, u2);
	}

}
