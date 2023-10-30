package com.serverprojectjava.Server.Module;

import java.net.Socket;

public class ClientConnect {
    private Socket socket;

    public ClientConnect(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket(){
        return this.socket;
    }    
}
