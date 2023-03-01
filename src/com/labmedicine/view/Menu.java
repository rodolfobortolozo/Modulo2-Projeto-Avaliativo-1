package com.labmedicine.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

  public void mainMenu(){
    PatientView patientView = new PatientView();
    NurseView nurseView = new NurseView();
    DoctorView doctorView = new DoctorView();

    Scanner scanner = new Scanner(System.in);
    Integer opcao = 0;

    System.out.println("Bem vindo ao sistema LABMedicine LTDA");
    System.out.println("Selecione uma das opções abaixo");
    System.out.println("1. Cadastro de Paciente");
    System.out.println("2. Cadastro de Enfermeiro");
    System.out.println("3. Cadastro de Médico");
    System.out.println("4. Realização de Atendimento Médico");
    System.out.println("5. Atualização do Status de Atendimento do Paciente");
    System.out.println("6. Relatórios");
    System.out.println("0. Sair");
    System.out.print("Selecione opção a opção:");
    try{
      opcao = scanner.nextInt();
    }catch (InputMismatchException e){
      opcaoInvalida();
    }

    switch (opcao){
      case 0:
        System.exit(0);
      case 1:
        patientView.patientMenu();
        break;
      case 2:
        nurseView.nurseMenu();
        break;
      case 3:
        doctorView.doctorMenu();
        break;
      default:
        opcaoInvalida();
    }
  }

  public void opcaoInvalida(){
    System.out.println("Opção Inválida, tente novamente");
    mainMenu();
  }
}
