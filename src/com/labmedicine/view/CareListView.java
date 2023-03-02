package com.labmedicine.view;

import com.labmedicine.controller.CareListController;
import com.labmedicine.model.CareList;
import com.labmedicine.view.utils.IsInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CareListView {
    Scanner sc = new Scanner(System.in);
    static CareListController careListController;

    static {
        careListController = new CareListController();
    }

    public List<CareList> addCareList(){
        Integer op=0;
        IsInteger isInteger = new  IsInteger();
        List<CareList> listCareList = new ArrayList<>();

        System.out.println("Deseja informar a lista de Cuidados");
        System.out.println("1-Sim, 2-Não");
        op = isInteger.getIsInteger();

        while (op != 2){
            CareList careList = new CareList();
            System.out.println("Informe um Cuidado");
            careList.setCareList(sc.nextLine());
            listCareList.add(careList);
            careListController.save(careList);
            System.out.println("Deseja inserir outro cuidado?");
            System.out.println("1-Sim, 2-Não");
            op = Integer.parseInt(sc.nextLine());
        }
        return listCareList;
    }
}
