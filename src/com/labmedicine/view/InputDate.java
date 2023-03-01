package com.labmedicine.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputDate {

    public LocalDate inputDate(){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            LocalDate dt = LocalDate.parse(sc.nextLine(), dtf);
            return dt;
        }catch (DateTimeParseException e){
            System.out.println("Data inválida, tente novamente:");
            inputDate();
        }

        return null;
    }

}
