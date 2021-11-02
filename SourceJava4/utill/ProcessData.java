/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utill;

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
        return n;
    }
}
