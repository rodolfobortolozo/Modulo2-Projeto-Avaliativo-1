package com.labmedicine.view.doctor;

import com.labmedicine.controller.DoctorController;

import com.labmedicine.model.Doctor;
import com.labmedicine.view.Menu;
import com.labmedicine.view.utils.IsDate;
import com.labmedicine.view.utils.InputGender;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class  DoctorView {
  static DoctorController doctorController;
  static Menu menu;

  static {
    doctorController = new DoctorController();
    menu = new Menu();
  }

  public void doctorMenu(){
    Scanner scanner = new Scanner(System.in);
    Integer op = null;

    System.out.println("**Menu Médico**");
    System.out.println("Selecione uma das opções abaixo");
    System.out.println("1. Cadastrar");
    System.out.println("2. Listar Todos");
    System.out.println("3. Pesquisar Médico");
    System.out.println("4. Alterar Médico");
    System.out.println("9. Voltar para o Menu Principal");
    try{
      op = scanner.nextInt();
    }catch (InputMismatchException e){
      opcaoInvalida();
    }
    switch (op){
      case 1:
        addDoctor();
        doctorMenu();
        break;
      case 2:
        getAllDoctor();
        doctorMenu();
        break;
      case 3:
        getDoctorbyName();
        doctorMenu();
        break;
      case 4:
        updateDoctor();
        doctorMenu();
        break;
      case 9:
        menu.mainMenu();
        break;
      default:
        opcaoInvalida();
    }
  }

  private void addDoctor(){
    Doctor doctor = viewDoctor();
    doctor.setId(doctorController.returnLastIdDoctor());

    doctorController.save(doctor);
    doctorMenu();
  }

  private void updateDoctor(){
    Scanner sc = new Scanner(System.in);

    System.out.println("Informe o Código do Médico");
    String cod = sc.nextLine();
    Integer indice = doctorController.indexDoctor(Long.valueOf(cod));

    if( indice >= 0){

      Doctor uDoctor = viewDoctor();
      uDoctor.setId(Long.valueOf(cod));
      doctorController.updateDoctor(indice, uDoctor);
    }

    System.out.println("Médico não encontrado!");


  }

  private Doctor viewDoctor(){
    Doctor doctor = new Doctor();
    Scanner sc = new Scanner(System.in);
    IsDate dt = new IsDate();
    InputGender ge = new InputGender();

    doctor.setId(returnLastIdNurse());
    System.out.println("Informe o nome do Médico");
    doctor.setName(sc.nextLine());
    System.out.println("Informe o Genêro");
    doctor.setGender(ge.getinputGender());
    System.out.println("Informe a Data de Nascimento");
    doctor.setDateBirth(dt.getIsDate());
    System.out.println("Informe o cpf");
    doctor.setCpf(sc.nextLine());
    System.out.println("Informe o telefone");
    doctor.setPhone(sc.nextLine());
    System.out.println("Instituiçáo de Ensino");
    doctor.setUniversity(sc.nextLine());
    System.out.println("CRM");
    doctor.setCrm(sc.nextLine());
    System.out.println("UF");
    doctor.setUf(sc.nextLine());
    System.out.println("Especialização");
    Integer opSpec = renderizeSpecialization();
    doctor.setSpecialization(opSpec);

    return doctor;

  }

  private Integer renderizeSpecialization(){
    Integer op = 0;
    Scanner sc = new Scanner(System.in);
    System.out.println("1. Clínico Geral");
    System.out.println("2. Anestesista");
    System.out.println("3. Dermatologia");
    System.out.println("4. Ginecologia");
    System.out.println("5. Neurologia");
    System.out.println("6. Pediatria");
    System.out.println("7. Psiquiatria");
    System.out.println("8. Ortopedia");

    try{
      op = Integer.parseInt(sc.nextLine());
      if(op<0 || op>8){
        System.out.println("Especialização Não Encontrada");
        renderizeSpecialization();
    }
    }catch (NumberFormatException e){
      System.out.println("Especialização Inválida");
      renderizeSpecialization();
    }

    return op;

  }

  public void getAllDoctor(){
    List<Doctor> doctorList = doctorController.getAll();
    renderizeDoctor(doctorList);

  }

  private Long returnLastIdNurse(){
    return Long.valueOf(doctorController.returnLastIdDoctor());
  }

  private void getDoctorbyName(){
    Scanner sc = new Scanner(System.in);
    Doctor doctor = new Doctor();
    System.out.print("Digite o nome:");
    doctor.setName(sc.nextLine());
    List<Doctor> doctorList = doctorController.getDoctorbyName(doctor);
    renderizeDoctor(doctorList);

  }

  private void renderizeDoctor(List<Doctor> doctorList){
    System.out.println("**Médicos Cadastrados**");
    for(int i=0; i<doctorList.size();i++){
      System.out.println("Id:"+ doctorList.get(i).getId()+ " Nome: " + doctorList.get(i).getName()+" CRM: "+doctorList.get(i).getCrm());

    }
  }

  public void opcaoInvalida(){
    System.out.println("Opção Inválida, tente novamente");
    doctorMenu();
  }
}
