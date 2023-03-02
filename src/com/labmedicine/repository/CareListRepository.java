package com.labmedicine.repository;

import com.labmedicine.model.Allergy;
import com.labmedicine.model.CareList;

import java.util.ArrayList;
import java.util.List;

public class CareListRepository {
    List<CareList> arrCareList = new ArrayList<>();

    public boolean add(CareList careList) {
        try{
            arrCareList.add(careList);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

