package com.programania.gildedrose;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GildedRoseSmokeTest {
  List<Item> items;

  @Before
  public void setUp() {
    items = new ArrayList<>();
    items.add(new Item("+5 Dexterity Vest", 10, 20));
    items.add(new Item("Aged Brie", 2, 0));
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Item("Conjured Mana Cake", 3, 6));
  }

  @Test
  public void everything_is_ok_after_one_run() {
    List<Integer> expectedQualities = Arrays.asList(19, 1, 6, 80, 21, 5);
    List<Integer> expectedSellIns = Arrays.asList(9, 1, 4, 0, 14, 2);
    List<Item> updatedItems = runIt(1);
    assertThatQualitiesAndSellInsAreOk(expectedQualities, expectedSellIns, updatedItems);
  }

  @Test
  public void everything_is_ok_after_two_runs() {
    List<Integer> expectedQualities = Arrays.asList(18, 2, 5, 80, 22, 4);
    List<Integer> expectedSellIns = Arrays.asList(8, 0, 3, 0, 13, 1);
    List<Item> updatedItems = runIt(2);
    assertThatQualitiesAndSellInsAreOk(expectedQualities, expectedSellIns, updatedItems);
  }

  @Test
  public void everything_is_ok_after_four_runs() {
    List<Integer> expectedQualities = Arrays.asList(16, 6, 3, 80, 24, 1);
    List<Integer> expectedSellIns = Arrays.asList(6, -2, 1, 0, 11, -1);
    List<Item> updatedItems = runIt(4);
    assertThatQualitiesAndSellInsAreOk(expectedQualities, expectedSellIns, updatedItems);
  }

  @Test
  public void everything_is_ok_after_six_runs() {
    List<Integer> expectedQualities = Arrays.asList(14, 10, 0, 80, 27, 0);
    List<Integer> expectedSellIns = Arrays.asList(4, -4, -1, 0, 9, -3);
    List<Item> updatedItems = runIt(6);
    assertThatQualitiesAndSellInsAreOk(expectedQualities, expectedSellIns, updatedItems);
  }

  @Test
  public void everything_is_ok_after_eleven_runs() {
    List<Integer> expectedQualities = Arrays.asList(8, 20, 0, 80, 38, 0);
    List<Integer> expectedSellIns = Arrays.asList(-1, -9, -6, 0, 4, -8);
    List<Item> updatedItems = runIt(11);
    assertThatQualitiesAndSellInsAreOk(expectedQualities, expectedSellIns, updatedItems);
  }

  @Test
  public void everything_is_ok_after_sixteen_runs() {
    List<Integer> expectedQualities = Arrays.asList(0, 30, 0, 80, 0, 0);
    List<Integer> expectedSellIns = Arrays.asList(-6, -14, -11, 0, -1, -13);
    List<Item> updatedItems = runIt(16);
    assertThatQualitiesAndSellInsAreOk(expectedQualities, expectedSellIns, updatedItems);
  }

  private void assertThatQualitiesAndSellInsAreOk(List<Integer> expectedQualities, List<Integer> expectedSellIns, List<Item> updatedItems) {
    for (int idx = 0, max = updatedItems.size(); idx < max; idx++) {
      assertThat(String.format("%s has a wrong quality value", updatedItems.get(idx).getName()), updatedItems.get(idx).hasQuality(expectedQualities.get(idx)), is(true));
      assertThat(String.format("%s has a wrong sellIn value", updatedItems.get(idx).getName()), updatedItems.get(idx).hasSellIn(expectedSellIns.get(idx)), is(true));
    }
  }

  private List<Item> runIt(int times) {
    List<Item> updatedItems = new ArrayList<>();
    while (times-- != 0)
      updatedItems = GildedRose.updateQuality(items);
    return updatedItems;
  }

}
