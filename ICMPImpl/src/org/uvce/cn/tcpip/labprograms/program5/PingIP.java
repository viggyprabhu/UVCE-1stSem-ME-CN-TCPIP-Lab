package org.uvce.cn.tcpip.labprograms.program5;


import java.io.BufferedReader;
import java.io.InputStreamReader;
public class PingIP {
	
	// In this program we use system command Ping
	// We call java inbuilt class Runtime.getRuntime.exec to execute the command
	//Whatever output comes from the command, we show it to the user
	public static void main(String args[]) {
		
		try {
			Process p = Runtime.getRuntime().exec("ping 127.0.0.1");
			BufferedReader inputStream = new BufferedReader(new       InputStreamReader(p.getInputStream()));
			String s = "";
			while ((s = inputStream.readLine()) != null) {
				System.out.println(s);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}