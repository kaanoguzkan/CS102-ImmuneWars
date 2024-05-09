package com.immunewars.game.screens.MainMap;

import java.util.ArrayList;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.immunewars.game.screens.MainMap.Node.Node;
import com.immunewars.game.screens.MainMap.Edge.Edge;

public class MainMap implements Screen 
{
    private ShapeRenderer shapeRenderer;
    ArrayList<Node> nodes = new ArrayList<Node>();
    ArrayList<Edge> edges = new ArrayList<Edge>();
    Node brainNode = new Node(0, 0, 0, "Brain", 0, new ArrayList<Node>(), 10);
    Node eyesNode = new Node(1, 0, 0, "Eyes", 0, new ArrayList<Node>(), 10);
    Node mouthNode = new Node(2, 0, 0, "Mouth", 0, new ArrayList<Node>(), 10);
    Node noseNode = new Node(3, 0, 0, "Nose", 0, new ArrayList<Node>(), 10);
    Node hearthNode = new Node(4, 0, 0, "Hearth", 0, new ArrayList<Node>(), 10);
    Node lungsNode = new Node(5, 0, 0, "Lungs", 0, new ArrayList<Node>(), 10);
    Node stomachNode = new Node(6, 0, 0, "Stomach", 0, new ArrayList<Node>(), 10);
    Node liverNode = new Node(7, 0, 0, "Liver", 0, new ArrayList<Node>(), 10);
    Node kidneysNode = new Node(8, 0, 0, "Kidneys", 0, new ArrayList<Node>(), 10);
    Node intestinesNode = new Node(9, 0, 0, "Intestines", 0, new ArrayList<Node>(), 10);
    
    public MainMap() 
    {
        shapeRenderer = new ShapeRenderer();
        
        
    }

   
}

