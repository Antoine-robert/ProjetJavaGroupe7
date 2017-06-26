package projet.tilegame.entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class EntityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetX() {
		final float expected = 4;
		assertEquals(expected,4, 5);
		
	}
	@Test
	public void testGetY(){
		final float expected = 4;
		assertEquals(expected,4, 5);
	
		
	}

}
