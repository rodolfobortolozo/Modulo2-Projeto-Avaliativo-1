package com.labmedicine.controller;

import com.labmedicine.model.Patient;
import com.labmedicine.repository.PatientRepository;

public class PatientController {

  PatientRepository patientRepository = new PatientRepository();

  public boolean save(Patient patient){
    try {
      patientRepository.add(patient);
      return  true;
    }catch (Exception e){
      return false;
    }
  }
}
