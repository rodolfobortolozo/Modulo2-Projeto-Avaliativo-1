package com.labmedicine.view.pacient;

import com.labmedicine.controller.PatientController;
import com.labmedicine.model.Patient;
import com.labmedicine.view.Menu;
import com.labmedicine.view.utils.IsDate;
import com.labmedicine.view.utils.InputGender;

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
    System.out.println("4. Alterar Paciente");
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
      case 4:
        updatePatient();
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

    Patient patient = viewPatient();
    patient.setId(returnLastIdPatient());

    patientController.save(patient);
  }

  private void updatePatient(){
    Scanner sc = new Scanner(System.in);

    System.out.println("Informe o Código do Paciente");
    String cod = sc.nextLine();
    Integer indice = patientController.indexPatient(Long.valueOf(cod));

    if( indice >= 0){

      Patient uPatient = viewPatient();
      uPatient.setId(Long.valueOf(cod));
      patientController.updatePatient(indice, uPatient);
    }

    System.out.println("Paciente não encontrado!");


  }

  private Patient viewPatient(){
    Patient patient = new Patient();

    AllergyView allergyView = new AllergyView();
    CareListView careListView = new CareListView();
    Scanner sc = new Scanner(System.in);
    IsDate dt = new IsDate();
    InputGender ge = new InputGender();

    System.out.println("Informe o nome do Paciente");
    patient.setName(sc.nextLine());
    System.out.println("Informe o Genêro");
    patient.setGender(ge.getinputGender());
    System.out.println("Informe a Data de Nascimento");
    patient.setDateBirth(dt.getIsDate());
    //Alergias
    patient.setAllergy(allergyView.addAllergy());
    //Lista de Cuidados
    patient.setCareList(careListView.addCareList());

    System.out.println("Informe o cpf");
    patient.setCpf(sc.nextLine());
    System.out.println("Informe o telefone");
    patient.setPhone(sc.nextLine());

    return patient;
  }

  private void getAllPatient(){
    List<Patient> patientList = patientController.getAll();
    renderizePatient(patientList);

  }

  private Long returnLastIdPatient(){
    return patientController.returnLastIdPatient();
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
      System.out.print("Id: "+ patientList.get(i).getId()+ " Nome: "+patientList.get(i).getName()+" ");

      System.out.print("Alergia(s): ");
      try{
        for(int x=0; x<patientList.get(i).getAllergy().size();x++){
          System.out.print(patientList.get(i).getAllergy().get(x).getNameAllergy()+", ");
        }
      }catch(NullPointerException e) {

      }

      System.out.print(" ");

      System.out.print("Lista de Cuidado(s): ");
      try {
        for (int x = 0; x < patientList.get(i).getCareList().size(); x++) {
          System.out.print(patientList.get(i).getCareList().get(x).getCareList() + ", ");
        }
      }catch (NullPointerException e){

      }
      System.out.println();
    }
  }

  private void opcaoInvalida(){
    System.out.println("Opção Inválida, tente novamente");
    patientMenu();
  }
}

