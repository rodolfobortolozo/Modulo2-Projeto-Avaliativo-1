package com.labmedicine.view.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class InputGender {
    Scanner sc = new Scanner(System.in);

    public String getinputGender(){

        System.out.println("M - Masculino");
        System.out.println("F - Feminino");
        String gender = sc.nextLine().toUpperCase();

            if(gender.equals("F") || gender.equals("M") ){
                return gender;
            }else{
                System.out.println("Genero inválido, tente novamente.");
                getinputGender();
                return null;
            }
    }

}
