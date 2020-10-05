package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    int[][] board = new int[15][15];
    int score = 0;
    Node tree;
    HashMap<int[], Integer> scoreChart = new HashMap<>();
    boolean firstMove = false;
    String teamName = "";


    Game(String name){
        //System.out.println(move);
        teamName = name;
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

    public boolean makeMove(File file){
        //move
        String move = minimax();
        return rewriteFile(file, move);



        //return false;


    }

    public boolean updateBoard(File move){
        String content = readMove(move);
        if(content == ""){
            firstMove = true;
            return true;
        }
        String[] parse =  content.split(" ");
        System.out.println(content);
        if(parse.length == 3 && Integer.parseInt(parse[2]) != -1){
            char c = Character.toUpperCase(parse[1].charAt(0));
            System.out.println(c);
            if(c-64-1 >= 15 || c-64-1 < 0 ||
                    Integer.parseInt(parse[2])-1 >=15 || Integer.parseInt(parse[2])-1 < 0){
                System.out.println("The move_file includes move range > 15 or < 1");
                return false;
            }
            board[Integer.parseInt(parse[2])-1][c-64-1] = -1;

            return true;
        }else{
            System.out.println("move_file includes wrong format input.");
            return false;
        }
    }


    private String readMove(File move){
        try {
            System.out.println(move);
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

    private String firstMove(){
        //put it in the center
        board[7][7] = 1;


        return teamName+" H 8";
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

    private boolean alpha_beta_pruning(){
        //To-Do
        return true;
    }

    private boolean secondMove(){
        //To-Do
        return true;
    }

    private int evaluateFunc(){
        //To-Do
        return 0;
    }



    private String minimax(){
        if(firstMove){
            return firstMove();
        }


        return "";
    }

    public boolean rewriteFile(File file, String content){
        try{
            FileOutputStream fooStream = new FileOutputStream(file, false);
            byte[] myBytes = content.getBytes();
            fooStream.write(myBytes);
            fooStream.close();
            return true;

        }catch (FileNotFoundException e){
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }


}
