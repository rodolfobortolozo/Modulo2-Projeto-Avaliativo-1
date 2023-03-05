package com.labmedicine.view.pacient;

import com.labmedicine.controller.PatientController;
import com.labmedicine.model.Patient;
import com.labmedicine.view.Menu;
import com.labmedicine.view.utils.IsInteger;

import java.util.Scanner;

public class StatusPatient {

  public void updateStatusPatient(){
    SearchPatient searchPatient = new SearchPatient();
    Patient patient = null;
    Integer index = null;
    Menu menu = new Menu();

    IsInteger isInteger = new IsInteger();
    PatientController patientController= new PatientController();

    while(patient == null){
      patient = searchPatient.search();
    }

    index = patientController.indexPatient(patient.getId());

    System.out.println("Status Atual do Paciente: "+ status(patient.getStatusConsult()));


    System.out.println("Selecione o status para alterar");
    System.out.println("0 - Não Atendido");
    System.out.println("1 - Atendido");
    System.out.println("2 - Em Atendimento");
    System.out.println("3 - Aguardando Atendimento");

    Integer op = isInteger.getIsInteger();
    patient.setStatusConsult(op);

    try {
    patientController.updatePatient(index, patient);
      menu.mainMenu();
    }catch (Exception e){
      System.out.println("Erro ao Alterar Status do Paciente");
      menu.mainMenu();

    }


  }

  private String status(Integer id){

    switch (id){
      case 0:
        return "Não Atendido";
      case 1:
        return "Atendido";
      case 2:
        return "Em Atendido";
      case 3:
        return "Aguardando Atendido";
      default:
        System.out.println("Opção Inválida");
    }

    return null;
  }
}
