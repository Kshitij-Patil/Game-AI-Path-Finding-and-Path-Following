package GraphGeneration;

import processing.core.PApplet;

import processing.core.PApplet;
import processing.core.PVector;

public class Room {
	PApplet parent;
	
	Room(PApplet p)
	{
		parent = p;
	}
	
	void displayObstacles() {
		  
	    parent.fill(0,0,0);
	    
	    for(int i = 0; i < parent.width; i+=40)
	    {
	    	parent.rect(i,0 ,2, parent.height);
	    }
	    for(int i = 0; i < parent.height; i+=40)
	    {
	    	parent.rect(0,i ,parent.width, 2);
	    }
	    
	    parent.rect(80, 0, 40, 280);
	    parent.rect(80, 520, 40, 280);
	    
	    parent.rect(280, 0, 40, 320);
	    parent.rect(320, 400, 40, 400);
	    
	    parent.rect(560, 0, 40, 240);
	    parent.rect(320, 400, 160, 40);
	    
	    parent.rect(520, 400, 40, 400);
	    parent.rect(640, 600, 40, 200);
	    
	    parent.rect(640, 400, 40, 120);
	    parent.rect(640, 400, 160, 40);
	    
	    parent.rect(640, 0, 40, 320);
	    parent.rect(760, 0, 40, 160);
	    parent.rect(760, 240, 40, 120);
	    parent.rect(640, 0, 40, 320);
	    
	    parent.rect(720, 720, 80, 80);
	    parent.rect(280, 320, 280, 40);
	    
	    parent.rect(360, 80, 160, 120);
	    
	    parent.rect(160, 680, 120, 120);

	    
	  }
	
}


