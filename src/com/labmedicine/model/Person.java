package com.labmedicine.model;

import java.time.LocalDate;

public abstract class Person {
  Long idPerson;
  String name;
  String gender;
  LocalDate dateBirth;
  String cpf;
  String phone;

  public Person() {
  }

  public Long getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(Long idPerson) {
    this.idPerson = idPerson;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public LocalDate getDateBirth() {
    return dateBirth;
  }

  public void setDateBirth(LocalDate dateBirth) {
    this.dateBirth = dateBirth;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
