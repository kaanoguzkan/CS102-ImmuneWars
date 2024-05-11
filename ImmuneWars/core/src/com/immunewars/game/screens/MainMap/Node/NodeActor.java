package com.immunewars.game.screens.MainMap.Node;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;




public class NodeActor extends Actor {
    private Node nodeData;
    private ShapeRenderer shapeRenderer;
    private float radius = nodeData.getWeight(); // Set your desired radius

    public NodeActor(ShapeRenderer shapeRenderer, Node nodeData) {
        this.shapeRenderer = shapeRenderer;
        this.nodeData = nodeData.getNode();
        setWidth(2 * radius);
        setHeight(2 * radius);
        setPosition(getOriginX(), getOriginY());
        // input listener for touch events
        addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                // handle touch events here
                 
                return false;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) 
    {
        batch.end(); // End the SpriteBatch 
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLACK); // Or any color you prefer
        shapeRenderer.circle(getX() + radius, getY() + radius, radius);
        shapeRenderer.end();
        batch.begin(); // Restart the SpriteBatch
    }

    public Node getNodeData() {
        return nodeData;
    }

    public void setNodeData(Node nodeData) {
        this.nodeData = nodeData;
    }

    
}