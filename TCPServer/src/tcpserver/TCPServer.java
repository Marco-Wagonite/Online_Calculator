/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpserver;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author marco
 */

public class TCPServer {
    static final int PORT = 1234;
    private ServerSocket server = null;
    
    public TCPServer() {
        try {
            server = new ServerSocket(PORT);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Action() {
        Socket socket = null;
        int i = 0;
        System.out.println("Sever listening...");
        
        try {
            while((socket = server.accept()) != null) {
                new ServerThread(socket, "Client#" + i);
                System.out.printf("Thread for Client#%d generating...%n", i++);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new TCPServer().Action();
    }
    
}
