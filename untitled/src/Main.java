import Sevice.impl.CategoryManager;
import Sevice.impl.ProductManager.ProductManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        CategoryManager categoryManager=new CategoryManager();
        ProductManager productManager=new ProductManager(categoryManager);
       do {
           System.out.println("1.add product :");
           System.out.println("2.Show list product :");
           System.out.println("3.delete product :");
           System.out.println("4.Enter search product candy :");
           System.out.println("5.Enter search product drink");
           System.out.println("6.Enter max price product");
           System.out.println("7.Enter min price product");
           System.out.println("8.Enter most product :");
           System.out.println("9.Enter min quantity product");
           System.out.println("10.Enter search bottle type :");
           System.out.println("11.Enter search max weight Candy : ");
           System.out.println("12. Enter search Category :");
           System.out.println("13. Enter name product contains");
           System.out.println("14.Enter search product price range :");
           System.out.println("15.Enter search bottle type max product :");
           System.out.println("0.Exit");
           System.out.println("Enter choice");
           int choice=Integer.parseInt(scanner.nextLine());
           switch (choice){
               case 1:   productManager.save(scanner);
                   productManager.disPlayAll();
                   break;
               case 2:
                   productManager.disPlayAll();
                   break;
               case 3:
                   productManager.deleteById(scanner);
                   break;
               case 4:
                   productManager.searchCandy();
                   break;
               case 5:
                   productManager.searchDrink();
                   break;
               case 6:
                   productManager.maxPriceProduct();
                   break;
               case 7:
                   productManager.minPriceProduct();
                   break;
               case 8:
                   productManager.mostProduct();
                   break;
               case 9:
                   productManager.minQuantityProduct();
                   break;
               case 10:
                   productManager.bottleType();
                   break;
               case 11:
                   productManager.weightCandy();
                   break;
               case 12:
                   productManager.searchCategory(scanner);
                   break;
               case 13:
                   productManager.searchContains(scanner);
                   break;
               case 14:
                   productManager.searchProductByPriceRange(scanner);
                   break;
               case 15:
                   productManager.searchBottleTypeMaxPrice();
                   break;
               case 0:
                   System.exit(0);
           }

       }while (true);


    }
}