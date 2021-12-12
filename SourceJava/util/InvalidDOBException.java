/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author NITRO5
 */
public class InvalidDOBException extends Exception{
    
    public InvalidDOBException(String message) {
        super(message);
    }
    
    @Override
    public String getMessage() {
        return "Error!\n" + super.getMessage();
    }
    
    public static String inputString(String inputData, String errorData) {
        Scanner sc = new Scanner(System.in);
        String n;
        while(true){
            try{
                System.out.println(inputData);
                n = sc.nextLine();
                if(n.length() == 0)
                    throw new InvalidDOBException(errorData);
                else{
                    Pattern p = Pattern.compile("[^0-9\\s/]");
                    Matcher m = p.matcher(n);
                    boolean b = m.find();
                    if(b == true)
                        throw new InvalidDOBException("Your date of birth is invalid! It has special character");
                    else{
                        n = ProcessInputData.processWhiteSpace(n);
                        n = ProcessInputData.processDateOfBirth(n);
                        if(n.length() != 8)
                            throw new InvalidDOBException("Your date of birth is invalid! It is wrong format!");
                        int day = Integer.parseInt(n.substring(0, 2));
                        int month = Integer.parseInt(n.substring(2, 4));
                        int year = Integer.parseInt(n.substring(4, n.length()));
                        if (month <= 0 || month > 12)
                            throw new InvalidDOBException("Your month is out of range [1...12]");
                        else
                            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                                if (day < 1 && day > 31){
                                    throw new InvalidDOBException("Your date is out of range [1...31] of month!");
                                }
                            else
                                if (month == 2)
                                    if (year % 4 == 0)
                                        if (day < 1 && day > 29){
                                            throw new InvalidDOBException("Your date is out of range [1...28] of February in leap year!");
                                        }
                                    else
                                        if (day < 1 && day > 30){
                                            throw new InvalidDOBException("Your date is out of range [1...28] of February!");
                                        }
                                else
                                   if (month == 4 || month == 6 || month == 9 || month == 11)
                                        if (day < 1 && day > 30)
                                            throw new InvalidDOBException("Your date is out of range [1...30] of month!");
                                n = day + "/" + month + "/" + year; 
                            return n;
                    }
                        
                }
            }
            catch(InvalidDOBException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
