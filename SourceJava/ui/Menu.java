/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import util.CustomException;



/**
 *
 * @author NITRO5
 */
public class Menu {
    public void printMenu(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~ MENU ~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Create a new profile of graduated student");
        System.out.println("2. Read all graduated student");
        System.out.println("3. Read good student list");
        System.out.println("4. Read normal student list");
        System.out.println("5. Read qualified student list");
        System.out.println("6. Find a student");
        System.out.println("7. Sort decending full name");
        System.out.println("8. Sort ascending phone number");
        System.out.println("9. Save into file");
        System.out.println("0. Quit");
    }
    
    public int getChoice(){
        String inputData = "Input your choice(0...9): ";
        String errorData = "Your option is invalid! Please input your choice again!";
        return CustomException.inputAnInteger(inputData, errorData, 0, 9);
    }
}
