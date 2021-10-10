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
public class ProcessData {
    public static String inputDate(String inputData){
        String n = "";
        Scanner sc = new Scanner(inputData);
        sc.useDelimiter("[/]+");
        while(sc.hasNext())
            n = n + sc.next();
        inputData = n;
        return inputData;
    }
    
    public static String processString(String inputData){
        String n = "";
        inputData = inputData.toLowerCase();
        Scanner sc = new Scanner(inputData);
        while(sc.hasNext())
            n = n + upperCaseData(sc.next()) + " ";
        inputData = n;
        return inputData.trim();
    }
    
    private static String upperCaseData(String inputData){
        String firstLetter = inputData.substring(0, 1);
        String remainLetter = inputData.substring(1, inputData.length());
        firstLetter = firstLetter.toUpperCase();
        inputData = firstLetter + remainLetter;
        return inputData;
    }
    
    public static String processWhiteSpace(String inputData){
        String n = "";
        Scanner sc = new Scanner(inputData);
        while(sc.hasNext())
            n = n + sc.next();
        inputData = n;
        return inputData.trim();
    }
}
