/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmanagementsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import util.FoodException;
import util.ProcessData;

/**
 *
 * @author NITRO5
 */
public class FoodList {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Food> foodList;

    public FoodList() {
        foodList = new ArrayList<>();
    }

    public FoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }
    
    public void addFood(){
        int yesNo = 0;
        do{
            System.out.println("Input the information of new food!");
            String _id = FoodException.inputString("Input the ID: ", "Invalid! Data can not be null!");
            _id = ProcessData.processWhiteSpace(_id);
            _id = checkID("Input the ID again: ", "The ID existed!", _id);
            String _name = FoodException.inputString("Input the name: ", "Invalid! Data can not be null!"); 
            _name = ProcessData.processString(_name);
            double _weight = FoodException.inputDouble("Input the weight: ", "Invalid! Data contains characters!");
            String _type = FoodException.inputString("Input the type: ", "Invalid! Data cannot be null!");
            _type = ProcessData.processString(_type);
            String _place = FoodException.inputPlace("Invalid! You must choose 1 of 3 places!");
            String _expiredDate = FoodException.inputString("Input the expired date(dd/mm/yyyy): ", "Invalid! Data can not be null!");
            _expiredDate = FoodException.inputDate(_expiredDate);
            Food f = new Food(_id, _name, _weight, _type, _place, _expiredDate);
            foodList.add(f);
            System.out.println("Do you want to continue adding another food?");
            yesNo = continueFunction(yesNo);
        }while(yesNo == 1);
    }
    
    public void searchFood(){
        int yesNo = 0;
        do{
            if(foodList.isEmpty())
                System.out.println("The list is empty!");
            else{
                String name = FoodException.inputString("Input the name of food you want to search: ", "Invalid! Data can not be null!");
                boolean b = findFood(name);
                if(b == false){
                    name = ProcessData.processString(name);
                    b = findFood(name);
                    if(b == false){
                        System.out.println("This food does not existed!");
                    }
                }
                System.out.println("Do you want to continue searching another food?");
                yesNo = continueFunction(yesNo);
            }
        }while(yesNo == 1);
    }
    
    public void removeFood(){
        int yesNo = 0;
        if(foodList.isEmpty())
            System.out.println("The list is empty!");
        else{
            String id = FoodException.inputString("Input the ID of food you want to remove: ", "The ID is invalid!");
            System.out.println("Are you sure to remove food with ID " + id + "?");
            yesNo = continueFunction(yesNo);
            if(yesNo == 1){
                int flag = 0;
                for(int i = 0; i < foodList.size(); i++)
                    if(foodList.get(i).getId().equals(id)){
                        flag = 1;
                        foodList.remove(i);
                    }
                if(flag == 1){
                    System.out.println("Successed!");
                }
                else
                    System.out.println("This food does not exist to remove!");
            }
            else
                System.out.println("Failed!");
            showList();
        }
    }
    
    public void printList(){
        if(foodList.isEmpty())
            System.out.println("The list is empty!");
        else{
            Collections.sort(foodList, Food.compareDate);
            showList();
        }
    }
    
    public void saveFile(){
        try{
            if(foodList.isEmpty())
                System.out.println("The list is empty!");
            else{
                String n = FoodException.inputString("Input the name of file you want to save(<<filename>>.txt): ", "The name of file is invalid!");
                if(!n.contains(".txt")){
                    System.out.println("Input the extension of the file!");
                    throw new IOException();
                }
                File file = new File(n);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("==============================Your Refrigerator=======================================\n");
                bw.write("|    ID    |   NAME   |  WEIGHT |        TYPE        |        PLACE       |   DATE   |\n");
                for(int i = 0; i < foodList.size(); i++){
                    bw.write(foodList.get(i).toString());
                    bw.write("\n");
                }
                bw.write("========================================================================================");
                bw.flush();
                bw.close();
                fw.close();
                System.out.println("Successed!");
            }
        }catch(IOException ex){
            System.out.println("Error!");
        }
    }
    
    private String checkID(String inputMes, String errorMes, String inputData){
        while(true){
            try{
                for(int i = 0; i < foodList.size(); i++)
                    if(foodList.get(i).getId().equals(inputData))
                        throw new Exception();
                return inputData; 
            }catch(Exception e){
                System.out.println(errorMes);
                inputData = FoodException.inputString(inputMes, "Invalid! Data can not be null!");
                inputData = ProcessData.processWhiteSpace(inputData);
            }
        }
    }
      
    private int continueFunction(int yesNo){
        System.out.println("1. Yes");
        System.out.println("2. No");
        yesNo = FoodException.inputChoice("Select your option(1 or 2): ", "Invalid! Data should be 1 or 2!", 1, 2);
        return yesNo;
    }
    
    private boolean findFood(String inputData){
        boolean flag = false;
        for(int i = 0; i < foodList.size(); i++)
            if(foodList.get(i).getName().contains(inputData)){
                flag = true;
            }
        if(flag == true){
            System.out.println("==============================Your Refrigerator=======================================");
            System.out.println("|    ID    |   NAME   |  WEIGHT |        TYPE        |        PLACE       |   DATE   |");
            for(int i = 0; i < foodList.size(); i++)
                if(foodList.get(i).getName().contains(inputData)){
                    System.out.println(foodList.get(i).toString());
                }
            System.out.println("======================================================================================");
        }
        return flag;
    }
    
    private void showList(){
        System.out.println("==============================Your Refrigerator=======================================");
        System.out.println("|    ID    |   NAME   |  WEIGHT |        TYPE        |        PLACE       |   DATE   |");
        for(Food x : foodList)
            System.out.println(x);
        System.out.println("======================================================================================");
    }
}
