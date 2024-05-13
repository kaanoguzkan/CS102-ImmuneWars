package com.immunewars.game.minigameBackend.MainMap.Edge;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.immunewars.game.minigameBackend.MainMap.Node.Node;
import com.immunewars.game.minigameBackend.MainMap.Node.NodeData;

public class Edge extends Actor 
{
    private EdgeData edgeData;
    private ShapeRenderer shapeRenderer;
    private Color lineColor = Color.PURPLE; // Default color

    public Edge(ShapeRenderer shapeRenderer, EdgeData edgeData) {
        this.shapeRenderer = shapeRenderer;
        this.edgeData = edgeData;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end(); // End SpriteBatch
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line); 
        shapeRenderer.setColor(lineColor);

        Node node1 = findNodeActor(edgeData.getStart());
        Node node2 = findNodeActor(edgeData.getEnd());

        if (node1 != null && node2 != null) 
        {
            shapeRenderer.line(node1.getX() + (node1.getWidth()/2), node1.getY() + (node1.getWidth()/2),  node2.getX() + (node2.getWidth()/2), node2.getY() + (node2.getWidth()/2) );
        } 

        shapeRenderer.end();
        batch.begin(); // Restart SpriteBatch
    }

    private Node findNodeActor(NodeData node) {
        for (Actor actor : getStage().getActors()) {
            if (actor instanceof Node && ((Node) actor).getNodeData() == node) {
                return (Node) actor;
            }
        }
        return null;
    }

    // Add getters and setters for lineColor if needed
    
}