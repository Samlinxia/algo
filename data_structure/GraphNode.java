package data_structure;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

  int label;
  List<GraphNode> neighbors;
  
  public GraphNode(int x) {
	 // TODO Auto-generated constructor stub
	 label = x;
	 neighbors = new ArrayList<>();
  }

}
