package com.labmedicine.repository.mocks;

import com.labmedicine.model.*;
import com.labmedicine.repository.DoctorRepository;
import com.labmedicine.repository.PatientRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Mocks {

  /*
  Médicos
   */
  DoctorRepository doctorRepository = new DoctorRepository();
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  Doctor doctor1 = new Doctor(1L, "Medico 1","366.817.166-88", LocalDate.parse("01/01/2020",dtf),"M",
                              "1799999999","fef","12345-6","SP", 1, 0, true );
  Doctor doctor2 = new Doctor(2L, "Medico 2","366.817.166-88", LocalDate.parse("01/01/2020",dtf),"M",
          "1799999999","fef","12345-6","SP", 1, 0, false );
  Doctor doctor3 = new Doctor(3L, "Medico 3","366.817.166-88", LocalDate.parse("01/01/2020",dtf),"M",
          "1799999999","fef","12345-6","SP", 1, 0, true );
  Doctor doctor4 = new Doctor(4L, "Medico 4","366.817.166-88", LocalDate.parse("01/01/2020",dtf),"M",
          "1799999999","fef","12345-6","SP", 1, 0, true );

  /*
  Pacientes
   */
  PatientRepository patientRepository = new PatientRepository();
  List<Allergy> allergy;
  List<CareList> careList;
  Patient patient1 = new Patient(1L,"Paciente 1", "366842555", LocalDate.parse("01/01/2020",dtf),"M","1799999999","178888888",
          allergy, careList,"UNIMED",123456,LocalDate.parse("01/01/2020",dtf), 0,0);
  Patient patient2 = new Patient(2L,"Paciente 2", "366842555", LocalDate.parse("01/01/2020",dtf),"M","1799999999","178888888",
          allergy, careList,"UNIMED",123456,LocalDate.parse("01/01/2020",dtf),1,0);
  Patient patient3 = new Patient(3L,"Paciente 3", "366842555", LocalDate.parse("01/01/2020",dtf),"M","1799999999","178888888",
          allergy, careList,"UNIMED",123456,LocalDate.parse("01/01/2020",dtf),2,0);
  Patient patient4 = new Patient(4L,"Paciente 4", "366842555", LocalDate.parse("01/01/2020",dtf),"M","1799999999","178888888",
          allergy, careList,"UNIMED",123456,LocalDate.parse("01/01/2020",dtf),0,0);

  public void insert(){
    doctorRepository.add(doctor1);
    doctorRepository.add(doctor2);
    doctorRepository.add(doctor3);
    doctorRepository.add(doctor4);

    patientRepository.add(patient1);
    patientRepository.add(patient2);
    patientRepository.add(patient3);
    patientRepository.add(patient4);
  }
}
