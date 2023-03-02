package com.labmedicine.controller;

import com.labmedicine.model.Patient;
import com.labmedicine.repository.PatientRepository;

import java.util.List;

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

  public List<Patient> getAll(){
    return patientRepository.getAll();
  }

  public Long returnLastIdPatient(){
    return Long.valueOf(getAll().size() + 1);
  }

  public List<Patient> getPatientbyName(Patient patient){
    return patientRepository.getByName(patient);
  }
}
