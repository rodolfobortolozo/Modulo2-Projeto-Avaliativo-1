package com.labmedicine.repository;

import com.labmedicine.model.Doctor;
import com.labmedicine.model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PatientRepository implements PersonInterface<Patient> {

  static final List<Patient> arrPatient = new ArrayList<>();

  @Override
  public boolean add(Patient patient) {
    try {
      arrPatient.add(patient);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  public boolean update(Integer indice, Patient patient) {
    try{
      arrPatient.set(indice,patient);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }

  }

  @Override
  public boolean remove(Integer indice) {
    try{
      arrPatient.remove(indice);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  public List getAll() {
    return arrPatient;
  }

  @Override
  public Patient getById(Long id) {

    for (Patient patient : arrPatient){
      if(patient.getId().equals(id)){
        return patient;
      }
    }
    return null;
  }


  public void upateConsult(Patient patient){

  }

  @Override
  public List<Patient> getByName(Patient patient) {

    Predicate<Patient> filterPatient = p -> p.getName().equalsIgnoreCase(patient.getName());

    List<Patient> patientFiltered = arrPatient.stream()
            .filter(filterPatient)
            .collect(Collectors.toList());

    return patientFiltered;
  }

  public List<Patient> getByStatusConsult(Integer op) {

    Predicate<Patient> filterPatient = p -> p.getStatusConsult().equals(op);

    List<Patient> patientFiltered = arrPatient.stream()
            .filter(filterPatient)
            .collect(Collectors.toList());

    return patientFiltered;
  }

}