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
public class InvalidFullNameException extends Exception{
    public InvalidFullNameException(String message){
        super(message);
    }
    
    @Override
    public String getMessage(){
        return "Error!\n" + super.getMessage();
    }
    
    public static String inputString(String inputData, String errorData) {
        Scanner sc = new Scanner(System.in);
        String n;
        while(true){
            try{
                System.out.println(inputData);
                n = sc.nextLine().trim();
                if(n.isEmpty())
                    System.out.println(errorData);
                else
                    if(n.length() < 10 || n.length() > 50)
                        throw new InvalidFullNameException("Your fullname is invalid! It is not in range of [10...50]!");
                    else{
                        for(int i = 0; i < n.length(); i++)
                            if(Character.isDigit(n.charAt(i))){
                                throw new InvalidFullNameException("Your fullname is invalid! Character at " + i +" is digit!");
                            }
                        Pattern p = Pattern.compile("[^A-Za-z\\s]");
                        Matcher m = p.matcher(n);
                        boolean b = m.find();
                        if(b == true)
                            throw new InvalidFullNameException("Your fullname is invalid! Your fullname has a special character!");
                        return n;
                    }
            }
            catch(InvalidFullNameException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
