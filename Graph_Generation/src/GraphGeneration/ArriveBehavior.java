package GraphGeneration;

import java.util.ArrayList;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PVector;

public class ArriveBehavior extends PApplet{

	Player_pointer player1;
	ArrayList<Integer> obstacle_indices = new ArrayList<Integer>();
	Room r ;
	Graph small;
	Dijkstra djkshitra;
    Astar dj ;
    LinkedList<Node> path, path1;
    
	public static void main(String[] args) 
	{	
		PApplet.main("GraphGeneration.ArriveBehavior");
	}
	
	public void settings()
	{
		size(800,800);
    }

    public void setup()
    {
    	  frameRate(30);
    	  int radius=15;
		  PVector initial_position = new PVector(20, 20);
		  PVector initial_velocity = new PVector(0,0);   // Velocity of player
		  PVector initial_acceleration = new PVector(0,0);   // Velocity of player
		  
		  float initial_orientation=0;		  
		  float initial_rotation=0;
		  float initial_angular_acceleration = 0;
		  
		  // 4 too small 5 too big 4.8 just exact 
		  float max_velocity = (float) 4;
		  float max_acceleration  = 2;
		  
		  float max_rotation=10;
		  float max_angular_acceleration=3;

	      player1 = new Player_pointer(this, radius, initial_position, initial_velocity, initial_acceleration, initial_orientation, initial_rotation, initial_angular_acceleration, max_velocity, max_acceleration, max_rotation, max_angular_acceleration);
	      r = new Room(this);
	      
	      obstacle_indices.add(2);
	      obstacle_indices.add(7);
	      obstacle_indices.add(14);
	      obstacle_indices.add(16);
	      obstacle_indices.add(19);
	      
	      obstacle_indices.add(22);
	      obstacle_indices.add(27);
	      obstacle_indices.add(34);
	      obstacle_indices.add(36);
	      obstacle_indices.add(39);
	      obstacle_indices.add(29);
	      obstacle_indices.add(30);
	      obstacle_indices.add(31);
	      obstacle_indices.add(32);
	      
	      obstacle_indices.add(42);
	      obstacle_indices.add(47);
	      obstacle_indices.add(49);
	      obstacle_indices.add(50);
	      obstacle_indices.add(51);
	      obstacle_indices.add(52);
	      obstacle_indices.add(54);
	      obstacle_indices.add(56);
	      obstacle_indices.add(59);
	      
	      obstacle_indices.add(62);
	      obstacle_indices.add(67);
	      obstacle_indices.add(69);
	      obstacle_indices.add(70);
	      obstacle_indices.add(71);
	      obstacle_indices.add(72);
	      obstacle_indices.add(74);
	      obstacle_indices.add(76);
	      obstacle_indices.add(79);
	      
	      obstacle_indices.add(82);
	      obstacle_indices.add(87);
	      obstacle_indices.add(89);
	      obstacle_indices.add(90);
	      obstacle_indices.add(91);
	      obstacle_indices.add(92);
	      obstacle_indices.add(94);
	      obstacle_indices.add(96);
	      
	      obstacle_indices.add(102);
	      obstacle_indices.add(107);
	      obstacle_indices.add(114);
	      obstacle_indices.add(116);
	      
	      obstacle_indices.add(122);
	      obstacle_indices.add(127);
	      obstacle_indices.add(136);
	      obstacle_indices.add(139);
	      
	      obstacle_indices.add(147);
	      obstacle_indices.add(156);
	      obstacle_indices.add(159);
	      
	      obstacle_indices.add(167);
	      obstacle_indices.add(168);
	      obstacle_indices.add(169);
	      obstacle_indices.add(170);
	      obstacle_indices.add(171);
	      obstacle_indices.add(172);
	      obstacle_indices.add(173);
	      obstacle_indices.add(179);
	      
	      obstacle_indices.add(208);
	      obstacle_indices.add(209);
	      obstacle_indices.add(210);
	      obstacle_indices.add(211);
	      obstacle_indices.add(213);
	      obstacle_indices.add(216);
	      obstacle_indices.add(217);
	      obstacle_indices.add(218);
	      obstacle_indices.add(219);
	      
	      obstacle_indices.add(228);
	      obstacle_indices.add(233);
	      obstacle_indices.add(236);
	      
	      obstacle_indices.add(248);
	      obstacle_indices.add(253);
	      obstacle_indices.add(256);
	      
	      obstacle_indices.add(262);
	      obstacle_indices.add(268);
	      obstacle_indices.add(273);
	      
	      obstacle_indices.add(282);
	      obstacle_indices.add(288);
	      obstacle_indices.add(293);
	      
	      obstacle_indices.add(302);
	      obstacle_indices.add(308);
	      obstacle_indices.add(313);
	      obstacle_indices.add(316);
	      
	      obstacle_indices.add(322);
	      obstacle_indices.add(328);
	      obstacle_indices.add(333);
	      obstacle_indices.add(336);
	      
	      obstacle_indices.add(342);
	      obstacle_indices.add(344);
	      obstacle_indices.add(345);
	      obstacle_indices.add(346);
	      obstacle_indices.add(348);
	      obstacle_indices.add(353);
	      obstacle_indices.add(356);
	      
	      obstacle_indices.add(362);
	      obstacle_indices.add(364);
	      obstacle_indices.add(365);
	      obstacle_indices.add(366);
	      obstacle_indices.add(368);
	      obstacle_indices.add(373);
	      obstacle_indices.add(376);
	      obstacle_indices.add(378);
	      obstacle_indices.add(379);
	      
	      obstacle_indices.add(382);
	      obstacle_indices.add(384);
	      obstacle_indices.add(385);
	      obstacle_indices.add(386);
	      obstacle_indices.add(388);
	      obstacle_indices.add(393);
	      obstacle_indices.add(396);
	      obstacle_indices.add(398);
	      obstacle_indices.add(399);
	      
	      small = new SmallGraph(obstacle_indices);
    	  djkshitra = new Dijkstra(small);
          dj = new Astar(small);
          
//          path = dijkstra.execute(small.getVertexes().get(0),small.getVertexes().get(397));
//          path1 = dj.execute(small.getVertexes().get(0),small.getVertexes().get(397));

//          for (Node vertex : path) {
//              System.out.println(vertex.getId());
//          }
//      
          
                
//          System.out.println( dijkstra.fill+" "+dijkstra.mem);
      
      
//          System.out.println( dj.fill+" "+dj.mem);
}

    public void draw()
    {
    	  background(100);
    	  
    	  r.displayObstacles();
    	  this.fill(255,255,255);
    	  
    	  
    	  if(arrive_flag ==1){
//    		  println(path.size());  
    		  for (Node vertex : path) {
//            	  System.out.println(vertex.getX());
            	  this.rect(vertex.getX(), vertex.getY(), 10, 10);
          	  }

    		  if(pointer_at < path.size())
    		  {
    			  PVector immediate_target = new PVector((float)path.get(pointer_at).getX(),(float)path.get(pointer_at).getY());
     	    	  arrive_flag = player1.arrive(immediate_target);
   
     	    	 if(path.get(path.size()-1).getId() == get_player_index(player1.position.x, player1.position.y))
     	    	 {
//     	    		 println("Common");
     	    		 player1.acceleration = new PVector(0,0);
     	    		 player1.velocity = new PVector(0,0);
     	    		 arrive_flag = 0;
     	    		 target_index = -1;
     	    		 source_index = -1;
     	    	 }
     	    	 if( path.get(pointer_at).getId()==get_player_index(player1.position.x, player1.position.y))
    	    	  {
    	    		  pointer_at++;
    	    		  arrive_flag =1;
     	    	  }

    		  }
    		  
 	    	  
 	    	  
// 	    	  else
// 	    	  {
// 	    		  arrive_flag =0;
// 	    	  }
 	    	  
// 	    	 println(arrive_flag); 
// 	    	 println(get_player_index(player1.position.x, player1.position.y));
// 	    	 println("OKay " +path.get(pointer_at).getId());
    	  }
    	  
 	      player1.update(1);
 	      player1.display(frameCount);
 	      
    }
    
    int pointer_at = -1;
    int arrive_flag = 0; 
    int target_index = -1;
    int source_index = -1;
    PVector target = new PVector(0,0);
    int mouse_clicked = 0;
    public void mousePressed() 
    {
    	// get mouse x and y coordinate, save in target and call arrive
    	target.x = mouseX;
    	target.y = mouseY;
    	source_index = ((int)player1.position.y/40)*20+((int)player1.position.x/40);
    	target_index = (mouseY/40)*20+(mouseX/40);
    	
    	if(!obstacle_indices.contains(target_index))
    	{
        	path = djkshitra.execute(small.getVertexes().get(source_index),small.getVertexes().get(target_index));
//        	path1 = dj.execute(small.getVertexes().get(source_index),small.getVertexes().get(target_index));
     
        	int dij_fill = djkshitra.openList.size()+djkshitra.closedList.size();
            int astar_fill = dj.openList.size()+dj.closedList.size();
            System.out.println( dij_fill+" "+djkshitra.mem);
            System.out.println( astar_fill+" "+dj.mem);
//            System.out.println( dij_totalTime+" "+astar_totalTime);	
        	
        	arrive_flag = 1;
        	pointer_at = 1;
    	}
    }
    
    public int get_player_index(float x, float y)
    {
    	return ((int)y/40)*20+((int)x/40);
    }
}


