package com.immunewars.game.screens.MainMap.Edge;

import com.immunewars.game.screens.MainMap.Node.Node;

public class Edge 
{
    private Node start;
    private Node end;
    
    public Edge(Node start, Node end)
    {
        this.start = start;
        this.end = end;
    }

    public Node getStart() 
    {
        return start;
    }

    public void setStart(Node start) 
    {
        this.start = start;
    }

    public Node getEnd() 
    {
        return end;
    }

    public void setEnd(Node end) 
    {
        this.end = end;
    }

    

}
