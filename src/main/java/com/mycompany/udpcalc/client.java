package com.mycompany.udpcalc;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author Gabriel
 */


public class client {
public static void main(String args[]) throws Exception
    {
        DatagramSocket aSocket = null;
        
    	System.out.println("Ex: 5 + 5");
		
		Scanner sc = new Scanner(System.in);
		String msg= "";
		
		try {
			while(!msg.equals("sair")){
				System.out.println("digite");
				
				msg = sc.nextLine();
				
				byte [] m = msg.getBytes();
				aSocket = new DatagramSocket();    
				InetAddress aHost = InetAddress.getByName("localhost");
				int serverPort = 6666;		                                                 
				
				DatagramPacket request = new DatagramPacket(m,  msg.length(), aHost, serverPort);
				aSocket.send(request);			                        
				
				
				byte[] buffer = new byte[1000];
				DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
				aSocket.receive(reply);
                                if(!msg.equals("sair")){
                                    System.out.println("Resultado: " + new String(reply.getData()));
                                }
			}
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
	}
    }
