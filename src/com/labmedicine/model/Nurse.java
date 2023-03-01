package com.labmedicine.model;

public class Nurse extends Person{

  private String university;
  private String cofen;
  private String uf;
  private String status;

  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  public String getCofen() {
    return cofen;
  }

  public void setCofen(String cofen) {
    this.cofen = cofen;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
