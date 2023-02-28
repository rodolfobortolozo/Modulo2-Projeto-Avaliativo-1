package com.labmedicine.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

  public  void mainMenu(){
    System.out.println("Bem vindo ao sistema LABMedicine LTDA");
    System.out.println("Selecione uma das opções abaixo");
    System.out.println("1. Cadastro de Paciente");
    System.out.println("2. Cadastro de Enfermeiro");
    System.out.println("3. Cadastro de Médico");
    System.out.println("4. Realização de Atendimento Médico");
    System.out.println("5. Atualização do Status de Atendimento do Paciente");
    System.out.println("6. Relatórios");
    System.out.println("0. Sair");
  }

  public Integer optionMenu(){
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Número selecionado: ");
      Integer op = Integer.parseInt(scanner.nextLine());
      return op;

    }catch (InputMismatchException e){
      System.out.println("Opção Inválida, tente novamente");
      optionMenu();
      return null;
    }

  }
}
