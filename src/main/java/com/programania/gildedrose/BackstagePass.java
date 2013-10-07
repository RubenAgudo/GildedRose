package com.programania.gildedrose;

public class BackstagePass extends Item {
  BackstagePass(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  void update() {
    decreaseSellIn();

    increaseQuality();

    if (sellIn < 5)
      increaseQuality();

    if (sellIn < 10)
      increaseQuality();

    if (sellIn < 0)
      setZeroQuality();
  }

}