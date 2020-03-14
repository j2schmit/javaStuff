package com.adv.java.restaurant;

public class Restaurant {

    private String name;
    private int zipcode;
    private String neighborhood;

    public Restaurant(String name, int zipcode, String neighborhood) {
        this.name = name.replaceAll("'", "\"");
        this.zipcode = zipcode;
        this.neighborhood = neighborhood.replaceAll("'", "\"");
    }

    public String getName() {
        return name;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String toString() {
        String str = "Name: " + name + "\n";
        str += "Zipcode: " + zipcode + "\n";
        str += "Neighborhood: " + neighborhood;
        return str;
    }

    public boolean complete() {
        return true;
    }
}
