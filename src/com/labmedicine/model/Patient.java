package com.labmedicine.model;

import java.time.LocalDate;
import java.util.List;


public class Patient extends Person {

  private String emergencyContact;
  private List<Allergy> allergy;
  private List<CareList> careList;
  private String healthInsurance;
  private Integer insuranceNumber;
  private LocalDate insuranceDate;
  private Integer statusConsult;
  private Integer qtdConsult = 0;

  public Patient() {
  }

  public Patient(Long id, String name, String cpf, LocalDate dateBirth, String gender, String phone,
                 String emergencyContact, List<Allergy> allergy, List<CareList> careList, String healthInsurance,
                 Integer insuranceNumber, LocalDate insuranceDate, Integer statusConsult, Integer qtdConsult) {
    super.id = id;
    super.name = name;
    super.cpf = cpf;
    super.dateBirth = dateBirth;
    super.gender = gender;
    super.phone = phone;
    this.emergencyContact = emergencyContact;
    this.allergy = allergy;
    this.careList = careList;
    this.healthInsurance = healthInsurance;
    this.insuranceNumber = insuranceNumber;
    this.insuranceDate = insuranceDate;
    this.statusConsult = statusConsult;
    this.qtdConsult = qtdConsult;
  }

  public String getEmergencyContact() {
    return emergencyContact;
  }

  public void setEmergencyContact(String emergencyContact) {
    this.emergencyContact = emergencyContact;
  }

  public List<Allergy> getAllergy() {
    return allergy;
  }

  public void setAllergy(List<Allergy> allergy) {
    this.allergy = allergy;
  }

  public List<CareList> getCareList() {
    return careList;
  }

  public void setCareList(List<CareList> careList) {
    this.careList = careList;
  }

  public String getHealthInsurance() {
    return healthInsurance;
  }

  public void setHealthInsurance(String healthInsurance) {
    this.healthInsurance = healthInsurance;
  }

  public Integer getInsuranceNumber() {
    return insuranceNumber;
  }

  public void setInsuranceNumber(Integer insuranceNumber) {
    this.insuranceNumber = insuranceNumber;
  }

  public LocalDate getInsuranceDate() {
    return insuranceDate;
  }

  public void setInsuranceDate(LocalDate insuranceDate) {
    this.insuranceDate = insuranceDate;
  }

  public Integer getStatusConsult() {
    return statusConsult;
  }

  public void setStatusConsult(Integer statusConsult) {

    if(statusConsult == null){
      this.statusConsult = 0;
    }
    this.statusConsult = statusConsult;
  }

  public Integer getQtdConsult() {
    return qtdConsult;
  }

  public void setQtdConsult(Integer qtdConsult) {
    this.qtdConsult = qtdConsult;
  }

  @Override
  public String toString() {
    return "Patient{" +
            ", qtdConsult=" + qtdConsult + '\'' +
    "emergencyContact='" + emergencyContact + '\'' +
            ", allergy=" + allergy +
            ", careList=" + careList +
            ", healthInsurance='" + healthInsurance + '\'' +
            ", insuranceNumber=" + insuranceNumber +
            ", insuranceDate=" + insuranceDate +
            ", Status='" + statusConsult + '\'' +

            ", id=" + id +
            ", name='" + name + '\'' +
            ", gender='" + gender + '\'' +
            ", dateBirth=" + dateBirth +
            ", cpf='" + cpf + '\'' +
            ", phone='" + phone + '\'' +
            '}';
  }
}
