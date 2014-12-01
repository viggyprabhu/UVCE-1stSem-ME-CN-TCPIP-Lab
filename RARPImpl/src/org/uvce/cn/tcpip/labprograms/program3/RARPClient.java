package org.uvce.cn.tcpip.labprograms.program3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
public class RARPClient
{
	public static void main(String args[])throws Exception
	{

		try
		{
			Socket s=new Socket("127.0.0.1",6000);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader din = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream dout=new PrintStream(s.getOutputStream());
			System.out.println("Enter the MAC address:");
			dout.println(in.readLine());
			System.out.println(din.readLine());
			s.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}