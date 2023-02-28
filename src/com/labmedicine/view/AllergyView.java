package com.labmedicine.view;

import com.labmedicine.controller.AllergyController;
import com.labmedicine.model.Allergy;
import com.labmedicine.repository.AllergyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllergyView {

    static AllergyController allergyController;

    static {
        allergyController = new AllergyController();
    }

    public List<Allergy> addAllergy(){
        Integer op = 0;
        List<Allergy> listAllergy = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
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
