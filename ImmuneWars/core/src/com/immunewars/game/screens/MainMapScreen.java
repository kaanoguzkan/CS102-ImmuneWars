package com.immunewars.game.screens;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.immunewars.game.screens.MainMap.Node.Node;
import com.immunewars.game.GameConfig;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.screens.MainMap.Edge.Edge;
import com.immunewars.game.screens.MainMap.Node.NodeActor;
import com.immunewars.game.screens.MainMap.Edge.EdgeActor;

public class MainMapScreen implements Screen {
    ImmuneWars game;
    int cameraX = GameConfig.resolutionX; 
	int cameraY = GameConfig.resolutionY;
	OrthographicCamera camera;
	Viewport viewport;
	SpriteBatch batch;
    ShapeRenderer shapeRenderer;
    Stage stage;
    Image background;
    MainMapScreen screen;
    
    ArrayList<Node> nodes = new ArrayList<Node>();
    ArrayList<Edge> edges = new ArrayList<Edge>();
    Node brainNode = new Node(0,150 , 728, "Brain", 0, 70);
    Node eyesNode = new Node(1, 200, 650, "Eyes", 0, 20);
    Node mouthNode = new Node(2, 300, 728, "Mouth", 0, 40);
    Node noseNode = new Node(3, 250,728 , "Nose", 0, 30);
    Node hearthNode = new Node(4, 600, 400, "Hearth", 0, 90);
    Node lungsNode = new Node(5, 650, 450, "Lungs", 0, 90);
    Node stomachNode = new Node(6, 680, 500, "Stomach", 0, 30);
    Node liverNode = new Node(7, 800, 550, "Liver", 0, 60);
    Node kidneysNode = new Node(8, 600, 650, "Kidneys", 0, 60);
    Node intestinesNode = new Node(9, 728, 600, "Intestines", 0, 30);
    Node armNode = new Node(10, 850, 450, "Arm", 0, 30);
    Node legNode = new Node(11, 800, 700, "Leg", 0, 30);
    Node footNode = new Node(12, 800, 780, "Foot", 0, 20);
    Node handNode = new Node(13, 900, 550, "Hand", 0, 40);

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

    

    public MainMapScreen(ImmuneWars game) 
    {
        this.screen = this;
        System.out.println(" ");
        this.game = game;
        this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, cameraX, cameraY);
		
        viewport = new StretchViewport(cameraX, cameraY, camera);
		viewport.apply();

		stage = new Stage();
		stage.setViewport(viewport);

        nodes.add(brainNode);
        nodes.add(eyesNode);
        nodes.add(mouthNode);
        nodes.add(noseNode);
        nodes.add(hearthNode);
        nodes.add(lungsNode);
        nodes.add(stomachNode);
        nodes.add(liverNode);
        nodes.add(kidneysNode);
        nodes.add(intestinesNode);
        nodes.add(armNode);
        nodes.add(legNode);
        nodes.add(footNode);
        nodes.add(handNode);

        edges.add(brainEyesEdge);
        edges.add(brainMouthEdge);
        edges.add(brainNoseEdge);
        edges.add(brainHearthEdge);
        edges.add(hearthLungsEdge);
        edges.add(hearthStomachEdge);
        edges.add(mouthLungEdge);
        edges.add(mouthEyesEdge);
        edges.add(mouthNoseEdge);
        edges.add(stomachIntestinesEdge);
        edges.add(stomachLiverEdge);
        edges.add(stomachKidneysEdge);
        edges.add(intestinesLiverEdge);
        edges.add(intestinesKidneysEdge);
        edges.add(noseLungEdge);
        edges.add(mouthStomachEdge);
        edges.add(eyesHearthEdge);
        edges.add(eyesArmEdge);
        edges.add(armHanEdge);
        edges.add(hearthArmEdge);
        edges.add(kidneyLEdge);
        edges.add(legFootEdge);
        edges.add(intestinesLegEdge);

        stage = new Stage();
        shapeRenderer = new ShapeRenderer();

        paintMap();
        System.out.println("no sorun.");
        System.out.println("constructed.");
        
    }


    // method that paints this nodes and edges to the map 
    public void paintMap()
    {

        // paint background
        background = new Image(new Texture("mapBackground.png"));
        stage.addActor(background);
        // paint nodes
        NodeActor nodeActor;
        for (Node node : nodes) 
        {   
            try {
                nodeActor = new NodeActor(shapeRenderer, node);
                stage.addActor(nodeActor);
            } catch (Exception e) {
                System.out.println("retard");
                e.printStackTrace();
            }
        }
        System.out.println("nodes painted");
        for(Edge edge : edges)
        {
            EdgeActor edgeActor = new EdgeActor(shapeRenderer, edge);
            stage.addActor(edgeActor);
        }
        System.out.println("edged to calculus class");
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
    
}

