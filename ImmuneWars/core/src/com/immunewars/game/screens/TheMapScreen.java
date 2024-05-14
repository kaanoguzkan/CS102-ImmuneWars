package com.immunewars.game.screens;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.StyledEditorKit.ForegroundAction;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    private static ImmuneWars ImmuneWars;
    private ShapeRenderer shapeRenderer;
    private Stage stage;
    private Image background;
    private Random random = new Random();
    int i = 2;
    private Sprite backgroundSprite;
    private SpriteBatch spriteBatch = new SpriteBatch();
    
    ArrayList<NodeData> nodes = new ArrayList<NodeData>();
    ArrayList<EdgeData> edges = new ArrayList<EdgeData>();
    ArrayList<NodeData> enemyNodes = new ArrayList<NodeData>();
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

        brainNode.setNeighbors(new ArrayList<NodeData>(){{add(mouthNode); add(noseNode); add(heartNode);}});
        mouthNode.setNeighbors(new ArrayList<NodeData>(){{add(lungsNode); add(noseNode); add(stomachNode); add(brainNode);}});
        noseNode.setNeighbors(new ArrayList<NodeData>(){{add(lungsNode); add(mouthNode); add(brainNode);}});
        heartNode.setNeighbors(new ArrayList<NodeData>(){{add(lungsNode); add(stomachNode); add(brainNode); add(armNode);}});
        lungsNode.setNeighbors(new ArrayList<NodeData>(){{add(heartNode); add(stomachNode); add(mouthNode); add(noseNode);}});
        stomachNode.setNeighbors(new ArrayList<NodeData>(){{add(lungsNode); add(heartNode); add(mouthNode); add(intestinesNode);}});
        liverNode.setNeighbors(new ArrayList<NodeData>(){{add(stomachNode); add(kidneysNode);}});
        kidneysNode.setNeighbors(new ArrayList<NodeData>(){{add(stomachNode); add(liverNode); add(intestinesNode); add(legNode);}});
        intestinesNode.setNeighbors(new ArrayList<NodeData>(){{add(stomachNode); add(kidneysNode); add(liverNode); add(legNode);}});
        armNode.setNeighbors(new ArrayList<NodeData>(){{add(heartNode); add(handNode);}});
        legNode.setNeighbors(new ArrayList<NodeData>(){{add(kidneysNode); add(intestinesNode); add(footNode);}});
        footNode.setNeighbors(new ArrayList<NodeData>(){{add(legNode);}});
        handNode.setNeighbors(new ArrayList<NodeData>(){{add(armNode);}});

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
        backgroundSprite = new Sprite(new Texture("mapBackground.png"));
        backgroundSprite.setBounds(0, 0, 1280, 800);
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

    public void renderBackground(){
        backgroundSprite.draw(spriteBatch);
    }

    @Override
    public void render(float delta) {
        spriteBatch.begin();
        renderBackground();
        spriteBatch.end();
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
        
        NodeData targetNode = pickTargetNode();
        System.out.println("enemy attacks: " + targetNode.getName());

        randomMinigameTrigger();

        endGame();
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

        enemyNodes.add(randomNode1);
        enemyNodes.add(randomNode2);

        System.out.println("enemy nodes are: " + randomNode1.getName() + " and " + randomNode2.getName());
    }


    public NodeData pickTargetNode()
    {
        // picks a target node for the enemy to attack
        ArrayList<NodeData> availableNodess = new ArrayList<NodeData>();
        // nested for loop for finding available nodes of the all enemy nodes
        for (NodeData enemyNode : enemyNodes) 
        {
            for (NodeData neighbor : enemyNode.getNeighbors()) 
            {
                if (neighbor.getId() != 1) 
                {
                    availableNodess.add(neighbor);
                }
            }
        }
        
        int i = (int) ((Math.random() * (availableNodess.size()))-1);

        return availableNodess.get(i);
    }


    public void randomMinigameTrigger()
    {
        // triggers a random minigame

        Double a = Math.random();

        if ((0 < a) && (a < 0.2))
        {
            TicTacToeScreen ticTacToeScreen = new TicTacToeScreen(ImmuneWars);
        }
        else if ((0.2 < a) && (a < 0.4))
        {
            SpaceInvadersScreen spaceInvadersScreen = new SpaceInvadersScreen(ImmuneWars);
        }
        else if ((0.4 < a) && (a < 0.6))
        {
            SnakeScreen snakeScreen = new SnakeScreen(ImmuneWars);
        }
        else if ((0.6 < a) && (a < 0.8))
        {
            ImageMatchingScreen imageMatchingScreen = new ImageMatchingScreen(ImmuneWars, 16);
        }
        else if ((0.8 < a) && (a < 1))
        {
            SpaceInvadersScreen spaceInvadersScreen = new SpaceInvadersScreen(ImmuneWars);
        }
    }

    public void endGame()
    {
        ArrayList<NodeData> nodesss = getNodes();

        if((nodesss.get(0).getId() == 1) && (nodesss.get(3).getId() == 1))
        {
            System.out.println("enemy wins");
        }
        else if(enemyNodes.isEmpty())
        {
            System.out.println("player wins");
        }
        else
        {
            System.out.println("game continues");
        }
    }



}


