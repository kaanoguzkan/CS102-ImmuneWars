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
import com.immunewars.game.screens.TheMapScreen;




public class Node extends Actor {
    private NodeData nodeData;
    private ShapeRenderer shapeRenderer;
    private float radius;
    Node curr;
    TheMapScreen screen;

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
        this.screen = nodeData.getScreen();

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("click!!!!!!!!!");
                System.out.println(curr.getNodeData().toString());
                screen.nodePressed = true;
            }
        });
        System.out.println("screen node constructed");
    }
    @Override
    public void draw(Batch batch, float parentAlpha) 
    {
        if (nodeData.getId() == 0)
        {
            shapeRenderer.begin(ShapeType.Filled);
            shapeRenderer.setColor(Color.GREEN);
            shapeRenderer.circle(getX() + radius, getY() + radius, radius);
            shapeRenderer.end();
        }
        else if (nodeData.getId() == 1)
        {
            shapeRenderer.begin(ShapeType.Filled);
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.circle(getX() + radius, getY() + radius, radius);
            shapeRenderer.end();
        }
        else 
        {
            shapeRenderer.begin(ShapeType.Filled);
            shapeRenderer.setColor(Color.GREEN);
            shapeRenderer.circle(getX() + radius, getY() + radius, radius);
            shapeRenderer.end();
        }
    }

    public NodeData getNodeData() {
        return nodeData;
    }

    public void setNodeData(NodeData nodeData) {
        this.nodeData = nodeData;
    }

    
}