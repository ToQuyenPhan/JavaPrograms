/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author NITRO5
 */
public class FoodException {
    static Scanner sc = new Scanner(System.in);
    
    public static int inputChoice(String inputMes, String errorMes, int minOption, int maxOption){
        int n;
        while(true){
            try{
                System.out.print(inputMes);
                n = Integer.parseInt(sc.nextLine());
                if(n < minOption || n > maxOption)
                    System.out.println("Invalid! Your option is out of range[" + minOption + "..." + maxOption + "]!");
                else
                    return n;
            }
            catch(Exception e){
                System.out.println(errorMes);
            }
        }
    }
    
    public static String inputString(String inputMes, String errorMes){
        String n;
        while(true){
            try{
                System.out.print(inputMes);
                n = sc.nextLine();
                if(n.isEmpty()){
                    throw new Exception();
                }
                else
                    return n;
            }catch(Exception e){
                System.out.println(errorMes);
            }
        }
    }
    
    public static double inputDouble(String inputMes, String errorMes){
        double n1;
        String n2;
        while(true){
            try{
                System.out.print(inputMes);
                n2 = sc.nextLine();
                if(n2.isEmpty())
                    System.out.println("Invalid! Data can not be null!");
                else{
                    n1 = Double.parseDouble(n2);
                    if(n1 <= 0)
                        System.out.println("Invalid! Data should be positive!");
                    else
                        return n1;
                }
            }catch(Exception e){
                System.out.println(errorMes);
            }
        }
    }
    
    public static String inputDate(String inputData){
        while(true){
            try{
                Pattern p = Pattern.compile("[^0-9\\s/]");
                Matcher m = p.matcher(inputData);
                boolean b = m.find();
                if(b == true){
                    System.out.println("Invalid! Data have character!");
                    throw new Exception();
                }  
                inputData = ProcessData.inputDate(inputData);
                if(inputData.length() != 8){
                    System.out.println("Invalid! Wrong format!");
                        throw new Exception();
                }
                else{
                    int day = Integer.parseInt(inputData.substring(0, 2));
                    int month = Integer.parseInt(inputData.substring(2, 4));
                    int year = Integer.parseInt(inputData.substring(4, inputData.length()));
                    if (month <= 0 || month > 12){
                        System.out.println("Invalid! The month is out of range[1...12]!");
                        throw new Exception();
                    }
                    else{
                        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                            if (day < 1 || day > 31){
                                System.out.println("Invalid! The day is out of range[1...31]!");
                                throw new Exception();
                            }
                        }
                        else{
                            if (month == 2){
                                if (year % 4 == 0){
                                    if (day < 1 || day > 29){
                                        System.out.println("Invalid! The day is out of range[1...29]!");
                                        throw new Exception();
                                    }
                                }
                                else{
                                    if (day < 1 || day > 28){
                                        System.out.println("Invalid! The day is out of range[1...28]!");
                                        throw new Exception();
                                    }
                                }
                            }
                            else{
                               if (month == 4 || month == 6 || month == 9 || month == 11){
                                   if (day < 1 || day > 30){
                                       System.out.println("Invalid! The day is out of range[1...30!");
                                       throw new Exception();
                                   }
                               }
                            }
                        }
                        //int result = 0;
                        inputData = day + "/" + month + "/" + year;
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Date inputDate = dateFormat.parse(inputData);
                        Date date = Calendar.getInstance().getTime();
                        //result = date.compareTo(inputDate);
                        if(inputDate.before(date)){
                            System.out.println("Invalid! The expired date less than current date!");
                            throw new Exception();
                        }  
                        else
                            return year + "/" + month + "/" + day;
                    }
                }
            }catch(Exception e){
                inputData = inputString("Input the expired date again(dd/mm/yyyy): ", "Invalid! Data can not be null!");
            }
        }
    }
    
    public static String inputPlace(String errorMes){
        String n;
        while(true){
            try{
                System.out.println("===Where do you store the food?===");
                System.out.println("-------Freezer compartment--------");
                System.out.println("-----Refrigerator compartment-----");
                System.out.println("--------Cool compartment----------");
                n = inputString("Input the place: ", "Invalid! Data can not be null!");
                n = ProcessData.processString(n);
                n = n.toLowerCase();
                if(n.equals("freezer compartment") || n.equals("refrigerator compartment") || n.equals("cool compartment"))
                    return ProcessData.processString(n);
                else
                    throw new Exception();
            }catch(Exception e){
                System.out.println(errorMes);
            }
        }
    }  
}
