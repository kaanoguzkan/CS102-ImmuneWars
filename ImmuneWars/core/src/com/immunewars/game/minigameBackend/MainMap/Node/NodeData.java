package com.immunewars.game.minigameBackend.MainMap.Node;

import java.util.ArrayList;

import com.immunewars.game.screens.TheMapScreen;

public class NodeData 
{
    private int id; 
    private int x;
    private int y;
    private String name;
    private int type;
    private ArrayList<NodeData> neighbors;
    private int weight;
    TheMapScreen screen;

    public NodeData(int option, int x, int y, String name, int type, int weight, TheMapScreen screen)
    {
        this.screen = screen;
        this.id = option;
        this.x = x;
        this.y = y;
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public TheMapScreen getScreen(){return screen;}

    public NodeData getNode()
    {
        return this;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public int getX() 
    {
        return x;
    }

    public void setX(int x) 
    {
        this.x = x;
    }

    public int getY() 
    {
        return y;
    }

    public void setY(int y) 
    {
        this.y = y;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getType() 
    {
        return type;
    }

    public void setType(int type) 
    {
        this.type = type;
    }

    public ArrayList<NodeData> getNeighbors() 
    {
        return neighbors;
    }

    public void setNeighbors(ArrayList<NodeData> neighbors) 
    {
        this.neighbors = neighbors;
    }

    public int getWeight() 
    {
        return weight;
    }

    public void setWeight(int weight) 
    {
        this.weight = weight;
    }

    public void addNeighbor(NodeData neighbor)
    {
        neighbors.add(neighbor);
    }

    public void removeNeighbor(NodeData neighbor)
    {
        neighbors.remove(neighbor);
    }

    public void clearNeighbors()
    {
        neighbors.clear();
    }

    public boolean isNeighbor(NodeData neighbor)
    {
        return neighbors.contains(neighbor);
    }

    public int getNeighborCount()
    {
        return neighbors.size();
    }

    public boolean equals(NodeData node)
    {
        return this.id == node.id;
    }

    public String toString()
    {
        return name;
    }
}
