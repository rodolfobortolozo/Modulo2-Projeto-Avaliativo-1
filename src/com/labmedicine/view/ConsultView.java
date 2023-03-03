package com.labmedicine.view;

import com.labmedicine.controller.ConsultController;
import com.labmedicine.controller.DoctorController;
import com.labmedicine.controller.PatientController;
import com.labmedicine.model.Doctor;
import com.labmedicine.model.Patient;
import com.labmedicine.repository.DoctorRepository;
import com.labmedicine.view.utils.IsInteger;

import javax.print.Doc;
import java.util.List;
import java.util.Scanner;

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
        Integer opDoctor = consultView.searchDoctor();
        Integer opPatient = consultView.searchPatient();

        patient = patientController.getById(opPatient);
        doctor = doctorController.getById(opDoctor);

        patient.setQtdConsult(patient.getQtdConsult()+1);
        doctor.setQtdConsult(doctor.getQtdConsult()+1);

    }

    private  Integer searchDoctor(){

        System.out.println("Informe o Médico responsável pela consulta");

        for(Doctor doctor : doctorController.getAll()){
            System.out.println(doctor.getId()+"-"+doctor.getName());
        }
        Integer opDoctor = isInteger.getIsInteger();

        if(doctorController.existsDoctor(Long.valueOf(opDoctor))){
            return opDoctor;
        }else {
            searchDoctor();
            return  null;
        }

    }

    private  Integer searchPatient(){

        System.out.println("Informe o Paciente da Consulta");

        for(Patient patient : patientController.getAll()){
            System.out.println(patient.getId()+"-"+patient.getName());
        }
        Integer opPatient = isInteger.getIsInteger();

        if(patientController.existsPatient(Long.valueOf(opPatient))){
            return opPatient;
        }else {
            searchPatient();
            return  null;
        }

    }
}
