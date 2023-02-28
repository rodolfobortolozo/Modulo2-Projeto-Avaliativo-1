package com.labmedicine.repository;

import com.labmedicine.model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PatientRepository implements PersonInterface<Patient> {

  List<Patient> arrPatient = new ArrayList<>();

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
  public List getAll() {
    return arrPatient;
  }

  @Override
  public List<Patient> getByName(Patient patient) {

    Predicate<Patient> filterPatient = p -> p.getName().equalsIgnoreCase(patient.getName());
    List<Patient> patientFiltered = arrPatient.stream()
            .filter(filterPatient)
            .collect(Collectors.toList());

    return patientFiltered;
  }

}