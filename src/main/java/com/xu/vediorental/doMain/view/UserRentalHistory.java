package com.xu.vediorental.doMain.view;


public class UserRentalHistory{

  private String name;
  private long fid;
  private java.sql.Date lend;
  private java.sql.Date back;
  private double amount;
  private long deposit;

  public long getDeposit() {
    return deposit;
  }

  public void setDeposit(long deposit) {
    this.deposit = deposit;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getFid() {
    return fid;
  }

  public void setFid(long fid) {
    this.fid = fid;
  }


  public java.sql.Date getLend() {
    return lend;
  }

  public void setLend(java.sql.Date lend) {
    this.lend = lend;
  }


  public java.sql.Date getBack() {
    return back;
  }

  public void setBack(java.sql.Date back) {
    this.back = back;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "UserRentalHistory{" +
            ", name='" + name + '\'' +
            ", fid=" + fid +
            ", lend=" + lend +
            ", back=" + back +
            ", amount=" + amount +
            '}';
  }
}
