package com.labmedicine.view;

import com.labmedicine.controller.CareListController;
import com.labmedicine.model.Allergy;
import com.labmedicine.model.CareList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CareListView {

    static CareListController careListController;

    static {
        careListController = new CareListController();
    }

    public List<CareList> addAllergy(){
        Integer op=0;
        List<CareList> listCareList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (op != 2){
            CareList careList = new CareList();
            System.out.println("Informe um Cuidado");
            careList.setCareList(sc.nextLine());
            listCareList.add(careList);
            careListController.save(careList);
            System.out.println("Deseja inserir outra cuidado?");
            System.out.println("1-Sim, 2-Não");
            op = Integer.parseInt(sc.nextLine());
        }
        return listCareList;
    }
}
