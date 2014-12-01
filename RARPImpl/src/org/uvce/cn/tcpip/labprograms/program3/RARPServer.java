package org.uvce.cn.tcpip.labprograms.program3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
public class RARPServer
{
	
	public static void main(String args[])
	{
		try
		{
			ServerSocket obj=new ServerSocket(6000);
			Socket obj1=obj.accept();
			System.out.println("Waiting for a new request\n");	
			BufferedReader din=new BufferedReader(new InputStreamReader(obj1.getInputStream()));
			PrintStream dout=new PrintStream(obj1.getOutputStream());
			if(din.readLine().startsWith("64-5A-04-CA-55-97"))
			{
				dout.println("IP Address is 192.168.0.4");
			}
			else
			{
				dout.println("Table doesnt have this MAC Address.");
			}
			obj.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}