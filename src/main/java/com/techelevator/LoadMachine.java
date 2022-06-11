package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoadMachine {

    Map<String, Product> products = new HashMap<>();
    File productInventory = new File("C:\\Users\\bcame\\Documents\\Java work\\Capstone Section\\capstone-1\\vendingmachine.csv");
    int count = 0;
    Product test = new Product("","",0,"");


    {
        try {
           Scanner inventoryInput = new Scanner(productInventory);

           while (inventoryInput.hasNextLine()){
               String lineOfInput = inventoryInput.nextLine();
                String[] splitLine = lineOfInput.split("|");

               for (String index: splitLine){
                   if (count == 0){
                       test.setKey(index);
                       count++;
                   }else if(count == 1){
                       test.setName(index);
                       count++;
                   }else if (count == 3){
                       double newCost = Double.parseDouble(index);
                       test.setCost(newCost);
                       count++;
                   }else if(count == 4){
                       test.setType(index);
                   }
               }
               products.put(test.getKey(), test);
               System.out.println(splitLine);

           }



        } catch (FileNotFoundException e) {
            System.err.println("Inventory not found.");
        }
    }

    //reading code

    //assigning code

    //adding product -> map


}
