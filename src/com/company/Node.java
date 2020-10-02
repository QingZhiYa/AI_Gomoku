package com.company;

import java.util.ArrayList;

public class Node {
    int[] move;
    ArrayList<Node> children;
    int score;

    public Node(){
        move = new int[2];
        children = new ArrayList<Node>();
        score = -1;
    }

    public Node addChild(Node child){
        children.add(child);
        return this;
    }

    public Node setScore(int s){
        score = s;
        return this;
    }

    public int getScore(){
        return score;
    }
}
