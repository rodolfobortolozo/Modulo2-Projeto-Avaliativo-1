package com.labmedicine.view.nurse;

import com.labmedicine.controller.NurseController;
import com.labmedicine.model.Doctor;
import com.labmedicine.model.Nurse;
import com.labmedicine.view.Menu;
import com.labmedicine.view.utils.IsDate;
import com.labmedicine.view.utils.InputGender;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class NurseView {
  static NurseController nurseController;
  static Menu menu;

  static {
    nurseController = new NurseController();
    menu = new Menu();
  }

  public void nurseMenu(){
    Scanner scanner = new Scanner(System.in);
    Integer op = null;

    System.out.println("**Menu Enfermeiro**");
    System.out.println("Selecione uma das opções abaixo");
    System.out.println("1. Cadastrar");
    System.out.println("2. Listar Todos");
    System.out.println("3. Pesquisar Enfermeiro");
    System.out.println("4. Alterar Enfermeiro");
    System.out.println("9. Voltar para o Menu Principal");
    try{
      op = scanner.nextInt();
    }catch (InputMismatchException e){
      opcaoInvalida();
    }
    switch (op){
      case 1:
        addNurse();
        nurseMenu();
        break;
      case 2:
        getAllNurse();
        nurseMenu();
        break;
      case 3:
        getNursebyName();
        nurseMenu();
        break;
      case 4:
        updateNurse();
        nurseMenu();
        break;
      case 9:
        menu.mainMenu();
        break;
      default:
        opcaoInvalida();
    }
  }

  private void addNurse(){
    Nurse nurse = viewNurse();
    nurse.setId(nurseController.returnLastIdNurse());
    nurseController.save(nurse);
    nurseMenu();
  }

  private void updateNurse(){
    Scanner sc = new Scanner(System.in);

    System.out.println("Informe o Código do Enfermeiro");
    String cod = sc.nextLine();
    Integer indice = nurseController.indexNurse(Long.valueOf(cod));

    if( indice >= 0){

      Nurse uNurse = viewNurse();
      uNurse.setId(Long.valueOf(cod));
      nurseController.updateNurse(indice, uNurse);
    }

    System.out.println("Médico não encontrado!");


  }

  private Nurse viewNurse(){
    Nurse nurse = new Nurse();
    Scanner sc = new Scanner(System.in);
    IsDate dt = new IsDate();
    InputGender ge = new InputGender();

    nurse.setId(returnLastIdNurse());
    System.out.println("Informe o nome do Enfermeiro");
    nurse.setName(sc.nextLine());
    System.out.println("Informe o Genêro");
    nurse.setGender(ge.getinputGender());
    System.out.println("Informe a Data de Nascimento");
    nurse.setDateBirth(dt.getIsDate());
    System.out.println("Informe o cpf");
    nurse.setCpf(sc.nextLine());
    System.out.println("Informe o telefone");
    nurse.setPhone(sc.nextLine());
    System.out.println("Instituiçáo de Ensino");
    nurse.setUniversity(sc.nextLine());
    System.out.println("COFEN");
    nurse.setCofen(sc.nextLine());
    System.out.println("UF");
    nurse.setUf(sc.nextLine());

    return nurse;
  }
  private void getAllNurse(){
    List<Nurse> nurseList = nurseController.getAll();
    renderizeNurse(nurseList);

  }

  private Long returnLastIdNurse(){
    return Long.valueOf(nurseController.returnLastIdNurse());
  }

  private void getNursebyName(){
    Scanner sc = new Scanner(System.in);
    Nurse nurse = new Nurse();
    System.out.print("Digite o nome:");
    nurse.setName(sc.nextLine());
    List<Nurse> patientList = nurseController.getNursebyName(nurse);
    renderizeNurse(patientList);

  }

  private void renderizeNurse(List<Nurse> nurseList){
    System.out.println("**Enfermeiros Cadastrados**");
    for(int i=0; i<nurseList.size();i++){
      System.out.print("Nome: ");
      System.out.println(nurseList.get(i).getName());
    }
  }

  public void opcaoInvalida(){
    System.out.println("Opção Inválida, tente novamente");
    nurseMenu();
  }
}