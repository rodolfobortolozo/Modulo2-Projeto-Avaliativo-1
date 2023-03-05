package com.labmedicine.repository;

import com.labmedicine.model.Doctor;
import com.labmedicine.model.Nurse;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DoctorRepository implements PersonInterface<Doctor> {

  static final List<Doctor> arrDoctor = new ArrayList<>();

  @Override
  public boolean add(Doctor doctor) {
    try {
      arrDoctor.add(doctor);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  public boolean update(Integer indice, Doctor doctor) {
    try{
      arrDoctor.set(indice,doctor);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  public boolean remove(Integer indice) {
    try{
      arrDoctor.remove(indice);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  public List getAll() {
    return arrDoctor;
  }

  @Override
  public Doctor getById(Long id) {

    for (Doctor doctor : arrDoctor){

      if(doctor.getId().equals(id)){
        return doctor;
      }
    }
    return null;
  }

  @Override
  public List<Doctor> getByName(Doctor doctor) {

    Predicate<Doctor> filterNurse = p -> p.getName().equalsIgnoreCase(doctor.getName());
    List<Doctor> doctorFiltered = arrDoctor.stream()
            .filter(filterNurse)
            .collect(Collectors.toList());

    return doctorFiltered;
  }

}