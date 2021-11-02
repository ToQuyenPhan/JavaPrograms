/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidvaccinemanagement;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import ui.Menu;
import utill.VaccineException;

/**
 *
 * @author NITRO5
 */
public class StuVaccine {
    Scanner sc = new Scanner(System.in);
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Vaccine> vaccineList = new ArrayList<>();
    ArrayList<Injection> injectionList = new ArrayList<>();
    
    public StuVaccine() {
        writeVaccine();
        writeStudent();
    }
   
    private void writeVaccine(){
        try{
            String fileName = "vaccine.dat";
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            vaccineList.add(new Vaccine("Covid-V001", "AstraZeneca"));
            vaccineList.add(new Vaccine("Covid-V002", "SPUTNIK V"));
            vaccineList.add(new Vaccine("Covid-V003", "Vero Cell"));
            vaccineList.add(new Vaccine("Covid-V004", "Pfizer"));
            vaccineList.add(new Vaccine("Covid-V005", "Moderna"));
            for(Vaccine vc : vaccineList){
                oStream.writeObject(vc);
            }
            oStream.close();
            file.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void writeStudent(){
        try{
            String fileName = "student.dat";
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            studentList.add(new Student("SE15000", "Hoa Doan"));
            studentList.add(new Student("SE150351", "Phan Thi To Quyen"));
            studentList.add(new Student("SE156190", "Vu Thi Thu Thao"));
            studentList.add(new Student("SE156123", "Doan Thi Truc Quyen"));
            studentList.add(new Student("SE162351", "Nguyen Khanh Linh"));
            studentList.add(new Student("SE123456", "Phan Trong An"));
            studentList.add(new Student("SE987654", "Nguyen Huynh Tam Nhu"));
            studentList.add(new Student("SE789101", "Nguyen Thi Yen Nhi"));
            studentList.add(new Student("SE111213", "Nguyen Huynh Nhu Y"));
            studentList.add(new Student("SE151617", "Tran Thi Anh Thu"));
            for(Student st : studentList)
                oStream.writeObject(st);
            oStream.close();
            file.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void printList(){
        if(studentList.isEmpty())
            System.out.println("The list is empty!");
        else
            for(Student st : studentList)
                System.out.println(st);
    }
    
    public void addInjection(){
        System.out.println("======You need to input some information for injection======");
        String _injectionId = checkID();
        String _firstPlace = VaccineException.inputString("Input the place for the first place: ");
        Date _firstDate = VaccineException.inputDate("Input the date for the first injection(dd/MM/yyyy): ");
        boolean result, firstInjected;
        String _studentId;
        do{
            _studentId = VaccineException.inputString("Input the ID of student: ");
            result = existID(_studentId);
            firstInjected = findStudentById(_studentId);
            if(result == false)
                System.out.println("No students have this ID!");
            if(firstInjected == true)
                System.out.println("This student has been injected!");
        }while(result == false || firstInjected == true);
        String _vaccineId = "";
        Menu vaccineMenu = new Menu();
        vaccineMenu.addOption("===Vaccines===");
        vaccineMenu.addOption("1. AstraZeneca");
        vaccineMenu.addOption("2. SPUTNIK V");
        vaccineMenu.addOption("3. Vero Cell");
        vaccineMenu.addOption("4. Pfizer");
        vaccineMenu.addOption("5. Moderna");
        vaccineMenu.showMenu();
        int vaccineChoice = VaccineException.inputChoice("Choose the vaccine you want to inject: ", 1, 5);
        switch(vaccineChoice){
            case 1:
                _vaccineId = "Covid-V001";
                break;
            case 2:
                _vaccineId = "Covid-V002";
                break;
            case 3:
                _vaccineId = "Covid-V003";
                break;
            case 4:
                _vaccineId = "Covid-V004";
                break;
            case 5:
                _vaccineId = "Covid-V005";
                break;
        }
        Injection ij = new Injection(_injectionId, _firstPlace, _firstDate, _studentId, _vaccineId, true, false);
        injectionList.add(ij);
        System.out.println("This student has completed the first injection!");
    }
    
    public void updateInjection(){
        int flag;
        long result = 0, distanceDay = 0;
        if(injectionList.isEmpty())
            System.out.println("The list is empty!");
        else{
            flag = 0;
            String id = VaccineException.inputString("Input the ID of injection you want to update: ");
            flag = findStudent(id);
            if(flag == 0)
                System.out.println("The ID of injection does not exist!");
            if(flag == 1)
                System.out.println("Student had been fully injected before!");
            if(flag == 2){
                String _secondPlace = VaccineException.inputString("Input the place for the second place: ");
                do{
                Date _secondDate = VaccineException.inputDate("Input the date for the second injection(dd/MM/yyyy): ");
                 for(int i = 0; i < injectionList.size(); i++)
                        if(injectionList.get(i).getInjectionId().equals(id)){
                            injectionList.get(i).setSecondPlace(_secondPlace);
                            injectionList.get(i).setSecondDate(_secondDate);
                            result = injectionList.get(i).getSecondDate().getTime() - injectionList.get(i).getFirstDate().getTime();
                            distanceDay = TimeUnit.MILLISECONDS.toDays(result);
                            if(distanceDay < 28 && distanceDay >= 0)
                                System.out.println("It's too early for the second injection day! The second dose of vaccine must be given 4 to 12 weeks after the first injection!");
                            else if(distanceDay > 84)
                                System.out.println("It's too late for the second injection day! The second dose of vaccine must be given 4 to 12 weeks after the first injection!");
                            else if(distanceDay < 0)
                                System.out.println("The second date is less than the first day!");
                            else {
                                System.out.println("Student has completed 2 injections!");
                                injectionList.get(i).setSecondInjection(true);
                                showDetails(injectionList.get(i).getStudentId());
                            }
                        }
                }while(distanceDay < 28 || distanceDay > 84);
            }
        }
    }
    
    
    public void deleteInjection(){
        int yesNo, flag = 0;
        if(injectionList.isEmpty())
            System.out.println("The list is empty!");
        else{
            String id = VaccineException.inputString("Input the ID of injection you want to delete: ");
            flag = findStudent(id);
            if(flag == 0)
                System.out.println("The ID of injection does not exist!");
            else{
                for(int i = 0; i < injectionList.size(); i++)
                    if(injectionList.get(i).getInjectionId().equals(id)){
                        flag = 1;
                        System.out.println("Are you sure to delete this injection's information?");
                        yesNo = CovidVaccineSystem.continueFunction();
                        if(yesNo == 1){
                            injectionList.remove(i);
                            flag = 2;
                        }
                    }
                if(flag == 1){
                    System.out.println("Removing is canceled by user!");
                    System.out.println("Removing failed!");
                }
                else{
                    System.out.println("Removing successed!");
                    showList();
                }
            }
        }
    }
    
    public void searchStudent(){
        if(injectionList.isEmpty())
            System.out.println("The list is empty!");
        else{
            String studentId = VaccineException.inputString("Input the ID of student you want to search: ");
            boolean b = findStudentById(studentId);
            if(b == true){
                showDetails(studentId);
            }
            else{
                System.out.println("No students have this ID!");
            }
        }
    }
    
    public void saveFile(){
        try{
            if(injectionList.isEmpty())
                System.out.println("The list is empty!");
            else{
                String fileName = "injection.dat";
                FileOutputStream file = new FileOutputStream(fileName);
                ObjectOutputStream oStream = new ObjectOutputStream(file);
                for(Injection ij : injectionList)
                    oStream.writeObject(ij);
                oStream.close();
                file.close();
            }
        }catch(Exception e){
            System.out.println("Error!");
        }
    }
    
    private String checkID(){
        while(true){
            try{
                String id = VaccineException.inputString("Input the ID of injection: ");
                for(int i = 0; i < injectionList.size(); i++)
                    if(injectionList.get(i).getInjectionId().equals(id))
                        throw new Exception();
                return id;
            }catch(Exception e){
                System.out.println("The ID of injection is existed!");
            }
        }
    }
    
    private boolean existID(String id){
        boolean flag = false;
        for(int i = 0; i < studentList.size(); i++)
            if(studentList.get(i).getId().equals(id))
                flag = true;
        return flag;
    }  
    
    private int findStudent(String id){
        int flag = 0;
        for(int i = 0; i < injectionList.size(); i++)
            if(injectionList.get(i).getInjectionId().equals(id)){
                flag = 2;
                if(injectionList.get(i).isSecondInjection())
                    flag = 1;
            }
        return flag;
    }
    
    private boolean findStudentById(String studentId){
        for(int i = 0; i < injectionList.size(); i++){
            if(injectionList.get(i).getStudentId().equals(studentId)){
                return true;
            }
        }
        return false;
    }
    
    private void showList(){
        System.out.println("==============================================INJECTION================================================");
        System.out.println("|    ID    |       Place 1      |  Date 1  |       Place 2      |    Date 2     |Student ID|Vaccine ID|");
        for(Injection ij: injectionList)
            System.out.println(ij);
        System.out.println("=======================================================================================================");
    }
    
    private void showDetails(String id){
        System.out.println("|    ID    |       Place 1      |  Date 1  |       Place 2      |    Date 2     |Student ID|Vaccine ID|");
        for(Injection ij : injectionList)
            if(ij.getStudentId().equals(id))
                System.out.println(ij);
    }
}
