package com.techelevator;

public class Product {

    //variables
    private String name;
    private double cost;
    private String type;
    private String key;

    private int inventory;

    //constructor
    public Product(String key, String name, double cost, String type, int inventory){
        this.key = key;
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.inventory = inventory;

    }
    //message method
    //split case so recall getType() of product for purchase
    public String getMessage(){

        String message = "";
        switch (getType()) {
            case "Chip": message = "Crunch Crunch, Yum!";
            break;
            case "Candy": message = "Munch Munch, Yum!";
            break;
            case "Drink": message = "Glug Glug, Yum!";
            break;
            case "Gum": message = "Chew Chew, Yum!";
            break;
        }
        return message;
    }

    public int getReducedInventory(boolean purchasable){

        if (purchasable == true){
            this.inventory = getInventory()-1;
        }
        return this.inventory;
    }

    public String isSoldOut(){
        int heldInventory = getInventory();
        String isInventory;
        if (heldInventory == 0){
            isInventory = "SOLD OUT";
        }else{
            isInventory = "AVAILABLE";
        }
        return isInventory;
    }

    //getters
    public String getName() {
        return name;
    }
    public double getCost() {
        return cost;
    }
    public String getType() {
        return type;
    }
    public String getKey() {
        return key;
    }
    public int getInventory() {
        return inventory;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
