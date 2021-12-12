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
public class NormalStudent extends GraduatedStudent{
    private double englishScore;
    private double entryTestScore;

    public NormalStudent() {
        super();
    }

    public NormalStudent(double englishScore, double entryTestScore, String code, String fullName, String doB, String sex, String phoneNumber, String universityName, String gradeLevel) {
        super(code, fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestCScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public String toString() {
        return  super.toString() + String.format("|%-2.1f|%-2.1f|", englishScore, entryTestScore);
    }

   public static Comparator compareEntryTestScore = new Comparator(){
        public int compare(Object obj1, Object obj2){
            NormalStudent ns1 = (NormalStudent) obj1;
            NormalStudent ns2 = (NormalStudent) obj2;
            if(ns1.entryTestScore > ns2.entryTestScore){
                return 1;
            }
            else{
                if(ns1.entryTestScore == ns2.entryTestScore){
                    return 0;
                }
                else{
                    return -1;
                }
            }
        }
    };
   
   public static Comparator compareEnglishScore = new Comparator(){
        public int compare(Object obj1, Object obj2){
            NormalStudent ns1 = (NormalStudent) obj1;
            NormalStudent ns2 = (NormalStudent) obj2;
            if(ns1.englishScore > ns2.englishScore){
                return 1;
            }
            else{
                if(ns1.englishScore == ns2.englishScore){
                    return 0;
                }
                else{
                    return -1;
                }
            }
        }
    };
   
    public static Comparator compareName = new Comparator(){
        public int compare(Object obj1, Object obj2){
            NormalStudent ns1 = (NormalStudent) obj1;
            NormalStudent ns2 = (NormalStudent) obj2;
            int t = ns1.getFullName().compareTo(ns2.getFullName());
            return t;
        }
    };
}
