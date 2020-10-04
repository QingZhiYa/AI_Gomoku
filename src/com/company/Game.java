package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    int[][] board = new int[15][15];
    int score = 0;
    Node tree;
    HashMap<int[], Integer> scoreChart = new HashMap<>();


    Game(){
        //System.out.println(move);
        setUpChart();
        setUpBoard();
        tree = new Node();

    }


    private boolean setUpBoard(){
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                board[i][j] = 0;
            }
        }return true;
    }

    private boolean setUpChart(){
        scoreChart.put(new int[]{1, 1 , 0, 0, 0}, 5);
        scoreChart.put(new int[]{1, 1 , 1, 0, 0}, 10);
        scoreChart.put(new int[]{1, 1 , 1, 1, 0}, 20);
        scoreChart.put(new int[]{1, 1 , 1, 1, 1}, 10000); //win

        scoreChart.put(new int[]{1, 1 , 0, 1, 0}, 10);
        scoreChart.put(new int[]{1, 1 , 0, 0, 1}, 7);
        scoreChart.put(new int[]{1, 0 , 0, 0, 1}, 3);

        //...


        return true;
    }

    public boolean makeMove(){
        if(board == new int[15][15]){
            return firstMove();

        }else{
            //second move

            //move
            return minimax();
        }


        //return false;


    }

    public boolean updateBoard(File move){
        String content = readMove(move);
        String[] parse =  content.split(" ");
        if(parse.length == 3){
            board[Integer.parseInt(parse[2])][Integer.parseInt(parse[1])-64] = -1;

            return true;
        }else{
            System.out.println("move_file includes wrong format input.");
            return false;
        }
    }


    private String readMove(File move){
        try {
            Scanner myReader = new Scanner(move);
            String content = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                content += data;
            }
            myReader.close();
            return content;
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            return null;
        }
    }

    private boolean firstMove(){
        //put it in the center
        board[8][8] = 1;

        return true;
    }


    private int utilityFunc(int[] oneLine){
        int point = 0;
        for(int i = 0; i < 10; i ++){
            int[] five = Arrays.copyOfRange(oneLine, 0, 5);
            if(scoreChart.containsKey(five)){
                point+=scoreChart.get(five);
            }
        }return point;


    }

    private int evaluateFunc(){
        return 0;
    }

    private boolean minimax(){


        return true;
    }




}
