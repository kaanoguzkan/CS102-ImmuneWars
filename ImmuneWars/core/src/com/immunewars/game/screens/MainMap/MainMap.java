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
    Node eyesNode = new Node(1, 0, 0, "Eyes", 0, new ArrayList<Node>(), 2);
    Node mouthNode = new Node(2, 0, 0, "Mouth", 0, new ArrayList<Node>(), 4);
    Node noseNode = new Node(3, 0, 0, "Nose", 0, new ArrayList<Node>(), 3);
    Node hearthNode = new Node(4, 0, 0, "Hearth", 0, new ArrayList<Node>(), 9);
    Node lungsNode = new Node(5, 0, 0, "Lungs", 0, new ArrayList<Node>(), 9);
    Node stomachNode = new Node(6, 0, 0, "Stomach", 0, new ArrayList<Node>(), 3);
    Node liverNode = new Node(7, 0, 0, "Liver", 0, new ArrayList<Node>(), 6);
    Node kidneysNode = new Node(8, 0, 0, "Kidneys", 0, new ArrayList<Node>(), 6);
    Node intestinesNode = new Node(9, 0, 0, "Intestines", 0, new ArrayList<Node>(), 3);
    Node armNode = new Node(10, 0, 0, "Arm", 0, new ArrayList<Node>(), 3);
    Node legNode = new Node(11, 0, 0, "Leg", 0, new ArrayList<Node>(), 3);
    Node footNode = new Node(12, 0, 0, "Foot", 0, new ArrayList<Node>(), 2);
    Node handNode = new Node(13, 0, 0, "Hand", 0, new ArrayList<Node>(), 4);

    Edge brainEyesEdge = new Edge(brainNode, eyesNode);
    Edge brainMouthEdge = new Edge(brainNode, mouthNode);
    Edge brainNoseEdge = new Edge(brainNode, noseNode);
    Edge brainHearthEdge = new Edge(brainNode, hearthNode);
    Edge hearthLungsEdge = new Edge(hearthNode, lungsNode);
    Edge hearthStomachEdge = new Edge(hearthNode, stomachNode);
    Edge mouthLungEdge = new Edge(mouthNode, lungsNode);
    Edge mouthEyesEdge = new Edge(mouthNode, eyesNode);
    Edge mouthNoseEdge = new Edge(mouthNode, noseNode);
    Edge stomachIntestinesEdge = new Edge(stomachNode, intestinesNode);
    Edge stomachLiverEdge = new Edge(stomachNode, liverNode);
    Edge stomachKidneysEdge = new Edge(stomachNode, kidneysNode);
    Edge intestinesLiverEdge = new Edge(intestinesNode, liverNode);
    Edge intestinesKidneysEdge = new Edge(intestinesNode, kidneysNode);
    Edge noseLungEdge = new Edge(noseNode, lungsNode);
    Edge mouthStomachEdge = new Edge(mouthNode, stomachNode);
    Edge eyesHearthEdge = new Edge(eyesNode, hearthNode);
    Edge eyesArmEdge = new Edge(eyesNode, armNode);
    Edge armHanEdge = new Edge(armNode, handNode);
    Edge hearthArmEdge = new Edge(hearthNode, armNode);
    Edge kidneyLEdge = new Edge(kidneysNode, legNode);
    Edge legFootEdge = new Edge(legNode, footNode);
    Edge intestinesLegEdge = new Edge(intestinesNode, legNode);
    



    public MainMap() 
    {
        shapeRenderer = new ShapeRenderer();
        
        
    }

   
}

