/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Doctor;
import View.Menu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thaip
 */
public class Doctormanagement {
    private HashMap<String, Doctor> hashDoctor;

    public Doctormanagement() {
        this.hashDoctor = new HashMap<>();
    }
    public boolean addDoctor(Doctor d) throws Exception {
        checkDatabaseExist();
        if (d == null) {
            throw new Exception("Data does not exist");
        }

        if (hashDoctor.containsKey(d.getCode())) {
            throw new Exception("Doctor code [" + d.getCode() + "] is duplicate");
        }

        hashDoctor.put(d.getCode(), d);
        return true;
    }

    public boolean updateDoctor(Doctor d) throws Exception {
        checkDatabaseExist();

        if (d == null) {
            throw new Exception("Data does not exist");
        }

        checkDoctorExist(d.getCode());

        hashDoctor.put(d.getCode(), d);
        return true;
    }

    public boolean removeDoctor(Doctor d) throws Exception {
        checkDatabaseExist();
        
        if (d == null) {
            throw new Exception("Data does not exist");
        }
        
        checkDoctorExist(d.getCode());
        
        hashDoctor.remove(d.getCode());
        return true;
    }

    public void searchDoctor(String input) throws Exception {
        checkDatabaseExist();
        
        ArrayList<Doctor> result = new ArrayList<Doctor>();

        for (Map.Entry<String, Doctor> entry : hashDoctor.entrySet()) {
            Doctor doctor = entry.getValue();
            if (doctor.getName().contains(input) ||
                doctor.getSpecialization().contains(input) ||
                doctor.getCode().contains(input) ||
                String.valueOf(doctor.getAvailability()).contains(input)) {
                result.add(doctor);
            }
        }
        String tieude = String.format("%-10s%-15s%-15s%-10s", "Code","Name","Specialization","Availability");
        System.out.println(tieude);
        for (Doctor a : result) {
            System.out.println(a.toString());
        }
    }
    
    public void displayDoc(){
        String tieude = String.format("%-10s%-15s%-15s%-10s", "Code","Name","Specialization","Availability");
        System.out.println(tieude);
        for (Map.Entry<String, Doctor> k : hashDoctor.entrySet()) {
            System.out.println(k);
        }
    }
    
    public Doctor getDoctorByCode(String code) throws Exception{
        checkDatabaseExist();
        checkDoctorExist(code);
        Doctor doctor = hashDoctor.get(code);
        if(doctor == null) throw new Exception("Doctor code doesn’t exist");
        return doctor;
    }
    
    private void checkDoctorExist(String code) throws Exception{
        if (!hashDoctor.containsKey(code)) {
            throw new Exception("Data doesn't exist");
        }
    }
    private void checkDatabaseExist() throws Exception {
        if (hashDoctor == null) {
            throw new Exception("Database does not exist");
        }
    }
    
}
