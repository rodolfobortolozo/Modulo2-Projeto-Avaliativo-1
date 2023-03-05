package com.labmedicine.view.reports;

import com.labmedicine.controller.DoctorController;
import com.labmedicine.controller.NurseController;
import com.labmedicine.controller.PatientController;
import com.labmedicine.model.Person;
import com.labmedicine.view.Menu;
import com.labmedicine.view.utils.IsInteger;

public class PersonReport {

  Menu menu = new Menu();

  public void reportPerson(){
    IsInteger isInteger = new IsInteger();

    System.out.println("Informe que tipo de Pessoa deseja visualizar");
    System.out.println("1 - Pacientes");
    System.out.println("2 - Enfermeiros");
    System.out.println("3 - Médicos");
    System.out.println("4 - Todos");
    System.out.println("9 - Voltar ao menu principal");
    Integer op = isInteger.getIsInteger();

    switch (op){
      case 1:
        rPatient();
        reportPerson();
        break;
      case 2:
        rNurse();
        reportPerson();
        break;
      case 3:
        rDoctor();
        reportPerson();
        break;
      case 4:
        rPatient();
        rNurse();
        rDoctor();
        reportPerson();
        break;
      case 9:
        menu.mainMenu();
        break;
      default:
        System.out.println("Opção inválida, tente novamente");
        reportPerson();
    }
  }

  private void rPatient(){
    PatientController patientController = new PatientController();

    System.out.println("Pacientes Cadastrados");
    for( Person person : patientController.getAll()){
      System.out.println("Código: "+person.getId()+" Nome:"+person.getName()+" CPF:"+person.getCpf());
    }
  }

  private void rNurse(){
    NurseController nurseController = new NurseController();

    System.out.println("Enfermeiros Cadastrados");
    for( Person person : nurseController.getAll()){
      System.out.println("Código: "+person.getId()+" Nome:"+person.getName()+" CPF:"+person.getCpf());
    }
  }

  private void rDoctor(){
    DoctorController doctorController = new DoctorController();

    System.out.println("Médicos Cadastrados");
    for( Person person : doctorController.getAll()){
      System.out.println("Código: "+person.getId()+" Nome:"+person.getName()+" CPF:"+person.getCpf());
    }
  }

}
