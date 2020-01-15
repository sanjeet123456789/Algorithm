package java_practice.BellmanFordAlgorithm;

import java.util.*;
import java.lang.*;
import java.io.*;
public class BellmanFord {
	class Edge{
		int src,dest,weight;
		Edge(){
			src=dest=weight=0;
		}
	};
	int V,E;
	Edge edge[];
	BellmanFord(int v,int e){
		V=v;
		E=e;
		edge=new Edge[e];
		for(int i=0;i<e;++i) {
			edge[i]=new Edge();
		}
	}
	
	void Bellman(BellmanFord bellmanford,int src) {
		int V=bellmanford.V,E=bellmanford.E;
		int dist[] =new int[V];
		for(int i=0;i<V;++i) {
			dist[i]=Integer.MAX_VALUE;
			
		}
		dist[src]=0;
		for(int i=1;i<V;++i) {
			for(int j=0;j<E;++j) {
				int u=bellmanford.edge[j].src;
				int v=bellmanford.edge[j].dest;
				int weight=bellmanford.edge[j].weight;
				if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v])
					dist[v]=dist[u]+weight;
			}
		}
		
		for(int j=0;j<E;++j) {
			int u=bellmanford.edge[j].src;
			int v=bellmanford.edge[j].dest;
			int weight=bellmanford.edge[j].weight;
			if(dist[u]!=Integer.MAX_VALUE&&dist[u]+weight<dist[v]) {
				System.out.println("");
				return;
			}
		}
		printArr(dist,V);
	}
	void printArr(int dist[],int V) {
		System.out.println("Vertex distance from source");
		for(int i=0;i<V;++i) {
			System.out.println(i+"\t"+dist[i]);
		}
	}
	public static void main(String[] args) {
		int V=5;
		int E=8;
		
		BellmanFord bellmanford=new BellmanFord(V,E);
		bellmanford.edge[0].src=0;
		bellmanford.edge[0].dest=1;
		bellmanford.edge[0].weight=-1;
		
		bellmanford.edge[1].src=0;
		bellmanford.edge[1].dest=2;
		bellmanford.edge[1].weight=4;
		
		bellmanford.edge[2].src=1;
		bellmanford.edge[2].dest=2;
		bellmanford.edge[2].weight=3;
		
		bellmanford.edge[3].src=1;
		bellmanford.edge[3].dest=4;
		bellmanford.edge[3].weight=2;
		
		
		bellmanford.edge[4].src=1;
		bellmanford.edge[4].dest=4;
		bellmanford.edge[4].weight=2;
		
		bellmanford.edge[5].src=3;
		bellmanford.edge[5].dest=2;
		bellmanford.edge[5].weight=5;
		
		bellmanford.edge[6].src=3;
		bellmanford.edge[6].dest=1;
		bellmanford.edge[6].weight=1;
		
		
		bellmanford.edge[7].src=4;
		bellmanford.edge[7].dest=3;
		bellmanford.edge[7].weight=-3;
		
		bellmanford.Bellman(bellmanford, 0);
		
	}
}
