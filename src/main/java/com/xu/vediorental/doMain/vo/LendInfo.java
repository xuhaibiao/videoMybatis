package com.xu.vediorental.doMain.vo;

import java.sql.Date;

/**
 * @author HaibiaoXu
 * @date Create in 11:48 2019/11/30
 * @modified By
 */
public class LendInfo {
    private String username;
    private long fid;
    private java.sql.Date lend;

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

    public Date getLend() {
        return lend;
    }

    public void setLend(Date lend) {
        this.lend = lend;
    }

    @Override
    public String toString() {
        return "LendInfo{" +
                "username='" + username + '\'' +
                ", fid=" + fid +
                ", lend=" + lend +
                '}';
    }
}
