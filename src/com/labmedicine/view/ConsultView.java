package com.labmedicine.view;

import com.labmedicine.controller.ConsultController;
import com.labmedicine.controller.DoctorController;
import com.labmedicine.controller.PatientController;
import com.labmedicine.model.Doctor;
import com.labmedicine.repository.DoctorRepository;
import com.labmedicine.view.utils.IsInteger;

import javax.print.Doc;
import java.util.List;
import java.util.Scanner;

public class ConsultView {
    IsInteger isInteger = new IsInteger();
    static DoctorController doctorController;
    static PatientController patientController;

    static {
        doctorController= new DoctorController();
        patientController = new PatientController();
        }


    public void addConsult(){
        System.out.println("Informe o Médico responsável pela consulta");

        for(Doctor doctor : doctorController.getAll()){
            System.out.println(doctor.getId()+"-"+doctor.getName());
        }
        Integer opDoctor = isInteger.getIsInteger();

        System.out.println("Informe o Paciente da Consulta");

        for(Doctor doctor : doctorController.getAll()){
            System.out.println(doctor.getId()+"-"+doctor.getName());
        }
        Integer opPatient = isInteger.getIsInteger();

    }
}
