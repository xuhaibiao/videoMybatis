package com.xu.videorental.doMain.table;


public class FileInfo {

  private long id;
  private long vid;
  private long status;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getVid() {
    return vid;
  }

  public void setVid(long vid) {
    this.vid = vid;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "FileInfo{" +
            "id=" + id +
            ", vid=" + vid +
            ", status=" + status +
            '}';
  }
}
