package com.serverprojectjava.Server.Module;

public class Products {
    private int ID;
    private String name;
    private int price;
    private byte[] image;

    public Products(int iD, String name, int price, byte[] image) {
        ID = iD;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public byte[] getImage() {
        return image;
    }
}
