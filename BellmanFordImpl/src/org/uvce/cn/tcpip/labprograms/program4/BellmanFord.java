package org.uvce.cn.tcpip.labprograms.program4;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
public class BellmanFord
{
	LinkedList<Edge> edges;
	int d[];
	Integer p[];
	int n,e,s;
	final int INFINITY=999;
	private static class Edge
	{
		int u,v,w;
		public Edge(int a,int b,int c)
		{
			u=a;
			v=b;
			w=c;
		}
	}
	BellmanFord() throws IOException
	{
		int item;
		edges=new LinkedList<Edge>();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of vertices");
		n=sc.nextInt();
		System.out.println("Cost matrix");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				item=sc.nextInt();
				if(item!=0)
					edges.add(new Edge(i,j,item));
			}
		e=edges.size();
		d=new int[n];
		System.out.println("enter the source vertex");
		s=sc.nextInt();
		sc.close();
	}
	/*Relaxing each edge for (n-1) time*/
	void relax()
	{
		int i,j;
		p = new Integer[n];
		for(i=0;i<n;++i) {
			d[i]=INFINITY;
			p[i] = null;
		}
		d[s]=0;
		for(i=0;i<n-1;++i)
			for(j=0;j<e;++j)
				if(d[edges.get(j).u]+edges.get(j).w<d[edges.get(j).v])
				{
					d[edges.get(j).v] = d[edges.get(j).u] + edges.get(j).w;
					p[edges.get(j).v] = edges.get(j).u;
				}
	}
	/*Check for negative cycle*/
	boolean cycle()
	{
		int j;
		for(j=0;j<e;++j)
			if(d[edges.get(j).u]+edges.get(j).w<d[edges.get(j).v])
				return false;
		return true;
	}
	public static void main(String args[])throws IOException
	{
		BellmanFord r=new BellmanFord();
		r.relax();
		if(r.cycle())
		{
			System.out.println("Shortest Distance from Source vertex:" +r.s);
			for(int i=0;i<r.n;i++){
				System.out.println("Shortest distance to vertex "+i+" is \t(Distance)="+r.d[i]);
			}
		}
		else
		{
			System.out.println("there is a negative edge cycle");
		}
	}
}