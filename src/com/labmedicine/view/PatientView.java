package com.labmedicine.view;

import com.labmedicine.controller.PatientController;
import com.labmedicine.model.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PatientView {
  static PatientController patientController;
  static Menu menu;

  static {
    patientController = new PatientController();
    menu = new Menu();
  }

  public void patientMenu(){
    Scanner scanner = new Scanner(System.in);
    Integer op = null;
    
    System.out.println("**Menu Paciente**");
    System.out.println("Selecione uma das opções abaixo");
    System.out.println("1. Cadastrar");
    System.out.println("2. Listar Todos");
    System.out.println("3. Pesquisar Paciente");
    System.out.println("9. Voltar para o Menu Principal");
    try{
      op = scanner.nextInt();
    }catch (InputMismatchException e){
      opcaoInvalida();
    }
    switch (op){
      case 1:
        addPatient();
        patientMenu();
        break;
      case 2:
        getAllPatient();
        patientMenu();
        break;
      case 3:
        getPatientbyName();
        patientMenu();
        break;
      case 9:
        menu.mainMenu();
        break;
      default:
        opcaoInvalida();
    }
  }

  private void addPatient(){
    Patient patient = new Patient();
    Scanner sc = new Scanner(System.in);
    InputDate dt = new InputDate();

    patient.setId(returnLastIdPatient());
    System.out.println("Informe o nome do Paciente");
    patient.setName(sc.nextLine());
    System.out.println("Informe o Genêro");
    System.out.println("M - Masculino");
    System.out.println("F - Feminino");
    patient.setGender(sc.nextLine());
    System.out.println("Informe a Data de Nascimento");
    patient.setDateBirth(dt.inputDate());
    AllergyView allergyView = new AllergyView();
    patient.setAllergy(allergyView.addAllergy());

    CareListView careListView = new CareListView();
    patient.setCareList(careListView.addAllergy());

    System.out.println("Informe o cpf");
    patient.setCpf(sc.nextLine());
    System.out.println("Informe o telefone");
    patient.setPhone(sc.nextLine());
    patientController.save(patient);
  }

  private void getAllPatient(){
    List<Patient> patientList= patientController.getAll();
    renderizePatient(patientList);

  }

  private Long returnLastIdPatient(){
    return Long.valueOf(patientController.getAll().size() + 1);
  }

  private void getPatientbyName(){
    Scanner sc = new Scanner(System.in);
    Patient patient = new Patient();
    System.out.print("Digite o nome:");
    patient.setName(sc.nextLine());
    List<Patient> patientList = patientController.getPatientbyName(patient);
    renderizePatient(patientList);

  }

  private void renderizePatient(List<Patient> patientList){
    System.out.println("**Pacientes Cadastrados**");
    for(int i=0; i<patientList.size();i++){
      System.out.print("Id: ");
      System.out.println(patientList.get(i).getId());
      System.out.print("Nome: ");
      System.out.println(patientList.get(i).getName());

      System.out.print("Alergia(s): ");
      for(int x=0; x<patientList.get(i).getAllergy().size();x++){
        System.out.print(patientList.get(i).getAllergy().get(x).getNameAllergy()+", ");
      }
      System.out.println();

      System.out.print("Lista de Cuidado(s): ");
      for(int x=0; x<patientList.get(i).getCareList().size();x++){
        System.out.print(patientList.get(i).getCareList().get(x).getCareList()+", ");
      }
      System.out.println();
    }
  }

  public void opcaoInvalida(){
    System.out.println("Opção Inválida, tente novamente");
    patientMenu();
  }
}

