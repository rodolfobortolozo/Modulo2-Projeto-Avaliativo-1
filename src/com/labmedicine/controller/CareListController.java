package com.labmedicine.controller;

import com.labmedicine.model.Allergy;
import com.labmedicine.model.CareList;
import com.labmedicine.repository.AllergyRepository;
import com.labmedicine.repository.CareListRepository;

public class CareListController {

    CareListRepository careListRepository = new CareListRepository();

    public boolean save(CareList careList){
        try {
            careListRepository.add(careList);
            return  true;
        }catch (Exception e){
            return false;
        }
    }
}
