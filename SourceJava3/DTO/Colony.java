/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author NITRO5
 */
public class Colony extends Organization{
    protected String place;

    public Colony() {
        super();
    }

    public Colony(String place, int size) {
        super(size);
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public void communicateByTool() {
        System.out.println("The colony communicate by sound."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "The colony's size is" + size + ", the colony's place is" + place; //To change body of generated methods, choose Tools | Templates.
    } 
    
    public void grow(){
        System.out.println("An annual cycle of growth that begins in spring.");
    }
    
    public void reproduce(){
        System.out.println("Colony can reproduce itself through a process.");
    }
}
