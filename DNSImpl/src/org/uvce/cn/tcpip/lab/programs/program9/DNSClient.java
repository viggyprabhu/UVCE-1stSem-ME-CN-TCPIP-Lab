package org.uvce.cn.tcpip.lab.programs.program9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class DNSClient {

	public static void main(String[] args) {
		try
		{
			Socket s=new Socket("127.0.0.1",15000);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader din = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream dout=new PrintStream(s.getOutputStream());
			System.out.println("Enter the domain name:");
			dout.println(in.readLine());
			System.out.println(din.readLine());
			s.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
