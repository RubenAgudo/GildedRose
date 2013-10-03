package com.programania.gildedrose;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

  @Test
  public void everything_is_ok_after_one_run() {
    List<Item> items = new ArrayList<>();
    items.add(new Item("+5 Dexterity Vest", 10, 20));
    items.add(new Item("Aged Brie", 2, 0));
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Item("Conjured Mana Cake", 3, 6));

    List<Integer> expectedQualities = Arrays.asList(19, 1, 6, 80, 21, 5);
    List<Integer> expectedSellIns = Arrays.asList(9, 1, 4, 0, 14, 2);
    List<Item> updatedItems = GildedRose.updateQuality(items);
    for (int idx = 0, max = updatedItems.size(); idx < max; idx++) {
      assertThat(String.format("%s has a wrong quality value", updatedItems.get(idx).getName()), updatedItems.get(idx).getQuality(), is(expectedQualities.get(idx)));
      assertThat(String.format("%s has a wrong sellIn value", updatedItems.get(idx).getName()), updatedItems.get(idx).getSellIn(), is(expectedSellIns.get(idx)));
    }
  }
}
