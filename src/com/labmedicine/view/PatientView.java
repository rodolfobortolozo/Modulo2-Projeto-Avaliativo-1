package com.labmedicine.view;

import com.labmedicine.controller.PatientController;
import com.labmedicine.model.Patient;
import com.labmedicine.repository.PatientRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PatientView {

  static Patient patient;

  static {
    patient = new Patient();
  }

  public void patientMenu(){
    System.out.println("**Menu Paciente**");
    System.out.println("Selecione uma das opções abaixo");
    System.out.println("1. Cadastrar");
    System.out.println("2. Alterar");
    Integer op = optionPatient();
    actions(op);

  }

  public Integer optionPatient() {
    Integer op;
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Número selecionado: ");
      op = scanner.nextInt();
      return op;

    } catch (InputMismatchException e) {
      System.out.println("Opção Inválida, tente novamente");
      optionPatient();
      return null;
    }
  }
  public void actions (Integer op){
    PatientController patientController = new PatientController();
    switch (op){
      case 1:
        patient = new Patient("1",2, "A");
        patientController.save(patient);
        optionPatient();
        break;
      case 2:
        System.out.println(patient.toString());
        optionPatient();
        break;
    }
  }

}
