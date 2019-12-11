package com.xu.videorental.doMain.view;


public class VacantFile {

    private String name;
    private double price;
    private long fid;


    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }


    public long getFid() {
    return fid;
    }

    public void setFid(long fid) { this.fid = fid; }

    public double getPrice() {
            return price;
        }

    public void setPrice(double price) {
            this.price = price;
        }

    @Override
    public String toString() {
        return "VacantFile{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", fid=" + fid +
                '}';
    }
}
