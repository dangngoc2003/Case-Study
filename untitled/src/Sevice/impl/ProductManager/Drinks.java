package Sevice.impl.ProductManager;

import Model.Category;
import Model.Product;

public class Drinks extends Product {
    Double volume;
    String bottleType;

    public Drinks() {
    }

    public Drinks(int id, String name, Double price, int quantity, Category category, Double volume, String bottleType) {
        super( id,name, price, quantity, category);
        this.volume = volume;
        this.bottleType = bottleType;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getBottleType() {
        return bottleType;
    }

    public void setBottleType(String bottleType) {
        this.bottleType = bottleType;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "volume=" + volume +
                ", bottleType='" + bottleType + '\'' +
                '}';
    }

    @Override
    public void display() {

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s",
                id, name, price, quantity, category.getName(),"",volume,bottleType+  "\n");
    }
}
