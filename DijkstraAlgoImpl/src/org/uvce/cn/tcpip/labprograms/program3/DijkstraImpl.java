package org.uvce.cn.tcpip.labprograms.program3;

import java.util.Scanner;
public class DijkstraImpl
{
	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		int i,j,k,s;
		System.out.println("Enter the number of vertices");
		int n=scanner.nextInt();
		int adj[][]=new int[n+1][n+1];
		int path[][]=new int[n+1][n+1];
		int dist[][]=new int[n+1][n+1];
		System.out.println("Enter the weighted adjacency matrix");
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
			{
				adj[i][j]=scanner.nextInt();
				if(adj[i][j]==0)
				{
					adj[i][j]=999;
					continue;
				}
			}
		
		System.out.println("Enter the source vertex");
		s=scanner.nextInt();
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
			{
				path[i][j]=0;
				dist[i][j]=adj[i][j];
			}

		for(k=1;k<=n;k++)
			for(i=1;i<=n;i++)
				for(j=1;j<=n;j++)

					if(adj[i][k]+adj[k][j]<adj[i][j])
					{	
						adj[i][j]=adj[i][k]+adj[k][j];
						path[i][j]=k;
					}
				
		for(i=1;i<=n;i++)
			if(s!=i)
				if(path[s][i]==0)
					if(adj[s][i]==999)
						continue;
					else
						System.out.println("Shortest path from"+s +"to"+i+":"+s+"----->"+i+"cost is"+adj[s][i]);
				
				else
					System.out.println("Shortest path from"+s +"to"+i+":"+s+"----->"+path[s][i]+"------>"+i+"cost is"+adj[s][i]);
		
		scanner.close();
	}
}