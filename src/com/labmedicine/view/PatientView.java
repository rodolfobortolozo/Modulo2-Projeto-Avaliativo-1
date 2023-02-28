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
    System.out.println("**Menu Paciente**");
    System.out.println("Selecione uma das opções abaixo");
    System.out.println("1. Cadastrar");
    System.out.println("2. Listar Todos");
    System.out.println("3. Pesquisar Paciente");
    System.out.println("9. Sair");
    Integer op = optionPatient();
    actions(op);
  }

  public Integer optionPatient() {
    Integer op;
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Opção: ");
      op = Integer.parseInt(scanner.nextLine());
      return op;

    } catch (InputMismatchException e) {
      System.out.println("Opção Inválida, tente novamente");
      optionPatient();
      return null;
    }
  }
  private void actions (Integer op){

    switch (op){
      case 1:
        addPatient();
        break;
      case 2:
        getAllPatient();
        patientMenu();
        break;
      case 3:
        getPatientbyName();
        patientMenu();
      case 9:
        menu.mainMenu();
        break;
    }
  }

  private void addPatient(){
    Patient patient = new Patient();
    Scanner sc = new Scanner(System.in);

    System.out.println("Informe o nome do Paciente");
    patient.setName(sc.nextLine());
    System.out.println("Informe o Genêro");
    System.out.println("1 - Masculino");
    System.out.println("2 - Feminino");
    patient.setGender(sc.nextLine());
    System.out.println("Informe a Data de Nascimento");

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    patient.setDateBirth(LocalDate.parse(sc.nextLine(), dtf));

    AllergyView allergyView = new AllergyView();
    patient.setAllergy(allergyView.addAllergy());

    CareListView careListView = new CareListView();
    patient.setCareList(careListView.addAllergy());

    System.out.println("Informe o cpf");
    patient.setCpf(sc.nextLine());
    System.out.println("Informe o telefone");
    patient.setPhone(sc.nextLine());
    patientController.save(patient);
    patientMenu();
  }

  private void getAllPatient(){
    List<Patient> patientList= patientController.getAll();
    renderizePatient(patientList);

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
}
