package com.labmedicine.controller;

import com.labmedicine.model.Doctor;
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

    public boolean updateNurse(Integer indice, Nurse nurse) {
        try {
            nurseRepository.update(indice, nurse);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer indexNurse(Long id){

        for(int i=0; i < getAll().size();i++){
            boolean res = getAll().get(i).getId().equals(id);
            if(res){
                return i;
            }
        }
        return -1;
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
