package com.programania.gildedrose;

public class AgingItem extends Item {
  AgingItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  void update() {
    decreaseSellIn();

    increaseQuality();

    if (sellIn < 0)
      increaseQuality();
  }
}