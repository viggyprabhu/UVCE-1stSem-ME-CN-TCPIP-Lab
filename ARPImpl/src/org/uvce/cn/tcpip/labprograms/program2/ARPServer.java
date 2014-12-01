package org.uvce.cn.tcpip.labprograms.program2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;


public class ARPServer
{
	public static void main(String args[]) throws Exception
	{
		try
		{
			ServerSocket obj=new ServerSocket(2980);
			Socket obj1=obj.accept();
			BufferedReader din = new BufferedReader(new InputStreamReader(obj1.getInputStream()));
			PrintStream dout=new PrintStream(obj1.getOutputStream());
			String ipaddr=din.readLine();
			InetAddress address = InetAddress.getByName(ipaddr);
			System.out.println("IPaddress of sender = "+address);
			NetworkInterface ni = NetworkInterface.getByInetAddress(address);
			byte[] mac = ni.getHardwareAddress();
			if(mac!=null){
				dout.write(mac,0,mac.length);				
			}
			obj.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}
