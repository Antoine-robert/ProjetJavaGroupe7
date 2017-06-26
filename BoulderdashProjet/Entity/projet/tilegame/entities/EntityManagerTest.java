package projet.tilegame.entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.javafx.geom.Rectangle;

import projet.tilegame.Handler;
import projet.tilegame.entities.creatures.Player;

public class EntityManagerTest {
	private Handler handler;
	private EntityManager entityManager;
	private Player player;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.entityManager = new EntityManager(handler, player);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
