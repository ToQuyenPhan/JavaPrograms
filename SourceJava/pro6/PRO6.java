/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro6;

import ui.Menu;
import util.CustomException;

/**
 *
 * @author NITRO5
 */
public class PRO6 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args){
        // TODO code application logic here
        Menu menu = new Menu();
        GraduatedStudentManager student = new GraduatedStudentManager();
        
        int choice;
        int count = 0;
        int numberOfStudent = CustomException.inputAnInteger("Input the number of students who you want to recruit(11...15): ", "Please input the number of students again!", 11, 15);
        do{
            menu.printMenu();
            choice = menu.getChoice();
            switch(choice){
                case 0:
                    System.out.println("Goodbye!");
                    break;
                case 1:
                    student.createNewGraduatedStudent(numberOfStudent);
                    break;
                case 2:
                    student.readAll();
                    break;
                case 3:
                    student.readGoodStudentList();
                    break;
                case 4:
                    student.readNormalStudentList();
                    break; 
                case 5:
                    student.readQualifiedStudent(numberOfStudent);
                    break;
                case 6:
                    student.findStudent();
                    break;
                case 7:
                    student.sortFullName();
                    break;
                case 8:
                    student.sortPhoneNumber();
                    break;
                case 9:
                    student.saveFile();
                    break;   
                default:
                    System.out.println("Error");
            }
        }while(choice != 0);
    }
    
}
