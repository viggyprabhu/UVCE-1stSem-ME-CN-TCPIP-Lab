package org.uvce.cn.tcpip.lab.programs.program9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class DNSServer {

	private static HashMap<String, String> DNSMap = new HashMap<String, String>();
	
	public static void DNSEntries() {
		DNSMap.put("google.com", "75.8.19.245");
		DNSMap.put("facebook.com", "173.252.120.6");
		DNSMap.put("localhost", "127.0.0.1");
		DNSMap.put("www.google.com", "75.8.19.245");
		DNSMap.put("uvce.ac.in", "83.175.20.5");		
	}
	public static void main(String[] args) {
		DNSEntries();
		try {
			ServerSocket s = new ServerSocket(15000);
			Socket obj = s.accept();
			BufferedReader din=new BufferedReader(new InputStreamReader(obj.getInputStream()));
			PrintStream dout=new PrintStream(obj.getOutputStream());
			String readLine;
			while((readLine = din.readLine())!=null) {
				if(DNSMap.containsKey(readLine))
				{
					dout.println("DNS entry for "+ readLine +": "+DNSMap.get(readLine));
				}
				else
				{
					dout.println("There is no DNS entry for :"+readLine);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
