package com.programania.gildedrose;

public class NormalItem extends Item {
  NormalItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  void update() {
    decreaseSellIn();

    decreaseQuality();

    if (sellIn < 0)
      decreaseQuality();
  }
}