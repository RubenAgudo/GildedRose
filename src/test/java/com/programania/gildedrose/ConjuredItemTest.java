package com.programania.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConjuredItemTest {

  private ConjuredItem manaCake;

  @Before
  public void setUp() throws Exception {
    manaCake = new ConjuredItem("Conjured Mana Cake", 1, 10);
  }

  @Test
  public void conjured_items_decrease_sell_in_each_day() {
    manaCake.update();
    assertThat(manaCake.hasSellIn(0), is(true));
  }

  @Test
  public void conjured_items_degrade_twice_as_fast() {
    manaCake.update();
    assertThat(manaCake.hasQuality(8), is(true));
  }

  @Test
  public void conjured_items_degrade_four_times_faster_after_sell_in_date() {
    manaCake.update();
    manaCake.update();
    assertThat(manaCake.hasQuality(4), is(true));
  }
}
