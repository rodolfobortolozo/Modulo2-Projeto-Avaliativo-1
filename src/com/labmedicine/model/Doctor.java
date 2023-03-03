package com.labmedicine.model;

public class Doctor extends Person{

  private String university;
  private String crm;
  private String uf;
  private Integer specialization;
  private Integer qtdConsult = 0;

  private Boolean status;

  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  public String getCrm() {
    return crm;
  }

  public void setCrm(String crm) {
    this.crm = crm;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public Integer getSpecialization() {
    return specialization;
  }

  public void setSpecialization(Integer specialization) {
    this.specialization = specialization;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public Integer getQtdConsult() {
    return qtdConsult;
  }

  public void setQtdConsult(Integer qtdConsult) {
    this.qtdConsult = qtdConsult;
  }
}
