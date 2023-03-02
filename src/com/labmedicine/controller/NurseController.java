package com.labmedicine.controller;

import com.labmedicine.model.Nurse;
import com.labmedicine.repository.NurseRepository;

import java.util.List;

public class NurseController {

    NurseRepository nurseRepository = new NurseRepository();

    public boolean save(Nurse nurse){
        try {
            nurseRepository.add(nurse);
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Nurse> getAll(){
        return nurseRepository.getAll();
    }

    public Long returnLastIdNurse(){
        return Long.valueOf(getAll().size() + 1);
    }

    public List<Nurse> getNursebyName(Nurse nurse){
        return nurseRepository.getByName(nurse);
    }
}
