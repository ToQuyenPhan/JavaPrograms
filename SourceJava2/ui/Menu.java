/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import util.FoodException;

/**
 *
 * @author NITRO5
 */
public class Menu {
    private ArrayList<String> optionList;

    public ArrayList<String> getOptionList() {
        return optionList;
    }

    public void setOptionList(ArrayList<String> optionList) {
        this.optionList = optionList;
    }

    public Menu() {
        optionList = new ArrayList<>();
    }
    
    public void addOption(String inputOption){
        optionList.add(inputOption);
    }
    
    public void showMenu(){
        if(optionList.isEmpty()){
            System.out.println("There are no option in the menu!");
            return;
        }
        for(String x : optionList) 
            System.out.println(x);
    }
    
    public int getChoice(){
        return FoodException.inputChoice("Input your option[1...6]: ", "Invalid! Option should be numbers!", 1, 6);
    }
}
