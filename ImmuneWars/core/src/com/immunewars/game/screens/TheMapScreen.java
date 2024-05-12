package com.immunewars.game.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.immunewars.game.ImmuneWars;
import com.immunewars.game.screens.MainMap.Edge.Edge;
import com.immunewars.game.screens.MainMap.Node.Node;

public class TheMapScreen implements Screen{

    ImmuneWars game;
    Stage stage;

    Node brainNode, eyesNode, mouthNode, noseNode, heartNode, lungsNode, stomachNode, liverNode, kidneysNode, intestinesNode, armNode, legNode, footNode, handNode;
        
    Edge brainEyesEdge, brainMouthEdge, brainNoseEdge, brainHearthEdge, heartLungsEdge, heartStomachEdge, mouthLungEdge,
    mouthEyesEdge, mouthNoseEdge, stomachIntestinesEdge, stomachLiverEdge, stomachKidneysEdge, intestinesLiverEdge, 
    intestinesKidneysEdge, noseLungEdge, mouthStomachEdge, eyesHeartEdge, eyesArmEdge, armHandEdge, heartArmEdge,
    kidneyLegEdge, legFootEdge, intestinesLegEdge;

    public TheMapScreen(ImmuneWars game){
        
        this.create();
        this.game = game;
        stage = new Stage();
        Image background = new Image(new Texture("mapBackground.png"));
        stage.addActor(background);
        ShapeRenderer shapeRenderer = new ShapeRenderer();
    }

    public void create(){

        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Edge> edges = new ArrayList<Edge>();
        brainEyesEdge = new Edge(brainNode, eyesNode);
        brainMouthEdge = new Edge(brainNode, mouthNode);
        brainNoseEdge = new Edge(brainNode, noseNode);
        brainHearthEdge = new Edge(brainNode, heartNode);
        heartLungsEdge = new Edge(heartNode, lungsNode);
        heartStomachEdge = new Edge(heartNode, stomachNode);
        mouthLungEdge = new Edge(mouthNode, lungsNode);
        mouthEyesEdge = new Edge(mouthNode, eyesNode);
        mouthNoseEdge = new Edge(mouthNode, noseNode);
        stomachIntestinesEdge = new Edge(stomachNode, intestinesNode);
        stomachLiverEdge = new Edge(stomachNode, liverNode);
        stomachKidneysEdge = new Edge(stomachNode, kidneysNode);
        intestinesLiverEdge = new Edge(intestinesNode, liverNode);
        intestinesKidneysEdge = new Edge(intestinesNode, kidneysNode);
        noseLungEdge = new Edge(noseNode, lungsNode);
        mouthStomachEdge = new Edge(mouthNode, stomachNode);
        eyesHeartEdge = new Edge(eyesNode, heartNode);
        eyesArmEdge = new Edge(eyesNode, armNode);
        armHandEdge = new Edge(armNode, handNode);
        heartArmEdge = new Edge(heartNode, armNode);
        kidneyLegEdge = new Edge(kidneysNode, legNode);
        legFootEdge = new Edge(legNode, footNode);
        intestinesLegEdge = new Edge(intestinesNode, legNode);

        brainNode = new Node(0,150 , 728, "Brain", 0, 70);
        eyesNode = new Node(1, 200, 650, "Eyes", 0, 20);
        mouthNode = new Node(2, 300, 728, "Mouth", 0, 40);
        noseNode = new Node(3, 250,728 , "Nose", 0, 30);
        heartNode = new Node(4, 600, 400, "Hearth", 0, 90);
        lungsNode = new Node(5, 650, 450, "Lungs", 0, 90);
        stomachNode = new Node(6, 680, 500, "Stomach", 0, 30);
        liverNode = new Node(7, 800, 550, "Liver", 0, 60);
        kidneysNode = new Node(8, 600, 650, "Kidneys", 0, 60);
        intestinesNode = new Node(9, 728, 600, "Intestines", 0, 30);
        armNode = new Node(10, 850, 450, "Arm", 0, 30);
        legNode = new Node(11, 800, 700, "Leg", 0, 30);
        footNode = new Node(12, 800, 780, "Foot", 0, 20);
        handNode = new Node(13, 900, 550, "Hand", 0, 40);
    
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
    
}
