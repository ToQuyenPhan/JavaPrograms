/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmanagementsystem;

import ui.Menu;

/**
 *
 * @author NITRO5
 */
public class FoodManagementSystem {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addOption("Welcome to Food Management - @ 2021 by <SE150351 - Phan Thi To Quyen>");
        menu.addOption("Select the options below:");
        menu.addOption("1. Add a new food");
        menu.addOption("2. Search a food by name");
        menu.addOption("3. Remove the food by ID");
        menu.addOption("4. Print the food list in the descending order of expired date");
        menu.addOption("5. Save to file");
        menu.addOption("6. Quit");
        FoodList obj = new FoodList();
        int choice;
        do{
            menu.showMenu();
            choice = menu.getChoice();
            switch(choice){
                case 1:
                    obj.addFood();
                    break;
                case 2:
                    obj.searchFood();
                    break;
                case 3:
                    obj.removeFood();
                    break;
                case 4:
                    obj.printList();
                    break;
                case 5:
                    obj.saveFile();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
            }
        }while(choice != 6);
    }
}
