package com.xu.videorental.doMain.vo;

import java.sql.Date;

/**
 * @author HaibiaoXu
 * @date Create in 11:53 2019/11/30
 * @modified By
 */
public class BackInfo {
    private String username;
    private long fid;
    private java.sql.Date back;
    private double amount;

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

    public Date getBack() {
        return back;
    }

    public void setBack(Date back) {
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
        return "BackInfo{" +
                "username='" + username + '\'' +
                ", fid=" + fid +
                ", back=" + back +
                ", amount=" + amount +
                '}';
    }
}
