package GraphGeneration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
	
	private final List<Node> nodes;
    private final List<Edge> edges;
    public Set<Node> closedList;
    public Set<Node> openList;
    private Map<Node, Node> predecessors;
    private Map<Node, Integer> distance;
    int fill =0;
    int mem = 0;
    public  Dijkstra(Graph graph) {
            this.nodes = new ArrayList<Node>(graph.getVertexes());
            this.edges = new ArrayList<Edge>(graph.getEdges());
    }

    public LinkedList<Node> execute(Node source,Node dest) {
            closedList = new HashSet<Node>();
            openList = new HashSet<Node>();
            distance = new HashMap<Node, Integer>();
            predecessors = new HashMap<Node, Node>();
            distance.put(source, 0);
            openList.add(source);
            fill++;
            mem++;
            while (openList.size() > 0) {
            		mem=Math.max(mem,openList.size());
                    Node node = getMinimum(openList);
                    if(node==dest)
                    	break;
                    closedList.add(node);
                    openList.remove(node);
                    findMinimalDistances(node);
            }
           return getPath(dest); 
    }

    private void findMinimalDistances(Node node) {
            List<Node> adjacentNodes = getNeighbors(node);
            for (Node target : adjacentNodes) {
                    if (getShortestDistance(target) > getShortestDistance(node)
                                    + getDistance(node, target)) {
                            distance.put(target, getShortestDistance(node)
                                            + getDistance(node, target));
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

    private int getShortestDistance(Node destination) {
            Integer d = distance.get(destination);
            if (d == null) {
                    return Integer.MAX_VALUE;
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
    
    public static void main(String[] args){
    	 
                 // Lets check from location Loc_1 to Loc_10
//                 Graph graph = new SmallGraph();
                 Graph graph = new LargeGraph();
                 
                 Dijkstra dijkstra = new Dijkstra(graph);
                 Astar dj = new Astar(graph);
                 
                 long dij_startTime = System.currentTimeMillis();
                 LinkedList<Node> path = dijkstra.execute(graph.getVertexes().get(0),graph.getVertexes().get(9900));
                 long dij_endTime   = System.currentTimeMillis();
                 long dij_totalTime = dij_endTime - dij_startTime;
                 
                 long astar_startTime = System.currentTimeMillis();
                 LinkedList<Node> astar_path = dj.execute(graph.getVertexes().get(0),graph.getVertexes().get(9900));
                 long astar_endTime   = System.currentTimeMillis();
                 long astar_totalTime = astar_endTime - astar_startTime;
                 
//                 for (Node vertex : path) {
//                         System.out.println(vertex);
//                 }
//                 
//                 for (Node vertex : astar_path) {
//                     System.out.println(vertex);
//             }
                 int dij_fill = dijkstra.openList.size()+dijkstra.closedList.size();
                 int astar_fill = dj.openList.size()+dj.closedList.size();
                 System.out.println( dij_fill+" "+dijkstra.mem);
                 System.out.println( astar_fill+" "+dj.mem);
                 System.out.println( dij_totalTime+" "+astar_totalTime);
         }
    	
    }

