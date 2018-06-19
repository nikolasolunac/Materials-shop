/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import forme.FmServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SOLUNAC
 */
public class Komunikacija extends Thread{
    
    private boolean kraj;
    private FmServer forma;

    public Komunikacija(FmServer forma) {
        kraj = false;
        this.forma = forma;
    }
    
    public void pokreniServer() throws IOException{
        
        ServerSocket ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut");
        
        while(!kraj){
            Socket socket = ss.accept();
            System.out.println("Klijent se povezao");
            NitKlijent nk = new NitKlijent (socket, this);
            nk.start();
        }
    }
    
    @Override
    public void run(){
        try {
            pokreniServer();
        } catch (Exception ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
