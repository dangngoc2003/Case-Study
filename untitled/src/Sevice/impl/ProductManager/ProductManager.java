package Sevice.impl.ProductManager;

import Model.Category;
import Model.Product;
import Sevice.impl.CategoryManager;
import Sevice.impl.ICrudManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements ICrudManager<Product> {
static int index=1;
   public List<Product> listProduct;
    public Drinks drinks=new Drinks();
    public Candy candy=new Candy();
    public CategoryManager categoryManager;
    public ProductManager(CategoryManager categoryManager){
        listProduct=new ArrayList<>();
        this.categoryManager=categoryManager;
    }
    public CategoryManager getCategoryManager(){
        return categoryManager;
    }
    @Override
    public Product create(Scanner scanner) {
        System.out.println("Enter your name product");
        String name=scanner.nextLine();
        System.out.println("Enter your price product");
        Double price=Double.parseDouble(scanner.nextLine());
        System.out.println("Enter your quantity product : ");
        int quantity=Integer.parseInt(scanner.nextLine());
        categoryManager.disPlayAll(categoryManager.getCategories());
        Category category=choiceCategory(scanner);
        return choiceProduct(scanner,name,price,quantity,category) ;
    }
    public Category choiceCategory(Scanner scanner){
        Category category;

        System.out.println("Enter choice classroom by id: (Enter 0 for create new)");
       int choice=Integer.parseInt(scanner.nextLine());
       if (choice==0){
           category=categoryManager.create(scanner);
           categoryManager.save(category);
       }else {
           category=categoryManager.findById(scanner);
        }if (category!=null){
           return category;
        }else {
            System.out.println("no type with corresponding id!!!");
           return choiceCategory(scanner);
        }
    }
    public Product choiceProduct(Scanner scanner,String name,Double price,int quantity,Category category){

           System.out.println("1. candy:");
           System.out.println("2. drink:");
           System.out.println("3. Another products :");
           System.out.println("Enter choice :");
           int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
               case 1:
                   System.out.println("Enter weight candy");
                   int weight = Integer.parseInt(scanner.nextLine());
                   Candy candy = new Candy(index++,name, price, quantity, category, weight);
                   return candy;
               case 2:
                   System.out.println("Enter volume drink :");
                   Double volume = Double.parseDouble(scanner.nextLine());
                   System.out.println("Enter bottleType drink :");
                   String bottleType = scanner.nextLine();
                   Drinks drinks = new Drinks(index++,name, price, quantity, category, volume, bottleType);
                   return drinks;
               default:
                   System.out.println("Enter new product :");
                   return new Product(index++,name, price, quantity, category);
           }
    }
    @Override
    public void save(Product product) {
    }
    public void save(Scanner scanner){
        listProduct.add(create(scanner));
    }
    @Override
    public void update(Scanner scanner) {
        System.out.println("Enter id want update :");
        int id=Integer.parseInt(scanner.nextLine());
        for (Product temp: listProduct) {
            if (temp.getId()==id){
                System.out.println("Enter name new update:");
                String name =scanner.nextLine();
                temp.setName(name);
                System.out.println("Enter new price product:");
                Double price=Double.parseDouble(scanner.nextLine());
                temp.setPrice(price);
                System.out.println("Enter new quantity product :");
                int quantity=Integer.parseInt(scanner.nextLine());
                temp.setQuantity(quantity);
                System.out.println("Enter new category product :");

                categoryManager.create(scanner);
            }
        }
    }
    @Override
    public void deleteById(Scanner scanner) {
        System.out.println("Enter id want delete :");
        int index=Integer.parseInt(scanner.nextLine());
        for (Product temp:listProduct) {
            if (temp.getId()==index){
                listProduct.remove(temp);
                temp.display();
                System.out.println("you have successfully deleted!!!");
            }else {
                System.out.println("Can't find the object you want to delete!!");
            }
        }

    }

    @Override
    public void disPlayAll(List<Product> element) {

    }
    public void disPlayAll() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s" ,
                          "id", "name", "price", "quantity", "category","weight","volume","bottleType"+  "\n");
        for (Product temp:listProduct) {
            temp.display();
        }
    }
    @Override
    public Product findById(Scanner scanner) {
        System.out.println("Enter id want search :");
        int id=Integer.parseInt(scanner.nextLine());
        for (Product temp:listProduct) {
            if (id== temp.getId()){
                temp.display();
            }else {
                System.out.println("no object with corresponding id!!!");
            }
        }
return null;
    }
    public void searchCandy(){
        for (Product element:
             listProduct) {
            if (element instanceof Candy){
                element.display();
            }
        }
    }
    public void searchDrink(){
        for (Product element:listProduct) {
            if (element instanceof Drinks){
                element.display();
            }
        }
    }
    public void maxPriceProduct() {
        Double maxPrice = listProduct.get(0).getPrice();
        for (Product temp : listProduct) {
            if (temp.getPrice() >= maxPrice) {
                maxPrice = temp.getPrice();

            }
        }
        for (Product element : listProduct) {
            if (element.getPrice() == maxPrice) {
                element.display();
            }

        }
    }
    public void minPriceProduct(){
        Double minPrice=listProduct.get(0).getPrice();
        for (Product temp:listProduct) {
            if (temp.getPrice()<=minPrice){
                minPrice=temp.getPrice();

                }
            } for (Product element:listProduct) {
                if (element.getPrice()==minPrice){
                    element.display();
                }
        }
    }
    public void mostProduct(){
        int most=listProduct.get(0).getQuantity();
        for (Product temp:listProduct) {
            if (temp.getQuantity()>most){
                most=temp.getQuantity();

                }
            }
        for (Product element: listProduct) {
            if (element.getQuantity()==most){
                element.display();
            }
        }
    }
    public void minQuantityProduct(){
        int minQuantity=listProduct.get(0).getQuantity();
        for (Product temp:listProduct) {
            if (temp.getQuantity()<=minQuantity){
                minQuantity=temp.getQuantity();
            }
        }
        for (Product temp:listProduct) {
            if (temp.getQuantity()==minQuantity){
                temp.display();
            }
        }
    }

        public void bottleType(){
        ArrayList<Drinks> listDrink=new ArrayList<>();
            for (Product temp:listProduct) {
                if (temp instanceof Drinks){
                    listDrink.add((Drinks) temp);
                }
            }if (listDrink.isEmpty()){
                System.out.println("Not exist any Drinks Product!!");
                return;
            }
            int i=0;
            while (i<listDrink.size()-1){
                int count=0;
                for (int j = i+1; j <listDrink.size() ; j++) {
                    if(listDrink.get(j).getBottleType().equalsIgnoreCase(listDrink.get(i).getBottleType())) {
                        ++count;
                        Drinks temp = listDrink.get(j);
                        listDrink.set(j, listDrink.get(i + count));
                        listDrink.set(i + count, temp);
                    }
                }
                i += count + 1;
            }
            for (Drinks temp:listDrink) {
                temp.display();
            }
                }
                public void weightCandy(){
        ArrayList<Candy> listCandy=new ArrayList<>();
                    for (Product temp: listProduct) {
                        if (temp instanceof Candy){
                            listCandy.add((Candy) temp);
                        }
                    }
                    int weight=listCandy.get(0).getWeight();
                    for (Candy temp: listCandy ) {
                        if (temp.getWeight()>=weight){
                            weight=temp.getWeight();
                        }
                    }
                    for (Candy temp:listCandy) {
                        if (temp.getWeight()==weight){
                            temp.display();
                        }
                    }
                }
                public void searchCategory(Scanner scanner){
                    System.out.println("Enter category product :");
                    String nameCategory=scanner.nextLine();
                    for (Product temp:listProduct) {
                        if (temp.getCategory().getName().equalsIgnoreCase(nameCategory)){
                            temp.display();
                        }
                    }
                }
                public void searchContains(Scanner scanner){
                    System.out.println("Enter name contains product :");
                    String nameContain=scanner.nextLine();
                    for (Product temp:listProduct) {
                        if (temp.getName().contains(nameContain)){
                            temp.display();
                        }
                    }
                }
                public void searchProductByPriceRange(Scanner scanner){
                    System.out.println("Enter price min product :");
                    Double minRange=Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter price max product :");
                    Double maxRange=Double.parseDouble(scanner.nextLine());
                    for (Product temp:listProduct) {
                        if (temp.getPrice()>=minRange&&temp.getPrice()<=maxRange){
                            temp.display();
                        }
                    }
                }
                public void searchBottleTypeMaxPrice(){
                ArrayList<Drinks> listDrink=new ArrayList<>();

                    for (Product temp:listProduct) {
                        if (temp instanceof Drinks){
                            listDrink.add((Drinks) temp);
                        }
                    }
                    ArrayList<Drinks> listBottleType=new ArrayList<>();
                    for (Drinks temp:listDrink) {
                        if (temp.getBottleType().equalsIgnoreCase("thuy tinh")){
                            listBottleType.add(temp);
                        }
                    }
                    Double maxPrice=listBottleType.get(0).getPrice();
                    for (Drinks temp:listBottleType) {
                        if (temp.getPrice()>=maxPrice){
                            maxPrice=temp.getPrice();
                        }
                    }
                    for (Drinks temp:listBottleType) {
                        if (temp.getPrice()==maxPrice){
                            temp.display();
                        }
                    }
                }
            }

