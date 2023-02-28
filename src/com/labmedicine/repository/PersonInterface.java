package com.labmedicine.repository;

import com.labmedicine.model.Patient;
import com.labmedicine.model.Person;

import java.util.List;

public interface PersonInterface<T> {

  boolean add(T object);

  List<T> getAll();

  List<T> getByName(T object);

}
