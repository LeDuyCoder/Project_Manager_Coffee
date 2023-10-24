package com.serverprojectjava.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.serverprojectjava.Throw.ExceptionServer;

public class server {

    private int Port;

    public void init(){
        LoadDataServer();
        try {
            runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * function load port server in file data
     */
    private void LoadDataServer(){
        JSONParser jsonParser = new JSONParser();

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("config.json");

            if (inputStream != null) {
                InputStreamReader reader = new InputStreamReader(inputStream);
                Object obj = jsonParser.parse(reader);
                JSONObject jsonDataServer = (JSONObject) obj;
                JSONObject ListDataServer = (JSONObject) jsonDataServer.get("DataServer");

                long portInData = (long) ListDataServer.get("Port");
                if(portInData > 99999){
                    try {
                        throw new ExceptionServer("Port just in 0 - 99999");
                    } catch (ExceptionServer e) {
                        e.printStackTrace();
                    }
                }else{
                    this.Port = (int) portInData;
                }
            } else {
                System.err.println("no found file config.json in resources.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException
     */
    private void runServer() throws IOException{
        try (ServerSocket serverSocket = new ServerSocket(this.Port)) {
            System.out.println("Server is running...");
            System.out.println("Proccess: 0%");
            System.out.println("Proccess: 10%");
            System.out.println("Proccess: 50%");
            System.out.println("Proccess: 75%");
            System.out.println("Proccess: 95%");
            System.out.println("Proccess: 100%");
            System.out.println("DONE");
            while(true){
                try (Socket socket = serverSocket.accept()) {
                    
                }
            }
        }
    }

    /*
     * function to get port of server
     */
    public int getPortServer(){
        return this.Port;
    }
    
}
