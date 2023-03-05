package com.labmedicine.view.pacient;

import com.labmedicine.controller.AllergyController;
import com.labmedicine.model.Allergy;
import com.labmedicine.view.utils.IsInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllergyView {
    Scanner sc = new Scanner(System.in);
    static AllergyController allergyController;

    static {
        allergyController = new AllergyController();
    }

    public List<Allergy> addAllergy(){
        Integer op = 0;
        IsInteger isInteger = new IsInteger();
        List<Allergy> listAllergy = new ArrayList<>();


        System.out.println("O Paciente tem Alergia");
        System.out.println("1-Sim, 2-Não");
        op = isInteger.getIsInteger();

        while (op != 2){
            Allergy allergy = new Allergy();
            System.out.println("Informe uma Alergia");
            allergy.setNameAllergy(sc.nextLine());
            listAllergy.add(allergy);
            allergyController.save(allergy);
            System.out.println("Deseja inserir outra Aleria?");
            System.out.println("1-Sim, 2-Não");
            op = Integer.parseInt(sc.nextLine());
        }
        return listAllergy;
    }
}
