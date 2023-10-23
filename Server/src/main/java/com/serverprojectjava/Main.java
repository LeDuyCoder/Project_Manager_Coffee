package com.serverprojectjava;


import com.serverprojectjava.Server.server;

public class Main {
    public static void main(String[] args) {
        server myserver = new server();
        myserver.init();

        System.out.println(myserver.getPortServer());
    }
}