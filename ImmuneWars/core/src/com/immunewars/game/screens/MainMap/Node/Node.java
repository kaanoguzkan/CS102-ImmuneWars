package com.immunewars.game.screens.MainMap.Node;

import java.util.ArrayList;

public class Node 
{
    private int id; 
    private int x;
    private int y;
    private String name;
    private int type;
    private ArrayList<Node> neighbors;
    private int weight;

    public Node(int id, int x, int y, String name, int type, ArrayList<Node> neighbors, int weight)
    {
        this.id = id;
        this.x = x;
        this.y = y;
        this.name = name;
        this.type = type;
        this.neighbors = neighbors;
        this.weight = weight;
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

    public ArrayList<Node> getNeighbors() 
    {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Node> neighbors) 
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

    public void addNeighbor(Node neighbor)
    {
        neighbors.add(neighbor);
    }

    public void removeNeighbor(Node neighbor)
    {
        neighbors.remove(neighbor);
    }

    public void clearNeighbors()
    {
        neighbors.clear();
    }

    public boolean isNeighbor(Node neighbor)
    {
        return neighbors.contains(neighbor);
    }

    public int getNeighborCount()
    {
        return neighbors.size();
    }

    public boolean equals(Node node)
    {
        return this.id == node.id;
    }

    public String toString()
    {
        return name;
    }


    

}
