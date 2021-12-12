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
public class GoodStudent extends GraduatedStudent {
    private double gpa;
    private String bestRewardName;

    public GoodStudent() {
        super();
    }

    public GoodStudent(double gpa, String bestRewardName, String code, String fullName, String doB, String sex, String phoneNumber, String universityName, String gradeLevel) {
        super(code, fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("|%-2.1f|%-20s|", gpa, bestRewardName);
    }

    public static Comparator compareGpa = new Comparator(){
        public int compare(Object obj1, Object obj2){
            GoodStudent gs1 = (GoodStudent) obj1;
            GoodStudent gs2 = (GoodStudent) obj2;
            if(gs1.gpa > gs2.gpa){
                return 1;
            }
            else{
                if(gs1.gpa == gs2.gpa){
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
            GoodStudent gs1 = (GoodStudent) obj1;
            GoodStudent gs2 = (GoodStudent) obj2;
            int t = gs1.getFullName().compareTo(gs2.getFullName());
            return t;
        }
    };
}
