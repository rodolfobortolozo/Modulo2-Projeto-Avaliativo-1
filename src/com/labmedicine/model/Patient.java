package com.labmedicine.model;

import java.time.LocalDate;
import java.util.List;

public class Patient extends Person {

  private Long idPatient;
  private String emergencyContact;
  private List<Allergy> allergy;
  private List<CareList> careList;
  private String healthInsurance;
  private Integer insuranceNumber;
  private LocalDate insuranceDate;
  private String Status;

  public Patient() {
  }

  public Long getIdPatient() {
    return idPatient;
  }

  public void setIdPatient(Long idPatient) {
    this.idPatient = idPatient;
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

  public String getStatus() {
    return Status;
  }

  public void setStatus(String status) {
    Status = status;
  }

  @Override
  public String toString() {
    return "Patient{" +
            "idPatient=" + idPatient +
            ", emergencyContact='" + emergencyContact + '\'' +
            ", allergy=" + allergy +
            ", careList=" + careList +
            ", healthInsurance='" + healthInsurance + '\'' +
            ", insuranceNumber=" + insuranceNumber +
            ", insuranceDate=" + insuranceDate +
            ", Status='" + Status + '\'' +
            ", idPerson=" + idPerson +
            ", name='" + name + '\'' +
            ", gender='" + gender + '\'' +
            ", dateBirth=" + dateBirth +
            ", cpf='" + cpf + '\'' +
            ", phone='" + phone + '\'' +
            '}';
  }
}
