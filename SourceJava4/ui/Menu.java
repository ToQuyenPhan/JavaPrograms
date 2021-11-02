/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;

/**
 *
 * @author NITRO5
 */
public class Menu {
    private ArrayList<String> optionList;

    public Menu() {
        optionList = new ArrayList<>();
    }

    public ArrayList<String> getOptionList() {
        return optionList;
    }

    public void setOptionList(ArrayList<String> optionList) {
        this.optionList = optionList;
    }
    
    public void addOption(String inputOption){
        optionList.add(inputOption);
    }
    
    public void showMenu(){
        if(optionList.isEmpty()){
            System.out.println("The list is empty!");
            return;
        }
        for(String x : optionList)
            System.out.println(x);
    }
}
