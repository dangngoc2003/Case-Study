package Sevice.impl;

import Model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryManager implements ICrudManager<Category> {
public ArrayList<Category> categories;
public CategoryManager(){
    categories=new ArrayList<>();
}
public ArrayList<Category>getCategories(){
    return categories;
}

    @Override
    public Category create(Scanner scanner) {
        System.out.println("Enter your name category:");
        String name=scanner.nextLine();
        return new Category(name);
    }
    @Override
    public void save(Category category) {
categories.add(category);
        System.out.println("Add classroom successfully!");
        title();
        category.disPlay();
    }
    @Override
    public void update(Scanner scanner) {
Category category=findById(scanner);
if (category!=null){
    System.out.println("Enter name category");
    String name=scanner.nextLine();
    if (!category.equals("")){{
        category.setName(name);
    }}
}
    }

    @Override
    public void deleteById(Scanner scanner) {
Category category=findById(scanner);
if (category!=null){
    categories.remove(category);
    title();
    category.disPlay();
}else {
    System.out.println("Not exist category have this id!");
}
    }
    @Override
    public void disPlayAll(List<Category> categories) {
if (!categories.isEmpty()){
    System.out.println("list category :");
    for (Category temp: categories) {
        temp.disPlay();
    }
}
    }
    @Override
    public Category findById(Scanner scanner) {
        System.out.println("Enter id category : ");
        int id=Integer.parseInt(scanner.nextLine());
        for (Category temp: categories) {
            if (temp.getId()==id){
                return temp;
            }
        }
        return null;
    }
    public void title(){
        System.out.printf("%-15s%s","ID","NAME\n");
    }
}
