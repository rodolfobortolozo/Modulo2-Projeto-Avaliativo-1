package com.labmedicine.controller;

import com.labmedicine.model.Allergy;
import com.labmedicine.model.Patient;
import com.labmedicine.repository.AllergyRepository;

public class AllergyController {

    AllergyRepository allergyRepository = new AllergyRepository();

    public boolean save(Allergy allergy){
        try {
            allergyRepository.add(allergy);
            return  true;
        }catch (Exception e){
            return false;
        }
    }
}
