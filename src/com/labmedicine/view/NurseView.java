package com.labmedicine.view;

import com.labmedicine.controller.NurseController;
import com.labmedicine.model.Nurse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    System.out.println("**Menu Enfermeiro**");
    System.out.println("Selecione uma das opções abaixo");
    System.out.println("1. Cadastrar");
    System.out.println("2. Listar Todos");
    System.out.println("3. Pesquisar Enfermeiro");
    System.out.println("9. Sair");
    Integer op = optionNurse();
    actions(op);
  }

  public Integer optionNurse() {
    Integer op;
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Opção: ");
      op = Integer.parseInt(scanner.nextLine());
      return op;

    } catch (InputMismatchException e) {
      System.out.println("Opção Inválida, tente novamente");
      optionNurse();
      return null;
    }
  }
  private void actions (Integer op){

    switch (op){
      case 1:
        addNurse();
        break;
      case 2:
        getAllNurse();
        nurseMenu();
        break;
      case 3:
        getNursebyName();
        nurseMenu();
      case 9:
        menu.mainMenu();
        break;
    }
  }

  private void addNurse(){
    Nurse nurse = new Nurse();
    Scanner sc = new Scanner(System.in);

    System.out.println("Informe o nome do Enfermeiro");
    nurse.setName(sc.nextLine());
    System.out.println("Informe o Genêro");
    System.out.println("1 - Masculino");
    System.out.println("2 - Feminino");
    nurse.setGender(sc.nextLine());
    System.out.println("Informe a Data de Nascimento");

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    nurse.setDateBirth(LocalDate.parse(sc.nextLine(), dtf));

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

    nurseController.save(nurse);
    nurseMenu();
  }

  private void getAllNurse(){
    List<Nurse> nurseList = nurseController.getAll();
    renderizeNurse(nurseList);

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
}
