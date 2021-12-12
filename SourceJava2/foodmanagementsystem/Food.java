/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmanagementsystem;

import java.util.Comparator;

/**
 *
 * @author NITRO5
 */
public class Food {
    private String id;
    private String name;
    private double weight;
    private String type;
    private String place;
    private String expiredDate;

    public Food() {
    }

    public Food(String id, String name, double weight, String type, String place, String expiredDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return String.format("|%10s|%10s|%9.1f|%20s|%20s|%10s|", id, name, weight, type, place, expiredDate);
    }
    
    public static Comparator compareDate = new Comparator(){
        public int compare (Object obj1, Object obj2){
            Food f1 = (Food) obj1;
            Food f2 = (Food) obj2;
            int t = f1.getExpiredDate().compareTo(f2.getExpiredDate());
            return -t;
        }
    };
}
