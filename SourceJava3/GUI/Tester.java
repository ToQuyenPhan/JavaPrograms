/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.BeeColony;
import DTO.Colony;
import DTO.FPTUniversity;
import DTO.Organization;
import DTO.University;

/**
 *
 * @author NITRO5
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Colony obj1 = new BeeColony(2000, "honey", "land");
        System.out.println(obj1);
        obj1.grow();
        obj1.reproduce();
        
        University obj2 = new FPTUniversity(100000, "FPT", "Cantho");
        System.out.println(obj2);
        obj2.enroll();
        obj2.educate();
        
        Organization org = new BeeColony(3000, "wasp", "land");
        System.out.println(org);
        ((BeeColony)org).createWorker();
        
        org = new FPTUniversity(100000, "FPT", "Hanoi");
        System.out.println(org);
        ((FPTUniversity)org).createWorker();
   }  
}
