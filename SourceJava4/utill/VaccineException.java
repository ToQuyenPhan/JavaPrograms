/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utill;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author NITRO5
 */
public class VaccineException {
    static Scanner sc = new Scanner(System.in);
    
    public static int inputChoice(String inputMes, int minOption, int maxOption){
        String nStr;
        while(true){
            try{
                System.out.print(inputMes);
                nStr = sc.nextLine();
                if(nStr.isEmpty())
                    System.out.println("Data can not be null!");
                else{
                    int n = Integer.parseInt(nStr);
                    if(n < minOption || n > maxOption)
                        System.out.println("Your option is out of range" + "[" + minOption + "..." + maxOption + "]!");
                    else
                        return n;
                }
            }catch(Exception e){
                System.out.println("Data must be number[" + minOption + "..." + maxOption + "]!");
            }
        }  
    }
    
    public static String inputString(String inputMes){
        String n;
        while(true){
            try{
                System.out.print(inputMes);
                n = sc.nextLine();
                if(n.isEmpty())
                    System.out.println("Data can not be null!");
                else{
                    return n;
                }
            }catch(Exception e){
            }
        }
    }
    
    public static Date inputDate(String inputMes){
        String n;
        while(true){
            try{
                n = inputString(inputMes);
                    if(n.length() != 10)
                        System.out.println("Invalid format!");
                    else{
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        dateFormat.setLenient(false);
                        Date date = dateFormat.parse(n);
                        return date;
                    }
            }catch(Exception e){
                System.out.println("Invalid date!");
            }
        }
    }
}
