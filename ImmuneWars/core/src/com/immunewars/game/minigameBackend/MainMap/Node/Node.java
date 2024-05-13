package com.immunewars.game.minigameBackend.MainMap.Node;

import java.awt.Font;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;




public class Node extends Actor {
    private NodeData nodeData;
    private ShapeRenderer shapeRenderer;
    private float radius;
    Node curr;

    public Node(ShapeRenderer shapeRenderer, NodeData nodeData) {
        curr = this;
        System.out.println("constructing node");
        this.shapeRenderer = shapeRenderer;
        this.nodeData = nodeData.getNode();
        radius = nodeData.getWeight();
        setWidth(2 * radius);
        setHeight(2 * radius);
        setX(nodeData.getX());
        setY(nodeData.getY());

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("click!!!!!!!!!");
                System.out.println(curr.getNodeData().toString());
            }
        });
        System.out.println("screen node constructed");
    }
    @Override
    public void draw(Batch batch, float parentAlpha) 
    {
        batch.end();
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(getX(),getY(), radius);
        shapeRenderer.end();
        batch.begin();
    }

    public NodeData getNodeData() {
        return nodeData;
    }

    public void setNodeData(NodeData nodeData) {
        this.nodeData = nodeData;
    }

    
}