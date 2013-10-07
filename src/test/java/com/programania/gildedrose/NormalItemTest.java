package com.programania.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NormalItemTest {

  private NormalItem elixir;

  @Before
  public void setUp() throws Exception {
    elixir = new NormalItem("Elixir of the Mongoose", 1, 10);
  }

  @Test
  public void normal_items_decrease_sell_in_each_day() {
    elixir.update();
    assertThat(elixir.hasSellIn(0), is(true));
  }

  @Test
  public void conjured_items_degrade_each_day() {
    elixir.update();
    assertThat(elixir.hasQuality(9), is(true));
  }

  @Test
  public void conjured_items_degrade_twice_as_fast_after_sell_in_date() {
    elixir.update();
    elixir.update();
    assertThat(elixir.hasQuality(7), is(true));
  }
}
