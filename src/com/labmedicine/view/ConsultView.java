package com.labmedicine.view;

import com.labmedicine.controller.DoctorController;
import com.labmedicine.controller.PatientController;
import com.labmedicine.model.Doctor;
import com.labmedicine.model.Patient;
import com.labmedicine.view.utils.IsInteger;

public class ConsultView {
    IsInteger isInteger = new IsInteger();
    Patient patient = new Patient();
    Doctor doctor = new Doctor();
    static DoctorController doctorController;
    static PatientController patientController;

    static {
        doctorController= new DoctorController();
        patientController = new PatientController();
        }


    public void addConsult(){

        ConsultView consultView = new ConsultView();
        doctor = consultView.searchDoctor();
        patient = consultView.searchPatient();



    }

    private  Doctor searchDoctor(){

        System.out.println("Informe o código do médico");

        for(Doctor doctor : doctorController.getAll()){
            if(doctor.getStatus() == true){
                System.out.println(doctor.getId()+"-"+doctor.getName() +" Crm:"+doctor.getCrm());
            }
        }

        Long opDoctor = Long.valueOf(isInteger.getIsInteger());
        doctor = doctorController.getById(opDoctor);

        if(doctor!=null){
            return doctor;
        }else {
            searchDoctor();
            return  null;
        }

    }

    private  Patient searchPatient(){

        System.out.println("Informe código do Paciente");

        for(Patient patient : patientController.getAll()){
            System.out.println(patient.getId()+"-"+patient.getName());
        }
        Long opPatient = Long.valueOf(isInteger.getIsInteger());
        patient = patientController.getById(opPatient);

        if(patient!=null){
            return patient;
        }else {
            searchDoctor();
            return  null;
        }

    }
}
