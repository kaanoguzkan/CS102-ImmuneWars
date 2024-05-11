package com.immunewars.game.screens.MainMap.Edge;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.immunewars.game.screens.MainMap.Node.NodeActor;
import com.immunewars.game.screens.MainMap.Node.Node;

public class EdgeActor extends Actor 
{
    private Edge edgeData;
    private ShapeRenderer shapeRenderer;
    private Color lineColor = Color.PURPLE; // Default color

    public EdgeActor(ShapeRenderer shapeRenderer, Edge edgeData) {
        this.shapeRenderer = shapeRenderer;
        this.edgeData = edgeData;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end(); // End SpriteBatch
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line); 
        shapeRenderer.setColor(lineColor);

        NodeActor node1 = findNodeActor(edgeData.getStart());
        NodeActor node2 = findNodeActor(edgeData.getEnd());

        if (node1 != null && node2 != null) 
        {
            shapeRenderer.line(node1.getX(), node1.getY() , node2.getX(), node2.getY() );
        } 

        shapeRenderer.end();
        batch.begin(); // Restart SpriteBatch
    }

    private NodeActor findNodeActor(Node node) {
        for (Actor actor : getStage().getActors()) {
            if (actor instanceof NodeActor && ((NodeActor) actor).getNodeData() == node) {
                return (NodeActor) actor;
            }
        }
        return null;
    }

    // Add getters and setters for lineColor if needed
    
}