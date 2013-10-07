package com.programania.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

  private static List<Item> items = null;

  public static void main(String[] args) {

    System.out.println("OMGHAI!");

    items = new ArrayList<>();
    items.add(new NormalItem("+5 Dexterity Vest", 10, 20));
    items.add(new AgingItem("Aged Brie", 2, 0));
    items.add(new NormalItem("Elixir of the Mongoose", 5, 7));
    items.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new NormalItem("Conjured Mana Cake", 3, 6));

    updateQuality(items);
  }

  public static List<Item> updateQuality(List<Item> items) {
    for (Item item : items)
      item.update();
    return items;
  }

}