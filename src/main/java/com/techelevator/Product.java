package com.techelevator;

public class Product {

    //variables
    private String name;
    private double cost;
    private String type;
    private String key;

    private int inventory = 5;

    //constructor
    public Product(String key, String name, double cost, String type){
        this.key = key;
        this.name = name;
        this.cost = cost;
        this.type = type;

    }
    //message method
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
