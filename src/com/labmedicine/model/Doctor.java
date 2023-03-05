package com.labmedicine.model;

import java.time.LocalDate;

public class Doctor extends Person{

  private String university;
  private String crm;
  private String uf;
  private Integer specialization;
  private Integer qtdConsult = 0;
  private Boolean status;

  public Doctor() {
  }

  public Doctor(Long id, String name, String cpf, LocalDate dateBirth, String gender, String phone, String university, String crm,
                String uf, Integer specialization, Integer qtdConsult, Boolean status) {
    super.id = id;
    super.name = name;
    super.cpf = cpf;
    super.dateBirth = dateBirth;
    super.gender = gender;
    super.phone = phone;
    this.university = university;
    this.crm = crm;
    this.uf = uf;
    this.specialization = specialization;
    this.qtdConsult = qtdConsult;
    this.status = status;
  }

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

  @Override
  public String toString() {
    return "Doctor{" +
            "university='" + university + '\'' +
            ", crm='" + crm + '\'' +
            ", uf='" + uf + '\'' +
            ", specialization=" + specialization +
            ", qtdConsult=" + qtdConsult +
            ", status=" + status +
            ", id=" + id +
            ", name='" + name + '\'' +
            ", gender='" + gender + '\'' +
            ", dateBirth=" + dateBirth +
            ", cpf='" + cpf + '\'' +
            ", phone='" + phone + '\'' +
            '}';
  }
}
