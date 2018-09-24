CSC 584/484 Spring 17 Homework 2: Pathﬁnding and Path Following 

Overview Your task for this assignment is to explore some of the pathﬁnding and path following algorithms we discussed in class. Working alone and using Processing (http://www.processing.org/), you will implement the algorithms described below and analyze your results in a 3–5 page writeup. Note that for some of these tasks you will be integrating your new solutions with your code from Assignment 1.

RUNNING THE CODE :  
For running the code, import the HW2_PathFollowing project and run the ArriveBehavior.java file
Click on any non-black tile for the character to move towards it. White rectangles denote the path to be followed.
Clicking on black tile will not show any movement as it is an obstacle.

DIJKSHTRA's ALGORITHM AND A*
Your next task is to implement both Dijkstra’s Algorithm and the A* Algorithm. Hint: get them both working on your ﬁrst graph before you begin testing on your second graph. For A*, pick a simple heuristic like a constant guess or some form of Manhattan Distance. If your large graph doesn’t have any meaningful distance or way to compute a heuristic, use a random one, constant guess, or the cluster heuristic discussed in class. What you choose isn’t all that important for this section of the assignment. Compare and contrast the performance of the two algorithms on bot hof your graphs in terms of runtime, number of nodes visited, and memory used. What else can you say about these algorithms? What effects does the graph structure have on performance? You are expected to present data in your writeup to support your analysis.

Heuristics(10pts)
Looking solely at the A* algorithm, design and implement at least two heuristics for your ﬁrst graph. The heuristic you used in the previous portion of the assignment can count as one of these two. A few options are random, hand-authored, Manhattan distance, a constant guess, or euclidean distance. These are not the only possibilities, be creative. These heuristics don’t need to work for your second, larger graph.

<p align="left">
<img src="https://raw.githubusercontent.com/Kshitij-Patil/Game-AI-Path-Finding-and-Path-Following/master/images/pathsearchandfollow.png" width="480" height="360" border="10">
 </p>
