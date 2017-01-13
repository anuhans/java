import java.util.LinkedList;
import java.util.*;
public class Connected
{
	private boolean[] marked; // to mark whether connected or not
	private int[] id;         // array of connected nodes
	private int[] size;       //total no of ids
	private int count;      //total count 
	
	public Connected(Graph G)
	{
		marked = new boolean[G.v()];
		id = new int[G.v()];
		size = new int[G.v()];
		for(int v=0; v<G.v(); v++)
		{
			if(!marked[v])
			{
				dfs(G,v);
				count++;
			}
		}
	}

	public void dfs(Graph G,int v)
	{
		marked[v] = true;
		id[v] = count;
		size[count]++;
		for(int w : G.adj(v))
		{
			if(!marked[w])
				dfs(G,w);
		}
	}

	public int id(int v)
	{
		return id[v];
	}
	
	public int size(int v)
	{
		return size(id[v]);
	}
	
	public int count()
	{
		return count;
	}
	
	public  static void main(String[] args)
	{
		Graph G = new Graph(6);
		G.addEdge(1,3);
		G.addEdge(1,4);
		G.addEdge(3,5);
		G.addEdge(0,2);
		G.addEdge(4,5);
		
		Connected cc = new Connected(G);
		int m = cc.count();
		System.out.println(m + "components");
		Queue<Integer>[] components =  new LinkedList[m];
		for(int i=0;i<m;i++)
		{
			components[i] = new LinkedList();
		}
		for(int v=0;v<G.v();v++)
		{
			components[cc.id[v]].add(v);
		}
		for(int i=0;i<m;i++)
		{
			System.out.println(i+" graph");
			for(int v : components[i])
			{
				System.out.println(v);
			}
			
		}

	 }
}
		
			
