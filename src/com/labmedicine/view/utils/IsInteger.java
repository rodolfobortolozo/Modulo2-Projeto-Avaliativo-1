package com.labmedicine.view.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class IsInteger {
    Scanner sc = new Scanner(System.in);
    public Integer getIsInteger(){

            try{
                return Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                System.out.println("Não é um número válido, tente novamente");
                getIsInteger();
                return null;
            }

    }
}
