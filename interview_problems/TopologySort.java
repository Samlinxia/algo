import java.util.Iterator;
import java.util.Stack;

import data_structure.Graph;
import data_structure.GraphNode;

/**
 * http://www.geeksforgeeks.org/topological-sorting/
 * 
 * */
public class TopologySort {
  
  Stack<Integer> stack = null;
  Graph g;
  public TopologySort(Graph g) {
	 this.g = g;
	 int V = g.V();
	 stack = new Stack<>();
	 boolean[] visited = new boolean[V];
	 for (int v = 0; v < V; v++) {
		if (!visited[v]) {
		  sort(v, visited);
		}
	 }
	 //print out stack which is reverse order of push in stack
	 while (!stack.isEmpty()) {
		int v = stack.pop();
		System.out.println(v);
	 }
  }
  
  public void sort(int v, boolean[] visited) {
	 visited[v] = true;
	 Iterator iter = g.adj(v).iterator();
	 while (iter.hasNext()) {
		int i = (Integer)iter.next();
		if (!visited[i]) {
		  sort(i, visited);
		}
	 }
	// Push current vertex to stack which stores result
	 stack.push(v);
  }
  
  

  public static void main(String[] args) {
	 // TODO Auto-generated method stub
	 
  }

}