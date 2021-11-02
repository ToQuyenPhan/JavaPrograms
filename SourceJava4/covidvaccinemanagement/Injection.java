/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidvaccinemanagement;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author NITRO5
 */
public class Injection implements Serializable{
    String injectionId;
    String firstPlace;
    String secondPlace;
    Date firstDate;
    Date secondDate;
    String studentId;
    String vaccineId;
    boolean firstInjection = false;
    boolean secondInjection = false;

    public Injection() {
    }

    public Injection(String injectionId, String firstPlace, Date firstDate, String studentId, String vaccineId, boolean firstInjection, boolean secondInjection) {
        this.injectionId = injectionId;
        this.firstPlace = firstPlace;
        //this.secondPlace = secondPlace;
        this.firstDate = firstDate;
        //this.secondDate = secondDate;
        this.studentId = studentId;
        this.vaccineId = vaccineId;
        this.firstInjection = firstInjection;
        this.secondInjection = secondInjection;
    }

    public String getInjectionId() {
        return injectionId;
    }

    public void setInjectionId(String injectionId) {
        this.injectionId = injectionId;
    }

    public String getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(String firstPlace) {
        this.firstPlace = firstPlace;
    }

    public String getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(String secondPlace) {
        this.secondPlace = secondPlace;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getSecondDate() {
        return secondDate;
    }

    public void setSecondDate(Date secondDate) {
        this.secondDate = secondDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public boolean isFirstInjection() {
        return firstInjection;
    }

    public void setFirstInjection(boolean firstInjection) {
        this.firstInjection = firstInjection;
    }

    public boolean isSecondInjection() {
        return secondInjection;
    }

    public void setSecondInjection(boolean secondInjection) {
        this.secondInjection = secondInjection;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-20s|%td/%tm/%tY|%-20s|%td/%tm/%tY     |%-10s|%-10s|" , injectionId, firstPlace, firstDate, firstDate, firstDate, secondPlace, secondDate, secondDate, secondDate, studentId, vaccineId);
    }
}
