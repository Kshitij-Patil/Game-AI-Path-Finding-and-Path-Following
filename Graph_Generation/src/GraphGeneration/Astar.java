package GraphGeneration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Astar {
	
	private final List<Node> nodes;
    private final List<Edge> edges;
    public Set<Node> closedList;
    public Set<Node> openList;
    private Map<Node, Node> predecessors;
    private Map<Node, Integer> distance;
    private Map<Node, Float> total;
    int fill=0;
    int mem=0;
    public  Astar(Graph graph) {
            this.nodes = new ArrayList<Node>(graph.getVertexes());
            this.edges = new ArrayList<Edge>(graph.getEdges());
    }

    public LinkedList<Node> execute(Node source,Node dest) {
            closedList = new HashSet<Node>();
            openList = new HashSet<Node>();
            distance = new HashMap<Node, Integer>();
            total = new HashMap<Node, Float>();
            predecessors = new HashMap<Node, Node>();
            distance.put(source, 0);
            total.put(source,0+euclid(source,dest));
            openList.add(source);
            fill++;
            while (openList.size() > 0) {
            	    mem=Math.max(mem,openList.size());
                    Node node = getMinimum(openList);
                    if(node==dest)
                    	break;
                    closedList.add(node);
                    openList.remove(node);
                    findMinimalDistances(node,dest);
            }
           return getPath(dest); 
    }

    private void findMinimalDistances(Node node,Node dest) {
            List<Node> adjacentNodes = getNeighbors(node);
            for (Node target : adjacentNodes) {
                    if (getShortestDistance(target) > getShortestDistance(node)
                                    + getDistance(node, target)) {
                            distance.put(target, (int) (getShortestDistance(node)
                                            + getDistance(node, target)));
                            total.put(target, distance.get(target)+euclid(target,dest));
                            predecessors.put(target, node);
                            openList.add(target);
                            fill++;
                    }
            }

    }

    private int getDistance(Node node, Node target) {
            for (Edge edge : edges) {
                    if (edge.getSource().equals(node)
                                    && edge.getDestination().equals(target)) {
                            return edge.getWeight();
                    }
            }
            throw new RuntimeException("Should not happen");
    }

    private List<Node> getNeighbors(Node node) {
            List<Node> neighbors = new ArrayList<Node>();
            for (Edge edge : edges) {
                    if (edge.getSource().equals(node)
                                    && !isSettled(edge.getDestination())) {
                            neighbors.add(edge.getDestination());
                    }
            }
            return neighbors;
    }

    private Node getMinimum(Set<Node> vertexes) {
            Node minimum = null;
            for (Node vertex : vertexes) {
                    if (minimum == null) {
                            minimum = vertex;
                    } else {
                            if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                                    minimum = vertex;
                            }
                    }
            }
            return minimum;
    }

    private boolean isSettled(Node vertex) {
            return closedList.contains(vertex);
    }

    private Float getShortestDistance(Node destination) {
            Float d = total.get(destination);
            if (d == null) {
                    return Float.MAX_VALUE;
            } else {
                    return d;
            }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public LinkedList<Node> getPath(Node target) {
            LinkedList<Node> path = new LinkedList<Node>();
            Node step = target;
            // check if a path exists
            if (predecessors.get(step) == null) {
                    return null;
            }
            path.add(step);
            while (predecessors.get(step) != null) {
                    step = predecessors.get(step);
                    path.add(step);
            }
            // Put it into the correct order
            Collections.reverse(path);
            return path;
    }
    private float manhatta(Node source,Node dest){
		
    	return Math.abs(source.getX()-dest.getX())+Math.abs(source.getY()-dest.getY());
    	
    }
    private float euclid(Node source,Node dest){
		
    	return (float) Math.sqrt((Math.abs(source.getX()-dest.getX())*Math.abs(source.getX()-dest.getX()))+(Math.abs(source.getY()-dest.getY())*Math.abs(source.getY()-dest.getY())));
    	
    }
    public static void main(String[] args){
    	
                 Graph graph = new LargeGraph();
                 Astar dijkstra = new Astar(graph);
                 
                 long dij_startTime = System.currentTimeMillis();
                 LinkedList<Node> path = dijkstra.execute(graph.getVertexes().get(0),graph.getVertexes().get(9900));
                 long dij_endTime   = System.currentTimeMillis();
                 long dij_totalTime = dij_endTime - dij_startTime;
                             
//                 for (Node vertex : path) {
//                         System.out.println(vertex);
//                 }
//                 System.out.println( dijkstra.fill+" "+dijkstra.mem);
                 
                 int dij_fill = dijkstra.openList.size()+dijkstra.closedList.size();
//                 int astar_fill = dj.openList.size()+dj.closedList.size();
                 System.out.println( dij_fill+" "+dijkstra.mem);
//                 System.out.println( astar_fill);
                 System.out.println( "Time : "+dij_totalTime);
         }
 
    	
    }

