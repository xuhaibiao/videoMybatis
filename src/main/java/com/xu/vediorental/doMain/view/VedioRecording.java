package com.xu.vediorental.doMain.view;


public class VedioRecording {

  private String name;
  private long inventory;
  private double price;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getInventory() {
    return inventory;
  }

  public void setInventory(long inventory) {
    this.inventory = inventory;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "VedioRecording{" +
            "name='" + name + '\'' +
            ", inventory=" + inventory +
            ", price=" + price +
            '}';
  }
}
