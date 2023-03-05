package com.labmedicine.view.doctor;

import com.labmedicine.controller.DoctorController;
import com.labmedicine.controller.PatientController;
import com.labmedicine.model.Doctor;
import com.labmedicine.view.utils.IsInteger;

public class SearchDoctor {

  IsInteger isInteger = new IsInteger();
  Doctor doctor = new Doctor();
  static DoctorController doctorController;

  static {
    doctorController= new DoctorController();

  }
  public Doctor search(){

    System.out.println("Informe o código do médico");

    for(Doctor doctor : doctorController.getAll()){
      if(doctor.getStatus().equals(true)){
        System.out.println(doctor.getId()+"-"+doctor.getName() +" Crm:"+doctor.getCrm());
      }
    }

    Long opDoctor = Long.valueOf(isInteger.getIsInteger());
    doctor = doctorController.getById(opDoctor);

    if(doctor!=null){
      return doctor;
    }else {
      return  null;
    }

  }
}
