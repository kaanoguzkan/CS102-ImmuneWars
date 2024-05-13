package com.immunewars.game.minigameBackend.MainMap.Edge;

import com.immunewars.game.minigameBackend.MainMap.Node.NodeData;

public class EdgeData 
{
    private NodeData start;
    private NodeData end;
    
    public EdgeData(NodeData start, NodeData end)
    {
        this.start = start;
        this.end = end;
    }

    public NodeData getStart() 
    {
        return start;
    }

    public void setStart(NodeData start) 
    {
        this.start = start;
    }

    public NodeData getEnd() 
    {
        return end;
    }

    public void setEnd(NodeData end) 
    {
        this.end = end;
    }

    

}
