/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultis;

import Controller.Doctormanagement;
import Model.Doctor;
import View.Menu;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thaip
 */
public class Execute extends Menu<String>{
    private static String[] mc={"Add Doctor","Update Doctor","Delete Doctor","Search Doctor","Exit"};
    private Doctormanagement dList = new Doctormanagement();
    public Execute() {
        super("========= Doctor Management ==========",mc);
     }
    @Override
    public void execute(int n) {
        switch(n){
            case 1: {
                try {
                    addDoctor();
                } catch (Exception ex) {
                }
            }break;
            case 2: updateDoc();break;
            case 3: delete();break;
            case 4: {
                try {
                    search();
                } catch (Exception ex) {
                    
                }
            }break;
            case 5: System.exit(0);
        }
    }
    public void addDoctor() throws Exception{
        try{
            System.out.println("---------- Add Doctor ----------");
            String code = Menu.getString("Enter Code : ");
            String name = Menu.getString("Enter Name : ");
            String spec = Menu.getString("Enter Specialization : ");
            int avai = Integer.parseInt(Menu.getString("Enter Availability : "));
            Doctor doc = new Doctor(code, name, spec, avai);
            dList.addDoctor(doc);
            System.out.println("Add doctor successfull");
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }
    }
    public void updateDoc(){
        try{
            printDoc();
            System.out.println("---------- Update Doctor ----------");
            String code = Menu.getString("Enter Code : ");
            String name = Menu.getString("Enter Name : ");
            String spec = Menu.getString("Enter Specialization : ");
            int avai = Integer.parseInt(Menu.getString("Enter Availability : "));
            Doctor doc = new Doctor(code, name, spec, avai);
            dList.updateDoctor(doc);
            System.out.println("Update doctor successfull");
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }
    }
    public void printDoc(){
        dList.displayDoc();
    }
    public void delete(){
        try{
            printDoc();
            System.out.println("--------- Delete Doctor -------");
            String code = Menu.getString("Enter Code : ");
            dList.removeDoctor(dList.getDoctorByCode(code));
            System.out.println("Remove doctor successfull");
            }catch(Exception e){
            System.out.println(e.getMessage());
            }
    }
    public void search() throws Exception{
        System.out.println("---------- Search Doctor --------");
        String text = Menu.getString("Enter text : ");
        dList.searchDoctor(text);
    }
}
