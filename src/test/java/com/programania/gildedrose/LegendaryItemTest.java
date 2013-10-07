package com.programania.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LegendaryItemTest {
  @Test
  public void legendary_items_do_not_decrease_sell_in() {
    LegendaryItem sulfuras = new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80);
    sulfuras.update();
    assertThat(sulfuras.hasSellIn(0), is(true));
  }

  @Test
  public void legendary_items_do_not_change_quality() {
    LegendaryItem sulfuras = new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80);
    sulfuras.update();
    assertThat(sulfuras.hasQuality(80), is(true));
  }
}
