package Sevice.impl.ProductManager;

import Model.Category;
import Model.Product;

public class Candy extends Product {
  int weight;

    public Candy() {
    }

    public Candy(int id, String name, Double price, int quantity, Category category, int weight) {
        super(id, name, price, quantity, category);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "weight=" + weight +
                '}';
    }

    @Override
    public void display() {

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s",
                id, name, price, quantity, category.getName(),weight,"","" + "\n");
    }
}
