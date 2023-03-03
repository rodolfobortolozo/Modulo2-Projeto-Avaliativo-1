package com.labmedicine.repository;

import com.labmedicine.model.Nurse;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NurseRepository implements PersonInterface<Nurse> {

  static final List<Nurse> arrNurse = new ArrayList<>();

  @Override
  public boolean add(Nurse nurse) {
    try {
      arrNurse.add(nurse);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  public boolean update(Integer indice, Nurse nurse) {
    try{
      arrNurse.set(indice,nurse);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  public boolean remove(Integer indice) {
    try{
      arrNurse.remove(indice);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  public List getAll() {
    return arrNurse;
  }

  @Override
  public Nurse getById(Integer indice) {
    return null;
  }

  @Override
  public List<Nurse> getByName(Nurse nurse) {

    Predicate<Nurse> filterNurse = p -> p.getName().equalsIgnoreCase(nurse.getName());
    List<Nurse> nurseFiltered = arrNurse.stream()
            .filter(filterNurse)
            .collect(Collectors.toList());

    return nurseFiltered;
  }

}