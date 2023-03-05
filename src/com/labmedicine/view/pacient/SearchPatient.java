package com.labmedicine.view.pacient;

import com.labmedicine.controller.DoctorController;
import com.labmedicine.controller.PatientController;
import com.labmedicine.model.Patient;
import com.labmedicine.view.utils.IsInteger;

public class SearchPatient {

  static PatientController patientController;
  IsInteger isInteger = new IsInteger();
  Patient patient = new Patient();

  static {
    patientController = new PatientController();
  }
  public Patient search(){

    System.out.println("Informe código do Paciente");

    for(Patient patient : patientController.getAll()){
      System.out.println(patient.getId()+"-"+patient.getName());
    }
    Long opPatient = Long.valueOf(isInteger.getIsInteger());
    patient = patientController.getById(opPatient);

    if(patient!=null){
      return patient;
    }else {
      return  null;
    }

  }
}
