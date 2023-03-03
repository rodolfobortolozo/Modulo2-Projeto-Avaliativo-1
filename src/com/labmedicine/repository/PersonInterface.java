package com.labmedicine.repository;

import com.labmedicine.model.Patient;
import com.labmedicine.model.Person;

import java.util.List;

public interface PersonInterface<T> {

  boolean add(T object);

  boolean update(Integer indice, T object);

  boolean remove(Integer indice);

  List<T> getAll();

  T getById(Integer indice);

  List<T> getByName(T object);


}
