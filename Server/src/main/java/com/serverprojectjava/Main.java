package com.serverprojectjava;


import java.util.List;

import com.serverprojectjava.Server.server;
import com.serverprojectjava.Server.sqlDataServer;
import com.serverprojectjava.Server.Module.Employee;
import com.serverprojectjava.Throw.ExceptionServer;

public class Main {
    public static void main(String[] args) {
        // server myserver = new server();
        // myserver.init();

        // System.out.println(myserver.getPortServer());

        sqlDataServer sqlSv = new sqlDataServer();
        try {
            sqlSv.init();
            List<Employee> datas = sqlSv.getAllDataEmployee();
            for (Employee employee : datas) {
                System.out.println(employee.getID() + " - " + employee.getName() + " - " + employee.getCCCD() + " - " + employee.getDataJoin() + " - " + employee.getSalary());
            }
        } catch (ExceptionServer e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}