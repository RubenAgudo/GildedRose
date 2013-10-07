package com.programania.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AgingItemTest {

  private AgingItem cheese;

  @Before
  public void setUp() throws Exception {
    cheese = new AgingItem("Aged Brie", 1, 10);
  }

  @Test
  public void aging_item_decreases_sell_in_each_day() {
    cheese.update();
    assertThat(cheese.hasSellIn(0), is(true));
  }

  @Test
  public void aging_item_increases_quality_each_day() {
    cheese.update();
    assertThat(cheese.hasQuality(11), is(true));
  }

  @Test
  public void aging_item_increases_quailty_twice_as_fast_after_sell_in_date() {
    cheese.update();
    cheese.update();
    assertThat(cheese.hasQuality(13), is(true));
  }
}
