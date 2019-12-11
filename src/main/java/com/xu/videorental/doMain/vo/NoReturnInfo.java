package com.xu.videorental.doMain.vo;

/**
 * @author HaibiaoXu
 * @date Create in 14:09 2019/11/29
 * @modified By
 */
public class NoReturnInfo {
    private String name;
    private long fid;
    private java.sql.Date lend;
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


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "NoReturnInfo{" +
                "name='" + name + '\'' +
                ", fid=" + fid +
                ", lend=" + lend +
                ", amount=" + amount +
                '}';
    }
}
