package com.serverprojectjava.Server.Module;

public class Employee {
    private String ID;
    private String Name;
    private int CCCD;
    private String DataJoin;
    private int Salary;

    public Employee(String iD, String name, int CCCD, String dataJoin, int salary) {
        this.ID = iD;
        this.Name = name;
        this.CCCD = CCCD;
        this.DataJoin = dataJoin;
        this.Salary = salary;
    }

  

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public int getCCCD() {
        return CCCD;
    }

    public String getDataJoin() {
        return DataJoin;
    }

    public int getSalary() {
        return Salary;
    }

    
}
