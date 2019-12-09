package com.xu.vediorental.doMain.table;


public class RecordInfo {

  private long id;
  private String username;
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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

}
