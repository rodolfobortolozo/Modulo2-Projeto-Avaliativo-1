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

  public Patient getById(Integer indece){
    return patientRepository.getById(indece-1);
  }

  public Boolean existsPatient(Long id){

    for(int i=0; i < getAll().size();i++){
      Boolean res = getAll().get(i).getId().equals(id);
      if(res){
        return true;
      }else{
        return false;
      }
    }
    return false;
  }

  public Long returnLastIdPatient(){
    return Long.valueOf(getAll().size() + 1);
  }

  public List<Patient> getPatientbyName(Patient patient){
    return patientRepository.getByName(patient);
  }
}
