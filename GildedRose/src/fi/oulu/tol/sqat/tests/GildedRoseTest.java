package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {
	private final PrintStream sysOutput = System.out;
	private final ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();

	@Test
	public void testTheTruth() {
		
		assertTrue(true);
	}

	@Test
	public void testMain() {
		System.setOut(new PrintStream(byteOutputStream));
		
		GildedRose.main(null);
		assertEquals("OMGHAI!", byteOutputStream.toString().trim());
		
		System.setOut(sysOutput);
	}
	
	@Test 
	public void testUpdateQuality() {
		GildedRose inn = new GildedRose();
		
		inn.setItem(new Item("+5 Dexterity Vest", 9, 19));
		List<Item> items = inn.getItems();
		int quality1 = items.get(0).getQuality();
		
		GildedRose.main(null);
		List<Item> items2 = inn.getItems();
		int quality2 = items2.get(0).getQuality();
		
		assertEquals("Updating doesn't work", quality1, quality2);
	}

	@Test
	public void exampleTest() {
		// create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();

		// access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();

		// assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}

	@Test
	public void testTAFKAL80ETC() {
		// create an inn, add backstage passes, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 35));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 35));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 47));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 35));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45));
		inn.oneDay();

		// Get qualities of all items
		List<Item> items = inn.getItems();
		int quality1 = items.get(0).getQuality();
		int quality2 = items.get(1).getQuality();
		int quality3 = items.get(2).getQuality();
		int quality4 = items.get(3).getQuality();
		int quality5 = items.get(4).getQuality();
		int quality6 = items.get(5).getQuality();
		
		int sellin1 = items.get(0).getSellIn();
		int sellin2 = items.get(1).getSellIn();
		int sellin3 = items.get(2).getSellIn();
		int sellin4 = items.get(3).getSellIn();
		int sellin5 = items.get(4).getSellIn();
		int sellin6 = items.get(5).getSellIn();
		
		// Assert quality has changed
		assertEquals("Failed quality for Backstage pass", 36, quality1);
		assertEquals("Failed sellin for Backstage pass", 10, sellin1);
		
		assertEquals("Failed quality for Backstage pass", 37, quality2);
		assertEquals("Failed sellin for Backstage pass", 9, sellin2);
		
		assertEquals("Failed quality for Backstage pass", 49, quality3);
		assertEquals("Failed sellin for Backstage pass", 5, sellin3);
		
		assertEquals("Failed quality for Backstage pass", 0, quality4);
		assertEquals("Failed sellin for Backstage pass", -2, sellin4);
		
		assertEquals("Failed quality for Backstage pass", 50, quality5);
		assertEquals("Failed sellin for Backstage pass", 4, sellin5);
		
		assertEquals("Failed quality for Backstage pass", 48, quality6);
		assertEquals("Failed sellin for Backstage pass", 4, sellin6);
		
	}
	
	@Test
	public void testAgedBrie() {
		// create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", -5, 45));
		inn.setItem(new Item("Aged Brie", 9, 45));
		inn.setItem(new Item("Aged Brie", 4, 45));
		inn.setItem(new Item("Aged Brie", -10, 55));
		inn.setItem(new Item("Aged Brie", -10, 50));
		inn.oneDay();

		// access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality1 = items.get(0).getQuality();
		int quality2 = items.get(1).getQuality();
		int quality3 = items.get(2).getQuality();
		int quality4 = items.get(3).getQuality();
		int quality5 = items.get(4).getQuality();
		
		int sellin5 = items.get(4).getSellIn();

		// assert quality has decreased by one
		assertEquals("Failed quality for Aged brie", 47, quality1);
		assertEquals("Failed quality for Aged brie", 46, quality2);
		assertEquals("Failed quality for Aged brie", 46, quality3);
		assertEquals("Failed quality for Aged brie", 55, quality4);
		
		assertEquals("Failed sellin for Aged Brie", -11, sellin5);
		assertEquals("Failed quality for Aged Brie", 50, quality5);
	}
	

	@Test
	public void testHandOfRagnaros() {
		// create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 9, 80));
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 4, 80));
		inn.oneDay();

		// access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality1 = items.get(0).getQuality();
		int quality2 = items.get(1).getQuality();
		int quality3 = items.get(2).getQuality();

		// assert quality has decreased by one
		assertEquals("Failed quality for Sulfuras, Hand of Ragnaros", 80, quality1);
		assertEquals("Failed quality for Sulfuras, Hand of Ragnaros", 80, quality2);
		assertEquals("Failed quality for Sulfuras, Hand of Ragnaros", 80, quality3);
	}
	
	@Test
	public void testElixirOfTheMongoose() {
		// create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", 5, 50));
		inn.setItem(new Item("Elixir of the Mongoose", 1, 25));
		inn.setItem(new Item("Elixir of the Mongoose", -1, 10));
		inn.oneDay();

		// access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality1 = items.get(0).getQuality();
		int quality2 = items.get(1).getQuality();
		int quality3 = items.get(2).getQuality();

		// assert quality has decreased by one
		assertEquals("Failed quality for Elixir of the Mongoose", 49, quality1);
		assertEquals("Failed quality for Elixir of the Mongoose", 24, quality2);
		assertEquals("Failed quality for Elixir of the Mongoose", 8, quality3);
	}
	
	@Test
	public void testItemQualityOver50() {
		// create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", 3, 55));
		inn.setItem(new Item("Elixir of the Mongoose", 8, 55));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 55));
		inn.oneDay();

		// access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality1 = items.get(0).getQuality();
		int sellin1 = items.get(0).getSellIn();

		int quality2 = items.get(1).getQuality();
		int sellin2 = items.get(1).getSellIn();
		
		int quality3 = items.get(2).getQuality();
		int sellin3 = items.get(2).getSellIn();
		
		// assert quality has decreased by one
		assertEquals("Failed quality for Elixir of the Mongoose", 54, quality1);
		assertEquals("Failed sellin for Elixir of the Mongoose", 2, sellin1);
		
		assertEquals("Failed quality for Elixir of the Mongoose", 54, quality2);
		assertEquals("Failed sellin for Elixir of the Mongoose", 7, sellin2);

		assertEquals("Failed sellin for Backstage passes to a TAFKAL80ETC concert", 9, sellin3);
		assertEquals("Failed quality for Backstage passes to a TAFKAL80ETC concert", 55, quality3);
		

	}
	
	@Test
	public void testItemQualityOfZero() {
		// create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", 0, 0));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, -5));
		inn.oneDay();

		// access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality1 = items.get(0).getQuality();
		int sellin1 = items.get(0).getSellIn();

		int quality2 = items.get(1).getQuality();
		int sellin2 = items.get(0).getSellIn();
		
		// assert quality has decreased by one
		assertEquals("Failed quality for Elixir of the Mongoose", 0, quality1);
		assertEquals("Failed sellin for Elixir of the Mongoose", -1, sellin1);

		assertEquals("Failed sellin for Backstage passes to a TAFKAL80ETC concert", -1, sellin2);
		assertEquals("Failed quality for Backstage passes to a TAFKAL80ETC concert", 0, quality2);
		

	}
		
}
