package com.programania.gildedrose;

public class LegendaryItem extends Item {
  LegendaryItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  void update() {
    increaseQuality();
  }

}