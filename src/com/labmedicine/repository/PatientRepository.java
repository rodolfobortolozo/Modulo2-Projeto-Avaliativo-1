package com.labmedicine.repository;

import com.labmedicine.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientRepository implements PersonInterface<Patient> {

  List<Patient> arrPatient = new ArrayList<>();

  @Override
  public boolean add(Patient patient) {
    try{
      arrPatient.add(patient);
      return true;
    }catch (Exception e){
      System.out.println(e.getMessage());
      return false;
    }
  }
}
