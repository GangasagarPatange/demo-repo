import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CoffeeMakerTest {

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
	public void addRecipe() {
		java.lang.String recipeName = "Dark Roast";
		int milkLevel = 2;
		int sugarLevel = 3;
		int coffeeLevel = 4;
		
		CoffeeMaker testCoffeeMaker = new CoffeeMaker();
		Recipe testRecipe = new Recipe(recipeName, milkLevel, sugarLevel, coffeeLevel);
		
		assertEquals(recipeName, testRecipe.getName());
		assertEquals(coffeeLevel, testRecipe.getCoffeeLevel());
		assertEquals(sugarLevel, testRecipe.getSugarLevel());
		assertEquals(milkLevel, testRecipe.getMilkLevel());
		
		if (!testCoffeeMaker.addRecipe(testRecipe))
			fail("Recipe not Added");
		
		assertNotNull(testCoffeeMaker.getRecipe(recipeName));
	}
	
	@Test
	public void makeCoffee() {
		java.lang.String recipeName = "Dark Roast";
		int milkLevel = 2;
		int sugarLevel = 3;
		int coffeeLevel = 4;
		
		CoffeeMaker testCoffeeMaker = new CoffeeMaker();
		Recipe testRecipe = new Recipe(recipeName, milkLevel, sugarLevel, coffeeLevel);
		
		if (!testCoffeeMaker.addRecipe(testRecipe))
			fail("Recipe not Added");
		
		if(!testCoffeeMaker.makeCoffee(testRecipe.getName()))
			fail("Coffee not Made");
		
		// Ensures inventory is updated
		assertEquals(testCoffeeMaker.MAX_INVENTORY - coffeeLevel, testCoffeeMaker.getInventory().getCoffee());
		assertEquals(testCoffeeMaker.MAX_INVENTORY - sugarLevel, testCoffeeMaker.getInventory().getSugar());
		assertEquals(testCoffeeMaker.MAX_INVENTORY - milkLevel, testCoffeeMaker.getInventory().getMilk());
	}
	
	@Test
	public void deleteRecipe() {
		java.lang.String recipeName = "Dark Roast";
		int milkLevel = 2;
		int sugarLevel = 3;
		int coffeeLevel = 4;
		
		CoffeeMaker testCoffeeMaker = new CoffeeMaker();
		Recipe testRecipe = new Recipe(recipeName, milkLevel, sugarLevel, coffeeLevel);
		
		if (!testCoffeeMaker.addRecipe(testRecipe))
			fail("Recipe not Added");
		if (!testCoffeeMaker.deleteRecipe(testRecipe.getName()))
			fail("Recipe not Deleted");
	}
}
