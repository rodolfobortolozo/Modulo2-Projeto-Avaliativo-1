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


}
