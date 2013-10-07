package com.programania.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BackstagePassTest {

  private BackstagePass pass;

  @Before
  public void setUp() throws Exception {
    pass = new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 16, 10);
  }

  @Test
  public void backstage_passes_decrease_sell_in_each_day() {
    pass.update();
    assertThat(pass.hasSellIn(15), is(true));
  }

  @Test
  public void backstage_passes_increase_quality_each_day() {
    pass.update();
    assertThat(pass.hasQuality(11), is(true));
  }

  @Test
  public void backstage_passes_increase_quality_twice_as_fast_if_it_sells_before_ten_days() {
    pass = new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 7, 10);
    pass.update();
    assertThat(pass.hasQuality(12), is(true));
  }

  @Test
  public void backstage_passes_increase_quality_twice_as_fast_if_it_sells_before_five_days() {
    pass = new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 3, 10);
    pass.update();
    assertThat(pass.hasQuality(13), is(true));
  }

  @Test
  public void backstage_passes_loose_all_quality_after_sell_in_date() {
    pass = new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 0, 10);
    pass.update();
    assertThat(pass.hasQuality(0), is(true));
  }
}
