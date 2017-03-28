package GraphGeneration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LargeGraph implements Graph {
	
	 static List<Node> nodess;
     static List<Edge> edgess;

	LargeGraph(){
		
		nodess = new ArrayList<Node>();
        edgess = new ArrayList<Edge>();
        for (int i = 0; i < 10000; i++) {
            Node location = new Node( i, "Node_" + i,10*(i%100),10*(i/100));
            nodess.add(location);
    }

        float randomNum1,randomNum2 ,randomNum3,randomNum4 ;       
          for(int i = 0; i < 10000; i++)
          {
        	  randomNum1 = (float)(Math.random()) ; 
              randomNum2 = (float)(Math.random()) ; 
              randomNum3 =  (float)(Math.random()); 
              randomNum4 =  (float)(Math.random()); 
          	// top
          	if(i-100 > 0 && randomNum1 > 0.2)
          		addNewEdge(i, i-100, 10);
          	// bottom
          	if(i+100 < 10000 && randomNum2 > 0.2)
          		addNewEdge(i, i+100, 10);
          	//right
          	if(i%100 > 0 && randomNum3 > 0.2)
          		addNewEdge(i, i-1, 10);
          	//left
          	if(i%100 < 99 && randomNum4 > 0.2)
          		addNewEdge(i, i+1, 10);
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
