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
public class CustomException {
    private static Scanner sc = new Scanner(System.in);
     
    public static int inputAnInteger(String inputData, String errorData, int minOption, int maxOption){
        int n;
        while(true){
            try{
                System.out.println(inputData);
                n = Integer.parseInt(sc.nextLine());
                if(n < minOption || n > maxOption){
                    throw new Exception();
                }
                return n;
            }
            catch(Exception e){
                System.out.println(errorData);
            }
        }
    }
    
    public static String inputCode(String inputData, String errorData){
        String n;
        while(true){
            try{
                System.out.println(inputData);
                n = sc.nextLine();
                if(n.length() == 0)
                    throw new Exception();
                else{
                    Pattern p = Pattern.compile("[^A-Za-z0-9\\s]");
                    Matcher m = p.matcher(n);
                    boolean b = m.find();
                    if(b == true)
                        System.out.println("Error!\nYour code have special character!");
                    else
                        return n;
                }
            }
            catch(Exception e){
                System.out.println(errorData);
            }
        }
    }
    
    public static String inputString(String inputData, String errorData){
        String n;
        while(true){
            try{
                System.out.println(inputData);
                n = sc.nextLine();
                if(n.length() == 0)
                    throw new Exception();
                else{
                    Pattern p = Pattern.compile("[^A-Za-z\\s]");
                    Matcher m = p.matcher(n);
                    boolean b = m.find();
                    if(b == true)
                        System.out.println("Error!\nYour sex is invalid! Please input your sex again!");
                    else{
                        n = ProcessInputData.processSexData(n);
                        if(n.equals("Female") || n.equals("Male") || n.equals("Others"))
                            return  n;
                        else
                            System.out.println("Error!\nYour sex is invalid! It must be female, male, others!");
                    }  
                }
            }
            catch(Exception e){
                System.out.println(errorData);
            }
        }
    }
    
    public static String inputFullName(String inputData, String errorData){
        String n;
        while(true){
            try{
                System.out.println(inputData);
                n = sc.nextLine();
                if(n.length() == 0)
                    throw new Exception();
                else{
                    Pattern p = Pattern.compile("[^A-Za-z\\s]");
                    Matcher m = p.matcher(n);
                    boolean b = m.find();
                    if(b == true)
                        System.out.println("Error!\nYour full name is invalid! It has special character and number!");
                    else
                        return n;
                }
            }
            catch(Exception e){
                System.out.println(errorData);
            }
        }
    }
    
    public static String inputUniversityName(String inputData, String errorData){
        String n;
        while(true){
            try{
                System.out.println(inputData);
                n = sc.nextLine();
                if(n.length() == 0)
                    throw new Exception();
                else{
                    Pattern p = Pattern.compile("[^A-Za-z\\s]");
                    Matcher m = p.matcher(n);
                    boolean b = m.find();
                    if(b == true)
                        System.out.println("Error!\nYour university name is invalid! It has special character and number!");
                    else
                        return n;
                }
            }
            catch(Exception e){
                System.out.println(errorData);
            }
        }
    }
    
    public static double inputADouble(String inputData, String errorData, int maxScore, int minScore){
        double n;
        while(true){
            try{
                System.out.println(inputData);
                n = Double.parseDouble(sc.nextLine());
                if(n < minScore || n > maxScore)
                    throw new Exception();
                else
                    return n;
            }
            catch(Exception e){
                System.out.println(errorData);
            }
        }
    }
    
    public static String inputBestRewardName(String inputData, String errorData){
        String n;
        while(true){
            try{
                System.out.println(inputData);
                n = sc.nextLine();
                if(n.length() == 0)
                    throw new Exception();
                else{
                    Pattern p = Pattern.compile("[^A-Za-z\\s]");
                    Matcher m = p.matcher(n);
                    boolean b = m.find();
                    if(b == true)
                        System.out.println("Error!\nYour best reward name is invalid! It has special character and number!");
                    else
                        return n;
                }
            }
            catch(Exception e){
                System.out.println(errorData);
            }
        }
    }
}
