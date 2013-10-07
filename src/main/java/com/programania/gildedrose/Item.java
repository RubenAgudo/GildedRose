package com.programania.gildedrose;

abstract public class Item {
  protected final String name;
  protected int sellIn;
  protected int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public String getName() {
    return name;
  }

  public boolean hasQuality(int someQuality) {
    return quality == someQuality;
  }

  public boolean hasSellIn(int someSellIn) {
    return sellIn == someSellIn;
  }

  public void setZeroQuality() {
    quality = 0;
  }

  public void increaseQuality() {
    if (quality < 50)
      quality++;
  }

  public void decreaseQuality() {
    if (quality > 0)
      quality--;
  }

  public void decreaseSellIn() {
    sellIn--;
  }

  abstract void update();

}
