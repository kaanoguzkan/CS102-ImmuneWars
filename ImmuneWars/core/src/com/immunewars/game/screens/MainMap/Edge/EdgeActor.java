package com.immunewars.game.screens.MainMap.Edge;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.immunewars.game.screens.MainMap.Node.NodeActor;

public class EdgeActor extends Actor 
{
    private NodeActor nodeActor1, nodeActor2;

    public EdgeActor(NodeActor nodeActor1, NodeActor nodeActor2)
    {
        this.nodeActor1 = nodeActor1;
        this.nodeActor2 = nodeActor2;
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLACK); // Set desired color
        shapeRenderer.line(
            nodeActor1.getX() + nodeActor1.getWidth() / 2, 
            nodeActor1.getY() + nodeActor1.getHeight() / 2,
            nodeActor2.getX() + nodeActor2.getWidth() / 2,
            nodeActor2.getY() + nodeActor2.getHeight() / 2
        );
        shapeRenderer.end();
    }

    public NodeActor getNodeActor1() 
    {
        return nodeActor1;
    }

    public void setNodeActor1(NodeActor nodeActor1) 
    {
        this.nodeActor1 = nodeActor1;
    }

    public NodeActor getNodeActor2() 
    {
        return nodeActor2;
    }

    public void setNodeActor2(NodeActor nodeActor2) 
    {
        this.nodeActor2 = nodeActor2;
    }

    
}
