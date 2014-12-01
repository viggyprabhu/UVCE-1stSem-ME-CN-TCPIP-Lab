package org.uvce.cn.tcpip.labprograms.program2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
public class ARPClient
{
	public static void main(String args[])
	{
		try
		{          


			Socket clsct=new Socket("127.0.0.1",2980);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			DataInputStream din=new DataInputStream(clsct.getInputStream());
			PrintStream dout=new PrintStream(clsct.getOutputStream());
			System.out.println("Enter the Logical address(IP):");
			String str1=in.readLine();
			dout.println(str1);
			byte[] mac=new byte[6];
			din.readFully(mac,0,mac.length);
			if (mac!=null || mac.length==0)
			{
				System.out.print("MAC Address : ");
				for (int i=0; i<mac.length; i++)
				{
					System.out.format("%02X%s", mac[i], (i<mac.length - 1) ? "-" :"");
				}
			}
			clsct.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}