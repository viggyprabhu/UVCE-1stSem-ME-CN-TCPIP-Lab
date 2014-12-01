/*
Description: 

This program is to demonstrate Basic Socket Communication. 
In the program, we initiate a thread in which we make the client listen to an available port.
We then initiate another thread in which we make the client connect to the port of another client and send messages given by the user.
   
*/
package org.uvce.cn.tcpip.labprograms.program1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
 */

/**
 * @author viggy
 *
 */
public class Client {

	private static String hostName = "127.0.0.1";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket s = null;
		try {
			
			//Create a new port
			s = new ServerSocket(0);
			System.out.println("listening on port: " + s.getLocalPort());
			
			//Initiate thread to print data from the port.
			printData(s); 
			
			//Initiate thread to collect data from user and send it to other client
		    sendData();
		    
		    while(true){
		    	//Infinite loop to make the main thread to wait for other threads to complete.
		    }
		     
		} catch (IOException e) {
			System.out.println("No ports free!!!");
			System.exit(0);
		} 
		finally 
		{
			try {
				if(null!=s)
				{
					s.close();
				}
			} catch (IOException e) {
				System.out.println("Error closing ports!!!");
				System.exit(0);
			}
		}
	}

	private static void sendData() {
		Thread sendThread = new Thread() {
			public void run() {
				try {
			    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				    System.out.print("Enter the port number of client that you want to talk to:");
				    int otherSidePort = Integer.parseInt(br.readLine());
					Socket echoSocket = new Socket(hostName, otherSidePort);
					BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
					PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
					String userInput;
					while ((userInput = stdIn.readLine()) != null) {
					    out.println(userInput);
					}
			    } catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		sendThread.start();
	    
		
	}

	private static void printData(final ServerSocket s) throws IOException{
		Thread printThread = new Thread() {
			public void run(){
				BufferedReader in;
				try {
					in = new BufferedReader(new InputStreamReader(s.accept().getInputStream()));
					String inputLine;
					while ((inputLine = in.readLine()) != null) {
						System.out.println(inputLine);
					    if (inputLine.equals("Bye."))
					            return ;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		printThread.start();
	}
}
