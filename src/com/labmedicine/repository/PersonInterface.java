package com.labmedicine.repository;

import com.labmedicine.model.Person;

public interface PersonInterface<T> {

  boolean add(T object);
}
