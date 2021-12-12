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
public class InvalidPhoneNumberException extends Exception{

    public InvalidPhoneNumberException(String message){
        super(message);
    }
    
    @Override
    public String getMessage(){
        return "Error!\n" + super.getMessage();
    }
    
    public static String inputPhoneNumber(String inputData, String errorData){
        Scanner sc = new Scanner(System.in);
        String n;
        while(true){
            try{
                System.out.println(inputData);
                n = sc.nextLine();
                if(n.isEmpty())
                    System.out.println(errorData);
                else
                    if(n.length() != 10)
                        throw new InvalidPhoneNumberException("Your phone number is invalid! The length of phone number is 10!");
                    else{
                        Pattern p = Pattern.compile("[^0-9\\s]");
                        Matcher m = p.matcher(n);
                        boolean b = m.find();
                        if(b == true)
                            throw new InvalidPhoneNumberException("Your phone number has special character!");
                        else{
                            n = ProcessInputData.processWhiteSpace(n);
                            String startLetter = n.substring(0, 3);
                            String endLetter = n.substring(3, n.length());
                            if(startLetter.equals("090") || startLetter.equals("091") || startLetter.equals("098") || startLetter.equals("031") || startLetter.equals("035") || startLetter.equals("038")){
                                n = startLetter + endLetter;
                                return n;
                            }
                            else
                                throw new InvalidPhoneNumberException("Your phone number do not match required format!");
                            }
                        }
                }
            catch(InvalidPhoneNumberException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
