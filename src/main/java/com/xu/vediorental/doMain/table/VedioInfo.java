package com.xu.vediorental.doMain.table;


public class VedioInfo {

    private long id;
    private String name;
    private long inventory;
    private double price;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


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
        return "VedioInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inventory=" + inventory +
                ", price=" + price +
                '}';
    }
}
