package java_practice.Linked_list;


public class Testing{
	
	
	private final int V=9;
	
	public int shortDistance(int dist[],Boolean set[]) {
		int min=Integer.MAX_VALUE;
		int min_integer=-1;
		for(int i=0;i<V;i++) {
			if(set[i]==false&&dist[i]<=min) {
				min=dist[i];
				min_integer=i;
			}
		}
		return min_integer;
	}
	public void dikstra(int graph[][],int src) {
		int dist[]=new int[V];
		Boolean[] set=new Boolean[V];
		for(int i=0;i<V;i++) {
			dist[i]=Integer.MAX_VALUE;
			set[i]=false;
		}
		dist[src]=0;
		for(int i=0;i<V-1;i++) {
			int u=shortDistance(dist,set);
			set[u]=true;
			for(int j=0;j<V;j++) {
				if(!set[j]&&dist[u]!=Integer.MAX_VALUE&&graph[u][j]!=0&&dist[u]+graph[u][j]<dist[j]) {
					dist[j]=dist[u]+graph[u][j];
				}
			}
		}
		
		printarr(dist);
	}
	public void printarr(int dist[]) {
		for(int i=0;i<V;i++) {
			System.out.println(i+" "+dist[i]);
		}
	}
	public static void main(String[] args) {
		int graph[][]= {{0,4,0,0,0,0,0,8,0},
				{4,0,8,0,0,0,0,11,0},
				{0,8,0,7,0,4,0,0,2},
				{0,0,7,0,9,14,0,0,0},
				{0,0,0,9,0,10,0,0,0},
				{0,0,4,14,10,0,2,0,0},
				{0,0,0,0,0,2,0,1,6},
				{8,11,0,0,0,0,1,0,7},
				{0,0,2,0,0,0,6,7,0}};
		
		
		Testing test=new Testing();
		test.dikstra(graph,0);
	}
}