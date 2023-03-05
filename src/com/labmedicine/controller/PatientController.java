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

  public boolean updatePatient(Integer indice, Patient patient){
    try {
      patientRepository.update(indice, patient);
      return  true;
    }catch (Exception e){
      return false;
    }
  }

  public List<Patient> getAll(){
    return patientRepository.getAll();
  }

  public Patient getById(Long id){
    return patientRepository.getById(id);
  }

  public Integer indexPatient(Long id){

    for(int i=0; i < getAll().size();i++){
      boolean res = getAll().get(i).getId().equals(id);
      if(res){
        return i;
      }
    }
    return -1;
  }

  public Long returnLastIdPatient(){
    return Long.valueOf(getAll().size() + 1);
  }

  public List<Patient> getPatientbyName(Patient patient){
    return patientRepository.getByName(patient);
  }

  public List<Patient> getByStatusConsult(Integer op){
    return patientRepository.getByStatusConsult(op);
  }
}
