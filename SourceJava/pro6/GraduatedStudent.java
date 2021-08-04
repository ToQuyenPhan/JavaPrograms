/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro6;

import java.util.Comparator;

/**
 *
 * @author NITRO5
 */
public abstract class GraduatedStudent {
    protected String code;
    protected String fullName;
    protected String doB;
    protected String sex;
    protected String phoneNumber;
    protected String universityName;
    protected String gradeLevel;

    public GraduatedStudent(){
    }

    public GraduatedStudent(String code, String fullName, String doB, String sex, String phoneNumber, String universityName, String gradeLevel) {
        this.code = code;
        this.fullName = fullName;
        this.doB = doB;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.universityName = universityName;
        this.gradeLevel = gradeLevel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-20s|%-10s|%-10s|%-15s|%-20s|%-15s", code, fullName, doB, sex, phoneNumber, universityName, gradeLevel);
    }
    
    public static Comparator comparePhoneNumber = new Comparator(){
        public int compare(Object obj1, Object obj2){
            GraduatedStudent grs1 = (GraduatedStudent) obj1;
            GraduatedStudent grs2 = (GraduatedStudent) obj2;
            int t = grs1.phoneNumber.compareTo(grs2.phoneNumber);
            if(t != 0)
                return t;
            return 0;
        }
    };
    
    public static Comparator compareName = new Comparator(){
        public int compare(Object obj1, Object obj2){
            GraduatedStudent grs1 = (GraduatedStudent) obj1;
            GraduatedStudent grs2 = (GraduatedStudent) obj2;
            int t = grs1.fullName.compareTo(grs2.fullName);
            return t;
        }
    };
}
