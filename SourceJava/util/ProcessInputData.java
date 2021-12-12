/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.util.Scanner;


/**
 *
 * @author NITRO5
 */
public class ProcessInputData{
    public static String fullNameInputData(String n){
        Scanner sc = new Scanner(n);
        String n1 = " ";
        while(sc.hasNext()){
            n1 = n1 + upperCaseFullName(sc.next()) + " ";
        }
        return n1.trim();
    }
    
    public static String upperCaseFullName(String n){ 
        String firstLetter = n.substring(0, 1); 
        String remainLetter = n.substring(1, n.length());
        firstLetter = firstLetter.toUpperCase();
        n = firstLetter + remainLetter; 
        return n;
    }
    
    public static String processCodeData(String n){
        String n1 = "";
        Scanner sc = new Scanner(n);
        while(sc.hasNext())
             n1 = n1 +  sc.next().toUpperCase();
        n = n1;
        return n;
    }
    
    public static String processSexData(String n){
        String n1 = "";
        Scanner sc = new Scanner(n);
        while(sc.hasNext())
             n1 = n1 +  sc.next();
        String firstLetter = n1.substring(0, 1);
        String remainLetter = n1.substring(1, n1.length());
        firstLetter = firstLetter.toUpperCase();
        n = firstLetter + remainLetter;
        return n;
    }
    
    public static String processWhiteSpace(String n){
        String n1 = "";
        Scanner sc = new Scanner(n);
        while(sc.hasNext())
             n1 = n1 + sc.next();
        n = n1;
        return n;
    }
    
    public static String processDateOfBirth(String n){
        String n1 = "";
        Scanner sc = new Scanner(n);
        sc.useDelimiter("[/]+");
        while(sc.hasNext())
             n1 = n1 + sc.next();
        n = n1;
        return n;
    }
  
}
