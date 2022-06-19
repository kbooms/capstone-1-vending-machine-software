package com.techelevator;

import java.util.Scanner;

public class Purchase {
    //product key
    String tempProductKey;
    public Purchase(){}

    //purchase method
    public String purchasing(){

        Scanner userSelect = new Scanner(System.in);
        System.out.print("Please enter key of the item you'd like: ");
        String productKey = userSelect.nextLine();
        System.out.println("You selected: " + productKey);

        this.tempProductKey = productKey;
        return tempProductKey;
    }

    //getter

    public String getTempProductKey() {
        return tempProductKey;
    }


    //if(key!exist || inventory == 0){
    //"Sorry this item is not available, returning to purchase menu:..."
    //}else {
    //"Dispensing product + product message."
    //remove cost from balance
}
