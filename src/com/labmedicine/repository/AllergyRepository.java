package com.labmedicine.repository;

import com.labmedicine.model.Allergy;

import java.util.ArrayList;
import java.util.List;

public class AllergyRepository {
    List<Allergy> arrAllergy = new ArrayList<>();

    public boolean add(Allergy allergy) {
        try{
            arrAllergy.add(allergy);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

