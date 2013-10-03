package com.programania.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

  private static List<Item> items = null;

  public static void main(String[] args) {

    System.out.println("OMGHAI!");

    items = new ArrayList<>();
    items.add(new Item("+5 Dexterity Vest", 10, 20));
    items.add(new Item("Aged Brie", 2, 0));
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Item("Conjured Mana Cake", 3, 6));

    updateQuality(items);
  }

  public static List<Item> updateQuality(List<Item> items) {
    for (int i = 0; i < items.size(); i++)
      updateItemQuality(items.get(i));
    return items;
  }

  private static void updateItemQuality(Item item) {
    if (!"Aged Brie".equals(item.getName()) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) && item.getQuality() > 0 && !"Sulfuras, Hand of Ragnaros".equals(item.getName()))
      item.decreaseQuality();

    if ("Aged Brie".equals(item.getName()) || "Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) || item.getQuality() <= 0 || "Sulfuras, Hand of Ragnaros".equals(item.getName()))
      item.increaseQuality();

    if (("Aged Brie".equals(item.getName()) || "Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) || item.getQuality() <= 0 || "Sulfuras, Hand of Ragnaros".equals(item.getName())) && "Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) && item.getSellIn() < 6)
      item.increaseQuality();

    if (("Aged Brie".equals(item.getName()) || "Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) || item.getQuality() <= 0 || "Sulfuras, Hand of Ragnaros".equals(item.getName())) && "Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) && item.getSellIn() < 11)
      item.increaseQuality();

    if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
      item.decreaseSellIn();

    if (item.getSellIn() < 0 && !"Aged Brie".equals(item.getName()) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) && item.getQuality() > 0 && !"Sulfuras, Hand of Ragnaros".equals(item.getName()))
      item.decreaseQuality();

    if (item.getSellIn() < 0 && !"Aged Brie".equals(item.getName()) && "Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
      item.setZeroQuality();

    if (item.getSellIn() < 0 && "Aged Brie".equals(item.getName()))
      item.increaseQuality();
  }

}