package com.labmedicine.view.doctor;

import com.labmedicine.controller.DoctorController;
import com.labmedicine.controller.PatientController;
import com.labmedicine.model.Doctor;
import com.labmedicine.model.Patient;
import com.labmedicine.view.Menu;
import com.labmedicine.view.pacient.SearchPatient;
import com.labmedicine.view.utils.IsInteger;

public class ConsultView {
    IsInteger isInteger = new IsInteger();
    Patient patient;
    SearchPatient searchPatient = new SearchPatient();
    SearchDoctor searchDoctor = new SearchDoctor();
    Doctor doctor;
    static DoctorController doctorController;
    static PatientController patientController;

    static {
        doctorController= new DoctorController();
        patientController = new PatientController();
        }


    public void addConsult(){

        Menu menu = new Menu();

        while(doctor == null){
            doctor = searchDoctor.search();
        }

        while( patient == null){
            patient = searchPatient.search();
        }

        Integer indexDoctor = doctorController.indexDoctor(doctor.getId());
        Integer indexPatient = patientController.indexPatient(patient.getId());

        doctor.setQtdConsult(doctor.getQtdConsult()+1);
        patient.setQtdConsult(patient.getQtdConsult()+1);

        patientController.updatePatient(indexPatient, patient);
        doctorController.updateDoctor(indexDoctor, doctor);

        menu.mainMenu();

    }

}
