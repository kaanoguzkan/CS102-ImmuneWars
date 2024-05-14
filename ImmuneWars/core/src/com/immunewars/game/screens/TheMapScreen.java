package com.immunewars.game.screens;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.StyledEditorKit.ForegroundAction;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.minigameBackend.MainMap.Edge.Edge;
import com.immunewars.game.minigameBackend.MainMap.Edge.EdgeData;
import com.immunewars.game.minigameBackend.MainMap.Node.Node;
import com.immunewars.game.minigameBackend.MainMap.Node.NodeData;

public class TheMapScreen implements Screen 
{
    private ShapeRenderer shapeRenderer;
    private Stage stage;
    private Image background;
    private Random random = new Random();
    int i = 2;
    
    ArrayList<NodeData> nodes = new ArrayList<NodeData>();
    ArrayList<EdgeData> edges = new ArrayList<EdgeData>();
    NodeData brainNode = new NodeData(0,80 , 390, "Brain", 0, 70 / i);
    NodeData mouthNode = new NodeData(2, 170, 450, "Mouth", 0, 35 / i);
    NodeData noseNode = new NodeData(3, 150,510 , "Nose", 0, 30 / i);
    NodeData heartNode = new NodeData(4, 360, 480, "Heart", 0, 50 / i);
    NodeData lungsNode = new NodeData(5, 300, 450, "Lungs", 0, 50 / i);
    NodeData stomachNode = new NodeData(6, 570, 480, "Stomach", 0, 50 / i);
    NodeData liverNode = new NodeData(7, 500, 400, "Liver", 0, 40 / i);
    NodeData kidneysNode = new NodeData(8, 600, 350, "Kidneys", 0, 60 / i);
    NodeData intestinesNode = new NodeData(9, 650, 460, "Intestines", 0, 30 / i);
    NodeData armNode = new NodeData(10, 500, 600, "Arm", 0, 30 / i);
    NodeData legNode = new NodeData(11, 850, 400, "Leg", 0, 30 / i);
    NodeData footNode = new NodeData(12, 1000, 400, "Foot", 0, 20 / i);
    NodeData handNode = new NodeData(13,600 , 600, "Hand", 0, 30 / i);

    EdgeData brainMouthEdge = new EdgeData(brainNode, mouthNode);
    EdgeData brainNoseEdge = new EdgeData(brainNode, noseNode);
    EdgeData brainHeartEdge = new EdgeData(brainNode, heartNode);
    EdgeData heartLungsEdge = new EdgeData(heartNode, lungsNode);
    EdgeData heartStomachEdge = new EdgeData(heartNode, stomachNode);
    EdgeData mouthLungEdge = new EdgeData(mouthNode, lungsNode);
    EdgeData mouthNoseEdge = new EdgeData(mouthNode, noseNode);
    EdgeData stomachIntestinesEdge = new EdgeData(stomachNode, intestinesNode);
    EdgeData stomachLiverEdge = new EdgeData(stomachNode, liverNode);
    EdgeData stomachKidneysEdge = new EdgeData(stomachNode, kidneysNode);
    EdgeData intestinesLiverEdge = new EdgeData(intestinesNode, liverNode);
    EdgeData intestinesKidneysEdge = new EdgeData(intestinesNode, kidneysNode);
    EdgeData noseLungEdge = new EdgeData(noseNode, lungsNode);
    EdgeData mouthStomachEdge = new EdgeData(mouthNode, stomachNode);
    EdgeData armHandEdge = new EdgeData(armNode, handNode);
    EdgeData heartArmEdge = new EdgeData(heartNode, armNode);
    EdgeData kidneyLEdge = new EdgeData(kidneysNode, legNode);
    EdgeData legFootEdge = new EdgeData(legNode, footNode);
    EdgeData intestinesLegEdge = new EdgeData(intestinesNode, legNode);

    

    public TheMapScreen(ImmuneWars game) 
    {
        nodes.add(brainNode);
        nodes.add(mouthNode);
        nodes.add(noseNode);
        nodes.add(heartNode);
        nodes.add(lungsNode);
        nodes.add(stomachNode);
        nodes.add(liverNode);
        nodes.add(kidneysNode);
        nodes.add(intestinesNode);
        nodes.add(armNode);
        nodes.add(legNode);
        nodes.add(footNode);
        nodes.add(handNode);

        edges.add(brainMouthEdge);
        edges.add(brainNoseEdge);
        edges.add(brainHeartEdge);
        edges.add(heartLungsEdge);
        edges.add(heartStomachEdge);
        edges.add(mouthLungEdge);
        edges.add(mouthNoseEdge);
        edges.add(stomachIntestinesEdge);
        edges.add(stomachLiverEdge);
        edges.add(stomachKidneysEdge);
        edges.add(intestinesLiverEdge);
        edges.add(intestinesKidneysEdge);
        edges.add(noseLungEdge);
        edges.add(mouthStomachEdge);
        edges.add(armHandEdge);
        edges.add(heartArmEdge);
        edges.add(kidneyLEdge);
        edges.add(legFootEdge);
        edges.add(intestinesLegEdge);

        

        stage = new Stage();
        shapeRenderer = new ShapeRenderer();

        giveEnemyTwoNodes();
        paintMap();
        System.out.println("no sorun.");
        render(0);
        System.out.println("constructed.");
        Gdx.input.setInputProcessor(stage);
    }


    // method that paints this nodes and edges to the map 
    public void paintMap()
    {
        // paint background
        Texture a = new Texture("mapBackground.png");
        background = new Image(a);
        background.setSize(1280, 800);
        stage.addActor(background);
        

        // paint nodes
        Node nodeActor;
        for (NodeData node : nodes) 
        {   
            try {
                nodeActor = new Node(shapeRenderer, node);
                stage.addActor(nodeActor);
            } catch (Exception e) {
                System.out.println("failed node!");
                e.printStackTrace();
            }
        }
        System.out.println("nodes painted");
        for(EdgeData edge : edges)
        {
            Edge edgeActor = new Edge(shapeRenderer, edge);
            stage.addActor(edgeActor);
            System.out.println("successul edge!");
        }
    }


    @Override
    public void show() {
    }


    @Override
    public void render(float delta) {
        // renders the stage

        stage.act();
     
        stage.draw();


        
    }

    public ArrayList<NodeData> getNodes() {
        return nodes;
    }

    @Override
    public void resize(int width, int height) {
        
    }


    @Override
    public void pause() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pause'");
    }


    @Override
    public void resume() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resume'");
    }


    @Override
    public void hide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hide'");
    }


    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }
    
    public void enemyChooseAndAttack()
    {
        giveEnemyTwoNodes();

        
        
    }


    public void giveEnemyTwoNodes()
    {
        ArrayList<NodeData> avaiableNodes = new ArrayList<NodeData>();
        ArrayList<NodeData> nodess = getNodes();
        
        for (int i = 0; i < nodess.size(); i++) 
        {
            NodeData node = nodes.get(i);
            if (node.getId() != 0 && !node.getName().equals("Brain") && !node.getName().equals("Heart")) {
                avaiableNodes.add(node);
            }
        }

        int randomNode1Index = random.nextInt(avaiableNodes.size());
        int randomNode2Index = random.nextInt(avaiableNodes.size());

        NodeData randomNode1 = avaiableNodes.get(randomNode1Index);
        NodeData randomNode2 = avaiableNodes.get(randomNode2Index);

        randomNode1.setId(1);
        randomNode2.setId(1);

        System.out.println("enemy nodes are: " + randomNode1.getName() + " and " + randomNode2.getName());
    }



}


