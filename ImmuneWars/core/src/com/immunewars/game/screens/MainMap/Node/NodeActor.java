package com.immunewars.game.screens.MainMap.Node;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class NodeActor extends Actor
{
    private Texture texture;
    private Node nodeData;

    public NodeActor(Texture texture, Node nodeData)
    {
        this.texture = texture;
        this.nodeData = nodeData;

        setWidth(texture.getWidth());
        setHeight(texture.getHeight());

        setPosition(getOriginX(), getOriginY());

        addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                // pops up a dialog box with the node's information 
                 
                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        batch.draw(texture, getX(), getY());
    }

    public Node getNodeData()
    {
        return nodeData;
    }


}
