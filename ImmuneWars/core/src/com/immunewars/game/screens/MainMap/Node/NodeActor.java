package com.immunewars.game.screens.MainMap.Node;

import java.awt.Font;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;




public class NodeActor extends Actor {
    private Node nodeData;
    private ShapeRenderer shapeRenderer;
    private float radius; // Set your desired radius

    public NodeActor(ShapeRenderer shapeRenderer, Node nodeData) {
        System.out.println("trying to construct node");
        this.shapeRenderer = shapeRenderer;
        this.nodeData = nodeData.getNode();
        radius = nodeData.getWeight();
        setWidth(2 * radius);
        setHeight(2 * radius);
        setX(nodeData.getX());
        setY(nodeData.getY());
        // input listener for touch events
        System.out.println("adding listeeer");
        addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                // handle touch events here
                 
                return false;
            }
        });
        System.out.println("screen node constructed");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) 
    {
        batch.end(); // End the SpriteBatch 
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.WHITE); // Or any color you prefer
        shapeRenderer.circle(getX(),getY(), radius);
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