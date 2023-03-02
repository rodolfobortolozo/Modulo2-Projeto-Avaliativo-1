package com.labmedicine.controller;

import com.labmedicine.model.Doctor;
import com.labmedicine.model.Nurse;
import com.labmedicine.repository.DoctorRepository;
import com.labmedicine.repository.NurseRepository;

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

    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }

    public Long returnLastIdDoctor(){
        return Long.valueOf(getAll().size() + 1);
    }

    public List<Doctor> getNursebyName(Doctor doctor){
        return doctorRepository.getByName(doctor);
    }
}
