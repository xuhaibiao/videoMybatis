package com.xu.videorental.doMain.view;


public class AllFile {

  private long id;
  private long status;
  private String name;
  private long vid;

  public long getVid() {
    return vid;
  }

  public void setVid(long vid) {
    this.vid = vid;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public String toString() {
    return "AllFile{" +
            "id=" + id +
            ", status=" + status +
            ", name='" + name + '\'' +
            ", vid=" + vid +
            '}';
  }
}
