package com.labmedicine.view.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class IsDate {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

    public LocalDate getIsDate(){

        try{
            LocalDate dt = LocalDate.parse(sc.nextLine(), dtf);
            return dt;
        }catch (DateTimeParseException e){
            System.out.println("Data inválida, tente novamente");
            getIsDate();
            return null;
        }

    }

}
