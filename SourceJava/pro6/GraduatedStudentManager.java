/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import ui.IFunctions;

/**
 *
 * @author NITRO5
 */

enum Grade{
    GOOD("Please input information for good student!"), NORMAL("Please input information for normal student!");
    private String n;
    private Grade(String n){
        this.n = n;
    }
    
    public String getn(){
        return n;
    }
}

public class GraduatedStudentManager implements IFunctions{
    private ArrayList<GraduatedStudent> studentList;
    private ArrayList<GoodStudent> goodStudentList;
    private ArrayList<NormalStudent> normalStudentList;
    private ArrayList<GraduatedStudent> qualifiedStudent;
    private ArrayList<GoodStudent> markList;
    private ArrayList<NormalStudent> markList2;

    public ArrayList<GraduatedStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<GraduatedStudent> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<GoodStudent> getGoodStudentList() {
        return goodStudentList;
    }

    public void setGoodStudentList(ArrayList<GoodStudent> goodStudentList) {
        this.goodStudentList = goodStudentList;
    }

    public ArrayList<NormalStudent> getNormalStudentList() {
        return normalStudentList;
    }

    public void setNormalStudentList(ArrayList<NormalStudent> normalStudentList) {
        this.normalStudentList = normalStudentList;
    }

    public ArrayList<GraduatedStudent> getQualifiedStudent() {
        return qualifiedStudent;
    }

    public void setQualifiedStudent(ArrayList<GraduatedStudent> qualifiedStudent) {
        this.qualifiedStudent = qualifiedStudent;
    }

    public ArrayList<GoodStudent> getMarkList() {
        return markList;
    }

    public void setMarkList(ArrayList<GoodStudent> markList) {
        this.markList = markList;
    }

    public ArrayList<NormalStudent> getMarkList2() {
        return markList2;
    }

    public void setMarkList2(ArrayList<NormalStudent> markList2) {
        this.markList2 = markList2;
    }

    public GraduatedStudentManager() {
        studentList = new ArrayList<>();
        goodStudentList = new ArrayList<>();
        normalStudentList = new ArrayList<>();
        qualifiedStudent = new ArrayList<>();
        markList = new ArrayList<>();
        markList2 = new ArrayList<>();
    }

    public GraduatedStudentManager(ArrayList<GraduatedStudent> studentList, ArrayList<GoodStudent> goodStudentList, ArrayList<NormalStudent> normalstudentList, ArrayList<GraduatedStudent> qualifiedStudent, ArrayList<GoodStudent> markList, ArrayList<NormalStudent> markList2) {
        this.studentList = studentList;
        this.goodStudentList = goodStudentList;
        this.normalStudentList = normalstudentList;
        this.qualifiedStudent = qualifiedStudent;
        this.markList = markList;
        this.markList2 = markList2;
    }

    public void createNewGraduatedStudent(int n){
        System.out.println("Please input some necessary information about you!");
        String _code = CustomException.inputCode("Input your code: ", "Your code is invalid! Please input your code!");
        _code = ProcessInputData.processCodeData(_code);
        _code = checkId(_code, "Error!Your code has been existed!");
        String _fullName = InvalidFullNameException.inputString("Input your fullname: ", "Please input your fullname!");
        _fullName = ProcessInputData.fullNameInputData(_fullName);
        String _doB = InvalidDOBException.inputString("Input your date of birth(dd/MM/YYYY): ", "Please input your date of birth again!");
        String _sex = CustomException.inputString("Input your sex( Male, Female, Others): ", "Error!\nYour sex is invalid! Please input your sex!");
        _sex = ProcessInputData.processSexData(_sex);
        String _phoneNumber = InvalidPhoneNumberException.inputPhoneNumber("Input your phone number( start with 090, 091, 098, 031, 035, 038)", "Please input your phone number!");
        String _universityName = CustomException.inputUniversityName("Input your university name: ", "Please input your university name!");
        _universityName = ProcessInputData.fullNameInputData(_universityName);
        String _gradeLevel = CustomException.inputUniversityName("Input your grade level(Good or Normal): ", "Please input your grade leve!");
        _gradeLevel = ProcessInputData.fullNameInputData(_gradeLevel);
        String gradeStudent = _gradeLevel.toUpperCase();
        if(gradeStudent.equals("GOOD")){
            Grade good = Grade.GOOD;
            System.out.println(good.getn());
            double _gpa = CustomException.inputADouble("Input your gpa(0...10): ", "Your gpa is invalid! Please input your gpa again!", 10, 0);
            String _bestRewardName = CustomException.inputBestRewardName("Input your best reward name: ", "Please input your best reward name!");
            _bestRewardName = ProcessInputData.fullNameInputData(_bestRewardName);
            GoodStudent gs = new GoodStudent(_gpa, _bestRewardName, _code, _fullName, _doB, _sex, _phoneNumber, _universityName, _gradeLevel);
            goodStudentList.add(gs);       
            studentList.add(gs);
        }
        else{
            Grade normal = Grade.NORMAL;
            System.out.println(normal.getn());
            double _englishScore = CustomException.inputADouble("Input your english score: ", "Your english score is invalid! Please input your english score again!", 10, 0);
            double _entryTestScore = CustomException.inputADouble("Input your entry test score: ", "Your entry test score is invalid! Please input your entry test score again!", 10, 0);
            NormalStudent ns = new NormalStudent(_englishScore, _entryTestScore, _code, _fullName, _doB, _sex, _phoneNumber, _universityName, _gradeLevel);
            normalStudentList.add(ns);
            studentList.add(ns);
        } 
        if(studentList.size() <= n){
            if(!qualifiedStudent.isEmpty())
                    qualifiedStudent.removeAll(qualifiedStudent);
            qualifiedStudent.addAll(studentList);
        }
        else if(goodStudentList.size() == n && studentList.size() > n){
            if(!qualifiedStudent.isEmpty())
                qualifiedStudent.removeAll(qualifiedStudent);
            qualifiedStudent.addAll(goodStudentList);
        }
        else if(goodStudentList.size() > n && studentList.size() > n){
            if(!qualifiedStudent.isEmpty())
                qualifiedStudent.removeAll(qualifiedStudent);
            Collections.sort(goodStudentList, GoodStudent.compareGpa);
            Collections.reverse(goodStudentList);
            int posUp = n - 1, posDown = n - 1; 
                /*
                nếu người dùng nhập vào 15
                danh sách học sinh giỏi (goodStudentList)
                11: 9
                12:  B 8  A 8
                13:  D 8  B 8
                14:  C 8
                15:  A 8
                16: 7
                danh sách điểm (markList)
                1: A 8
                2: B 8
                3: C 8
                4: D 8
                */
            double min = goodStudentList.get(n - 1).getGpa();
            for(int i = posUp; i >= 0; i--)
                if(min == goodStudentList.get(i).getGpa())
                    posUp = i; 
                else
                    break;
            for(int i = posDown; i < goodStudentList.size(); i++)
                if(min == goodStudentList.get(i).getGpa())
                    posDown = i;
                else
                    break;
            if(posUp != posDown){
                for(int i = posUp; i < posDown; i++)
                    markList.add(goodStudentList.get(i));
                Collections.sort(markList, GoodStudent.compareName);
                Collections.reverse(markList); //bằng nhau nhưg đồng thời phải bằng vs điểm của index 14
                int t = 0;
                for(int i = posUp; i < posDown; i++){
                    goodStudentList.set(i, markList.get(t));
                    t++;
                }
            }
            for(int i = 0; i < n; i++)
                qualifiedStudent.add(goodStudentList.get(i));
        }
        else if(goodStudentList.size() < n && studentList.size() > n){
            if(!qualifiedStudent.isEmpty())
                qualifiedStudent.removeAll(qualifiedStudent);
            qualifiedStudent.addAll(goodStudentList);
            int m = n - goodStudentList.size();
            Collections.sort(normalStudentList, NormalStudent.compareEntryTestScore);
            Collections.reverse(normalStudentList);
            int posUpM = m - 1, posDownM = m - 1;
            double minM = normalStudentList.get(m - 1).getEntryTestScore();
            for(int i = posUpM; i >= 0; i--)
                if(minM == normalStudentList.get(i).getEntryTestScore())
                    posUpM = i;
                else
                    break;
            for(int i = posDownM; i < normalStudentList.size(); i++)
                if(minM == normalStudentList.get(i).getEntryTestScore())
                    posDownM = i;
                else
                    break;
            if(posUpM != posDownM){
                if(!markList2.isEmpty())
                    markList2.removeAll(markList2);
                for(int i = posUpM; i < posDownM; i++)
                    markList2.add(normalStudentList.get(i));
                Collections.sort(markList2, NormalStudent.compareEnglishScore);
                Collections.reverse(markList2);
                int t = 0;
                for(int i = posUpM; i < posDownM; i++){
                    normalStudentList.set(i, markList2.get(t));
                    t++;
                }
            }
            if(!markList2.isEmpty())
                markList2.removeAll(markList2);
            int posUpM2 = m - 1, posDownM2 = m - 1;
            double minM2 = normalStudentList.get(m - 1).getEnglishScore();
            for(int i = posUpM2; i >= 0; i--)
                if(minM2 == normalStudentList.get(i).getEnglishScore())
                    posUpM2 = i;
                else
                    break;
            for(int i = posDownM2; i < normalStudentList.size(); i++)
                if(minM2 == normalStudentList.get(i).getEnglishScore())
                    posDownM2 = i;
                else
                    break;
            if(posUpM2 != posDownM2){
                for(int i = posUpM2; i < posDownM2; i++)
                    markList2.add(normalStudentList.get(i));
                Collections.sort(markList2, NormalStudent.compareName);
                Collections.reverse(markList2);
                int t2 = 0;
                for(int i = posUpM2; i < posDownM2; i++){
                    normalStudentList.set(i, markList2.get(t2));
                    t2++;
                }
            }
            for(int i = 0; i < m; i++)
                qualifiedStudent.add(normalStudentList.get(i));
        }
    }
    
    public void readAll(){
        if(studentList.isEmpty())
            System.out.println("The list is empty!");
        else
            for(GraduatedStudent s : studentList)
                System.out.println(s);
    }
    
    @Override
    public void readGoodStudentList(){
        if(goodStudentList.isEmpty())
            System.out.println("The list is empty!");
        else
            for(GoodStudent g : goodStudentList)
                System.out.println(g);
    }
    
    @Override
    public void readNormalStudentList(){
        if(normalStudentList.isEmpty())
            System.out.println("The list is empty!");
        else
            for(NormalStudent n : normalStudentList)
                System.out.println(n);
    }
    
    public void readQualifiedStudent(int n){   
        if(qualifiedStudent.isEmpty())
            System.out.println("The list is empty!");
        else
            for(GraduatedStudent st : qualifiedStudent)
                System.out.println(st);
    }
    
    public void findStudent(){
        Scanner sc = new Scanner(System.in);
        int flag = 0;
        if(studentList.isEmpty())
            System.out.println("The list is empty!");
        else{
            String id = CustomException.inputCode("Input your code of student you want to find: ", "Error! Your code is invalid! Please input your code again!");
            for(int i = 0; i < studentList.size(); i++)
                if(studentList.get(i).getCode().equals(id)){
                    System.out.println(studentList.get(i).toString());
                    flag = 1;
                }
            if(flag == 0)
                System.out.println("No one have this id!");
        }
    }
    
    public void sortFullName(){
        if(studentList.isEmpty())
            System.out.println("The list is empty!");
        else{
            Collections.sort(studentList, GraduatedStudent.compareName);
            Collections.reverse(studentList);
            if(studentList.isEmpty())
                System.out.println("The list is empty!");
            else
                for(GraduatedStudent sl : studentList)
                    System.out.println(sl);
        }
    }
    
    public void sortPhoneNumber(){
        if(studentList.isEmpty())
            System.out.println("The list is empty!");
        else{
            Collections.sort(studentList, GraduatedStudent.comparePhoneNumber);
            if(studentList.isEmpty())
                System.out.println("The list is empty!");
            else
                for(GraduatedStudent sl : studentList)
                    System.out.println(sl);
        }
    }
    
    public void saveFile(){
        try{
            if(qualifiedStudent.isEmpty())
                System.out.println("The list is empty!");
            File file = new File("c:/data.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Qualified students: ");
            bw.newLine();
            for (int i = 0; i < qualifiedStudent.size(); i++) {
                bw.write(qualifiedStudent.get(i).toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch(IOException ex){
            System.out.println("Error: " + ex);
        }
    }
    
    public String checkId(String n, String errorData){
        while(true){
            try{
                for(int i = 0; i < studentList.size(); i++)
                    if(studentList.get(i).getCode().equals(n)){
                            throw new Exception();      
                    }
                return n;
            }
            catch(Exception e){
                System.out.println(errorData);
                n = CustomException.inputCode("Input your code again: ", "Your code is invalid! Please input your code again!");
            }
        }
    }
}
