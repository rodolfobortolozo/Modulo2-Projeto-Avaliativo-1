package com.labmedicine.model;

import java.time.LocalDate;

public class Patient extends Person {

  Long idPatient;
  String emergencyContact;
  Allergy allergy;
  CareList careList;
  String healthInsurance;
  Integer insuranceNumber;
  LocalDate insuranceDate;
  String Status;

  public Patient() {
  }

  public Patient(Long idPatient, String emergencyContact, String healthInsurance, Integer insuranceNumber, LocalDate insuranceDate, String status) {
    this.idPatient = idPatient;
    this.emergencyContact = emergencyContact;
    this.healthInsurance = healthInsurance;
    this.insuranceNumber = insuranceNumber;
    this.insuranceDate = insuranceDate;
    Status = status;
  }

  public Long getIdPatient() {
    return idPatient;
  }

  public Patient(String healthInsurance, Integer insuranceNumber, String status) {
    this.healthInsurance = healthInsurance;
    this.insuranceNumber = insuranceNumber;
    this.insuranceDate = insuranceDate;
    Status = status;
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

  public Allergy getAllergy() {
    return allergy;
  }

  public void setAllergy(Allergy allergy) {
    this.allergy = allergy;
  }

  public CareList getCareList() {
    return careList;
  }

  public void setCareList(CareList careList) {
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
