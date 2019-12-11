package com.xu.videorental.doMain.view;


public class VideoRecording {

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
    return "videoRecording{" +
            "name='" + name + '\'' +
            ", inventory=" + inventory +
            ", price=" + price +
            '}';
  }
}
