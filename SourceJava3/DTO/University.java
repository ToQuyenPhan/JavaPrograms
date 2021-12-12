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
public class University extends Organization{
    protected String name;

    public University() {
        super();
    }

    public University(String name, int size) {
        super(size);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void communicateByTool(){
        System.out.println("In the university, people communicate by voice.");
    }
    
    @Override
    public String toString(){
        return "encourage the advancement and development of knowledge.";
    }
    
    public void enroll(){
        System.out.println("The registartion for enrollment is only valid when the University has received all enrollment documents and enrollment fees.");
    }
    
    public void educate(){
        System.out.println("Provide education at university standard.");
    }
}
