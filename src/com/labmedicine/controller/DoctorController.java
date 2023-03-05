package com.labmedicine.controller;

import com.labmedicine.model.Doctor;
import com.labmedicine.model.Patient;
import com.labmedicine.repository.DoctorRepository;

import java.util.List;

public class DoctorController {

    DoctorRepository doctorRepository = new DoctorRepository();

    public boolean save(Doctor doctor){
        try {
            doctorRepository.add(doctor);
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean updateDoctor(Integer indice, Doctor doctor) {
        try {
            doctorRepository.update(indice, doctor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }

    public Doctor getById(Long id){
        return doctorRepository.getById(id);
    }

    public Integer indexDoctor(Long id){

        for(int i=0; i < getAll().size();i++){
            boolean res = getAll().get(i).getId().equals(id);
            if(res){
                return i;
            }
        }
        return -1;
    }

    public Long returnLastIdDoctor(){
        return Long.valueOf(getAll().size() + 1);
    }

    public List<Doctor> getDoctorbyName(Doctor doctor){
        return doctorRepository.getByName(doctor);
    }
}
