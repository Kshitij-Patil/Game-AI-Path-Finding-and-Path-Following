package GraphGeneration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SmallGraph implements Graph {
	
	//ArrayList of Obstacles, if doesnt match, then add node
	ArrayList<Integer> obstacles = new ArrayList<Integer>();
	
	 static List<Node> nodess;
     static List<Edge> edgess;

	SmallGraph(ArrayList<Integer> obstacle_indices ){
		
		obstacles = obstacle_indices;
		nodess = new ArrayList<Node>();
        edgess = new ArrayList<Edge>();
        for (int i = 0; i < 400; i++) {
            Node location = new Node( i, "Node_" + i,20+40*(i%20),20+40*(i/20));
            nodess.add(location);
        }
 
        
        for(int i = 0; i < 400; i++)
        {
        	
        	if(!obstacles.contains(i))
        	{
        		// top
        		if((nodess.get(i).getY()-40) > 0 && !obstacles.contains(i-20))
        			addNewEdge(i, i-20, 10);
        		// 	bottom
        		if((nodess.get(i).getY()+40) < 800 && !obstacles.contains(i+20))
        			addNewEdge(i, i+20, 10);
        		//right
        		if((nodess.get(i).getX()+40) < 800 && !obstacles.contains(i+1))
        			addNewEdge(i, i+1, 10);
        		//left
        		if((nodess.get(i).getX()-40) > 0 && !obstacles.contains(i-1))
        			addNewEdge(i, i-1, 10);
        	}
        }
     }

	private static void addNewEdge(int sourceLocNo, int destLocNo,
            int duration) {
    Edge lane = new Edge(nodess.get(sourceLocNo), nodess.get(destLocNo), duration );
    edgess.add(lane);
	}
	
	public List<Node> getVertexes() {
        return nodess;
	}
	public List<Edge> getEdges() {
        return edgess;
	}
	
}
