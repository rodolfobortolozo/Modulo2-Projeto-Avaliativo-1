package com.labmedicine.view.reports;

import com.labmedicine.controller.NurseController;
import com.labmedicine.controller.PatientController;
import com.labmedicine.model.Patient;
import com.labmedicine.model.Person;
import com.labmedicine.view.Menu;
import com.labmedicine.view.utils.IsInteger;

public class PatientReport {

  Menu menu = new Menu();

  public void reportPatient(){
    IsInteger isInteger = new IsInteger();

    System.out.println("Informe que tipo de Pessoa deseja visualizar");
    System.out.println("0 - Não Atendido");
    System.out.println("1 - Atendido");
    System.out.println("2 - Em Atendimento");
    System.out.println("3 - Aguardando Atendimento");

    System.out.println("9 - Voltar ao menu principal");
    Integer op = isInteger.getIsInteger();

    rPatient(op);

    menu.mainMenu();

  }

  private void rPatient(Integer op){
    PatientController patientController = new PatientController();
    Patient opPatient;

    System.out.println("Pacientes");
    for( Patient patient : patientController.getByStatusConsult(op)){
      System.out.println("Código: "+patient.getId()+" Nome:"+patient.getName()+" CPF:"+patient.getCpf());
    }
  }
}
