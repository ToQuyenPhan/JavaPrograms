/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidvaccinemanagement;

import ui.Menu;
import utill.VaccineException;

/**
 *
 * @author NITRO5
 */
public class CovidVaccineSystem {
    private static final int ADD = 2, UPDATE = 3, DELETE = 4, SEARCH = 5;
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addOption("===================Menu=============================");
        menu.addOption("1. Show information all students have been injected");
        menu.addOption("2. Add student's vaccine injection information");
        menu.addOption("3. Updating information of student's vaccine injection");
        menu.addOption("4. Delete student vaccine injection information");
        menu.addOption("5. Search for injection information by studentID");
        menu.addOption("6. Save file");
        menu.addOption("7. Quit");
        StuVaccine sv = new StuVaccine();
        int choice, yesNo = 0;
        do{
            menu.showMenu();
            choice = VaccineException.inputChoice("Your option: ", 1, 7);
            switch(choice){
                case 1:
                    sv.printList();
                    break;
                case 2:
                    do{
                        sv.addInjection();
                        functionsForMenu(ADD);
                        yesNo = continueFunction();
                    }while(yesNo == 1);
                    break;
                case 3:
                    do{
                        sv.updateInjection();
                        functionsForMenu(UPDATE);
                        yesNo = continueFunction();
                    }while(yesNo == 1);
                    break;
                case 4:
                    do{
                        sv.deleteInjection();
                        functionsForMenu(DELETE);
                        yesNo = continueFunction();
                    }while(yesNo == 1);
                    break;
                case 5:
                    do{
                        sv.searchStudent();
                        functionsForMenu(SEARCH);
                        yesNo =continueFunction();
                    }while(yesNo == 1);
                    break;
                case 6:
                    sv.saveFile();
                    System.out.println("Saving successed!");
                    break;
                case 7:
                    System.out.println("Goodbye!");
            }
        }while(choice != 7);
    }
    
    public static int continueFunction(){
        int yesNo;
        System.out.println("1. Yes");
        System.out.println("2. No");
        yesNo = VaccineException.inputChoice("Choose your option: ", 1, 2);
        return yesNo;
    }
    
    public static void functionsForMenu(int function){
        switch(function){
            case ADD:
                System.out.println("Do you want to continue adding?");
                break;
            case UPDATE:
                System.out.println("Do you want to continue updating?");
                break;
            case DELETE:
                System.out.println("Do you want to continue deleting?");
                break;
            case SEARCH:
                System.out.println("Do you want to continue searching?");
                break;
        }
    }
}
